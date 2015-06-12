import java.util.*;

/**
 * @author hjorthjort
 */
public class AdventureGame {
    Map theMap;
    Player thePlayer;

    void play() {
        thePlayer = new Player("Hero");
        theMap = new Map(thePlayer);

        print("Welcome to the adventure game!");

        printInstructions();
        char input = getNextLine();

        while (input != 'q') {

            if (input == 'f') theMap.goForward();
            if (input == 'b') theMap.goBackward();
            if (input == 'q') System.exit(0);

            printInstructions();
            input = getNextLine();
        }
    }

    private void print(String s) {
        System.out.println(s);
    }

    void printInstructions() {
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


