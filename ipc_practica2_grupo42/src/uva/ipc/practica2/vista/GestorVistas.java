/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.vista;

import javax.swing.JFrame;

/**
 * Clase controladora de las vistas
 * 
 * @author tomruiz, irereto
 */
public class GestorVistas {

    private JFrame vistaActual;

    /**
     * Funcion para mostrar el menu inicial
     */
    public void mostrarVistaMenuInicial() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuInicial();
        vistaActual.setVisible(true);
    }

    /**
     * Funcion para mostrar el gestor de tareas
     */
    public void mostrarVistaGestorTareas() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaGestorTareas();
        vistaActual.setVisible(true);
    }

    /**
     * Funcion para mostrar el gestor de listas
     */
    public void mostrarVistaGestorListas() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaGestorListas();
        vistaActual.setVisible(true);
    }
    
    /**
     * Funcion para salir del programa
     */
    public void salir(){
        System.exit(0);
    }
}
