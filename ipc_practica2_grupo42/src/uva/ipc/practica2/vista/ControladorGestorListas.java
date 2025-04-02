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
public class ControladorGestorListas {
    private VistaGestorListas vista;
    private GestorListas lista;
    
    /**
     * Inicializador del controlador
     * 
     * @param vista: vista de la que se tomaran los valores
     */
    public ControladorGestorListas(VistaGestorListas vista){
        this.vista=vista;
        this.lista=Main.getGestorListas();
        vista.actualizarListas(lista.getGestorTareas());
    }
    
    public void procesarEventoGuardar(){
        lista.addLista(vista.getNombreNuevaLista());
        vista.actualizarListas(lista.getGestorTareas());
    }

    void procesarEventoVistaTareas() {
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }

    void procesarEventoVistaMenu() {
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }
}
