/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.exmaralda.orthonormal.gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;

/**
 *
 * @author thomas
 */
public class WordListTableModel extends javax.swing.table.AbstractTableModel {

    List<Element> words;
    boolean hasLemmaOrPOS = false;

    public WordListTableModel(List<Element> words) {
        this.words = words;
        try {
            hasLemmaOrPOS = (XPath.selectSingleNode(words, "//w[@lemma or @pos]")!=null);
        } catch (JDOMException ex) {
            Logger.getLogger(WordListTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return words.size();
    }

    @Override
    public int getColumnCount() {
        //if (words.size()>0 && words.get(0).getAttribute("pos")!=null){
        if (hasLemmaOrPOS) {
            return 5;
        } else {
            return 2;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Element word = words.get(rowIndex);
        return word;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Wort";
            case 1:
                return "Normal";
            case 2:
                return "Lemma";
            case 3:
                return "POS";
            case 4:
                return "p(POS)";
            default:
                break;
        }
        return "";
    }

    public void updateWord(Element word){
        int row = words.indexOf(word);
        fireTableRowsUpdated(row, row);
    }

}
