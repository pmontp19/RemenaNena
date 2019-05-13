/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Interficie;
import remena_nena.Domini.*;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class FinestraSeleccionarCampanya {
    Controlador K;
    Campanya c;
    ArrayList<Etapa> e;
    boolean activa;
    ArrayList<Meme> m;
    
    public FinestraSeleccionarCampanya(Controlador k, String s){
        K = k;  
        c = getCampanya(K,s);
        e = c.getEtapasForma();
        activa = c.getIniciada();
    }
    public Campanya getCampanya(Controlador k, String s){
        Campanya c = null;
        boolean trobat = false;
        int i = 0;
        ArrayList<Campanya> ca = k.getCampanyes();
        while(i<ca.size() && !trobat){
            c = ca.get(i);
            if (c.getnom().equals(s)) trobat = true;
            else i++;
        }
        return c;
    }
    public Controlador getControlador(){
        return K;
    }
    public String[] getLlistaEtapes(){
        String[] et = new String[e.size()];
        int i = 0;
        while(i<e.size()){
            et[i] = (e.get(i)).getId();
            i++;
        }
        return et;
    }
    
    public boolean getIniciada(){
        return activa;
    }
    public String[] getLlistaMemes(String s){
        Etapa et = c.getEtapa(s);
        ArrayList<Meme> m = et.getEmesos();
        String[] es = new String[m.size()];
        int i = 0;
        while(i < m.size()){
            es[i] = (m.get(i)).getId();
            i++;
        }
        return es;
    }
    
}
