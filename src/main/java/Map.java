public class Map {
    private Room room1 = null;
    private Room room2 = null;
    private Room room3 = null;
    private Room room4 = null;
    private Room room5 = null;
    private Room room6 = null;
    private Room room7 = null;
    private Room room8 = null;
    private Room room9 = null;

    public Room getRoom1() {
        return room1;
    }

    public void createMap(){
        room1 = new Room("Library", "Lots of books");
        room2 = new Room("Office 1", "A pleasant smell of coffee");
        room3 = new Room("Toilet", "An unpleasant smell");
        room4 = new Room("Dining Hall", "No food yet");
        room5 = new Room("Machine Room", "Noisy, but cool!");
        room6 = new Room("Office 2", "A silent programmer sitting in the corner");
        room7 = new Room("Yard", "Birds are singing");
        room8 = new Room("Entrance Hall", "Wide and empty");
        room9 = new Room("Reception", "Reception desk. No one here.");

        setDirection(room1, null, room4, room2, null);
        setDirection(room2, null, null, room3, room1);
        setDirection(room3, null, room6, null, room2);
        setDirection(room4, room1, room7, null, null);
        setDirection(room5, null, room8, null, null);
        setDirection(room6, room3, room9, null, null);
        setDirection(room7, room4, null, room8, null);
        setDirection(room8, room5, null, room9, room7);
        setDirection(room9, room6, null, null, room8);

        addItemsToRoom(room1, "Flashlight", "A blue plastic flashlight.");
        addItemsToRoom(room2, "Bucket", "A rusty old metal bucket.");
        addItemsToRoom(room3, "Mirror", "A small mirror.");
        addItemsToRoom(room4, "Fork", "A silver fork.");
        addItemsToRoom(room5, "Crank", "A heavy metal crank.");
        addItemsToRoom(room6, "Note", "A piece of paper, with a note on it.");
        addItemsToRoom(room7, "Cup", "A paper cup.");
        addItemsToRoom(room8, "Umbrella", "An umbrella.");
        addItemsToRoom(room9, "Ballpen", "A black plastic ballpen.");
    }

    public void addItemsToRoom(Room room, String itemName, String description){
        room.addItem(new Item(itemName, description));
    }

    public void setDirection(Room room, Room north, Room south, Room east, Room west){
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

}
