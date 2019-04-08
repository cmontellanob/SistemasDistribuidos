
import java.rmi.*;

public interface InterfazOperaciones extends Remote {
    long Factorial(long arg) throws RemoteException; 
}


