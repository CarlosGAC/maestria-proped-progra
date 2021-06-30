
package com.itcg.ejercicio10;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.000");

    private static double num1;
    private static double num2;
    
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textFieldNumero1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textFieldNumero2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnSuma = new javax.swing.JButton();
        btnResta = new javax.swing.JButton();
        btnMulti = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelRes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejercicio 10");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(363, 132));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 200));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Numero 1");
        jPanel5.add(jLabel2, java.awt.BorderLayout.NORTH);

        textFieldNumero1.setText("0");
        jPanel5.add(textFieldNumero1, java.awt.BorderLayout.SOUTH);

        jPanel4.add(jPanel5);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Numero 2");
        jPanel8.add(jLabel3, java.awt.BorderLayout.NORTH);

        textFieldNumero2.setText("0");
        jPanel8.add(textFieldNumero2, java.awt.BorderLayout.SOUTH);

        jPanel7.add(jPanel8);

        jPanel4.add(jPanel7);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        btnSuma.setText("Suma");
        btnSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumaActionPerformed(evt);
            }
        });
        jPanel9.add(btnSuma);

        btnResta.setText("Resta");
        btnResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaActionPerformed(evt);
            }
        });
        jPanel9.add(btnResta);

        btnMulti.setText("Multiplicación");
        btnMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiActionPerformed(evt);
            }
        });
        jPanel9.add(btnMulti);

        btnDiv.setText("División");
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });
        jPanel9.add(btnDiv);

        jPanel3.add(jPanel9, java.awt.BorderLayout.NORTH);

        jLabel4.setText("Resultado:");
        jPanel10.add(jLabel4);

        labelRes.setText("0");
        jPanel10.add(labelRes);

        jPanel3.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Calculadora");
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumaActionPerformed
        if(validateFieldValues()) {
            getFieldValues();
            double res = Aritmetica.suma(num1, num2);
            setLabelResText(res);
        }
    }//GEN-LAST:event_btnSumaActionPerformed

    private void btnRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaActionPerformed
        if(validateFieldValues()) {
            getFieldValues();
            double res = Aritmetica.resta(num1, num2);
            setLabelResText(res);
        }
    }//GEN-LAST:event_btnRestaActionPerformed

    private void btnMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiActionPerformed
        if(validateFieldValues()) {
            getFieldValues();
            double res = Aritmetica.multiplicacion(num1, num2);
            setLabelResText(res);
        }
    }//GEN-LAST:event_btnMultiActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        double res = 0;
        if(validateFieldValues()) {
            getFieldValues();
            try {
                res = Aritmetica.division(num1, num2);
            }catch(ArithmeticException e) {
                e.getMessage();
                JOptionPane.showMessageDialog(this, "Error: Division entre 0", "Error Aritmetico", JOptionPane.ERROR_MESSAGE);
            }
            
            setLabelResText(res);
        }
    }//GEN-LAST:event_btnDivActionPerformed

    private void setLabelResText(double value) {
        System.out.println(value);
        labelRes.setText("" + decimalFormat.format(value));
    }
    
    private void getFieldValues() {
        num1 = Double.parseDouble(textFieldNumero1.getText());
        num2 = Double.parseDouble(textFieldNumero2.getText());
    }
    
    private void clearValues() {
        num1 = 0;
        num2 = 0;
    }
    private boolean validateFieldValues() {
        String numberRegex = "^[+-]?([0-9]*[.])?[0-9]+$";
        
        if(textFieldNumero1.getText().matches(numberRegex) && textFieldNumero2.getText().matches(numberRegex)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Error: Uno de los valores ingresados no son numericos", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnMulti;
    private javax.swing.JButton btnResta;
    private javax.swing.JButton btnSuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelRes;
    private javax.swing.JTextField textFieldNumero1;
    private javax.swing.JTextField textFieldNumero2;
    // End of variables declaration//GEN-END:variables
}
