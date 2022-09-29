import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;


    public Player(){
        currentRoom = new Room(null, null);
        inventory = new ArrayList<Item>();
    }

    //Room metoder
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newCurrentRoom) {
        this.currentRoom = newCurrentRoom;
    }

    //Item metoder
    public void addItemToInventory(Item item){
        inventory.add(item);
    }

    public Item searchItemInInventory(String item){
        for (Item s: inventory) {
            if(s.getName().equals(item))
                return s;
        }
        return null;
    }

    public ArrayList<Item> printInventory() {
        return inventory;
    }

    public void deleteItemFromInventory(Item item){
        int index = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) == item){
                index = i;
            }
        }
        inventory.remove(index);
    }
}
