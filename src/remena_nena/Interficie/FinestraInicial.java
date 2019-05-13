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
    
}
