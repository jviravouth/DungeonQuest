package dungeonquest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class DungeonQuest {
    
    JFrame ui;
    Container container;
    JPanel startScreen, startScreenBG, startButtonPanel, gameText, choicesPanel, playerPanel;
    JLabel startScreenTitle, startScreenBGLabel, playerInvLabel, playerInv, playerTurnLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea gameTextArea;
    String position;
    boolean flagGoldenKey = false;
    boolean libraryComplete = false;
    boolean libraryStoveOn = true;
    boolean libraryCombinationKnown = false;
    boolean flagMoss = false;
    boolean flagMeat = false;
    boolean potEmpty = true;
    boolean potMoss = false;
    boolean potMeat = false;
    boolean potMossMeat = false;
    boolean weakPoison = false;
    boolean strongPoison = false;
    boolean feedRoomComplete = false;
    boolean sphinxRoomComplete = false;
    boolean drownRoomComplete = false;
    boolean haveShovel = false;
    boolean digNorth = false;
    boolean digEast = false;
    boolean digSouth = false;
    boolean digWest = false;
    boolean digNorth2 = false;
    boolean digRoomComplete = false;
    boolean haveTwig = false;
    boolean haveString = false;
    boolean haveKite = false;
    boolean flyLeft = false;
    boolean flyRight = false;
    boolean flyUp = false;
    boolean windRoomComplete = false;
    boolean haveFryPan = false;
    boolean haveWax = false;
    boolean haveCloth = false;
    boolean panStove = false;
    boolean waxStove = false;
    boolean clothStove = false;
    boolean heatRoomComplete = false;
    int playerTurn = 0;
    int turnTracker = 0;
    /*
    boolean playerWon = false;
    
    JButton a1, a2, a3, b1, b2, b3, c1, c2, c3;
    //ImageIcon a1x = new ImageIcon(getClass().getClassLoader().getResource("X.png"));
    //ImageIcon a1o = new ImageIcon(getClass().getClassLoader().getResource("O.png"));
    //ImageIcon a1x, a2x, a3x, b1x, b2x, b3x, c1x, c2x, c3x = new ImageIcon(getClass().getResource("X.png"));
    //ImageIcon a1o, a2o, a3o, b1o, b2o, b3o, c1o, c2o, c3o = new ImageIcon(getClass().getResource("O.png"));
    int[][] tic = new int[3][3];
    int actionPerformed = 0;
    int gameStatus = 0;
    int row, column = 0;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    //Container tttContainer;
    
    tttHandler tttgame = new tttHandler();
    */
    startButtonHandler startHandler = new startButtonHandler();
    choiceButtonHandler choiceHandler = new choiceButtonHandler();
    
    public static void main(String[] args) {
        DungeonQuest game = new DungeonQuest();
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
        startScreenBG.setOpaque(true);
        startScreenBGLabel = new JLabel();
        startScreenBGLabel.setBounds(0,0,1280,720);
        startScreenBGLabel.setOpaque(true);
        startScreenBGLabel.setBackground(Color.BLACK);
        ImageIcon startScreenIMG = new ImageIcon(getClass().getClassLoader().getResource("background4b.png"));
        startScreenBGLabel.setIcon(startScreenIMG);
        */
        
        ui.setContentPane(new JLabel(new ImageIcon("resources/background4b.png")));
        ui.setBackground(Color.BLACK);
        
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
        
        /*gameTextArea = new JTextArea("""
                                     You've entered the Dungeon! There are four rooms
                                     ahead of you.""");*/
        gameTextArea = new JTextArea();
        gameTextArea.setBounds(350,175,600,250);
        gameTextArea.setBackground(Color.BLACK);
        gameTextArea.setForeground(Color.WHITE);
        gameTextArea.setFont(gameTextArea.getFont().deriveFont(25.0f));
        gameTextArea.setLineWrap(true);
        gameText.add(gameTextArea);
        //position = "entrance";
        
        choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(4,1));
        choicesPanel.setBounds(520,425,250,175);
        choicesPanel.setOpaque(false);
        container.add(choicesPanel);
        
        //choice1 = new JButton("Enter Door 1");
        choice1 = new JButton();
        choice1.setOpaque(false);
        choice1.setContentAreaFilled(false);
        choice1.setForeground(Color.WHITE);
        choice1.setFocusPainted(false);
        choice1.setFont(choice1.getFont().deriveFont(25.0f));
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("choice1");
        
        //choice2 = new JButton("Enter Door 2");
        choice2 = new JButton();
        choice2.setOpaque(false);
        choice2.setContentAreaFilled(false);
        choice2.setForeground(Color.WHITE);
        choice2.setFocusPainted(false);
        choice2.setFont(choice1.getFont().deriveFont(25.0f));
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("choice2");
        
        //choice3 = new JButton("Enter Door 3");
        choice3 = new JButton();
        choice3.setOpaque(false);
        choice3.setContentAreaFilled(false);
        choice3.setForeground(Color.WHITE);
        choice3.setFocusPainted(false);
        choice3.setFont(choice1.getFont().deriveFont(25.0f));
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("choice3");
        
        //choice4 = new JButton("Enter Door 4");
        choice4 = new JButton();
        choice4.setOpaque(false);
        choice4.setContentAreaFilled(false);
        choice4.setForeground(Color.WHITE);
        choice4.setFocusPainted(false);
        choice4.setFont(choice1.getFont().deriveFont(25.0f));
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("choice4");
        
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
        
        playerTurnLabel = new JLabel("Turn #: " + playerTurn);
        playerTurnLabel.setFont(playerTurnLabel.getFont().deriveFont(25.0f));
        playerTurnLabel.setForeground(Color.WHITE);
        playerPanel.add(playerTurnLabel);
        
        choicesPanel.add(choice1);
        choicesPanel.add(choice2);
        choicesPanel.add(choice3);
        choicesPanel.add(choice4);
        
        ui.repaint();
        startScreen.setVisible(false);
        startButtonPanel.setVisible(false);
        
        entrance();
    }
    
    /*
    public void TicTacToe(){
            System.out.println("Hello");
            
            JFrame TTTFrame = new JFrame();
            tttContainer = TTTFrame.getContentPane();
            
            JPanel ticTacToeUI = new JPanel();
            ticTacToeUI.setLayout(new GridLayout(3, 3));
            ticTacToeUI.setBounds(0,0,340,340); 
            tttContainer.add(ticTacToeUI);
            
            JLabel ticTacToeImages = new JLabel();
            ticTacToeImages.setLayout(new GridLayout(3,3));
            ticTacToeImages.setBounds(0,0,340,340);
            //a1.setForeground(Color.red);
            
            a1 = new JButton();
            a1.addActionListener(tttgame);
            a1.setActionCommand("A1");
            
            a2 = new JButton();
            a2.addActionListener(tttgame);
            a2.setActionCommand("A2");
            
            a3 = new JButton();
            a3.addActionListener(tttgame);
            a3.setActionCommand("A3");
            
            b1 = new JButton();
            b1.addActionListener(tttgame);
            b1.setActionCommand("B1");
            
            b2 = new JButton();
            b2.addActionListener(tttgame);
            b2.setActionCommand("B2");
            
            b3 = new JButton();
            b3.addActionListener(tttgame);
            b3.setActionCommand("B3");
            
            c1 = new JButton();
            c1.addActionListener(tttgame);
            c1.setActionCommand("C1");
            
            c2 = new JButton();
            c2.addActionListener(tttgame);
            c2.setActionCommand("C2");
            
            c3 = new JButton();
            c3.addActionListener(tttgame);
            c3.setActionCommand("C3");
            //tttContainer.add(ticTacToeImages);
            
            /*
            JButton a2 = new JButton();
            JButton a3 = new JButton();
            JButton b1 = new JButton();
            JButton b2 = new JButton();
            JButton b3 = new JButton();
            JButton c1 = new JButton();
            JButton c2 = new JButton();
            JButton c3 = new JButton();

            ticTacToeUI.add(a1);
            ticTacToeUI.add(a2);
            ticTacToeUI.add(a3);
            ticTacToeUI.add(b1);
            ticTacToeUI.add(b2);
            ticTacToeUI.add(b3);
            ticTacToeUI.add(c1);
            ticTacToeUI.add(c2);
            ticTacToeUI.add(c3);
            
            TTTFrame.setSize(340,340);
            TTTFrame.setVisible(true);
            TTTFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            /*boolean playerWon = false;
            //Initilize frame
            JFrame TTTFrame = new JFrame();
            JPanel ticTacToeUI = new JPanel();
            TTTFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            TTTFrame.setSize(340,340);
            ticTacToeUI.setSize(340, 340);
            ticTacToeUI.setBackground(Color.YELLOW);
            ticTacToeUI.setLayout(new GridLayout(3, 3, 10, 10));
            
            tttContainer = TTTFrame.getContentPane();
            
            
            /*
            //button initlize and link to action listner
            ticTacToeUI.add(a1);
            a1.addActionListener(tttgame);
            a1.setActionCommand("A1");
            a1.setOpaque(false);
            a1.setBackground(Color.BLACK);
            
            ticTacToeUI.add(a2);
            a2.addActionListener(tttgame);
            a2.setActionCommand("A2");
            ticTacToeUI.add(a3);
            a3.addActionListener(tttgame);
            a3.setActionCommand("A3");

            ticTacToeUI.add(b1);
            b1.addActionListener(tttgame);
            b1.setActionCommand("B1");
            ticTacToeUI.add(b2);
            b2.addActionListener(tttgame);
            b2.setActionCommand("B2");
            ticTacToeUI.add(b3);
            b3.addActionListener(tttgame);
            b3.setActionCommand("B3");

            ticTacToeUI.add(c1);
            c1.addActionListener(tttgame);
            c1.setActionCommand("C1");
            ticTacToeUI.add(c2);
            c2.addActionListener(tttgame);
            c2.setActionCommand("C2");
            ticTacToeUI.add(c3);
            c3.addActionListener(tttgame);
            c3.setActionCommand("C3");

            TTTFrame.repaint();
            
            /*
            TTTFrame.add(ticTacToeUI);
            ticTacToeUI.setVisible(true);
            TTTFrame.setVisible(true);

            
            //resetBoard();
            
            while(playerWon == false){
                
                while(actionPerformed < 10){
                    TTTFrame.add(ticTacToeUI);
                    checkBoard();
                    TTTFrame.repaint();
                }

                resetBoard();
                actionPerformed = 0;
            }
}

    public int checkBoard(){
            
            int row1sum = tic[0][0] + tic[0][1] + tic[0][2];
            int row2sum = tic[1][0] + tic[1][1] + tic[1][2];
            int row3sum = tic[2][0] + tic[2][1] + tic[2][2];
        
            int col1sum = tic[0][0] + tic[1][0] + tic[2][0];
            int col2sum = tic[0][1] + tic[1][1] + tic[2][1];
            int col3sum = tic[0][2] + tic[1][2] + tic[2][2];
        
            int dig1sum = tic[0][0] + tic[1][1] + tic[2][2];
            int dig2sum = tic[0][2] + tic[1][1] + tic[2][0];
        
            if(row1sum == -3 || row2sum == -3 || row3sum == -3 || col1sum == -3 || col2sum == -3 || col3sum == -3 || dig1sum == -3 || dig2sum == -3){
                return gameStatus = 1;
            } else if(row1sum == 3 || row2sum == 3 || row3sum == 3 || col1sum == 3 || col2sum == 3 || col3sum == 3 || dig1sum == 3 || dig2sum == 3){
                playerWon = true;
                return gameStatus = 2;
            } else {
                return gameStatus = 0;
            }
    }
    
     public void resetBoard(){
        a1.setIcon(null);
        a2.setIcon(null);
        a3.setIcon(null);
        b1.setIcon(null);
        b2.setIcon(null);
        b3.setIcon(null);
        c1.setIcon(null);
        c2.setIcon(null);
        c3.setIcon(null);
            /*
            a1x.setVisible(false);
            a1o.setVisible(false);
            a2x.setVisible(false);
            a2o.setVisible(false);
            a3x.setVisible(false);
            a3o.setVisible(false);

            b1x.setVisible(false);
            b1o.setVisible(false);
            b2x.setVisible(false);
            b2o.setVisible(false);
            b3x.setVisible(false);
            b3o.setVisible(false);

            c1x.setVisible(false);
            c1o.setVisible(false);
            c2x.setVisible(false);
            c2o.setVisible(false);
            c3x.setVisible(false);
            c3o.setVisible(false);
    }
 
     
    public class tttHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event) {
            String choiceMadettt = event.getActionCommand();
            
            switch(choiceMadettt){
                case "A1":
                    a1.setIcon(a1x);
                    a1.setEnabled(false);
                    tic[0][0] = 1;
                    actionPerformed++;
                    break;
                case "A2":
                    a2.setIcon(a1x);
                    a2.setEnabled(false);
                    //a2x.setVisible(true);
                    tic[0][1] = 1;
                    actionPerformed++;
                    break;
                case "A3":
                    a3.setIcon(a1x);
                    a3.setEnabled(false);
                    //a3x.setVisible(true);
                    tic[0][2] = 1;
                    actionPerformed++;
                    break;
                case "B1":
                    b1.setIcon(a1x);
                    b1.setEnabled(false);
                    //b1x.setVisible(true);
                    tic[1][0] = 1;
                    actionPerformed++;
                    break;
                case "B2":
                    b2.setIcon(a1x);
                    b2.setEnabled(false);
                    //b2x.setVisible(true);
                    tic[1][1] = 1;
                    actionPerformed++;
                    break;
                case "B3":
                    b3.setIcon(a1x);
                    b3.setEnabled(false);
                    //b3x.setVisible(true);
                    tic[1][2] = 1;
                    actionPerformed++;
                    break;
                case "C1":
                    c1.setIcon(a1x);
                    c1.setEnabled(false);
                    //c1x.setVisible(true);
                    tic[2][0] = 1;
                    actionPerformed++;
                    break;
                case "C2":
                    c2.setIcon(a1x);
                    c2.setEnabled(false);
                    //c2x.setVisible(true);
                    tic[2][1] = 1;
                    actionPerformed++;
                    break;
                case "C3":
                    c3.setIcon(a1x);
                    c3.setEnabled(false);
                    //c3x.setVisible(true);
                    tic[2][2] = 1;
                    actionPerformed++;
                    break;
            }
            //computer turn
            boolean fill = false;
                while(fill == false && actionPerformed != 9){
                    row = rand.nextInt(3);
                    column = rand.nextInt(3);
                    
                    if(tic[row][column] == 1 || tic[row][column] == -1){
                        fill = false; 
                    } else {
                        fill = true;
                        tic[row][column] = -1;
                        actionPerformed++;
                    } 
                }
                
                
                if (row == 0 && column == 0 && actionPerformed != 9){
                    a1.setIcon(a1o);
                    //a1x.setVisible(true);
                } else if (row == 0 && column == 1 && actionPerformed != 9){
                    a2.setIcon(a1o);
                    //a2x.setVisible(true);
                } else if (row == 0 && column == 2 && actionPerformed != 9){
                    a3.setIcon(a1o);
                    //a3x.setVisible(true);
                } else if (row == 1 && column == 0 && actionPerformed != 9){
                    b1.setIcon(a1o);
                    //b1x.setVisible(true);
                }  else if(row == 1 && column == 1 && actionPerformed != 9){
                    b2.setIcon(a1o);
                    //b2x.setVisible(true);
                } else if (row == 1 && column == 2 && actionPerformed != 9){
                    b3.setIcon(a1o);
                    //b3x.setVisible(true);
                } else if (row == 2 && column == 0 && actionPerformed != 9){
                    c1.setIcon(a1o);
                    //c1x.setVisible(true);
                } else if (row == 2 && column == 1 && actionPerformed != 9){
                    c2.setIcon(a1o);
                    //c2x.setVisible(true);
                } else if (row == 2 && column == 2 && actionPerformed != 9){
                    c3.setIcon(a1o);
                    //c3x.setVisible(true);
                }
                
            
        }
    } 
*/
    public void entrance() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "entrance";
        if (libraryComplete == true && drownRoomComplete == true && feedRoomComplete == true && sphinxRoomComplete == true) {
            gameTextArea.setText("Having completed each room a divine light shines further into the dungeon lighting your way." +
                    " You may proceed.");
            choice1.setText("Next");
            choice2.setText("");
            choice2.setText("");
            choice2.setText("");
        } else {
            gameTextArea.setText("You've entered the Dungeon! There are four rooms \nahead of you.");
            choice1.setText("Examine Door 1");
            choice2.setText("Examine Door 2");
            choice3.setText("Examine Door 3");
            choice4.setText("Examine Door 4");
        }
    }
    
    public void deathReset1() {
        playerTurn = 0;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "deathReset1";
        gameTextArea.setText("You awaken at the entrance of the dungeon.");
        choice1.setText("Examine Door 1");
        choice2.setText("Examine Door 2");
        choice3.setText("Examine Door 3");
        choice4.setText("Examine Door 4");
    }
    
    public void door1Library() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "door1Library";
        gameTextArea.setText("You enter a library and the door behind locks shut!"); 
        choice1.setText("Examine the room");
        choice2.setText("Wait");
        choice3.setText("Exit the room");
        choice4.setText("");
    }
    
    public void libraryLocked() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "libraryLocked";
        gameTextArea.setText("The door is locked shut!");
        choice1.setText("Examine the room");
        choice2.setText("Wait");
    }
    
    public void examineDoor1(){
        position = "examineDoor1";
        gameTextArea.setText("A large wood door with 'quiet in the library please' \nengraved on the front");
        choice1.setText("Enter the Library");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineLibrary(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineLibrary";
        if (libraryStoveOn == true) {
                gameTextArea.setText("The room is a library with a huge safe in the middle" +
                    " \nwith a combination lock, there is a kettle on a stove \nin the room." + 
                    " The kettle is whistling.");
        }
        else {
            gameTextArea.setText("The room is a library with a huge safe in the middle" +
                    " \nwith a combination lock, there is a kettle on a stove \nin the room." +
                    " The kettle has steam drifting out it's spout.");
        }
        choice1.setText("Listen to the room");
        choice2.setText("Try the safe");
        choice3.setText("Turn off the stove");
        choice4.setText("Wait");
        
        // Check flags to see if stove is off, room has been listened to, and safe then interacted with
        // unlock door option becomes available to go back to other puzzles
    }
    
    public void libraryListen() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "libraryListen";
        if (libraryStoveOn == true) {
            gameTextArea.setText("You hear a loud whistling from the kettle echo throughout " +
                    "the library.");
            choice1.setText("Return");
            choice2.setText("Try the safe");
            choice3.setText("Turn off the stove");
            choice4.setText("Wait");
        }
        else if (libraryStoveOn == false) {
            gameTextArea.setText("You hear a clock tick mysteriously off rhythm, " +
                    "almost as if it were a sequence. You quietly remember the " +
                    "sequence to yourself.");
            libraryCombinationKnown = true;
            choice1.setText("Return");
            choice2.setText("Try the safe");
            choice3.setText("The stove is turned off.");
            choice4.setText("Wait");
        }
        // If stove on hear loud listening, if off hear password to safe, flips variable to open safe
        // choices go back to room, try the safe, turn off the stove, wait
    }
    
    public void libraryTrySafe() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "libraryTrySafe";
        if (libraryCombinationKnown == false) {
            gameTextArea.setText("You enter a random code and it does nothing.");
            choice1.setText("Listen to the room");
            choice2.setText("Return");
            choice3.setText("Turn stove off");
            choice4.setText("Wait");
        } else {
            gameTextArea.setText("You enter in the sequence you heard form the clock!" +
                    " You hear the lock on the door behind you deactivatem " +
                    " You can now exit the room!");
            choice1.setText("Exit");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            libraryComplete = true;
        }
        // "you enter a random code and it does nothing. If stove the is off and listened to room again
        // can input code into the safe. "You input the code you know into the safe"
        // listen to the room if not already, return, turn off the stove, wait
        // 
    }
    
    public void libraryTurnOffStove() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "libraryTurnOffStove";
        if (libraryStoveOn == true) {
            gameTextArea.setText("You turn off the stove. The heat of the stove stops burning " +
                    "the kettle and the sound of the room changes quickly.");
            libraryStoveOn = false;
            choice1.setText("Listen to the room");
            choice2.setText("Try the safe");
            choice3.setText("Return");
            choice4.setText("Wait");
        } else {
            gameTextArea.setText("The stove is already turned off.");
            choice1.setText("Listen to the room");
            choice2.setText("Try the safe");
            choice3.setText("Return");
            choice4.setText("Wait");
        }
        // The heat of the stove stops burning the kettle and the sounds change quickly.
        // After stove has been turned off run libraryStoveOff
        // choices listen to the room if havent, try safe if havent, return, wait
    }
    
    public void examineDoor2(){
        // flavor text for FEED room
        // choices enter the room, return
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineDoor2";
        gameTextArea.setText("A door made of iron covered in scratches");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }

    public void door2FeedRoom() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "door2FeedRoom";
        gameTextArea.setText("You enter into an open kitchen coverred in moss" +
                ", a large monster is chained to the far wall next to the exit door."); 
        choice1.setText("Examine the room");
        choice2.setText("Wait");
        choice3.setText("Exit the room");
        choice4.setText("");
    }
    
    public void feedRoomLocked() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "feedRoomLocked";
        gameTextArea.setText("You try the locked door but it doesn't budge." +
                " The noise wakes the monster and it attacks you!" +
                " You try to escape but there is no where to run!");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }
    
    public void feedRoomNext() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "feedRoomNext";
        gameTextArea.setText("You awaken at the entrance of the dungeon, your heart racing as you " +
                "recall you recent encounter.");
        choice1.setText("Examine Door 1");
        choice2.setText("Examine Door 2");
        choice3.setText("Examine Door 3");
        choice4.setText("Examine Door 4");
    }
    
    public void examineFeedRoom (){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineFeedRoom";
        gameTextArea.setText("The room is covered in moss and has a lot of rotten meat around" +
                " on the floor. there's a pot of water boiling over a fire. You notice a poster, " +
                "mostly covered in moss on the floor. A dangerous looking monster sleeps nearby.");
        if (weakPoison == false && strongPoison == false) {
            if (flagMoss == false && flagMeat == false) {
                choice1.setText("Examine poster");
                choice2.setText("Pickup moss");
                choice3.setText("Pickup meat");
                choice4.setText("Wait");
            } else if (flagMoss == true && flagMeat == false) {
                choice1.setText("Examine Poster");
                choice2.setText("Put moss in pot");
                choice3.setText("Pickup meat");
                choice4.setText("Wait");
            } else if (flagMoss == true && flagMeat == true) {
                choice1.setText("Examine poster");
                choice2.setText("Put moss in pot");
                choice3.setText("Put meat in pot");
                choice4.setText("Wait");
            } else if (flagMoss == false && flagMeat == true) {
                choice1.setText("Examine poster");
                choice2.setText("Pickup moss");
                choice3.setText("Put meat in pot");
                choice4.setText("Wait");
            }
        } else if (weakPoison == true || strongPoison == true) {
            choice1.setText("Examine Poster");
            choice2.setText("Poison the monster");
            choice3.setText("Wait");
            choice4.setText("");
        }
        // game text falvor text from disc 3/16
        // choices of adding meat or moss to kitchen equipment, for successful run moss first, kitchen equipment,
        // meat, kitchen, feed monster, monster dies flavor text, can safely open the door.
        // poster says be careful with missing moss improperly can create poison warning!
        // adding moss and meat create a 'wet meat' monster doesn't die, can pull infinite amount
        // of meat or moss as long as not in inventory.
        // wet meat, causes monster to go to sleep, using door causes monster to wake up (mini fail state)
    }
    
    public void poisonMonsterFeed() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "poisonMonsterFeed";
        if (weakPoison == true) {
            gameTextArea.setText("You attempt to poison the monster with your concocted poison!" +
                    " It isn't fully effective! The monster wakes from its slumber dazed and angry!" +
                    " It begins to swing at everything in its sight. You have been struck by the monster!");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (strongPoison == true) {
            gameTextArea.setText("You attempt to poison the monster with you concocted poison!" +
                    " It is fully effective! The monster remains asleep until it's heart beat slows" +
                    " to a stop. The room is now safe to exit!");
            feedRoomComplete = true;
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void putMossPot() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "putMossPot";
        if (potEmpty == true) {
            gameTextArea.setText("You put moss into the pot. It begins to boil.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            potMoss = true;
            potEmpty = false;
            flagMoss = false;
            if (flagMeat == true) {
                playerInv.setText("Meat");
            } else {
                playerInv.setText("");
            }
        } else if (potMoss == true && potMossMeat == false) {
            gameTextArea.setText("You put more moss into the pot. The mixture begins to fall apart and nothing but" +
                    " water remains. The pot continues to boil.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            flagMoss = false;
            potEmpty = true;
            playerInv.setText("");
        } else if (potMeat == true && potMossMeat == false) {
            gameTextArea.setText("You put moss into the pot. It mixes with meat to create a weak poison!");
            weakPoison = true;
            playerInv.setText("Weak Poison");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            flagMoss = false;
            potEmpty = true;
            playerInv.setText("");
        }
    }
    
    public void putMeatPot() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "putMeatPot";
        if (potEmpty == true) {
            gameTextArea.setText("You put meat into the pot. It begins to boil.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            flagMeat = false;
            potMeat = true;
            potEmpty = false;
            if (flagMoss == true) {
                playerInv.setText("Moss");
            } else {
                playerInv.setText("");
            }
        } else if (potMoss == true && potMossMeat == false) {
            gameTextArea.setText("You put meat into the pot with the moss. The mixture begins to boil" +
                    " creating a strong poison!");
            strongPoison = true;
            playerInv.setText("Strong Poison");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            flagMeat = false;
            potEmpty = true;
            if (flagMoss == true) {
                playerInv.setText("Moss");
            } else {
                playerInv.setText("");
            }
        } else if (potMeat == true && potMossMeat == false) {
            gameTextArea.setText("You put more meat into the pot. The mixture softens into something useless." +
                    " Only water remains in the pot");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            potEmpty = true;
            potMoss = false;
            potMeat = false;
            flagMeat = false;
            if (flagMoss == true) {
                playerInv.setText("Moss");
            } else {
                playerInv.setText("");
            }
        }
    }
    public void examinePosterFeed() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examinePosterFeed";
        gameTextArea.setText("Be careful with mixing moss improperly! A powerful poison can be made!" +
                " Moss cooked for too long is dangerous!");
        choice1.setText("Return");
        choice2.setText("Pickup moss");
        choice3.setText("Pickup meat");
        choice4.setText("Wait");
    }
    
    public void pickupMossFeed() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "pickupMossFeed";
        if (flagMoss == false) {
            gameTextArea.setText("You pickup some moss from around the room.");
            flagMoss = true;
        } else {
            gameTextArea.setText("You already have some moss!");
        }
        if (flagMoss == true && flagMeat == true) {
            playerInv.setText("Moss, Rotten Meat");
        } else {
            playerInv.setText("Moss");
        }
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void pickupMeatFeed() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "pickupMeatFeed";
        if (flagMeat == false) {
            gameTextArea.setText("You pickup some meat from around the kitchen.");
            flagMeat = true;
        } else {
            gameTextArea.setText("You already have some meat!");
        }
        if (flagMoss == true && flagMeat == true) {
            playerInv.setText("Moss, Rotten Meat");
        } else {
            playerInv.setText("Rotten Meat");
        }
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineDoor3(){
        // flavor SPHINX room
        // choices enter the room, return
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineDoor3";
        gameTextArea.setText("A door made of worn sandstone.");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void door3SphinxRoom(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "door3Sphinxroom";
        gameTextArea.setText("You enter into a large open field of sand, a towering presence looms" +
                " over you and asks 'What is always old and sometimes new; never sad, sometimes blue;" +
                " never empty, but sometimes full; never pushes, always pulls?'");
        choice1.setText("The moon");
        choice2.setText("The ocean");
        choice3.setText("A door");
        choice4.setText("A butler");
        // Enter room, sphinx riddle, user can enter text (TRY THIS)
        // if not choices are given, only one answer right
        // "What is always old an dsometimes new; never sad, sometimes blue;
        // never empty, but sometimes full; never pushes, always pulls?"
        // choices if user text cannot be done is MOON(Answer), ocean (FALSE), A door (FALSE), A Butler (False)
        // Lets say only one try, if wrong sphinx kills you flavor text. (Return to previous hub)
    }
    
    public void sphinxComplete(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "sphinxComplete";
        sphinxRoomComplete = true;
        gameTextArea.setText("You've correctly solved the sphinx's riddle! You may now leave the room");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void sphinxFail(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "sphinxFail";
        gameTextArea.setText("You've incorrectly answered the sphinx's riddle! They swing their mighty hand down upon you!");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineDoor4(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineDoor4";
        gameTextArea.setText("A metal door with a glass porthole.");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
        // flavor Drowining Room (4/6) metal door
        // choices enter the room, return
    }
    
    public void door4Drown(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "door4Drown";
        if (turnTracker < 1) {
            gameTextArea.setText("You enter into a tight room that has a leak pouring water into the room," +
                " You notice a soaked diary floating in the corner, and a switch on the ceiling." +
                " The door locks behind you.");
            choice1.setText("Read the diary");
            choice2.setText("Flip the switch");
            choice3.setText("Look out the door");
            choice4.setText("Wait");
            turnTracker++;
        } else if (turnTracker <= 5) {
            gameTextArea.setText("The water continues to rise in the room! The diary continues to drift around with " +
                    "the flowing water.");
            choice1.setText("Read the diary");
            choice2.setText("Flip the switch");
            choice3.setText("Look out the door");
            choice4.setText("Wait");
            turnTracker++;
        } else if (turnTracker <= 7) {
            gameTextArea.setText("The water has risen high enough to reach the switch!");
            choice1.setText("Read the diary");
            choice2.setText("Flip the switch");
            choice3.setText("Look out the door");
            choice4.setText("Wait");
            turnTracker++;
        } else {
            gameTextArea.setText("The water has risen too high. You are exhausted from treading water and blackout!");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        // tight room with water slowly pouring in
        // soaked diary item, can read to push turn forward
        // water level to max, turn based, at max level you can flip a switch to drain the water
        // flavor text progressively gets more dangerous, say like 7 turns, at 9 you drown
        // choices read diary, try the door, wait, look outside porthole (entrance) "You feel fear that room is full
        // of water wishing you were on the other side"
        // Fail state sends them back to entrance area "You've drowned and awake at the entrance of the dungeon
    }
    
    public void readDiary(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        turnTracker++;
        position = "readDiary";
        gameTextArea.setText("The diary of a fallen sailor, you read about their life for a while." +
                "They were a patient sailor, seemingly knowing the precise time to push forward.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void flipSwitchDrown(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        turnTracker++;
        position = "flipSwitchDrown";
        if (turnTracker < 5) {
            gameTextArea.setText("The switch is too far for you to reach! The water continues to pour" +
                    " into the room.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (turnTracker > 4 && turnTracker < 8) {
            gameTextArea.setText("The room has finally filled up enough for you to reach the switch!" +
                    " You flip the switch and the sound of running water stops. The room begins to drain.");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void portholeDrown(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        turnTracker++;
        position = "portholeDrown";
        gameTextArea.setText("Looking out at the dry dungeon your fear grows as the room continues to fill with water.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void drownRoomComplete() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "drownRoomComplete";
        gameTextArea.setText("With the room finally drained you can now safely exit!");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        drownRoomComplete = true;
    }
    
    public void hub2(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "hub2";
        playerInv.setText("");
        gameTextArea.setText("You've entered into another part of the dungeon. In front of you are four more doors.");
        choice1.setText("Examine Door 5");
        choice2.setText("Examine Door 6");
        choice3.setText("Examine Door 7");
        choice4.setText("Examine Door 8");
        turnTracker = 0;
        // Use boolean flag to set whether each room is complete
        // Flavor text divine light guides you to further into the dungeon
        // call next hub room method to initiate next room of puzzles
        // reset turn count
    }

    public void deathReset2() {
        playerTurn = 0;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "deathReset2";
        playerInv.setText("");
        turnTracker = 0;
        gameTextArea.setText("You awaken somewhere deep in the dungeon. In front of are four more doors.");
        choice1.setText("Examine Door 5");
        choice2.setText("Examine Door 6");
        choice3.setText("Examine Door 7");
        choice4.setText("Examine Door 8");
    }
    
    public void examineDoor5(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineDoor5";
        gameTextArea.setText("A door made of packed dirt.");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void door5DirtRoom() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "door5DirtRoom";
        gameTextArea.setText("You enter into a cramped cellar with walls made of dirt. The door out is obscured by a mound of dirt. You will" +
                " have to dig out to exit.");
        choice1.setText("Examine the room");
        choice2.setText("Wait");
        choice3.setText("");
        choice4.setText("");
        // maybe have a hidden shovel, or hanging on the wall, several objects hanging on wall, examine
        // wall to find a shovel to dig in the room, having shovel in inventory opens option to dig the pile
        // of dirt.
        // Items worm flavor text, dirt flavor text, when examining the room
        // examining worms to find direction their crawling,
        // when choosing a dig ooption, choices are are cardinal directions. have to dig in the same direction
        // as the worms. (ie forward, left, right, worms can change direction based on how many turns,
        // ie (turn counter +5 worms change direction, have to dig in that direction.
        // digging in the wrong direction could collapse on you, resetting you to the hub
        // choosing wrong direction than the worms causese collapse flavor text.
    }
    
    public void examineDirtRoom() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineDirtRoom";
        turnTracker++;
        gameTextArea.setText("The room is cramped and full of dirt. You can see worms moving around on the dirt pile. " +
                "A few tools are hanging on a wall. The pile of dirt still blocks the exit.");
        choice1.setText("Examine wall");
        choice2.setText("Examine worms");
        choice3.setText("Dig");
        choice4.setText("Wait");
    }
    
    public void examineWallDirt(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineWallDirt";
        if (haveShovel == false) {
            gameTextArea.setText("Hanging on the wall are a bunch of garden tools. The shovel seems the most useful.");
            choice1.setText("Grab the shovel");
            choice2.setText("Return");
            choice3.setText("");
            choice4.setText("");
        }  else if (haveShovel == true) {
            gameTextArea.setText("Hanging on the wall are a bunch of garden tools. You've already grabbed what seemed the most useful.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void grabShovel(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "grabShovel";
        turnTracker++;
        gameTextArea.setText("You grab the shovel off the wall.");
        haveShovel = true;
        playerInv.setText("Shovel");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineWormsDirt() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineWormsDirt";
        turnTracker++;
        gameTextArea.setText("The worms seem to move north, then east, then north, then west");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void digDirt() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "digDirt";
        if (haveShovel == false) {
            gameTextArea.setText("You don't have any tools to dig with!");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (haveShovel == true){
            gameTextArea.setText("You attempt to dig out the dirt. Which direction should you go?");
            choice1.setText("North");
            choice2.setText("East");
            choice3.setText("South");
            choice4.setText("West");
        }
    }
    
    public void digNorth(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "digNorth";
        if (digNorth == false && digEast == false && digSouth == false && digWest == false){
            gameTextArea.setText("You dig north and open the path forward. Where should you dig next?");
            digNorth = true;
            choice1.setText("North");
            choice2.setText("East");
            choice3.setText("South");
            choice4.setText("West");
        } else if (digNorth == true && digEast == true) {
            gameTextArea.setText("You dig north again and continue to open the path forward. Where should you dig next?");
            digNorth2 = true;
            choice1.setText("North");
            choice2.setText("East");
            choice3.setText("South");
            choice4.setText("West");
        } else if (digNorth2 == true) {
            gameTextArea.setText("You dig north again but the ground collapses beneath you! You begin to fall into the darkness");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void digEast(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "digEast";
        if (digNorth == true && digEast == false) {
            gameTextArea.setText("You dig east and open the path forward. Where should you dig next?");
            digEast = true;
            choice1.setText("North");
            choice2.setText("East");
            choice3.setText("South");
            choice4.setText("West");
        } else if (digEast == true) {
            gameTextArea.setText("You dig east again but the ground collapses beneath you! You begin to fall into the darkness!");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void digSouth() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "digSouth";
        gameTextArea.setText("You dig south but the ground collapses beneath you! You begin to fall into the darkness!");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void digWest() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "digWest";
        if (digNorth2 == false) {
            gameTextArea.setText("You dig west but the ground collapses beneath you! you begin to fall into the darkness!");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (digNorth2 == true) {
            gameTextArea.setText("You dig west and open a safe passage to the door! You can now safely exit.");
            digRoomComplete = true;
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void examineDoor6(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineDoor6";
        gameTextArea.setText("A tall door, you hear a large breeze from behind it.");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void door6WindRoom() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "door6WindRoom";
        gameTextArea.setText("You enter into the room where a gust of wind is pushing you back from the far side door. There is a lever on the high ceiling.");
        choice1.setText("Examine the room");
        choice2.setText("Wait");
        choice3.setText("");
        choice4.setText("");
        // enter room flavor text about the kite pieces on ground, gust of wind, lever on the ceiling
        // choices examine sticks, paper, and string. use paper on string, sticks on paper to create
        // maybe poster on wall showing proper order, paper on string, then sticks on paper to properly make
        // kite, if improper assembly wind tunnel blasts you into the wall (by kite maybe), return to 2nd hub
        // choice hold onto kite, to let it fly in wind gust, choices to move kite left/ right, have sign explain
        // "move kite right, then down, etc. to get to switch", choosing wrong diretions would cause fail state
        // kite pulls them into the wall or something. 
        // if they sucessful follow the posters direction the switch is flipped by the kite, and the door is unlocked
    }
    
    public void examineWindRoom() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineWindRoom";
        gameTextArea.setText("The room is small with a big gust pushing towards you. Scattered around the room are twigs and paper" +
                " tied together with string.");
        if (haveTwig == false && haveString == false && haveKite == false) {
            choice1.setText("Examine twigs");
            choice2.setText("Examine string and paper");
            choice3.setText("Wait");
            choice4.setText("");
        } else if (haveTwig == true && haveString == false){
            choice1.setText("Examine string and paper");
            choice2.setText("Wait");
            choice3.setText("");
            choice4.setText("");
        } else if (haveTwig == false && haveString == true) {
            choice1.setText("Examine twigs");
            choice2.setText("Wait");
            choice3.setText("");
            choice4.setText("");
        } else if (haveTwig == true && haveString == true) {
            choice1.setText("combine items");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }else if (haveKite == true){
            gameTextArea.setText("The gust of wind blows a poster into your view that reads left, right, up, up");
            choice1.setText("Hold onto kite");
            choice2.setText("Relase the kite");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void examineTwigs(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineTwigs";
        gameTextArea.setText("Strong twigs that looks to be able to hold a decent weight. You pick them up.");
        haveTwig = true;
        if (haveString == false) {
            playerInv.setText("Twigs");
        } else {
            playerInv.setText("Twigs, String and paper");
        }
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineString() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineString";
        gameTextArea.setText("Strong twine tied to heavy duty paper. You pick them up.");
        haveString = true;
        if (haveTwig == false){
            playerInv.setText("String and paper");
        } else {
            playerInv.setText("Twigs, String and paper");
        }
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void combineTwigString() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "combineTwigString";
        gameTextArea.setText("You tie the string around the twig. You've made a homemade kite!");
        haveKite = true;
        playerInv.setText("Kite");
        haveTwig = false;
        haveString = false;
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void holdKite() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "holdKite";
        gameTextArea.setText("You attempt to hold onto the kite but the gust of wind throws you into the wall. You blackout.");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void releaseKite(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "releaseKite";
        gameTextArea.setText("You release the kite into the room. Which direction should you fly?");
        choice1.setText("Up");
        choice2.setText("Right");
        choice3.setText("Down");
        choice4.setText("Left");
    }
    
    public void flyUp() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "flyUp";
        if (flyUp == true){
            gameTextArea.setText("The kite lifts even higher into the room flipping the switch! You may now safely exit the room!");
            windRoomComplete = true;
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (flyLeft == true && flyRight == true) {
            gameTextArea.setText("The kite lifts into the upper area of the room. Where do you fly it next?");
            flyUp = true;
            choice1.setText("Up");
            choice2.setText("Right");
            choice3.setText("Down");
            choice4.setText("Left");
        } else {
            gameTextArea.setText("The kite catches a strong breeze slamming you into the wall! You blackout.");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void flyUp2() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "flyUp2";
        gameTextArea.setText("The kite lifts even higher into the room flipping the switch! You may now safely exit the room!");
        windRoomComplete = true;
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void flyRight(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "flyRight";
        if (flyLeft == true && flyUp == false) {
            gameTextArea.setText("The kite moves to the right of the room. Where do you fly it next?");
            flyRight = true;
            choice1.setText("Up");
            choice2.setText("Right");
            choice3.setText("Down");
            choice4.setText("Left");
        } else {
            gameTextArea.setText("The kite catches a strong breeze slamming you into the wall! You blackout.");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void flyDown(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "flyDown";
        gameTextArea.setText("The kite catches a strong breeze pulling you into the wall! You blackout.");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void flyLeft(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "flyLeft";
        if (flyLeft == false) {
            gameTextArea.setText("The kite floats to the left of the room. Where do you fly it next?");
            choice1.setText("Up");
            choice2.setText("Right");
            choice3.setText("Down");
            choice4.setText("Left");
            flyLeft = true;
        } else if (flyLeft == true) {
            gameTextArea.setText("The kite catches a strong breeze slamming you into the wall! You blackout.");
            choice1.setText("Next");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void door7CarsonsPuzzle(){
        
    }
    
    public void door8GregsTicTacToe(){
        
    }
    
    public void door9GregsLightPuzzle(){
        
    }
    
    public void examineDoor7(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "examineDoor7";
        gameTextArea.setText("A small stone door covered in ash and burn marks.");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void door7HeatRoom(){
        // Room begins heating up tremendously, Maybe set turn a limit
        // intreact with wax on frying pan, combine wax with cloth, after reading book insulation
        // use fireproof cloth on door that is too hot to touch otherwise. (SUCCESSFUL PATH)
        // fail states, took too many turns only, combining cloth on frying pan burns the cloth, can grab more cloth,
        // not reading book before using wax melts wax too quickly, but can get more wax.
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "door7HeatRoom";
        gameTextArea.setText("You enter into a cramped room with a large stove that suddenly turns on and starts heating up.");
        choice1.setText("Examine the room");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineHeatRoom(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "examineHeatRoom";
        gameTextArea.setText("The room is small with plenty of trash laying about. There is a frying pan, wax tablets, cloth and a book" +
                " on insulation nearby. The door to the exit is covered in thick wax.");
        if (haveFryPan == false){
            choice1.setText("Pickup frying pan");
        } else if (haveFryPan == true) {
            choice1.setText("Put pan on stove");
        }
        if (haveWax == false){
            choice2.setText("pickup wax");
        } else if (haveWax == true){
            choice2.setText("Put wax on stove");
        }
        if (haveCloth == false) {
            choice3.setText("pickup cloth");
        } else if (haveCloth == true) {
            choice3.setText("Put cloth on stove");
        }
        choice4.setText("Read the book");
    }
    
    public void pickupFryPan(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "pickupFryPan";
        gameTextArea.setText("You pickup the pan.");
        haveFryPan = true;
        if (haveWax == false && haveCloth == false){
            playerInv.setText("Fry Pan");
        } else if (haveWax == true && haveCloth == false){
            playerInv.setText("Fry Pan, Wax");
        } else if (haveWax == false && haveCloth == true){
            playerInv.setText("Fry Pan, Cloth");
        } else if (haveWax == true && haveCloth == true){
            playerInv.setText("Fry Pan, Wax, Cloth");
        }
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void putPanStove() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "putPanStove";
        panStove = true;
        haveFryPan = false;
        gameTextArea.setText("You put the pan on the stove.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void pickupWax() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "pickupWax";
        gameTextArea.setText("You pickup the wax.");
        haveWax = true;
        if (haveFryPan == false && haveCloth == false){
            playerInv.setText("Wax");
        } else if (haveFryPan == true && haveCloth == false){
            playerInv.setText("Fry Pan, Wax");
        } else if (haveFryPan == false && haveCloth == true){
            playerInv.setText("Wax, Cloth");
        } else if (haveFryPan == true && haveCloth == true){
            playerInv.setText("Fry Pan, Wax, Cloth");
        }
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void putWaxStove() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "putWaxStove";
        haveWax = false;
        if (panStove == false) {
            gameTextArea.setText("The wax burns up on the hot stove into an unuseable mess.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (panStove == true && clothStove == false) {
            gameTextArea.setText("The wax begins to melt on the pan.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            waxStove = true;
        }
    }
    
    public void pickupCloth() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "pickupCloth";
        gameTextArea.setText("You pickup the cloth");
        haveCloth = true;
        if (haveFryPan == false && haveWax == false){
            playerInv.setText("Cloth");
        } else if (haveFryPan == true && haveWax == false){
            playerInv.setText("Fry Pan, Cloth");
        } else if (haveFryPan == false && haveWax == true){
            playerInv.setText("Wax, Cloth");
        } else if (haveFryPan == true && haveWax == true){
            playerInv.setText("Fry Pan, Wax, Cloth");
        }
        
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void putClothStove() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "putClothStove";
        haveCloth = false;
        if (panStove == false) {
            gameTextArea.setText("The cloth burns up on the hot stove into an unuseable mess.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (panStove == true && waxStove == false) {
            gameTextArea.setText("The cloth begins to burn on the pan. It becomes unuseable.");
            choice1.setText("Return");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else if (panStove == true && waxStove == true) {
            gameTextArea.setText("The cloth and wax combine into an insulated cloth!");
            choice1.setText("Try the door");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
    
    public void readHeatBook() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "readHeatBook";
        gameTextArea.setText("The book suggests melted wax can become a good insulator if combined with something.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void heatRoomFinish(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "heatRoomFinish";
        gameTextArea.setText("Using the insulated cloth you can now open the door!");
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        heatRoomComplete = true;
    }
    
    public void examineDoor8() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "examineDoor8";
        gameTextArea.setText("A door similar to that of a classroom.");
        choice1.setText("Enter the room");
        choice2.setText("Return");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void door8Locked(){
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "door8Locked";
        gameTextArea.setText("This door remains locked shut. Try the other doors first.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void door8() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: "+ playerTurn);
        position = "Door8";
        gameTextArea.setText("You enter into a classroom. The professor asks a simple question." +
                " 'What class section was this game developed in?'");
        choice1.setText("CSI 1310");
        choice2.setText("CSI 5280");
        choice3.setText("CSI 2990");
        choice4.setText("CSI 3660");
    }
    
    public void gameComplete() {
        position = "gameComplete";
        playerTurnLabel.setText("Turn #: " + playerTurn);
        gameTextArea.setText("You have bested our dungeon and completed your journey! Thank you so much for " +
                "playing our game!");
        choice1.setText("You");
        choice2.setText("Have");
        choice3.setText("Won");
        choice4.setText("!!");
    }
    public void door11ClockRoom(){
        // Elevator buttons floor 1,2,3,4 choices to go to each floor
        // can look out the elevator, clock changes on each floor,
        // to leave the elevator input proper times to get a pass code
        // to enter into the safe to exit the room, 
        // choices example floor1: look out window, go to floor2, etc.
        // have a creature on each floor, flavor text over safe saying like "Dwarfs were first etc..."
        // flavor text for dwarves mining or doing something a clock in the room reads ##
        // another floor has goblins/kobolds with a clock in reading ##
        // another floor has vampires with a sun dial reading ##
        // another floor has centaurs with the position of the sun suggsting it is around ##
        // in safe code position, choices are the times from each floor, have to input proper order based
        // off flavor text from above.
    }
    
    public void door12() {
        
    }
    public void grabGoldenKey() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "grabGoldenKey";
        gameTextArea.setText("You've grabbed the golden key!");
        flagGoldenKey = true;
        playerInv.setText("Golden Key");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void examineGoldenKey() {
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "examineGoldenKey";
        gameTextArea.setText("A key shimmering in gold.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void waitTurn(String sentPosition) {
        String returnPosition = sentPosition; 
        playerTurn++;
        playerTurnLabel.setText("Turn #: " + playerTurn);
        position = "waitTurn";
        gameTextArea.setText("You pause for a moment to catch your breath.");
        choice1.setText("Return");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public class startButtonHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event) {
            //TicTacToe();
            gameUI();
        }
    }
    
    public class choiceButtonHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event) {
            
            String choiceMade = event.getActionCommand();
            
            switch(position){
            case "entrance":
                if (libraryComplete == true && drownRoomComplete == true && feedRoomComplete == true && sphinxRoomComplete == true) {
                    switch(choiceMade){
                        case "choice1": hub2(); break;
                    }
                    break;
                } else {
                    switch(choiceMade){
                        case "choice1": examineDoor1(); break;
                        case "choice2": examineDoor2(); break;
                        case "choice3": examineDoor3(); break;
                        case "choice4": examineDoor4(); break;
                    }
                    break;
                }
            case "examineDoor1":
                switch(choiceMade){
                    case "choice1": door1Library(); break;
                    case "choice2": entrance(); break;
                }
                break;
            case "door1Library":
                switch(choiceMade){
                    case "choice1": examineLibrary(); break;
                    case "choice2": waitTurn(position); break;
                    case "choice3": libraryLocked(); break;
                }
                break;
            case "examineLibrary":
                switch(choiceMade){
                    case "choice1": libraryListen(); break;
                    case "choice2": libraryTrySafe(); break;
                    case "choice3": libraryTurnOffStove(); break;
                    case "chocie4": waitTurn(position); break;
                }
                break;
            case "libraryLocked":
                switch(choiceMade){
                    case "choice1": examineLibrary(); break;
                    case "choice2": waitTurn(position); break;
                }
                break;
            case "libraryListen":
                switch(choiceMade){
                    case "choice1": examineLibrary(); break;
                    case "choice2": libraryTrySafe(); break;
                    case "choice3": libraryTurnOffStove(); break;
                    case "chocie4": waitTurn(position); break;
                }
                break;
            case "libraryTrySafe":
                if (libraryCombinationKnown == false) {
                    switch(choiceMade){
                        case "choice1": libraryListen(); break;
                        case "choice2": examineLibrary(); break;
                        case "choice3": libraryTurnOffStove(); break;
                        case "choice4": waitTurn(position); break;
                    }
                    break;
                } else {
                    switch(choiceMade){
                        case "choice1": entrance(); break;
                    }
                    break;
                }
            case "libraryTurnOffStove":
                switch(choiceMade){
                    case "choice1": libraryListen(); break;
                    case "choice2": libraryTrySafe(); break;
                    case "choice3": examineLibrary(); break;
                    case "choice4": waitTurn(position); break;
                }
                break;
            case "examineDoor2":
                switch(choiceMade){
                    case "choice1": door2FeedRoom(); break;
                    case "choice2": entrance(); break;
                }
                break;
            case "door2FeedRoom":
                switch(choiceMade){
                    case "choice1": examineFeedRoom(); break;
                    case "choice2": waitTurn(position); break;
                    case "choice3": feedRoomLocked(); break;
                }
                break;
            case "feedRoomLocked":
                switch(choiceMade){
                    case "choice1": feedRoomNext(); break;
                }
                break;
            case "feedRoomNext":
                switch(choiceMade){
                    case "choice1": examineDoor1(); break;
                    case "choice2": examineDoor2(); break;
                    case "choice3": examineDoor3(); break;
                    case "choice4": examineDoor4(); break;
                }
                break;
            case "examineFeedRoom":
                if (weakPoison == false && strongPoison == false) {
                    if (flagMoss == false && flagMeat == false) {
                        switch(choiceMade){
                            case "choice1": examinePosterFeed(); break;
                            case "choice2": pickupMossFeed(); break;
                            case "choice3": pickupMeatFeed(); break;
                            case "choice4": waitTurn(position); break;
                        }
                        break;
                    } else if (flagMoss == true && flagMeat == false) {
                        switch(choiceMade){
                            case "choice1": examinePosterFeed(); break;
                            case "choice2": putMossPot(); break;
                            case "choice3": pickupMeatFeed(); break;
                            case "choice4": waitTurn(position); break;
                        }
                        break;
                    } else if (flagMoss == true && flagMeat == true) {
                        switch(choiceMade){
                            case "choice1": examinePosterFeed(); break;
                            case "choice2": putMossPot(); break;
                            case "choice3": putMeatPot(); break;
                            case "choice4": waitTurn(position); break;
                        }
                        break;
                    } else if (flagMoss == false && flagMeat == true){
                        switch(choiceMade){
                            case "choice1": examinePosterFeed(); break;
                            case "choice2": pickupMossFeed(); break;
                            case "choice3": putMeatPot(); break;
                            case "choice4": waitTurn(position); break;
                        }
                        break;
                    }
                } else if (weakPoison == true || strongPoison == true) {
                    switch(choiceMade){
                        case "choice1": examinePosterFeed(); break;
                        case "choice2": poisonMonsterFeed(); break;
                        case "choice3": waitTurn(position); break;
                    }
                    break;
                }
            case "poisonMonsterFeed":
                if (weakPoison == true) {
                    switch(choiceMade){
                        case "choice1": deathReset1(); break;
                    }
                    break;
                } else if (strongPoison == true) {
                    switch(choiceMade){
                        case "choice1": entrance(); break;
                    }
                    break;
                }
            case "putMossPot":
                switch(choiceMade){
                    case "choice1": examineFeedRoom(); break;
                }
                break;
            case "putMeatPot":
                switch(choiceMade){
                    case "choice1": examineFeedRoom(); break;
                }
                break;
            case "examinePosterFeed":
                switch(choiceMade){
                    case "choice1": examineFeedRoom(); break;
                    case "choice2": pickupMossFeed(); break;
                    case "choice3": pickupMeatFeed(); break;
                    case "choice4": waitTurn(position); break;
                }
                break;
            case "pickupMossFeed":
                switch(choiceMade){
                    case "choice1": examineFeedRoom(); break;
                }
                break;
            case "pickupMeatFeed":
                switch(choiceMade){
                    case "choice1": examineFeedRoom(); break;
                }
                break;
            case "examineDoor3":
                switch(choiceMade){
                    case "choice1": door3SphinxRoom(); break;
                    case "choice2": entrance(); break;
                }
                break;
            case "door3Sphinxroom":
                switch(choiceMade){
                    case "choice1": sphinxComplete(); break;
                    case "choice2": sphinxFail(); break;
                    case "choice3": sphinxFail(); break;
                    case "choice4": sphinxFail(); break;
                }
                break;          
            case "sphinxComplete":
                switch(choiceMade){
                    case "choice1": entrance(); break;
                }
                break;                        
            case "sphinxFail":
                switch(choiceMade){
                    case "choice1": deathReset1(); break;
                }
                break;
            case "deathReset1":
                switch(choiceMade){
                    case "choice1": examineDoor1(); break;
                    case "choice2": examineDoor2(); break;
                    case "choice3": examineDoor3(); break;
                    case "choice4": examineDoor4(); break;
                }
                break;
            case "examineDoor4":
                switch(choiceMade){
                    case "choice1": door4Drown(); break;
                    case "choice2": entrance(); break;
                }
                break;
            case "door4Drown":
                if (turnTracker < 1) {
                    switch(choiceMade){
                        case "choice1": readDiary(); break;
                        case "choice2": flipSwitchDrown(); break;
                        case "choice3": portholeDrown(); break;
                        case "choice4": waitTurn(position); break;
                    }
                    break;
                } else if (turnTracker <= 5) {
                    switch(choiceMade){
                        case "choice1": readDiary(); break;
                        case "choice2": flipSwitchDrown(); break;
                        case "choice3": portholeDrown(); break;
                        case "choice4": waitTurn(position); break;
                    }
                    break;
                } else if (turnTracker >= 7) {
                    switch(choiceMade){
                        case "choice1": readDiary(); break;
                        case "choice2": flipSwitchDrown(); break;
                        case "choice3": portholeDrown(); break;
                        case "choice4": waitTurn(position); break;
                    }
                    break;
                } else {
                    switch(choiceMade){
                        case "choice1": deathReset1(); break;
                    }
                    break;
                }
            case "readDiary":
                switch(choiceMade){
                    case "choice1": door4Drown(); break;
                }
                break;
            case "flipSwitchDrown":
                if (turnTracker < 5) {
                    switch(choiceMade){
                        case "choice1": door4Drown(); break;
                    }
                    break;
                } else if (turnTracker > 4 && turnTracker < 8) {
                    switch(choiceMade){
                        case "choice1": drownRoomComplete(); break;
                    }
                }
                break;
            case "portholeDrown":
                switch(choiceMade){
                    case "choice1": door4Drown(); break;
                }
                break;
            case "drownRoomComplete":
                switch(choiceMade){
                    case "choice1": entrance(); break;
                }
                break;
            case "hub2":
                switch(choiceMade) {
                    case "choice1": examineDoor5(); break;
                    case "choice2": examineDoor6(); break;
                    case "choice3": examineDoor7(); break;
                    case "choice4": examineDoor8(); break;
                }
                break;
            case "deathReset2":
                switch(choiceMade){
                    case "choice1": examineDoor5(); break;
                    case "choice2": examineDoor6(); break;
                    case "choice3": examineDoor7(); break;
                    case "choice4": examineDoor8(); break;
                }
                break;
            case "examineDoor5":
                switch(choiceMade){
                    case "choice1": door5DirtRoom(); break;
                    case "choice2": hub2(); break;
                }
                break;
            case "door5DirtRoom":
                switch(choiceMade){
                    case "choice1": examineDirtRoom(); break;
                    case "choice2": waitTurn(position); break;
                }
                break;
            case "examineDirtRoom":
                switch(choiceMade){
                    case "choice1": examineWallDirt(); break;
                    case "choice2": examineWormsDirt(); break;
                    case "choice3": digDirt(); break;
                    case "choice4": waitTurn(position); break;
                }
                break;
            case "examineWallDirt":
                if (haveShovel == false) {
                    switch(choiceMade) {
                        case "choice1": grabShovel(); break;
                        case "choice2": examineDirtRoom(); break;
                    }
                    break;
                } else if (haveShovel == true) {
                    switch(choiceMade) {
                        case "choice1": examineDirtRoom(); break;
                    }
                    break;
                }
            case "grabShovel":
                switch(choiceMade){
                    case "choice1": examineDirtRoom(); break;
                }
                break;
            case "examineWormsDirt":
                switch(choiceMade){
                    case "choice1": examineDirtRoom(); break;
                }
                break;
            case "digDirt":
                if (haveShovel == false) {
                    switch(choiceMade){
                        case "choice1": examineDirtRoom(); break;
                    }
                    break; 
                } else if (haveShovel == true){
                    switch(choiceMade){
                        case "choice1": digNorth(); break;
                        case "choice2": digEast(); break;
                        case "choice3": digSouth(); break;
                        case "choice4": digWest(); break;
                    }
                    break;
                }
            case "digNorth":
                if (digNorth == false && digEast == false && digSouth == false && digWest == false){
                    switch(choiceMade){
                        case "choice1": digNorth(); break;
                        case "choice2": digEast(); break;
                        case "choice3": digSouth(); break;
                        case "choice4": digWest(); break;
                    }
                    break;
                } else if (digNorth == true && digEast == true) {
                    switch(choiceMade){
                        case "choice1": digNorth(); break;
                        case "choice2": digEast(); break;
                        case "choice3": digSouth(); break;
                        case "choice4": digWest(); break;
                    }
                    break;
                } else if (digNorth2 == true) {
                    switch (choiceMade){
                        case "choice1": deathReset2(); break;
                    }
                    break;
                }
            case "digEast":
                if (digNorth == true && digEast == false){
                    switch(choiceMade){
                        case "choice1": digNorth(); break;
                        case "choice2": digEast(); break;
                        case "choice3": digSouth(); break;
                        case "choice4": digWest(); break;
                    }
                    break;
                } else if (digEast == true && digNorth == true){
                    switch(choiceMade){
                        case "choice1": digNorth(); break;
                    }
                    break;
                }
            case "digSouth":
                switch(choiceMade){
                    case "choice1": deathReset2(); break;
                }
                break;
            case "digWest":
                if (digNorth2 == false){
                    switch(choiceMade){
                        case "choice1": deathReset2(); break;
                    }
                    break;
                } else if (digNorth2 == true){
                    switch(choiceMade){
                        case "choice1": hub2(); break;
                    }
                    break;
                }
            case "examineDoor6":
                switch(choiceMade){
                    case "choice1": door6WindRoom(); break;
                    case "choice2": hub2(); break;
                }
                break;
            case "door6WindRoom":
                switch(choiceMade){
                    case "choice1": examineWindRoom(); break;
                    case "choice2": waitTurn(position); break;
                }
                break;
            case "examineWindRoom":
                if (haveKite == true){
                    switch(choiceMade){
                        case "choice1": holdKite(); break;
                        case "choice2": releaseKite(); break;
                    }
                    break;
                } else if (haveTwig == false && haveString == false){
                    switch(choiceMade){
                        case "choice1": examineTwigs(); break;
                        case "choice2": examineString(); break;
                        case "choice3": waitTurn(position); break;
                    }
                    break;
                } else if (haveTwig == true && haveString == false){
                    switch(choiceMade){
                        case "choice1": examineString(); break;
                        case "choice2": waitTurn(position); break;
                    }
                    break;
                } else if (haveTwig == false && haveString == true){
                    switch(choiceMade){
                        case "choice1": examineTwigs(); break;
                        case "choice2": waitTurn(position); break;
                    }
                    break;
                } else if (haveTwig == true && haveString == true) {
                    switch(choiceMade){
                        case "choice1": combineTwigString(); break;
                    }
                    break;
                }
                break;
            case "examineTwigs":
                switch(choiceMade){
                    case "choice1": examineWindRoom(); break;
                }
                break;
            case "examineString":
                switch(choiceMade){
                    case "choice1": examineWindRoom(); break;
                }
                break;
            case "combineTwigString":
                switch(choiceMade){
                    case "choice1": examineWindRoom(); break;
                }
                break;
            case "holdKite":
                switch(choiceMade){
                    case "choice1": deathReset2(); break;
                }
                break;
            case "releaseKite":
                switch(choiceMade){
                    case "choice1": flyUp(); break;
                    case "choice2": flyRight(); break;
                    case "choice3": flyDown(); break;
                    case "choice4": flyLeft(); break;
                }
                break;
            case "flyUp":
                if (flyUp == true) {
                    switch(choiceMade){
                        case "choice1": flyUp2(); break;
                    }
                    break;
                } else if (flyLeft == true && flyRight == true){
                    switch(choiceMade){
                        case "choice1": flyUp(); break;
                        case "choice2": flyRight(); break;
                        case "choice3": flyDown(); break;
                        case "choice4": flyLeft(); break;
                    }
                    break;
                } else {
                    switch(choiceMade){
                        case "choice1": deathReset2(); break;
                    }
                    break;
                }
            case "flyUp2":
                switch(choiceMade) {
                    case "choice1": hub2(); break;
                }
                break;
            case "flyRight":
                if (flyLeft == true && flyUp == false){
                    switch(choiceMade){
                        case "choice1": flyUp(); break;
                        case "choice2": flyRight(); break;
                        case "choice3": flyDown(); break;
                        case "choice4": flyLeft(); break;
                    }
                    break;
                } else if (flyLeft == false) {
                    switch(choiceMade){
                        case "choice1": deathReset2(); break;
                    }
                    break;
                }
            case "flyDown":
                switch(choiceMade){
                    case "choice1": deathReset2(); break;
                }
                break;
            case "flyLeft":
                if (flyLeft == false) {
                    switch(choiceMade){
                        case "choice1": flyUp(); break;
                        case "choice2": flyRight(); break;
                        case "choice3": flyDown(); break;
                        case "choice4": flyLeft(); break;
                    }
                    break;
                } else if (flyLeft == true){
                    switch(choiceMade){
                        case "choice1": deathReset2(); break;
                        case "choice2": flyRight(); break;
                        case "choice3": deathReset2(); break;
                        case "choice4": deathReset2(); break;
                    }
                    break;
                }
            case "examineDoor7":
                switch(choiceMade){
                    case "choice1": door7HeatRoom(); break;
                    case "choice2": hub2(); break;
                }
                break;
            case "door7HeatRoom":
                switch(choiceMade){
                    case "choice1": examineHeatRoom(); break;
                }
                break;
            case "examineHeatRoom":
                if (haveFryPan == false) {
                    switch (choiceMade){
                        case "choice1": pickupFryPan(); break;
                    }
                } else if (haveFryPan == true){
                    switch (choiceMade) {
                        case "choice1": putPanStove(); break;
                    }
                }
                if (haveWax == false) {
                    switch (choiceMade){
                        case "choice2": pickupWax(); break;
                    }
                } else if (haveWax == true){
                    switch (choiceMade){
                        case "choice2": putWaxStove(); break;
                    }
                }
                if (haveCloth == false){
                    switch (choiceMade) {
                        case "choice3": pickupCloth(); break;
                    }
                } else if (haveCloth == true){
                    switch (choiceMade){
                        case "choice3": putClothStove(); break;
                    }
                }
                switch (choiceMade){
                case "choice4": readHeatBook(); break; 
                }
                break;
            case "pickupFryPan":
                switch(choiceMade){
                    case "choice1": examineHeatRoom(); break;
                }
                break;
            case "putPanStove":
                switch(choiceMade){
                    case "choice1": examineHeatRoom(); break;
                }
                break;
            case "pickupWax":
                switch(choiceMade){
                    case "choice1": examineHeatRoom(); break;
                }
                break;
            case "putWaxStove":
                if (panStove == false) {
                    switch (choiceMade){
                        case "choice1": examineHeatRoom(); break;
                    }
                } else if (panStove == true) {
                    switch (choiceMade){
                        case "choice1": examineHeatRoom(); break;
                    }
                }
                break;
            case "pickupCloth":
                switch(choiceMade){
                    case "choice1": examineHeatRoom(); break;
                }
                break;
            case "putClothStove":
                if (panStove == false) {
                    switch (choiceMade){
                        case "choice1": examineHeatRoom(); break;
                    }
                } else if (panStove == true && waxStove == false) {
                    switch (choiceMade){
                        case "choice1": examineHeatRoom(); break;
                    }
                } else if (panStove == true && waxStove == true) {
                    switch (choiceMade){
                        case "choice1": heatRoomFinish(); break;
                    }
                }
                break;
            case "readHeatBook":
                switch (choiceMade){
                    case "choice1": examineHeatRoom(); break;
                }
                break;
            case "heatRoomFinish":
                switch (choiceMade){
                    case "choice1": hub2(); break;
                }
                break;
            case "examineDoor8":
                if (heatRoomComplete == false || digRoomComplete == false || windRoomComplete == false){
                    switch (choiceMade) {
                        case "choice1": door8Locked(); break;
                    }
                } else {
                    switch (choiceMade){
                        case "choice1": door8(); break;
                    }
                }
                break;
            case "door8Locked":
                switch (choiceMade){
                    case "choice1": hub2(); break;
                }
                break;
            case "Door8":
                switch (choiceMade){
                    case "choice1": deathReset2(); break;
                    case "choice2": deathReset2(); break;
                    case "choice3": gameComplete(); break;
                    case "choice4": deathReset2(); break;
                }
                break;
            case "gameComplete":
                switch(choiceMade){
                    case "choice1": break;
                    case "choice2": break;
                    case "choice3": break;
                    case "choice4": break;
                }
            case "waitTurn":
                switch(choiceMade){
                    case "choice1": break;
                }
                break;
            }
        }
    }
}