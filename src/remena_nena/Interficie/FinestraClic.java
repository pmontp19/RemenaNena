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
 * @author victo
 */
public class FinestraClic {
    Controlador K;
    Meme m;
    String idMeme = "";
    ArrayList<Enregistrament> llibertat;
    Enregistrament total;

    public FinestraClic(Controlador k){
        K = k;  
        m = k.returnActiu();
        idMeme = m.getId();
        llibertat = m.getEnregistraments();
        total = m.getEnregistramentTotal();
    }
    
    public Controlador getControlador(){
        return K;
    }
    public String IdMeme(){
        return idMeme;
    }
    public boolean getLlibertat(){
        return m.getLlibertad();
    }
    
    public Meme getMeme(){
        return m;
    }
    
    public Enregistrament getEnregistrament(String id) {
        for (Enregistrament enr : llibertat) {
            if (enr.getId().equals(id)) return enr;
        }
        return null;
    }
    
    public String[] getLlistaEnregistraments(){
        String[] enregistraments = new String[llibertat.size()];
        int i = 0;
        for (Enregistrament enr : llibertat) {
            enregistraments[i] = enr.getId();
            i++;
        }
        return enregistraments;
    }
    
    public int getTotalClicsEnr() {
        return total.getClics();
    }
}
