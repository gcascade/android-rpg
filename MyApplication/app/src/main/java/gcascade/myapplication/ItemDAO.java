package gcascade.myapplication;

import android.content.ContentValues;

/**
 * Created by Geoffroy on 28/05/2016.
 */
public class ItemDAO extends DAOBase {


    public static final String KEY = "ID";
    public static final String ATK = "atk";
    public static final String DEF = "def";
    public static final String HP = "hp";
    public static final String SP = "sp";
    public static final String NAME = "name";
    public static final String SLOT = "slot";
    public static final String WEIGHT = "weight";
    public static final String DUAL_WIELD = "dualWield";
    public static final String EQUIPMENT = "equipment";
    //public static final String SPECIAL = "specialId";
    public static final String TWO_HANDS = "twoHands";
    public static final String RARITY = "rarity";
    public static final String TABLE_NAME = "item";
    
    public void insert(Item item){
        ContentValues value = new ContentValues();
        value.put(ItemDAO.ATK, item.getAttack());
        value.put(ItemDAO.DEF, item.getDefense());
        value.put(ItemDAO.HP, item.getHp());
        value.put(ItemDAO.SP, item.getSp());
        value.put(ItemDAO.NAME, item.getName());
        value.put(ItemDAO.RARITY,item.getRarity());
        value.put(ItemDAO.SLOT,item.getSlot());
        value.put(ItemDAO.TWO_HANDS,item.isTwoHands());
        value.put(ItemDAO.EQUIPMENT,item.isEquipment());
        value.put(ItemDAO.DUAL_WIELD,item.isDualWield());
        value.put(ItemDAO.WEIGHT,item.getWeight());
        mDb.insert(ItemDAO.TABLE_NAME, null, value);

    }

    public void delete(long id) {
        mDb.delete(ItemDAO.TABLE_NAME, ItemDAO.KEY + " = ?", new String[] {String.valueOf(id)});
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
