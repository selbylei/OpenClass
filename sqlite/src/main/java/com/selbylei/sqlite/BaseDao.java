package com.selbylei.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by selbylei on 17/3/8.
 */

public abstract class BaseDao<T> implements IBaseDao<T> {

    private SQLiteDatabase database;

    private boolean isInit = false;

    /**
     * 具体的class对象
     */
    private Class<T> entity;


    private HashMap<String, Field> cacheMap;


    protected synchronized boolean init(Class<T> entity, SQLiteDatabase sqLiteDatabase) {
        if (!isInit){

        }else {

        }

        return isInit;
    }


    private void initCacheMap(){
        cacheMap = new HashMap<>();

        String sql = "select * from" + this.tableName +" limit 1,0";
        Cursor cursor = null;
        cursor = database.rawQuery(sql,null);
        String[] colmunsNames =  cursor.getColumnNames();
        Field[] colmunsFields = entity.getFields();


        for (Field field:colmunsFields){
            field.setAccessible(true);
        }

        for (String colmunName:colmunsNames){

        }
    }


    @Override
    public Long insert(T t) {
        HashMap<String,String> map = getValues(t);
        return null;
    }

    @Override
    public Long update(T t) {
        return null;
    }

    //创建表
    abstract String createTable();


    private ContentValues getContentValues(Map<T> map){

    }

}
