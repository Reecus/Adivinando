/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.BusinessLogic.BLSala;
import Models.BusinessObject.*;
import Views.Sala.*;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author Bruno
 */
public final class SalaController {
    private static Sala salaViewContext;
    private static BOJugador jugador;
    private static BOSala salaJuego;
    
    public static void votarPorCategoria(BOCategoria cat, int idSala) {
        if(BLSala.registrarVoto(cat,idSala)){
            //Todo bien
            
            /*ArrayList<BOPersonaje> personajes = BLSala.obtenerPersonajes(catGanadora.getIdCategoria());
            salaViewContext.mostrarPersonajes(personajes);*/
        }
    }
    
    public static void mostrarCatGanadora(){
        BOCategoria catGanadora = BLSala.definirCategoria(salaJuego.getId());
        salaJuego.setCategoria(catGanadora);
        salaJuego.setNumeroRondas(salaJuego.getJugadores().size() * 2);
        salaViewContext.mostrarCategoriaGanadora(catGanadora);
        definirDescriptor(salaJuego.getId());
    }
    
    public static void definirDescriptor(int idSala){
        salaJuego.setRonda(BLSala.aumentarRonda(salaJuego));
        if(salaJuego.getRonda() != -1){
            BOJugador aux = BLSala.definirDescriptor(idSala);
            if(aux.getIdJugador() == jugador.getIdJugador()){
                jugador.setRol(1);
            }
            salaViewContext.mostrarDescriptor(aux);
            }
        else{
            terminarJuego();
        }
    }
    
    public static void buscarSala(){
        BuscadorSala buscador = new BuscadorSala();
        buscador.setTitle("Adivinando - Buscador de salas");
        buscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscador.pack();
        buscador.setVisible(true);
    }
    public static void crearSala(){
        CreadorSala creador = new CreadorSala();
        creador.setTitle("Adivinando - Creador de salas");
        creador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creador.pack();
        creador.setVisible(true);
    }
    public static void ingresarASala(BOJugador jugador,int idSala){
        BOSala sala = BLSala.ingresarASala(jugador, idSala);
        if(sala != null){
            salaJuego = sala;
            Sala salavw = new Sala(jugador,sala);
            salaViewContext = salavw;
            salavw.setTitle("Adivinando - Sala: " + sala.getNombre());
            salavw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            salavw.pack();
            salavw.setVisible(true);
        }
    }
    public static BOJugador definirNombre(String nombre){
        jugador = BLSala.definirNombre(nombre);
        return jugador;
    }
    
    public static ArrayList<BOSala> obtenerSalas(){
        return BLSala.obtenerSalas();
    }
    public static ArrayList<BOJugador> obtenerJugadoresSala(int idSala){
        ArrayList<BOJugador> jugadores = BLSala.obtenerJugadoresSala(idSala);
        if(jugadores != null){
            return jugadores;
        }
        else{
            return null;
        }
    }
    
    public static boolean setListo(BOJugador jugador,boolean listo){
        return BLSala.setListo(jugador, listo);
    }
    
    public static ArrayList<BOCategoria> obtenerCategorias(){
        return BLSala.obtenerCategorias();
    }

    public static void mostrarPersonajes() {
        if(jugador.getRol() == 1){
            ArrayList<BOPersonaje> personajes = BLSala.obtenerPersonajes(salaJuego.getCategoria().getIdCategoria());
            salaViewContext.mostrarPersonajes(personajes);
        }
    }

    public static boolean setPersonaje(BOPersonaje personaje, int idSala) {
        if(BLSala.setPersonajeSala(personaje,idSala) != null){
            return true;
        }
        return false;
    }

    private static void terminarJuego() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<String> obtenerPreguntas(int idCategoria) {
        ArrayList<String> preguntas = BLSala.obtenerPreguntas(idCategoria);
        return preguntas;
    }

    public static void registrarPuntos(BOSala sala, BOJugador jugadorPrin) {
        BLSala.registrarPuntos(sala,jugador);
    }

}
