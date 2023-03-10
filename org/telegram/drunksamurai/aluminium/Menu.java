
package org.telegram.drunksamurai.aluminium;

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
    static JMenuItem mSaveFile, mOpenFile, mExit;
    
    static JMenu menuView;
    static JMenuItem mChangeFont;
    static JMenuItem mSwitchDarkTheme;
    
    static JMenu menuHelp;
    static JMenuItem mAbout;
    
    static void addBar() {
        // add menu bar itself
        bar = new JMenuBar();
        
        // add file menu
        menuFile = new JMenu("File");        
        
        mSaveFile = new JMenuItem("Save to file...");
        mOpenFile = new JMenuItem("Open file...");
        mExit = new JMenuItem("Exit");
        
        mSaveFile.addActionListener(new SaveFileAction());
        mOpenFile.addActionListener(new OpenFileAction());
        mExit.addActionListener(new ExitAction());
        
        menuFile.add(mSaveFile);
        menuFile.add(mOpenFile);
        menuFile.add(mExit);
        
        bar.add(menuFile);
        
        // add view menu        
        menuView = new JMenu("View");
        
        mChangeFont = new JMenuItem("Change font...");
        mSwitchDarkTheme = new JMenuItem("Switch to dark/light theme");
        
        mChangeFont.addActionListener(new ChangeFontAction());
        mSwitchDarkTheme.addActionListener(new SwitchThemeAction());
        
        menuView.add(mChangeFont);
        menuView.add(mSwitchDarkTheme);
        
        bar.add(menuView);
        
        // add Help menu
        menuHelp = new JMenu("Help");
        
        mAbout = new JMenuItem("About...");
        
        mAbout.addActionListener(new AboutAction());
        
        menuHelp.add(mAbout);
        
        bar.add(menuHelp);
        
        
        Actions.frame.setJMenuBar(bar);
        
    }
    
}
