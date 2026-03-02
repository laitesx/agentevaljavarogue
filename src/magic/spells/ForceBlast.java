package magic.spells;

import magic.utils.Roller;

import utils.DamageType;

public class ForceBlast {
    private String name = "Force Blast";
    private String description = "Force Blast";

    private DamageType damageType = DamageType.FORCE;

    private Roller damage = new Roller(2, 4, 1);

    public int roll() { return damage.Roll(); }
}
