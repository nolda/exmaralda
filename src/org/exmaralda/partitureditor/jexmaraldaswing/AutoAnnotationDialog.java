/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.partitureditor.jexmaraldaswing;

import java.awt.Color;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Schmidt
 */
public class AutoAnnotationDialog extends javax.swing.JDialog implements DocumentListener {

    public boolean approved = false;
    /**
     * Creates new form AutoAnnotationDialog
     */
    public AutoAnnotationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        regexTextField.getDocument().addDocumentListener(this);
        categoryTextField.getDocument().addDocumentListener(this);
        valueTextField.getDocument().addDocumentListener(this);
    }
    
    public String getRegex(){
        return regexTextField.getText();
    }

    public String getCategory(){
        return categoryTextField.getText();
    }
    
    public String getValue(){
        return valueTextField.getText();
    }
    
    public boolean getDelete(){
        return deleteCheckbox.isSelected();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        regexPanel = new javax.swing.JPanel();
        regexLabel = new javax.swing.JLabel();
        regexTextField = new javax.swing.JTextField();
        categoryPanel = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        categoryTextField = new javax.swing.JTextField();
        valuePanel = new javax.swing.JPanel();
        valueLabel = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();
        deletePanel = new javax.swing.JPanel();
        deleteCheckbox = new javax.swing.JCheckBox();
        buttonsPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Auto Annotation");

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        regexPanel.setLayout(new javax.swing.BoxLayout(regexPanel, javax.swing.BoxLayout.LINE_AXIS));

        regexLabel.setText("Regular expression: ");
        regexLabel.setMaximumSize(new java.awt.Dimension(106, 14));
        regexLabel.setMinimumSize(new java.awt.Dimension(106, 14));
        regexLabel.setPreferredSize(new java.awt.Dimension(106, 14));
        regexPanel.add(regexLabel);

        regexTextField.setMaximumSize(new java.awt.Dimension(300, 20));
        regexTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        regexTextField.setPreferredSize(new java.awt.Dimension(300, 20));
        regexPanel.add(regexTextField);

        mainPanel.add(regexPanel);

        categoryPanel.setLayout(new javax.swing.BoxLayout(categoryPanel, javax.swing.BoxLayout.LINE_AXIS));

        categoryLabel.setText("Annotation category: ");
        categoryPanel.add(categoryLabel);

        categoryTextField.setMaximumSize(new java.awt.Dimension(300, 20));
        categoryTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        categoryTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        categoryPanel.add(categoryTextField);

        mainPanel.add(categoryPanel);

        valuePanel.setLayout(new javax.swing.BoxLayout(valuePanel, javax.swing.BoxLayout.LINE_AXIS));

        valueLabel.setText("Annotation value: ");
        valueLabel.setMaximumSize(new java.awt.Dimension(106, 14));
        valueLabel.setMinimumSize(new java.awt.Dimension(106, 14));
        valueLabel.setPreferredSize(new java.awt.Dimension(106, 14));
        valuePanel.add(valueLabel);

        valueTextField.setMaximumSize(new java.awt.Dimension(300, 20));
        valueTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        valueTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        valuePanel.add(valueTextField);

        mainPanel.add(valuePanel);

        deleteCheckbox.setText("Delete existing annotations (if any)");
        deletePanel.add(deleteCheckbox);

        mainPanel.add(deletePanel);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(cancelButton);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        approved = true;
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AutoAnnotationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoAnnotationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoAnnotationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoAnnotationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AutoAnnotationDialog dialog = new AutoAnnotationDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JCheckBox deleteCheckbox;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel regexLabel;
    private javax.swing.JPanel regexPanel;
    private javax.swing.JTextField regexTextField;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JPanel valuePanel;
    private javax.swing.JTextField valueTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        textFieldChange(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        textFieldChange(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        textFieldChange(e);
    }

    private void textFieldChange(DocumentEvent e) {
        String regex = regexTextField.getText();
        boolean regexOK = false;
        if (regex.length()>0){
            try{
                Pattern.compile(regex);
                regexOK = true;
                regexTextField.setForeground(Color.black);
            } catch (PatternSyntaxException ex){
                regexTextField.setToolTipText(ex.getLocalizedMessage());
                regexTextField.setForeground(Color.red);
            }
        }
        boolean textisEverywhere = regex.length()>0 && categoryTextField.getText().length()>0 && valueTextField.getText().length()>0;
        okButton.setEnabled(regexOK && textisEverywhere);
    }
}