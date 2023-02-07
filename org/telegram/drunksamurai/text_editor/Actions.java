
package org.telegram.drunksamurai.text_editor;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

class ExitAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

// View menu actions

class ChangeFontAction implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFontChooser fontChooser = new JFontChooser();
        int result = fontChooser.showDialog(Actions.frame);
        
        if (result == JFontChooser.OK_OPTION) {
            Font font = fontChooser.getSelectedFont();
            Actions.textArea.setFont(font);
        } else {
            System.out.println("New font was not selected.");
        }
    }
}

// Help menu actions

class AboutAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                
        String text = "<html> <br/>  This is a simple text editor <br/> written entirely in Java. <br/><br/>" +
                "License: MIT<br/>";                
 
        JLabel label = new JLabel(text);
        label.setFont(new Font("Consolas", 0, 16));
        
        JLabel label2 = new JLabel("Github: click me!");
        label2.setFont(new Font("Consolas", 0, 16));
        
        label2.addMouseListener(new VisitGitHubAction());
        
        panel.add(label);
        panel.add(label2);
        
        JDialog jd = new JDialog(Actions.frame, true);
        jd.setIconImage(Actions.frame.getIconImage());
        jd.setTitle("About");
        jd.setSize(300, 170);
        jd.setLocationRelativeTo(null);
        jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jd.setResizable(false);
        jd.add(panel);
        jd.setVisible(true);
        
        //about.setVisible(true);
    }
    
    
    
    
}

class VisitGitHubAction implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
         
            Desktop.getDesktop().browse(new URI("https://github.com"));
         
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    } 
}
