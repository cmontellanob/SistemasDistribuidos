/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbancocompleto;


import io.jsonwebtoken.Claims;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class servicioscotesImpl extends servicioscotesPOA{

    @Override
    public String facturaspendientes(int numero,String llave) {
       // Claims a=Utiles.decodeJWT(llave);
        System.out.print(llave);
        PreparedStatement pst = null;
        ResultSet rst = null;
        String sql = "select * from facturas where estado='E' AND idcliente="+numero;
        System.out.println(sql);
        String aux="";
        try {
            ConexionMySQL mysql=new ConexionMySQL("bd_cotes");
            Connection conexion =mysql.conectar(); 
            pst = conexion.prepareStatement(sql);
            rst = pst.executeQuery();
                while(rst.next()){
                String nrofactura = rst.getString("nrofactura");
                String monto = rst.getString("monto");
                aux+=nrofactura+"-"+monto+",";
            }
                aux=aux.substring(0, aux.length()-1);
        } catch (SQLException ex) {
            Logger.getLogger(servicioscotesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

    @Override
    public String pagar(int idfactura,String llave) {
       // Claims a=Utiles.decodeJWT(llave);
         PreparedStatement pst = null;
        ResultSet rst = null;
        String sql = "update facturas set estado='P' where id="+idfactura;
        String aux="";
        try {
            ConexionMySQL mysql=new ConexionMySQL("bd_cotes");
            Connection conexion =mysql.conectar(); 
            pst = conexion.prepareStatement(sql);
            rst = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(servicioscotesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "SI";
    }

}
