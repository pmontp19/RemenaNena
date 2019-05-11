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
    private String id;
    private boolean utilitzat;
    private ArrayList<Condicio> compleix;
    
    public Accio(String idAccio){
        id = idAccio;
        utilitzat = false;
        compleix = new ArrayList<Condicio>();
    }
    
}
