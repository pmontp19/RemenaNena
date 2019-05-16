/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Interficie;

import java.util.ArrayList;
import remena_nena.Domini.*;

/**
 *
 * @author pere
 */
public class FinestraAfegirEtapa {

    Controlador K;
    String nomEtapa;
    ArrayList<Meme> emes;
    ArrayList<Meme> memes;

    FinestraAfegirEtapa(Controlador k) {
        K = k;
        memes = K.getMemes();
        emes = new ArrayList<>();
    }
    
    public Controlador getK() {
        return K;
    }
    
    public String getCampanya() {
        return K.getNomCampanyaActiva();
    }

    public String[] getMemes() {
        String[] m = new String[memes.size()];
        int i = 0;
        while (i < memes.size()) {
            m[i] = (memes.get(i)).getId();
            i++;
        }
        return m;
    }

    public String[] getEmesos() {
        String[] m = new String[emes.size()];
        int i = 0;
        while (i < emes.size()) {
            m[i] = (emes.get(i)).getId();
            i++;
        }
        return m;
    }

    public void setNomEtapa(String nom) {
        nomEtapa = nom;
    }

    public boolean afegir() {
        // no existeix comprovem la pre
        boolean noExisteix = !K.comprovaEtapa(nomEtapa);
        if (noExisteix) {
            K.crearEtapa(nomEtapa);
            for (Meme m : emes) {
                K.seleccionarMeme(m.getId());
            }
            K.fiSeleccionar();
            K.fiAfegir();
        }
        return noExisteix;
    }

    public void addMeme(String m) {
        int i = 0;
        boolean trobat = false;
        while (i < memes.size() && trobat == false) {
            Meme meme = memes.get(i);
            if (meme.getId().equals(m) && !emes.contains(meme)) {
                trobat = true;
                emes.add(meme);
            }
            i++;
        }
    }

    public void removeMeme(String m) {
        int i = 0;
        boolean trobat = false;
        while (i < memes.size() && trobat == false) {
            Meme meme = memes.get(i);
            if (meme.getId().equals(m)) {
                trobat = true;
                emes.remove(meme);
            }
            i++;
        }
    }
}
