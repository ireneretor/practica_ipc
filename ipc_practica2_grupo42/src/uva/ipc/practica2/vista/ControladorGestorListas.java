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
        lista.addLista(vista.getNombreNuevaLista());
        vista.actualizarListas(lista.getGestorTareas());
    }

    void procesarEventoVistaTareas() {
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }

    void procesarEventoVistaMenu() {
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }

    public void procesarEventoSeleccionarLista() {
        lista.seleccionarLista(vista.getIndexListaSeleccionada());
        vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());        
    }

    public void procesarCompletarTarea() {
        int nTarea=vista.getPosicionSelectPendiente();
        ArrayList <Tarea> tareas=lista.getListaSeleccionada().getTareas();
        int pend=0;
        for(int i=0;i<tareas.size();i++){
            if(tareas.get(i).getProgreso()<100){
                if(pend==nTarea){
                    tareas.get(i).setCompletado(true);
                    vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());
                    return;
                }
                pend++;
            }
        }
        throw new IllegalArgumentException("Chicharron");
    }

    public void procesarEventoBorrar() {
        try{
            lista.eliminarLista(vista.getIndexListaSeleccionada());
            vista.vaciarCampos();
            vista.actualizarListas(lista.getGestorTareas());
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
        }
    }
}
