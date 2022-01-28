package dungeonquest;

import java.util.*;

/**
 *
 * @author jvira
 */
public class DungeonQuest {
    public static void main(String[] args) {
        // Set up Dungeon Entrance room
        Room entrance = new Room("Dungeon Entrance", // Room Name
                          "This is the Entrance to the dungeon! You notice 4 doors ahead of you.", // Room Description
                          "0", // Room Door Number
                          "This is the door to the Fire Room", // Room Door Description
                          "You awaken at the entrance to the dungeon."); // Death State 
    
        // Set up TestRoom 1
        Room testRoom1 = new Room("Test Room 1", // Test Room
                            "This is a test room beyond the entrance of the dungeon.", // Room Desc
                            "1", // Room Door Number
                            "This is room number 1.", // Room Door Description
                            "You died in room 1!"); // Death State
        
        // Set up TestRoom 2
        Room testRoom2 = new Room("Test Room 2", // Test Room
                            "This is a test room beyond the entrance of the dungeon.", // Room Desc
                            "2", // Room Door Number
                            "This is room number 2.", // Room Door Description
                            "You died in room 2!"); // Death State
        
        // Set up TestRoom 3
        Room testRoom3 = new Room("Test Room 3", // Test Room
                            "This is a test room beyond the entrance of the dungeon.", // Room Desc
                            "3", // Room Door Number
                            "This is room number 3.", // Room Door Description
                            "You died in room 3!"); // Death State
        
        // Set up TestRoom 4
        Room testRoom4 = new Room("Test Room 4", // Test Room
                            "This is a test room beyond the entrance of the dungeon.", // Room Desc
                            "4", // Room Door Number
                            "This is room number 4.", // Room Door Description
                            "You died in room 4!"); // Death State
        
        
        // Boolean value for game state
        boolean running = true;
        
        /* Loop Label and while loop for most game functions.
            THIS IS ENTIRELY A TEST, I HAVE NO IDEA HOW THIS WILL FUNCTION WITH JAVAFX
            MAY NOT USE THIS CODE AT ALL -JV
        */
        GAME:
        while(running) {
        System.out.println("**********************************");
        System.out.println("Welcome to the dungeon Sir Wizard!");
        System.out.println("**********************************");
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println();
        
        System.out.println("You enter the dungeon yadadadada pick a room!");
        System.out.println("1. " + testRoom1.getRoomName() + " " + testRoom1.getRoomDoorDesc());
        System.out.println("2. " + testRoom2.getRoomName() + " " + testRoom2.getRoomDoorDesc());
        System.out.println("3. " + testRoom3.getRoomName() + " " + testRoom3.getRoomDoorDesc());
        System.out.println("4. " + testRoom4.getRoomName() + " " + testRoom4.getRoomDoorDesc());
        
        String input = keyboard.nextLine();
        
            if (input.equals("1")) {
                System.out.println("You enter " + testRoom1.getRoomName());
                playRoom1();
            } 
            else if (input.equals("2")) {
                System.out.println("You enter " + testRoom2.getRoomName());
            }
            else if (input.equals("3")) {
                System.out.println("You enter " + testRoom3.getRoomName());
            }
            else if (input.equals("4")) {
                System.out.println("You enter " + testRoom4.getRoomName());
            }
            else {
                System.out.println("That door does not exist!");
                System.out.println("1. " + testRoom1.getRoomName() + " " + testRoom1.getRoomDoorDesc());
                System.out.println("2. " + testRoom2.getRoomName() + " " + testRoom2.getRoomDoorDesc());
                System.out.println("3. " + testRoom3.getRoomName() + " " + testRoom3.getRoomDoorDesc());
                System.out.println("4. " + testRoom4.getRoomName() + " " + testRoom4.getRoomDoorDesc());
            }
            break;
        }
    }
    
    public static void playRoom1() {
        Scanner keyboard = new Scanner(System.in);
        Item goldenKey = new Item("Golden Key", "A key shimmering in gold");
        System.out.println("In front of you lays a golden key what do you do?");
        System.out.println("1. Grab the key.");
        System.out.println("2. Exit the room.");

        String input = keyboard.nextLine();
        if (input.equals("1")) {
            System.out.println("You've grabbed the key!");
            System.out.println("Would you like to examine the key?");
            System.out.println("\t1. Yes\n\t2. No");
            input = keyboard.nextLine();
            if (input.equals("1")) {
                goldenKey.getItemDesc();
            }
        }
        else if (input.equals("2")) {
            System.out.println("You leave the room.");
        }
    }
}
