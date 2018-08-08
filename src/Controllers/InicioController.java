/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Ingreso.Inicio;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public final class InicioController {
    public static void inicio(){
        Inicio inicio = new Inicio();
        inicio.setTitle("Adivinando!");
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.pack();
        inicio.setVisible(true);
    }
}
