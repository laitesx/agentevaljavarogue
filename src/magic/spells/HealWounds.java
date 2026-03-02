package magic.spells;

import magic.utils.Roller;

public class HealWounds {
    private String name = "Heal Wounds";
    private String description = "Heal Wounds";

    private Roller roller = new Roller(2, 6, 2);

    public int roll() { return roller.Roll(); }
}
