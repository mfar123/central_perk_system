/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Cursor;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.Produtos;
import model.bean.Vender;
import model.dao.ClienteDA0;
import model.dao.ProdutoDA0;
import model.dao.UsuarioDA0;
import model.dao.VenderDA0;

/**
 *
 * @author PC TESTE
 */
public class ViewCompras extends javax.swing.JFrame {
         int a=0;
    /**
     * Creates new form ViewCompras
     */
    public ViewCompras() {
        initComponents();
        
        ClienteDA0 cdao = new ClienteDA0();
        for(Cliente c: cdao.read()){
            comprasbox.addItem(c);
        }
        
    
}
   public void readvenTable() {

        DefaultTableModel modelo = (DefaultTableModel) compras.getModel();
        modelo.setNumRows(0);
        
        VenderDA0 dao = new VenderDA0();
        ProdutoDA0 p = new ProdutoDA0();

                
        for (Vender v : dao.lera(a)) {           
             String produto = (p.getName(v.getProduto()));
             v.setPro( produto ); 
            modelo.addRow(new Object[]{

                v.getPro(),
                v.getTotal(),
                v.getData(),
                v.getHora()
                

            });

        }


    }
        
        
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprasbox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        compras = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(comprasbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 270, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC TESTE\\Desktop\\Netbeans and IMG\\Sistema\\src\\imagens\\search.png")); // NOI18N
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 60, 50));

        compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Compras", "Total", "Data", "Hora"
            }
        ));
        jScrollPane1.setViewportView(compras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 810, 320));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 70));

        jLabel1.setFont(new java.awt.Font("Gregor Millers Friends Font", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar Vendas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 486, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/jframe.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 0, 1090, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
        String nc = comprasbox.getSelectedItem().toString();

        
        ClienteDA0 cd = new ClienteDA0();
        Cliente c1 = cd.getClientes(nc);
        


        a = c1.getCodigo();
        
       
        readvenTable();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ViewHome vw = new ViewHome();
       vw.show();
       this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
       // JButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        String string = "Buscar Informações";
        jButton1.setToolTipText(string);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

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
            java.util.logging.Logger.getLogger(ViewCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable compras;
    private javax.swing.JComboBox<Object> comprasbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
