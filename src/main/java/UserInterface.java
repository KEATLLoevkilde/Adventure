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
        while (true) {
            System.out.println("\nWhat do you want to do?");
            String[] command = handleInput();

            switch (command[0]) {
                case "go" -> go(command);
                case "take" -> take(command);
                case "drop" -> drop(command);
                case "inventory", "inv" -> inventory();
                case "health" -> health();
                case "eat", "drink" -> eatDrink(command);
                case "equip" -> equip(command);
                case "attack" -> attack(command);
                case "look" -> look();
                case "help" -> help();
                case "exit" -> System.exit(0);
                default-> System.out.println("Invalid request, try again.");
            }
        }
    }

    private void equip(String[] command) {
        if(command.length > 1){
            ReturnMessage message = adventure.equipWeapon(command[1]);
            switch (message){
                case COULD_NOT_BE_FOUND -> System.out.println(command[1] + " is not in your inventory.");
                case IS_NOT_A_WEAPON -> System.out.println(command[1] + " is not a weapon");
                case EQUIPPED -> System.out.println(command[1] + " equipped");
            }
        }else {
            System.out.println("You did not indicate the weapon to " + command[0]);
        }
    }

    private String[] handleInput(){
        String action = sc.nextLine().toLowerCase();
        String[] command = action.split(" ");
        return command;
    }
    private String capFirst(String str){
        String capFirst = str.substring(0, 1).toUpperCase() + str.substring(1);
        return capFirst;
    }

    private void go(String[] command){
        if(command.length > 1){
            boolean goingInDirection = adventure.go(command[1]);
            if(goingInDirection) {
                System.out.println(adventure.getCurrentRoom());
            } else {
                System.out.println("You can't go that way!");
            }
        } else {
            System.out.println("You did not indicate the direction to " + command[0]);
        }
    }

    private void take(String[] command){
        if(command.length > 1){
            boolean itemTaken = adventure.takeItem(command[1]);
            if (itemTaken) {
                System.out.println("You've taken the " + command[1]);
            } else {
                System.out.println(capFirst(command[1]) + " couldn't be found in this room");
            }
        }else {
            System.out.println("You did not indicate the item to " + command[0]);
        }
    }

    private void drop(String[] command){
        if(command.length > 1){
            boolean itemDropped = adventure.dropItem(command[1]);
            if (itemDropped){
                System.out.println("you dropped the " + command[1]);
            }else {
                System.out.println(capFirst(command[1]) + " is not in your inventory.");
            }
        }else {
            System.out.println("You did not indicate the item to " + command[0]);
        }
    }

    private void inventory(){
            boolean weaponEquipped = adventure.weaponEquipped();
            if(weaponEquipped){
                System.out.println(adventure.printInventory());
                System.out.println("\nEquipped weapon: " + adventure.getEquippedWeapon());
            }else{
                System.out.println(adventure.printInventory());
                System.out.println("\nNo weapon equipped.");
            }
    }

    private void health(){
        System.out.println(adventure.printPlayerHealth());
    }
    private void eatDrink(String[] command){
        if(command.length > 1){
            ReturnMessage message = adventure.eatItem(command[1]);
            switch (message){
                case COULD_NOT_BE_FOUND -> System.out.println(capFirst(command[1]) + " is not in your inventory.");
                case CAN_NOT_BE_EATEN -> System.out.println(capFirst(command[1]) + " can not be eaten");
                case EATEN -> System.out.println(capFirst(command[1]) + " eaten");
            }
        }else {
            System.out.println("You did not indicate the item to " + command[0]);
        }
    }

    private void attack(String[] command){
        if(command.length > 1) {
            ReturnMessage message = adventure.attack(command[1]);
            switch(message){
                case NO_WEAPON_EQUIPPED -> System.out.println("You can not attack without a weapon equipped");
                case NO_ENEMY_FOUND_BY_THAT_NAME -> System.out.println("No enemy like " + command[1] + " in the room");
                case PLAYER_WEAPON_OUT_OF_AMMO -> System.out.println("You are out of ammo.");
                case ENEMY_WEAPON_OUT_OF_AMMO -> System.out.println("Enemy is out of ammo");
                case ENEMY_KILLED -> System.out.println("Enemy killed");
                case PLAYER_ATTACKED -> {
                    System.out.println("You survived, but so did the " + command[1]);
                    System.out.println("Player health: " + adventure.getPlayerHealth());
                    System.out.println(capFirst(command[1]) + " health: " + adventure.getCurrentEnemyHealth());
                }
                case PLAYER_DIED -> {
                    System.out.println("GAME OVER\nYou were killed by the " + command[1]);
                    System.exit(0);
                }
            }
        }else {
            System.out.println("You did not indicate the enemy to " + command[0]);
        }
    }

    private void look(){
        System.out.println(adventure.getCurrentRoom());
    }

    private void help(){
        System.out.println("""
                                                
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
                                                
                                                Attack: Attack enemy with equipped weapon. Enemy will make counter attack if still alive.                                          
                                                 
                                                Exit: Ends the game.                                                  
                                                
                                                """);
    }

}
