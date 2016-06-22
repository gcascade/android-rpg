package gcascade.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Geoffroy on 20/05/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
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
    public static final String WEIGHT = "weight";
    public static final String RARITY = "rarity";
    public static final String SLOT = "slot";
    public static final String DUAL_WIELD = "dualWield";
    public static final String TWO_HANDS = "twoHands";
    public static final String EQUIPMENT = "equipment";

    public static final String HERO_TABLE_NAME = "Hero";
    public static final String ITEM_TABLE_NAME = "Item";
    public static final String SKILL_TABLE_NAME = "Skill";
    public static final String SKILLS_HERO_ASSOCIATION_TABLE_NAME = "SkillsHeroAssociation";
    public static final String ITEM_TABLE_CREATE =
            "CREATE TABLE " + ITEM_TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ATK + " INTEGER, " +
                    DEF + " INTEGER, " +
                    HP + " INTEGER, " +
                    SP + " INTEGER, " +
                    NAME + " TEXT, " +
                    WEIGHT + " REAL, " +
                    RARITY + " INTEGER, " +
                    SLOT + " INTEGER, " +
                    DUAL_WIELD + " INTEGER, " +
                    TWO_HANDS + " INTEGER, " +
                    EQUIPMENT + " INTEGER, " +
                    ");";
    public static final String HERO_TABLE_CREATE =
            "CREATE TABLE " + HERO_TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ATK + " INTEGER, " +
                    DEF + " INTEGER, " +
                    HP + " INTEGER, " +
                    SP + " INTEGER, " +
                    NAME + " TEXT, " +
                    //SKILLS_HERO_ASSOCIATION_ID + " INTEGER, " +
                    LEFT_HAND_ITEM + " INTEGER, " +
                    RIGHT_HAND_ITEM + " INTEGER, " +
                    BODY_ITEM + " INTEGER, " +
                    HEAD_ITEM + " INTEGER, " +
                    BOOTS_ITEM + " INTEGER, " +
                    //"FOREIGN KEY (" + SKILLS_HERO_ASSOCIATION_ID + ") REFERENCES " + SKILLS_HERO_ASSOCIATION_TABLE_NAME+ " (" + KEY + ")," +
                    "FOREIGN KEY (" + LEFT_HAND_ITEM + ") REFERENCES " + ITEM_TABLE_NAME+ " (" + KEY + ")," +
                    "FOREIGN KEY (" + RIGHT_HAND_ITEM + ") REFERENCES " + ITEM_TABLE_NAME+ " (" + KEY + ")," +
                    "FOREIGN KEY (" + BODY_ITEM + ") REFERENCES " + ITEM_TABLE_NAME+ " (" + KEY + ")," +
                    "FOREIGN KEY (" + HEAD_ITEM + ") REFERENCES " + ITEM_TABLE_NAME+ " (" + KEY + ")," +
                    "FOREIGN KEY (" + BOOTS_ITEM + ") REFERENCES " + ITEM_TABLE_NAME+ " (" + KEY + ")" +
                    ");";

    public static final String HERO_TABLE_DROP = "DROP TABLE IF EXISTS " + HERO_TABLE_NAME + ";";
    public static final String ITEM_TABLE_DROP = "DROP TABLE IF EXISTS " + ITEM_TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ITEM_TABLE_CREATE);
        db.execSQL(HERO_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(HERO_TABLE_DROP);
        db.execSQL(ITEM_TABLE_DROP);
        onCreate(db);
    }
}
