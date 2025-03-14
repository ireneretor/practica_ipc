/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_practica1_grupo42_modelo;
import java.util.ArrayList;


public class GestorTareas {
    private ArrayList <Tarea> tareas;
    
    public GestorTareas(){
        this.tareas = new ArrayList<>();
    }
    public ArrayList <Tarea> getTareas(){
        ArrayList <Tarea> copia=new ArrayList<>(tareas);
        return copia;
    }
    
    public String[] getTareasString(){
        return this.tareas.toArray(String[]::new);
    }
    
    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
    }

    public void editarTarea(int i,Tarea nuevaTarea){
        tareas.set(i,nuevaTarea);
    }
    
    public void eliminarTarea(int i){
        tareas.remove(i);
    }
}
