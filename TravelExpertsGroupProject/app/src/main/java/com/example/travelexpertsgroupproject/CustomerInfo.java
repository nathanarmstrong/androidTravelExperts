package com.example.travelexpertsgroupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.travelexpertsgroupproject.model.BookingDetails;
import com.example.travelexpertsgroupproject.model.BookingDetailsDB;
import com.example.travelexpertsgroupproject.model.Customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomerInfo extends AppCompatActivity {
    private Customer loginCust;
    private TextView tvFistName;
    private Button btnUpdate;
    private Button btnSignOut;
    private ArrayList<BookingDetails> bookingDetails;
    private BookingDetailsDB source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        Intent intent = getIntent();
        loginCust = (Customer) intent.getSerializableExtra("CUSTOMER");
        tvFistName = findViewById(R.id.tvUpdateProvince);
        tvFistName.setText("Welcome " + loginCust.getCustFirstName() + " " + loginCust.getCustLastName());

        source = new BookingDetailsDB(this);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUpdateCust = new Intent(getApplicationContext(), UpdateCustomerActivity.class);
                intentUpdateCust.putExtra("CUSTOMER", loginCust);
                startActivity(intentUpdateCust);
            }
        });

        btnSignOut = findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignOut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(SignOut);
            }
        });


        bookingDetails = source.GetBookingDetails(loginCust);
        TableLayout tableLayout = findViewById(R.id.tlBookingInfo);

        LinearLayout.LayoutParams tableRowParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        for (BookingDetails bookings: bookingDetails){
            Log.d("Booking Details", bookings.toString());

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(tableRowParams);

            TextView tvDesc = new TextView(this);
            tvDesc.setBackgroundColor(0xf3f3f3f3);
            tvDesc.setText(bookings.getDescription());
            TextView tvDest = new TextView(this);
            tvDest.setBackgroundColor(0xf3f3f3f3);
            tvDest.setText(bookings.getDestination());

            TextView tvStart = new TextView(this);
            tvStart.setBackgroundColor(0xf3f3f3f3);
            DateFormat formatter1=new SimpleDateFormat("yyyymmddHHmmsssss");
            Date startDate;
            try {
                startDate=formatter1.parse(bookings.getTripStart());
                tvStart.setText(startDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            TextView tvEnd = new TextView(this);
            tvEnd.setBackgroundColor(0xf3f3f3f3);
            Date endDate;
            try {
                endDate=formatter1.parse(bookings.getTripEnd());
                tvEnd.setText(endDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            TextView tvCount = new TextView(this);
            tvCount.setBackgroundColor(0xf3f3f3f3);
            tvCount.setText(bookings.getTravelerCount() + "");

            TableRow.LayoutParams cellParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT);
            cellParams.leftMargin = 10;
            cellParams.bottomMargin = 10;

            tvDesc.setLayoutParams(cellParams);
            tvDest.setLayoutParams(cellParams);
            tvStart.setLayoutParams(cellParams);
            tvEnd.setLayoutParams(cellParams);
            tvCount.setLayoutParams(cellParams);

            tableRow.addView(tvDesc);
            tableRow.addView(tvDest);
            tableRow.addView(tvStart);
            tableRow.addView(tvEnd);
            tableRow.addView(tvCount);

            tableLayout.addView(tableRow);
        }


    }
}
