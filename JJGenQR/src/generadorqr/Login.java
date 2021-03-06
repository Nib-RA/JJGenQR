package generadorqr;


import Modelos.UsuarioIngresado;
import Modelos.Validate;
import Modelos.ValoresConstantes;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import db.mysql;
import Modelos.Redimencion;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.commons.io.FileUtils;
import java.awt.Image;


public class Login extends javax.swing.JFrame {
Connection conn;
Statement sent;
UsuarioIngresado us=new UsuarioIngresado();
String user,ok="\u2714";  //Caracter unicode de visto
Validate val=new Validate();
    

    public Login() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        File directorioPrincipal = new File(ValoresConstantes.DIRECTORIO_HOST + "\\Proyectos_PHP");
        File directorioDestino = new File(getClass().getResource("/conf").getPath());
        File directorioHost = new File(ValoresConstantes.DIRECTORIO_HOST);
        if(!directorioPrincipal.exists()) try {
            FileUtils.copyDirectory(directorioDestino, directorioHost);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = mysql.getConnect();
        txtUsuario.requestFocus();
     //   String Ruta=("/images/home1.jpg").getPath();
     Redimencion cm= new Redimencion();
     cm.Mostrar_Visualizador(lblImgLogin, "/images/home1.jpg");
     Redimencion cmL= new Redimencion();
     cmL.Mostrar_Visualizador(lblIconoEscuela, "/images/iconoescuela.png");
     //Mostrar_Visualizador(lblImgLogin, "/images/home1.jpg");
        //ImageIcon icon= new ImageIcon(getClass().getResource("Imagenes/taza.jpg"));
        
        /*ImageIcon fot = new ImageIcon(getClass().getResource("/images/home1.jpg"));
       // ImageIcon fot = new ImageIcon("C:\\Users\\Jess\\Pictures\\Imagen3.jpg");
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblImgLogin.getWidth(), lblImgLogin.getHeight(), Image.SCALE_DEFAULT));
        lblImgLogin.setIcon(icono);
        this.repaint();*/
  }
   
    
    
    
    //MEtodo para realizar la consulta de contraseña y pasword para poder tener acceso 


int cont=0;
    void Acceder(){
        if(txtUsuario.getText().trim().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Ingrese Usuario");
            txtUsuario.requestFocus();
        }
        else if (txtPassword.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Ingrese contraseña"); 
            txtPassword.requestFocus();
        }
        else{
            try{
            String SQL ="SELECT * FROM USUARIOS WHERE CEDULAUSUARIO = '" + txtUsuario.getText() + "' AND CONTRASENAUSUARIO = '" + String.valueOf(txtPassword.getPassword()) + "'";                 
            String rolU,nombreU;
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(SQL);
            rs.next();
            txtPassword.setText(rs.getString("CONTRASENAUSUARIO"));
            txtUsuario.setText(rs.getString("CEDULAUSUARIO"));
            rolU=rs.getString("TIPOUSUARIO");
            nombreU=rs.getString("NOMBRESUSUARIO");
            us.setParametroU(nombreU);
            us.setParametroR(rolU);
            // ENviar parametros
            //UsuarioIngresado us=new UsuarioIngresado(rs.getString("CEDULAUSUARIO"),rs.getString("CONTRASENAUSUARIO") );
            rs.close();
            JOptionPane.showMessageDialog(null, "Bienvenid@ " +nombreU+" al Generador de QR y tu rol es de " + rolU);
            Principal fr=new Principal();
            fr.setVisible(true);
            dispose();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña inválida o pongase en contacto con el Administrador");
                //txtUsuario.setText("");
                txtPassword.setText("");
                txtPassword.requestFocus();
                cont++;
                if(cont==3) System.exit( 0 );
        }
      } 
    } 
     
           
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlJJ2016 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlMuseo = new javax.swing.JLabel();
        lblIconoEscuela = new javax.swing.JLabel();
        lblImgLogin = new javax.swing.JLabel();
        jlUsuarios = new javax.swing.JLabel();
        jlContraseña = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        lblUserValidacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jlJJ2016.setForeground(new java.awt.Color(255, 255, 255));
        jlJJ2016.setText("JJ 2016 Reservados  todos  los  derechos . ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(jlJJ2016)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jlJJ2016)
                .addGap(23, 23, 23))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(25, 14, 60));

        jPanel4.setBackground(new java.awt.Color(155, 80, 80));
        jPanel4.setMinimumSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlMuseo.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jlMuseo.setForeground(new java.awt.Color(255, 255, 255));
        jlMuseo.setText("Museo  \"ISIDRO AYORA\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jlMuseo)
                .addGap(118, 118, 118)
                .addComponent(lblIconoEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblIconoEscuela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlMuseo, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        lblImgLogin.setMaximumSize(new java.awt.Dimension(800, 600));
        lblImgLogin.setMinimumSize(new java.awt.Dimension(800, 600));
        lblImgLogin.setPreferredSize(new java.awt.Dimension(800, 600));

        jlUsuarios.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jlUsuarios.setText("Usuario");

        jlContraseña.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jlContraseña.setText("Contraseña");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(0, 0, 0));
        btnIngresar.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        lblUserValidacion.setText("CI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(lblImgLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlUsuarios)
                            .addComponent(jlContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblUserValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblImgLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlUsuarios)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUserValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlContraseña)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        //se asegura de capturar la tecla ENTER y descartar todas las demas
        char cTeclaPresionada=evt.getKeyChar();
        //Da click al boton aceptar al detectar la tecla ENTER
        if(cTeclaPresionada==KeyEvent.VK_ENTER) btnIngresar.doClick();
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        //se asegura de caprturar la tecla ENTER y descartar todas las demas
        char cTeclaPresionada=evt.getKeyChar();
        //Da click al boton aceptar aldetectar la tecla ENTER
        if(cTeclaPresionada==KeyEvent.VK_ENTER){
            btnIngresar.doClick();
        }
        char car=evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
        int limite  = 10;
        if (txtUsuario.getText().length()== limite)              evt.consume();
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:
        if (txtUsuario.getText().length()==10){
            try{
                String SQLU ="SELECT * FROM USUARIOS WHERE CEDULAUSUARIO Like '%" + txtUsuario.getText().toString().trim() + "%'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(SQLU);
                rs.next();
                user = rs.getString("CEDULAUSUARIO");
                if(!Validate.validadorDeCedula(user)) lblUserValidacion.setText("Usuario inexistente");
                else lblUserValidacion.setText(ok);
                rs.close();
            }
            catch(Exception e){
            }
        } else lblUserValidacion.setText("CI");
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Acceder();
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlContraseña;
    private javax.swing.JLabel jlJJ2016;
    private javax.swing.JLabel jlMuseo;
    private javax.swing.JLabel jlUsuarios;
    public static javax.swing.JLabel lblIconoEscuela;
    private javax.swing.JLabel lblImgLogin;
    private javax.swing.JLabel lblUserValidacion;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
