/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Domini;

/**
 *
 * @author victo
 */
public class Enregistrament {
    private String id;
    private int clics;
    
    public Enregistrament(){
        id = java.util.UUID.randomUUID().toString();
        clics = 0;
    }
    
    public Enregistrament(int clics){
        id = java.util.UUID.randomUUID().toString();
        this.clics = clics;
    }
    
    public String getId() {
        return id;
    }
    
    public int getClics() {
        return clics;
    }
    
    public void rebreClic(){
        clics++;
    }
    
}
