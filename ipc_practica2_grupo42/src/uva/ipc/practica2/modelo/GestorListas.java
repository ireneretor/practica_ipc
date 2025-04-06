/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que gestiona las listas creadas
 * 
 * @author tomip, irereto
 */
public class GestorListas {
    private ArrayList <ListaTareas> lista;
    private ListaTareas listaSeleccionada;
    
    /**
     * Inicializador de la clase, creando el arraylist donde se almacenan las listas.
     */
    public GestorListas(){
        this.lista = new ArrayList<>();
        rellenarPredeterminado();
        listaSeleccionada=lista.get(0);
    }
    
    /**
     * Función que añade una lista al gestor
     * @param nombre Nombre de la nueva lista
     * @throws IllegalArgumentException si el nombre de la lista son caracteres en blanco o si el nombre es igual al de otra lista ya añadida
     */
    public void addLista(String nombre){
         if (nombre.trim().isEmpty()) { 
            throw new IllegalArgumentException("El nombre de la lista no puede ser una serie de caracteres en blanco");
        }
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNombre().equals(nombre)){
                throw new IllegalArgumentException("No puede haber dos listas con el mismo nombre");
            }
        }
        lista.add(new ListaTareas(nombre));
        seleccionarLista(lista.size()-1);
    }
    
    /**
     * Función para indicar que una lista es la seleccionada actualmente.
     * @param pos indice donde esta la lista
     */
    public void seleccionarLista(int pos){
        listaSeleccionada=lista.get(pos);
    }
    
    /**
     * Función que devuelve la lista seleccionada actualmente
     * @return la ListaTareas que esta seleccionada en el momento
     */
    public ListaTareas getListaSeleccionada(){
        return listaSeleccionada;
    }

    /**
     * Función que devuelve el ArrayList con todas las listas
     * @return un ArrayList con todas las listas
     */
    public ArrayList <ListaTareas> getGestorListas(){
        return lista;
    }
    
    /**
     * Función que completa una tarea de la lista seleccionada
     * @param posStr posición en la que se encuentra la lista que se va a completar
     * @throws IllegalArgumentException si no se ha seleccionado una tarea
     */
    public int[] completarTarea(int posStr){
        if (posStr == -1) {
                    throw new IllegalArgumentException("Debe seleccionar una tarea pendiente para completar");

        }
        int pos=posStr;
        ArrayList <Tarea> tareas=listaSeleccionada.getTareas();
        int pend=0;
        for(int i=0;i<tareas.size();i++){
            if(tareas.get(i).getProgreso()<100){
                if(pend==pos){
                    int progreso=tareas.get(i).getProgreso();
                    tareas.get(i).setCompletado(true);  // Marca la tarea como completada
                    return new int[]{i, progreso};  // Devuelve la tarea original
                }
                pend++;
            }
        }
        throw new IllegalArgumentException("Debe seleccionar una tarea pendiente para completar");
    }
    
    /**
     * Función que introduce la lista predeterminada
     */
    private void rellenarPredeterminado(){
        Tarea tarea1=new Tarea("TE 1","Realizar un análisis de una aplicación", new Date(125, 2, 5),"Alta",50, "IPC");
        Tarea tarea2=new Tarea("Lectura","Leer un artículo sobre el uso de deshacer para el tratamiento de errores",new Date(125, 2, 11),"Baja",100, "IPC");
        Tarea tarea3 = new Tarea("Boceto", "Realizar un boceto de la práctica 2", new Date(125, 2, 30), "Alta", 25, "IPC");
        Tarea tarea4 = new Tarea("TE 2", "Realizar una aplicación web", new Date(125, 3, 28), "Media", 100, "IPC");
        ListaTareas IPC=new ListaTareas("IPC");
        IPC.addTarea(tarea1);
        IPC.addTarea(tarea2);
        IPC.addTarea(tarea3);
        IPC.addTarea(tarea4);
        lista.add(IPC);
    }

    /**
     * Función para eliminar una lista
     * @param indexListaSeleccionada posición en la que se encuentra la lista eliminada
     * @throws IllegalArgumentException si no se selecciona una lista para eliminar o si la lista tiene tareas sin completar
     */
    public void eliminarLista(int indexListaSeleccionada) {
        if(indexListaSeleccionada!=-1){
            if(lista.get(indexListaSeleccionada).getNumeroTareasCompletadas()==lista.get(indexListaSeleccionada).getTareas().size()){
                lista.remove(indexListaSeleccionada);
            }else{
                throw new IllegalArgumentException("Para borrar una lista, debe completar todas las tareas");
            }
        }else{
            throw new IllegalArgumentException("Debe seleccionar una lista para eliminar");
        }
    }
    
    /**
     * Función que devuelve todas las tareas de todas las listas
     * @return un ArrayList con todas las tareas de todas las listas
     */
    public ArrayList <Tarea> getTodasTareas(){
        ArrayList <Tarea> todasTareas=new ArrayList<>();
        for(ListaTareas l: lista){
            todasTareas.addAll(l.getTareas());
        }
        return todasTareas;
    }
    
    /**
     * Función para buscar una tarea entre todas las almacenadas en las listas
     * @param tareaSeleccionada toString de la tarea que se pretende buscar
     * @return un entero con la posición en la que se encuentra la tarea
     * @throws IllegalArgumentException si no se ha seleccionado una tarea
     */
    public int buscarTarea(String tareaSeleccionada){
        int i=0;
        for (Tarea t : this.getTodasTareas()) {
                if (t.toString().equals(tareaSeleccionada)) {
                    return i;
                }
                i++;
            }
        throw new IllegalArgumentException("Tienes que seleccionar una tarea");
    }

    /**
     * Función para deshacer una tarea que se marco como completada en la vista del gestor
     * @param tar array de enteros con la posicion de la tarea a editar en la posición 0 y el progreso abterior en la posición 1
     */
    public void deshacerCompletado(int[] tar) {
        listaSeleccionada.editarProgresoTarea(tar[0],tar[1]);
    }

    
}
