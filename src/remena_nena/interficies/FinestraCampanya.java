/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.interficies;
import java.util.ArrayList;
import remena_nena.domini.*;

/**
 *
 * @author victo
 */
public class FinestraCampanya {
    String nomCampanya;
    String nomEtapa;
    ArrayList<Etapa> forma;
    Etapa inicial;
    Controlador K;
    
    
   public FinestraCampanya(Controlador k){
        K=k;
        nomCampanya = "";
        nomCampanya = new String();
        nomEtapa = "";
        nomEtapa = new String();
        forma= new ArrayList<Etapa>();
    }
}
