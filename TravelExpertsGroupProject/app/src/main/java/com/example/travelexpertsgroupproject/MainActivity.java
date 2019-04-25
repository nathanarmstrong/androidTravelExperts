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
import com.example.travelexpertsgroupproject.model.SignUpActivity;


public class MainActivity extends AppCompatActivity {

    private EditText etLoginID;
    private EditText etPass;
    private TextView tvError;
    private Customer mCustomer;
    private Button btnlogin;
    private CustomerDB source;

    // Andy Code
    private Button btnSignUp;

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
                etLoginID = findViewById(R.id.etLoginID);
                String user = etLoginID.getText().toString();
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

        // Andy Code
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });
    }


}
