/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisbancocompleto;


import io.jsonwebtoken.Claims;

/**
 *
 * @author carlos
 */
public class servicioscotesImpl extends servicioscotesPOA{

    @Override
    public String facturaspendientes(int numero,String llave) {
       // Claims a=Utiles.decodeJWT(llave);
       System.out.print(llave);
        return "2256-36,3216-26,4547-44";
    }

    @Override
    public String pagar(int idfactura,String llave) {
       // Claims a=Utiles.decodeJWT(llave);
        return "SI";
    }

}
