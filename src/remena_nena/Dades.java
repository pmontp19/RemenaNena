/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena;
import java.util.ArrayList;
import remena_nena.Domini.Campanya;
import remena_nena.Domini.Etapa;
import remena_nena.Domini.Meme;

/**
 *
 * @author victo
 */
public class Dades {
    ArrayList<Campanya> c;
    ArrayList<Etapa> e;
    ArrayList<Meme> m;
    public Dades(){
        iniciarCampanya();
        iniciarMemes();
    }
    private void iniciarCampanya(){
        c = new ArrayList<Campanya>();
        Campanya nova = new Campanya("Eleccions municipals","Pre eleccions");
        nova.IndicarMemePerDades("Pre eleccions","Corrupcio");
        nova.crearEtapa("Meeting a l'ajuntament");
        c.add(nova);
        nova = new Campanya("Eleccions Europees","Primer debat");
        nova.crearEtapa("Segon debat");
        nova.crearEtapa("Tercer debat");
        c.add(nova);
        nova = new Campanya("Eleccions Generals","Ineficiencia del actual Gobern");
        nova.crearEtapa("Nosaltres ho farem millor");
        nova.crearEtapa("Voteume");
        c.add(nova);
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
        return m;
    }
}
