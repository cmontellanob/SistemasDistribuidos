/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis258.edu.cotizaciones;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import java.util.Date;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Carlos
 */

@RestController
public class CotizacionApi {

private static String SECRET_KEY = "2doparcial";
   
@RequestMapping(value="/cotizaciones", method=RequestMethod.POST)
public String insertarCotizacion(@RequestHeader("authorization") String token,@RequestParam("fecha") String txtfecha,@RequestParam("cotizacion") String txtcotizacion) throws ClassNotFoundException, SQLException{
if (token.length()<8)
        return "error en el token";
    else 
        token=token.substring(7);
        
        
        Claims d= decodeJWT(token);
        String sql="insert into cotizaciones (fecha,cotizacion) values ('"+txtfecha+"',"+txtcotizacion+")";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Connection conexion =conectar(); 
        pst = conexion.prepareStatement(sql);
        pst.executeUpdate();
        
        return "se inserto con exito";
        
        }

@RequestMapping(value="/cotizaciones/{fecha}", method=RequestMethod.PUT)
public String editarCotizacion(@RequestHeader("authorization") String token,@PathVariable String txtfecha,@RequestParam("cotiacion") String txtcotizacion){
if (token.length()<8)
        return "error en el token";
    else 
        token=token.substring(7);
        try
        {
            Claims d= decodeJWT(token);
        String sql="update cotiaciones set cotizacion='"+txtcotizacion+"' where fecha='"+txtfecha+"'";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Connection conexion =conectar(); 
        pst = conexion.prepareStatement(sql);
        pst.executeUpdate();
        
        return "se inserto con exito";
        
        }
        catch(Exception e)  
                {
                  System.out.print(e.getMessage());
                 return "No autorizado";         
                }
        
        }

@RequestMapping(value="/cotizaciones/{fecha}", method=RequestMethod.DELETE)
public String eliminarCotizacion(@RequestHeader("authorization") String token,@PathVariable String txtfecha){
if (token.length()<8)
        return "error en el token";
    else 
        token=token.substring(7);
        try
        {
            Claims d= decodeJWT(token);
            String sql="delete cotiaciones  where fecha='"+txtfecha+"'";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Connection conexion =conectar(); 
        pst = conexion.prepareStatement(sql);
        pst.executeUpdate();
        
        return "se elimino con exito";
        
        
        }
        catch(Exception e)  
                {
                  System.out.print(e.getMessage());
                 return "No se pudo eliminar";         
                }
        
        }


@RequestMapping(value="/cotizaciones/{fecha}", method=RequestMethod.GET)
public String obtenerCotizacion(@PathVariable String fecha) throws ClassNotFoundException, SQLException, Exception{
        String sql="select fecha,cotizacion from cotizaciones where fecha='"+fecha+"'";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Connection conexion =conectar(); 
        pst = conexion.prepareStatement(sql);
        rst = pst.executeQuery();
        JSONArray json= convertToJSON(rst);
        return json.toString();
    }

@RequestMapping(value="/cotizaciones", method=RequestMethod.GET)
public String obtenerCotizaciones() throws ClassNotFoundException, SQLException, Exception{
        String sql="select fecha,cotizacion from cotizaciones";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Connection conexion =conectar(); 
        pst = conexion.prepareStatement(sql);
        rst = pst.executeQuery();
        JSONArray json= convertToJSON(rst);
        return json.toString();
    }





    
       public static Claims decodeJWT(String jwt) {
        //esta puede lanzar ina excepcion si esta no firmada con no JWS 
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
          public Connection conectar() throws ClassNotFoundException, SQLException {
            Connection conn = null;
            String url = "jdbc:mysql://localhost:3306/bd_cotizaciones?serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
           return conn;
    }
    public JSONArray convertToJSON(ResultSet resultSet)
            throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            for (int i = 0; i < total_rows; i++) {
                JSONObject obj = new JSONObject();
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1)
                        .toLowerCase(), resultSet.getObject(i + 1));
                jsonArray.put(obj);
            }
        }
        return jsonArray;
    }

}       
       
