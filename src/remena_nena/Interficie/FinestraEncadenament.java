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
public class FinestraEncadenament {

    Controlador K;
    ArrayList<Etapa> forma;
    ArrayList<Etapa> iniciacio;
    ArrayList<Campanya> campanyes;
    Campanya c;
    Etapa e;
    String idCampanyaDisp;

    public FinestraEncadenament(Controlador k) {
        K = k;
        c = K.getCampanya();
        forma = c.getEtapasForma();
        e = c.obteEtapa();
        iniciacio = new ArrayList<>();
        campanyes = K.getCampanyes();
    }

    public String getNomCampanya() {
        return c.getnom();
    }

    public String getNomEtapa() {
        return e.getId();
    }
    
    public void setEtapa(String e) {
        for (Etapa etapa : forma) {
            if (etapa.getId().equals(e)) this.e = etapa;
        }
    }
    
    public void setCampanyaDisp(String c) {
        idCampanyaDisp = c;
    }
    
    public Controlador getControlador() {
        return K;
    }

    /* GET etapes de la mateixa campanya */
    public String[] getEtapes() {
        String[] etapes = new String[forma.size()];
        int i = 0;
        for (Etapa etapa : forma) {
            // excloem la propia etapa
            if (!etapa.getId().equals(e.getId())) {
                etapes[i] = etapa.getId();
                i++;
            }
        }
        return etapes;
    }
    
    public String[] getCampanyes() {
        String[] etapes = new String[campanyes.size()];
        int i = 0;
        for (Campanya camp : campanyes) {
            // excloem la propia campanya
            if (!camp.getnom().equals(c.getnom())) {
                etapes[i] = camp.getnom();
                i++;
            }
        }
        return etapes;
    }
    
    public String[] getEtapesAdded() {
        String[] etapes = new String[iniciacio.size()];
        int i = 0;
        for (Etapa etapa : iniciacio) {
            etapes[i] = etapa.getId();
            i++;
            
        }
        return etapes;
    }
    
    public void afegirDisp() {
        K.encadenarDisparador(idCampanyaDisp);
        K.fiAccio();
    }
    
    public void afegirSeq() {
        /**
         * DS iniciaccio[crearseq[encadenarsq]*fiseq]
         */
        K.crearSeq();
        iniciacio.forEach((etapa) -> {
            K.encadenarSequencia(c.getnom(), etapa.getId());
        });
        K.fiSequencia();
        K.fiAccio();
    }

    public void addEtapa(String m) {
        int i = 0;
        boolean trobat = false;
        while (i < forma.size() && trobat == false) {
            Etapa etapa = forma.get(i);
            if (etapa.getId().equals(m) && !iniciacio.contains(m)) {
                trobat = true;
                iniciacio.add(etapa);
            }
            i++;
        }
    }

    public void removeEtapa(String m) {
        int i = 0;
        boolean trobat = false;
        while (i < forma.size() && trobat == false) {
            Etapa etapa = forma.get(i);
            if (etapa.getId().equals(m)) {
                trobat = true;
                iniciacio.remove(etapa);
            }
            i++;
        }
    }
}
