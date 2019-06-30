/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbancocompleto;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public interface ICessa extends Remote {
    public Factura[] pedientes(int idcliente,String llave) throws RemoteException;
    public String pagar(Factura[] facturas,String llave) throws RemoteException;
    
}
