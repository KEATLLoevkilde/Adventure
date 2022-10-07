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
    @Override
    public ReturnMessage use(){
        ReturnMessage message;
        if(uses > 0){
            message = ReturnMessage.ENEMY_ATTACKED;
            uses --;
        } else {
            message = ReturnMessage.WEAPON_OUT_OF_AMMO;
        }
        return message;
    }

    @Override
    public String toString(){
        return super.toString() + " - Shots left: " + uses;
    }
}
