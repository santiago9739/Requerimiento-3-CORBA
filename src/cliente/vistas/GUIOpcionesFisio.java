/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import S_Gestion_Pacientes.sop_rmi.GestionInformesInt;
import S_Gestion_Pacientes.sop_rmi.GestionUsuariosInt;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class GUIOpcionesFisio extends javax.swing.JFrame {

    private static GestionUsuariosInt objRemotoU1;
    private static GestionInformesInt objRemotoI1;
    /**
     * Creates new form GUIOpcionesFisio
     * @param objRemotoU
     * @param objRemotoI
     */
    public GUIOpcionesFisio(GestionUsuariosInt objRemotoU, GestionInformesInt objRemotoI) {
        objRemotoU1 = objRemotoU;
        objRemotoI1 = objRemotoI;
        initComponents();
    }
    
    public GUIOpcionesFisio() {
        initComponents();
    }
    
    public void mostrarMensajeCallBackFisio(String nombreCompleto, int id) throws InterruptedException {
        String mensaje = "*** El usuario ["+ nombreCompleto +"] Identificado con id ["+ id +"] Ingresó a la aplicación. *** \n \n";
        lbMensajeCllBack.setText(lbMensajeCllBack.getText() + mensaje);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        lbMenuValoracion = new javax.swing.JLabel();
        btnRegistrarPaciente = new javax.swing.JButton();
        btnConsultarPaciente = new javax.swing.JButton();
        btnRegistrarReporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbMensajeCllBack = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        lbMenuValoracion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbMenuValoracion.setText("Menú Valoración");

        btnRegistrarPaciente.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnRegistrarPaciente.setText("Registrar Paciente");
        btnRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPacienteActionPerformed(evt);
            }
        });

        btnConsultarPaciente.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnConsultarPaciente.setText("Consultar Paciente");
        btnConsultarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPacienteActionPerformed(evt);
            }
        });

        btnRegistrarReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnRegistrarReporte.setText("Registrar Reporte");
        btnRegistrarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarReporteActionPerformed(evt);
            }
        });

        lbMensajeCllBack.setEnabled(false);
        jScrollPane1.setViewportView(lbMensajeCllBack);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbMenuValoracion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnRegistrarPaciente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultarPaciente)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbMenuValoracion)))
                .addGap(38, 38, 38)
                .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPacienteActionPerformed
        new GUIRegistrarFormatoFRCP02(objRemotoI1, "Fisioterapeuta").setVisible(true);
        super.dispose();
    }//GEN-LAST:event_btnRegistrarPacienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (objRemotoU1 == null) {
            JOptionPane.showMessageDialog(null, "No hay conexion con el servidor para cerrar sesión.");
        } else {
            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Esta seguro que desea cerrar sesión?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                new GUIIniciarSesion(objRemotoU1).setVisible(true);
                super.dispose();
            }
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRegistrarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarReporteActionPerformed
        new GUIRegistrarFormatoFRCP03(objRemotoI1).setVisible(true);
        super.dispose();
    }//GEN-LAST:event_btnRegistrarReporteActionPerformed

    private void btnConsultarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPacienteActionPerformed
        new GUIConsultarFormatoFRCP02(objRemotoI1,"Fisioterapeuta").setVisible(true);
        super.dispose();
    }//GEN-LAST:event_btnConsultarPacienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIOpcionesFisio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIOpcionesFisio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIOpcionesFisio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIOpcionesFisio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIOpcionesFisio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConsultarPaciente;
    private javax.swing.JButton btnRegistrarPaciente;
    private javax.swing.JButton btnRegistrarReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane lbMensajeCllBack;
    private javax.swing.JLabel lbMenuValoracion;
    // End of variables declaration//GEN-END:variables
}