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
    private final String enllaca; // pendent de saber si es objecte o id
    
    Relativa(String idMeme, Accio idAccio, int nombreClics)
    {
        super(nombreClics, idAccio);
        this.enllaca = idMeme;
    }
}
