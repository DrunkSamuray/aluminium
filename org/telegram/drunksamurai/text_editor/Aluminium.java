
package org.telegram.drunksamurai.text_editor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jadavin
 * 
 */
public class Aluminium extends JFrame {
    
    JTextArea textArea;
    JLabel pathLabel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Aluminium app = new Aluminium();
                Actions.frame = app;                
                
                app.buildTextArea();
                Menu.addBar();
                
                app.setVisible(true);
            }
        });        
    }
    
    Aluminium() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800); 
        setTitle("Aluminium Text Editor");
        setLocationRelativeTo(null);
        
        URL imgUrl = getClass().getResource("/res/img/text_editor_icon.png");
        System.out.println(imgUrl.toString());
        ImageIcon icon = new ImageIcon(imgUrl);
        setIconImage(icon.getImage());
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    void buildTextArea() {
        JPanel panel = new JPanel();
        textArea = new JTextArea();
        Actions.textArea = textArea;
        Actions.textArea.setFont(new Font("Consolas", 0, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        panel.setLayout(new BorderLayout());

        panel.add(scrollPane);
        
        pathLabel = new JLabel("Path to file...");
        Actions.pathLabel = pathLabel;
        
        Actions.statusLabel = new JLabel("Status: running...");
        panel.add(Actions.statusLabel, BorderLayout.SOUTH);
        
        panel.add(pathLabel, BorderLayout.NORTH);
        getContentPane().add(panel);
    }
}
