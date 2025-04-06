/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.GestorListas;

/**
 * Clase controladora de los eventos de la vista del menu principal
 * 
 * @author tomruiz, irereto
 */
public class ControladorMenuInicial {
    
    private VistaMenuInicial vista;
    private GestorListas lista;

    /**
     * Inicializador del controlador
     * 
     * @param vista: vista de la que se tomaran los valores
     */
    public ControladorMenuInicial(VistaMenuInicial vista){
        this.vista=vista;
        this.lista=Main.getGestorListas();
    }
    
    /**
     * Funcion para procesar el evento que cambia la vista al gestor de tareas
     */
    public void procesarEntrarGestorTareas(){
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }
    
    /**
     * Funcion para procesar el evento que cambia la vista al gestor de listas
     */
    public void procesarEntrarGestorListas(){
        Main.getGestorVistas().mostrarVistaGestorListas();
    }
    
    /**
     * Funcion para procesar el evento que sale del programa
     */
    public void procesarEventoSalir(){
        Main.getGestorVistas().salir();
    }
}
