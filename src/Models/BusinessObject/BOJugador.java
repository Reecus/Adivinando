/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.BusinessObject;

/**
 *
 * @author Bruno
 */
public class BOJugador {
    private int idJugador;
    private String Nombre;
    private int rol;
    private int turnosComoDesc;
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public int getIdJugador() {
        return idJugador;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getTurnosComoDesc() {
        return turnosComoDesc;
    }

    public void setTurnosComoDesc(int turnosComoDesc) {
        this.turnosComoDesc = turnosComoDesc;
    }

    
    public BOJugador(int idJugador, String Nombre, int rol) {
        this.idJugador = idJugador;
        this.Nombre = Nombre;
        this.rol = rol;
    }
}
