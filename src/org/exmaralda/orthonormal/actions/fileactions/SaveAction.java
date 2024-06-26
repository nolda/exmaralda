/*
 * OpenAction.java
 *
 * Created on 14. Mai 2008, 14:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.exmaralda.orthonormal.actions.fileactions;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;
import org.exmaralda.orthonormal.actions.AbstractApplicationAction;
import org.exmaralda.orthonormal.application.ApplicationControl;


/**
 *
 * @author thomas
 */
public class SaveAction extends AbstractApplicationAction {
    
    /** Creates a new instance of OpenAction
     * @param ac
     * @param name
     * @param icon */
    public SaveAction(ApplicationControl ac, String name, Icon icon) {
        super(ac, name, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("[*** SaveAction ***]");
        ApplicationControl ac = (ApplicationControl)applicationControl;
        if (ac.currentFilePath == null){
            new SaveAsAction(ac, null, null).actionPerformed(e);
            return;
        }
        ac.saveTranscriptionFileAs(new File(ac.currentFilePath), false);
    }
    
}
