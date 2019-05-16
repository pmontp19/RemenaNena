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
    
    public Meme(String idmeme){
        nom = idmeme;
        lliure = false;
        clics = 0;  
        total = new Enregistrament();
        llibertat = new ArrayList<Enregistrament>();
    }
    
    public String getId(){
          return nom;
      }
    
}
