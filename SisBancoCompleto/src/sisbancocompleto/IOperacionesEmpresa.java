package sisbancocompleto;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IOperacionesEmpresa extends Remote {
    public Factura[] calcular(int idcliente,String llave ) throws RemoteException;
    public String pagar(Factura[] facturas,String llave) throws RemoteException;
    
}
