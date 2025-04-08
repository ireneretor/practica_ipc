package uva.ipc.practica2.vista;
import uva.ipc.practica2.modelo.ListaTareas;
import uva.ipc.practica2.modelo.Tarea;
import java.util.Date;
import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.GestorListas;

/**
 * Clase controladora de los eventos de la vista del gestor de tareas
 * 
 * @author tomruiz, irereto
 */
public class ControladorGestorTareas {
    
    private VistaGestorTareas vista;
    private GestorListas lista;
    private int indexEditar;
    private int indexLista;
    
    /**
     * Inicializador del controlador
     * 
     * @param vista: vista de la que se tomaran los valores
     */
    public ControladorGestorTareas(VistaGestorTareas vista){
        this.vista=vista;
        this.lista=Main.getGestorListas();
        this.indexEditar=-1;
        vista.actualizarTareas(lista.getTodasTareas());
        vista.actualizarListas(lista.getGestorListas());
    }
    
    /**
     * Funcion para procesar el guardado de las tareas en el modelo con los valores obtenidos de la vista
     */
    public void procesarEventoGuardar(){
        String nombreTarea=vista.getNombreTarea();
        String descripcion=vista.getDescripcion();
        Date fecha=vista.getFecha();
        String prioridad=vista.getPrioridad();
        String lista=vista.getLista();
        int progreso=vista.getProgreso();
        if(lista != null) {
            if(indexEditar==-1){
                try{
                    this.lista.getListaSeleccionada().addTarea(new Tarea(nombreTarea,descripcion,fecha,prioridad,progreso, lista));
                    vista.actualizarTareas(this.lista.getTodasTareas());
                    indexEditar=-1;
                    vista.limpiarCampos();
                    vista.errorVerde();
                    vista.setError("Tarea guardada con éxito");
                }catch(IllegalArgumentException e){
                    vista.errorRojo();
                    vista.setError(e.getMessage());
                    if(e.getMessage().equals("La descripción no puede tener más de 100 caracteres")){
                        vista.descripcionRojo();
                    }else if(e.getMessage().equals("La fecha es incorrecta")){
                        vista.fechaRojo();
                    }else{
                        vista.nombreRojo();
                    }
                }
            }else{
                try{
                    this.lista.getListaSeleccionada().editarTarea(indexLista, new Tarea(nombreTarea,descripcion,fecha,prioridad,progreso,lista));
                    vista.actualizarTareas(this.lista.getTodasTareas());
                    vista.limpiarCampos();
                    vista.errorVerde();
                    vista.setError("Tarea editada con éxito");
                }catch(IllegalArgumentException e){
                    vista.errorRojo();
                    vista.setError(e.getMessage());
                    if(e.getMessage().equals("La descripción no puede tener más de 100 caracteres")){
                        vista.descripcionRojo();
                    }else if(e.getMessage().equals("La fecha es incorrecta")){
                        vista.fechaRojo();
                    }else{
                        vista.nombreRojo();
                    }
                }
            }
        }else{
            vista.errorRojo();
            vista.setError("No hay ninguna lista creada");
        }
    }
    
    /**
     * Funcion para procesar la edicion de las tareas, poniendo los valores de la tarea seleccionada en la vista para poder ser editada
     */
    public void procesarEventoEditar(){
        String tareaSeleccionada=vista.getTareaSeleccionada();
        try{
            int i=lista.buscarTarea(tareaSeleccionada);
            Tarea t=lista.getTodasTareas().get(i);
            vista.setNombreTarea(t.getNombreTarea());
            vista.setDescripcion(t.getDescripcionTareas());
            vista.setFecha(t.getFecha());
            vista.setPrioridad(t.getPrioridad());
            vista.setProgreso(t.getProgreso());
            vista.setLista(t.getLista());
            if (t.getProgreso() == 100) {
                vista.setCompletado(true);
                vista.setSpinnerVisible(false);
            } else {
                vista.setCompletado(false);
                vista.setSpinnerVisible(true);
            }
            indexEditar=i;
            indexLista=lista.getListaSeleccionada().buscarTarea(tareaSeleccionada);
        }catch(IllegalArgumentException e){
                vista.errorRojo();
                vista.setError(e.getMessage());
                vista.listaRojo();
        }
        
    }
    
    /**
     * Funcion para procesar el eliminado de una tarea del modelo
     */
    public void procesarEventoEliminar(){
        //TODO funcion eliminar
        String tareaSeleccionada=vista.getTareaSeleccionada();
        try{
            for(ListaTareas l: lista.getGestorListas()) {
                if(l.eliminarTarea(tareaSeleccionada)){
                    break;
                }
            }
            indexEditar=-1;
            vista.actualizarTareas(lista.getTodasTareas());
            vista.limpiarCampos();
            vista.errorVerde();
            vista.setError("Tarea eliminada con éxito");
        }catch(IllegalArgumentException e){
            vista.errorRojo();
            vista.setError(e.getMessage());
            vista.listaRojo();
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
        for (Tarea t : lista.getTodasTareas()) {
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

    /**
     * Funcion para procesar el cambiar la lista seleccionada
     */
    public void procesarCambiarListaSeleccionada() {
        lista.seleccionarLista(vista.getListaSeleccionada());
    }

    /**
     * Funcion para procesar el evento que cambia la vista al gestor de listas
     */
    public void procesarEventoVistaListas() {
        Main.getGestorVistas().mostrarVistaGestorListas();
    }

    /**
     * Funcion para procesar el evento que cambia la vista al menu principal
     */
    public void procesarEventoVistaMenu() {
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }
}
