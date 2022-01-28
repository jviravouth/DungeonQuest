package dungeonquest;

import java.util.Hashtable;

public class Item {
    Hashtable<String, String> itemDict = new Hashtable<String, String>();
    private String itemName;
    private String itemDesc;
    
    
    public Item(String name, String desc) {
        itemName = name;
        itemDesc = desc;
        itemDict.put(this.itemName, this.itemDesc);
    }
    
    public void getItem() {
        System.out.println(itemDesc);
    }
    
    public void getItemDesc() {
        System.out.println(itemDesc);
    }

}
