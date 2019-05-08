/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.domini;

/**
 *
 * @author victo
 */
public class Condicio {
    private String id;
    private int clics;
    private int clics_necessaris;
    
    public Condicio(String idCondicio, int nombreClics){
        id = idCondicio;
        clics = 0;
        clics_necessaris = nombreClics;
    }
    
}
