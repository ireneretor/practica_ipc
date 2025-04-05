/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.vista;
import java.util.ArrayList;
import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.GestorListas;
import uva.ipc.practica2.modelo.Tarea;

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
        try{
            lista.addLista(vista.getNombreNuevaLista());
            vista.actualizarListas(lista.getGestorTareas());
            vista.vaciarCampos();
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
        }
    }

    void procesarEventoVistaTareas() {
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }

    void procesarEventoVistaMenu() {
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }

    public void procesarEventoSeleccionarLista() {
        if(vista.getIndexListaSeleccionada()!=-1) lista.seleccionarLista(vista.getIndexListaSeleccionada());
        vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());   
        vista.setError("");
    }

    public void procesarCompletarTarea() {
        try{
            lista.completarTarea(vista.getPosicionSelectPendiente());
            vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());
            vista.setError("");
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
        }
    }

    public void procesarEventoBorrar() {
        try{
            lista.eliminarLista(vista.getIndexListaSeleccionada());
            vista.actualizarListas(lista.getGestorTareas());
            vista.vaciarCampos();
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
        }
    }
}
