package ipc_practica1_grupo42_controlador;
import ipc_practica1_grupo42_modelo.Modelo;
import ipc_practica1_grupo42_modelo.Tareas;
import ipc_practica1_grupo42_vista.GestorTareas;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author tomip
 */
public class Controlador {
    
    private GestorTareas vista;
    private Modelo modelo;
    private int indexEditar;
    
    public Controlador(GestorTareas vista, Modelo modelo){
        this.vista=vista;
        this.modelo=modelo;
        this.indexEditar=-1;
    }
    
    public void procesarEventoGuardar(){
        String nombreTarea=vista.getNombreTarea();
        String descripcion=vista.getDescripcion();
        Date fecha=vista.getFecha();
        Date fechaActual=new Date();
        String prioridad=vista.getPrioridad();
        int progreso=vista.getProgreso();
        boolean completado=vista.getCompletado();
        
        if(nombreTarea.length()>10 | nombreTarea.length()<1){
            vista.setError("El nombre de la tarea debe tener entre 1 y 10 caracteres");
        }else{
            ArrayList <Tareas> todasTareas=modelo.getTareas();
            for(int i=0;i<todasTareas.size();i++){
                if(i!=indexEditar){
                    Tareas tarea= todasTareas.get(i);
                    if(nombreTarea.equals(tarea.getNombreTarea())) {
                        vista.setError("Dos tareas no pueden tener el mismo nombre");
                        return;
                    }
                }
            }
            if(descripcion.length()>100){
                    vista.setError("La descripción no puede tener más de 100 caracteres");
            }else{
                if(fecha.before(fechaActual)){
                    vista.setError("La fecha fijada no puede ser anterior a hoy");
                }else{
                    if(completado){
                        progreso=100;
                    }
                    if(indexEditar==-1){
                        modelo.addTarea(new Tareas(nombreTarea,descripcion,fecha,prioridad,progreso,completado));
                    }else{
                        modelo.editarTarea(indexEditar, new Tareas(nombreTarea,descripcion,fecha,prioridad,progreso,completado));
                    }
                    vista.actualizarTareas(modelo.getTareas());
                    vista.setError("");
                    indexEditar=-1;
                    vista.limpiarCampos();
                }
            }
        }
    }
    
    public void procesarEventoEditar(){
        String tareaSeleccionada=vista.getListaSeleccionada();
        if (tareaSeleccionada == null) {
            vista.setError("Tienes que seleccionar una tarea para editar");
        } else {
            int i=0;
            for (Tareas t : modelo.getTareas()) {
                if (t.toString().equals(tareaSeleccionada)) {
                    vista.setNombreTarea(t.getNombreTarea());
                    vista.setDescripcion(t.getDescripcionTareas());
                    vista.setFecha(t.getFecha());
                    vista.setPrioridad(t.getPrioridad());
                    vista.setProgreso(t.getProgreso());
                    if (t.getProgreso() == 100) {
                        vista.setCompletado(true);
                    } else {
                        vista.setCompletado(false);
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
            vista.setError("Tienes que seleccionar una tarea para editar");
        } else {
            int i=0;
            for (Tareas t : modelo.getTareas()) {
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
        for (Tareas t : modelo.getTareas()) {
            if (t.toString().equals(tareaSeleccionada)) {
                vista.cambiarCamposNoModificables(t);
                break;
            }
        }
    }
}
