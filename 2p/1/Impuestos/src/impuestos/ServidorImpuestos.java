package impuestos;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

/**
 *
 * @author Carlos
 */
class serviciosimpuestosImpl extends serviciosimpuestosPOA{
 private ORB orb;
 public void setORB(ORB orb_val){
 orb=orb_val;
 }
 public String calcularimpuesto(int importe){
     double calculo=0;
     if (importe<50)
         calculo=.03;
     if (importe>=50 && importe<200)
         calculo=.05;
     if (importe>=200 && importe<800 )
         calculo=.07;
     if (importe>=200)
         calculo=.1;
     
 return Double.toString(calculo);
 }
}
public class ServidorImpuestos {
 
 public static void main(String args[]){
 try{
 ORB orb= ORB.init(args,null);
 POA rootpoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
 rootpoa.the_POAManager().activate();
 
 serviciosimpuestosImpl impuestosImpl=new serviciosimpuestosImpl();
 impuestosImpl.setORB(orb);
 
 org.omg.CORBA.Object ref=rootpoa.servant_to_reference(impuestosImpl);
 serviciosimpuestos href=serviciosimpuestosHelper.narrow(ref);
 org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
 NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);

 NameComponent path[]=ncRef.to_name("ServicioImpuestos");
 ncRef.rebind(path, href);
 System.out.println("Servidor de suma listo y en espera");
 orb.run();
 }catch(Exception e){
 System.err.println("Error: "+e);
 e.printStackTrace(System.out);
 }
 
 System.out.println("Adios cerrando servidor");
 }
}    

