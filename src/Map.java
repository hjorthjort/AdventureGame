import java.util.LinkedList;
import java.util.List;

/**
 * @author hjorthjort
 */ //Change to use a list instead
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
