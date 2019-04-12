package com.example.travelexpertsgroupproject.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.travelexpertsgroupproject.model.Customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String name = "TravelExpertsSqlLite.db";
    private static File path;
    private final Context myContext;
    private SQLiteDatabase myDatabase;

    public DatabaseHelper(Context context) {
        super(context, name, null, 1);
        this.myContext = context;
        path = context.getDatabasePath(DatabaseHelper.name);
    }

    public void createDataBase()
    {
        if (dbExist())
        {
            // do nothing
        }
        else
        {
            copyDatabase();
        }

    }

    private void copyDatabase() {
        try {
            InputStream myInput = myContext.getAssets().open(name);
            OutputStream myOutput = new FileOutputStream(path);

            byte [] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0)
            {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean dbExist(){
        SQLiteDatabase checkdb = null;
//        myContext.getDatabasePath(name.get)
        try {
            checkdb = SQLiteDatabase.openDatabase(path.getPath() + name, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkdb !=null)
        {
            checkdb.close();
        }
        return checkdb != null ? true : false;

    }

    public void openDataBase()
    {
        myDatabase = SQLiteDatabase.openDatabase(path + name, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
