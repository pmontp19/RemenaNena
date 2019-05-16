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
    private Meme m_actiu;
    private boolean finalitzat;

    public Controlador() {
        campanyes = new ArrayList<Campanya>();
        memes = new ArrayList<Meme>();
    }

    public Controlador(Dades d) {
        campanyes = d.obtenirCampanyes();
        memes = d.obtenirMemes();
    }
    
    public void setMemesIni(ArrayList<Meme> memes) {
        this.memes = memes;
    }

    public void novaInicial(String nomCampanya, String nomInicial) {
        c_activa = new Campanya(nomCampanya, nomInicial);
        campanyes.add(c_activa);
        c_activa.etapaActiva(nomInicial);
        finalitzat = false;
    }

    public void iniciAccio(String nomCampanya, String nomEtapa) {
        c_activa = getCampanya(nomCampanya);
        c_activa.iniciAccio(nomEtapa, c_activa);
    }

    public void crearSeq() {
        c_activa.crearSeq();
    }

    public void encadenarSequencia(String idCampanya, String idEtapaDesti) {
        Etapa eDesti = c_activa.getEtapa(idEtapaDesti);
        c_activa.encadenarSequencia(eDesti);
    }

    public void fiSequencia() {
        c_activa.fiSequencia();
    }

    public void encadenarDisparador(String idCampanya) {
        Campanya c = getCampanya(idCampanya);
        c_activa.encadenarDisparador(c);
    }
    
    public void encadenarFinalitzador() {
        c_activa.encadenarDisparador();
    }
    
    public void fiAccio() {
        c_activa.fiAccio();
        c_activa = null;
    }
    
    public void rebreClic(String idMeme){
        Meme m = getMeme(idMeme);
        m.rebreClic();
    }

    public void indicarMeme(String idMeme) {
        Meme m = getMeme(idMeme);
        if (m != null) {
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
  
    public void fiCampanya() {
        if (finalitzat = true) {
            c_activa.fiEtapa();
            c_activa = null;
        }
    }
    
    public void IniciarCampanya(String nomCampanya){
        Campanya c = getCampanya(nomCampanya);
        if(!c.getIniciada()){
            c.iniciarCampanya();
        }
    }
    
    public void FinalitzarCampanya(String nomCampanya){
        Campanya c = getCampanya(nomCampanya);
        if(c.getIniciada()){
            c.FinalitzarCampanya();
        }
    }
    
    public void fixarCondicioRelativa(String idCampanya, String idEtapa, int idAccio, String idMeme, int nombreClics) {
        /* PRE Campanya c existeix */
        Campanya c = getCampanya(idCampanya);
        Meme m = getMeme(idMeme);
        c.fixarCondicioRelativa(idEtapa, idAccio, m, nombreClics);
    }
    
   public void fixarCondicioAbsoluta(String idCampanya, int idAccio, String idEtapa, int nombreClics) {
       Campanya c = getCampanya(idCampanya);
       c.fixarCondicioAbsoluta(idAccio, idEtapa, nombreClics);
   }
   
   public void seleccionarCampanya(String idCampanya) {
       /**
        * existeix campanya
        * ass. inicial(campanya,etapa)
        * no c_activa
        */

       Campanya c = getCampanya(idCampanya);
       c_activa = c;
   }
   
   
   public void crearEtapa(String nomEtapa) {
       c_activa.crearEtapa(nomEtapa);
   }
   
    public void memeActiu(String idMeme) {
       Meme m = getMeme(idMeme);
       m_actiu = m;
   }
    
    public Meme returnActiu(){
        return m_actiu;
    }
   
   public void seleccionarMeme(String idMeme) {
       c_activa.seleccionarMeme(getMeme(idMeme));
   }
   
   public void fiSeleccionar() {
       c_activa.fiSeleccionar();
   }
   
   public void fiAfegir() {
       c_activa = null;
   }

    public ArrayList<Campanya> getCampanyes() {
        return campanyes;
    }

    public ArrayList<Meme> getMemes() {
        return memes;
    }

    // finds
    public Meme getMeme(String idMeme) {
        boolean trobat = false;
        int i = 0;
        Meme m = null;
        while (i < memes.size() && !trobat) {
            m = memes.get(i);
            if (m.getId() == idMeme) {
                trobat = true;
            }
            i++;
        }
        if (!trobat) {
            m = null;
        }
        return m;
    }
    
    public Campanya getCampanya() {
        return c_activa;
    }

    public Campanya getCampanya(String idCampanya) {
        boolean trobat = false;
        Campanya c = null;
        for (int i = 0; i < campanyes.size() && !trobat; i++) {
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
    
    public String getNomCampanyaActiva() {
        return c_activa.getnom();
    }

    // comprovacions
    public boolean comprovaCampanya(String nom) {
        Campanya c = getCampanya(nom);
        return c != null;
    }
    
    public boolean comprovaEtapa(String nom) {
        Etapa e = c_activa.getEtapa(nom);
        return e != null;
    }
}
