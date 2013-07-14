/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtranspose;

/**
 *
 * @author kerem
 */
public class ScoreElement {

    public enum ELEMENT_TYPE {NOTE, TEXT, LINE_BREAK};
    
    private Note note;
    private String text;
    private ELEMENT_TYPE elementType;
    
    public ScoreElement() {
        
    }
    
    public ELEMENT_TYPE getElementType() {
        return elementType;
    }
    
    public void setElementType(ELEMENT_TYPE E) {
        elementType = E;
        
        if (elementType.equals(ELEMENT_TYPE.LINE_BREAK)) {
            note = null;
            text = null;
        }
        
        if (elementType.equals(ELEMENT_TYPE.NOTE)) {
            text = null;
        }
        
        if (elementType.equals(ELEMENT_TYPE.TEXT)) {
            note = null;
        }
    }
    
    public Note getNote() {
        return note;
    }
    
    public void setNote(Note N) {
        setElementType(ELEMENT_TYPE.NOTE);
        note = N;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String S) {
        setElementType(ELEMENT_TYPE.TEXT);
        text = S;
    }
    
    @Override
    public String toString() {
        if (elementType.equals(ELEMENT_TYPE.LINE_BREAK)) return "\r";
        else if (elementType.equals(ELEMENT_TYPE.NOTE)) return getNote().toString();
        else return getText();
    }
    
}
