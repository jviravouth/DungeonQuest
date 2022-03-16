package dungeonquest;

import java.util.*;


public class Room {
    // Variables
    private String roomName;
    private String roomDescription;
    private String roomDeathState;
    private String roomDoorDesc;
    private String position;
    private Room[] roomLinks;
    private int turnNumber = 0;
    
    // Constructor
    public Room (String name, String desc, String doorDesc, String deathState) {
        roomName = name;
        roomDescription = desc;
        roomDeathState = deathState;
        roomDoorDesc = doorDesc; 
    }
    
    // Method to return roomDeathState description
    public String getDeathState () {
        String str = roomDeathState;
        return str;
    }

    public String getRoomName() {
        String str = roomName;
        return str;
    }

    public String getRoomDescription() {
        String str = roomDescription;
        return str;
    }

    public String getRoomDoorDesc() {
        String str = roomDoorDesc;
        return str;
    }
        
    public void createLinks(Room[] links) {
        roomLinks = links;
    }
    
    public String[] position() {
        Scanner sc = new Scanner(System.in);
        
        Room[] list = new Room[12];
        
        list[0] = new Room("Fire Room", "A Room on Fire! etc.", "Scorched by flames, this door reads #0", "The heat becomes unbearable, you could not stay in the room any longer.");
        list[1] = new Room("Mirror Room", "generic room desc", "generic door desc.", "generic death state");
        list[2] = new Room("Waterways", "generic room desc", "generic door desc.", "generic death state");
        list[3] = new Room("Earth Room", "generic room desc", "generic door desc.", "generic death state");
        list[4] = new Room("Stone Room", "generic room desc", "generic door desc.", "generic death state");
        
        list[0].createLinks(new Room[]{list[1], list[2], list[3], list[4]});
        list[1].createLinks(new Room[]{list[0], list[2], list[3], list[4]});
        list[2].createLinks(new Room[]{list[0], list[1], list[3], list[4]});
        list[3].createLinks(new Room[]{list[0], list[1], list[2], list[4]});
        list[4].createLinks(new Room[]{list[0], list[1], list[2], list[3]});
        int x = 0;
        Room walker = list[0];
        
        while(true)
        {
            x = 0;
            System.out.println("Current Room: " + walker.roomName);
            position = walker.roomName;
            System.out.println("Room Choices");
            String[] choices = new String[4];
            while(x < walker.roomLinks.length)
            {
               choices[x] = walker.roomName;
               x++;
            }
            walker = walker.roomLinks[sc.nextInt() - 1];
            System.out.println(position);
        }
    }
    
    public String getPosition() {
        return position;
    }
}
