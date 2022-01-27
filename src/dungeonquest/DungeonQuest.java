package dungeonquest;

/**
 *
 * @author jvira
 */
public class DungeonQuest {

    public static void main(String[] args) {
        
        Room entrance = new Room("Dungeon Entrance", // Room Name
                          "This is the Entrance to the dungeon! You notice 4 doors ahead of you.", // Room Description
                          "1", // Room Door Number
                          "This is the door to the Fire Room", // Room Door Description
                          "You awaken at the entrance to the dungeon."); // Death State 
    }
    
}
