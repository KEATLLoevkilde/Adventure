public class Item {
    private String name;
    private String description;
// TODO: 04-10-2022 Add health

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return description;
    }
}
