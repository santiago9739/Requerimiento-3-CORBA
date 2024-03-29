/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import Cliente.sop_rmi.AdminCllbckImpl;
import S_Gestion_Pacientes.dto.RegistroDTO;
import S_Gestion_Pacientes.sop_rmi.GestionInformesInt;
import S_Gestion_Pacientes.sop_rmi.GestionUsuariosInt;
import S_Seguimiento_Pacientes.sop_rmi.GestionNotificacionesInt;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import plugins.TextPrompt;

/**
 *
 * @author Luis Romero - Santiago Cordoba
 */
public class GUIIniciarSesion extends javax.swing.JFrame {
    
    private static GestionUsuariosInt objRemotoU1;
    private static GestionInformesInt objRemotoI1;
    private static GestionNotificacionesInt objRemotoNt1;
    private String userAdministrador = "admin123";
    private String contrasenaAdministrador = "admin123";
    
    public GUIIniciarSesion(GestionUsuariosInt objRemotoU) {
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt textUsuario = new TextPrompt("Usuario", txtUsuario);
        TextPrompt textContrasenia = new TextPrompt("Contrasenia", txtContrasena);
    }
    
    public GUIIniciarSesion(GestionUsuariosInt objRemotoU, GestionInformesInt objRemotoI, GestionNotificacionesInt objRemotoNt) {
        objRemotoU1 = objRemotoU;
        objRemotoI1 = objRemotoI;
        objRemotoNt1 = objRemotoNt;
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt textUsuario = new TextPrompt("Usuario", txtUsuario);
        TextPrompt textContrasenia = new TextPrompt("Contrasenia", txtContrasena);
    }
    
    public GUIIniciarSesion(GestionInformesInt objRemotoI) {
        objRemotoI1 = objRemotoI;
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt textUsuario = new TextPrompt("Usuario", txtUsuario);
        TextPrompt textContrasenia = new TextPrompt("Contrasenia", txtContrasena);
    }
    
    public GUIIniciarSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt textUsuario = new TextPrompt("Usuario", txtUsuario);
        TextPrompt textContrasenia = new TextPrompt("Contrasenia", txtContrasena);
    }
    
    public boolean validarAlfanumerico(String texto) {
        boolean bandera = false;
        char textoIngresado;
        byte conNumero = 0, conLetra = 0;
        for (byte i = 0; i < texto.length(); i++) {
            textoIngresado = texto.charAt(i);
            String aux = String.valueOf(textoIngresado);

            if (aux.matches("[a-z]") || aux.matches("[A-Z]")) {
                conLetra++;
            } else if (aux.matches("[0-9]")) {
                conNumero++;
            }
        }
        if (conNumero > 0 && conLetra > 0) {
            bandera = true;
        }
        return bandera;
    }
    
    private void opcion1MedicPsico() throws RemoteException {
        new GUIOpcionesMedicPsico(objRemotoU1,objRemotoI1).setVisible(true);
        super.dispose(); 

    }
    
    private void opcion1Fisio() throws RemoteException {
        
           new GUIOpcionesFisio(objRemotoU1,objRemotoI1).setVisible(true);
           super.dispose(); 

    }
    
    private void opcion3AdminRecep() throws RemoteException {
        new GUIOpcionesAdminRecep(objRemotoU1,objRemotoI1).setVisible(true);
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIniciarSesion = new javax.swing.JPanel();
        lbIniciarSesion = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lbContrasena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbIniciarSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lbIniciarSesion.setText("Iniciar Sesión");

        txtUsuario.setText("admin123");

        txtContrasena.setText("admin123");

        btnIniciarSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N

        lbContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrasenas.png"))); // NOI18N

        javax.swing.GroupLayout pnlIniciarSesionLayout = new javax.swing.GroupLayout(pnlIniciarSesion);
        pnlIniciarSesion.setLayout(pnlIniciarSesionLayout);
        pnlIniciarSesionLayout.setHorizontalGroup(
            pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIniciarSesionLayout.createSequentialGroup()
                .addGroup(pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIniciarSesionLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lbIniciarSesion))
                    .addGroup(pnlIniciarSesionLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnIniciarSesion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIniciarSesionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsuario)
                            .addComponent(lbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlIniciarSesionLayout.setVerticalGroup(
            pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIniciarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIniciarSesion)
                .addGap(57, 57, 57)
                .addGroup(pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnlIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        if (objRemotoU1 == null && objRemotoI1 == null && objRemotoNt1 == null) {
            JOptionPane.showMessageDialog(null, "No hay conexion con el servidor.");
        }else{
            if (txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El usuario y/o contraseña tiene que ser de 8 caracteres.");
            } else {
                if (txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ningun campo de texto puede estar vacío.");
                } else if (validarAlfanumerico(txtUsuario.getText()) && validarAlfanumerico(txtContrasena.getText())) {
                    if (txtUsuario.getText().equals(userAdministrador) && txtContrasena.getText().equals(contrasenaAdministrador)) {
                        new GUIAdministrador(objRemotoU1).setVisible(true);
                        super.dispose();
                    } else {
                        try {
                        boolean UsuarioValido = objRemotoU1.validarUsuario(txtUsuario.getText(),txtContrasena.getText());
                        
                        if (UsuarioValido == true) {
                            int opcion = objRemotoU1.consultarRol(txtUsuario.getText(), txtContrasena.getText());
                            if (opcion == 1) {
                                opcion1MedicPsico();
                            }
                            if (opcion == 2) {
                                opcion1Fisio();
                            }
                            
                            if (opcion == 3) {
                                opcion3AdminRecep();
                            }

                            if (opcion == 0) {
                                JOptionPane.showMessageDialog(null, "Usuario y/o Contrasenia incorrecta.");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Usuario y/o Contrasenia no existen.");
                        }
                    } catch (RemoteException ex) {
                        System.out.println("Error");
                    }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario y/o contrasenia deben ser alfanumericas.");
                }
            }
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(GUIIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIIniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbIniciarSesion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlIniciarSesion;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
