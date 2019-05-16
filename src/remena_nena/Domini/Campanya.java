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
        inicial = new Etapa(this, nomEtapa);
        forma.add(inicial);
        etapa_activa = null;
    }
   public Etapa obteEtapa(){
       return etapa_activa;
   }
   public void fiEtapa(){
       etapa_activa = null;
   }
   
   public void IndicarMemePerDades(String s, String r){
       Etapa e = getEtapa(s);
       Meme m = e.getMeme(r);
       e.inserirMeme(m);
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
   public void activarEtapa(Etapa e){
       this.iniciades.add(e);
   }
   
   public String getnom(){
       return nom;
   }
   public boolean getIniciada(){
       return iniciada;
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
   
   public void fixarCondicioRelativa(String idEtapa, int idAccio, Meme m, int nombreClics) {
        /* PRE Etapa existeix */
        Etapa e = getEtapa(idEtapa);
        e.fixarCondicioRelativa(idAccio, m, nombreClics);
   }
   
   public void fixarCondicioAbsoluta(int idAccio, String idEtapa, int nombreClics) {
       Etapa e = getEtapa(idEtapa);
       e.fixarCondicioAbsoluta(idAccio, nombreClics);
   }
   
   public void crearEtapa(String nomEtapa) {
       Etapa e = new Etapa(this, nomEtapa);
       forma.add(e);
       etapa_activa = e;
   }
   
   public void seleccionarMeme(Meme m) {
       etapa_activa.seleccionarMeme(m);
   }
   
   public void fiSeleccionar() {
       etapa_activa = null;
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
   public ArrayList<Etapa> getEtapasForma() {
       return forma;
   }
   
   public void iniciarCampanya(){
       iniciada = true;
       inicial.iniciarCampanya();
       iniciades.add(inicial);
       
   }
   
   public void FinalitzarCampanya(){
       iniciada = false;
       for(int i = 0; i<iniciades.size(); i++){
           Etapa e = iniciades.get(i);
           e.FinalitzarCampanya();
       }
       iniciades = new ArrayList<Etapa>();
   }
   public void borrarEtapa(Etapa e){
       int i = 0;
       boolean trobat = false;
       while(i<iniciades.size() && !trobat){
           Etapa et = iniciades.get(i);
           if(et.equals(e)) iniciades.remove(i);
           else i++;           
       }
       if(iniciades.isEmpty()) iniciada = false;
       
   }
      
}
