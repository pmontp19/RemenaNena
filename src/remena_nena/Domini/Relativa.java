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
public class Relativa extends Condicio {
    private final Meme enllaca; // pendent de saber si es objecte o id
    
    Relativa(Meme m, Accio idAccio, int nombreClics)
    {
        super(nombreClics, idAccio);
        this.enllaca = m;
    }
    public void rebreClic(){
        clics++;
        if(clics == clics_necessaris) {
            this.accioEcecutada();
        }
    }
}
