/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtranspose;

/**
 *
 * @author kerem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static FrmMain form;
    public static final String VERSION = "1.0.0";
    
    public static void main(String[] args) {
        form = new FrmMain();
        form.setTitle("JTranspose " + VERSION + " - by Kerem Koseoglu");
        form.setVisible(true);
    }

}
