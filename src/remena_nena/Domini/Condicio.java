/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;

/**
 *
 * @author victo
 */
public class Condicio {
    protected static int comptador = 0;
    protected int id;
    protected int clics;
    protected int clics_necessaris;
    protected Accio compleix;
    
    
    Condicio() {
        id = comptador++;
        clics = 0;
    }
    
    Condicio(int nombreClics, Accio idAccio) {
        id = comptador++;
        clics = 0;
        clics_necessaris = nombreClics;
        compleix = idAccio;
    }
    
    protected void accioEcecutada(){
        compleix.accioExecutada();
    }
    
}
