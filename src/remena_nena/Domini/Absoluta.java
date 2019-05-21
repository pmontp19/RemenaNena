/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;

/**
 *
 * @author pere
 */
public class Absoluta extends Condicio {
    private final Etapa vinculada;   // vinculada<absoluta,etapa>
    
    Absoluta(Etapa e, Accio idAccio, int nombreClics) {
        super(nombreClics, idAccio);
        vinculada = e;
    }
    public void rebreClic(){
        clics++;
        if(clics == clics_necessaris){
            this.accioExecutada();
        }
    }
}
