package sisbancocompleto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    private String host;
    private int puerto;
    private String database;
    private String usuario;
    private String contrasena;

    public ConexionMySQL(String base) {
        this.host = "localhost";
        this.puerto = 3306;
        this.usuario = "root";
        this.contrasena = "";
        this.database = base;
    }

    
    public Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://" + host + ":" + puerto + "/" + database;
            System.out.print(url);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
