/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTextPane;

/**
 * Main class that initiates all Components and UI
 * @author Pavan Yekabote
 * @version 1.0
 */
public class TextEditor extends javax.swing.JFrame {

    /**
     * Creates new form TextEditor
     */
    Actions actions;
    protected Tasks tasks;
    protected ArrayList<File> file;
    protected ArrayList<JTextPane> editpane;
    protected ArrayList<TitleDisplay> tdarraylist;
    protected JDialog jdialog;
    public TextEditor() {
        super("Text Editor");
        initComponents();
        file = new ArrayList<>();
        editpane=new ArrayList<>();
        tdarraylist  = new ArrayList<>();
        actions = new Actions(this);
        jdialog = new JDialog();
        initListeners();
        tasks=new Tasks(this);
        this.runMI.setEnabled(false);
    }
    
    private void initListeners()
    {
       //Initialising all the MenuItems ActionListeners
       newMI.addActionListener(actions);
       openMI.addActionListener(actions);
       closecurrenttabMI.addActionListener(actions);
       saveMI.addActionListener(actions);
       saveasMI.addActionListener(actions);
       exitMI.addActionListener(actions);
       fontMI.addActionListener(actions);
       runMI.addActionListener(actions);
       //Add ChangeListener to tabpane
       tabpane.addChangeListener(actions);
       
    }

   //Initialize all the User Interface Components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpane = new javax.swing.JTabbedPane();
        menubar = new javax.swing.JMenuBar();
        fileMBI = new javax.swing.JMenu();
        newMI = new javax.swing.JMenuItem();
        openMI = new javax.swing.JMenuItem();
        saveMI = new javax.swing.JMenuItem();
        closecurrenttabMI = new javax.swing.JMenuItem();
        saveasMI = new javax.swing.JMenuItem();
        exitMI = new javax.swing.JMenuItem();
        editMBI = new javax.swing.JMenu();
        fontMI = new javax.swing.JMenuItem();
        runMBI = new javax.swing.JMenu();
        runMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMBI.setText("File");
        fileMBI.setMnemonic('F');

        newMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMI.setMnemonic('N');
        newMI.setText("New");
        fileMBI.add(newMI);

        openMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMI.setMnemonic('O');
        openMI.setText("Open");
        fileMBI.add(openMI);

        saveMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMI.setMnemonic('S');
        saveMI.setText("Save");
        fileMBI.add(saveMI);

        closecurrenttabMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        closecurrenttabMI.setMnemonic('C');
        closecurrenttabMI.setText("Close Current Tab");
        fileMBI.add(closecurrenttabMI);

        saveasMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveasMI.setText("Save As");
        fileMBI.add(saveasMI);

        exitMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMI.setMnemonic('X');
        exitMI.setText("Exit");
        fileMBI.add(exitMI);

        menubar.add(fileMBI);

        editMBI.setText("Edit");
        editMBI.setMnemonic('E');

        fontMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        fontMI.setMnemonic('F');
        fontMI.setText("Font");
        editMBI.add(fontMI);

        menubar.add(editMBI);

        runMBI.setText("Run");

        runMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        runMI.setText("Run");
        runMBI.add(runMI);

        menubar.add(runMBI);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenuItem closecurrenttabMI;
    private javax.swing.JMenu editMBI;
    protected javax.swing.JMenuItem exitMI;
    protected javax.swing.JMenu fileMBI;
    protected javax.swing.JMenuItem fontMI;
    private javax.swing.JMenuBar menubar;
    protected javax.swing.JMenuItem newMI;
    protected javax.swing.JMenuItem openMI;
    private javax.swing.JMenu runMBI;
    protected javax.swing.JMenuItem runMI;
    protected javax.swing.JMenuItem saveMI;
    protected javax.swing.JMenuItem saveasMI;
    protected javax.swing.JTabbedPane tabpane;
    // End of variables declaration//GEN-END:variables
}

