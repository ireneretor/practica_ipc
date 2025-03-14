package ipc_practica1_grupo42_vista;
import ipc_practica1_grupo42_modelo.GestorTareas;
import ipc_practica1_grupo42_modelo.Tarea;
import ipc_practica1_grupo42_vista.Vista;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author tomip
 */
public class Controlador {
    
    private Vista vista;
    private GestorTareas modelo;
    private int indexEditar;
    
    public Controlador(Vista vista, GestorTareas modelo){
        this.vista=vista;
        this.modelo=modelo;
        this.indexEditar=-1;
    }
    
    public void procesarEventoGuardar(){
        String nombreTarea=vista.getNombreTarea();
        String descripcion=vista.getDescripcion();
        Date fecha=vista.getFecha();
        String prioridad=vista.getPrioridad();
        int progreso=vista.getProgreso();
        boolean completado=vista.getCompletado();
        if(indexEditar==-1){
            try{
                modelo.addTarea(new Tarea(nombreTarea,descripcion,fecha,prioridad,progreso,completado));
                vista.actualizarTareas(modelo.getTareas());
                vista.setError("");
                indexEditar=-1;
                vista.limpiarCampos();
            }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
            }
        }else{
            try{
                modelo.editarTarea(indexEditar, new Tarea(nombreTarea,descripcion,fecha,prioridad,progreso,completado));
                vista.actualizarTareas(modelo.getTareas());
                vista.setError("");
                vista.limpiarCampos();
            }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
            }
        }
    }
    
    public void procesarEventoEditar(){
        String tareaSeleccionada=vista.getListaSeleccionada();
        if (tareaSeleccionada == null) {
            vista.setError("Tienes que seleccionar una tarea para editar");
        } else {
            int i=0;
            for (Tarea t : modelo.getTareas()) {
                if (t.toString().equals(tareaSeleccionada)) {
                    vista.setNombreTarea(t.getNombreTarea());
                    vista.setDescripcion(t.getDescripcionTareas());
                    vista.setFecha(t.getFecha());
                    vista.setPrioridad(t.getPrioridad());
                    vista.setProgreso(t.getProgreso());
                    if (t.getProgreso() == 100) {
                        vista.setCompletado(true);
                        vista.setSpinnerVisible(false);
                    } else {
                        vista.setCompletado(false);
                        vista.setSpinnerVisible(true);
                    }
                    indexEditar=i;
                    break;
                }
                i++;
            }
        }
    }
    
    
    public void procesarEventoEliminar(){
        //TODO funcion eliminar
        String tareaSeleccionada=vista.getListaSeleccionada();
        if (tareaSeleccionada == null) {
            vista.setError("Tienes que seleccionar una tarea para eliminar");
        } else {
            int i=0;
            for (Tarea t : modelo.getTareas()) {
                if (t.toString().equals(tareaSeleccionada)) {
                    modelo.eliminarTarea(i);
                    break;
                }
                i++;
            }
        }
        vista.actualizarTareas(modelo.getTareas());
        vista.limpiarCampos();
    }
    
    public void procesarEventoLimpiar(){
        vista.limpiarCampos();
    }
    
    public void procesarEventoSeleccionarTarea(String tareaSeleccionada){
        for (Tarea t : modelo.getTareas()) {
            if (t.toString().equals(tareaSeleccionada)) {
                vista.cambiarCamposNoModificables(t);
                break;
            }
        }
    }
    
    public void procesarEventoCompletado(){
        if(vista.getCompletado()) {
            vista.setProgreso(100);
            vista.setSpinnerVisible(false);
        } else {
            vista.setProgreso(0);
            vista.setSpinnerVisible(true);
        }
    }
}
