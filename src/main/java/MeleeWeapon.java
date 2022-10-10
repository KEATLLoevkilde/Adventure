public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String name, String description, int damage){
        super(name, description, damage);
    }

    @Override
    public ReturnMessage use(){
        return ReturnMessage.WEAPON_USED;
    }
//    @Override
//    public ReturnMessage usePlayer(){
//        return ReturnMessage.ENEMY_ATTACKED;
//    }
//    @Override
//    public ReturnMessage useEnemy(){
//        return ReturnMessage.PLAYER_ATTACKED;
//    }
}
