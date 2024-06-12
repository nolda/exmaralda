/*
 * ApplicationFrame.java
 *
 * Created on 9. Mai 2008, 14:08
 */

package org.exmaralda.folker.application;

//import com.apple.eawt.ApplicationEvent;
import java.awt.desktop.OpenFilesEvent;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import org.exmaralda.common.application.ProConnector;
import org.exmaralda.folker.gui.StartupSplashScreen;
import org.exmaralda.folker.utilities.FOLKERInternationalizer;
import org.exmaralda.partitureditor.partiture.StringUtilities;
import org.exmaralda.pro.ProUtilities;
import org.exmaralda.pro.swing.GetRegisteredDialog;

/**
 *
 * @author  Thomas
 */
public class ApplicationFrame extends javax.swing.JFrame implements org.exmaralda.common.ExmaraldaApplication {
    
    
    ApplicationControl applicationControl;
    MainPanel mainPanel;

    String[] HELP_MENU_TITLES = {FOLKERInternationalizer.getString("help_menu.web"), FOLKERInternationalizer.getString("help_menu.about"), ""};

    /** Creates new form ApplicationFrame */
    public ApplicationFrame(String[] args) {
        new StartupSplashScreen(this);

        org.exmaralda.common.Logger.initialiseLogger(this);
        
        initComponents();

        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/gui/folkerlogo.png")).getImage());
        
        applicationControl = new ApplicationControl(this);
        mainPanel = new MainPanel(applicationControl);
        
        applicationControl.assignActions();
        mainPanel.textViewsTabbedPane.addChangeListener(applicationControl);
        mainPanel.textViewsTabbedPane.setEnabledAt(1,false);
        mainPanel.textViewsTabbedPane.setEnabledAt(2,false);

        applicationControl.setAddEventInvoker(mainPanel.addEventInPartiturButton);

        
        getContentPane().add(mainPanel);
        
        pack();

        applicationControl.assignKeyboardShortcuts();
        
        applicationControl.retrieveSettings();
        
        applicationControl.displayRateSpinner();
        
        this.initProActions();

        // if this is a MAC OS: init the MAC OS X specific actions
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
                        if (!(fileNameToOpen.toLowerCase().endsWith(".wav"))){
                            applicationControl.openTranscriptionFile(fileToOpen);
                        } else {
                            applicationControl.newTranscriptionFile(fileToOpen);
                        }
                    } catch (Exception ex){
                        Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);  
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
            if (!(fileNameToOpen.toLowerCase().endsWith(".wav"))){
                applicationControl.openTranscriptionFile(fileToOpen);
            } else {
                applicationControl.newTranscriptionFile(fileToOpen);
            }
        }

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        applicationToolBar = new javax.swing.JToolBar();
        dummyPanelForCocoaQT = new javax.swing.JPanel();
        applicationMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();
        showVirtualKeyboardCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        showQuickTranscriptionCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        showMatchListCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        showVideoPanelCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        transcriptionMenu = new javax.swing.JMenu();
        helpMenu = new org.exmaralda.common.application.HelpMenu("Hilfe", this, HELP_MENU_TITLES, "https://exmaralda.org/de/folker-de/");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(getApplicationName() + " " + getVersion());

        applicationToolBar.setMaximumSize(new java.awt.Dimension(800, 24));
        applicationToolBar.setMinimumSize(new java.awt.Dimension(200, 24));
        applicationToolBar.setPreferredSize(new java.awt.Dimension(800, 24));

        dummyPanelForCocoaQT.setMaximumSize(new java.awt.Dimension(1, 1));
        dummyPanelForCocoaQT.setMinimumSize(new java.awt.Dimension(1, 1));
        dummyPanelForCocoaQT.setPreferredSize(new java.awt.Dimension(1, 1));
        dummyPanelForCocoaQT.setLayout(new javax.swing.BoxLayout(dummyPanelForCocoaQT, javax.swing.BoxLayout.LINE_AXIS));
        applicationToolBar.add(dummyPanelForCocoaQT);

        getContentPane().add(applicationToolBar, java.awt.BorderLayout.NORTH);

        fileMenu.setText(FOLKERInternationalizer.getString("file_menu"));
        applicationMenuBar.add(fileMenu);

        editMenu.setText(FOLKERInternationalizer.getString("edit_menu"));
        applicationMenuBar.add(editMenu);

        viewMenu.setText(FOLKERInternationalizer.getString("view_menu"));

        showVirtualKeyboardCheckBoxMenuItem.setSelected(true);
        showVirtualKeyboardCheckBoxMenuItem.setText(FOLKERInternationalizer.getString("view_menu.keyboard"));
        showVirtualKeyboardCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showVirtualKeyboardCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(showVirtualKeyboardCheckBoxMenuItem);

        showQuickTranscriptionCheckBoxMenuItem.setText(FOLKERInternationalizer.getString("view_menu.helper"));
        showQuickTranscriptionCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showQuickTranscriptionCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(showQuickTranscriptionCheckBoxMenuItem);

        showMatchListCheckBoxMenuItem.setText(FOLKERInternationalizer.getString("view_menu.matchlist"));
        showMatchListCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMatchListCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(showMatchListCheckBoxMenuItem);

        showVideoPanelCheckBoxMenuItem.setText(FOLKERInternationalizer.getString("view_menu.videopanel"));
        showVideoPanelCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showVideoPanelCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(showVideoPanelCheckBoxMenuItem);

        applicationMenuBar.add(viewMenu);

        transcriptionMenu.setText(FOLKERInternationalizer.getString("transcription_menu"));
        applicationMenuBar.add(transcriptionMenu);

        helpMenu.setText(FOLKERInternationalizer.getString("help_menu"));
        applicationMenuBar.add(helpMenu);

        setJMenuBar(applicationMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showQuickTranscriptionCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showQuickTranscriptionCheckBoxMenuItemActionPerformed
        applicationControl.toggleQuickTranscriptionDialog(showQuickTranscriptionCheckBoxMenuItem.isSelected());
    }//GEN-LAST:event_showQuickTranscriptionCheckBoxMenuItemActionPerformed

    private void showVirtualKeyboardCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showVirtualKeyboardCheckBoxMenuItemActionPerformed
        applicationControl.toggleVirtualKeyboard(showVirtualKeyboardCheckBoxMenuItem.isSelected());
}//GEN-LAST:event_showVirtualKeyboardCheckBoxMenuItemActionPerformed

    private void showMatchListCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMatchListCheckBoxMenuItemActionPerformed
        applicationControl.toggleMatchList(showMatchListCheckBoxMenuItem.isSelected());
    }//GEN-LAST:event_showMatchListCheckBoxMenuItemActionPerformed

    private void showVideoPanelCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showVideoPanelCheckBoxMenuItemActionPerformed
        applicationControl.toggleVideoPanel(showVideoPanelCheckBoxMenuItem.isSelected());
    }//GEN-LAST:event_showVideoPanelCheckBoxMenuItemActionPerformed
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // added 09-11-2022: issue #344
        System.setProperty("apple.awt.application.name", "FOLKER");        
        try {
            System.out.println("Setting system L&F : " + javax.swing.UIManager.getSystemLookAndFeelClassName());
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (java.lang.ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);              
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

    /** returns the icon associated with this application
     * @return  */
    @Override
    public java.awt.Image getIconImage(){
        return new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/gui/folkerlogo.png")).getImage();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar applicationMenuBar;
    public javax.swing.JToolBar applicationToolBar;
    javax.swing.JPanel dummyPanelForCocoaQT;
    public javax.swing.JMenu editMenu;
    public javax.swing.JMenu fileMenu;
    public javax.swing.JMenu helpMenu;
    javax.swing.JCheckBoxMenuItem showMatchListCheckBoxMenuItem;
    javax.swing.JCheckBoxMenuItem showQuickTranscriptionCheckBoxMenuItem;
    javax.swing.JCheckBoxMenuItem showVideoPanelCheckBoxMenuItem;
    javax.swing.JCheckBoxMenuItem showVirtualKeyboardCheckBoxMenuItem;
    public javax.swing.JMenu transcriptionMenu;
    javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getVersion() {
       return org.exmaralda.common.EXMARaLDAConstants.FOLKER_VERSION;
    }

    @Override
    public String getApplicationName() {
        return "Folker";
    }

    @Override
    public String getPreferencesNode() {
        return "org.exmaralda.folker";
    }

    @Override
    public ImageIcon getWelcomeScreen() {
        return new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/gui/splashscreen.png"));
    }
    
    @Override
    public void resetSettings(){
        try {
            java.util.prefs.Preferences.userRoot().node(getPreferencesNode()).clear();                
            JOptionPane.showMessageDialog(rootPane, "<html>Preferences reset.<br/><b>Restart the editor.</b></html>");
        } catch (BackingStoreException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);  
            JOptionPane.showMessageDialog(rootPane, "Problem resetting preferences:\n" + ex.getLocalizedMessage());
        }        
    }
    
    private void initProActions() {
        boolean isProPresent = ProConnector.isProPresent();
        if (!isProPresent){
            //JOptionPane.showMessageDialog(rootPane, "No Pro, bro!");
            return;
        }
        //JOptionPane.showMessageDialog(rootPane, "we are pro, bro!");
        ProUtilities proUtilities = new ProUtilities(this);
        boolean isRegisteredUser = proUtilities.isRegisteredUser();
        int usagesIncludingThisOne = proUtilities.incrementUsageCount();
        System.out.println("Usage counter: " + usagesIncludingThisOne);
        if ((usagesIncludingThisOne%5==0) && !isRegisteredUser){
        //if (true){
            GetRegisteredDialog getRegisteredDialog = new GetRegisteredDialog(this, true);
            getRegisteredDialog.setLocationRelativeTo(this);
            String htmlText = proUtilities.getRegisterText();
            getRegisteredDialog.setText(htmlText);
            getRegisteredDialog.setVisible(true);
        }
    }
    
    
}
