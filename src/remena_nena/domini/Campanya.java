/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.domini;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Campanya {
    private String nom;
    private boolean iniciada;
    private ArrayList<Etapa> forma;
    private ArrayList<Etapa> iniciades;
    private Etapa inicial;
    private Etapa etapa_activa;
    
    public Campanya(String nomCampanya,String nomEtapa){
        nom = nomCampanya;
        iniciada = false;
        forma = new ArrayList<Etapa>();
        iniciades = new ArrayList<Etapa>();
        inicial = new Etapa(nomEtapa);
        forma.add(inicial);
    }
   public Etapa obteEtapa(){
       return etapa_activa;
   }
   public void fiEtapa(){
       etapa_activa = null;
   }
   public void etapaActiva(String idEtapa){
       int i = 0;
       boolean trobat = false;
       etapa_activa = null;
       while(i<forma.size() && !trobat){
           etapa_activa = forma.get(i);
           if(etapa_activa.getEtapa().equals(idEtapa)) trobat= true;
           i++;
       }
       if(!trobat) etapa_activa = null;
   }
   public String getnom(){
       return nom;
   }
      
}
