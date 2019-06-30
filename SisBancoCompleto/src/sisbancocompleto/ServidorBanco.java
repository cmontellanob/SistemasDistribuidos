package sisbancocompleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;




public class ServidorBanco 
    extends UnicastRemoteObject
    implements IOperacionesEmpresa
	 
{

    ServidorBanco() throws java.rmi.RemoteException{
	super();
    }
    
   
    public Factura[] calcular(int idcliente,String llave) throws RemoteException {
       // Claims a=Utiles.decodeJWT(llave);
        System.out.print(llave);
        ICessa cessa;
        try {
        cessa=(ICessa)Naming.lookup("rmi://localhost/Cessa");
        Factura[] FacturasPendientesCessa=cessa.pedientes(idcliente,llave);
        String [] pendientesElapas=llamarElapas("fac-"+String.valueOf(idcliente)+"-"+llave).split(",");
        Factura[] FacturasPendientesElapas=new Factura[pendientesElapas.length];
        String [] pendientesCotes=llamarCotes(idcliente,llave).split(",");
        Factura[] FacturasPendientesCotes=new Factura[pendientesCotes.length];
        Factura[] FacturasPendientes = new Factura[ FacturasPendientesCessa.length + pendientesElapas.length+ pendientesCotes.length ];
        
        
        
        int i=0;
        for (String f:pendientesElapas )
        {
            String[] factu=f.split("-");
            int IdFactura=Integer.parseInt(factu[0]);
            double monto=Integer.parseInt(factu[1]);
            FacturasPendientesElapas[i]=new Factura("Elapas",IdFactura,monto);
            i++;
        }
         int j=0;
        for (String f:pendientesCotes )
        {
            String[] factu=f.split("-");
            int IdFactura=Integer.parseInt(factu[0]);
            double monto=Integer.parseInt(factu[1]);
            FacturasPendientesCotes[j]=new Factura("Cotes",IdFactura,monto);
            j++;
        }
        
        System.arraycopy( FacturasPendientesCessa, 0, FacturasPendientes, 0, FacturasPendientesCessa.length );
        System.arraycopy( FacturasPendientesElapas, 0, FacturasPendientes, FacturasPendientesCessa.length, FacturasPendientesElapas.length );
        System.arraycopy( FacturasPendientesCotes, 0, FacturasPendientes,FacturasPendientesCessa.length + FacturasPendientesElapas.length, FacturasPendientesCotes.length);

        return FacturasPendientes; 
        }
        catch (Exception e){
	    e.printStackTrace();
	return null;
        }
    }    
    public String pagar(Factura[] facturas,String llave) throws RemoteException {
          ICessa cessa;
        try 
        {
        cessa=(ICessa)Naming.lookup("rmi://localhost/Cessa");  
        int contarCessa=0;
        String  facturasElapas="";
        String empresa="";
        for (Factura f:facturas)
        {
            empresa=f.getEmpresa();
            if (empresa.equals("Cessa"))
            {
                contarCessa++;
            }
            if (empresa.equals("Elapas"))
            {
                facturasElapas+=String.valueOf(f.getIdFactura())+",";
            }
            
        }
        facturasElapas=facturasElapas.substring(0, facturasElapas.length()-2);
        
        Factura[] FacturasCessa=new Factura[contarCessa]; 
        
        int iCessa=0;
        for (Factura f:facturas)
        {
            if (f.getEmpresa().equals("Cessa"))
            {
                FacturasCessa[iCessa]=f;
                iCessa++;
            }
        }
        return cessa.pagar(FacturasCessa,llave)+llamarElapas("pag-"+facturasElapas);
        }
        catch (Exception e){
	    e.printStackTrace();
	return null;
        }
        
    }
    
    
    
    public static void main(String args[]) { 
	try {
	    ServidorBanco Banco;
	    //LocateRegistry.createRegistry(1099);
	    Banco=new ServidorBanco(); 
	    Naming.bind("Operaciones", Banco); 
            System.out.println("El servidor Banco esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 

    private String llamarElapas(String cadena) {
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
    

private String llamarCotes(int id_cliente,String llave){
        try {
            String[] args = null;
            ORB orb = ORB.init(args ,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            servicioscotes servicioscotesImpl = servicioscotesHelper.narrow(ncRef.resolve_str("Cotes"));

            String response = servicioscotesImpl.facturaspendientes(id_cliente,llave);
            return response;

                    
            } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
            }
                //return "2200-30,3200-25,4540-48";
                return null;
    }

    
}


