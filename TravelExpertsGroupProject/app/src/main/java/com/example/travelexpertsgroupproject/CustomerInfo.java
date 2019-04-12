package com.example.travelexpertsgroupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.travelexpertsgroupproject.model.Customer;

public class CustomerInfo extends AppCompatActivity {
    private Customer loginCust;
    private TextView tvFistName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        Intent intent = getIntent();
        loginCust = (Customer) intent.getSerializableExtra("CUSTOMER");
        tvFistName = findViewById(R.id.tvFirstName);
        tvFistName.setText(loginCust.getCustFirstName());
    }
}
