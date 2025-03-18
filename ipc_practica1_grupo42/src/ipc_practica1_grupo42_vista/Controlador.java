package ipc_practica1_grupo42_vista;
import ipc_practica1_grupo42_modelo.GestorTareas;
import ipc_practica1_grupo42_modelo.Tarea;
import java.util.Date;

/**
 * Clase controladora de los eventos de la vista
 * 
 * @author tomruiz, irereto
 */
public class Controlador {
    
    private Vista vista;
    private GestorTareas modelo;
    private int indexEditar;
    
    /**
     * Inicializador del controlador
     * 
     * @param vista: vista de la que se tomaran los valores
     * @param modelo: modelo en el que se almacenan las tareas
     */
    public Controlador(Vista vista, GestorTareas modelo){
        this.vista=vista;
        this.modelo=modelo;
        this.indexEditar=-1;
    }
    
    /**
     * Funcion para procesar el guardado de las tareas en el modelo con los valores obtenidos de la vista
     */
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
    
    /**
     * Funcion para procesar la edicion de las tareas, poniendo los valores de la tarea seleccionada en la vista para poder ser editada
     */
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
    
    /**
     * Funcion para procesar el eliminado de una tarea del modelo
     */
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
        indexEditar=-1;
        vista.actualizarTareas(modelo.getTareas());
        vista.limpiarCampos();
    }
    
    /**
     * Funcion para procesar el limpiado de los campos de la vista
     */
    public void procesarEventoLimpiar(){
        vista.limpiarCampos();
    }
    
    
    /**
     * Funcion para procesar el evento de seleccionar una tarea y cambiar los campos no modificables de la vista
     * 
     * @param tareaSeleccionada: toString de la tarea seleccionada en la vista
     */
    public void procesarEventoSeleccionarTarea(String tareaSeleccionada){
        for (Tarea t : modelo.getTareas()) {
            if (t.toString().equals(tareaSeleccionada)) {
                vista.cambiarCamposNoModificables(t);
                break;
            }
        }
    }
    
    /**
     * Funcion para procesar la desactivacion del spinner de progreso y la puesta de su valor a 100,
     * en caso de que se presione el comboBox de completado
     */
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
