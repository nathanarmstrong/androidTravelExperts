package com.example.travelexpertsgroupproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.travelexpertsgroupproject.model.Customer;
import com.example.travelexpertsgroupproject.model.CustomerDB;

public class UpdateCustomerActivity extends AppCompatActivity {
    private Customer Cust;
    private CustomerDB source;

    private EditText etUpdateFirstname;
    private EditText etUpdateLastName;
    private EditText etUpdateAddress;
    private EditText etUpdateCity;
    private EditText etUpdateProvince;
    private EditText etUpdatePost;
    private EditText etUpdateCountry;
    private EditText etUpdateHomePhone;
    private EditText etUpdateBuisPhone;
    private EditText etUpdateEmail;
    private Button btnUpdateCustInfo;

    private EditText etChangePass;
    private EditText etChangePassConfim;
    private Button btnChangePass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);

        Intent intent = getIntent();
        Cust = (Customer) intent.getSerializableExtra("CUSTOMER");

        source = new CustomerDB(this);

        btnUpdateCustInfo = findViewById(R.id.btnUpdateCustInfo);



        etUpdateAddress = findViewById(R.id.etUpdateAddress);
        etUpdateAddress.setText(Cust.getCustAddress());
        etUpdateAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateCity = findViewById(R.id.etUpdateCity);
        etUpdateCity.setText(Cust.getCustCity());
        etUpdateCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateProvince = findViewById(R.id.etUpdateProvince);
        etUpdateProvince.setText(Cust.getCustProv());
        etUpdateProvince.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdatePost = findViewById(R.id.etUpdatePost);
        etUpdatePost.setText(Cust.getCustPostal());
        etUpdatePost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateCountry = findViewById(R.id.etUpdateCountry);
        etUpdateCountry.setText(Cust.getCustCountry());
        etUpdateCountry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateHomePhone = findViewById(R.id.etUpdateHomePhone);
        etUpdateHomePhone.setText(Cust.getCustHomePhone());
        etUpdateHomePhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateBuisPhone = findViewById(R.id.etUpdateBuisPhone);
        etUpdateBuisPhone.setText(Cust.getCustBusPhone());
        etUpdateBuisPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateEmail = findViewById(R.id.etUpdateEmail);
        etUpdateEmail.setText(Cust.getCustEmail());
        etUpdateEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        etUpdateFirstname = findViewById(R.id.etUpdateFirstName);
        etUpdateFirstname.setText(Cust.getCustFirstName());
        etUpdateFirstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etUpdateLastName = findViewById(R.id.etUpdateLastName);
        etUpdateLastName.setText(Cust.getCustLastName());
        etUpdateLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnUpdateCustInfo.setEnabled(false);
                } else {
                    btnUpdateCustInfo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnUpdateCustInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cust.setCustFirstName(etUpdateFirstname.getText() + "");
                Cust.setCustLastName(etUpdateLastName.getText() + "");
                Cust.setCustAddress(etUpdateAddress.getText() + "");
                Cust.setCustCity(etUpdateCity.getText() + "");
                Cust.setCustPostal(etUpdatePost.getText() + "");
                Cust.setCustProv(etUpdateProvince.getText() + "");
                Cust.setCustEmail(etUpdateEmail.getText() + "");
                Cust.setCustHomePhone(etUpdateHomePhone.getText() + "");
                Cust.setCustBusPhone(etUpdateBuisPhone.getText() + "");
                Cust.setCustCountry(etUpdateCountry.getText() + "");
                source.update(Cust);
                Intent intent = new Intent(getApplicationContext(), CustomerInfo.class);
                intent.putExtra("CUSTOMER", Cust);
                startActivity(intent);
            }
        });

        btnChangePass = findViewById(R.id.btnChangePass);

        etChangePass = findViewById(R.id.etChangePass);
        etChangePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnChangePass.setEnabled(false);
                } else {
                    btnChangePass.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etChangePassConfim = findViewById(R.id.etChangePassConfirm);
        etChangePassConfim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    btnChangePass.setEnabled(false);
                } else {
                    btnChangePass.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etChangePass.getText() == etChangePassConfim.getText()){
                    Cust.setCustPass(etChangePass.getText() + "");
                    source.update(Cust);
                    Intent intent = new Intent(getApplicationContext(), CustomerInfo.class);
                    intent.putExtra("CUSTOMER", Cust);
                    startActivity(intent);
                }else{
                    new AlertDialog.Builder(UpdateCustomerActivity.this)
                            .setTitle("Password does not match")
                            .setMessage("Did you want to try again?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton("Okay", null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });
    }
}
