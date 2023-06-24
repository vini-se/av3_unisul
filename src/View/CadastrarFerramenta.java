package View;

import Model.Ferramenta;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastrarFerramenta extends javax.swing.JFrame {

    private final Ferramenta objFerramenta; // cria o v�nculo com o Ferramenta.java

    public CadastrarFerramenta() {
        this.objFerramenta = new Ferramenta(); // carrega objeto vazio de ferramenta
        initComponents();
        setIconImage(getIconImage());
    }
    
    public final Image getIconImage(){
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Helpers/assets/Log.png"));
        return icon;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        c_marca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_custo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Cadastro de ferrameta");
        setResizable(false);

        jLabel1.setText("Nome:");

        c_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nomeActionPerformed(evt);
            }
        });

        b_cadastrar.setText("Cadastrar");
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        c_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_marcaActionPerformed(evt);
            }
        });

        jLabel4.setText("Marca:");

        c_custo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_custoActionPerformed(evt);
            }
        });

        jLabel5.setText("Custo de aquisição:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(b_cancelar)
                        .addGap(52, 52, 52)
                        .addComponent(b_cadastrar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c_custo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_custo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cadastrar)
                    .addComponent(b_cancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void c_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nomeActionPerformed

    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarActionPerformed

        try {
            // recebendo e validando dados da interface gr�fica.
            String nome = "";
            String marca = "";
            double custo = 0;

            if (this.c_nome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.c_nome.getText();            
            }

            if (this.c_custo.getText().length() <= 0) {
                throw new Mensagens("Custo deve ser número e maior que zero.");
            } else {
                custo = Double.parseDouble(this.c_custo.getText());  
            }
            
            if (this.c_marca.getText().length() < 2) {
                throw new Mensagens("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.c_marca.getText();
            }
            
            

            // envia os dados para o Controlador cadastrar
            if (this.objFerramenta.InsertFerramentaDB(marca, custo, nome)) {
                JOptionPane.showMessageDialog(rootPane, "Ferramenta Cadastrada com Sucesso!");

                // limpa campos da interface
                this.c_nome.setText("");
                this.c_custo.setText("");
                this.c_marca.setText("");

            }

            System.out.println(this.objFerramenta.getListaFerramentas().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, erro2);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFerramenta.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_b_cadastrarActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        // TODO add your handling code here:
       
        this.setVisible(false);
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void c_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_marcaActionPerformed

    private void c_custoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_custoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_custoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_custo;
    private javax.swing.JTextField c_marca;
    private javax.swing.JTextField c_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
