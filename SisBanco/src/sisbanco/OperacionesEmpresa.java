package sisbanco;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface OperacionesEmpresa extends Remote {
    public Factura[] calcular(int idcliente) throws RemoteException;
    public String Pagar(Factura[] facturas) throws RemoteException;
    
}
