package dungeonquest;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {
    
    DungeonQuest game;
    
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];
    
    public UI(DungeonQuest game){
        this.game = game;
        
        MainWindow();
        createRoom();
        
        window.setVisible(true);
    }
    
    public void MainWindow() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setLayout(null);
        
        messageText = new JTextArea("SAMPLE TEXT");
        messageText.setBounds(100,400,600,150);
        messageText.setBackground(Color.DARK_GRAY);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Arial", Font.PLAIN, 26));
        window.add(messageText);
    }
    
    public void background(int bgNum, String fileName) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0,0,800,600);
        bgPanel[bgNum].setBackground(Color.CYAN);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);
        
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,800,600);
        
        ImageIcon bgStartScreen = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        bgLabel[bgNum].setIcon(bgStartScreen);
        
    }
    
    public void createRoom() {
        // Start Screen
        background(0, "Picture1.png");
        bgPanel[0].add(bgLabel[0]);
        
        // Entrance
        background(1, "picture2.jpg");
        bgPanel[1].add(bgLabel[1]);
    }
    
}
