package uva.ipc.practica2.vista;
import uva.ipc.practica2.modelo.ListaTareas;
import uva.ipc.practica2.modelo.Tarea;
import java.util.Date;
import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.GestorListas;

/**
 * Clase controladora de los eventos de la vista
 * 
 * @author tomruiz, irereto
 */
public class ControladorGestorTareas {
    
    private VistaGestorTareas vista;
    private GestorListas lista;
    private int indexEditar;
    
    /**
     * Inicializador del controlador
     * 
     * @param vista: vista de la que se tomaran los valores
     */
    public ControladorGestorTareas(VistaGestorTareas vista){
        this.vista=vista;
        this.lista=Main.getGestorListas();
        this.indexEditar=-1;
        vista.actualizarTareas(lista.getListaSeleccionada().getTareas());
        vista.actualizarListas(lista.getGestorTareas());
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
                lista.getListaSeleccionada().addTarea(new Tarea(nombreTarea,descripcion,fecha,prioridad,progreso));
                vista.actualizarTareas(lista.getListaSeleccionada().getTareas());
                vista.setError("");
                indexEditar=-1;
                vista.limpiarCampos();
            }catch(IllegalArgumentException e){
                vista.setError(e.getMessage());
            }
        }else{
            try{
                lista.getListaSeleccionada().editarTarea(indexEditar, new Tarea(nombreTarea,descripcion,fecha,prioridad,progreso));
                vista.actualizarTareas(lista.getListaSeleccionada().getTareas());
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
            for (Tarea t : lista.getListaSeleccionada().getTareas()) {
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
        if (tareaSeleccionada==null) {
            vista.setError("Tienes que seleccionar una tarea para eliminar");
        }else {
            int i=0;
            for (Tarea t : lista.getListaSeleccionada().getTareas()) {
                if (t.toString().equals(tareaSeleccionada)) {
                    lista.getListaSeleccionada().eliminarTarea(i);
                    break;
                }
                i++;
            }
            indexEditar=-1;
            vista.actualizarTareas(lista.getListaSeleccionada().getTareas());
            vista.limpiarCampos();
        }
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
        for (Tarea t : lista.getListaSeleccionada().getTareas()) {
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
