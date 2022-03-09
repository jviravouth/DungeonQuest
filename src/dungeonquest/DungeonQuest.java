package dungeonquest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class DungeonQuest {
    
    JFrame ui;
    Container container;
    JPanel startScreen, startScreenBG, startButtonPanel, gameText, choicesPanel, playerPanel;
    JLabel startScreenTitle, startScreenBGLabel, playerInvLabel, playerInv;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea gameTextArea;
    
    startButtonHandler startHandler = new startButtonHandler();
    choiceButtonHandler choiceHandler = new choiceButtonHandler();
    
    public static void main(String[] args) {
        new DungeonQuest();
    }
    
    public DungeonQuest() {
        ui = new JFrame();
        /*
        ui.setSize(1280, 720);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.getContentPane().setBackground(Color.BLACK);
        ui.setLayout(null);
        ui.setVisible(true);
        container = ui.getContentPane();
        */ 
        
        /*
        startScreenBG = new JPanel();
        startScreenBG.setBounds(0,0,1280,720);
        startScreenBG.setLayout(null);
        startScreenBGLabel = new JLabel();
        startScreenBGLabel.setBounds(0,0,1280,720);
        ImageIcon startScreenIMG = new ImageIcon(getClass().getClassLoader().getResource("Picture1.png"));
        startScreenBGLabel.setIcon(startScreenIMG);
        */

        startScreen = new JPanel();
        startScreen.setBounds(350,175,600,200);
        startScreen.setBackground(Color.BLACK);
        startScreenTitle = new JLabel("Dungeon Quest");
        startScreenTitle.setForeground(Color.WHITE);
        startScreenTitle.setFont(startScreenTitle.getFont().deriveFont(40.0f));
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500,475,300,50);
        startButtonPanel.setOpaque(false);
        
        startButton = new JButton("Begin your Journey!");
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(startButton.getFont().deriveFont(25.0f));
        startButton.setFocusPainted(false);
        startButton.addActionListener(startHandler);
        
        startScreen.add(startScreenTitle);
        startButtonPanel.add(startButton);
        //startScreenBG.add(startScreenBGLabel);

        container = ui.getContentPane();
        
        container.add(startScreen);
        container.add(startButtonPanel);
        //container.add(startScreenBG);
        
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setSize(1280,720);
        ui.getContentPane().setBackground(Color.BLACK);
        ui.setLayout(null);
        ui.setResizable(true);
        ui.setVisible(true);
    }
    
    public void gameUI() {
        
        //startScreen.setVisible(false);
        //startButtonPanel.setVisible(false);
        
        gameText = new JPanel();
        gameText.setBounds(350, 175, 600, 250);
        gameText.setBackground(Color.BLACK);
        gameText.setForeground(Color.BLACK);
      
        container.add(gameText);
        
        gameTextArea = new JTextArea("You've entered the Dungeon! There are four rooms\n"
                + "ahead of you.");
        gameTextArea.setBounds(350,175,600,250);
        gameTextArea.setBackground(Color.BLACK);
        gameTextArea.setForeground(Color.WHITE);
        gameTextArea.setFont(gameTextArea.getFont().deriveFont(25.0f));
        gameTextArea.setLineWrap(true);
        gameText.add(gameTextArea);
        
        choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(4,1));
        choicesPanel.setBounds(520,425,250,175);
        choicesPanel.setOpaque(false);
        container.add(choicesPanel);
        
        choice1 = new JButton("Enter Door 1");
        choice1.setOpaque(false);
        choice1.setContentAreaFilled(false);
        choice1.setForeground(Color.WHITE);
        choice1.setFocusPainted(false);
        choice1.setFont(choice1.getFont().deriveFont(25.0f));
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("choice1");
        
        choice2 = new JButton("Enter Door 2");
        choice2.setOpaque(false);
        choice2.setContentAreaFilled(false);
        choice2.setForeground(Color.WHITE);
        choice2.setFocusPainted(false);
        choice2.setFont(choice1.getFont().deriveFont(25.0f));
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("choice1");
        
        choice3 = new JButton("Enter Door 3");
        choice3.setOpaque(false);
        choice3.setContentAreaFilled(false);
        choice3.setForeground(Color.WHITE);
        choice3.setFocusPainted(false);
        choice3.setFont(choice1.getFont().deriveFont(25.0f));
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("choice1");
        
        choice4 = new JButton("Enter Door 4");
        choice4.setOpaque(false);
        choice4.setContentAreaFilled(false);
        choice4.setForeground(Color.WHITE);
        choice4.setFocusPainted(false);
        choice4.setFont(choice1.getFont().deriveFont(25.0f));
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("choice1");
        
        playerPanel = new JPanel();
        playerPanel.setBounds(100,30,1050,50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1,4));
        container.add(playerPanel);
        
        playerInvLabel = new JLabel("Inventory:");
        playerInvLabel.setFont(playerInvLabel.getFont().deriveFont(25.0f));
        playerInvLabel.setForeground(Color.WHITE);
        playerPanel.add(playerInvLabel);
        playerInv = new JLabel();
        playerInv.setFont(playerInv.getFont().deriveFont(25.0f));
        playerInv.setForeground(Color.WHITE);
        playerPanel.add(playerInv);
        
        choicesPanel.add(choice1);
        choicesPanel.add(choice2);
        choicesPanel.add(choice3);
        choicesPanel.add(choice4);
        
        ui.repaint();
        startScreen.setVisible(false);
        startButtonPanel.setVisible(false);
    }
    
    public void door1() {
        gameTextArea.setText("You've entered the first door!\nIn front of you lies a golden"
                + " key!");
        choice1.setText("Grab the Key");
        choice2.setText("Examine the key");
        choice3.setText("Wait");
        choice4.setText("Exit the room");
    }
    public class startButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event) {
            gameUI();
        }
    }
    
    public class choiceButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event) {
            String choiceMade = event.getActionCommand();
            
            switch(choiceMade){
                case "choice1":
                    door1();
                    break;
                case "choice2":
                    door2();
                    break;
                case "choice3":
                    door3();
                    break;
                case "choice4":
                    door4();
                    break;
            }
        }
    }
}