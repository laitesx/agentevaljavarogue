package magic.spells;

import magic.utils.Roller;

import utils.DamageType;

public class FireBolt {
    private String name = "Fire Bolt";
    private String description = "Fire Bolt";

    private DamageType damageType = DamageType.FIRE;

    private Roller roller = new Roller(1, 8, 0);

    public int rollDamage() { return roller.Roll(); }
}
