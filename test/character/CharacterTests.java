package character;

import items.DieRoller;
import items.Weapon;

import org.junit.jupiter.api.Test;
import utils.DamageType;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CharacterTests {
    private CharacterRace zerosRace = new CharacterRace(0, 0, 0, 0, 0, 0, 0, 0, "Test Race", "Test Race");
    private CharacterRace testRace = new CharacterRace(1, 1, 1, 1, 1, 1, 1, 1, "Test Race", "Test Race");

    private CharacterClass testClass = new CharacterClass(10, 6, "Test Class", "Test Class");

    private Weapon testTwoHanded = new Weapon(2, "Two Handed", "Two Handed", DamageType.FORCE, new DieRoller(2, 6));
    private Weapon testOneHandedA = new Weapon(1, "One Handed A", "One Handed A", DamageType.SLASH, new DieRoller(1, 8));
    private Weapon testOneHandedB = new Weapon(1, "One Handed B", "One Handed B", DamageType.SLASH, new DieRoller(1, 6));

    @Test
    public void RerollCharacterTest() {
        Character character = new Character("Jimothy");
        character.setCharacterRace(testRace);

        for (int i = 0; i < 500; i++) {
            character.rerollAttributes();

            assertTrue(character.getBaseStrength() >= 3);
            assertTrue(character.getBaseStrength() <= 18);

            assertTrue(character.getBaseAgility() >= 3);
            assertTrue(character.getBaseAgility() <= 18);

            assertTrue(character.getBaseToughness() >= 3);
            assertTrue(character.getBaseToughness() <= 18);

            assertTrue(character.getBasePerception() >= 3);
            assertTrue(character.getBasePerception() <= 18);

            assertTrue(character.getBaseIntelligence() >= 3);
            assertTrue(character.getBaseIntelligence() <= 18);

            assertTrue(character.getBaseKnowledge() >= 3);
            assertTrue(character.getBaseKnowledge() <= 18);

            assertTrue(character.getBaseWill() >= 3);
            assertTrue(character.getBaseWill() <= 18);

            assertTrue(character.getBaseCharisma() >= 3);
            assertTrue(character.getBaseCharisma() <= 18);

            assertTrue(character.getStrength() >= 4);
            assertTrue(character.getStrength() <= 19);

            assertTrue(character.getAgility() >= 4);
            assertTrue(character.getAgility() <= 19);

            assertTrue(character.getToughness() >= 4);
            assertTrue(character.getToughness() <= 19);

            assertTrue(character.getPerception() >= 4);
            assertTrue(character.getPerception() <= 19);

            assertTrue(character.getIntelligence() >= 4);
            assertTrue(character.getIntelligence() <= 19);

            assertTrue(character.getKnowledge() >= 4);
            assertTrue(character.getKnowledge() <= 19);

            assertTrue(character.getWill() >= 4);
            assertTrue(character.getWill() <= 19);

            assertTrue(character.getCharisma() >= 4);
            assertTrue(character.getCharisma() <= 19);
        }
    }

    @Test
    public void testAttributeBonus() {
        assertEquals(-2, Character.attributeBonus(6));
        assertEquals(-2, Character.attributeBonus(7));
        assertEquals(-1, Character.attributeBonus(8));
        assertEquals(-1, Character.attributeBonus(9));
        assertEquals(0, Character.attributeBonus(10));
        assertEquals(0, Character.attributeBonus(11));
        assertEquals(1, Character.attributeBonus(12));
        assertEquals(1, Character.attributeBonus(13));
        assertEquals(2, Character.attributeBonus(14));
        assertEquals(2, Character.attributeBonus(15));
    }

    @Test
    public void testRollHPMP() {
        Character testCharacter = new Character("Jimothy");

        testCharacter.setCharacterRace(zerosRace);
        testCharacter.setCharacterClass(testClass);

        for (int i = 0; i < 500; i++) {
            testCharacter.rerollInitialHPMP();

            assertTrue(testCharacter.getCurrentHP() >= 1);
            assertTrue(testCharacter.getMaxHP() >= 1);
            assertTrue(testCharacter.getCurrentMP() >= 1);
            assertTrue(testCharacter.getMaxMP() >= 1);

            assertTrue(testCharacter.getCurrentHP() <= 10);
            assertTrue(testCharacter.getMaxHP() <= 10);
            assertTrue(testCharacter.getCurrentMP() <= 6);
            assertTrue(testCharacter.getMaxMP() <= 6);

            testCharacter.levelUp();

            assertTrue(testCharacter.getCurrentHP() >= 2);
            assertTrue(testCharacter.getMaxHP() >= 2);
            assertTrue(testCharacter.getCurrentMP() >= 2);
            assertTrue(testCharacter.getMaxMP() >= 2);

            assertTrue(testCharacter.getCurrentHP() <= 20);
            assertTrue(testCharacter.getMaxHP() <= 20);
            assertTrue(testCharacter.getCurrentMP() <= 12);
            assertTrue(testCharacter.getMaxMP() <= 12);

            testCharacter.levelUp();

            assertTrue(testCharacter.getCurrentHP() >= 3);
            assertTrue(testCharacter.getMaxHP() >= 3);
            assertTrue(testCharacter.getCurrentMP() >= 3);
            assertTrue(testCharacter.getMaxMP() >= 3);

            assertTrue(testCharacter.getCurrentHP() <= 30);
            assertTrue(testCharacter.getMaxHP() <= 30);
            assertTrue(testCharacter.getCurrentMP() <= 18);
            assertTrue(testCharacter.getMaxMP() <= 18);
        }
    }

    @Test
    public void testEquipWeapons() {
        Character testCharacter = new Character("Jimothy");

        assertNull(testCharacter.getRightHand());
        assertNull(testCharacter.getLeftHand());

        testCharacter.equipRightHandWeapon(testOneHandedA);

        assertEquals(testOneHandedA, testCharacter.getRightHand());
        assertNull(testCharacter.getLeftHand());

        testCharacter.equipRightHandWeapon(testOneHandedB);

        assertEquals(testOneHandedB, testCharacter.getRightHand());
        assertNull(testCharacter.getLeftHand());

        testCharacter.equipLeftHandWeapon(testOneHandedA);

        assertEquals(testOneHandedB, testCharacter.getRightHand());
        assertEquals(testOneHandedA, testCharacter.getLeftHand());

        testCharacter.equipRightHandWeapon(testTwoHanded);

        assertEquals(testTwoHanded, testCharacter.getRightHand());
        assertEquals(testTwoHanded, testCharacter.getLeftHand());

        testCharacter.equipRightHandWeapon(testOneHandedA);

        assertEquals(testOneHandedA, testCharacter.getRightHand());
        assertNull(testCharacter.getLeftHand());

        testCharacter.equipRightHandWeapon(testTwoHanded);

        assertEquals(testTwoHanded, testCharacter.getRightHand());
        assertEquals(testTwoHanded, testCharacter.getLeftHand());

        testCharacter.equipLeftHandWeapon(testOneHandedA);

        assertNull(testCharacter.getRightHand());
        assertEquals(testOneHandedA, testCharacter.getLeftHand());
    }
}
