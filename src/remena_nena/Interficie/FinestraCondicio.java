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
public class FinestraCondicio {

    ArrayList<Etapa> forma;
    ArrayList<Accio> lligam;
    Controlador k;
    String idCampanya;
    Etapa e_selec;
    Campanya c;
    int clicsCondicio;
    int idAccio;
    String idMeme;

    FinestraCondicio(Controlador k, String idCampanya) {
        this.k = k;
        this.idCampanya = idCampanya;
        this.c = k.getCampanya(idCampanya);
        forma = c.getEtapasForma();
        e_selec = null;
    }

    public void setEtapaActiva(String idEtapa) {
        for (Etapa etapa : forma) {
            if (etapa.getId().equals(idEtapa)) {
                e_selec = etapa;
            }
        }
    }
    
    public void setClicsCondicio(int c) {
        clicsCondicio = c;
    }
    
    public void setIdAccio(int a) {
        idAccio = a;
    }
    
    public void setIdMeme(String id) {
        idMeme = id;
    }

    public String[] getEtapes() {
        String[] etapes = new String[forma.size()];
        int i = 0;
        for (Etapa etapa : forma) {
            etapes[i] = etapa.getId();
            i++;
        }
        return etapes;
    }

    public String[] getAccions() {
        lligam = e_selec.getAccions();
        String[] accions = new String[lligam.size()];
        int i = 0;
        for (Accio accio : lligam) {
            accions[i] = String.valueOf(accio.getId());
            i++;
        }
        return accions;
    }

    public String[] getLlistaMemes() {
        ArrayList<Meme> m = e_selec.getEmesos();
        String[] es = new String[m.size()];
        int i = 0;
        while (i < m.size()) {
            es[i] = (m.get(i)).getId();
            i++;
        }
        return es;
    }
    
    public void acceptarRelativa() {
        k.fixarCondicioRelativa(idCampanya, e_selec.getId(), idAccio, idMeme, clicsCondicio);
    }
    
    public void acceptarAbsoluta() {
        k.fixarCondicioAbsoluta(idCampanya, idAccio, e_selec.getId(), clicsCondicio);
    }
    
        
    public Controlador getK() {
        return k;
    }
}
