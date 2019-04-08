
import java.rmi.*;
import java.rmi.registry.*;

public class Cliente{
    public static void main(String args[]){
	InterfazOperaciones calculadora;
      int numero;
	try {
	    calculadora=(InterfazOperaciones)Naming.lookup("rmi://localhost/Calculadora");
            numero=5;
	    System.out.println();
	    System.out.println( "   "+numero+"! = "+calculadora.Factorial(numero));
	    System.out.println();
	}
	catch (Exception e){
	    e.printStackTrace();
	}
    }
}

