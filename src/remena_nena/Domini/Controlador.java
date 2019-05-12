/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;
import java.util.ArrayList;
import remena_nena.Dades;

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
     
     public Controlador(Dades d){
         campanyes = d.obtenirCampanyes();
         memes = d.obtenirMemes();
     }
     
     public void novaInicial(String nomCampanya, String nomInicial){
         c_activa = new Campanya(nomCampanya,nomInicial); 
         campanyes.add(c_activa);
         c_activa.etapaActiva(nomInicial);
         finalitzat = false;
     }
     public void indicarMeme(String idMeme){
         Meme m = getMeme(idMeme);
         if( m != null){
             Etapa e = c_activa.obteEtapa();
             e.inserirMeme(m);
             finalitzat = true;
         }
     }
     
    public void indicarMemes(String[] m, String s){
         Etapa e = c_activa.obteEtapa();
         for (int i = 0; i<m.length;i++){
             Meme me = getMeme(s);
             if( me != null){
                 e.inserirMeme(me);
             }
         }
         finalitzat = true;
     }
     public void fiCampanya(){
         if(finalitzat = true){
             c_activa.fiEtapa();
             c_activa = null;
        }
     }
    
    public ArrayList<Campanya> getCampanyes(){
        return campanyes;
    }
    
    public ArrayList<Meme> getMemes(){
        return memes;
    }
     
     // finds
    public Meme getMeme(String idMeme){
        boolean trobat = false;
        int i = 0;
        Meme m = null;
        while(i < memes.size() && !trobat){
            m = memes.get(i);
            if(m.getId().equals(idMeme)) trobat = true;
            i++;
        }
        if(!trobat) m = null;
        return m;
    }
    
    public Campanya getCampanya(String idCampanya) {
        boolean trobat = false;
        Campanya c = null;
        for (int i = 0; i < campanyes.size() && !trobat; i++ ) {
            c = campanyes.get(i);
            if (c.getnom().equals(idCampanya)) {
                trobat = true;
            }
        }
        if (!trobat) {
            c = null;
        }
        return c;
    }
    
    // comprovacions
    
    public boolean comprovaCampanya(String nom) {
        Campanya c = getCampanya(nom);
        boolean trobat;
        if (c != null) {
            trobat = true;
        } else {
            trobat = false;
        }
        return trobat;
    }

    

}
