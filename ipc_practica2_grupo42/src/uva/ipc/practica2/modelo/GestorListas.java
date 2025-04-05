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
    
    public void seleccionarLista(int pos){
        listaSeleccionada=lista.get(pos);
    }
    
    public ListaTareas getListaSeleccionada(){
        return listaSeleccionada;
    }

    public ArrayList <ListaTareas> getGestorTareas(){
        return lista;
    }
    
    public void completarTarea(int posStr){
        if (posStr == -1) {
                    throw new IllegalArgumentException("Debe seleccionar una tarea pendiente para completar");

        }
        int pos=posStr;
        ArrayList <Tarea> tareas=listaSeleccionada.getTareas();
        int pend=0;
        for(int i=0;i<tareas.size();i++){
            if(tareas.get(i).getProgreso()<100){
                if(pend==pos){
                    tareas.get(i).setCompletado(true);
                    return;
                }
                pend++;
            }
        }
        throw new IllegalArgumentException("Debe seleccionar una tarea pendiente para completar");
    }
    
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
    
    public ArrayList <Tarea> getTodasTareas(){
        ArrayList <Tarea> todasTareas=new ArrayList<>();
        for(ListaTareas l: lista){
            todasTareas.addAll(l.getTareas());
        }
        return todasTareas;
    }
    
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

    public ArrayList<ListaTareas> getListas() {
        return this.lista;
    }
}
