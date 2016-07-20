/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author Pavan Yekabote
 */
public class Actions extends WindowAdapter implements ActionListener,ChangeListener{
   
    private TextEditor te;
    Actions(TextEditor te)
    {
        this.te=te;
        
    }
    
    //Notifies when any Component is Clicked
    @Override
    public void actionPerformed(ActionEvent e)  
    {
        if(e.getSource()==te.newMI)
        {
            try {
                te.tasks.addTab(te.editpane);
            } catch (IOException ex) {
                Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == te.exitMI)
        {
            System.exit(0);
        }
        
        /**
         * Action Triggered when Open option is choosen from File Menu
         */
        if(e.getSource()==te.openMI)
        {
            try {
                te.tasks.addFile(te.file, te.editpane);
            } catch (IOException ex) {
                Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Action Performed when the Close Button in Font Dialog box is pressed
         */
        if(e.getSource()==te.closecurrenttabMI)
        {
            te.tasks.removeTabFile(te.file, te.editpane);
        }
        /**
         * Action triggered when Font option is selected from Edit Menu
         */
        if(e.getSource()== te.fontMI)
        {
          te.tasks.fontdialogOpen();
        }
       
        /**
         * Action Performed when the Close Button in Font Dialog box is pressed
        */
        if( e.getSource() == te.tasks.je.closeBtn)
        {
            te.setEnabled(true);
            te.jdialog.dispose();
      
        }
        /**
         * Action Performed when the Save Button in Font Dialog box is pressed
        */
        if(e.getSource() == te.tasks.je.saveBtn)
        {
           Store.FontColourIndex= te.tasks.je.fontcolorCB.getSelectedIndex();
           Store.FontSizeIndex=te.tasks.je.fontsizeCB.getSelectedIndex();
           Store.FontStyleIndex=te.tasks.je.fontstyleCB.getSelectedIndex();
           Store.InitFont=new Font(te.tasks.je.fontstyleCB.getItemAt(Store.FontStyleIndex),
                                   Font.PLAIN,
                                   Integer.parseInt(te.tasks.je.fontsizeCB.getItemAt(Store.FontSizeIndex))
                                   );
            Store.FontColor=te.tasks.je.fontviewJL.getForeground();
           for(int i=0;i<te.editpane.size();i++){
               te.editpane.get(i).setFont(Store.InitFont);
               te.editpane.get(i).setForeground(Store.FontColor);
           }
           te.setEnabled(true);
           te.jdialog.dispose();
        }
         /**
          * Action Performed when the Color changes in Font Dialog box
         */
        if(e.getSource() == te.tasks.je.fontcolorCB)
        {
            te.tasks.je.fontviewJL.setForeground(te.tasks.colorSet(te.tasks.je.fontcolorCB));
          
        }
        /**
         * Action Performed when Font Size is changed in Font DialogBox
        */
        if(e.getSource() == te.tasks.je.fontsizeCB)
        {
              
            te.tasks.je.fontviewJL.setFont((new Font(
                                                       te.tasks.je.fontstyleCB.getItemAt(te.tasks.je.fontstyleCB.getSelectedIndex()), //FontStyle at given Index
                                                        Font.PLAIN,                                             //Font Type
                                                        Integer.parseInt(te.tasks.je.fontsizeCB.getItemAt(te.tasks.je.fontsizeCB.getSelectedIndex())) //FontSize
                                                      )
                                            ));
          
        }
        
        /**
         * Action Performed when Font Style is changed in Font DialogBox
        */ 
        if(e.getSource() == te.tasks.je.fontstyleCB)
        {
            
            /**
             * Set the FontView("Hello World") text in the selected style in FontDialogBox
             */
          te.tasks.je.fontviewJL.setFont((new Font(
                                                       te.tasks.je.fontstyleCB.getItemAt(te.tasks.je.fontstyleCB.getSelectedIndex()), //FontStyle at given Index
                                                        Font.PLAIN,                                             //Font Type
                                                        Integer.parseInt(te.tasks.je.fontsizeCB.getItemAt(te.tasks.je.fontsizeCB.getSelectedIndex())) //FontSize
                                                      )
                                            ));   //
        }
    
    /**
     * if Run Button action is Performed
     */
     if(e.getSource() == te.runMI)
     {
            try {
                Desktop d = Desktop.getDesktop();
                d.browse(te.file.get(Store.SelectedFileIndex).toURI());
            } catch (IOException ex) {
                Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
     if(e.getSource() == te.saveMI)
     {
         if(!te.tabpane.getTitleAt(Store.SelectedTabIndex).equals("NewTab"))
            try {
                te.tasks.saveFile(te.file.get(Store.SelectedFileIndex));
         } catch (Exception ex) {
             Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}

   
    //Notifies when a tab is changed in tabpane
    @Override
    public void stateChanged(ChangeEvent e) {
  
        if(e.getSource()==te.tabpane)
        {
            Store.SelectedTabIndex=te.tabpane.getSelectedIndex();       //Store opened TabIndex here
            Store.SelectedFileIndex=te.tasks.fileIndexSelect();         //Store opened fileIndex if there is a file opened in current tab
            te.tasks.setRunState();
            //System.out.println("TabSelected:"+te.tabpane.getSelectedIndex());
            te.tasks.checkFileIndex();
        }
    }
}