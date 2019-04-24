package com.example.travelexpertsgroupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.travelexpertsgroupproject.model.Customer;
import com.example.travelexpertsgroupproject.model.CustomerDB;


public class MainActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPass;
    private TextView tvError;
    private Customer mCustomer;
    private Button btnlogin;
    private CustomerDB source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btnLogin);
        source = new CustomerDB(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etPass =  findViewById(R.id.etPass);
                etEmail = findViewById(R.id.etEmail);
                String user = etEmail.getText().toString();
                String pass =  etPass.getText().toString();
                try{
                    if(source.getCustomer(user, pass) != null){
                        Intent intent = new Intent(getApplicationContext(), CustomerInfo.class);
                        mCustomer = source.getCustomer(user, pass);
                        intent.putExtra("CUSTOMER", mCustomer);
                        source.db.close();
                        startActivity(intent);
                    }else{
                        tvError = findViewById(R.id.tvError);
                        tvError.setText("Failed to login");
                    }
                }catch (Exception e){
                    throw e;
                }


            }
        });
    }


}
