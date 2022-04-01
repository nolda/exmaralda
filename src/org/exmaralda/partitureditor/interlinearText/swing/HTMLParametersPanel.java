/*
 * HTMLParametersPanel.java
 *
 * Created on 3. April 2002, 12:05
 */

package org.exmaralda.partitureditor.interlinearText.swing;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.exmaralda.partitureditor.interlinearText.*;
/**
 *
 * @author  Thomas
 */
public class HTMLParametersPanel extends javax.swing.JPanel implements ChangeListener {

    /** Creates new form HTMLParametersPanel */
    public HTMLParametersPanel() {
        initComponents();
    }

    /** Creates new form HTMLParametersPanel */
    public HTMLParametersPanel(HTMLParameters param) {
        initComponents();
        makeLinksCheckBox.setSelected(param.makeLinks);
        makeAnchorsCheckBox.setSelected(param.outputAnchors);
        useJavaScriptCheckBox.setSelected(param.useJavaScript);
        if (param.getWidth()<0){
            noBreaksButton.setSelected(true);
        } else {
            breaksButton.setSelected(true);
            int width = (int)(param.getWidth());
            widthSlider.setValue(Math.max(200,width));
            widthLabel.setText(Integer.toString(Math.max(200,width)) + "px");
        }
        widthSlider.addChangeListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        makeLinksCheckBox = new javax.swing.JCheckBox();
        makeAnchorsCheckBox = new javax.swing.JCheckBox();
        useJavaScriptCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        noBreaksButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        breaksButton = new javax.swing.JRadioButton();
        widthSlider = new javax.swing.JSlider();
        widthLabel = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hypertext"));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        makeLinksCheckBox.setSelected(true);
        makeLinksCheckBox.setText("Make links");
        jPanel1.add(makeLinksCheckBox);

        makeAnchorsCheckBox.setSelected(true);
        makeAnchorsCheckBox.setText("Make anchors");
        jPanel1.add(makeAnchorsCheckBox);

        useJavaScriptCheckBox.setText("Use JavaScript");
        useJavaScriptCheckBox.setEnabled(false);
        jPanel1.add(useJavaScriptCheckBox);

        add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Width"));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        buttonGroup1.add(noBreaksButton);
        noBreaksButton.setSelected(true);
        noBreaksButton.setText("Don't make line breaks");
        noBreaksButton.setToolTipText("Partitur nicht umbrechen");
        jPanel2.add(noBreaksButton);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroup1.add(breaksButton);
        breaksButton.setText("Pixel width");
        breaksButton.setToolTipText("Umbruchbreite in Pixeln");
        jPanel3.add(breaksButton);

        widthSlider.setMajorTickSpacing(400);
        widthSlider.setMaximum(2000);
        widthSlider.setMinimum(200);
        widthSlider.setMinorTickSpacing(100);
        widthSlider.setPaintLabels(true);
        widthSlider.setPaintTicks(true);
        widthSlider.setToolTipText("Breite der Partituren in Pixel");
        widthSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                widthSliderStateChanged(evt);
            }
        });
        jPanel3.add(widthSlider);

        widthLabel.setForeground(new java.awt.Color(0, 102, 204));
        widthLabel.setText("200px");
        jPanel3.add(widthLabel);

        jPanel2.add(jPanel3);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void widthSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthSliderStateChanged
        // TODO add your handling code here:
        if (widthSlider.getValueIsAdjusting()) return;
        breaksButton.setSelected(true);
    }//GEN-LAST:event_widthSliderStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton breaksButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox makeAnchorsCheckBox;
    private javax.swing.JCheckBox makeLinksCheckBox;
    private javax.swing.JRadioButton noBreaksButton;
    private javax.swing.JCheckBox useJavaScriptCheckBox;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JSlider widthSlider;
    // End of variables declaration//GEN-END:variables

    public void modifyParameters(org.exmaralda.partitureditor.interlinearText.HTMLParameters param){
        param.makeLinks = makeLinksCheckBox.isSelected();
        param.outputAnchors = makeAnchorsCheckBox.isSelected();
        param.useJavaScript = useJavaScriptCheckBox.isSelected();
        if (noBreaksButton.isSelected()){
            param.setWidth(-1);
        } else {
            param.setWidth(widthSlider.getValue());
        }
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource()==this.widthSlider){
            widthLabel.setText(Integer.toString(widthSlider.getValue())+"px");
        }
    }
    
}
