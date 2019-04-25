package com.example.travelexpertsgroupproject.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.travelexpertsgroupproject.database.DatabaseHelper;

public class CustomerDB {
    public SQLiteDatabase db;
    DatabaseHelper helper;

    public CustomerDB(Context context){
        helper = new DatabaseHelper(context);
        helper.createDataBase();
        db = helper.getWritableDatabase();
    }

    public Customer getCustomer(String LoginID, String CustPass){
        String[] Args = {LoginID, CustPass};
        Cursor cursor = db.rawQuery("select * from Customers where CustLoginID=? and CustPass=?", Args);
        if(cursor.moveToNext()){
            return new Customer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),  cursor.getString(6), cursor.getString(7),  cursor.getString(8),  cursor.getString(9), cursor.getString(10), cursor.getInt(11), cursor.getString(12), cursor.getString(13));
        }else{
            return null;
        }
    }

    public boolean insertCustomer(String first, String last, String address, String city, String prov, String postal, String country, String homePhone, String busPhone, String Email, String loginID, String password){
        ContentValues values = new ContentValues();
        values.put("CustFirstName", first);
        values.put("CustLastName", last);
        values.put("CustAddress", address);
        values.put("CustCity", city);
        values.put("CustProv", "AB");
        values.put("CustPostal", postal);
        values.put("CustCountry", country);
        values.put("CustHomePhone", homePhone);
        values.put("CustBusPhone", busPhone);
        values.put("CustEmail", Email);
        values.put("CustLoginID", loginID);
        values.put("CustPass",password);
        long result = db.insert("customers", null, values);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public void update(Customer a){
        ContentValues values = new ContentValues();
        values.put("CustomerId", a.getCustomerId());
        values.put("CustFirstName", a.getCustFirstName());
        values.put("CustLastName", a.getCustLastName());
        values.put("CustAddress", a.getCustAddress());
        values.put("CustCity", a.getCustCity());
        values.put("CustProv", a.getCustProv());
        values.put("CustPostal", a.getCustPostal());
        values.put("CustCountry", a.getCustCountry());
        values.put("CustHomePhone", a.getCustHomePhone());
        values.put("CustBusPhone", a.getCustBusPhone());
        values.put("CustEmail", a.getCustEmail());
        values.put("AgentId", a.getAgentId());
        values.put("CustPass", a.getCustPass());
        String where = "CustomerId = ?";
        String [] whereArgs = {a.getCustomerId() + ""};
        db.update("customers", values, where, whereArgs);
    }
}
