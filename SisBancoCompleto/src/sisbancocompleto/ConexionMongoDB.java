package sisbancocompleto;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConexionMongoDB {
    private String host;
    private int puerto;
    private String database;

    public ConexionMongoDB(String database) {
         host="localhost";
         puerto=27017;
         this.database = database;
    }
        public MongoDatabase conectar() {
        
            MongoClient client = new MongoClient(host, puerto);
            MongoDatabase base = client.getDatabase(database);
 
        return base;
    }
}
