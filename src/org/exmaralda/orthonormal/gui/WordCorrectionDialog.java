/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WordCorrectionDialog.java
 *
 * Created on 21.09.2012, 11:31:11
 */
package org.exmaralda.orthonormal.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.exmaralda.exakt.utilities.FileIO;
import org.exmaralda.partitureditor.jexmaralda.StringUtilities;
import org.jdom.Attribute;
import org.jdom.Content;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Text;

/**
 *
 * @author Schmidt
 */
public class WordCorrectionDialog extends javax.swing.JDialog {

    Element wordElement;
    public boolean approved = false;
    
    /** Creates new form WordCorrectionDialog */
    public WordCorrectionDialog(java.awt.Frame parent, boolean modal, Element wordElement) {
        super(parent, modal);
        this.wordElement = wordElement;
        initComponents();
        String allText = "";
        for (Object o : wordElement.getContent()){
            Content c = (Content)o;
            if (c instanceof Text){
                allText+=((Text)c).getText();
            } else {
                Element e = (Element)c;
                allText+="<" + e.getName();
                for (Object o2 : e.getAttributes()){
                    Attribute a = (Attribute)o2;
                    allText+=" " + a.getName() + "=\"" + a.getValue() + "\"";
                }
                allText+="/>";
            }
        }
        editTextField.setText(allText);
        
        ActionListener enterKeyListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                okButtonActionPerformed(actionEvent);
            }
        };
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        getRootPane().registerKeyboardAction(enterKeyListener, enterStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
    }
    
    public Element getWordElement(){
        return wordElement;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editTextField = new javax.swing.JTextField();
        okCancelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wortkorrektur");

        editTextField.setText("jTextField1");
        editTextField.setMinimumSize(new java.awt.Dimension(300, 30));
        editTextField.setPreferredSize(new java.awt.Dimension(300, 30));
        getContentPane().add(editTextField, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(cancelButton);

        getContentPane().add(okCancelPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        approved = true;
        boolean isOkay = setWordElement();
        if (isOkay){
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "XML-Fehler!");
        }
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
            java.util.logging.Logger.getLogger(WordCorrectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WordCorrectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WordCorrectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WordCorrectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                WordCorrectionDialog dialog = new WordCorrectionDialog(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField editTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okCancelPanel;
    // End of variables declaration//GEN-END:variables

    private boolean setWordElement() {
        // changed 14-04-2015: must escape XML entities before parsing
        String elementText = "<w";
        for (Object o : wordElement.getAttributes()){
            Attribute a = (Attribute)o;
            elementText+=" " + a.getName() + "=\"" + StringUtilities.toXMLString(a.getValue()) + "\"";
        }
        elementText+=">";
        elementText+=editTextField.getText().trim();
        elementText+="</w>";
        System.out.println(elementText);
        try {
            Element newWordElement = FileIO.readDocumentFromString(elementText).getRootElement();
            wordElement = newWordElement;
            return true;
        } catch (JDOMException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
}