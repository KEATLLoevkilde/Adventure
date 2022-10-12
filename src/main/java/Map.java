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
    private Enemy troll = null;
    private Enemy cowboy = null;

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

        troll = new Enemy("Troll", "A big ugly troll", 200, null);
        addMeleeWeapon(troll, "Hammer", "A huge hammer", 50 );

        cowboy = new Enemy("Cowboy", "An evil looking cowboy in black", 100, null);
        addRangedWeapon(cowboy, "Revolver", "A black revolver", 25, 6);

        addEnemy(room1, troll);
        addEnemy(room1, cowboy);

        setDirection(room1, null, room4, room2, null);
        setDirection(room2, null, null, room3, room1);
        setDirection(room3, null, room6, null, room2);
        setDirection(room4, room1, room7, null, null);
        setDirection(room5, null, room8, null, null);
        setDirection(room6, room3, room9, null, null);
        setDirection(room7, room4, null, room8, null);
        setDirection(room8, room5, null, room9, room7);
        setDirection(room9, room6, null, null, room8);

        addItem(room1, "Flashlight", "A blue plastic flashlight.");
        addItem(room2, "Bucket", "A rusty old metal bucket.");
        addItem(room3, "Mirror", "A small mirror.");
        addItem(room4, "Fork", "A silver fork.");
        addItem(room5, "Crank", "A heavy metal crank.");
        addItem(room6, "Note", "A piece of paper, with a note on it.");
        addItem(room7, "Cup", "A paper cup.");
        addItem(room8, "Umbrella", "An umbrella.");
        addItem(room9, "Ballpen", "A black plastic ballpen.");

        addFood(room1, "Apple", "A red delicious apple", 50);
        addFood(room9, "Poison", "A bottle of poison", -30);
        addFood(room2, "Poison", "A bottle of poison", -30);

        addRangedWeapon(room1, "Shotgun", "An old double barreled shotgun", 100, 2);
        addMeleeWeapon(room1, "Dagger", "A shiny antique dagger", 10);
    }

    public Room getRoom1() {
        return room1;
    }

    private void setDirection(Room room, Room north, Room south, Room east, Room west){
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }
    //Add methods
    private void addItem(Room room, String itemName, String description){
        room.addItem(new Item(itemName, description));
    }
    private void addFood(Room room, String itemName, String description, int healthPoint){
        room.addItem(new Food(itemName, description, healthPoint));
    }

    private void addRangedWeapon(Room room, String name, String description, int damage, int uses){
        room.addItem(new RangedWeapon(name, description, damage, uses));
    }
    private void addRangedWeapon(Enemy enemy, String name, String description, int damage, int uses){
        enemy.setWeapon(new RangedWeapon(name, description, damage, uses));
    }
    private void addMeleeWeapon(Room room, String name, String description, int damage){
        room.addItem(new MeleeWeapon(name, description, damage));
    }

    private void addMeleeWeapon(Enemy enemy, String name, String description, int damage){
        enemy.setWeapon(new MeleeWeapon(name, description, damage));
    }

    private void addEnemy(Room room, Enemy enemy){
        room.addEnemy(enemy);
    }

}
