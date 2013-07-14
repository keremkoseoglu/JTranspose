/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtranspose;

import java.util.*;

/**
 *
 * @author kerem
 */
public class Score {

    private ArrayList elements;
    
    public Score() {
        initialize(null);
    }
    
    public Score(String S) {
        initialize(S);
    }
   
    
    public void parseText(String S) {
        String c1 = "";
        String c2 = "";
        
        if (S == null) return;
        
        boolean cont = true;
        int pos = 0;
        
        while (cont) {
            c1 = S.substring(pos, pos + 1);
            boolean n1 = Note.isStringANote(c1);
            try {
                c2 = S.substring(pos, pos + 2);
            }
            catch (Exception ex) {
                c2 = c1;
            }
            boolean n2 = Note.isStringANote(c2);
            
            if (c1.equals("\r")) {
                addString(c1, ScoreElement.ELEMENT_TYPE.LINE_BREAK);
                pos++;
            }
            else if (n1 && !n2) {
                addString(c1, ScoreElement.ELEMENT_TYPE.NOTE);
                pos++;
            }
            else if (n1 && n2) {
                addString(c2, ScoreElement.ELEMENT_TYPE.NOTE);
                pos = pos + 2;
            }
            else if (!n1 && !n2) {
                addString(c1, ScoreElement.ELEMENT_TYPE.TEXT);
                pos++;
            }
            else {
                pos++;
            }    

            cont = (pos <= S.length() - 1);
        }
        
        /*else if (Note.isStringANote(c2)) addString(c2, ScoreElement.ELEMENT_TYPE.NOTE);
        else addString(c2, ScoreElement.ELEMENT_TYPE.TEXT);*/
    }
    
    public void transpose(int Step) {
        for (int n = 0; n < elements.size(); n++) {
            ScoreElement se = getScoreElement(n);
            if (se.getElementType() == ScoreElement.ELEMENT_TYPE.NOTE) {
                Note note = se.getNote();
                note.transpose(Step);
                se.setNote(note);
                elements.set(n, se);
            }
        }
    }
    
    @Override
    public String toString() {
        String ret = "";
        
        if (elements == null) return ""; 
        for (int n = 0; n < elements.size(); n++) ret += getScoreElement(n).toString();
        
        return ret;
    }
    
    private ScoreElement getScoreElement(int Pos) {
        return (ScoreElement) elements.get(Pos);
    }
    
    private void addString(String S, ScoreElement.ELEMENT_TYPE E) {
        if (E == ScoreElement.ELEMENT_TYPE.LINE_BREAK) {
            ScoreElement se = new ScoreElement();
            se.setElementType(E);
            elements.add(se);
            return;
        }
        
        if (E == ScoreElement.ELEMENT_TYPE.NOTE) {
            Note note = new Note(S);
            ScoreElement se = new ScoreElement();
            se.setNote(note);
            elements.add(se);
            return;
        }
        
        if (E == ScoreElement.ELEMENT_TYPE.TEXT) {
            ScoreElement se = new ScoreElement();
            se.setText(S);
            elements.add(se);
            return;
        }
    }
    
    private void initialize(String S) {
        elements = new ArrayList();
        parseText(S);
    }
    
}
