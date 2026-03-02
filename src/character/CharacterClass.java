package character;

public class CharacterClass {
    private int hpDie;
    private int mpDie;

    private String name;
    private String description;

    public CharacterClass(int hpDie, int mpDie, String name, String description) {
        this.hpDie = hpDie;
        this.mpDie = mpDie;

        this.name = name;
        this.description = description;
    }

    public int getHpDie() { return hpDie; }

    public int getMpDie() { return mpDie; }
}
