import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(){
        currentRoom = new Room(null, null);
        inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newCurrentRoom) {
        this.currentRoom = newCurrentRoom;
    }

    public boolean go(String direction){
        boolean goingInDirection = false;
        Room newCurrentRoom = null;
        switch (direction){
            case "north", "n"-> {
                if(currentRoom.getNorth() != null){
                    newCurrentRoom = currentRoom.getNorth();
                }
            }
            case "south", "s" -> {
                if(currentRoom.getSouth() != null){
                    newCurrentRoom = currentRoom.getSouth();
                }
            }
            case "east", "e" -> {
                if(currentRoom.getEast() != null){
                    newCurrentRoom = currentRoom.getEast();
                }
            }
            case "west", "w" -> {
                if(currentRoom.getWest() != null){
                    newCurrentRoom = currentRoom.getWest();
                }
            }
        }
        if(newCurrentRoom != null){
            setCurrentRoom(newCurrentRoom);
            goingInDirection = true;
        }
        return goingInDirection;
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

    public Item searchItemInInventory(String itemName){
        for (Item s: inventory) {
            if(s.getName().toLowerCase().equals(itemName))
                return s;
        }
        return null;
    }

    public String printInventory() {
        String str = "";
            if(inventory.isEmpty()){
                str += "Inventory is empty.";
            } else {
                str += "Inventory:";
                for (Item i: inventory) {
                    str += '\n' + i.getDescription();
                }
            }
            return str;
    }

    public void removeItemFromInventory(Item item){
        int index = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) == item){
                index = i;
            }
        }
        inventory.remove(index);
    }
    public boolean takeItem(String itemName){
        boolean takeItem = false;
        Item requiredItem = currentRoom.searchItem(itemName);
        if(requiredItem != null){
            addItemToInventory(requiredItem);
            currentRoom.removeItemFromRoom(requiredItem);
            takeItem = true;
        }
        return takeItem;
    }

    public boolean dropItem(String itemName){
        boolean dropItem = false;
        Item requiredItem = searchItemInInventory(itemName);
        if(requiredItem != null){
            getCurrentRoom().addItem(requiredItem);
            removeItemFromInventory(requiredItem);
            dropItem = true;
        }
        return dropItem;
    }
}
