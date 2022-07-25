/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vitas;

import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author The Frank R
 */
public class Usermenu extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection Connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados;

    public Usermenu() {
        initComponents();
        ListarEmpleados();

    }

    private void ListarEmpleados() {
        
         String filtroBusqueda = txtSearch.getText();
         
         
         if(filtroBusqueda.isEmpty()){
             
        String queryConsulta = "SELECT * FROM empleados";

        try {

            Connection = conexion.getConection();
            st = Connection.createStatement();
            rs = st.executeQuery(queryConsulta);
            Object[] empleados = new Object[6];
            contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
            while (rs.next()) {
                empleados[0] = rs.getInt("idempleado");
                empleados[1] = rs.getString("NombreEmp");
                empleados[2] = rs.getString("Apeliidos");
                empleados[3] = rs.getString("TipoDeDocumento");
                empleados[4] = rs.getString("Documento");
                empleados[5] = rs.getString("Correo");
                contenidoTablaEmpleados.addRow(empleados);
                //System.out.println(empleados[0] + " " + "nombre " + empleados[1]+"apellidos"+empleados[2]
                       // + "\nDocumento " + empleados[2] + ": " + empleados[3] + "\n Correo: " + empleados[4]);
                
                tblEmpleados.setModel(contenidoTablaEmpleados);
            }

        } catch (SQLException e) {
            System.out.println("Error");
        }
        }else{
             String queryConsulta = "SELECT * FROM empleados WHERE NombreEmp LIKE \"%"+filtroBusqueda+"%\" or Apeliidos LIKE \"%"+filtroBusqueda+"%\"";
             System.out.println(queryConsulta);
             
             try {

                Connection = conexion.getConection();
                st = Connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getInt("idempleado");
                    empleados[1] = rs.getString("NombreEmp");
                    empleados[2] = rs.getString("Apeliidos");
                    empleados[3] = rs.getString("TipoDeDocumento");
                    empleados[4] = rs.getString("Documento");
                    empleados[5] = rs.getString("Correo");
                    contenidoTablaEmpleados.addRow(empleados);
                    //System.out.println(empleados[0] + " " + "nombre " + empleados[1]+"apellidos"+empleados[2]
                    // + "\nDocumento " + empleados[2] + ": " + empleados[3] + "\n Correo: " + empleados[4]);

                    tblEmpleados.setModel(contenidoTablaEmpleados);
                }

            } catch (SQLException e) {
                System.out.println("Error");
            }
             
         }
    }
    
    
    
    private void borrarDatosTabla(){
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i-=1;      
        }
    }
    
  
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUsser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnShear = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Home", jPanel2);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Tipo Documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUsser.setBackground(new java.awt.Color(204, 204, 204));
        btnAddUsser.setForeground(new java.awt.Color(204, 204, 204));
        btnAddUsser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/agregar.png"))); // NOI18N
        btnAddUsser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Informacion Empleados");

        jLabel2.setText("Nombre");

        btnShear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/lupa(1).png"))); // NOI18N
        btnShear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnShear)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addComponent(btnAddUsser, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnAddUsser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(84, 84, 84))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Empleado", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Linea de ventas", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Productos", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUsserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsserActionPerformed

        addUser Aduser = new addUser(this, rootPaneCheckingEnabled);
        Aduser.setVisible(true);
        borrarDatosTabla();
        ListarEmpleados();
       
    }//GEN-LAST:event_btnAddUsserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int row = tblEmpleados.getSelectedRow();//identifica la fila
        //System.out.println("*********************************");
        //System.out.println("fILA "+row);
        //validar si el usuiro no selecciono un emopleado
        
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un empleado","",JOptionPane.WARNING_MESSAGE);
        } else{
            //capturar la fila en registros 
            
            int idEmp= Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
            String NombreEmp= tblEmpleados.getValueAt(row, 1).toString();
            String Apellidos= tblEmpleados.getValueAt(row, 2).toString();
            String tipoDocumento= tblEmpleados.getValueAt(row, 3).toString();
            String documento= tblEmpleados.getValueAt(row, 4).toString();
            String correo= tblEmpleados.getValueAt(row, 5).toString();
            
            System.out.println("id: q"+idEmp+"\n"+NombreEmp+"\n"+Apellidos+"\n"+tipoDocumento+"\n"+documento+"\n"+correo);
            
            ShowUserFrom showUserfrom = new ShowUserFrom(this, true);
            showUserfrom.resiveDatos(idEmp, NombreEmp, Apellidos, tipoDocumento, documento, correo);
            showUserfrom.setVisible(true);
            borrarDatosTabla();
            ListarEmpleados();
            
            
        }
        
        
        
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnShearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShearActionPerformed
       
        borrarDatosTabla();
        ListarEmpleados();
        
        
    }//GEN-LAST:event_btnShearActionPerformed

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
            java.util.logging.Logger.getLogger(Usermenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usermenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usermenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usermenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usermenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUsser;
    private javax.swing.JButton btnShear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
