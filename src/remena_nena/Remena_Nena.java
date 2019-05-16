/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remena_nena;
import remena_nena.Interficie.FinestraInicial;
import remena_nena.Domini.Controlador;
import remena_nena.pantalles.*;

/**
 *
 * @author victo
 */
public class Remena_Nena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dades info_inicial = new Dades();
        //Controlador k = new Controlador(info_inicial);
        Controlador k = new Controlador();
        k.setMemesIni(info_inicial.obtenirMemes());
        info_inicial.iniciarCampanya(k);
        FinestraInicial pantallaInicial = new FinestraInicial(k);
        Inicial primera_pantalla = new Inicial(pantallaInicial);
        primera_pantalla.setVisible(true);
    }
    
}
