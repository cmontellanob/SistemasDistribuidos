package sisbancocompleto;


import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import io.jsonwebtoken.Claims;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;


public class ServidorCessa 
    extends UnicastRemoteObject
    implements ICessa
	 
{
    ServidorCessa() throws java.rmi.RemoteException{
	super();
    }
    
    public Factura[] pedientes(int idcliente,String llave) throws RemoteException {
       // Claims a=Utiles.decodeJWT(llave);
       System.out.print(llave);
       ConexionMongoDB mongo=new ConexionMongoDB("bd_cessa");
       MongoDatabase m=mongo.conectar();
       //new Document("idcliente", idcliente)
       BasicDBObject criteria = new BasicDBObject();
       criteria.append("idcliente", idcliente);
       criteria.append("estado", "E");
        FindIterable<Document> iterable = m.getCollection("facturas").find(criteria);
       List<Factura> listafacturas=new ArrayList<Factura>();
       //FindIterable<Document> iterable = 
       iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                List list = new ArrayList(document.values());
                int nrofactura=Integer.parseInt(list.get(1).toString());
                double monto=Double.parseDouble(list.get(3).toString());
                Factura f=new Factura("Cessa",nrofactura,monto);
                listafacturas.add(f);
            }
        });
       Factura[] aux = new Factura[listafacturas.size()];
       aux = listafacturas.toArray(aux);
       return aux;
    }


        public String pagar(Factura[] facturas,String llave) throws RemoteException {
            return "SI";
    }    
    
    
    
    public static void main(String args[]) { 
	try {
	    ServidorCessa cessa;
	    LocateRegistry.createRegistry(1099);
	    cessa=new ServidorCessa(); 
	    Naming.bind("Cessa", cessa); 
            System.out.println("El servidor Cessa esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 

   
}


