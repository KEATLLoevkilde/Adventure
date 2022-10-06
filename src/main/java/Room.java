import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ArrayList<Item> items;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
        items = new ArrayList<Item>();
    }

    //Gettere
    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    //Settere

    public void setNorth(Room northRoom) {
        this.north = northRoom;
    }

    public void setSouth(Room southRoom) {
        this.south = southRoom;
    }

    public void setEast(Room eastRoom) {
        this.east = eastRoom;
    }

    public void setWest(Room westRoom) {
        this.west = westRoom;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item searchItem(String item){
        for (Item s: items) {
            if(s.getName().toLowerCase().equals(item))
                return s;
        }
        return null;
    }

    public void removeItemFromRoom(Item item){
        int startIndex = items.size() - 1;
        for (int i = startIndex; i >= 0 ; i--) {
            if (items.get(i) == item){
                items.remove(i);
                break;
            }
        }
    }

    public String toString() {
        String str = "";
        str += "You are in the " + name + '\n';
        str += description;
        if(items.isEmpty()){
            str += "\nNothing else of interest in here.";
        } else {
            for (Item i: items) {
                str += "\nThere is " + i.getDescription();
            }
        }
        return str;
    }
}
