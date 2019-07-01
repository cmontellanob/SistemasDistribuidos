/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumirservicio;

/**
 *
 * @author Carlos
 */
public class ConsumirServicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a= obtenerCotizacion("asd");
        System.out.print(a);
    }

    private static Double obtenerCotizacion(java.lang.String fecha) {
        wsbanco.WsBanco_Service service = new wsbanco.WsBanco_Service();
        wsbanco.WsBanco port = service.getWsBancoPort();
        return port.obtenerCotizacion(fecha);
    }

   

    

   




    
}
