package JuegoTresEnRaya;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTresEnRaya {
    
     Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner


     public static void main(String[] args){
        int port = 5001; // puerto de comunicacion
      
        try{
            
            Socket client = new Socket("localhost", port); //conectarse al socket
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.print("Marque la casilla: ");
            System.out.print("Introduzca x ");
            String x =br.readLine();
            System.out.print("Introduzca y ");
            String y = br.readLine();
            System.out.print("Introduzca jugador ");
            String  jugador = br.readLine();
            toServer.println(x);
            toServer.println(y);
            toServer.println(jugador);  
            
            String result = fromServer.readLine();  // devolver del servidor
            System.out.println("cadena devuelta es: "+result);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    
}
