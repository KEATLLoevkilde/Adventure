public class Item {
    private String name;
    private String description;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Item(Item source){
        this.name = source.name;
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
