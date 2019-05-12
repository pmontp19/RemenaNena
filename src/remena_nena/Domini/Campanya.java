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
           if(etapa_activa.getId().equals(idEtapa)) trobat= true;
           i++;
       }
       if(!trobat) etapa_activa = null;
   }
   
   public String getnom(){
       return nom;
   }
   
   public void iniciAccio(String nomEtapa, Campanya c) {
       etapaActiva(nomEtapa);
   }
   
   public void fiAccio() {
       etapa_activa = null;
   }
   
   public void crearSeq() {
       etapa_activa.crearSeq();
   }
   
   public void encadenarSequencia(Etapa eDesti) {
       etapa_activa.encadenarSequencia(eDesti);
   }
   
   public void fiSequencia() {
       etapa_activa.fiSequencia();
   }

   public void encadenarDisparador(Campanya c) {
       etapa_activa.encadenarDisparador(c);
   }
   
   public void encadenarDisparador() {
       etapa_activa.encadenarFinalitzador();
   }
   
   // finds
   
   public Etapa getEtapa(String idEtapa) {
       for (Etapa etapa : forma) {
           if (etapa.getId().equals(idEtapa)) {
               return etapa;
           }
       }
       return null;
   }
      
}
