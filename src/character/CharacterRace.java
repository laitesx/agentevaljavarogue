package character;

public class CharacterRace {
    private int strengthMod;
    private int agilityMod;
    private int toughnessMod;
    private int perceptionMod;
    private int intelligenceMod;
    private int knowledgeMod;
    private int willMod;
    private int charismaMod;

    private String name;
    private String description;

    public CharacterRace(int strengthMod, int agilityMod, int toughnessMod, int perceptionMod, int intelligenceMod, int knowledgeMod, int willMod, int charismaMod, String name, String description) {
        this.strengthMod = strengthMod;
        this.agilityMod = agilityMod;
        this.toughnessMod = toughnessMod;
        this.perceptionMod = perceptionMod;
        this.intelligenceMod = intelligenceMod;
        this.knowledgeMod = knowledgeMod;
        this.willMod = willMod;
        this.charismaMod = charismaMod;

        this.name = name;
        this.description = description;
    }

    public int getStrengthMod() { return strengthMod; }

    public int getAgilityMod() { return agilityMod; }

    public int getToughnessMod() { return toughnessMod; }

    public int getPerceptionMod() { return perceptionMod; }

    public int getIntelligenceMod() { return intelligenceMod; }

    public int getKnowledgeMod() { return knowledgeMod; }

    public int getWillMod() { return willMod; }

    public int getCharismaMod() { return charismaMod; }

    public String getName() { return name; }

    public String getDescription() { return description; }
}
