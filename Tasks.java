/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.text.StyledDocument;

/**
 * Class to perform different operations that take place in the model
 * @author Pavan Yekabote
 * @version 1.0
 */
public class Tasks {
    
    private int ntabs=0,nfiles=0;
    private TextEditor te;
    private StyledDocument style;
    ArrayList<Integer> fileTabIndex;
    private JFileChooser choosefile;
    private File openfile;
    protected FontDialog je;
  
    Tasks(TextEditor te)
    {
        this.te=te;
        je = new FontDialog(te);
        fileTabIndex=new ArrayList<>();
    }
    
    protected void setRunState()
    {
        if(this.fileIndexSelect()!=-1)
        {
            if(Check.isRunnable(te.file.get(fileIndexSelect())))
                te.runMI.setEnabled(true);
            else
                te.runMI.setEnabled(false);
        }
    }
     protected void addTab(ArrayList<JTextPane> je) throws IOException
    {
        
        JTextPane jpane = new JTextPane();
         TitleDisplay tdisplay = new TitleDisplay(te);
        te.tdarraylist.add(tdisplay);
        jpane.setFont(Store.InitFont);
        jpane.setForeground(Store.FontColor);
        je.add(ntabs, jpane);
        te.tabpane.add(new JScrollPane(je.get(ntabs)));
        te.tabpane.setTabComponentAt(ntabs, tdisplay);
        te.tabpane.setSelectedIndex(ntabs);
        te.tabpane.setTitleAt(ntabs++, "New Tab");
        tdisplay.setTitle("New Tab");
    }
    
     
    protected void saveFile(File f) throws FileNotFoundException, IOException
    {
        JFileChooser jf= new JFileChooser();
        jf.showSaveDialog(null);
        File j = jf.getSelectedFile();
        FileOutputStream fo = new FileOutputStream(j);
        String file = te.editpane.get(Store.SelectedTabIndex).getText();
        for(int i=0;i<file.length();i++)
        {
            fo.write((int)file.charAt(i));
        }
        fo.close();
      
    }
     protected void addFile(ArrayList<File> f,ArrayList<JTextPane> je) throws IOException
    {
        openfile=chooseFile();
        if(openfile!=null)
            if(isAlreadyOpened(openfile,f))
            {
                FileInputStream fin = new FileInputStream(openfile);
                int c;
                String s="";
                while((c=fin.read())!=-1)
                    s=s+(char)c;
              
                if(te.tabpane.getTitleAt(Store.SelectedTabIndex).contains("New Tab"))
                    f.add(nfiles++,openfile);    
                else
                    f.set(Store.SelectedFileIndex,openfile);
                je.get(Store.SelectedTabIndex).setText(s);
                ((TitleDisplay)te.tabpane.getTabComponentAt(Store.SelectedTabIndex)).setTitle(openfile.getName());
                te.tabpane.setTitleAt(Store.SelectedTabIndex,openfile.getName());
                te.tabpane.setToolTipTextAt(Store.SelectedTabIndex, openfile.getCanonicalPath()); //Make a Popup visible when mouseponter is placed over a tab
                fileTabIndex.add(Store.SelectedTabIndex);
                Store.SelectedFileIndex=this.fileIndexSelect();
                setRunState();
            }
           else
           {
               te.tabpane.setSelectedIndex(Store.SelectedTabIndex);
           }  
    }
     
     protected void removeTabFile(ArrayList<File> f,ArrayList<JTextPane> ja)
        {
            int i,j;
            for( i=0;i<f.size();i++)
            {
             if(fileTabIndex.get(i)==Store.SelectedTabIndex)
                 break;
            }
           if(f.size()>0 && (!te.tabpane.getTitleAt(Store.SelectedTabIndex).contains("New Tab")))
            {    
                System.out.println("I: "+i+" FSize:"+f.size());
                f.remove(i);
                j=fileTabIndex.get(i);
                fileTabIndex.remove(i);
                System.out.println();
                for(i=0;i<fileTabIndex.size();i++){
                    fileTabIndex.set(i, fileTabIndex.get(i)>j?(fileTabIndex.get(i)-1):fileTabIndex.get(i));
                    System.out.println("Running:"+i);
                }
                nfiles--;
               
            }
       
            te.tabpane.remove(Store.SelectedTabIndex);
            ntabs--;
        }
     
     private File chooseFile()
     {
        choosefile=new JFileChooser();
        choosefile.showOpenDialog(null);
        return choosefile.getSelectedFile()==null?null:choosefile.getSelectedFile();  
     }
     
     private boolean isAlreadyOpened(File f,ArrayList<File> af)
    {
        for(int i=0;i<af.size();i++)
        {
            if(af.get(i).getAbsolutePath().equals(f.getAbsolutePath())){
                Store.SelectedTabIndex=fileTabIndex.get(i);
                return false;
            }
        }

        return true;
    }
     protected int fileIndexSelect()
    {
      
        for(int i=0;i<fileTabIndex.size();i++)
        {
            if(fileTabIndex.get(i)==Store.SelectedTabIndex)
                return i;
        }
        return -1;
    }
     
     protected void checkFileIndex()
     {
           for(int i=0;i<fileTabIndex.size();i++)
        {
            System.out.println("File:"+te.file.get(i).getAbsolutePath()+" Tabindex:"+fileTabIndex.get(i)+" FileIndex:"+i);
        }
     }
     
     
     protected Color colorSet(JComboBox jbx)
     {
         if(jbx.getItemAt(jbx.getSelectedIndex()).equals("Blue"))
             return Color.BLUE;
         else
             return Color.BLACK;
     }
     
    protected void fontdialogOpen()
    {
            
            te.jdialog.addWindowListener(te.actions);
            te.jdialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            te.jdialog.addWindowListener(te.actions);
            te.jdialog.setBounds(500, 300, 420,350);
            te.jdialog.setTitle("Font Dialog");
            te.jdialog.add(je);
            te.jdialog.setVisible(true);
            te.setEnabled(false);
        
    }
}
