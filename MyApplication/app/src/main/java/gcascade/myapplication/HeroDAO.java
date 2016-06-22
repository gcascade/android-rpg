package gcascade.myapplication;

import android.content.ContentValues;

/**
 * Created by Geoffroy on 20/05/2016.
 */
public class HeroDAO extends DAOBase {
    public static final String KEY = "ID";
    public static final String ATK = "atk";
    public static final String DEF = "def";
    public static final String HP = "hp";
    public static final String SP = "sp";
    public static final String NAME = "name";
    public static final String SKILLS_HERO_ASSOCIATION_ID = "SKILLS_HERO_ASSOCIATION_ID";
    public static final String LEFT_HAND_ITEM = "leftHandItem";
    public static final String RIGHT_HAND_ITEM = "rightHandItem";
    public static final String BODY_ITEM = "bodyItem";
    public static final String HEAD_ITEM = "headItem";
    public static final String BOOTS_ITEM = "bootsItem";
    public static final String TABLE_NAME = "hero";

    public void insert(Hero hero){
        ContentValues value = new ContentValues();
        value.put(HeroDAO.ATK, hero.getAtk());
        value.put(HeroDAO.DEF, hero.getDef());
        value.put(HeroDAO.HP, hero.getHp());
        value.put(HeroDAO.SP, hero.getSp());
        value.put(HeroDAO.NAME, hero.getName());
        value.put(HeroDAO.LEFT_HAND_ITEM, hero.getLeftHand().getId());
        value.put(HeroDAO.RIGHT_HAND_ITEM, hero.getRightHand().getId());
        value.put(HeroDAO.BODY_ITEM, hero.getBody().getId());
        value.put(HeroDAO.HEAD_ITEM, hero.getHead().getId());
        value.put(HeroDAO.BOOTS_ITEM, hero.getBoots().getId());
        mDb.insert(HeroDAO.TABLE_NAME, null, value);

    }

    public void delete(long id) {
        mDb.delete(HeroDAO.TABLE_NAME, HeroDAO.KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void update(String valueName, int valueInt, int id) {
        ContentValues value = new ContentValues();
        value.put(valueName, valueInt);
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(id)});
    }

    public void update(String valueName, String valueString, int id) {
        ContentValues value = new ContentValues();
        value.put(valueName, valueString);
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(id)});
    }

    public void update(String valueName, float valueFloat, int id) {
        ContentValues value = new ContentValues();
        value.put(valueName, valueFloat);
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(id)});
    }
}
