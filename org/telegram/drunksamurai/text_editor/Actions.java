
package org.telegram.drunksamurai.text_editor;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Jadavin
 */
public class Actions {
    static JFrame frame;
    static JTextArea textArea;
    static JLabel pathLabel;
    static JLabel statusLabel;
    
    static Font font;
}

// File menu actions

class OpenFileAction implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("read from file...");
        
        FileDialog fd = new FileDialog(Actions.frame, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        String path = fd.getDirectory() + fd.getFile();
        File f = new File(path);
        
        try {
            FileReader fr = new FileReader(f);
            StringBuilder sb = new StringBuilder();
            
            int i = 0;
            
            while ( (i = fr.read()) != -1) {
                sb.append( (char) i);
            }
                     
            Actions.textArea.setText(sb.toString());
            Actions.pathLabel.setText(path);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
    }
}

class SaveFileAction implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("save to file...");
        
        FileDialog fd = new FileDialog(Actions.frame, "Save", FileDialog.SAVE);
        fd.setLocationRelativeTo(null);
        fd.setVisible(true);
        String path = fd.getDirectory() + fd.getFile();
        
        if (!path.endsWith(".txt")) {
            path += ".txt";
        }
        
        File f = new File(path);
        
        try {
            FileWriter fw = new FileWriter(f);
            Actions.textArea.write(fw);
            Actions.pathLabel.setText(path);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

// View menu actions

class ChangeFontAction implements ActionListener {

    public ChangeFontAction(Font font) {
        Actions.font = font;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Actions.textArea.setFont(Actions.font);
    }
}
