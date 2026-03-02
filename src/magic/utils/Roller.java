package magic.utils;

import java.util.Random;

public class Roller {
    private int dice;
    private int sides;
    private int modifier;

    public Roller(int dice, int sides, int modifier) {
        this.dice = dice;
        this.sides = sides;
        this.modifier = modifier;
    }

    public int Roll() {
        int result = modifier;

        Random random = new Random();

        for (int i = 0; i < dice; i++) {
            result += random.nextInt(1, sides + 1);
        }

        return result;
    }
}
