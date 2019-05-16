/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Meme {
    private String nom;
    private boolean lliure;
    private int clics;
    private Enregistrament total;
    private ArrayList<Enregistrament> llibertat;
    private ArrayList<Etapa> emes;
    private int Etapes_actives;
    
    public Meme(String idmeme){
        nom = idmeme;
        lliure = false;
        clics = 0;  
        Etapes_actives = 0;
        total = new Enregistrament();
        llibertat = new ArrayList<Enregistrament>();
        emes = new ArrayList<Etapa>();
    }
    
    public String getId(){
          return nom;
      }
    
    public void activarMemes(Etapa e){
        lliure = false;
        Etapes_actives++;
        emes.add(e);
        
    }
    public boolean getLlibertad(){
        return lliure;
    }
    
    public void FinalitzarEtapa(Etapa e){
        Etapes_actives--;
        boolean trobat = false;
        int i = 0;
        while(i<emes.size() && !trobat){
            Etapa et = emes.get(i);
            if(et.equals(e)){
                emes.remove(i);
                trobat = true;
            }
            else i++;
        }
        if(Etapes_actives == 0){
            lliure = true;
        }
    }
    
}
