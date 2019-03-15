package mayor3;

import java.io.*;
import java.net.*;

public class server {

    public static int mayor(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        }
        if (b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        int port = 5001; // puerto en el que escuchara el socket
        int a = 0, b = 0, c = 0;

        try 
        {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            Socket client;
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            while (true) {   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // aceptala conexion
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena;
                cadena = fromClient.readLine(); //cadena obtenida desde el lector
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver

                if (cadena.compareTo("Resultado") == 0) {
                    String devuelve = Integer.toString(mayor(a, b, c));
                    toClient.flush();
                    toClient.println(devuelve);
                }
                if (cadena.substring(1, 2).equals("-")) {
                    char variable = cadena.charAt(0);
                    int numero = Integer.parseInt(cadena.substring(2));
                    if (variable == 'a') {
                        a = numero;
                    }
                    if (variable == 'b') {
                        b = numero;
                    }
                    if (variable == 'c') {
                        c = numero;
                    }
                    toClient.flush();
                    toClient.println("Se ha recibido "+variable+" su valor: "+String.valueOf(numero));
                } else {
                    toClient.flush();
                    toClient.println("No se reconoce el comando");
                }
            }

        }
        catch(IOException e

    
        ){
            System.out.println(e.getMessage());
    }
}
}