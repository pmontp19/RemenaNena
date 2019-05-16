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
public class Accio {
    private static int comptador = 0;
    private int id;
    private boolean utilitzat;
    private ArrayList<Condicio> compleix;
    
    // constructor per defecte
    public Accio() {
        id = comptador++;
        utilitzat = false;
        compleix = new ArrayList<>();
    }
    
    // constructor amb parametre
    public Accio(int idAccio){
        id = idAccio;
        utilitzat = false;
        compleix = new ArrayList<>();
    }
    
    public void fixarCondicioRelativa(String idMeme, int nombreClics) 
    {
        Relativa r = new Relativa(idMeme, this, nombreClics);
        compleix.add(r);
    }
    
    public void fixarCondicioAbsoluta(Etapa e, int nombreClics) {
        Absoluta a = new Absoluta(e, this, nombreClics);
        compleix.add(a);
    }
    
    public int getId() {
        return id;
    }
    
}
