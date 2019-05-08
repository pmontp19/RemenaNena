/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.domini;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Controlador {
     private ArrayList<Campanya> campanyes;
     private ArrayList<Meme> memes;
     private Campanya c_activa;
     private boolean finalitzat;
     
     public Controlador(){
         campanyes = new ArrayList<Campanya>();
         memes = new ArrayList<Meme>();
     }    
     public void novaInicial(String nomCampanya, String nomInicial){
         c_activa = new Campanya(nomCampanya,nomInicial);   
         finalitzat = false;
     }
     public void indicarMeme(String idMeme){
         Meme m = getMeme(idMeme);
         
     }
    
     
     //finds
    public Meme getMeme(String idMeme){
        boolean trobat = false;
        int i = 0;
        Meme m = null;
        while(i < memes.size() && !trobat){
            m = memes.get(i);
            if(m.getMeme().equals(idMeme)) trobat = true;
            i++;
        }
        if(!trobat) m = null;
        return m;
    }
}
