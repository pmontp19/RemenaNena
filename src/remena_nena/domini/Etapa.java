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
public class Etapa {
    private String nom;
    private boolean iniciada;
    private int clics;
    private ArrayList<Meme> emès;
    private ArrayList<Meme> actiu;
    private ArrayList<Accio> lligam;
    
    public Etapa(String nomEtapa){
        nom = nomEtapa;
        iniciada = false;
        clics = 0;
        emès = new ArrayList<Meme>();
        actiu = new ArrayList<Meme>();
        lligam = new ArrayList<Accio>();
    }
    
    public void inserirMeme(Meme m){
        emès.add(m);
    }
    public String getEtapa(){
        return nom;
    }
    
}
