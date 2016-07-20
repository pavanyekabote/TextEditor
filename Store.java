/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Pavan Yekabote
 */
public class Store {
 
    
    //We define static variables here for indexes and state retention
    //variables to note down changedState in Actions
    
    /**
     * Contain the index of current Selected Tab in TabbedPane
    */
    protected static int SelectedTabIndex;
    /**
     * Contain the index of File incurrent Selected Tab in TabbedPane
    */
    protected static int SelectedFileIndex;
    
    
    /*Contains Selected TabTilePane(With a Button 'X' and TextView) */
    
    protected static int SelectedTabTitleIndex;
    
    //Store Run state
    
    protected static boolean isRunEnabled=false;
    //Font Style, Size , Colour
    protected static int FontStyleIndex=45;
    protected static int FontSizeIndex=2;
    protected static int FontColourIndex=0;
    protected static Font InitFont=new Font("Arial",Font.PLAIN,10);
    protected static Color FontColor=Color.BLACK;
}
