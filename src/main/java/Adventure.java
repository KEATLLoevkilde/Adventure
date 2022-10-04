import java.util.ArrayList;

public class Adventure {
    private Map map;
    private Player player;

    public Adventure(){
        map = new Map();
        map.createMap();
        player = new Player();
        player.setCurrentRoom(map.getRoom1());
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    public ArrayList<Item> printInventory(){
        return player.printInventory();
    }

    //Go methods
    public boolean goNorth(){
        return player.goNorth();
    }

    public boolean goSouth(){
        return player.goSouth();
    }

    public boolean goEast(){
        return player.goEast();
    }

    public boolean goWest(){
        return player.goWest();
    }

    // TODO: 04-10-2022 Take-methods
    // TODO: 04-10-2022 Drop-methods

}
