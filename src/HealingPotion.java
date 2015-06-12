/**
 * @author hjorthjort
 */ //These are the healing potions in the rooms
class HealingPotion {
    private int healingPower;

    HealingPotion() {
        Dice dice = new Dice(5);
        healingPower = dice.rollDice();
    }

    int getHealingPower() {
        return healingPower;
    }
}
