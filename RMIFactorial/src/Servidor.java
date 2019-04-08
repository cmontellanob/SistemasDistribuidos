import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class Servidor 
    extends UnicastRemoteObject
    implements InterfazOperaciones
	 
{
    Servidor() throws java.rmi.RemoteException{
	super();
    }
    
    public long Factorial(long a) {
	if (a==0 || a==1) {
	    return 1;
	} else {
	    return a*Factorial(a-1);
	}
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


