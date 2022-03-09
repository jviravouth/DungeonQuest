package dungeonquest;

import java.util.*;


public class Room {
    // Variables
    private String roomName;
    private String roomDescription;
    private String roomDeathState;
    private String roomDoorNumber;
    private String roomDoorDesc;
    private int turnNumber = 0;
    static Hashtable<String, String> itemDict = new Hashtable<String, String>();
    
    
    // Constructor
    public Room (String name, String desc, String door, String doorDesc, String deathState) {
        roomName = name;
        roomDescription = desc;
        roomDoorNumber = door;
        roomDeathState = deathState;
        roomDoorDesc = doorDesc;
    }
    
    // Add object to objectDict
    public void addObject(String itemName, String itemDesc) {
        itemDict.put(itemName, itemDesc);
    }
    
    // Remove object from itemDict
    public void removeObject(String itemName) {
        itemDict.remove(itemName);
    }
    
    // Method to return itemDict
    public void returnObjectDict (String objectNum) {
        System.out.println(itemDict.get(objectNum));
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

    public String getRoomDoorNumber() {
        String str = roomDoorNumber;
        return str;
    }

    public String getRoomDoorDesc() {
        String str = roomDoorDesc;
        return str;
    }
    
    
}
