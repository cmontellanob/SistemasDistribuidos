
import java.rmi.*;

public interface InterfazReservas extends Remote {
    double Cotizar(String incio,String fin,String fechacotizacion) throws RemoteException;
    String Reservar(String incio,String fin,int idCliente,String fechacompra) throws RemoteException;
    
}


