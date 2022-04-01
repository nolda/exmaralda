/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LiveTimelineSegmenationDialog.java
 *
 * Created on 28.04.2009, 12:27:40
 */

package org.exmaralda.partitureditor.sound;

import java.awt.Component;
import java.io.IOException;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.exmaralda.folker.utilities.TimeStringFormatter;

/**
 *
 * @author thomas
 */
public class LiveTimelineSegmentationDialog extends javax.swing.JDialog implements PlayableListener {

    Playable player;
    DefaultListModel listModel = new DefaultListModel();
    boolean started = false;
    Vector<Double> times = new Vector<Double>();


    /** Creates new form LiveTimelineSegmenationDialog */
    public LiveTimelineSegmentationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.playToggleButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        jPanel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "doSomething");
        jPanel1.getActionMap().put("doSomething", new LiveTimelineSegmentationAction(this));
        tliList.setModel(listModel);
    }

    public void setPlayer(Playable p){
        player = p;
        player.addPlayableListener(this);
    }

    public Playable getPlayer() {
        return player;
    }


    public void setMedia(String url) throws IOException{
        player.setSoundFile(url);
        player.setStartTime(0.0);
        player.setEndTime(player.getTotalLength());
        setupVideo();
    }

    void processAction() {
        double t = player.getCurrentPosition();
        //System.out.println("Adding " + t);
        if ((times.size()>0) && maxIntervalCheckBox.isSelected()){
            double lastTime = times.get(times.size()-1);
            int maxTime = ((Integer)maxIntervalSpinner.getValue());
            if ((t - lastTime) > maxTime){
                int intermediateIntervalCount = ((int) (t-lastTime)) / (int) maxTime +1;
                double intermediateIntervalLength = (t-lastTime)/intermediateIntervalCount;
                for (double time=lastTime + intermediateIntervalLength; time<t; time+=intermediateIntervalLength){
                    times.addElement(time);
                    String timeString = "[" + TimeStringFormatter.formatMiliseconds(time*1000.0,2) + "]";
                    listModel.addElement(timeString);
                    tliList.scrollRectToVisible(tliList.getCellBounds(listModel.size()-1, listModel.size()-1));
                    tliList.setSelectedIndex(listModel.size()-1);
                }
            }
        }
        times.addElement(t);
        String time = "[" + TimeStringFormatter.formatMiliseconds(t*1000.0,2) + "]";
        listModel.addElement(time);
        tliList.scrollRectToVisible(tliList.getCellBounds(listModel.size()-1, listModel.size()-1));
        tliList.setSelectedIndex(listModel.size()-1);
    }

    public Vector<Double> getTimes(){
        if (!(this.equidistantCheckBox.isSelected())){
            return times;
        } else {
            Vector<Double> otherTimes = new Vector<Double>();
            double intervalLength = ((Integer)maxIntervalSpinner.getValue()).intValue();
            for (double d = 0.0; d<this.getPlayer().getTotalLength(); d+=intervalLength){
                otherTimes.add(d);
            }
            return otherTimes;
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

        jPanel1 = new javax.swing.JPanel();
        playerControlsPanel = new javax.swing.JPanel();
        playToggleButton = new javax.swing.JToggleButton();
        videoDisplayPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tliList = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        maxIntervalCheckBox = new javax.swing.JCheckBox();
        maxIntervalSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        equidistantCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialogClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        playToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/partitureditor/sound/Start.gif"))); // NOI18N
        playToggleButton.setToolTipText("Play/Pause");
        playToggleButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/partitureditor/sound/Pause.gif"))); // NOI18N
        playToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playToggleButtonActionPerformed(evt);
            }
        });
        playerControlsPanel.add(playToggleButton);

        jPanel1.add(playerControlsPanel, java.awt.BorderLayout.SOUTH);
        jPanel1.add(videoDisplayPanel, java.awt.BorderLayout.CENTER);

        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 24));
        timeLabel.setText("00:00.00");
        jPanel2.add(timeLabel);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel3.add(okButton);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(tliList);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Press the start button to playback the recording from the beginning. Hit <SPACE> to insert a new timeline item.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel5.add(jScrollPane2);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        maxIntervalCheckBox.setSelected(true);
        maxIntervalCheckBox.setText("Maximum interval length: ");
        maxIntervalCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxIntervalCheckBoxActionPerformed(evt);
            }
        });
        jPanel6.add(maxIntervalCheckBox);

        maxIntervalSpinner.setModel(new javax.swing.SpinnerNumberModel(5, 1, 20, 1));
        jPanel6.add(maxIntervalSpinner);

        jLabel1.setText("seconds");
        jPanel6.add(jLabel1);

        jPanel7.add(jPanel6);

        equidistantCheckBox.setText("Make equidistant times with maximum interval length");
        equidistantCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equidistantCheckBoxActionPerformed(evt);
            }
        });
        jPanel8.add(equidistantCheckBox);

        jPanel7.add(jPanel8);

        jPanel4.add(jPanel7, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playToggleButtonActionPerformed
        if (playToggleButton.isSelected()){
            if (!started){
                player.startPlayback();
                started=true;
            } else {
                player.resumePlayback();
            }
        } else {
            player.haltPlayback();
        }
    }//GEN-LAST:event_playToggleButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        player.stopPlayback();
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void maxIntervalCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxIntervalCheckBoxActionPerformed
        requestFocus();
    }//GEN-LAST:event_maxIntervalCheckBoxActionPerformed

    private void dialogClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogClosing
        player.stopPlayback();
    }//GEN-LAST:event_dialogClosing

    private void equidistantCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equidistantCheckBoxActionPerformed
        player.stopPlayback();
        playToggleButton.setEnabled(!(equidistantCheckBox.isSelected()));
    }//GEN-LAST:event_equidistantCheckBoxActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LiveTimelineSegmentationDialog dialog = new LiveTimelineSegmentationDialog(new javax.swing.JFrame(), true);
                dialog.setPlayer(new JDSPlayer());
                try {
                    dialog.setMedia("T:\\TP-Z2\\DATEN\\EXMARaLDA_DemoKorpus\\MyTheory\\MyTheory.avi");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
    private javax.swing.JCheckBox equidistantCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JCheckBox maxIntervalCheckBox;
    private javax.swing.JSpinner maxIntervalSpinner;
    private javax.swing.JButton okButton;
    private javax.swing.JToggleButton playToggleButton;
    private javax.swing.JPanel playerControlsPanel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JList tliList;
    private javax.swing.JPanel videoDisplayPanel;
    // End of variables declaration//GEN-END:variables

    private void setupVideo() {
        // added 18-03-2005
        videoDisplayPanel.removeAll();

        /*if (getPlayer() instanceof JMFPlayer){
            JMFPlayer jmfp = (JMFPlayer)getPlayer();
            if (jmfp.getVisibleComponent()!=null){
                Component c = jmfp.getVisibleComponent();
                videoDisplayPanel.add(c);
                //videoDisplayPanel.setPreferredSize(c.getPreferredSize());
                videoDisplayPanel.setVisible(true);
            } else {
                videoDisplayPanel.setVisible(false);
            }
        }*/

        /*if (getPlayer() instanceof ELANDSPlayer){
            ELANDSPlayer edsp = (ELANDSPlayer)getPlayer();
            // TODO
            if (edsp.getVisibleComponent()!=null){
                Component c = edsp.getVisibleComponent();
                c.setPreferredSize(new java.awt.Dimension(
                        edsp.wrappedPlayer.getSourceWidth(),
                        edsp.wrappedPlayer.getSourceHeight()));
                videoDisplayPanel.add(c);
                videoDisplayPanel.setPreferredSize(c.getPreferredSize());
                videoDisplayPanel.setVisible(true);
            } else {
                videoDisplayPanel.setVisible(false);
            }
        }*/

        if (getPlayer() instanceof JDSPlayer){
            JDSPlayer edsp = (JDSPlayer)getPlayer();
            // TODO
            if (edsp.getVisibleComponent()!=null){
                Component c = edsp.getVisibleComponent();
                c.setPreferredSize(new java.awt.Dimension(
                        edsp.wrappedPlayer.getSourceWidth(),
                        edsp.wrappedPlayer.getSourceHeight()));
                videoDisplayPanel.add(c);
                videoDisplayPanel.setPreferredSize(c.getPreferredSize());
                videoDisplayPanel.setVisible(true);
            } else {
                videoDisplayPanel.setVisible(false);
            }
        }

        if (getPlayer() instanceof JavaFXPlayer){
            JavaFXPlayer edsp = (JavaFXPlayer)getPlayer();
            // TODO
            if (edsp.getVisibleComponent()!=null){
                Component c = edsp.getVisibleComponent();
                c.setPreferredSize(new java.awt.Dimension(
                        edsp.wrappedPlayer.getSourceWidth(),
                        edsp.wrappedPlayer.getSourceHeight()));
                videoDisplayPanel.add(c);
                videoDisplayPanel.setPreferredSize(c.getPreferredSize());
                videoDisplayPanel.setVisible(true);
            } else {
                videoDisplayPanel.setVisible(false);
            }
        }

        if (getPlayer() instanceof AVFPlayer){
            AVFPlayer edsp = (AVFPlayer)getPlayer();
            // TODO
            if (edsp.getVisibleComponent()!=null){
                Component c = edsp.getVisibleComponent();
                c.setPreferredSize(new java.awt.Dimension(
                        edsp.wrappedPlayer.getSourceWidth(),
                        edsp.wrappedPlayer.getSourceHeight()));
                videoDisplayPanel.add(c);
                videoDisplayPanel.setPreferredSize(c.getPreferredSize());
                videoDisplayPanel.setVisible(true);
            } else {
                videoDisplayPanel.setVisible(false);
            }
        }

        if (getPlayer() instanceof MMFPlayer){
            MMFPlayer edsp = (MMFPlayer)getPlayer();
            // TODO
            if (edsp.getVisibleComponent()!=null){
                Component c = edsp.getVisibleComponent();
                c.setPreferredSize(new java.awt.Dimension(
                        edsp.wrappedPlayer.getSourceWidth(),
                        edsp.wrappedPlayer.getSourceHeight()));
                videoDisplayPanel.add(c);
                videoDisplayPanel.setPreferredSize(c.getPreferredSize());
                videoDisplayPanel.setVisible(true);
            } else {
                videoDisplayPanel.setVisible(false);
            }
        }

        // ADDED BY TTT FOR version 1.3.4., April 2007
        // Load Quicktime components into the Exmaralda GUI
        // changed by TS 01-08-2008 because TTT is a honk
        /*if (getPlayer() instanceof QuicktimePlayer){

            // Create an object of QuictimeBasedPlayer
            QuicktimePlayer qtp = (QuicktimePlayer)getPlayer();

            // Get visible "Component" of QuicktimeBasedPlayer and add it to "videoDisplayPanel"
            if (qtp.getQtc().asComponent()!=null){
                videoDisplayPanel.add(qtp.getQtc().asComponent());
                this.setResizable(true);// enable resizing for the whole frame
                videoDisplayPanel.setVisible(true);
            } else {
                this.setResizable(true);
                videoDisplayPanel.setVisible(false);
            }


        }*/

        pack();
    }

    @Override
    public void processPlayableEvent(PlayableEvent e) {
        if (e.getType()==PlayableEvent.POSITION_UPDATE){
            String time = TimeStringFormatter.formatMiliseconds(player.getCurrentPosition()*1000.0,2);
            timeLabel.setText(time);
        } else if (e.getType()==PlayableEvent.PLAYBACK_STOPPED){
            playToggleButton.setEnabled(false);
        }
    }


}
