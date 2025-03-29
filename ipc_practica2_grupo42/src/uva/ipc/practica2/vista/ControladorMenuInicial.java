/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;

/**
 *
 * @author tomip
 */
public class ControladorMenuInicial {
    private VistaMenuInicial vista;

    public ControladorMenuInicial(VistaMenuInicial vista){
        this.vista=vista;
    }
    
    public void procesarEntrarGestorTareas(){
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }
    
    public void procesarEntrarGestorListas(){
        Main.getGestorVistas().mostrarVistaGestorListas();
    }
    
    public void procesarEventoSalir(){
        Main.getGestorVistas().salir();
    }
}
