/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 *
 * @author Pavan Yekabote
 */
public class FontDialog extends javax.swing.JPanel {

     GraphicsEnvironment ge;
     Font[] fonts;
    /**
     * Creates new form FontDialog
     */
    private TextEditor te;
    public FontDialog(TextEditor te) {
           initComponents();
        this.te=te;
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fonts=ge.getAllFonts();         //Get All fonts in System
     
                init();
                initListeners();
        fontviewJL.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void init()
    {
        //Add Different fonts present in System.
       for(int i=0;i<fonts.length;i++)
         fontstyleCB.addItem(fonts[i].getName());
       
        //Add Different Sizes 
       for(int i=8;i<72;)
        {
            fontsizeCB.addItem((i)+"");
            if(i<=20)
                i++;
            else if(i>20 && i<=40)
                i+=2;
            if(i>40)
                i+=7;
        }
        
       //Add colors
       fontcolorCB.addItem("Black");
       fontcolorCB.addItem("Blue");
       
       fontcolorCB.setSelectedIndex(Store.FontColourIndex);
       fontstyleCB.setSelectedIndex(Store.FontStyleIndex);
       fontsizeCB.setSelectedIndex(Store.FontSizeIndex);
    }
    private void initListeners()
    {
        fontstyleCB.addActionListener(te.actions);
        fontsizeCB.addActionListener(te.actions);
        fontcolorCB.addActionListener(te.actions);
        closeBtn.addActionListener(te.actions);
        saveBtn.addActionListener(te.actions);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fontstyleCB = new javax.swing.JComboBox<>();
        fontsizeJL = new javax.swing.JLabel();
        fontcolorCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        fontsizeCB = new javax.swing.JComboBox<>();
        fontcolorJL1 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        fontviewJL = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add(fontstyleCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 324, 28));

        fontsizeJL.setBackground(new java.awt.Color(255, 255, 255));
        fontsizeJL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        fontsizeJL.setText("Font Size");
        add(fontsizeJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 28));

        add(fontcolorCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Font Style");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 124, 28));

        add(fontsizeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 132, -1));

        fontcolorJL1.setBackground(new java.awt.Color(255, 255, 255));
        fontcolorJL1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        fontcolorJL1.setText("Font Color");
        add(fontcolorJL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 28));

        saveBtn.setText("Save");
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 249, -1, -1));

        closeBtn.setText("Close");
        add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 249, -1, -1));

        fontviewJL.setEditable(false);
        fontviewJL.setText("Hello World.");
        add(fontviewJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 328, 50));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton closeBtn;
    protected javax.swing.JComboBox<String> fontcolorCB;
    private javax.swing.JLabel fontcolorJL1;
    protected javax.swing.JComboBox<String> fontsizeCB;
    private javax.swing.JLabel fontsizeJL;
    protected javax.swing.JComboBox<String> fontstyleCB;
    protected javax.swing.JTextField fontviewJL;
    private javax.swing.JLabel jLabel2;
    protected javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
