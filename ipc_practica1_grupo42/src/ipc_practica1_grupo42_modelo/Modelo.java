/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_practica1_grupo42_modelo;
import java.util.ArrayList;


public class Modelo {
    private ArrayList <Tareas> tareas;
    
    public Modelo(){
        tareas=new ArrayList <> ();
    }
    
    public ArrayList <Tareas> getTareas(){
        return this.tareas;
    }
    
    public void addTarea(Tareas tarea){
        this.tareas.add(tarea);
    }
}
