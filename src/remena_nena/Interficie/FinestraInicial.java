/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Interficie;
import remena_nena.Domini.Campanya;
import remena_nena.Domini.Controlador;
import remena_nena.Domini.Meme;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class FinestraInicial {
    ArrayList<Campanya> c;
    ArrayList<Meme> m;
    Controlador k;
    
    public FinestraInicial(Controlador k){
        this.k = k;
        c = k.getCampanyes();
        m = k.getMemes();
    }
    
    public Campanya getCampanya(String s){
        Campanya retornada = k.getCampanya(s);
        return retornada;
    }
    
    public String[] getCampanyes(){
        String[] camp = new String[c.size()];
        int i = 0;
        while(i<c.size()){
            camp[i] = (c.get(i)).getnom();
            i++;
        }
        return camp;
    }
    
    
    public String[] getMemes(){
        String[] me = new String[m.size()];
        int i = 0;
        while(i<m.size()){
            me[i] = (m.get(i)).getId();
            i++;
        }
        return me;
    }
    
    public FinestraCampanya obtenirCampanyes(){
        return new FinestraCampanya(k);
    }
    public FinestraSeleccionarCampanya controladorSel(String s){
        return new FinestraSeleccionarCampanya(k,s);
    }
    
    public FinestraAfegirEtapa afegirEtapa(String campanya) {
        k.seleccionarCampanya(campanya);
        return new FinestraAfegirEtapa(k);
    }
    
    public FinestraSelecEncadenament afegirEncadenament(String idCampanya) {
        return new FinestraSelecEncadenament(k, idCampanya);
    }
    
    public Controlador getControlador(){
        return k;
    }
    
    public FinestraClic controladorClics(String s){
        k.memeActiu(s);
        return new FinestraClic(k);
    }
    
    public FinestraCondicio afegirCondicio(String idCampanya) {
        return new FinestraCondicio(k, idCampanya);
    }
    
}
