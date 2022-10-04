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

    public void createMap(){
        room1 = new Room("Library", "Lots of books");
        room2 = new Room("Office 1", "A pleasant smell of coffee");
        room3 = new Room("Toilet", "An unpleasant smell");
        room4 = new Room("Dining Hall", "No food yet");
        room5 = new Room("Machine Room", "Noisy, but cool!");
        room6 = new Room("Office 2", "A silent programmer sitting in the corner");
        room7 = new Room("Yard", "Birds are singing");
        room8 = new Room("Entrance Hall", "Wide and empty. Exept for an umbrella rack.");
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

        addItemToRoom(room1, "Flashlight", "A blue plastic flashlight.");
        addItemToRoom(room2, "Bucket", "A rusty old metal bucket.");
        addItemToRoom(room3, "Mirror", "A small mirror.");
        addItemToRoom(room4, "Fork", "A silver fork.");
        addItemToRoom(room5, "Crank", "A heavy metal crank.");
        addItemToRoom(room6, "Note", "A piece of paper, with a note on it.");
        addItemToRoom(room7, "Cup", "A paper cup.");
        addItemToRoom(room8, "Umbrella", "An umbrella.");
        addItemToRoom(room9, "Ballpen", "A black plastic ballpen.");

        addFoodToRoom(room1, "Apple", "A red delicious apple", 50);
    }

    public Room getRoom1() {
        return room1;
    }

    public void addItemToRoom(Room room, String itemName, String description){
        room.addItem(new Item(itemName, description));
    }
    public void addFoodToRoom(Room room, String itemName, String description, int healthPoint){
        room.addItem(new Food(itemName, description, healthPoint));
    }

    public void setDirection(Room room, Room north, Room south, Room east, Room west){
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

}
