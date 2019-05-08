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
    
    public Campanya(String nomCampanya,String nomEtapa){
        nom = nomCampanya;
        iniciada = false;
        forma = new ArrayList<Etapa>();
        iniciades = new ArrayList<Etapa>();
        inicial = new Etapa(nomEtapa); 
    }
       
}
