package character;

import java.util.Random;

public class Dice {
    private int count;
    private int sides;
    private int mod;

    public Dice(int count, int sides, int mod) {
        this.count = count;
        this.sides = sides;
        this.mod = mod;
    }

    public int Roll() {
        int result = 0;

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            result += result += random.nextInt(1, sides + 1);
        }

        result += mod;

        return result;
    }
}
