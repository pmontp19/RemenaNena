/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;

import java.util.ArrayList;

/**
 *
 * @author pere
 */
public class Sequencia extends Accio {
    private ArrayList<Etapa> iniciacio;
    
    Sequencia() {
        // super();
        iniciacio = new ArrayList<>();
    }
    
    public void encadenarSequencia(Etapa eDesti) {
        iniciacio.add(eDesti);
    }
    
    public void accioExecutada(){
        utilitzat = true;
        for(int i = 0; i<iniciacio.size();i++){
            Etapa e = iniciacio.get(i);
            e.activarMeme(e);
        }
    }
}
