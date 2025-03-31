/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.GestorListas;

/**
 *
 * @author tomip
 */
public class ControladorMenuInicial {
    private VistaMenuInicial vista;
    private GestorListas lista;

    public ControladorMenuInicial(VistaMenuInicial vista){
        this.vista=vista;
        this.lista=Main.getGestorListas();
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
