/**
 * @author hjorthjort
 */ //This is the player
class Player {
    String name;
    int healthPoints;

    Player(String playerName) {
        name = playerName;
        healthPoints = 100;
    }

    int getHealthPoints() {
        return healthPoints;
    }

    void hit(Monster monster) {
        int damage = monster.getDamage();
        healthPoints = healthPoints - damage;
        System.out.println("MONSTER!");
        sleep();
        System.out.println(
                "I" +
                        " " +
                        "killed " +
                        "the " +
                        "monster, but I was hit! " +
                        "I took " + damage + " damage." + System.lineSeparator());
        sleep();
        if (healthPoints <=0 ) {
            System.out.println("I DIED! Game Over :(" + System.lineSeparator());
            System.exit(0);
        }
    }

    void heal(HealingPotion potion) {
        int pointsToHeal = potion.getHealingPower();
        healthPoints = healthPoints + pointsToHeal;
        System.out.println("HEALING POTION!");
        sleep();
        System.out.println("Hooray! I " +
                "was" +
                " " +
                "healed! " +
                "I gained " + pointsToHeal + " health." + System.lineSeparator
                ());
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException i)  {}
    }
}
