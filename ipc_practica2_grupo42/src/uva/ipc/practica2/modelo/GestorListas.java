/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tomip
 */
public class GestorListas {
    private ArrayList <ListaTareas> lista;
    private ListaTareas listaSeleccionada;
    
    /**
     * Inicializador de la clase, creando el arraylist donde se almacenan las tareas.
     */
    public GestorListas(){
        this.lista = new ArrayList<>();
        rellenarPredeterminado();
        listaSeleccionada=lista.get(0);
    }
    
    public void addLista(String nombre){
        lista.add(new ListaTareas(nombre));
        listaSeleccionada=lista.get(lista.size()-1);
    }
    
    public ListaTareas getListaSeleccionada(){
        return listaSeleccionada;
    }
    
    public ArrayList <ListaTareas> getGestorTareas(){
        return lista;
    }
    
    private void rellenarPredeterminado(){
        Tarea tarea1=new Tarea("TE 1","Realizar un análisis de una aplicación", new Date(125, 2, 5),"Alta",50);
        Tarea tarea2=new Tarea("Lectura","Leer un artículo sobre el uso de deshacer para el tratamiento de errores",new Date(125, 2, 11),"Baja",100);
        Tarea tarea3 = new Tarea("Boceto", "Realizar un boceto de la práctica 2", new Date(125, 2, 30), "Alta", 25);
        Tarea tarea4 = new Tarea("TE 2", "Realizar una aplicación web", new Date(125, 3, 28), "Media", 100);
        ListaTareas IPC=new ListaTareas("IPC");
        IPC.addTarea(tarea1);
        IPC.addTarea(tarea2);
        IPC.addTarea(tarea3);
        IPC.addTarea(tarea4);
        lista.add(IPC);
    }

}
