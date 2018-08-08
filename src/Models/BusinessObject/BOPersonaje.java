/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.BusinessObject;

/**
 *
 * @author User
 */
public class BOPersonaje {
    private int idPersonaje;
    private String nombre;

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public BOPersonaje(int idPersonaje, String nombre) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
    }
}
