public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy (String name, String description, int health, Weapon weapon){
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString(){
        return description;
    }
}
