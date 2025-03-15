/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_practica1_grupo42_modelo;
import java.util.ArrayList;

/**
 * Clase que actua como modelo para la gestión de las tareas.
 * @author tomruiz,irereto
 */
public class GestorTareas {
    private ArrayList <Tarea> tareas;
    
    /**
     * Inicializador de la clase, creando el arraylist donde se almacenan las tareas.
     */
    public GestorTareas(){
        this.tareas = new ArrayList<>();
    }
    
    /**
     * Funcion que devuelve una copia de las tareas que guarda el modelo
     * @return un arraylist con todas las tareas
     */
    public ArrayList <Tarea> getTareas(){
        ArrayList <Tarea> copia=new ArrayList<>(tareas);
        return copia;
    }
    
    /**
     * Getter del toString de todas las tareas
     * @return Array de Stringg con los toString de las tareas
     */
    public String[] getTareasString(){
        return this.tareas.toArray(String[]::new);
    }
    
    /**
     * Función para añadir una tarea nueva a la lista
     * @param tarea: Tarea nueva a añadir
     */
    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
    }

    /**
     * Funcion para editar la tarea en una posicion determinada
     * @param i: entero que representa la posición en la que se va a cambiar la tarea
     * @param nuevaTarea: tarea que se añade en la posicion i
     */
    public void editarTarea(int i,Tarea nuevaTarea){
        tareas.set(i,nuevaTarea);
    }
    
    /**
     * Función para eliminar una tarea de la lista
     * @param i: entero que nos da las posición de la tarea a eliminar
     */
    public void eliminarTarea(int i){
        tareas.remove(i);
    }
}

