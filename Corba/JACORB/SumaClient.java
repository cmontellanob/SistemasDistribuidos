import sumaApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
public class SumaClient {
 static suma sumaImpl;
 public static void main(String args[]){
 try{
 ORB orb= ORB.init(args,null);
 org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
 NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
 
 String name="Suma";
 sumaImpl=sumaHelper.narrow(ncRef.resolve_str(name));
 //System.out.println("Obteniendo las cabeceras del objeto servidor: "+sumaImpl);
 System.out.println("suma es:"+Integer.toString(sumaImpl.sumar(20, 30)));
 sumaImpl.shutdown();
 }catch(Exception e){
 System.out.println("Error: "+e);
 e.printStackTrace(System.out);
 }
 }
 }