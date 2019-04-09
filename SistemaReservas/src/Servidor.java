import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class Servidor 
    extends UnicastRemoteObject
    implements InterfazReservas
	 
    {
    Servidor() throws java.rmi.RemoteException{
	super();
    }
    public double ObtenerCotizacion(String fechacotizacion)
    {
        
        return 1;
    }
    
    
    @Override
    public double Cotizar(String incio, String fin, String fechacotizacion) throws RemoteException 
    {
        

     return 1;   
    }

    @Override
    public String Reservar(String incio, String fin, int idCliente, String fechacompra) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public static void main(String args[]) { 
	try {
	    Servidor calculadora;
	    LocateRegistry.createRegistry(1099);
	    calculadora=new Servidor(); 
	    Naming.bind("Calculadora", calculadora); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 
    
}


