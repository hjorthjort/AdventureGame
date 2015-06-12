import java.util.Random;

/**
 * @author hjorthjort
 */ //This is dice which you can create. They roll up to
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
