package items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DieRollerTests {
    @Test
    public void TestSingleDie() {
        DieRoller roller = new DieRoller(1, 4);

        for (int i = 0; i < 500; i++) {
            int roll = roller.Roll();
            assertTrue(roll >= 1);
            assertTrue(roll <= 4);
        }
    }

    @Test
    public void TestMultipleDice() {
        DieRoller roller = new DieRoller(2, 6);

        for (int i = 0; i < 500; i++) {
            int roll = roller.Roll();
            assertTrue(roll >= 2);
            assertTrue(roll <= 12);
        }
    }

    @Test
    public void TestModifier() {
        DieRoller roller = new DieRoller(2, 8, -2);

        for (int i = 0; i < 500; i++) {
            int roll = roller.Roll();
            assertTrue(roll >= 0);
            assertTrue(roll <= 14);
        }
    }
}
