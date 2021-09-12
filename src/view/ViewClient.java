/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Produtos;
import model.dao.ClienteDA0;
import model.dao.ProdutoDA0;

/**
 *
 * @author PC TESTE
 */
public class ViewClient extends javax.swing.JFrame {

    /**
     * Creates new form ViewClient
     */
    public ViewClient() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) cliTable.getModel();
        cliTable.setRowSorter(new TableRowSorter(modelo));

        ClienteTable();
    }

    public void ClienteTable() {

        DefaultTableModel modelo = (DefaultTableModel) cliTable.getModel();
        modelo.setNumRows(0);

        ClienteDA0 dao = new ClienteDA0();

        for (Cliente c : dao.read()) {

            modelo.addRow(new Object[]{
                c.getCodigo(),
                c.getNome(),
                c.getCompras(),
                c.getTotalvalor()
            });

        }
    }

    public void Clisearch(String nom) {
        DefaultTableModel modelo = (DefaultTableModel) cliTable.getModel();
        modelo.setNumRows(0);
        ClienteDA0 cdao = new ClienteDA0();

        for (Cliente c : cdao.buscar(nom)) {

            modelo.addRow(new Object[]{
                c.getCodigo(), c.getNome(), c.getCompras(),c.getTotalvalor()

            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cliNome = new javax.swing.JTextField();
        cliCadastrar = new javax.swing.JButton();
        cliDelete = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cliBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cliTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JTableClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        getContentPane().add(cliNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 756, -1));

        cliCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        cliCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cliCadastrarMouseEntered(evt);
            }
        });
        cliCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(cliCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 70, 60));

        cliDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/trash.png"))); // NOI18N
        cliDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cliDeleteMouseEntered(evt);
            }
        });
        cliDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(cliDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 90, 80));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 60, 50));
        getContentPane().add(cliBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 168, -1));

        cliTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Total de Compras", "TotalGasto"
            }
        ));
        cliTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cliTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cliTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 700, 160));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 50));

        jLabel1.setFont(new java.awt.Font("Gregor Millers Friends Font", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastrar/Consultar Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC TESTE\\Desktop\\Netbeans and IMG\\Sistema\\src\\imagens\\editar.png")); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 60, 60));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC TESTE\\Desktop\\Netbeans and IMG\\Sistema\\src\\imagens\\editar.png")); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 60, 60));

        JTableClientes.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        JTableClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/jframe.png"))); // NOI18N
        getContentPane().add(JTableClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, -190, 1070, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cliCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliCadastrarActionPerformed

        if (cliNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira o Nome do Cliente");
            cliNome.requestFocusInWindow();
            return;

        }

        Cliente c = new Cliente();
        ClienteDA0 cdao = new ClienteDA0();

        c.setNome(cliNome.getText());

        cdao.create(c);

        ClienteTable();
        
        cliNome.setText("");


    }//GEN-LAST:event_cliCadastrarActionPerformed

    private void cliDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliDeleteActionPerformed

        if (cliTable.getSelectedRow() != -1) {

            Cliente c = new Cliente();
            ClienteDA0 dao = new ClienteDA0();

            c.setCodigo((int) cliTable.getValueAt(cliTable.getSelectedRow(), 0));
            dao.excluir(c);

            ClienteTable();

        }


    }//GEN-LAST:event_cliDeleteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        Clisearch(cliBuscar.getText());

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewHome vw = new ViewHome();
        vw.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        String string = "Voltar";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void cliCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliCadastrarMouseEntered
        String string = "Cadastrar";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_cliCadastrarMouseEntered

    private void cliDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliDeleteMouseEntered
        String string = "Excluir";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_cliDeleteMouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        String string = "Procurar Cliente";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        String string = "Atualizar";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

      if (cliTable.getSelectedRow() != -1) {

            Cliente c = new Cliente();
            ClienteDA0 dao = new ClienteDA0();

            c.setNome(cliNome.getText());
            c.setCodigo((int) cliTable.getValueAt(cliTable.getSelectedRow(), 0));

            dao.atualizarCliente(c);
            
            ClienteTable();

            
            cliNome.setText("");
            cliNome.requestFocusInWindow();

        } else {

            JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar");
        }
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        String string = "Atualizar";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void cliTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliTableMouseClicked
       if (cliTable.getSelectedRow() != -1) {

            cliNome.setText(cliTable.getValueAt(cliTable.getSelectedRow(), 1).toString());

        } else {

            JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar");
        }
    }//GEN-LAST:event_cliTableMouseClicked

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
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTableClientes;
    private javax.swing.JTextField cliBuscar;
    private javax.swing.JButton cliCadastrar;
    private javax.swing.JButton cliDelete;
    private javax.swing.JTextField cliNome;
    private javax.swing.JTable cliTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
