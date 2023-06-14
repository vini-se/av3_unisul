package View;

import Model.Emprestimo;
import Model.Ferramenta;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciarEmprestimo extends javax.swing.JFrame {

    private final Emprestimo objemprestimo; // cria o v�nculo com o objemprestimo
    String data_devolucao;
    int id = 0;
    int idEmprestimo = 0;

    public GerenciarEmprestimo() {
        initComponents();
        setIconImage(getIconImage());
        this.objemprestimo = new Emprestimo(); // carrega objemprestimo de emprestimo
        this.carregaTabela();
    }
    
    public final Image getIconImage(){
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Helpers/assets/Log.png"));
        return icon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        b_cancelar = new javax.swing.JButton();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        c_DataDevolucao = new com.toedter.calendar.JDateChooser();

        setTitle("Gerenciamento de Emprestimos");
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "idFerramenta", "Ferramenta", "Data de empréstimo", "Data de devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmprestimos);
        if (jTableEmprestimos.getColumnModel().getColumnCount() > 0) {
            jTableEmprestimos.getColumnModel().getColumn(0).setMinWidth(0);
            jTableEmprestimos.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableEmprestimos.getColumnModel().getColumn(1).setMinWidth(100);
            jTableEmprestimos.getColumnModel().getColumn(2).setMinWidth(0);
            jTableEmprestimos.getColumnModel().getColumn(2).setMaxWidth(0);
            jTableEmprestimos.getColumnModel().getColumn(3).setMinWidth(100);
            jTableEmprestimos.getColumnModel().getColumn(4).setMinWidth(100);
            jTableEmprestimos.getColumnModel().getColumn(5).setMinWidth(100);
        }

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });

        b_apagar.setText("Marcar devolução");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nova data de devolução");

        c_DataDevolucao.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                c_DataDevolucaoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_cancelar)
                .addGap(18, 18, 18)
                .addComponent(b_alterar)
                .addGap(18, 18, 18)
                .addComponent(b_apagar)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c_DataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_DataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar)
                    .addComponent(b_alterar)
                    .addComponent(b_apagar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Gerenciamento de Alunos");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterarActionPerformed

    String datePicked = this.c_DataDevolucao.getDate().toString();

    SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
    // Parse the input date string
    Date date;
    try {
        date = inputFormat.parse(datePicked);
    } catch (java.text.ParseException e) {
        e.printStackTrace();
        return;
    }

    // Specify the desired output format
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Format the date to the desired output format
    this.data_devolucao = outputFormat.format(date);

        try {

            if (this.jTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Emprestimo para Alterar");
            } else {
                id = Integer.parseInt(this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0).toString());
            }

//             envia os dados para o Emprestimo processar
            if (this.objemprestimo.UpdateEmprestimoDB(id, data_devolucao)) {

                // limpa os campos
                JOptionPane.showMessageDialog(rootPane, "Emprestimo Alterado com Sucesso!");

            }
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_b_alterarActionPerformed

    private void jTableEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmprestimosMouseClicked

        if (this.jTableEmprestimos.getSelectedRow() != -1) {

            this.id = (int) this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0);
            this.idEmprestimo = (int) this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 2);

        }
    }//GEN-LAST:event_jTableEmprestimosMouseClicked

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed
        try {
            // validando dados da interface gr�fica.
            int id = 0;
            if (this.jTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Emprestimo para marcar a devolução");
            } else {
                id = Integer.parseInt(this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro bot�o | 1 -> segundo bot�o | 2 -> terceiro botão
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja marcar esta devolução?");

            if (resposta_usuario == 0) {// clicou em SIM
                
                Ferramenta objFerramenta = new Ferramenta();
                
                // envia os dados para o Amigo processar
                if (this.objemprestimo.DeleteEmprestimoDB(id) && objFerramenta.UpdateFerramentaEmprestimoDB(0, this.idEmprestimo)) {

                    JOptionPane.showMessageDialog(rootPane, "Empréstimo Apagado com Sucesso!");

                }
            }

//            System.out.println(this.objemprestimo.getListaEmprestimos().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_b_apagarActionPerformed

    private void c_DataDevolucaoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_c_DataDevolucaoPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_c_DataDevolucaoPropertyChange
   
    
    /**
     */
    @SuppressWarnings("unchecked")
    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTableEmprestimos.getModel();
        modelo.setNumRows(0);

        ArrayList<Emprestimo> minhalista = new ArrayList<>();
        minhalista = objemprestimo.getListaEmprestimo();

        for (Emprestimo a : minhalista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNomeAmigo(),
                a.getFerramenta_id(),
                a.getNomeFerramenta(),
                a.getData_emprestimo(),
                a.getData_devolucao()
            });
        }
    }

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
            java.util.logging.Logger.getLogger(GerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarEmprestimo().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private com.toedter.calendar.JDateChooser c_DataDevolucao;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmprestimos;
    // End of variables declaration//GEN-END:variables
}
