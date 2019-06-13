package JuegoTresEnRaya;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTresEnRaya {
   
    
    
    
    public static void main(String args[]) { 
    {
        int port =5001; // puerto en el que escuchara el socket
        TresEnRaya juego=new TresEnRaya(1);
        try {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            Socket client;      
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            while(true){   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // aceptala conexion
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                int x =Integer.parseInt(fromClient.readLine()) ; //cadena obtenida desde el lector
                int y =Integer.parseInt(fromClient.readLine()) ; //cadena obtenida desde el lector
                int jugador =Integer.parseInt(fromClient.readLine()) ; //cadena obtenida desde el lector
                System.out.println(x+","+y+"-"+jugador);
                String Respuesta=juego.jugada(x, y, jugador);//int jugador=Integer.parseInt(juador);
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                toClient.println(Respuesta);
                toClient.flush(); // 
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }   
}
}
        
    

