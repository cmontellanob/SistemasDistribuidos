/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis258.edu.usuarios;


import io.jsonwebtoken.JwtBuilder;
import java.util.Date;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Carlos
 */

@RestController
public class LoginApi {

private static String SECRET_KEY = "TrabajoFinalSIS258";
   
    //@PostMapping("login")
@RequestMapping(value="/login", method=RequestMethod.POST)
public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password){
        // verificar por base de datos que es usuario autorizado
                PreparedStatement pst = null;
        ResultSet rst = null;
        String sql = "select * from usuarios where usuario='"+usuario+"' AND password='"+password+"'";
        System.out.println(sql);
        String aux="";
        String token="";
        try {
            ConexionMySQL mysql=new ConexionMySQL("bd_usuario");
            Connection conexion =mysql.conectar(); 
            pst = conexion.prepareStatement(sql);
            rst = pst.executeQuery();
            if (rst.next()){
                String id = rst.getString("id");
                String correo = rst.getString("correo");
                token =createJWT(id,"yes",correo,-1);      
            }
            else
                token="Datos Invalidos";
        } catch (SQLException ex) {
            Logger.getLogger(LoginApi.class.getName()).log(Level.SEVERE, null, ex);
        }

         
        return token;
    }


    public String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //El algoritmoefirma el  JWT  nosotros podriamo esta usando un token firmado
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //Nosotros podemos firmar nuestro JWT con nuestro nuestra secretar ApiKey 
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //POngamos los afirmaciones JWT 
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //si esto se va especificar, se añadira la expiracion 
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Construir el JWT y serializarlo a compacto ,UR-seguro compacto 
        return builder.compact();
    }
}
