/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;

import java.util.ArrayList;

/**
 *
 * @author pere
 */
public class Finalitzador extends Accio {
    
    Finalitzador(Etapa e){
        super(e);
    }
    public void accioExecutada(){
        e.crearTancat();
    }
    
}
