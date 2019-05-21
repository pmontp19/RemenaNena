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
public class Tancat extends Accio{
    
    public Tancat(Etapa e){
       super(e);
       this.fixarCondicioAbsoluta(e, 10000);
       e.afegeixAccio(this);
    }
    
    @Override
    public void accioExecutada(){
        lligam.FinalitzarCampanya();
        lligam.lliberaMeme();
        lligam.EsborrarEtapaAcabada();
    }
    
}
