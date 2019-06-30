/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsBanco;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "wsBanco")
public class wsBanco {

    /**
     * Servicio para obtenerlacotización por fecha
     */
    
    @WebMethod(operationName = "ObtenerCotizacion")
    public Double hello(@WebParam(name = "fecha") String txt) {
        return 6.96;
    }
}
