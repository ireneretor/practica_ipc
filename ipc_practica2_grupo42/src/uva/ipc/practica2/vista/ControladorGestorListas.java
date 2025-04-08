/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.vista;
import java.util.ArrayList;
import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.GestorListas;

/**
 *Clase controladora de los eventos de la vista del gestor de listas
 * 
 * @author tomruiz, irereto
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
    
    /**
     * Funcion para procesar el guardado de las listas en el modelo con los valores obtenidos de la vista
     */
    public void procesarEventoGuardar(){
        try{
            lista.addLista(vista.getNombreNuevaLista());
            vista.actualizarListas(lista.getGestorListas());
            vista.vaciarCampos();
            desmantelarDeshacer();
            vista.errorVerde();
            vista.setError("Lista añadida con éxito");
        }catch(IllegalArgumentException e){
                vista.errorRojo();
                vista.setError(e.getMessage());
                vista.anadirRojo();
        }
    }

    /**
     * Funcion para procesar el evento que cambia la vista al gestor de tareas
     */
    public void procesarEventoVistaTareas() {
        vista.desactivarDeshacerCompletado();
        Main.getGestorVistas().mostrarVistaGestorTareas();
    }

    /**
     * Funcion para procesar el evento que cambia la vista al menu principal
     */
    public void procesarEventoVistaMenu() {
        vista.desactivarDeshacerCompletado();
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }

    /**
     * Funcion para procesar el evento de seleccionar una lista
     */
    public void procesarEventoSeleccionarLista() {
        if(vista.getIndexListaSeleccionada()!=-1) lista.seleccionarLista(vista.getIndexListaSeleccionada());
        vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());   
        vista.setError("");
        vista.pendientesBlanco();
        desmantelarDeshacer();
    }

    /**
     * Funcion para procesar el evento de completar una tarea
     */
    public void procesarCompletarTarea() {
        try{
            tareasAntiguas.add(lista.completarTarea(vista.getPosicionSelectPendiente()));
            vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());
            vista.setError("");
            vista.pendientesBlanco();
            vista.activarDeshacerCompletado();
            vista.errorVerde();
            vista.setError("Tarea completada con éxito");
        }catch(IllegalArgumentException e){
                vista.errorRojo();
                vista.setError(e.getMessage());
                vista.pendientesRojo();
        }
    }

    /**
     * Funcion para procesar el evento de borrar una lista
     */
    public void procesarEventoBorrar() {
        try{
            lista.eliminarLista(vista.getIndexListaSeleccionada());
            vista.actualizarListas(lista.getGestorListas());
            vista.vaciarCampos();
            desmantelarDeshacer();
            vista.errorVerde();
            vista.setError("Lista borrada con éxito");
        }catch(IllegalArgumentException e){
                vista.errorRojo();
                vista.setError(e.getMessage());
                if(e.getMessage().equals("Para borrar una lista, debe completar todas las tareas")){
                    vista.pendientesRojo();
                }else{
                    vista.listasRojo();
                }
        }
    }

    /**
     * Funcion para procesar el evento de deshacer el completar una tarea
     */
    public void procesarEventoDeshacer() {
        lista.deshacerCompletado(tareasAntiguas.get(tareasAntiguas.size()-1));
        tareasAntiguas.remove(tareasAntiguas.size()-1);
        vista.cambiarCamposListaSeleccionada(lista.getListaSeleccionada());
        vista.setError("");
        vista.pendientesBlanco();
        vista.errorVerde();
        vista.setError("Deshacer completado con éxito");
        if(tareasAntiguas.isEmpty()){
            vista.desactivarDeshacerCompletado();           
        }
    }
    
    /**
     * Funcion para reiniciar las acciones que habria que deshacer
     */
    public void desmantelarDeshacer(){
        tareasAntiguas.clear();
        vista.desactivarDeshacerCompletado();
    }
}
