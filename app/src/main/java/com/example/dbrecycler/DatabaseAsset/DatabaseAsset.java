package com.example.dbrecycler.DatabaseAsset;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.dbrecycler.Mode.SecondStore;
import com.example.dbrecycler.Mode.Store;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAsset extends SQLiteAssetHelper {

    private static String DATA_NAME="data.db";
    private static int VER_NUM=1;

    public DatabaseAsset(Context context) {
        super(context, DATA_NAME, null, VER_NUM);
    }

    // Function to get All Store

    public List<Store> getStore(){
        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();


        //Make sure all is from Column name

        String [] sqSelect={"id","Name","email"};
        String tableName="Friends";
        qb.setTables(tableName);

        Cursor cursor=qb.query(db,sqSelect,null,null,null,null,null,null);

        List<Store> result=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                Store store=new Store();
                store.setId(cursor.getInt(cursor.getColumnIndex("id")));
                store.setName(cursor.getString(cursor.getColumnIndex("Name")));
                store.setEmail(cursor.getString(cursor.getColumnIndex("Email")));

                result.add(store);
            }while (cursor.moveToNext());
        }
        return  result;
    }




    // Work with second activity

    public List<SecondStore> getSecondStore(){
        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String [] sqSelect={"id", "name", "content"};
        String tableName="second";
        qb.setTables(tableName);

        Cursor cursor=qb.query(db,sqSelect,null,null,null,null,null);

        List<SecondStore> result=new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                SecondStore secondStore=new SecondStore();
                secondStore.setId(cursor.getInt(cursor.getColumnIndex("work")));
                secondStore.setName(cursor.getString(cursor.getColumnIndex("name")));
                secondStore.setContent(cursor.getString(cursor.getColumnIndex("content")));

                result.add(secondStore);
            }while (cursor.moveToNext());
        }
        return result;
    }
}
