package gcascade.myapplication;

/**
 * Created by Geoffroy on 17/05/2016.
 */
public class Item {

    public static final int SLOT_HEAD=1;
    public static final int SLOT_HAND=2;
    public static final int SLOT_BODY=3;
    public static final int SLOT_BOOTS=4;
    public static final int RARITY_NORMAL=5;
    public static final int RARITY_UNCOMMON=6;
    public static final int RARITY_RARE=7;
    public static final int RARITY_UNIQUE=8;
    private int attack;
    private int defense;
    private int hp;
    private int sp;
    private int slot;
    private float weight;
    private boolean dualWield;
    private boolean twoHands;
    private boolean equipment;
    private Effect special;
    private String name;
    private int rarity;
    private int id;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isDualWield() {
        return dualWield;
    }

    public void setDualWield(boolean dualWield) {
        this.dualWield = dualWield;
    }

    public boolean isTwoHands() {
        return twoHands;
    }

    public void setTwoHands(boolean twoHands) {
        this.twoHands = twoHands;
    }

    public boolean isEquipment() {
        return equipment;
    }

    public void setEquipment(boolean equipment) {
        this.equipment = equipment;
    }

    public Effect getSpecial() {
        return special;
    }

    public void setSpecial(Effect special) {
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpty() {
        name="Empty";
        attack=0;
        defense=0;
        hp=0;
        sp=0;
        dualWield=true;
        twoHands=false;
        rarity=RARITY_NORMAL;
        special=null;
        weight=0;
    }
}
