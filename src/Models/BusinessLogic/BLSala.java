/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.BusinessLogic;

import Models.BusinessObject.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public final class BLSala {
    private static ArrayList<BOJugador> jugadoresDeSala;
    private static BOPersonaje personajeSala;
    private static final ArrayList<BOSala> salas = new ArrayList<BOSala>(){{
        add(new BOSala(1,"Sala 1",7,3));
        add(new BOSala(2,"Sala 2",3,1));
        add(new BOSala(3,"Sala 3",5,2));
        add(new BOSala(4,"Sala 4",4,3));
        add(new BOSala(5,"Sala 5",3,3));
        add(new BOSala(6,"Sala 6",7,3));
        add(new BOSala(7,"Sala 7",7,6));
        add(new BOSala(8,"Sala 8",3,2));
        add(new BOSala(9,"Sala 9",5,3));
    }};
    
    private static final ArrayList<BOCategoria> categorias = new ArrayList<BOCategoria>(){{
        add(new BOCategoria(1,"Señor de los anillos"));
        add(new BOCategoria(2,"Marvel"));
        add(new BOCategoria(3,"League of legends"));
    }};
    
    public static final ArrayList<ArrayList<BOPersonaje>> personajes = new ArrayList<ArrayList<BOPersonaje>>(){
        {
            add(new ArrayList<BOPersonaje>(){
                {
                    add(new BOPersonaje(1,"Frodo"));
                    add(new BOPersonaje(2,"Gandalf"));
                    add(new BOPersonaje(3,"Sam"));
                    add(new BOPersonaje(4,"Merry"));
                    add(new BOPersonaje(5,"Pippin"));
                    add(new BOPersonaje(6,"Aragorn"));
                    add(new BOPersonaje(7,"Legolas"));
                    add(new BOPersonaje(8,"Gimli"));
                    add(new BOPersonaje(9,"Boromir"));
                    add(new BOPersonaje(10,"Sauron"));
                    add(new BOPersonaje(11,"Gollum"));
                    add(new BOPersonaje(12,"Bilbo"));
                }
            });
            add(new ArrayList<BOPersonaje>(){
                {
                    add(new BOPersonaje(1,"Wolverine"));
                    add(new BOPersonaje(2,"Magneto"));
                    add(new BOPersonaje(3,"Capitan America"));
                    add(new BOPersonaje(4,"Spiderman"));
                    add(new BOPersonaje(5,"Dr. Strange"));
                    add(new BOPersonaje(6,"Thor"));
                    add(new BOPersonaje(7,"Nick Fury"));
                    add(new BOPersonaje(8,"Hawkeye"));
                    add(new BOPersonaje(9,"Gambito"));
                    add(new BOPersonaje(10,"Hulk"));
                    add(new BOPersonaje(11,"Iron man"));
                    add(new BOPersonaje(12,"Profesor X"));
                }
            });
            add(new ArrayList<BOPersonaje>(){
                {
                    add(new BOPersonaje(1,"Wukong"));
                    add(new BOPersonaje(2,"Malphite"));
                    add(new BOPersonaje(3,"Corki"));
                    add(new BOPersonaje(4,"Soraka"));
                    add(new BOPersonaje(5,"Darius"));
                    add(new BOPersonaje(6,"Thresh"));
                    add(new BOPersonaje(7,"Nidalee"));
                    add(new BOPersonaje(8,"Heimerdinger"));
                    add(new BOPersonaje(9,"Garen"));
                    add(new BOPersonaje(10,"Hecarim"));
                    add(new BOPersonaje(11,"Irelia"));
                    add(new BOPersonaje(12,"Poppy"));
                }
            });
        }
    };
    
    private static final ArrayList<BOCategoria> votos = new ArrayList<BOCategoria>();
    
    public static BOJugador definirNombre(String nombre){
        //Se registra nombre de jugador y se retorna el objeto
        return new BOJugador(1,nombre,0);
    }
    
    public static ArrayList<BOSala> obtenerSalas(){
        return salas;
    }
    
    public static BOSala ingresarASala(BOJugador Jugador,int idSala){
        //Set sala para el jugador...
        BOSala sala = buscarSala(idSala);
        int n = sala.getNJugadores() + 1;
        sala.setNJugadores(sala.getNJugadores() + 1);
        
        
        //Para definir los jugadores en base de datos, esto no estaría en el programa real.
        if(jugadoresDeSala == null){
            jugadoresDeSala = new ArrayList<BOJugador>();
        }
        jugadoresDeSala.clear();
        jugadoresDeSala.add(Jugador);
        for(int x = 0;x < n - 1; x++){
            jugadoresDeSala.add(new BOJugador(x+2 ,"Jugador " + (x + 2),0));
        }
        
        sala.setJugadores(jugadoresDeSala);
        
        return sala;
    }
    
    public static ArrayList<BOJugador> obtenerJugadoresSala(int idSala){
        return jugadoresDeSala;
    }
    
    private static BOSala buscarSala(int idSala){
        for(BOSala sala:salas){
            if(sala.getId() == idSala)
                return sala;
        }
        return null;
    }
    
    public static boolean setListo(BOJugador jugador,boolean listo){
        //Se registra el estado del jugador en la base de datos y se checa si todos los jugadores de la sala están listos
        
        return listo;
    }
    
    public static ArrayList<BOCategoria> obtenerCategorias(){
        //Retorna 3 catagorías random
        
        return categorias;
    }

    public static boolean registrarVoto(BOCategoria cat, int idSala) {
        //Se registra voto en BD para "idSala" sala
        votos.add(cat);
        return true;
    }

    public static BOCategoria definirCategoria(int idSala) {
        //Se define la catgoria de ronda en la BD para la sala
        BOCategoria cat;
        if(votos != null && !votos.isEmpty()){
            cat = votos.get(0);
        }
        else{
            Random rand = new Random();
            cat = categorias.get(rand.nextInt(3));
        }
        return cat;
    }

    public static ArrayList<BOPersonaje> obtenerPersonajes(int idCategoria) {
        return personajes.get(idCategoria - 1);
    }

    public static BOJugador definirDescriptor(int idSala) {
        //Se define un descriptor dependiendo de como vayan las rondas en la sala
        for(BOJugador jugador : jugadoresDeSala){
            if(jugador.getTurnosComoDesc() == 0){
                jugador.setTurnosComoDesc(1);
                jugador.setRol(1);
                return jugador;
            }
        }
        return null;
    }

    public static BOPersonaje setPersonajeSala(BOPersonaje personaje, int idSala) {
        //Se define el personaje a utilizar en la sala
        personajeSala = personaje;
        return personaje;
    }

    public static int aumentarRonda(BOSala salaJuego) {
        //Se valida que ronda es
        if(salaJuego.getRonda() < salaJuego.getNumeroRondas())
            return salaJuego.getRonda() + 1;
        return -1;
    }

    public static ArrayList<String> obtenerPreguntas(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void registrarPuntos(BOSala sala, BOJugador jugador) {
        //Se registran los puntos de la ronda para el jugador en la base de datos...
        for(BOJugador jugadorBD : jugadoresDeSala){
            if(jugadorBD.getIdJugador() == jugador.getIdJugador()){
                jugadorBD.setPuntos(jugadorBD.getPuntos() + 10);
            }
        }
    }
}
