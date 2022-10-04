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

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    public String printInventory(){
        return player.printInventory();
    }

    public String printPlayerHealth(){
        return player.printPlayerHealth();
    }

    public boolean go(String direction){
        return player.go(direction);
    }

    public boolean takeItem(String itemName){
        return player.takeItem(itemName);
    }

    public boolean dropItem(String itemName){
        return player.dropItem(itemName);
    }
    public ReturnMessage eatItem(String itemName){
        return player.eatItem(itemName);
    }

}
