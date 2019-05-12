/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Interficie;
import remena_nena.Domini.Controlador;
import remena_nena.Domini.Etapa;
import java.util.ArrayList;
import remena_nena.Domini.Meme;

/**
 *
 * @author victo
 */
public class FinestraCampanya {
    String nomCampanya;
    String nomEtapa;
    ArrayList<Etapa> forma;
    ArrayList<Meme> memes;
    ArrayList<Meme> emes;
    Etapa inicial;
    Controlador K;
    
    
   public FinestraCampanya(Controlador k){
        K = k;
        nomCampanya = "";
        nomCampanya = new String();
        nomEtapa = "";
        nomEtapa = new String();
        forma = new ArrayList<Etapa>();
        memes = K.getMemes();
        emes = new ArrayList<Meme>();
    }
   
   public void setNomCampanya(String n) {
       nomCampanya = n;
   }
   
   public void setNomInicial(String n) {
       nomEtapa = n;
   }   
   public Controlador returnK() {
       return K;
   }  
   
    public String[] getMemes(){
        String[] m = new String[memes.size()];
        int i = 0;
        while(i < memes.size()){
            m[i] = (memes.get(i)).getId();
            i++;
        }
        return m;
    }

    public String[] getEmesos(){
        String[] m = new String[emes.size()];
        int i = 0;
        while(i < emes.size()){
            m[i] = (emes.get(i)).getId();
            i++;
        }
        return m;
    }

   
   public boolean afegir() {
       boolean bona = false;
       // no cal comprovar etapa
       if (!K.comprovaCampanya(nomCampanya)) {
           bona = true;
           K.novaInicial(nomCampanya, nomEtapa);
           for (int i = 0; i < emes.size(); i++) {
               K.indicarMeme(emes.get(i).getId());
           }
           // aixo va aqui? finalitza K si es bona
           K.fiCampanya();
       }
       return bona;
   }
   
    public void addMeme(String m){
        int i=0;
        boolean trobat = false;
        while( i < memes.size() && trobat == false ){
            Meme meme = memes.get(i);
            if(meme.getId().equals(m) && !emes.contains(meme)){
                trobat = true;
                emes.add(meme);
            }
            i++;
        }
    }

    public void removeMeme(String m){
        int i=0;
        boolean trobat = false;
        while( i < memes.size() && trobat == false ){
            Meme meme = memes.get(i);
            if(meme.getId().equals(m)){
                trobat = true;
                emes.remove(meme);
            }
            i++;
        }
    }

}
