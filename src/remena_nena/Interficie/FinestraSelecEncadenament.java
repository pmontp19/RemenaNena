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
public class FinestraSelecEncadenament {

    Controlador k;
    ArrayList<Etapa> forma;
    String idCampanya;
    String idEtapa;

    public FinestraSelecEncadenament(Controlador k, String idCampanya) {
        this.k = k;
        this.idCampanya = idCampanya;
        Campanya c = k.getCampanya(idCampanya);
        forma = c.getEtapasForma();
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
    
    public String getNomCampanya() {
        return idCampanya;
    }
    
    public Controlador getControlador() {
        return this.k;
    }
    
    public void setNomEtapa(String nom) {
        idEtapa = nom;
    }
    
    public void dacord() {
        k.iniciAccio(idCampanya, idEtapa);
    }
    
    public void finalitzador() {
        k.iniciAccio(idCampanya, idEtapa);
        k.encadenarFinalitzador();
        k.fiAccio();
    }
}
