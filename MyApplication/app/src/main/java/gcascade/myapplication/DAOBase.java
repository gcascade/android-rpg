package gcascade.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Geoffroy on 20/05/2016.
 */
public abstract class DAOBase {
    protected final static int VERSION = 1;
    protected final static String DBNAME = "database.db";

    protected SQLiteDatabase mDb = null;
    protected DatabaseHandler mHandler = null;

    public DAOBase() {

    }
    public DAOBase(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, DBNAME, null, VERSION);
    }

    public SQLiteDatabase open() {
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}
