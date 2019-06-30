/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis258.edu.usuarios;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos
 */

@RestController
public class HolaMundoControler {
@RequestMapping({ "/hola" })
public String PrimeraPagina() {
return "Hola Mundo";
}
}

