package character;

import java.util.Random;

import items.Weapon;

public class Character {
    private int strength = 10;
    private int agility = 10;
    private int toughness = 10;
    private int perception = 10;
    private int intelligence = 10;
    private int knowledge = 10;
    private int will = 10;
    private int charisma = 10;

    private int level = 1;

    private int currentHP = 1;
    private int maxHP = 1;

    private int currentMP = 1;
    private int maxMP = 1;

    private Weapon rightHand = null;
    private Weapon leftHand = null;

    private String name;
    private String description;

    private CharacterRace characterRace = null;
    private CharacterClass characterClass = null;

    public Character(String name) {
        this.name = name;
        this.description = "This is you.";
    }

    public void equipRightHandWeapon(Weapon weapon) {
        if (weapon.getHands() == 2) {
            rightHand = weapon;
            leftHand = weapon;
        }
        else {
            if (rightHand != null && rightHand.getHands() == 2) {
                rightHand = weapon;
                leftHand = null;
            }
            else if (weapon == leftHand) {
                rightHand = weapon;
                leftHand = null;
            }
            else {
                rightHand = weapon;
            }
        }
    }

    public void equipLeftHandWeapon(Weapon weapon) {
        if (weapon.getHands() == 2) {
            rightHand = weapon;
            leftHand = weapon;
        }
        else {
            if (leftHand != null && leftHand.getHands() == 2) {
                rightHand = null;
                leftHand = weapon;
            }
            else if (weapon == rightHand) {
                rightHand = null;
                leftHand = weapon;
            }
            else {
                leftHand = weapon;
            }
        }
    }

    public void unequipWeapons() {
        rightHand = null;
        leftHand = null;
    }

    public void rerollAttributes() {
        Random random = new Random();

        strength = 0;
        agility = 0;
        toughness = 0;
        perception = 0;
        intelligence = 0;
        knowledge = 0;
        will = 0;
        charisma = 0;

        for (int i = 0; i < 3; i++) {
            strength += random.nextInt(1, 7);
            agility += random.nextInt(1, 7);
            toughness += random.nextInt(1, 7);
            perception += random.nextInt(1, 7);
            intelligence += random.nextInt(1, 7);
            knowledge += random.nextInt(1, 7);
            will += random.nextInt(1, 7);
            charisma += random.nextInt(1, 7);
        }
    }

    public void rerollInitialHPMP() {
        Random random = new Random();

        maxHP = random.nextInt(1, characterClass.getHpDie()) + attributeBonus(getToughness());
        maxMP = random.nextInt(1, characterClass.getMpDie()) + attributeBonus(getBaseWill());

        currentHP = maxHP;
        currentMP = maxMP;
    }

    public void levelUp() {
        Random random = new Random();

        level++;

        int newHP = random.nextInt(1, characterClass.getHpDie());
        int newMP = random.nextInt(1, characterClass.getMpDie());

        maxHP += newHP;
        currentHP += newHP;

        maxMP += newMP;
        currentMP += newMP;
    }

    public static int attributeBonus(int attribute) {
        if (attribute >= 10) return (attribute - 10) / 2;
        else return (attribute - 11) / 2;
    }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getCurrentMP() { return currentMP; }

    public int getMaxMP() { return maxMP; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStrength() {
        if (characterRace == null) return strength;

        return strength + characterRace.getStrengthMod();
    }

    public int getAgility() {
        if (characterRace == null) return agility;

        return agility + characterRace.getAgilityMod();
    }

    public int getToughness() {
        if (characterRace == null) return toughness;

        return toughness + characterRace.getToughnessMod();
    }

    public int getPerception() {
        if (characterRace == null) return perception;

        return perception + characterRace.getPerceptionMod();
    }

    public int getIntelligence() {
        if (characterRace == null) return perception;

        return perception + characterRace.getPerceptionMod();
    }

    public int getKnowledge() {
        if (characterRace == null) return knowledge;

        return knowledge + characterRace.getKnowledgeMod();
    }

    public int getWill() {
        if (characterRace == null) return will;

        return will + characterRace.getWillMod();
    }

    public int getCharisma() {
        if (characterRace == null) return charisma;

        return charisma + characterRace.getCharismaMod();
    }

    public int getBaseStrength() {
        return strength;
    }

    public void setBaseStrength(int strength) { this.strength = strength; }

    public int getBaseAgility() {
        return agility;
    }

    public void setBaseAgility(int agility) { this.agility = agility; }

    public int getBaseToughness() {
        return toughness;
    }

    public void setBaseToughness(int toughness) { this.toughness = toughness; }

    public int getBasePerception() {
        return perception;
    }

    public void setBasePerception(int perception) { this.perception = perception; }

    public int getBaseIntelligence() {
        return intelligence;
    }

    public void setBaseIntelligence(int intelligence) { this.intelligence = intelligence; }

    public int getBaseKnowledge() {
        return knowledge;
    }

    public void setBaseKnowledge(int knowledge) { this.knowledge = knowledge; }

    public int getBaseWill() {
        return will;
    }

    public void setBaseWill(int will) { this.will = will; }

    public int getBaseCharisma() { return charisma; }

    public void setBaseCharisma(int charisma) { this.charisma = charisma; }

    public CharacterRace getCharacterRace() { return characterRace; }

    public void setCharacterRace(CharacterRace characterRace) { this.characterRace = characterRace; }

    public CharacterClass getCharacterClass() { return characterClass; }

    public void setCharacterClass(CharacterClass characterClass) { this.characterClass = characterClass; }

    public Weapon getRightHand() { return rightHand; }

    public Weapon getLeftHand() { return leftHand; }
}
