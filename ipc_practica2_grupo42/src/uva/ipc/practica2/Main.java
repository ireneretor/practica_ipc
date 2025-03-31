/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uva.ipc.practica2;
import uva.ipc.practica2.modelo.GestorListas;
import uva.ipc.practica2.vista.GestorVistas;

/**
 *Clase donde se encuentra el main e inicializa todo el programa
 * 
 * @author tomip, irereto
 */
public class Main {

    private static GestorVistas gestor;
    private static GestorListas lista;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        gestor=new GestorVistas();
        lista=new GestorListas();
        gestor.mostrarVistaMenuInicial();     
    }
    
    public static GestorVistas getGestorVistas(){
        return gestor;
    }
    
    public static GestorListas getGestorListas(){
        return lista;
    }
    
}
