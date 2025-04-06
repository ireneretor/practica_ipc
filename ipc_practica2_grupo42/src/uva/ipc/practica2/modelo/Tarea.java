/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.practica2.modelo;

import static java.lang.Math.abs;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Tipo de dato que define las tareas que se tienen almacenar
 * 
 * @author tomruiz, irereto
 */
public class Tarea {
    private String nombreTarea;
    private String descripcionTareas;
    private Date fecha;
    private String prioridad;
    private int progreso;
    private boolean completado;
    private String lista;
    
    /**     
     * Inicializador de la clase Tareas
     * 
     * @param nombreTarea:  String que se refiere nombre que se asigna a la tarea
     * @param descripcion: String que se refiere a la descripcion de la tarea
     * @param fecha: Date referida a la fecha en la que se espera que acabe la tarea
     * @param prioridad: String que indica la prioridad de la tarea
     * @param progreso: int que indica el progreso de la tarea
     * @param lista: String que se refiere al nombre de la lista donde se almacena
     */
    public Tarea(String nombreTarea, String descripcion, Date fecha, String prioridad, int progreso, String lista) {
        setNombreTarea(nombreTarea);
        setDescripcionTareas(descripcion);
        setFecha(fecha);
        setPrioridad(prioridad);
        setLista(lista);
        if(progreso==100) {
            this.completado=true;
        } else {
            this.completado=false;
        }
        setProgreso(progreso);
    }
    /**
     * Getter del nombre de la tarea
     * 
     * @return un String con el nombre de la tarea
     */
    public String getNombreTarea() {
        return nombreTarea;
    }

    /**
     * Getter de la descripcion de la tarea
     * 
     * @return un String con la descripcion de la tarea
     */
    public String getDescripcionTareas() {
        return descripcionTareas;
    }

    /**
     * Getter de la fecha de fin prevista de la tarea
     * 
     * @return un Date con la fecha de fin prevista de la tarea
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Getter de la prioridad de la tarea
     * 
     * @return un String con el valor de la prioridad de la tarea
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Getter del progreso de la tarea
     * 
     * @return un int con el valor del progreso de la tarea
     */
    public int getProgreso() {
        return progreso;
    }
    
    public String getLista() {
        return lista;
    }
 
    /**
     * Getter de completado
     * 
     * @return un boolean que devuelve False si no esta completada la tarea o True si esta completada
     */
    public boolean isCompletado() {
        return completado;
    }
    
    /**
     * Setter del nombre de la tarea
     * 
     * @param nombreTarea:  String que se refiere nombre que se asigna a la tarea
     * @throws IllegalArgumentException si nombreTarea son caracteres en blanco
     * @throws IllegalArgumentException si nombreTarea tiene más de 10 caracteres o menos de 1
     */
    public void setNombreTarea(String nombreTarea) {
        if (nombreTarea.trim().isEmpty()) { 
            throw new IllegalArgumentException("El nombre de la tarea no puede ser una serie de caracteres en blanco");
        }else if(nombreTarea.length()>10 | nombreTarea.length()<1){
            throw new IllegalArgumentException("El nombre de la tarea debe tener entre 1 y 10 caracteres");
        }
        this.nombreTarea = nombreTarea;
    }
    
    /**
     * Setter de la descripcion
     * 
     * @param descripcion: String que se refiere a la descripcion de la tarea
     * @throws IllegalArgumentException si descripción tiene más de 100 caracteres
     */
    public void setDescripcionTareas(String descripcion) {
        if(descripcion.length()>100){
            throw new IllegalArgumentException("La descripción no puede tener más de 100 caracteres");
        }
        this.descripcionTareas = descripcion;
    }

    /**
     * Setter de la fecha
     * 
     * @param fecha: Date referida a la fecha en la que se espera que acabe la tarea
     * @throws IllegalArgumentException si fecha es incorrecta
     */
    public void setFecha(Date fecha) {
        if(fecha==null){
            throw new IllegalArgumentException("La fecha es incorrecta");
        }
        this.fecha = fecha;
    }

    /**
     * Setter de la prioridad
     * 
     * @param prioridad: String que indica la prioridad de la tarea
     * @throws IllegalArgumentException si prioridad no es "Baja", "Media" o "Alta"
     */
    public void setPrioridad(String prioridad) {
        if(!(prioridad.equals("Baja") | prioridad.equals("Media") | prioridad.equals("Alta"))){
            throw new IllegalArgumentException("La prioridad debe ser Baja, Media o Alta");
        }
        this.prioridad = prioridad;
    }

    /**
     * Setter de progreso
     * 
     * @param progreso: int que indica el progreso de la tarea
     * @throws IllegalArgumentException si progreso no está entre 0 y 100 y completado es false
     */
    public void setProgreso(int progreso) {
        if(progreso<0 | progreso>100){
            throw new IllegalArgumentException("El progreso debe estar entre 0 y 100");
        }
        if(!this.completado){
            if(progreso<0 | progreso>100){
                throw new IllegalArgumentException("El progreso debe estar entre 0 y 100");
            }
            this.progreso = progreso;
        }else{
            this.progreso=100;
        }
    }

    /**
     * Setter de completado
     * 
     * @param completado: boolean que indica si la tarea ha sido completada
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
        setProgreso(this.progreso);
    }
    
    /**
     * Setter de lista
     * 
     * @param lista: String que indica el nombre de la lista
     */
    public void setLista(String lista) {
        this.lista = lista;
    }

    /**
     * Funcion que devuelve la descripcion de la tarea en un String para la lista de pendientes
     * 
     * @return String con el formato: nombreTarea: fecha: 
     * si completado es true "Completada" y si es false "Pendiente": dias restantes
     */
    public String stringPendiente(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        long ms = fecha.getTime() - (new Date()).getTime();
        long dias = TimeUnit.MILLISECONDS.toDays(ms);
        dias=abs(dias);
        return nombreTarea+": "+formato.format(fecha)+": Pendiente: "+dias+" dias";
    }
    
    /**
     * Funcion que devuelve la descripcion de la tarea en un String
     * 
     * @return un String con el formato: nombreTarea: fecha: 
     * si completado es true "Completada" y si es false "Pendiente"
     */
    @Override
    public String toString(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (completado) return nombreTarea+": "+formato.format(fecha)+": Completada";
        else return nombreTarea+": "+formato.format(fecha)+": Pendiente";
    }
}

