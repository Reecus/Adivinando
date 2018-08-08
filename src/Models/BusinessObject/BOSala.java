/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.BusinessObject;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class BOSala {
    private int Id;
    private String Nombre;
    private int Capacidad;
    private int nJugadores;
    private ArrayList<BOJugador> jugadores;
    private BOCategoria categoria;
    private BOPersonaje personaje;
    private int ronda;
    private int numeroRondas;

    public BOCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(BOCategoria categoria) {
        this.categoria = categoria;
    }

    public BOSala(int Id, String Nombre, int Capacidad, int Jugadores) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Capacidad = Capacidad;
        this.nJugadores = Jugadores;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public int getNJugadores() {
        return nJugadores;
    }

    public void setNJugadores(int Jugadores) {
        this.nJugadores = Jugadores;
    }

    public ArrayList<BOJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<BOJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public BOPersonaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(BOPersonaje personaje) {
        this.personaje = personaje;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getNumeroRondas() {
        return numeroRondas;
    }

    public void setNumeroRondas(int numeroRondas) {
        this.numeroRondas = numeroRondas;
    }
    
}
