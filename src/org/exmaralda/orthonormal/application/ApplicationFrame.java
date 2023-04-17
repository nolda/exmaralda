/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ApplicationFrame.java
 *
 * Created on 03.03.2010, 13:01:16
 */

package org.exmaralda.orthonormal.application;

//import com.apple.eawt.ApplicationEvent;
import java.awt.desktop.OpenFilesEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.exmaralda.folker.gui.StartupSplashScreen;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;
import org.exmaralda.partitureditor.partiture.StringUtilities;
import org.jdom.JDOMException;

/**
 *
 * @author thomas
 */
public class ApplicationFrame extends javax.swing.JFrame implements org.exmaralda.common.ExmaraldaApplication {

    String[] HELP_MENU_TITLES = {"OrthoNormal im Web", "Über OrthoNormal", ""};
    public ApplicationControl applicationControl;

    /** Creates new form ApplicationFrame
     * @param args */
    public ApplicationFrame(String[] args) {
        new StartupSplashScreen(this, "/org/exmaralda/orthonormal/gui/splashscreen.png");

        org.exmaralda.common.Logger.initialiseLogger(this);

        initComponents();

        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/gui/folkerlogo.png")).getImage());

        applicationControl = new ApplicationControl(this);  
        applicationControl.assignActions();

        pack();

        applicationControl.assignKeyboardShortcuts();
        applicationControl.retrieveSettings();

        contributionTableScrollPane.setViewportView(applicationControl.contributionListTable);

        // if this is a MAC OS: init the MAC OS X specific actions (added 27-05-2019: issue #184)
        String os = System.getProperty("os.name").substring(0,3);
        if (os.equalsIgnoreCase("mac")) {
            // added 03-03-2010
            //setupMacOSXApplicationListener();
            // new 02-03-2020
            java.awt.Desktop.getDesktop().setOpenFileHandler(new java.awt.desktop.OpenFilesHandler(){
                    @Override
                    public void openFiles(OpenFilesEvent e){
                        try{
                            boolean proceed = true;
                            if (applicationControl.DOCUMENT_CHANGED){
                                proceed = applicationControl.checkSave();
                            }
                            if (!proceed) return;
                            String fileNameToOpen = e.getFiles().get(0).getAbsolutePath();
                            // dirty fix for #216
                            File fileToOpen = new File(StringUtilities.fixFilePath(fileNameToOpen));                                                        
                            //File fileToOpen = new File(fileNameToOpen);
                            applicationControl.openTranscriptionFile(fileToOpen);
                        } catch (Exception ex){
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage());
                        }
                    }
            });
            
        }

        if (args.length>0){
            String fileNameToOpen = args[0];
            // dirty fix for #216
            File fileToOpen = new File(StringUtilities.fixFilePath(fileNameToOpen));                                                        
            //File fileToOpen = new File(fileNameToOpen);
            if ((fileNameToOpen.toLowerCase().endsWith(".fln")) || ((fileNameToOpen.toLowerCase().endsWith(".flk")))){
                applicationControl.openTranscriptionFile(fileToOpen);
            } else  {
                Exception exc = new Exception("Dateiendung von \n" + fileNameToOpen + "\nwurde nicht erkannt.");
                applicationControl.displayException(exc);
            }
        }
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeButtonGroup = new javax.swing.ButtonGroup();
        filterButtonGroup = new javax.swing.ButtonGroup();
        applicationToolBar = new javax.swing.JToolBar();
        dummyPanelForCocoaQT = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        playerControlsPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        playerTypeLabel = new javax.swing.JLabel();
        playSelectionButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        sliderPanel = new javax.swing.JPanel();
        playerSlider = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        stopLabel = new javax.swing.JLabel();
        editControlsPanel = new javax.swing.JPanel();
        modePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        normalizationRadioButton = new javax.swing.JRadioButton();
        taggingRadioButton = new javax.swing.JRadioButton();
        xmlRadioButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        autoAdvanceCheckBox = new javax.swing.JCheckBox();
        correctionPanel = new javax.swing.JPanel();
        editContributionButton = new javax.swing.JButton();
        changeSpeakerButton = new javax.swing.JButton();
        changeSpeakerAbbButton = new javax.swing.JButton();
        outerSplitPane = new javax.swing.JSplitPane();
        wordListPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        wordTable = new javax.swing.JTable();
        filterPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        wordFilterRadioButton = new javax.swing.JRadioButton();
        normalFilterRadioButton = new javax.swing.JRadioButton();
        lemmaFilterRadioButton = new javax.swing.JRadioButton();
        posFilterRadioButton = new javax.swing.JRadioButton();
        filterTextField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        wordListButtonPanel = new javax.swing.JPanel();
        splitWordsToggleButton = new javax.swing.JToggleButton();
        oovToggleButton = new javax.swing.JToggleButton();
        normalisationRatioButton = new javax.swing.JButton();
        mainSplitPane = new javax.swing.JSplitPane();
        contributionTableScrollPane = new javax.swing.JScrollPane();
        editPanelScrollPane = new javax.swing.JScrollPane();
        editPanel = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        statusMessageLabel = new javax.swing.JLabel();
        applicationMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();
        showMatchListCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        annotationMenu = new javax.swing.JMenu();
        helpMenu = new org.exmaralda.common.application.HelpMenu("Hilfe", this, HELP_MENU_TITLES, "http://agd.ids-mannheim.de/folker.shtml")
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OrthoNormal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        applicationToolBar.setRollover(true);

        dummyPanelForCocoaQT.setMaximumSize(new java.awt.Dimension(1, 1));
        dummyPanelForCocoaQT.setMinimumSize(new java.awt.Dimension(1, 1));
        dummyPanelForCocoaQT.setPreferredSize(new java.awt.Dimension(1, 1));
        dummyPanelForCocoaQT.setLayout(new javax.swing.BoxLayout(dummyPanelForCocoaQT, javax.swing.BoxLayout.LINE_AXIS));
        applicationToolBar.add(dummyPanelForCocoaQT);

        getContentPane().add(applicationToolBar, java.awt.BorderLayout.NORTH);

        mainPanel.setLayout(new java.awt.BorderLayout());

        playerControlsPanel.setLayout(new javax.swing.BoxLayout(playerControlsPanel, javax.swing.BoxLayout.LINE_AXIS));

        buttonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        playerTypeLabel.setForeground(java.awt.Color.gray);
        playerTypeLabel.setText("jLabel1");
        buttonPanel.add(playerTypeLabel);

        playSelectionButton.setText("jButton1");
        buttonPanel.add(playSelectionButton);

        playButton.setText("jButton1");
        buttonPanel.add(playButton);

        stopButton.setText("jButton1");
        buttonPanel.add(stopButton);

        playerControlsPanel.add(buttonPanel);

        sliderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sliderPanel.setLayout(new java.awt.BorderLayout());

        playerSlider.setBackground(new java.awt.Color(255, 255, 255));
        playerSlider.setMaximumSize(new java.awt.Dimension(500, 20));
        playerSlider.setMinimumSize(new java.awt.Dimension(100, 20));
        playerSlider.setPreferredSize(new java.awt.Dimension(400, 20));
        sliderPanel.add(playerSlider, java.awt.BorderLayout.CENTER);

        startLabel.setForeground(new java.awt.Color(51, 153, 0));
        startLabel.setText("-");
        startLabel.setToolTipText("Startzeit");
        jPanel1.add(startLabel);

        positionLabel.setText("-");
        positionLabel.setToolTipText("Startzeit");
        jPanel1.add(positionLabel);

        stopLabel.setForeground(new java.awt.Color(255, 0, 0));
        stopLabel.setText("-");
        stopLabel.setToolTipText("Startzeit");
        jPanel1.add(stopLabel);

        sliderPanel.add(jPanel1, java.awt.BorderLayout.NORTH);

        playerControlsPanel.add(sliderPanel);

        mainPanel.add(playerControlsPanel, java.awt.BorderLayout.PAGE_START);

        editControlsPanel.setLayout(new java.awt.BorderLayout());

        modePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Modus"));
        modePanel.setLayout(new javax.swing.BoxLayout(modePanel, javax.swing.BoxLayout.Y_AXIS));

        modeButtonGroup.add(normalizationRadioButton);
        normalizationRadioButton.setSelected(true);
        normalizationRadioButton.setText("Normalisieren");
        normalizationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalizationRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(normalizationRadioButton);

        modeButtonGroup.add(taggingRadioButton);
        taggingRadioButton.setText("Tagging");
        taggingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taggingRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(taggingRadioButton);

        modeButtonGroup.add(xmlRadioButton);
        xmlRadioButton.setText("XML");
        xmlRadioButton.setEnabled(false);
        xmlRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xmlRadioButtonMouseClicked(evt);
            }
        });
        xmlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(xmlRadioButton);

        modePanel.add(jPanel2);

        autoAdvanceCheckBox.setText("Automatisches Weiterrücken");
        autoAdvanceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoAdvanceCheckBoxActionPerformed(evt);
            }
        });
        jPanel3.add(autoAdvanceCheckBox);

        modePanel.add(jPanel3);

        editControlsPanel.add(modePanel, java.awt.BorderLayout.EAST);

        correctionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Korrekturen"));

        editContributionButton.setText("Beitrag bearbeiten...");
        editContributionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContributionButtonActionPerformed(evt);
            }
        });
        correctionPanel.add(editContributionButton);

        changeSpeakerButton.setText("Sprecherzuordnung ändern...");
        changeSpeakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSpeakerButtonActionPerformed(evt);
            }
        });
        correctionPanel.add(changeSpeakerButton);

        changeSpeakerAbbButton.setText("Sprecherkürzel ändern...");
        changeSpeakerAbbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSpeakerAbbButtonActionPerformed(evt);
            }
        });
        correctionPanel.add(changeSpeakerAbbButton);

        editControlsPanel.add(correctionPanel, java.awt.BorderLayout.WEST);

        mainPanel.add(editControlsPanel, java.awt.BorderLayout.PAGE_END);

        wordListPanel.setLayout(new java.awt.BorderLayout());

        tablePanel.setLayout(new javax.swing.BoxLayout(tablePanel, javax.swing.BoxLayout.LINE_AXIS));

        wordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Wort", "Normalisiert"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        wordTable.setRowHeight(18);
        tableScrollPane.setViewportView(wordTable);

        tablePanel.add(tableScrollPane);

        wordListPanel.add(tablePanel, java.awt.BorderLayout.CENTER);

        filterPanel.setLayout(new javax.swing.BoxLayout(filterPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        filterButtonGroup.add(wordFilterRadioButton);
        wordFilterRadioButton.setSelected(true);
        wordFilterRadioButton.setText("Wort");
        jPanel5.add(wordFilterRadioButton);

        filterButtonGroup.add(normalFilterRadioButton);
        normalFilterRadioButton.setText("Normal");
        jPanel5.add(normalFilterRadioButton);

        filterButtonGroup.add(lemmaFilterRadioButton);
        lemmaFilterRadioButton.setText("Lemma");
        jPanel5.add(lemmaFilterRadioButton);

        filterButtonGroup.add(posFilterRadioButton);
        posFilterRadioButton.setText("POS");
        jPanel5.add(posFilterRadioButton);

        filterPanel.add(jPanel5);

        filterTextField.setMaximumSize(new java.awt.Dimension(300, 20));
        filterTextField.setMinimumSize(new java.awt.Dimension(50, 20));
        filterTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        filterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTextFieldActionPerformed(evt);
            }
        });
        filterPanel.add(filterTextField);

        filterButton.setText("Filtern");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        filterPanel.add(filterButton);

        wordListPanel.add(filterPanel, java.awt.BorderLayout.PAGE_START);

        wordListButtonPanel.setLayout(new javax.swing.BoxLayout(wordListButtonPanel, javax.swing.BoxLayout.LINE_AXIS));

        splitWordsToggleButton.setText("ab|cd");
        splitWordsToggleButton.setToolTipText("Wörter an Segmentgrenzen");
        splitWordsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splitWordsToggleButtonActionPerformed(evt);
            }
        });
        wordListButtonPanel.add(splitWordsToggleButton);

        oovToggleButton.setBackground(new java.awt.Color(255, 0, 0));
        oovToggleButton.setText("OOV");
        oovToggleButton.setToolTipText("Out of Vocabulary-Wörter");
        oovToggleButton.setOpaque(true);
        oovToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oovToggleButtonActionPerformed(evt);
            }
        });
        wordListButtonPanel.add(oovToggleButton);

        normalisationRatioButton.setText("%");
        normalisationRatioButton.setToolTipText("Normalisierungsquote berechnen");
        normalisationRatioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalisationRatioButtonActionPerformed(evt);
            }
        });
        wordListButtonPanel.add(normalisationRatioButton);

        wordListPanel.add(wordListButtonPanel, java.awt.BorderLayout.SOUTH);

        outerSplitPane.setRightComponent(wordListPanel);

        mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        mainSplitPane.setLeftComponent(contributionTableScrollPane);

        editPanel.setBackground(new java.awt.Color(255, 255, 255));
        editPanel.setPreferredSize(new java.awt.Dimension(500, 5000));
        editPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        editPanelScrollPane.setViewportView(editPanel);

        mainSplitPane.setRightComponent(editPanelScrollPane);

        outerSplitPane.setLeftComponent(mainSplitPane);

        mainPanel.add(outerSplitPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        statusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        statusPanel.setLayout(new javax.swing.BoxLayout(statusPanel, javax.swing.BoxLayout.LINE_AXIS));

        statusMessageLabel.setText("status");
        statusPanel.add(statusMessageLabel);

        getContentPane().add(statusPanel, java.awt.BorderLayout.SOUTH);

        fileMenu.setText("Datei");
        applicationMenuBar.add(fileMenu);

        editMenu.setText("Bearbeiten");
        applicationMenuBar.add(editMenu);

        viewMenu.setText("Ansicht");

        showMatchListCheckBoxMenuItem.setText("Trefferliste");
        showMatchListCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMatchListCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(showMatchListCheckBoxMenuItem);

        applicationMenuBar.add(viewMenu);

        annotationMenu.setText("Annotation");
        applicationMenuBar.add(annotationMenu);

        helpMenu.setText("Hilfe");
        applicationMenuBar.add(helpMenu);

        setJMenuBar(applicationMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void normalizationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalizationRadioButtonActionPerformed
        changeMode();
    }//GEN-LAST:event_normalizationRadioButtonActionPerformed

    private void taggingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taggingRadioButtonActionPerformed
        changeMode();   
    }//GEN-LAST:event_taggingRadioButtonActionPerformed

    private void autoAdvanceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoAdvanceCheckBoxActionPerformed
        applicationControl.autoAdvance = autoAdvanceCheckBox.isSelected();
    }//GEN-LAST:event_autoAdvanceCheckBoxActionPerformed

    private void xmlRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlRadioButtonActionPerformed
        changeMode();
    }//GEN-LAST:event_xmlRadioButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        filter();
    }//GEN-LAST:event_filterButtonActionPerformed

    private void filterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTextFieldActionPerformed
        filter();
    }//GEN-LAST:event_filterTextFieldActionPerformed

    private void editContributionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContributionButtonActionPerformed
        applicationControl.editContribution();
    }//GEN-LAST:event_editContributionButtonActionPerformed

    private void changeSpeakerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSpeakerButtonActionPerformed
        applicationControl.changeSpeaker();
    }//GEN-LAST:event_changeSpeakerButtonActionPerformed

    private void showMatchListCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMatchListCheckBoxMenuItemActionPerformed
        applicationControl.toggleMatchList(showMatchListCheckBoxMenuItem.isSelected());
    }//GEN-LAST:event_showMatchListCheckBoxMenuItemActionPerformed

    private void splitWordsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splitWordsToggleButtonActionPerformed
        applicationControl.filterSplitWords(splitWordsToggleButton.isSelected());
    }//GEN-LAST:event_splitWordsToggleButtonActionPerformed

    private void xmlRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xmlRadioButtonMouseClicked
        if (evt.getClickCount()==2){
            String pw = JOptionPane.showInputDialog(this, "Passwort zum Entsperren der XML-Funktionalität?");
            xmlRadioButton.setEnabled("reklof".equals(pw));
        }
    }//GEN-LAST:event_xmlRadioButtonMouseClicked

    private void normalisationRatioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalisationRatioButtonActionPerformed
        double ratio = applicationControl.getTranscription().getNormalisationRatio();
        JOptionPane.showMessageDialog(this, 
                "Die Normalisierungsquote für dieses Dokument ist:\n" + Double.toString(ratio * 100) + "%");
    }//GEN-LAST:event_normalisationRatioButtonActionPerformed

    private void oovToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oovToggleButtonActionPerformed
        applicationControl.filterOutOfVocabularyWords(oovToggleButton.isSelected());
    }//GEN-LAST:event_oovToggleButtonActionPerformed

    private void changeSpeakerAbbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSpeakerAbbButtonActionPerformed
        try {
            applicationControl.changeSpeakerAbbreviations();
        } catch (JDOMException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
            applicationControl.displayException(ex);
        }
    }//GEN-LAST:event_changeSpeakerAbbButtonActionPerformed

    private void changeMode(){
        if (normalizationRadioButton.isSelected()){
            applicationControl.mode = ApplicationControl.NORMALIZATION_MODE;            
        } else if (taggingRadioButton.isSelected()){
            applicationControl.mode = ApplicationControl.TAGGING_MODE;            
        } else if (xmlRadioButton.isSelected()){
            applicationControl.mode = ApplicationControl.XML_MODE;                        
        } /*else if (correctionRadioButton.isSelected()){
            applicationControl.mode = ApplicationControl.CORRECTION_MODE;                        
        }*/
        //lemmaFilterRadioButton.setVisible(taggingRadioButton.isSelected());
        //posFilterRadioButton.setVisible(taggingRadioButton.isSelected());
        applicationControl.valueChanged(null);
        // no idea why this should be necessary...
        applicationControl.setWordListCellRenderers();                
    }
    
    private void filter(){
        int column = 1;
        if (normalFilterRadioButton.isSelected()) column=2;
        if (lemmaFilterRadioButton.isSelected()) column=3;
        if (posFilterRadioButton.isSelected()) column=4;
        applicationControl.filter(filterTextField.getText(), column);        
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        // added 09-11-2022: issue #344
        System.setProperty("apple.awt.application.name", "OrthoNormal");        
        try{
            System.out.println("Setting system L&F : " + javax.swing.UIManager.getSystemLookAndFeelClassName());
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
                e.printStackTrace();
        }

        final String[] theArgs = args;

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationFrame af = new ApplicationFrame(theArgs);
                af.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JMenu annotationMenu;
    private javax.swing.JMenuBar applicationMenuBar;
    public javax.swing.JToolBar applicationToolBar;
    private javax.swing.JCheckBox autoAdvanceCheckBox;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton changeSpeakerAbbButton;
    private javax.swing.JButton changeSpeakerButton;
    public javax.swing.JScrollPane contributionTableScrollPane;
    private javax.swing.JPanel correctionPanel;
    javax.swing.JPanel dummyPanelForCocoaQT;
    private javax.swing.JButton editContributionButton;
    private javax.swing.JPanel editControlsPanel;
    public javax.swing.JMenu editMenu;
    public javax.swing.JPanel editPanel;
    public javax.swing.JScrollPane editPanelScrollPane;
    public javax.swing.JMenu fileMenu;
    javax.swing.JButton filterButton;
    private javax.swing.ButtonGroup filterButtonGroup;
    private javax.swing.JPanel filterPanel;
    javax.swing.JTextField filterTextField;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton lemmaFilterRadioButton;
    javax.swing.JPanel mainPanel;
    public javax.swing.JSplitPane mainSplitPane;
    private javax.swing.ButtonGroup modeButtonGroup;
    private javax.swing.JPanel modePanel;
    private javax.swing.JRadioButton normalFilterRadioButton;
    private javax.swing.JButton normalisationRatioButton;
    private javax.swing.JRadioButton normalizationRadioButton;
    private javax.swing.JToggleButton oovToggleButton;
    javax.swing.JSplitPane outerSplitPane;
    public javax.swing.JButton playButton;
    public javax.swing.JButton playSelectionButton;
    javax.swing.JPanel playerControlsPanel;
    public javax.swing.JSlider playerSlider;
    javax.swing.JLabel playerTypeLabel;
    private javax.swing.JRadioButton posFilterRadioButton;
    public javax.swing.JLabel positionLabel;
    public javax.swing.JCheckBoxMenuItem showMatchListCheckBoxMenuItem;
    private javax.swing.JPanel sliderPanel;
    private javax.swing.JToggleButton splitWordsToggleButton;
    public javax.swing.JLabel startLabel;
    public javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    public javax.swing.JButton stopButton;
    public javax.swing.JLabel stopLabel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JRadioButton taggingRadioButton;
    public javax.swing.JMenu viewMenu;
    private javax.swing.JRadioButton wordFilterRadioButton;
    private javax.swing.JPanel wordListButtonPanel;
    private javax.swing.JPanel wordListPanel;
    public javax.swing.JTable wordTable;
    javax.swing.JRadioButton xmlRadioButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getVersion() {
       return org.exmaralda.common.EXMARaLDAConstants.ORTHONORMAL_VERSION;
    }

    @Override
    public String getApplicationName() {
        return "OrthoNormal";
    }

    @Override
    public String getPreferencesNode() {
        return "org.exmaralda.orthonormal";
    }

    @Override
    public ImageIcon getWelcomeScreen() {
        return new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/orthonormal/gui/splashscreen.png"));
    }
    
    @Override
    public void resetSettings(){
        try {
            java.util.prefs.Preferences.userRoot().node(getPreferencesNode()).clear();                
            JOptionPane.showMessageDialog(rootPane, "Preferences reset.\nRestart the editor.");
        } catch (BackingStoreException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Problem resetting preferences:\n" + ex.getLocalizedMessage());
        }        
    }  
    

    /** added 27-05-2019: issue # 184*/
    /** removed 05-12-2019: issue # 199*/
    /*private void setupMacOSXApplicationListener() {
        final com.apple.eawt.Application application = com.apple.eawt.Application.getApplication();
        application.setEnabledAboutMenu(true); // damit ein "Ueber " Menu erscheint
        application.addPreferencesMenuItem(); // "Einstellen..." Dialog
        application.setEnabledPreferencesMenu(true); // diesen Dialog auch
        application.addApplicationListener(new com.apple.eawt.ApplicationListener() {

            @Override
            public void handleAbout(com.apple.eawt.ApplicationEvent ae) {
                ((HelpMenu)helpMenu).aboutAction.actionPerformed(null);
                ae.setHandled(true); // habe fertig...
            }

            // app wird ueber den finder geoeffnet. wie auch sonst.
            // (lies: total unnuetz!)
            @Override
            public void handleOpenApplication(ApplicationEvent ae) {
            }

            @Override
            public void handlePreferences(ApplicationEvent ae) {
                applicationControl.editPreferencesAction.actionPerformed(null);
                ae.setHandled(true);
            }

            @Override
            public void handlePrintFile(ApplicationEvent ae) {
                System.out.println("Drucken?!");
                JOptionPane.showMessageDialog(rootPane, "Drucken wird nicht unterstuetzt.\b Bitte nutzen Sie die Funktionen unter\bDatei > Ausgabe...");
                ae.setHandled(true);
            }

            @Override
            public void handleQuit(ApplicationEvent ae) {
                boolean reallyQuit = applicationControl.exitApplication();
                ae.setHandled(reallyQuit); // da wird wohl nichts mehr draus!
            }

            // anwendung laeuft bereits und jemand startet es nochmal
            @Override
            public void handleReOpenApplication(ApplicationEvent ae) {
                System.out.println("Laeuft schon");
                // will ich mehrere instanzen? nein
                //JOptionPane.showMessageDialog(new JFrame(), "You already have an instance\nof the EXMARaLDA Partitur-Editor running.");
                ae.setHandled(true);
            }

            // anwendung laeuft schon, dokument wird ueber den finder geoeffnet
            @Override
            public void handleOpenFile(ApplicationEvent ae) {
                try{
                    boolean proceed = true;
                    if (applicationControl.DOCUMENT_CHANGED){
                        proceed = applicationControl.checkSave();
                    }
                    if (!proceed) return;
                    String fileNameToOpen = ae.getFilename();
                    File fileToOpen = new File(fileNameToOpen);
                    applicationControl.openTranscriptionFile(fileToOpen);
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, e.getLocalizedMessage());
                }
            }
           });
	}*/
    
    
    
}
