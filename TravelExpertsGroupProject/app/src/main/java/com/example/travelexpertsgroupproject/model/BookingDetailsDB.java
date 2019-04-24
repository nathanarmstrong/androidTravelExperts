package com.example.travelexpertsgroupproject.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.travelexpertsgroupproject.database.DatabaseHelper;

import java.util.ArrayList;

public class BookingDetailsDB {
    public static SQLiteDatabase db;
    DatabaseHelper helper;

    public BookingDetailsDB(Context context){
        helper = new DatabaseHelper(context);
        helper.createDataBase();
        db = helper.getReadableDatabase();
    }

    public static ArrayList<BookingDetails> GetBookingDetails(Customer cust){
        ArrayList<BookingDetails> list = new ArrayList<>();
        String[] Args = {Integer.toString(cust.getCustomerId())};
        Cursor cursor = db.rawQuery("select B.BookingId, BD.TripStart, BD.TripEnd, BD.Description, BD.Destination, B.TravelerCount from Bookings B join BookingDetails BD on B.BookingId = BD.BookingId where B.CustomerId = ?", Args);
        if(cursor != null) {
            while (cursor.moveToNext()) {
                list.add(new BookingDetails(cursor.getInt(0), cursor.getString(3), cursor.getString(4), cursor.getString(1), cursor.getString(2), cursor.getInt(5)));
            }
        }
        return list;

    }
}
