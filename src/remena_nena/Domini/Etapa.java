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
    private ArrayList<Accio> lligam;
    private String forma;
    private Sequencia seqActiva;
    private Campanya forma;

    public Etapa(Campanya c, String nomEtapa) {
        nom = nomEtapa;
        iniciada = false;
        clics = 0;
        emès = new ArrayList<Meme>();
        lligam = new ArrayList<>();
        forma = c;
    }

    public void inserirMeme(Meme m) {
        emes.add(m);
    }

    public String getId() {
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

    public void fixarCondicioRelativa(int idAccio, Meme m, int nombreClics) {
        /* PRE Accio existeix */
        Accio a = getAccio(idAccio);
        a.fixarCondicioRelativa(m, nombreClics);
    }
    
    public void fixarCondicioAbsoluta(int idAccio, int nombreClics) {
        Accio ac = getAccio(idAccio);
        ac.fixarCondicioAbsoluta(this, nombreClics);
    }
    
    public void seleccionarMeme(Meme m) {
        emes.add(m);
    }

    public ArrayList<Meme> getEmesos() {
        return emes;
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
}
