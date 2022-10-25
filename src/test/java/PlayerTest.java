import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    Room room;

    @BeforeEach
    public void setup(){
        player = new Player();
        room = new Room("Library", "Lots of books");
        room.addItem(new MeleeWeapon("Hammer", "A huge hammer", 50));
        player.setCurrentRoom(room);
    }
    @Test
    public void takeItemInRoom() {
        //Act
        boolean result = player.takeItem("hammer");

        //Assert
        assertTrue(result);
        Item takenItem = player.searchItemInInventory("hammer");
        assertEquals(takenItem.getName().toLowerCase(), "hammer");
        Item item = room.searchItem("hammer");
        assertNull(item);
    }

    @Test
    public void tryToTakeItemWhichIsNotInRoom() {
        //Act
        boolean result = player.takeItem("sword");

        //Assert
        assertFalse(result);
        Item takenItem = player.searchItemInInventory("sword"); // must make method public
        //assertNull(takenItem); //Maybe already in inventory?
    }
}