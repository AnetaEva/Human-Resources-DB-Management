
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class dependantupdate extends javax.swing.JFrame {

    /**
     * Creates new form dependantupdate
     */
    public dependantupdate() {
        initComponents();
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DEPENDANT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 151, 29);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Dependent ID:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 100, 114, 18);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Employee ID:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(33, 162, 105, 18);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(33, 223, 105, 18);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Relation:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(33, 289, 69, 18);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 100, 157, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 163, 155, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 224, 155, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(180, 290, 155, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(222, 360, 97, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(325, 360, 97, 31);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Verify");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 90, 85, 31);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\SQL\\dbms project\\Screenshots\\5.jpg")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 500, 450);

        setBounds(0, 0, 517, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String depid = jTextField1.getText();
        String empid = jTextField2.getText();
        String dob = jTextField3.getText();
        String relation = jTextField4.getText();
        int empty = 0, existing = 0;
        if (depid.length() == 0 && empid.length() == 0 && dob.length() == 0 && relation.length() == 0) {
            empty++;
        }
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini", "root", "root");
            Statement myStat = myConn.createStatement();
            java.sql.ResultSet myRs = myStat.executeQuery("Select * from employee");
            while (myRs.next()) {
                if (myRs.getString("EmployeeID").equals(empid)) {
                    existing++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (empty == 0) {
            if(existing!=0){
            try {

                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini", "root", "root");
                PreparedStatement myStat = myConn.prepareStatement("update dependent set DependentID='" + depid + "',EmployeeID='" + empid + "',DependentDOB='" + dob + "',Relation='" + relation + "' where DependentID='" + depid+"'");

                myStat.executeUpdate();

                JOptionPane.showMessageDialog(null, "Updated Successfully");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            else{
                JOptionPane.showMessageDialog(null,"Enter a valid Employee ID");
            
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter all the credentials");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String depid = jTextField1.getText();
        int existing = 0;
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini", "root", "root");
            Statement myStat = myConn.createStatement();
            java.sql.ResultSet myRs = (java.sql.ResultSet) myStat.executeQuery("Select * from dependent");
            while (myRs.next()) {
                if (myRs.getString("DependentID").equals(depid)) {
                    existing++;
                }
            }
            if (existing == 0) {
                JOptionPane.showMessageDialog(null, "Dependent Id does not Exist");
                jTextField1.setText("");
            } else {
                jLabel2.setEnabled(false);
                jTextField1.setEnabled(false);
                jButton3.setEnabled(false);
                jLabel3.setEnabled(true);
                jLabel4.setEnabled(true);
                jLabel5.setEnabled(true);
                jTextField2.setEnabled(true);
                jTextField3.setEnabled(true);
                jTextField4.setEnabled(true);
                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.setVisible(false);
        hrupdatemain obj=new hrupdatemain();
        obj.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(dependantupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dependantupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dependantupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dependantupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dependantupdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
