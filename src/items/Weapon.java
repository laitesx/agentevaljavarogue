package items;

import utils.DamageType;

public class Weapon {
    private int hands;

    private String name;
    private String description;

    private DamageType damageType;

    private DieRoller damage;

    public Weapon(int hands, String name, String description, DamageType damageType, DieRoller damage) {
        this.hands = hands;

        this.name = name;
        this.description = description;

        this.damageType = damageType;

        this.damage = damage;
    }

    public int getHands() { return hands; }

    public int rollDamage() { return damage.Roll(); }
}
