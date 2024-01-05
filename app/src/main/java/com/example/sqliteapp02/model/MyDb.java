package com.example.sqliteapp02.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDb extends SQLiteOpenHelper {
    private static final String nameDb = "Produit.db";
    private static final int version = 1;
    public static final String ID = "id";

    public MyDb(@Nullable Context context) {
        super(context, nameDb, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Produit (" + ID + " Integer Primary Key autoincrement,name text,prix int) ");
    }

    public  boolean  add(Produit p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put("name",p.getName());
        cn.put("prix",p.getPrix());
        if (db.insert("Produit",null,cn) == -1){
            return false;
        }
        return  true;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Produit> getData(){
        List<Produit> prodouitList = new ArrayList<>();
        SQLiteDatabase sqlGetData = getReadableDatabase();
        SQLiteDatabase sql = getReadableDatabase();

        Cursor cur = sqlGetData.rawQuery("select * from Produit",null);
        while (cur.moveToNext()){
            Produit prod = new Produit(cur.getString(1),cur.getString(2),cur.getInt(0));
//          boolean b = cur.getInt(1) == 1 ? true : false;
            prodouitList.add(prod);
        }
        return  prodouitList;
    }
    public void Delet(Integer id){
        SQLiteDatabase db = getWritableDatabase();
//       String [] args = {name};
//        db.delete("Produit",""+ID+"= 1",null);
//       String s = "DELETE * from Produit where " + ID + " = ";


        String query = "Delete From Produit where id = "+id+"";
        db.execSQL(query);
    }
}
