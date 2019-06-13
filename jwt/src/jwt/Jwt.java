package jwt;

import io.jsonwebtoken.Claims;
import jwt.JWTDemo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Jwt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String p=JWTDemo.createJWT("id", "yes", "prueba", -1);
        System.out.println(p);
        Claims a=JWTDemo.decodeJWT(p);
        System.out.print(a.toString());
        
    }
    
}
