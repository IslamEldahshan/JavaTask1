/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dark-Hero
 */
public class TaskGUI extends javax.swing.JFrame {

    int counter = 3;

    /**
     * Creates new form TaskGUI
     */
    public TaskGUI() {
        initComponents();
    }

    
    // Get Data From Table
    public int[] getDataFromTable(JTable table) {
        DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
        int rows = tablemodel.getRowCount();
        int[] tableData = new int[rows];
        for (int i = 0; i < rows - 1; i++) {
            tableData[i] = Integer.parseInt(tablemodel.getValueAt(i, 0).toString());
        }
        return tableData;
    }

    
    
    // Insert Table Data To The 2D Array Which Called table_data
    public String[][] tableData(JTable table) {
        DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
        int rows = tablemodel.getRowCount();
        int columns = tablemodel.getColumnCount();
        String[][] table_data = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    table_data[i][j] = "";
                } else {
                    if (tablemodel.getValueAt(i, j) == null) {
                        continue;
                    } else {
                        table_data[i][j] = tablemodel.getValueAt(i, j).toString();

                    }
                }
            }
        }
        return table_data;
    }

    
    
    
    public int[] getAcceptStates(JTable table) {
        DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
        int rows = tablemodel.getRowCount();

        int acceptStates[] = new int[rows];
        for (int i = 0; i < rows; i++) {
            if (tablemodel.getValueAt(i, 0) == null) {
                continue;
            }
            acceptStates[i] = Integer.parseInt(tablemodel.getValueAt(i, 0).toString());

        }
        return acceptStates;
    }

    
    
    
    public static void displayCode(String[][] table, int[] acceptStates) throws IOException {
        
        File Task1 = new File("Task1.txt");
        FileWriter fileWriter = new FileWriter("Task1.txt");
        fileWriter.write("public static boolean belongs (String token){ \n");
        fileWriter.write(" int state = 1; \n");
        fileWriter.write(" int i = 0; \n");
        fileWriter.write(" while(i <token.length()){ \n");
        fileWriter.write("  char ch = token.charAt(i); \n");
        fileWriter.write("  switch(state) \n { \n");
        for (int i = 0; i < table.length; i++) {
            if (i == 0) {
                continue;
            }
            if (table[i][0] == null) {
                continue;
            }
            fileWriter.write("   case " + (i) + ": \n");
            for (int j = 0; j < table[i].length; j++) {
                if (j == 0 || table[i][j] == null) {
                    continue;
                }
                if (j == 1) {
                    fileWriter.write("    if(ch == '" + table[0][j] + "'){ \n" + "     state = " + table[i][j] + ";" + "\n    } \n");
                }
                else if (j < table[i].length) {
                    fileWriter.write("    else if(ch == '" + table[0][j] + "'){ \n" + "     state = " + table[i][j] + ";" + "\n    } \n");
                } 
            }
            fileWriter.write("    else \n");
                    fileWriter.write("     return false; \n");
                    fileWriter.write("     break; \n");

        }
        fileWriter.write("    } \n");
        fileWriter.write("    i++; \n");
        fileWriter.write("   } \n");
        for (int i = 0; i < acceptStates.length; i++) {
            if (acceptStates[i] == 0) {
                continue;
            }
            else if(i >=1){
                fileWriter.write(" || state == " + acceptStates[i]);
            }
            else{
                fileWriter.write("   if(state == " + acceptStates[i]);
            }
            
//            fileWriter.write("   if(state == " + acceptStates[i] + ")\n    return true; \n   else \n");
        }
        fileWriter.write(" )\n    return true; \n   else \n");
        fileWriter.write("    return false; \n");
        fileWriter.write("   } \n");
        
        fileWriter.close();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, ""}
            },
            new String [] {
                "1", "2", "3"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("insert row");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("insert column");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Add accept state");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Accept States"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel) jTable1.getModel();
        counter++;
        tablemodel.addRow(new Object[]{});
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel) jTable1.getModel();
        counter++;
        tablemodel.addColumn(counter);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String table_data[][] = tableData(jTable1);
        int[] acceptStates = getAcceptStates(jTable2);
        try {
            displayCode(table_data, acceptStates);
        } catch (IOException ex) {
            Logger.getLogger(TaskGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel) jTable2.getModel();
        tablemodel.addRow(new Object[]{});
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
