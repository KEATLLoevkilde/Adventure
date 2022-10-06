public class RangedWeapon extends Weapon{
    private int uses;

    public RangedWeapon(String name, String description, int damage, int uses){
        super(name, description, damage);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
