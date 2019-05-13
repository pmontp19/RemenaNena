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
    private ArrayList<Meme> emès;
    private ArrayList<Meme> actiu;
    private ArrayList<Accio> lligam;
    private Sequencia seqActiva;
    
    public Etapa(String nomEtapa){
        nom = nomEtapa;
        iniciada = false;
        clics = 0;
        emès = new ArrayList<Meme>();
        actiu = new ArrayList<Meme>();
        lligam = new ArrayList<>();
    }
    
    public void inserirMeme(Meme m){
        emès.add(m);
    }
    public String getId(){
        return nom;
    }
    
    public void crearSeq() {
        Sequencia s = new Sequencia();
        lligam.add(s);
        seqActiva = s;
    }
    
    public void encadenarSequencia(Etapa eDesti) {
        seqActiva.encadenarSequencia(eDesti);
    }
    
    public void encadenarFinalitzador() {
        Finalitzador f = new Finalitzador();
        lligam.add(f);
    }
    
    public void fiSequencia() {
        seqActiva = null;
    }
    
    public void encadenarDisparador(Campanya c) {
        Disparador d = new Disparador(c);
        lligam.add(d);
    }
    public ArrayList<Meme> getEmesos(){
        return emès;
    }
}
