package mayor3contiuo;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args){
        int port = 5001; // puerto de comunicacion
        try{
            Socket client = new Socket("localhost", port); //conectarse al socket
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String cadena="";
            while (!cadena.equals("salir"))
            {
            System.out.print("Introduzca una cadena : ");
            cadena = br.readLine();
            toServer.println(cadena);  //mandar alservidor 
            String result = fromServer.readLine();  // devolver del servidor
            System.out.println("cadena devuelta es: "+result);
            }
           

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
