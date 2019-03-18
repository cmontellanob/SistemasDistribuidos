package Echo;


import java.io.*;
import java.net.*;

public class EchoClient {


    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    public static void main(String[] args) {
    EchoClient client=new EchoClient();
    client.startConnection("localhost", 4444);
    String resp1 = client.sendMessage("hello");
    String resp2 = client.sendMessage("world");
    String resp3 = client.sendMessage("!");
    String resp4 = client.sendMessage(".");
    System.err.println(resp1);
    System.err.println(resp2);
    System.err.println(resp3);
    System.err.println(resp4);
    

    client.stopConnection();
    }
    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }

    public String sendMessage(String msg) {
        try {
            out.println(msg);
            return in.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }
}
