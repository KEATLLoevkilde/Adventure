import java.util.Scanner;
public class UserInterface {
    private Adventure adventure;
    private Scanner sc;

    public UserInterface(){
        adventure = new Adventure();
        sc = new Scanner(System.in);
    }
    public void start(){
        System.out.println(adventure.getPlayer().getCurrentRoom());
        handleInput();
    }
    public void handleInput(){
        while (true) {
            System.out.println("What do you want to do?");
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
                    boolean itemTaken = adventure.getPlayer().takeItem(command[1]);
                    if (itemTaken) {
                        System.out.println("You've taken " + command[1]);
                     } else {
                        System.out.println(command[1] + " couldn't be found in this room");
                    }
                }

                case "drop" -> {
                    boolean itemDropped = adventure.getPlayer().dropItem(command[1]);
                    if (itemDropped){
                        System.out.println("you dropped " + command[1]);
                    }else {
                        System.out.println(command[1] + " is not in your inventory.");
                    }
                }

                case "inventory", "inv" -> System.out.println(adventure.printInventory());

                case "look" -> System.out.println(adventure.getCurrentRoom());
                case "help" -> System.out.println("""
                                                
                                                COMMANDS:
                                                
                                                go north
                                                go south
                                                go east
                                                go west
                                                look
                                                exit
                                                
                                                """);


                case "exit" -> System.exit(0);
                default-> System.out.println("Invalid request, try again.");
            }
        }
    }

}
