package com.selbylei.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

/**
 * Created by selbylei on 17/3/8.
 */

public class BaseDaoFactory {


    private String sqliteDataBasePath;

    private SQLiteDatabase sqLiteDatabase;


    private static BaseDaoFactory instance = new BaseDaoFactory();

    private BaseDaoFactory() {
        sqliteDataBasePath = Environment.getExternalStorageState() + "/david.db";
        openDataBase();
    }

    private void openDataBase() {
        this.sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(sqliteDataBasePath, null);
    }


    public static BaseDaoFactory getInstance() {
        return instance;
    }


    public synchronized <T extends BaseDao<M>, M> T getBaseDao(Class<T> baseDaoClazz, Class<M>) {

        BaseDao basedao = null;


    }
}
