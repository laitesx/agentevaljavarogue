package items;

import java.util.Random;

public class DieRoller {
    private int dice;
    private int sides;
    private int modifier;

    public DieRoller(int dice, int sides) {
        this.dice = dice;
        this.sides = sides;
        this.modifier = 0;
    }

    public DieRoller(int dice, int sides, int modifier) {
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
