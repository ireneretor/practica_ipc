/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.vista;

import javax.swing.JFrame;

/**
 *
 * @author irereto
 */
public class GestorVistas {

    private JFrame vistaActual;

    public void mostrarVistaMenuInicial() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuInicial();
        vistaActual.setVisible(true);
    }

    public void mostrarVistaGestorTareas() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaGestorTareas();
        vistaActual.setVisible(true);
    }

    public void mostrarVistaGestorListas() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        //vistaActual = new VistaGestorListas();
        vistaActual.setVisible(true);
    }
    
    public void salir(){
        System.exit(0);
    }
}
