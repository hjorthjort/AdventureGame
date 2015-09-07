/**
 * @author hjorthjort
 */ //These are the different rooms in the game
class Room {
    //Is true if the treasure is in this room
    boolean hasTreasure;

    //The healing potion of this room.
    HealingPotion healingPotion;

    Room() {
        healingPotion = new HealingPotion();
    }

    void enterPlayer(Player player) {
        Monster monster = new Monster();
        Dice dice = new Dice(6);
        if (dice.rollDice() <= 2) {
            player.hit(monster);
        }
        if (dice.rollDice() >= 4) {
            player.heal(healingPotion);
        }
    }
}
