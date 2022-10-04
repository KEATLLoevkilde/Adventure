public class Item {
    private String name;
    // TODO: 04-10-2022 add Item description

    public Item(String name){
        this.name = name;
    }

    public Item(Item source){
        this.name = source.name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}
