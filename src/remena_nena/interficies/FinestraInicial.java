/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.interficies;
import java.util.ArrayList;
import remena_nena.domini.*;

/**
 *
 * @author victo
 */
public class FinestraInicial {
    ArrayList<Campanya> c;
    ArrayList<Meme> m;
    Controlador k;
    
    public FinestraInicial(Controlador k){
        k = k;
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
            me[i] = (m.get(i)).getMeme();
            i++;
        }
        return me;
    }
    
    public FinestraCampanya obtenirCampanyes(){
        return new FinestraCampanya(k);
    }
    
}
