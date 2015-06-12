import java.util.*;

/**
 * @author hjorthjort
 */
public class AdventureGame {
    public static void main(String[] args) {
        new AdventureGame().play();
    }

    Map theMap;
    Player thePlayer;

    AdventureGame() {
        thePlayer = new Player("Hero");
        theMap = new Map(thePlayer);
    }

    void play() {
        char input;
        do {
            printInstructions();
            input = getNextLine();

            if (input == 'f') theMap.goForward();
            if (input == 'b') theMap.goBackward();
            if (input == 'q') System.exit(0);

        } while (input != 'q');
    }

    private void printInstructions() {
        System.out.println("-----------");
        System.out.println("Room: " + theMap.getRoomNumber());
        System.out.println("Health: " + thePlayer.getHealthPoints());
        System.out.println("Write F to go forward, B to go backward or Q to " +
                "quit");
        System.out.print("> ");
    }

    char getNextLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next().toLowerCase().toCharArray()[0];
    }
}


//Change to use a list instead
class Map {
    List<Room> rooms;
    Player player;
    int location;
    int treasureLocation;

    Map(Player aPlayer) {
        player = aPlayer;
        rooms = new LinkedList<Room>();
        rooms.add(new Room());
        location = 0;
        treasureLocation = 10 + new Dice(30).rollDice();
    }

    int getRoomNumber() {
        return location + 1;
    }

    void goForward() {
        if (location == treasureLocation) {
            System.out.println("I found the treasure! I WIN!");
            System.exit(0);
        }
        rooms.get(location).enterPlayer(player);
        location++;
        if (rooms.size() == location)
            rooms.add(new Room());
    }

    void goBackward() {
        if (location > 0) {
            location--;
            rooms.get(location).enterPlayer(player);
        }
    }

}

//These are the different rooms in the game
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
            player.hit(monster.damage);
        }
        if (dice.rollDice() >= 4) {
            player.heal(healingPotion.getHealingPower());
        }
    }
}


//These are the monsters in the rooms
class Monster {
    int damage;

    Monster() {
        Dice dice = new Dice(30);
        damage = dice.rollDice();
    }
}


//These are the healing potions in the rooms
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


//This is the player
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

    void hit(int damage) {
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

    void heal(int pointsToHeal) {
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

//This is dice which you can create. They roll up to
class Dice {
    int maxNumber;

    Dice(int max) {
        maxNumber = max;
    }
    int rollDice() {
        int roll = new Random().nextInt(maxNumber) + 1;
        return roll;
    }
}