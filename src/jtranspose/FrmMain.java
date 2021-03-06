/*
 * FrmMain.java
 *
 * Created on December 19, 2009, 10:19 PM
 */

package jtranspose;

/**
 *
 * @author  kerem
 */
public class FrmMain extends javax.swing.JFrame {
    
    /** Creates new form FrmMain */
    public FrmMain() {
        initComponents();
        cmbStep.setSelectedIndex(13);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMain = new javax.swing.JTextArea();
        cmbStep = new javax.swing.JComboBox();
        btnTranspose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMain.setColumns(20);
        txtMain.setRows(5);
        txtMain.setText("A | D | A | D | x 2\nD | D | D | D | x 2\nC | B | E | E | \nA | E | D | (es)\nA | D | A | D | x 2\nD | G | D | G | x 2\nC | B | E | E | \nC# | F# | B | E |  x 3\nA | D | B | E | C | F |\nB | E | C | F | A | D | G |\n");
        jScrollPane1.setViewportView(txtMain);

        cmbStep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-11", "-10", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9", "+10", "+11" }));

        btnTranspose.setText("Transpose");
        btnTranspose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransposeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(btnTranspose, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTranspose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnTransposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransposeActionPerformed
    Score s = new Score(txtMain.getText());
    s.transpose(cmbStep.getSelectedIndex() -11);
    txtMain.setText(s.toString());
}//GEN-LAST:event_btnTransposeActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTranspose;
    private javax.swing.JComboBox cmbStep;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMain;
    // End of variables declaration//GEN-END:variables

}
