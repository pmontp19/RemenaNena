
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena;
import java.util.ArrayList;
import remena_nena.Domini.*;

/**
 *
 * @author victo
 */
public class Dades {
    ArrayList<Campanya> c;
    ArrayList<Etapa> e;
    ArrayList<Meme> m;
    
    public Dades(){
        //c = new ArrayList<>();
        //iniciarMemes();
        //iniciarCampanya();
    }
    public void iniciarCampanya(Controlador k){
        String idMeme;
        String idCampanya = "Destruir oponents";
        String idEtapa = "fase 2";
        k.novaInicial(idCampanya, "fase 1");
        k.indicarMeme("Corrupcio");
        k.indicarMeme("Judicis");
        k.fiCampanya();
        k.seleccionarCampanya(idCampanya);
        k.crearEtapa("fase 2");
        k.indicarMeme("Judicis");
        k.crearEtapa("fase 3");
        k.indicarMeme("Candidat enemic plorant");
        k.indicarMeme("Gestió de crisis");
        k.fiSeleccionar();
        k.fiAfegir();
        k.iniciAccio(idCampanya, "fase 1");
        k.crearSeq();
        k.encadenarSequencia(idCampanya, idEtapa);
        k.fiSequencia();
        k.fiAccio();
        k.fixarCondicioAbsoluta(idCampanya, 0, "fase 1", 100);
        k.fixarCondicioRelativa(idCampanya, "fase 1", 0, "Judicis", 100);
        k.rebreClic("Judicis");
        
        idCampanya = "Eleccions europees";
        idEtapa = "Adversaris";
        idMeme = "Corrupcio";
        k.novaInicial(idCampanya, idEtapa);
        k.indicarMeme(idMeme);
        k.fiCampanya();
        k.seleccionarCampanya(idCampanya);
        k.crearEtapa("Publicitat");
        k.indicarMeme("Judicis");
        k.fiSeleccionar();
        k.fiAfegir();
        k.iniciAccio(idCampanya, idEtapa);
        k.encadenarFinalitzador();
        k.fiAccio();
        k.fixarCondicioRelativa(idCampanya, idEtapa, 1, idMeme, 100);
        k.rebreClic(idMeme);

    }
    private void iniciarMemes(){
        m = new ArrayList<Meme>();
        Meme me = new Meme("Pactes inconvenients");
        m.add(me);
        me = new Meme("Corrupcio");
        m.add(me);
        me = new Meme("Judicis");
        m.add(me);
        me = new Meme("Candidat enemic plorant");
        m.add(me);
        me = new Meme("Gestio terrible");
        m.add(me);
        me = new Meme("Gestió de crisis");
        m.add(me);
    }
    public ArrayList<Campanya> obtenirCampanyes() {
            return c;
    }
    public ArrayList<Meme> obtenirMemes(){
        iniciarMemes();
        return m;
    }
}