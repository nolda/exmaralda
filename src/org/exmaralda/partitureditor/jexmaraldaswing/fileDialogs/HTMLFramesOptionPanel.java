/*
 * HTMLFramesOptionPanel.java
 *
 * Created on 3. April 2002, 12:55
 */

package org.exmaralda.partitureditor.jexmaraldaswing.fileDialogs;

/**
 *
 * @author  Thomas
 */
public class HTMLFramesOptionPanel extends javax.swing.JPanel {

    /** Creates new form HTMLFramesOptionPanel */
    public HTMLFramesOptionPanel() {
        initComponents();
        org.exmaralda.common.helpers.Internationalizer.internationalizeComponentToolTips(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Frame options"));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("No frames");
        add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Frames");
        add(jRadioButton2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables

    public boolean useFrames(){
        return jRadioButton2.isSelected();
    }
}