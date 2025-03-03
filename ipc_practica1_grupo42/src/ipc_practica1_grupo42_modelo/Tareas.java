/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_practica1_grupo42_modelo;

import java.time.LocalDate;

/**
 *
 * @author tomip
 */
import java.time.LocalDate;

public class Tareas {
    private String nombreTarea;
    private String descripcionTareas;
    private LocalDate fecha;
    private String prioridad;
    private int progreso;
    private boolean completado;
    
    public Tareas(String nombreTarea, String descripcion, LocalDate fecha, String prioridad, int progreso, boolean completado) {
        this.nombreTarea = nombreTarea;
        this.descripcionTareas = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.progreso = progreso;
        this.completado = completado;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public String getDescripcionTareas() {
        return descripcionTareas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int getProgreso() {
        return progreso;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public void setDescripcionTareas(String descripcionTareas) {
        this.descripcionTareas = descripcionTareas;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

}

