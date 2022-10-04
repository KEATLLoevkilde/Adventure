import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north = null;
    private Room south = null;
    private Room east = null;
    private Room west = null;
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
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

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
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == item){
                index = i;
            }
        }
        items.remove(index);
    }

    public String toString() {
        String str = "";
        str += "You are in the " + name + '\n';
        str += description + '\n';
        if(!items.isEmpty()){
            for (Item i: items) {
                str += "There is " + i.getDescription() + '\n';
            }
        } else {
            str += "Nothing else of interest in here.";
        }
        return str;
    }
}
