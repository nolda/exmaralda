/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditPreferencesDialog.java
 *
 * Created on 23.09.2010, 13:40:00
 */

package org.exmaralda.orthonormal.gui;

import javax.swing.JFileChooser;
import org.exmaralda.folker.utilities.FOLKERInternationalizer;
import org.exmaralda.orthonormal.utilities.PreferencesUtilities;
import org.exmaralda.partitureditor.jexmaraldaswing.fileFilters.ParameterFileFilter;

/**
 *
 * @author thomas
 */
public class EditPreferencesDialog extends javax.swing.JDialog {

    /** Creates new form EditPreferencesDialog */
    public EditPreferencesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        String type = PreferencesUtilities.getProperty("lexicon-type", "xml");
        String LEXICON_PATH = PreferencesUtilities.getProperty("lexicon-path", "");
        String RDB_URL = PreferencesUtilities.getProperty("rdb-url", "");
        String RDB_USERNAME = PreferencesUtilities.getProperty("rdb-username", "");
        String RDB_PASSWORD = PreferencesUtilities.getProperty("rdb-password", "");

        if ("xml".equals(type)){
            internalRadioButton.setSelected(true);
        } else if ("xml-local".equals(type)){
            xmlRadioButton.setSelected(true);
        } else {
            rdbRadioButton.setSelected(true);
        }
        
        String playerType = PreferencesUtilities.getProperty("PlayerType", "JMF-Player");
        jmfRadioButton.setSelected(playerType.equals("JMF-Player"));
        jdsRadioButton.setSelected(playerType.equals("JDS-Player"));
        cocoaQTRadioButton.setSelected(playerType.equals("CocoaQT-Player"));
        elanQuicktimeRadioButton.setSelected(playerType.equals("ELAN-Quicktime-Player"));
        quicktimeRadioButton.setSelected(playerType.equals("Quicktime-Player"));
        directShowRadioButton.setSelected(playerType.equals("DirectShow-Player"));
        basRadioButton.setSelected(playerType.equals("BAS-Audio-Player"));

        String os = System.getProperty("os.name").toLowerCase();
        directShowRadioButton.setVisible(os.toLowerCase().startsWith("win"));
        jdsRadioButton.setVisible(os.toLowerCase().startsWith("win"));
        elanQuicktimeRadioButton.setVisible(os.toLowerCase().startsWith("mac"));
        cocoaQTRadioButton.setVisible(os.toLowerCase().startsWith("mac"));
        

        xmlFileTextField.setText(LEXICON_PATH);
        urlTextField.setText(RDB_URL);
        usernameTextField.setText(RDB_USERNAME);
        passwordField.setText(RDB_PASSWORD);



        switchViews();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        playerButtonGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        lexiconPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        internalRadioButton = new javax.swing.JRadioButton();
        xmlRadioButton = new javax.swing.JRadioButton();
        rdbRadioButton = new javax.swing.JRadioButton();
        xmlParamatersPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        xmlFileTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        rdbParamatersPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        tagsetPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        internalPOSRadioButton = new javax.swing.JRadioButton();
        xmlPOSRadioButton = new javax.swing.JRadioButton();
        xmlPOSParametersPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        xmlPOSFileTextField = new javax.swing.JTextField();
        browsePOSButton = new javax.swing.JButton();
        playerOptionsPanel = new javax.swing.JPanel();
        playerPanel = new javax.swing.JPanel();
        basRadioButton = new javax.swing.JRadioButton();
        jdsRadioButton = new javax.swing.JRadioButton();
        directShowRadioButton = new javax.swing.JRadioButton();
        cocoaQTRadioButton = new javax.swing.JRadioButton();
        elanQuicktimeRadioButton = new javax.swing.JRadioButton();
        quicktimeRadioButton = new javax.swing.JRadioButton();
        jmfRadioButton = new javax.swing.JRadioButton();
        restartHintPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        restartHintTextArea = new javax.swing.JTextArea();
        optionsPanel = new javax.swing.JPanel();
        useControlCheckBoxPanel = new javax.swing.JPanel();
        useControlCheckBox = new javax.swing.JCheckBox();
        loopTimePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        loopTimeSlider = new javax.swing.JSlider();
        defaultAudioPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        defaultAudioTextField = new javax.swing.JTextField();
        defaultAudioBrowseButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferences");

        lexiconPanel.setLayout(new java.awt.BorderLayout());

        buttonGroup1.add(internalRadioButton);
        internalRadioButton.setText("Internes Lexikon");
        internalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internalRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(internalRadioButton);

        buttonGroup1.add(xmlRadioButton);
        xmlRadioButton.setText("Lokales XML-Lexikon");
        xmlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(xmlRadioButton);

        buttonGroup1.add(rdbRadioButton);
        rdbRadioButton.setText("Datenbank-Lexikon");
        rdbRadioButton.setEnabled(false);
        rdbRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(rdbRadioButton);

        lexiconPanel.add(jPanel2, java.awt.BorderLayout.NORTH);

        xmlParamatersPanel.setLayout(new javax.swing.BoxLayout(xmlParamatersPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("XML-Datei: ");
        xmlParamatersPanel.add(jLabel1);

        xmlFileTextField.setMaximumSize(new java.awt.Dimension(500, 20));
        xmlFileTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        xmlFileTextField.setPreferredSize(new java.awt.Dimension(300, 20));
        xmlParamatersPanel.add(xmlFileTextField);

        browseButton.setText("Durchsuchen...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        xmlParamatersPanel.add(browseButton);

        lexiconPanel.add(xmlParamatersPanel, java.awt.BorderLayout.WEST);

        rdbParamatersPanel.setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("URL: ");
        jLabel2.setMaximumSize(new java.awt.Dimension(90, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 14));
        jPanel1.add(jLabel2);

        urlTextField.setMaximumSize(new java.awt.Dimension(400, 20));
        urlTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        jPanel1.add(urlTextField);

        rdbParamatersPanel.add(jPanel1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Benutzername: ");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(90, 14));
        jPanel3.add(jLabel3);

        usernameTextField.setMaximumSize(new java.awt.Dimension(400, 20));
        usernameTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        jPanel3.add(usernameTextField);

        rdbParamatersPanel.add(jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Passwort: ");
        jLabel4.setMaximumSize(new java.awt.Dimension(90, 14));
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 14));
        jPanel4.add(jLabel4);
        jPanel4.add(passwordField);

        rdbParamatersPanel.add(jPanel4);

        lexiconPanel.add(rdbParamatersPanel, java.awt.BorderLayout.EAST);

        jTabbedPane1.addTab("Lexikon", lexiconPanel);

        tagsetPanel.setLayout(new java.awt.BorderLayout());

        buttonGroup2.add(internalPOSRadioButton);
        internalPOSRadioButton.setSelected(true);
        internalPOSRadioButton.setText("Internes Tagset");
        internalPOSRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internalPOSRadioButtonActionPerformed(evt);
            }
        });
        jPanel6.add(internalPOSRadioButton);

        buttonGroup2.add(xmlPOSRadioButton);
        xmlPOSRadioButton.setText("Lokales XML-Tagset");
        xmlPOSRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlPOSRadioButtonActionPerformed(evt);
            }
        });
        jPanel6.add(xmlPOSRadioButton);

        tagsetPanel.add(jPanel6, java.awt.BorderLayout.NORTH);

        xmlPOSParametersPanel.setLayout(new javax.swing.BoxLayout(xmlPOSParametersPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("XML-Datei: ");
        xmlPOSParametersPanel.add(jLabel5);

        xmlPOSFileTextField.setMaximumSize(new java.awt.Dimension(500, 20));
        xmlPOSFileTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        xmlPOSFileTextField.setPreferredSize(new java.awt.Dimension(300, 20));
        xmlPOSParametersPanel.add(xmlPOSFileTextField);

        browsePOSButton.setText("Durchsuchen...");
        browsePOSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsePOSButtonActionPerformed(evt);
            }
        });
        xmlPOSParametersPanel.add(browsePOSButton);

        tagsetPanel.add(xmlPOSParametersPanel, java.awt.BorderLayout.WEST);

        jTabbedPane1.addTab("POS Tagset", tagsetPanel);

        playerOptionsPanel.setLayout(new java.awt.BorderLayout());

        playerPanel.setLayout(new javax.swing.BoxLayout(playerPanel, javax.swing.BoxLayout.Y_AXIS));

        playerButtonGroup.add(basRadioButton);
        basRadioButton.setText("BAS Audio Player");
        playerPanel.add(basRadioButton);

        playerButtonGroup.add(jdsRadioButton);
        jdsRadioButton.setText("JDS Player");
        playerPanel.add(jdsRadioButton);

        playerButtonGroup.add(directShowRadioButton);
        directShowRadioButton.setForeground(new java.awt.Color(128, 128, 128));
        directShowRadioButton.setText(FOLKERInternationalizer.getString("dialog.preferences.directshow"));
        directShowRadioButton.setEnabled(false);
        playerPanel.add(directShowRadioButton);

        playerButtonGroup.add(cocoaQTRadioButton);
        cocoaQTRadioButton.setText("Cocoa QT Player");
        playerPanel.add(cocoaQTRadioButton);

        playerButtonGroup.add(elanQuicktimeRadioButton);
        elanQuicktimeRadioButton.setText(FOLKERInternationalizer.getString("dialog.preferences.quicktime"));
        playerPanel.add(elanQuicktimeRadioButton);

        playerButtonGroup.add(quicktimeRadioButton);
        quicktimeRadioButton.setForeground(new java.awt.Color(128, 128, 128));
        quicktimeRadioButton.setText("QTJ (Quicktime for Java) Player");
        quicktimeRadioButton.setEnabled(false);
        playerPanel.add(quicktimeRadioButton);

        playerButtonGroup.add(jmfRadioButton);
        jmfRadioButton.setText("JMF (Java Media Framework) Player");
        playerPanel.add(jmfRadioButton);

        playerOptionsPanel.add(playerPanel, java.awt.BorderLayout.CENTER);

        restartHintPanel.setLayout(new javax.swing.BoxLayout(restartHintPanel, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        restartHintTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        restartHintTextArea.setColumns(20);
        restartHintTextArea.setEditable(false);
        restartHintTextArea.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        restartHintTextArea.setForeground(new java.awt.Color(204, 0, 0));
        restartHintTextArea.setLineWrap(true);
        restartHintTextArea.setRows(3);
        restartHintTextArea.setText(FOLKERInternationalizer.getString("dialog.preferences.playerhint"));
        restartHintTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(restartHintTextArea);

        restartHintPanel.add(jScrollPane1);

        playerOptionsPanel.add(restartHintPanel, java.awt.BorderLayout.PAGE_START);

        optionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(FOLKERInternationalizer.getString("dialog.preferences.options")));
        optionsPanel.setLayout(new javax.swing.BoxLayout(optionsPanel, javax.swing.BoxLayout.Y_AXIS));

        useControlCheckBoxPanel.setLayout(new javax.swing.BoxLayout(useControlCheckBoxPanel, javax.swing.BoxLayout.LINE_AXIS));

        useControlCheckBox.setText(FOLKERInternationalizer.getString("dialog.preferences.controloption"));
        useControlCheckBoxPanel.add(useControlCheckBox);

        optionsPanel.add(useControlCheckBoxPanel);

        loopTimePanel.setLayout(new javax.swing.BoxLayout(loopTimePanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText(FOLKERInternationalizer.getString("dialog.preferences.waitloop"));
        loopTimePanel.add(jLabel6);

        loopTimeSlider.setMajorTickSpacing(200);
        loopTimeSlider.setMaximum(1000);
        loopTimeSlider.setMinimum(200);
        loopTimeSlider.setMinorTickSpacing(100);
        loopTimeSlider.setPaintLabels(true);
        loopTimeSlider.setPaintTicks(true);
        loopTimeSlider.setPreferredSize(new java.awt.Dimension(250, 47));
        loopTimePanel.add(loopTimeSlider);

        optionsPanel.add(loopTimePanel);

        jLabel7.setText(FOLKERInternationalizer.getString("dialog.preferences.defaultAudioPath"));
        defaultAudioPanel.add(jLabel7);

        defaultAudioTextField.setMinimumSize(new java.awt.Dimension(250, 20));
        defaultAudioTextField.setPreferredSize(new java.awt.Dimension(250, 20));
        defaultAudioPanel.add(defaultAudioTextField);

        defaultAudioBrowseButton.setText(FOLKERInternationalizer.getString("masker.browse"));
        defaultAudioBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultAudioBrowseButtonActionPerformed(evt);
            }
        });
        defaultAudioPanel.add(defaultAudioBrowseButton);

        optionsPanel.add(defaultAudioPanel);

        playerOptionsPanel.add(optionsPanel, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Player", playerOptionsPanel);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel5.add(okButton);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xmlRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlRadioButtonActionPerformed
        switchViews();
    }//GEN-LAST:event_xmlRadioButtonActionPerformed

    private void rdbRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbRadioButtonActionPerformed
        switchViews();
    }//GEN-LAST:event_rdbRadioButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("XML-Datei f�r Lexikon ausw�hlen/angeben");
        jfc.setFileFilter(new ParameterFileFilter("xml", "Normalisierungslexikondateien (*.xml)"));
        int v = jfc.showOpenDialog(this);
        if (v==JFileChooser.APPROVE_OPTION){
            xmlFileTextField.setText(jfc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String type = "xml";
        if (rdbRadioButton.isSelected()){
            type = "db";
        } else if (xmlRadioButton.isSelected()){
            type = "xml-local";
        }
        String posType="xml";
        if (xmlPOSRadioButton.isSelected()){
            posType = "xml-local";
        }        
        PreferencesUtilities.setProperty("lexicon-type", type);
        PreferencesUtilities.setProperty("tagset-type", posType);
        PreferencesUtilities.setProperty("lexicon-path", xmlFileTextField.getText());
        PreferencesUtilities.setProperty("tagset-path", xmlPOSFileTextField.getText());
        PreferencesUtilities.setProperty("rdb-url", this.urlTextField.getText());
        PreferencesUtilities.setProperty("rdb-username", this.usernameTextField.getText());
        PreferencesUtilities.setProperty("rdb-password", new String(passwordField.getPassword()));
        
        String playerType = "JMF-Player";
        if (quicktimeRadioButton.isSelected()) playerType = "Quicktime-Player"; 
        if (directShowRadioButton.isSelected()) playerType = "DirectShow-Player"; 
        if (elanQuicktimeRadioButton.isSelected()) playerType = "ELAN-Quicktime-Player";
        if (basRadioButton.isSelected()) playerType = "BAS-Audio-Player";
        if (jdsRadioButton.isSelected()) playerType = "JDS-Player";
        if (cocoaQTRadioButton.isSelected()) playerType = "CocoaQT-Player";
        
        PreferencesUtilities.setProperty("PlayerType", playerType);
        

        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void internalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internalRadioButtonActionPerformed
         switchViews();
    }//GEN-LAST:event_internalRadioButtonActionPerformed

    private void internalPOSRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internalPOSRadioButtonActionPerformed
        switchViews();
    }//GEN-LAST:event_internalPOSRadioButtonActionPerformed

    private void xmlPOSRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlPOSRadioButtonActionPerformed
        switchViews();
    }//GEN-LAST:event_xmlPOSRadioButtonActionPerformed

    private void browsePOSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsePOSButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("XML-Datei f�r POS-Tagset ausw�hlen/angeben");
        jfc.setFileFilter(new ParameterFileFilter("xml", "POS-Tagset-Dateien (*.xml)"));
        int v = jfc.showOpenDialog(this);
        if (v==JFileChooser.APPROVE_OPTION){
            xmlPOSFileTextField.setText(jfc.getSelectedFile().getAbsolutePath());
        }

    }//GEN-LAST:event_browsePOSButtonActionPerformed

    private void defaultAudioBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultAudioBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int approve = jfc.showOpenDialog(defaultAudioBrowseButton);
        if (approve!=JFileChooser.APPROVE_OPTION) return;
        defaultAudioTextField.setText(jfc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_defaultAudioBrowseButtonActionPerformed

    void switchViews(){
        xmlParamatersPanel.setVisible(xmlRadioButton.isSelected());
        rdbParamatersPanel.setVisible(rdbRadioButton.isSelected());
        xmlPOSParametersPanel.setVisible(xmlPOSRadioButton.isSelected());
        pack();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditPreferencesDialog dialog = new EditPreferencesDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton basRadioButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton browsePOSButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton cocoaQTRadioButton;
    private javax.swing.JButton defaultAudioBrowseButton;
    private javax.swing.JPanel defaultAudioPanel;
    private javax.swing.JTextField defaultAudioTextField;
    private javax.swing.JRadioButton directShowRadioButton;
    private javax.swing.JRadioButton elanQuicktimeRadioButton;
    private javax.swing.JRadioButton internalPOSRadioButton;
    private javax.swing.JRadioButton internalRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton jdsRadioButton;
    private javax.swing.JRadioButton jmfRadioButton;
    private javax.swing.JPanel lexiconPanel;
    private javax.swing.JPanel loopTimePanel;
    private javax.swing.JSlider loopTimeSlider;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.ButtonGroup playerButtonGroup;
    private javax.swing.JPanel playerOptionsPanel;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JRadioButton quicktimeRadioButton;
    private javax.swing.JPanel rdbParamatersPanel;
    private javax.swing.JRadioButton rdbRadioButton;
    private javax.swing.JPanel restartHintPanel;
    private javax.swing.JTextArea restartHintTextArea;
    private javax.swing.JPanel tagsetPanel;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JCheckBox useControlCheckBox;
    private javax.swing.JPanel useControlCheckBoxPanel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JTextField xmlFileTextField;
    private javax.swing.JTextField xmlPOSFileTextField;
    private javax.swing.JPanel xmlPOSParametersPanel;
    private javax.swing.JRadioButton xmlPOSRadioButton;
    private javax.swing.JPanel xmlParamatersPanel;
    private javax.swing.JRadioButton xmlRadioButton;
    // End of variables declaration//GEN-END:variables

}
