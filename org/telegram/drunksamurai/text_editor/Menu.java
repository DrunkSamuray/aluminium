
package org.telegram.drunksamurai.text_editor;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jadavin
 */
public class Menu {
    
    static JMenuBar bar;
    
    static JMenu menuFile;    
    static JMenuItem mSaveFile, mOpenFile, item3;
    
    static JMenu menuView;
    static JMenuItem mChangeFont;
    
    static void addBar() {
        // add menu bar itself
        bar = new JMenuBar();
        
        // add file menu
        menuFile = new JMenu("File");        
        
        mSaveFile = new JMenuItem("Save to file...");
        mOpenFile = new JMenuItem("Open file...");
        item3 = new JMenuItem("Action 3");
        
        mSaveFile.addActionListener(new SaveFileAction());
        mOpenFile.addActionListener(new OpenFileAction());
        
        menuFile.add(mSaveFile);
        menuFile.add(mOpenFile);
        menuFile.add(item3);
        
        bar.add(menuFile);
        
        // add view menu        
        menuView = new JMenu("View");
        
        mChangeFont = new JMenuItem("Change font...");
        
        Font font = new Font("Consolas", 0, 16);
        
        mChangeFont.addActionListener(new ChangeFontAction(font));
        
        menuView.add(mChangeFont);
        
        bar.add(menuView);
        
        Actions.frame.setJMenuBar(bar);
        
    }
    
}