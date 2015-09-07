/**
 * @author hjorthjort
 */ //These are the monsters in the rooms
class Monster {
    int damage;

    Monster() {
        Dice dice = new Dice(30);
        damage = dice.rollDice();
    }

    public int getDamage() {
        return damage;
    }
}
