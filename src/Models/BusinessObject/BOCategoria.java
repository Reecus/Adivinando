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
public class BOCategoria {
    private int idCategoria;
    private String descripcion;
    private ArrayList<BOPersonaje> personajes;

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }    

    public BOCategoria(int idCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }

    public ArrayList<BOPersonaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<BOPersonaje> personajes) {
        this.personajes = personajes;
    }
    
}
