
import java.rmi.*;

public interface InterfazCotizador extends Remote {
    double Cotizar(String fecha) throws RemoteException;
    
}
