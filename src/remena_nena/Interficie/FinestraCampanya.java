/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena.Interficie;
import remena_nena.Domini.Controlador;
import remena_nena.Domini.Etapa;
import java.util.ArrayList;

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
        K = k;
        nomCampanya = "";
        nomCampanya = new String();
        nomEtapa = "";
        nomEtapa = new String();
        forma = new ArrayList<Etapa>();
    }
   
   public void setNomCampanya(String n) {
       nomCampanya = n;
   }
   
   public void setNomInicial(String n) {
       nomEtapa = n;
   }
   
   public boolean afegir() {
       boolean bona = false;
       // no cal comprovar etapa
       if (!K.comprovaCampanya(nomCampanya)) {
           bona = true;
           K.novaInicial(nomCampanya, nomEtapa);
       }
       return bona;
   }
}
