package sisbancocompleto;

import io.jsonwebtoken.Claims;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorElapas {
    
    public static void main(String[] args) {
        int port = 5001; // puerto en el que escuchara el socket
        String Respuesta="";
        try 
        {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            System.out.println("El servidor Elapas esta listo\n");
            Socket client;
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            while (true) {   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // aceptala conexion
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena;
                cadena = fromClient.readLine(); //cadena obtenida desde el lector
                String[] separado=cadena.split("-");
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println("Comando Recibido"+cadena);
                if (separado.length==3) {
                     
                    String llave=separado[2];
                    //Claims a=Utiles.decodeJWT(llave);
                    System.out.print(llave);
                    String  comando = separado[0];
                    
                    if (comando.equals("fac")) {
                        Integer idcliente  = Integer.parseInt(separado[1]);
                        PreparedStatement pst = null;
                        ResultSet rst = null;
                        String sql = "select * from facturas where estado='E' AND idcliente="+idcliente;
                        System.out.println(sql);
                        String aux="";
                        try {
                        ConexionPostgres posgres=new ConexionPostgres("bd_elapas");
                        Connection conexion =posgres.conectar(); 
                        pst = conexion.prepareStatement(sql);
                        rst = pst.executeQuery();
                        while(rst.next()){
                        String nrofactura = rst.getString("nrofactura");
                        String monto = rst.getString("monto");
                        aux+=nrofactura+"-"+monto+",";
                        }
                        } catch (SQLException ex) {
                        Logger.getLogger(ServidorElapas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        aux=aux.substring(0, aux.length()-1);
                        Respuesta=aux;    
                        
                        }
                    if (comando.equals("pag")) {
                            Respuesta="SI";
                    }
                    
                    toClient.flush();
                    toClient.println(Respuesta);
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
