package impuestos;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Scanner;

/**
 * noovidar ejecutar orbd
 * 
 * @author Carlos
 */
public class Impuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("introduzca el id cliente");
        Scanner reader = new Scanner(System.in);
        int idcliente;
        idcliente = reader.nextInt();
        //web service
        int deuda=obtenerDeuda(idcliente);
        
        //corba
        serviciosimpuestos impuestosImpl;

        try{
        ORB orb= ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
        impuestosImpl=serviciosimpuestosHelper.narrow(ncRef.resolve_str("ServicioImpuestos"));
        String impuesto=impuestosImpl.calcularimpuesto(deuda);
        System.out.println("El monto adeudado es :"+deuda);
        System.out.println("Aplica el impuesto de :"+impuesto);
        double pagar=deuda*Double.parseDouble(impuesto);
        System.out.println("El impuesto a pagar es :"+Double.toString(pagar));
        }catch(Exception e){
        System.out.println("Error: "+e);
        e.printStackTrace(System.out);
        }
 }

    private static int obtenerDeuda(int idcliente) {
        servicios.WsDeudas_Service service = new servicios.WsDeudas_Service();
        servicios.WsDeudas port = service.getWsDeudasPort();
        return port.obtenerDeuda(idcliente);
    }
 }
        
    
    

