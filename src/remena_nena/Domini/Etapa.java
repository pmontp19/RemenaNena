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
public class Etapa {

    private String nom;
    private boolean iniciada;
    private int clics;
    private ArrayList<Meme> emes;
    private ArrayList<Accio> lligam;
    private ArrayList<Absoluta> vinculada;
    private Sequencia seqActiva;
    private Campanya forma;

    public Etapa(Campanya c, String nomEtapa) {
        nom = nomEtapa;
        iniciada = false;
        clics = 0;
        emes = new ArrayList<Meme>();
        lligam = new ArrayList<Accio>();
        vinculada = new ArrayList<Absoluta>();
        forma = c;
    }

    public void inserirMeme(Meme m) {
        emes.add(m);
    }

    public String getId() {
        return nom;
    }

    public void crearSeq() {
        Sequencia s = new Sequencia(this);
        lligam.add(s);
        seqActiva = s;
    }
    
    public void afegeixCondicio(Absoluta a){
        vinculada.add(a);
    }
    
    public void afegeixAccio(Accio a){
        lligam.add(a);
    }
    
    public void crearTancat(){
        Tancat s = new Tancat(this);
        lligam.add(s);
    }

    public void encadenarSequencia(Etapa eDesti) {
        seqActiva.encadenarSequencia(eDesti);
    }

    public void encadenarFinalitzador() {
        Finalitzador f = new Finalitzador(this);
        lligam.add(f);
    }

    public void fiSequencia() {
        seqActiva = null;
    }

    public void encadenarDisparador(Campanya c) {
        Disparador d = new Disparador(c,this);
        lligam.add(d);
    }

    public void fixarCondicioRelativa(int idAccio, Meme m, int nombreClics) {
        /* PRE Accio existeix */
        Accio a = getAccio(idAccio);
        a.fixarCondicioRelativa(m, nombreClics, this);
    }
    
    public void fixarCondicioRelativa(Relativa r, Meme m) {
        m.fixarCondicioRelativa(r);
    }
    
    public void fixarCondicioAbsoluta(int idAccio, int nombreClics) {
        Accio ac = getAccio(idAccio);
        ac.fixarCondicioAbsoluta(this, nombreClics);
    }
    
    public void seleccionarMeme(Meme m) {
        emes.add(m);
    }
    public void seleccionarMemeID(String s) {
        Meme m = getMeme(s);
        emes.add(m);
    }

    public ArrayList<Meme> getEmesos() {
        return emes;
    }
    
    public ArrayList<Accio> getAccions() {
        return lligam;
    }

    // finds
    public Accio getAccio(int id) {
        for (Accio a : lligam) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    public void iniciarCampanya(){
        iniciada = true;
        for(int i = 0; i<emes.size();i++){
            Meme m = emes.get(i);
            m.activarMemes(this);
        }
    }
    
    public boolean esta_iniciada(){
        return iniciada;
    }
    public Meme getMeme(String idMeme){
        boolean trobat = false;
        int i = 0;
        Meme m = null;
        while(i<emes.size() && !trobat){
            m = emes.get(i);
            if (m.getId().equals(idMeme)) {
                trobat = true;
            }
            else i++;
        }
        if(!trobat) m = null;
        return m;
    }
    
    public void FinalitzarCampanya(){
        iniciada = false;
        for(int i = 0; i<emes.size();i++){
            Meme m = emes.get(i);
            m.FinalitzarEtapa(this);
        }
    }
    public void activarMeme(Etapa e){
        iniciada = true;
        for(int i = 0; i<emes.size();i++){
            Meme m = emes.get(i);
            m.activarMemes(e);
            forma.activarEtapa(this);
        }
    }

    public void EsborrarEtapaAcabada(){
        forma.borrarEtapa(this);
    }
    
    public void rebreClic(){
        clics++;
        for(int i = 0; i<vinculada.size(); i++){
            Absoluta a = vinculada.get(i);
            a.rebreClic();
        }
    }
    
    public void lliberaMeme() {
        for (Meme meme : emes) {
            meme.lliure(this); 
        }
    }
    
    public int getClics() {
        return clics;
    }
}
