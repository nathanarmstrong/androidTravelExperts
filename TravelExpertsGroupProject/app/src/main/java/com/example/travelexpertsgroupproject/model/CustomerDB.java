package com.example.travelexpertsgroupproject.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.travelexpertsgroupproject.database.DatabaseHelper;

import java.util.ArrayList;

public class CustomerDB {
    public SQLiteDatabase db;
    DatabaseHelper helper;

    public CustomerDB(Context context){
        helper = new DatabaseHelper(context);
        helper.createDataBase();
        db = helper.getWritableDatabase();
    }

//    public Agent getAgent(int agentId){
//        String [] args = { agentId + ""};
//        String sql = "select * from Agents where AgentId=?";
//        Cursor cursor = db.rawQuery(sql, args);
//        cursor.moveToNext();
//        return new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7));
//    }
    public Customer getCustomer(String CustEmail, String CustPass){
        String[] Args = {CustEmail, CustPass};
        Cursor cursor = db.rawQuery("select * from Customers where CustEmail=? and CustPass=?", Args);
        cursor.moveToNext();
        return new Customer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),  cursor.getString(6), cursor.getString(7),  cursor.getString(8),  cursor.getString(9), cursor.getString(10), cursor.getString(12));
    }

//    public ArrayList<Customer> getAllAgents(){
//        ArrayList<Customer> list = new ArrayList<>();
//        Cursor cursor = db.rawQuery("select * from Customer", null);
//        while (cursor.moveToNext()){
//            list.add(new Customer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7)));
//        }
//        return list;
//    }

//    public void insert(Customer a){
//        ContentValues values = new ContentValues();
//        values.put("AgtFirstName", a.getAgtFirstName());
//        values.put("AgtMiddleInitial", a.getAgtMiddleInitial());
//        values.put("AgtLastName", a.getAgtLastName());
//        values.put("AgtBusPhone", a.getAgtBusPhone());
//        values.put("AgtEmail", a.getAgtEmail());
//        values.put("AgtPosition", a.getAgtPosition());
//        values.put("AgencyId", a.getAgencyId());

//        db.insert("Agents", null, values);
//    }

//    public void update(Customer a){
//        ContentValues values = new ContentValues();
//        values.put("AgentId", a.getAgentId());
//        values.put("AgtFirstName", a.getAgtFirstName());
//        values.put("AgtMiddleInitial", a.getAgtMiddleInitial());
//        values.put("AgtLastName", a.getAgtLastName());
//        values.put("AgtBusPhone", a.getAgtBusPhone());
//        values.put("AgtEmail", a.getAgtEmail());
//        values.put("AgtPosition", a.getAgtPosition());
//        values.put("AgencyId", a.getAgencyId());
//        String where = "AgentId = ?";
//        String [] whereArgs = {a.getAgentId() + ""};
//        db.update("Agents", values, where, whereArgs);
//    }
}
