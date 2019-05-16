/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Interficie;
import remena_nena.Domini.*;

/**
 *
 * @author victo
 */
public class FinestraClic {
    Controlador K;
    Meme m;
    String idMeme = "";
    
    public FinestraClic(Controlador k){
        K = k;  
        m = k.returnActiu();
        idMeme = m.getId();
    }
    
    public Controlador getControlador(){
        return K;
    }
    public String IdMeme(){
        return idMeme;
    }
    public boolean getLlibertat(){
        return m.getLlibertad();
    }
    
    public Meme getMeme(){
        return m;
    }
}
