/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "wsDeudas")
public class wsDeudas {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerDeuda")
    public int getDeuda(@WebParam(name = "idcliente") int idcliente) {
        int deuda=0;
        switch (idcliente)
        {
            case 1:deuda=150;
                   break;
            case 2:deuda=245;
                   break;
            case 3:deuda=75;
                   break;
            case 4:deuda=1000;
                    break;
            case 5:deuda=50;
                    break;
       
        }
        return deuda;
    }
}
