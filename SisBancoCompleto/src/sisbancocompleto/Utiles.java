/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbancocompleto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Carlos
 */
public class  Utiles {
       private static String SECRET_KEY = "TrabajoFinalSIS258";  
       public static Claims decodeJWT(String jwt) {

        //esta puede lanzar ina excepcion si esta no firmada con no JWS 
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
 
}
