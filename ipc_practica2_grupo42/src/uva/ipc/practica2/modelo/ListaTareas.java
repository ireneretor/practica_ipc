/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.modelo;
import java.util.ArrayList;

/**
 * Clase que actua como modelo para la gestion de las tareas.
 * 
 * @author tomruiz, irereto
 */
public class ListaTareas {
    private ArrayList <Tarea> tareas;
    private String nombre;
    
    /**
     * Inicializador de la clase, creando el arraylist donde se almacenan las tareas.
     */
    public ListaTareas(String nombre){
        this.tareas = new ArrayList<>();
        this.nombre= nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Funcion que devuelve una copia de las tareas que guarda el modelo
     * 
     * @return un arraylist con todas las tareas
     */
    public ArrayList <Tarea> getTareas(){
        ArrayList <Tarea> copia=new ArrayList<>(tareas);
        return copia;
    }
    
    /**
     * Getter del toString de todas las tareas
     * 
     * @return Array de Stringg con los toString de las tareas
     */
    public String[] getTareasString(){
        return this.tareas.toArray(String[]::new);
    }
    
    /**
     * Funcion para añadir una tarea nueva a la lista
     * @throws IllegalArgumentException si la tarea que se introduce se llama igual que otra ya introducida
     * @param tarea: Tarea nueva a añadir
     */
    public void addTarea(Tarea tarea){
        boolean existe = false;
        for (Tarea t : tareas) {
            if (t.getNombreTarea().equals(tarea.getNombreTarea())) {
                existe = true;
                throw new IllegalArgumentException("Ya existe una tarea con ese nombre");
            }
        }
        if(!existe) this.tareas.add(tarea);
    }

    /**
     * Funcion para editar la tarea en una posicion determinada
     * 
     * @param i: entero que representa la posicion en la que se va a cambiar la tarea
     * @param nuevaTarea: tarea que se añade en la posicion i
     */
    public void editarTarea(int i,Tarea nuevaTarea){
        System.out.println(nuevaTarea.toString());
        tareas.set(i,nuevaTarea);
        for(int j=0;j<tareas.size();j++){
            System.out.println(tareas.get(j).toString());
        }
    }
    
    public int buscarTarea(String tareaSeleccionada){
        int i=0;
        for (Tarea t : tareas) {
                if (t.toString().equals(tareaSeleccionada)) {
                    return i;
                }
                i++;
            }
        throw new IllegalArgumentException("Tienes que seleccionar una tarea");
    }
    
    public boolean eliminarTarea(String tareaSeleccionada){
        if(tareaSeleccionada==null){ 
            throw new IllegalArgumentException("Tienes que seleccionar una tarea");
        }
        for(Tarea t : tareas) {
                    if(tareaSeleccionada.equals(t.toString())) {
                        tareas.remove(buscarTarea(tareaSeleccionada));
                        return true;
                    }
                }
        return false;
    }
    
    public int getNumeroTareasCompletadas(){
        int comp=0;
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t=tareas.get(i);
            if(t.getProgreso()==100){
                comp++;
            }
        }
        return comp;
    }
    
    public void editarProgresoTarea(int pos, int progre){
        tareas.get(pos).setCompletado(false);
        tareas.get(pos).setProgreso(progre);
    }
    }

