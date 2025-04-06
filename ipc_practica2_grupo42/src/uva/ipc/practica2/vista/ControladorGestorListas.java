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
    private ArrayList<int[]> tareasAntiguas;
    
    /**
     * Inicializador del controlador
     * 
     * @param vista: vista de la que se tomaran los valores
     */
    public ControladorGestorListas(VistaGestorListas vista){
        this.vista=vista;
        this.lista=Main.getGestorListas();
        this.tareasAntiguas=new ArrayList<int[]>();
        vista.actualizarListas(lista.getGestorListas());
        vista.desactivarDeshacerCompletado();
    }
    
    public void procesarEventoGuardar(){
        try{
            lista.addLista(vista.getNombreNuevaLista());
            vista.actualizarListas(lista.getGestorListas());
            vista.vaciarCampos();
            desmantelarDeshacer();
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
                vista.anadirRojo();
        }
    }

    void procesarEventoVistaTareas() {
        vista.desactivarDeshacerCompletado();
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }

    void procesarEventoVistaMenu() {
        vista.desactivarDeshacerCompletado();
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }

    public void procesarEventoSeleccionarLista() {
        if(vista.getIndexListaSeleccionada()!=-1) lista.seleccionarLista(vista.getIndexListaSeleccionada());
        vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());   
        vista.setError("");
        desmantelarDeshacer();
    }

    public void procesarCompletarTarea() {
        try{
            tareasAntiguas.add(lista.completarTarea(vista.getPosicionSelectPendiente()));
            vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());
            vista.setError("");
            vista.pendientesBlanco();
            vista.activarDeshacerCompletado();
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
                vista.pendientesRojo();
        }
    }

    public void procesarEventoBorrar() {
        try{
            lista.eliminarLista(vista.getIndexListaSeleccionada());
            vista.actualizarListas(lista.getGestorListas());
            vista.vaciarCampos();
            desmantelarDeshacer();
        }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
                if(e.getMessage().equals("Para borrar una lista, debe completar todas las tareas")){
                    vista.completadasRojo();
                }else{
                    vista.listasRojo();
                }
        }
    }

    public void procesarEventoDeshacer() {
        lista.deshacerCompletado(tareasAntiguas.get(tareasAntiguas.size()-1));
        tareasAntiguas.remove(tareasAntiguas.size()-1);
        vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());
        vista.setError("");
        vista.pendientesBlanco();
        if(tareasAntiguas.isEmpty()){
            vista.desactivarDeshacerCompletado();           
        }
    }
    
    public void desmantelarDeshacer(){
        tareasAntiguas.clear();
        vista.desactivarDeshacerCompletado();
    }
}
