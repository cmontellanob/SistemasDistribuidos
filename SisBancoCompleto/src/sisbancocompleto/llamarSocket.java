/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbancocompleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class llamarSocket {
    
    private static String llamarElapas(String cadena) {
                int port = 5001; // puerto de comunicacion
        try{
            Socket client = new Socket("localhost", port); //conectarse al socket
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println(cadena);  //mandar alservidor 
            String result = fromServer.readLine();  // devolver del servidor
            return result;
                    }
        catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

   public static void main(String args[]){
       String pendientesElapas=llamarElapas("fac-"+String.valueOf(1)+"-sin llave");
       System.out.println(pendientesElapas);
        
   }
   

}
