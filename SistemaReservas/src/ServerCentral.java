import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class ServerCentral
extends UnicastRemoteObject
    implements InterfazCotizador
{
    ServerCentral() throws java.rmi.RemoteException{
	super();
    }

    @Override
    public double Cotizar(String fecha) throws RemoteException {
        if (fecha.equals("26-06-19"))
                {
                    return 6.9;
                }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
