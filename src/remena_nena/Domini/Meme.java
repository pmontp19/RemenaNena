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
    private ArrayList<Etapa> actives;
    private ArrayList<Relativa> enllaca;
    private int Etapes_actives;
    
    public Meme(String idmeme){
        nom = idmeme;
        lliure = false;
        clics = 0;  
        Etapes_actives = 0;
        total = new Enregistrament();
        llibertat = new ArrayList<Enregistrament>();
        actives = new ArrayList<Etapa>();
        enllaca = new ArrayList<Relativa>();
    }
    
    
    public String getId(){
          return nom;
      }
    
    public void activarMemes(Etapa e){
        lliure = false;
        Etapes_actives++;
        actives.add(e);
        
    }
    public boolean getLlibertad(){
        return lliure;
    }
    
    public void FinalitzarEtapa(Etapa e){
        Etapes_actives--;
        boolean trobat = false;
        int i = 0;
        while(i<actives.size() && !trobat){
            Etapa et = actives.get(i);
            if(et.equals(e)){
                actives.remove(i);
                trobat = true;
            }
            else i++;
        }
        if(Etapes_actives == 0){
            lliure = true;
        }
    }
    
    public void rebreClic(){
        clics++;
        if(lliure){
            total.rebreClic();
        }
        for(int i = 0; i<enllaca.size(); i++){
            Relativa r = enllaca.get(i);
            r.rebreClic();
        }
    }
    
    public void fixarCondicioRelativa(Relativa r) {
        enllaca.add(r);
    }
    
}
