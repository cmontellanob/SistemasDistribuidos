/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Double hello(@WebParam(name = "fecha") String txtfecha) {
        //txtfecha=txtfecha.replace("-", "/");
        PreparedStatement pst = null;
        ResultSet rst = null;
        String sql = "select * from cotizaciones where fecha='"+txtfecha+"'";
        System.out.println(sql);
        String aux="";
        try {
        ConexionPostgres posgres=new ConexionPostgres("bd_banco");
        Connection conexion =posgres.conectar(); 
        pst = conexion.prepareStatement(sql);
        rst = pst.executeQuery();
        if (rst.next()){
            String precio = rst.getString("precio");
            return Double.parseDouble(precio);
                        
        }
        } catch (SQLException ex) {
            Logger.getLogger(wsBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 6.96;
    }
}
