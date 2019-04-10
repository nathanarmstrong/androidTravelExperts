package com.example.travelexpertsgroupproject.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.travelexpertsgroupproject.model.Customer;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "TravelExpertsSqlLite.db";
    public static final String DBLOCATION = "/data/data/com.example.travelexpertsgroupproject/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper (Context context){
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()){
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase(){
        if(mDatabase != null){
            mDatabase.close();
        }
    }

    public Customer getCustomer(String CustEmail, String CustPass){
        Customer cust = null;
        openDatabase();
        String[] Args = {CustEmail, CustPass};
        try{
            Cursor cursor = mDatabase.rawQuery("select * from Customers where CustEmail=? and CustPass=?", Args);
            cursor.moveToNext();
            cust = new Customer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),  cursor.getString(6), cursor.getString(7),  cursor.getString(8),  cursor.getString(9), cursor.getString(10), cursor.getString(12));
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        closeDatabase();
        return cust;
    }
}
