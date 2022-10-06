import java.sql.SQLOutput;
import java.util.Scanner;
public class UserInterface {
    private Adventure adventure;
    private Scanner sc;

    public UserInterface(){
        adventure = new Adventure();
        sc = new Scanner(System.in);
    }
    public void start(){
        System.out.println(adventure.getCurrentRoom());
        handleInput();
    }
    public void handleInput(){
        while (true) {
            System.out.println("\nWhat do you want to do?");
            String action = sc.nextLine().toLowerCase();
            String[] command = action.split(" ");

            switch (command[0]) {
                case "go" ->{
                    boolean goingInDirection = adventure.go(command[1]);
                    if(goingInDirection) {
                        System.out.println(adventure.getCurrentRoom());
                    } else {
                        System.out.println("You can't go that way!");
                    }
                }
                case "take" -> {
                    boolean itemTaken = adventure.takeItem(command[1]);
                    if (itemTaken) {
                        System.out.println("You've taken the " + command[1]);
                     } else {
                        System.out.println(command[1] + " couldn't be found in this room");
                    }
                }

                case "drop" -> {
                    boolean itemDropped = adventure.dropItem(command[1]);
                    if (itemDropped){
                        System.out.println("you dropped the " + command[1]);
                    }else {
                        System.out.println(command[1] + " is not in your inventory.");
                    }
                }

                case "inventory", "inv" -> {
                    boolean weaponEquipped = adventure.weaponEquipped();
                    if(weaponEquipped){
                        System.out.println(adventure.printInventory());
                        System.out.println("\nEquipped weapon: " + adventure.getEquippedWeapon());
                    }else{
                        System.out.println(adventure.printInventory());
                        System.out.println("\nNo weapon equipped.");
                    }

                }
                case "health" -> System.out.println(adventure.printPlayerHealth());
                case "eat", "drink" -> {
                    ReturnMessage message = adventure.eatItem(command[1]);
                    switch (message){
                        case COULD_NOT_BE_FOUND -> System.out.println(command[1] + " is not in your inventory.");
                        case CAN_NOT_BE_EATEN -> System.out.println(command[1] + " can not be eaten");
                        case EATEN -> System.out.println(command[1] + " eaten");
                    }
                }
                case "equip" -> {
                    ReturnMessage message = adventure.equipWeapon(command[1]);
                    switch (message){
                        case COULD_NOT_BE_FOUND -> System.out.println(command[1] + " is not in your inventory.");
                        case IS_NOT_A_WEAPON -> System.out.println(command[1] + " is not a weapon");
                        case EQUIPPED -> System.out.println(command[1] + " equipped");
                    }
                }
                case "look" -> System.out.println(adventure.getCurrentRoom());
                case "help" -> System.out.println("""
                                                
                                                COMMANDS:
                                                Go: Will let you go in the following direction if possible:
                                                    north, south, east, west (or: n, s, e, w )
                                                                                            
                                                Look: Display the contents of the room if possible.                                                    
                                                    
                                                Take: Takes an item from the room and puts it in the player inventory.                                                    
                                                    
                                                Drop: Takes an item from the player inventory and puts it in the room.                                                    
                                                    
                                                Inventory (inv): Display the contents of the player inventory. 
                                                
                                                Health: Display player health. 
                                                
                                                Eat / Drink: Eat or drink food from your inventory to gain or lose health points. 
                                                
                                                Equip: Equip a weapon from your inventory.                                                 
                                                 
                                                Exit: Ends the game.                                                  
                                                
                                                """);


                case "exit" -> System.exit(0);
                default-> System.out.println("Invalid request, try again.");
            }
        }
    }

}
