/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbancocompleto;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Carlos
 */
public class llamarCorba {
    
     public static void main(String args[]){
       try {
            String[] args2 = null;
            ORB orb = ORB.init(args2 ,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            servicioscotes servicioscotesImpl = servicioscotesHelper.narrow(ncRef.resolve_str("Cotes"));
            
            String response = servicioscotesImpl.facturaspendientes(1,"llave");
            System.out.print(response);
                      
                    
            } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
            }
          
     }
}
