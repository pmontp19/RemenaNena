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
    protected static int comptador = 0;
    protected int id;
    protected boolean utilitzat;
    protected Condicio compleix;
    protected Etapa e;

    
    // constructor per defecte
    public Accio() {
        id = comptador++;
        utilitzat = false;
        compleix = null;
    }
    
    // constructor amb parametre
    public Accio(Etapa e){
        id = comptador++;
        utilitzat = false;
        compleix = null;
        this.e = e;
    }
    
    public void fixarCondicioRelativa(Meme m, int nombreClics, Etapa e) 
    {
        Relativa r = new Relativa(m, this, nombreClics);
        compleix = r;
        e.fixarCondicioRelativa(r,m);
        
    }
    
    public void fixarCondicioAbsoluta(Etapa e, int nombreClics) {
        Absoluta a = new Absoluta(e, this, nombreClics);
        compleix = a;
        e.afegeixCondicio(a);
    }
    
    public int getId() {
        return id;
    }

    public void accioExecutada() {
        
    }
   
    
    
    
}
