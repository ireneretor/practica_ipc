/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ipc_practica1_grupo42_vista;

import java.util.Date;
import ipc_practica1_grupo42_modelo.Modelo;
import ipc_practica1_grupo42_modelo.Tareas;
import ipc_practica1_grupo42_controlador.Controlador;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author tomip
 */
public class GestorTareas extends javax.swing.JFrame {

    private Controlador controlador;
    private Modelo modelo;

    /**
     * Creates new form GestorTareas
     */
    public GestorTareas() {
        initComponents();
        this.modelo = new Modelo();
        this.controlador = new Controlador(this, modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        descripcionLabel = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        descripcionScrollPane = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        anadirNombreTareaLabel = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        anadirNombreTareaTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        fechaLabel = new javax.swing.JLabel();
        fechaSpinner = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        prioridadLabel = new javax.swing.JLabel();
        prioridadComboBox = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        anadirProgresoLabel = new javax.swing.JLabel();
        porcentajeSpinner = new javax.swing.JSpinner();
        completadoCheckBox = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        guardarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        erroresLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        listaTareasScrollPane = new javax.swing.JScrollPane();
        listaTareasList = new javax.swing.JList<>();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        verNombreTareaLabel = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        verDescripcionJSCroll = new javax.swing.JScrollPane();
        verDescripcionTextArea = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        verFechaNoModificableLabel = new javax.swing.JLabel();
        verFechaModificableLabel = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        verPrioridadNoModificableLabel = new javax.swing.JLabel();
        verPrioridadModificableLabel = new javax.swing.JLabel();
        verProgresoLabel = new javax.swing.JLabel();
        verProgresoProgressBar = new javax.swing.JProgressBar();
        jPanel16 = new javax.swing.JPanel();
        editarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(75, 86));

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 860));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel3.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel3.setName(""); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setMinimumSize(new java.awt.Dimension(75, 50));
        jPanel5.setName(""); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        descripcionLabel.setText("Descripción:");
        jPanel19.add(descripcionLabel);

        jPanel5.add(jPanel19);

        jPanel20.setLayout(new java.awt.BorderLayout());

        descripcionScrollPane.setPreferredSize(new java.awt.Dimension(144, 86));

        descripcionTextArea.setColumns(20);
        descripcionTextArea.setRows(5);
        descripcionTextArea.setPreferredSize(new java.awt.Dimension(450, 74));
        descripcionScrollPane.setViewportView(descripcionTextArea);

        jPanel20.add(descripcionScrollPane, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel20);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setMinimumSize(new java.awt.Dimension(75, 32));
        jPanel6.setName(""); // NOI18N
        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jPanel22.setMaximumSize(new java.awt.Dimension(798, 182));
        jPanel22.setMinimumSize(new java.awt.Dimension(37, 26));
        jPanel22.setPreferredSize(new java.awt.Dimension(350, 26));
        jPanel22.setRequestFocusEnabled(false);
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        anadirNombreTareaLabel.setText("Nombre de la tarea");
        anadirNombreTareaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel22.add(anadirNombreTareaLabel);

        jPanel6.add(jPanel22);

        jPanel21.setMinimumSize(new java.awt.Dimension(37, 32));
        jPanel21.setName(""); // NOI18N
        jPanel21.setLayout(new java.awt.BorderLayout());

        anadirNombreTareaTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        anadirNombreTareaTextField.setMinimumSize(new java.awt.Dimension(64, 32));
        anadirNombreTareaTextField.setName(""); // NOI18N
        anadirNombreTareaTextField.setPreferredSize(new java.awt.Dimension(450, 32));
        jPanel21.add(anadirNombreTareaTextField, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel21);

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel3);

        jPanel4.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel4.setName(""); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(4, 0));

        jPanel7.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel7.setName(""); // NOI18N
        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jPanel17.setMinimumSize(new java.awt.Dimension(37, 32));
        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        fechaLabel.setText("Fecha: ");
        jPanel17.add(fechaLabel);

        fechaSpinner.setModel(new javax.swing.SpinnerDateModel());
        fechaSpinner.setEditor(new javax.swing.JSpinner.DateEditor(fechaSpinner, "dd/MM/yy"));
        jPanel17.add(fechaSpinner);

        jPanel7.add(jPanel17);

        jPanel18.setMinimumSize(new java.awt.Dimension(37, 32));
        jPanel18.setName(""); // NOI18N
        jPanel18.setPreferredSize(new java.awt.Dimension(450, 32));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        prioridadLabel.setText("Prioridad");
        jPanel18.add(prioridadLabel);

        prioridadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Media", "Alta" }));
        jPanel18.add(prioridadComboBox);

        jPanel7.add(jPanel18);

        jPanel4.add(jPanel7);

        jPanel8.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel8.setName(""); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(550, 32));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        anadirProgresoLabel.setText("Progreso:");
        jPanel8.add(anadirProgresoLabel);

        porcentajeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        porcentajeSpinner.setMinimumSize(new java.awt.Dimension(60, 22));
        porcentajeSpinner.setName(""); // NOI18N
        porcentajeSpinner.setPreferredSize(new java.awt.Dimension(60, 22));
        jPanel8.add(porcentajeSpinner);

        completadoCheckBox.setText("Completado");
        jPanel8.add(completadoCheckBox);

        jPanel4.add(jPanel8);

        jPanel9.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel9.setName(""); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(550, 33));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });
        jPanel9.add(guardarButton);

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });
        jPanel9.add(limpiarButton);

        jPanel4.add(jPanel9);

        erroresLabel.setForeground(new java.awt.Color(204, 0, 51));
        jPanel23.add(erroresLabel);

        jPanel4.add(jPanel23);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 860));
        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jPanel10.setLayout(new java.awt.BorderLayout());

        listaTareasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTareasList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTareasListValueChanged(evt);
            }
        });
        listaTareasScrollPane.setViewportView(listaTareasList);

        jPanel10.add(listaTareasScrollPane, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel10);

        jPanel11.setMinimumSize(new java.awt.Dimension(75, 86));
        jPanel11.setLayout(new java.awt.GridLayout(5, 0));

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel12.add(verNombreTareaLabel);

        jPanel11.add(jPanel12);

        jPanel13.setLayout(new java.awt.BorderLayout());

        verDescripcionJSCroll.setEnabled(false);

        verDescripcionTextArea.setEditable(false);
        verDescripcionTextArea.setColumns(20);
        verDescripcionTextArea.setRows(5);
        verDescripcionJSCroll.setViewportView(verDescripcionTextArea);

        jPanel13.add(verDescripcionJSCroll, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        verFechaNoModificableLabel.setText("Fecha");
        jPanel14.add(verFechaNoModificableLabel);
        jPanel14.add(verFechaModificableLabel);

        jPanel11.add(jPanel14);

        jPanel15.setMinimumSize(new java.awt.Dimension(50, 26));
        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        verPrioridadNoModificableLabel.setText("Prioridad");
        jPanel15.add(verPrioridadNoModificableLabel);
        jPanel15.add(verPrioridadModificableLabel);

        verProgresoLabel.setText("Progreso:");
        jPanel15.add(verProgresoLabel);
        jPanel15.add(verProgresoProgressBar);

        jPanel11.add(jPanel15);

        jPanel16.setMinimumSize(new java.awt.Dimension(50, 33));

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });
        jPanel16.add(editarButton);

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });
        jPanel16.add(eliminarButton);

        jPanel11.add(jPanel16);

        jPanel2.add(jPanel11);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
        controlador.procesarEventoGuardar();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        // TODO add your handling code here:
        controlador.procesarEventoEditar();
    }//GEN-LAST:event_editarButtonActionPerformed

    private void listaTareasListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaTareasListValueChanged
        // TODO add your handling code here:
        String tareaSeleccionada = listaTareasList.getSelectedValue();
        for (Tareas t : modelo.getTareas()) {
            if (t.toString().equals(tareaSeleccionada)) {
                verNombreTareaLabel.setText(t.getNombreTarea());
                verDescripcionTextArea.setText(t.getDescripcionTareas());
                verFechaModificableLabel.setText(t.getFecha().toString());
                verPrioridadModificableLabel.setText(t.getPrioridad());
                verProgresoProgressBar.setValue(t.getProgreso());
                break;
            }
        }
    }//GEN-LAST:event_listaTareasListValueChanged

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        controlador.procesarEventoEliminar();
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        // TODO add your handling code here:
        controlador.procesarEventoLimpiar();
    }//GEN-LAST:event_limpiarButtonActionPerformed

    public void actualizarTareas(ArrayList<Tareas> tareas) {
         String[] tareasArray = new String[tareas.size()];
    
        for (int i = 0; i < tareas.size(); i++) {
            tareasArray[i] = tareas.get(i).toString();
        }
        listaTareasList.setListData(tareasArray);
    }

    
    
   

    public String getNombreTarea() {
        return anadirNombreTareaTextField.getText();
    }

    public String getDescripcion() {
        return descripcionTextArea.getText();
    }

    public Date getFecha() {
        Date fecha = (Date)fechaSpinner.getValue();
        return fecha;
    }

    public String getPrioridad() {
        return (String) prioridadComboBox.getSelectedItem();
    }

    public int getProgreso() {
        return (int) porcentajeSpinner.getValue();
    }

    public boolean getCompletado() {
        return completadoCheckBox.isSelected();
    }
    
    public String getListaSeleccionada(){
        return listaTareasList.getSelectedValue();
    }
    
    
    
    
    
    
    public void setNombreTarea(String nombreTarea) {
        anadirNombreTareaTextField.setText(nombreTarea);
    }

    public void setDescripcion(String descripcion) {
        descripcionTextArea.setText(descripcion);
    }

    public void setFecha(Date fecha) {
        fechaSpinner.setValue(fecha);
    }

    public void setPrioridad(String prioridad) {
        prioridadComboBox.setSelectedItem(prioridad);
    }

    public void setProgreso(int progreso) {
        porcentajeSpinner.setValue(progreso);
    }

    public void setCompletado(boolean completado) {
        completadoCheckBox.setSelected(completado);
    }

    public void setListaSeleccionada(String listaSeleccionada) {
        listaTareasList.setSelectedValue(listaSeleccionada, true);
    }

    public void setError(String s){
        erroresLabel.setText(s);
    }

    public void limpiarCampos(){
        anadirNombreTareaTextField.setText("");
        descripcionTextArea.setText("");
        fechaSpinner.setValue(new Date());
        prioridadComboBox.setSelectedIndex(0);
        porcentajeSpinner.setValue(0);
        completadoCheckBox.setSelected(false);
        listaTareasList.clearSelection();
        verNombreTareaLabel.setText("");
        verDescripcionTextArea.setText("");
        verFechaModificableLabel.setText("");
        verPrioridadModificableLabel.setText("");
        verProgresoProgressBar.setValue(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anadirNombreTareaLabel;
    private javax.swing.JTextField anadirNombreTareaTextField;
    private javax.swing.JLabel anadirProgresoLabel;
    private javax.swing.JCheckBox completadoCheckBox;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JScrollPane descripcionScrollPane;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JButton editarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel erroresLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JSpinner fechaSpinner;
    private javax.swing.JButton guardarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JList<String> listaTareasList;
    private javax.swing.JScrollPane listaTareasScrollPane;
    private javax.swing.JSpinner porcentajeSpinner;
    private javax.swing.JComboBox<String> prioridadComboBox;
    private javax.swing.JLabel prioridadLabel;
    private javax.swing.JScrollPane verDescripcionJSCroll;
    private javax.swing.JTextArea verDescripcionTextArea;
    private javax.swing.JLabel verFechaModificableLabel;
    private javax.swing.JLabel verFechaNoModificableLabel;
    private javax.swing.JLabel verNombreTareaLabel;
    private javax.swing.JLabel verPrioridadModificableLabel;
    private javax.swing.JLabel verPrioridadNoModificableLabel;
    private javax.swing.JLabel verProgresoLabel;
    private javax.swing.JProgressBar verProgresoProgressBar;
    // End of variables declaration//GEN-END:variables
}
