/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import S_Gestion_Pacientes.dto.FRCP02FormatoDTO;
import S_Gestion_Pacientes.sop_rmi.GestionInformesInt;
import S_Gestion_Pacientes.sop_rmi.GestionUsuariosInt;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class GUIConsultarFormatoFRCP02 extends javax.swing.JFrame {

    private static GestionUsuariosInt objRemotoU1;
    private static GestionInformesInt objRemotoI1;
    private String objRol;
    /**
     * Creates new form GUIConsultarFormatoFRCP02
     * @param objRemotoI
     * @param rol
     */
    public GUIConsultarFormatoFRCP02(GestionInformesInt objRemotoI,String rol) {
        objRemotoI1 = objRemotoI;
        objRol = rol;
        initComponents();
    }
    
    public GUIConsultarFormatoFRCP02(GestionInformesInt objRemotoI) {
        objRemotoI1 = objRemotoI;
        initComponents();
    }
    
    public GUIConsultarFormatoFRCP02() {
        initComponents();
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
        lbConsultarFormatoFRCP02 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        lbIdentificacion = new javax.swing.JLabel();
        txtConsultarId = new javax.swing.JTextField();
        btnConsultarId = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtConsultarConcepto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtConsultarFechaValoracion = new javax.swing.JLabel();
        txtConsultarProfesion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtConsultarNombreProfesional = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsultarObservaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbConsultarFormatoFRCP02.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lbConsultarFormatoFRCP02.setText("Consultar Formato FRCP-02");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        lbIdentificacion.setText("Identificación:");

        txtConsultarId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsultarIdKeyTyped(evt);
            }
        });

        btnConsultarId.setText("Consultar");
        btnConsultarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIdActionPerformed(evt);
            }
        });

        jLabel1.setText("Concepto:");

        txtConsultarConcepto.setText("-");

        jLabel3.setText("Fecha de Valoración: ");

        txtConsultarFechaValoracion.setText("-");

        txtConsultarProfesion.setText("-");

        jLabel6.setText("Profesión: ");

        txtConsultarNombreProfesional.setText("-");

        jLabel8.setText("Nombre del Profesional: ");

        jLabel9.setText("Observaciones:");

        txtConsultarObservaciones.setColumns(20);
        txtConsultarObservaciones.setRows(5);
        txtConsultarObservaciones.setEnabled(false);
        jScrollPane1.setViewportView(txtConsultarObservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbConsultarFormatoFRCP02))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdentificacion)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(txtConsultarId, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultarId))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtConsultarNombreProfesional, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(txtConsultarProfesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtConsultarFechaValoracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtConsultarConcepto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbConsultarFormatoFRCP02)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbIdentificacion)
                        .addComponent(txtConsultarId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConsultarId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConsultarConcepto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtConsultarFechaValoracion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtConsultarProfesion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtConsultarNombreProfesional))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Esta seguro que desea salir del consultar?", "Mensaje de Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            if (objRol.equals("Medico Especialista")) {
                new GUIOpcionesMedicPsico(objRemotoU1, objRemotoI1).setVisible(true);
                super.dispose();
            }else{
                new GUIOpcionesFisio(objRemotoU1, objRemotoI1).setVisible(true);
                super.dispose();
            }
        } else {
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnConsultarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIdActionPerformed
        if (objRemotoI1 == null) {
            JOptionPane.showMessageDialog(null, "No hay conexion con el servidor.");
        }else{
            if (!txtConsultarId.getText().isEmpty()) {
                txtConsultarConcepto.setText("");
                txtConsultarFechaValoracion.setText("");
                txtConsultarProfesion.setText("");
                txtConsultarNombreProfesional.setText("");
                txtConsultarObservaciones.setText("");
                int idConsultar = Integer.parseInt(txtConsultarId.getText());
                try{  
                    int IdValido = objRemotoI1.validarIdPaciente(idConsultar);
                    if (IdValido != 0) {
                        FRCP02FormatoDTO objFormato02 = objRemotoI1.consultarPersonalFRCP02(idConsultar);
                        if (objFormato02 != null) {
                            txtConsultarConcepto.setText(objFormato02.getConcepto());
                            txtConsultarFechaValoracion.setText(objFormato02.getFechaValoracion());
                            txtConsultarProfesion.setText(objFormato02.getProfesion());
                            txtConsultarNombreProfesional.setText(objFormato02.getNombreProfesional());
                            txtConsultarObservaciones.setText(objFormato02.getObservaciones());
                        }else{
                            JOptionPane.showMessageDialog(null, "EL paciente con el id " + idConsultar + " no existe. ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "EL paciente con el id " + idConsultar + " no existe. ");
                    }
                }catch(RemoteException ex){
                    System.out.println("La operacion ha fallado, intente nuevamente...");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación válida.");
            }
        }
    }//GEN-LAST:event_btnConsultarIdActionPerformed

    private void txtConsultarIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarIdKeyTyped
        char validarNumero = evt.getKeyChar();
        if (Character.isLetter(validarNumero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se permite ingresar números.");
        }
    }//GEN-LAST:event_txtConsultarIdKeyTyped

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
            java.util.logging.Logger.getLogger(GUIConsultarFormatoFRCP02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIConsultarFormatoFRCP02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIConsultarFormatoFRCP02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIConsultarFormatoFRCP02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIConsultarFormatoFRCP02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConsultarId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbConsultarFormatoFRCP02;
    private javax.swing.JLabel lbIdentificacion;
    private javax.swing.JLabel txtConsultarConcepto;
    private javax.swing.JLabel txtConsultarFechaValoracion;
    private javax.swing.JTextField txtConsultarId;
    private javax.swing.JLabel txtConsultarNombreProfesional;
    private javax.swing.JTextArea txtConsultarObservaciones;
    private javax.swing.JLabel txtConsultarProfesion;
    // End of variables declaration//GEN-END:variables
}
