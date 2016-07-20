
package texteditor;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavan Yekabote
 */
public class Check {
   
    TextEditor te;
    public Check(TextEditor te)
    {
        this.te=te;
    }
    
    protected static boolean isRunnable(File f)
    {
        if(f.getName().endsWith(".html"))
            return true;
        else
            return false;
    }
}
