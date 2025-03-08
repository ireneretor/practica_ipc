package ipc_practica1_grupo42_controlador;
import ipc_practica1_grupo42_modelo.Modelo;
import ipc_practica1_grupo42_modelo.Tareas;
import ipc_practica1_grupo42_vista.GestorTareas;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author tomip
 */
public class Controlador {
    
    private GestorTareas vista;
    private Modelo modelo;
    
    public Controlador(GestorTareas vista, Modelo modelo){
        this.vista=vista;
        this.modelo=modelo;
    }
    
    public void procesarEventoGuardar(){
        String nombreTarea=vista.getNombreTarea();
        String descripcion=vista.getDescripcion();
        LocalDate fecha=vista.getFecha();
        String prioridad=vista.getPrioridad();
        int progreso=vista.getProgreso();
        boolean completado=vista.getCompletado();
        
        if(nombreTarea.length()>10 | nombreTarea.length()<1){
            //voy a meter throws pero habria que buscar una manera mejor de procesar los errores
            throw new IllegalArgumentException("");
        }else{
            ArrayList <Tareas> todasTareas=modelo.getTareas();
            for(int i=0;i<todasTareas.size();i++){
                Tareas tarea= todasTareas.get(i);
                if(nombreTarea.equals(tarea.getNombreTarea())) {
                    throw new IllegalArgumentException("");
                }
            }
            if(descripcion.length()>100){
                throw new IllegalArgumentException("");
            }else{
                if(fecha.isAfter(LocalDate.now())){
                    throw new IllegalArgumentException("");
                }else{
                    if(!completado & (progreso<0 |progreso>100)){
                        throw new IllegalArgumentException("");
                    }else{
                        if(completado){
                            progreso=100;
                        }
                        modelo.addTarea(new Tareas(nombreTarea,descripcion,fecha,prioridad,progreso,completado));
                        vista.actualizarTareas(modelo.getTareasString());
                    }
                    
                }
            }
        }
    }
    
    public void procesarEventoEditar(){
        //TODO funcion editar
        vista.editarCamposTexto();
    }
    
    public void procesarEventoEliminar(){
        //TODO funcion eliminar
        
    }
}
