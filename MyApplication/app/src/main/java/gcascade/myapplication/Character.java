package gcascade.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffroy on 17/05/2016.
 */
public class Character {
    private String name;
    private int atk;
    private int def;
    private int hp;
    private int sp;
    private List<Skills> skills;
    private int id;
    public Character() {
        atk=1;
        def=1;
        hp=1;
        sp=1;
        skills = new ArrayList<Skills>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
