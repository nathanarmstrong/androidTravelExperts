package com.example.travelexpertsgroupproject.model;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.travelexpertsgroupproject.MainActivity;
import com.example.travelexpertsgroupproject.R;


public class SignUpActivity extends AppCompatActivity {
    private CustomerDB source;
    private EditText etCustFirstName;
    private EditText etCustLastName;
    private EditText etCustAddress;
    private EditText etCustCity;
    private EditText etCustPostal;
    private EditText etCustHomePhone;
    private EditText etCustBusPhone;
    private EditText etCustEmail;
    private EditText etCustLoginID;
    private EditText etCustPass;
    private EditText etConfirmPass;

    private boolean firstNameSet;
    private boolean lastNameSet;
    private boolean addressSet;
    private boolean citySet;
    private boolean postalSet;
    private boolean homePhoneSet;
    private boolean busPhoneSet;
    private boolean emailSet;
    private boolean loginIDSet;
    private boolean passSet;
    private boolean confirmPassSet;


    private Spinner spCountry;
    private Spinner spProvince;

    private String  country;
    private String province;

    private Button btnSubmit;
    private boolean inserted;


    // Andy Code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        source = new CustomerDB(this);
        firstNameSet = false;
        lastNameSet = false;
        addressSet = false;
        citySet = false;
        postalSet = false;
        homePhoneSet = false;
        busPhoneSet = false;
        emailSet = false;
        loginIDSet = false;
        passSet = false;
        confirmPassSet = false;

        CheckSubmit();

        // Drop Down List for Countries
         spCountry = findViewById(R.id.spCountry);
        final Resources resources = getResources();
        final ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>
                (SignUpActivity.this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.country));
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(countryAdapter);

        // Set Up Drop Down List for Provinces or States
        spProvince = findViewById(R.id.spProvince);
        final ArrayAdapter<String> provinceAdapter = new ArrayAdapter<String>
                (SignUpActivity.this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.provinces));
        provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>
                (SignUpActivity.this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.states));
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Default to Canada
        spProvince.setAdapter(provinceAdapter);

        // Changes to states when USA is selected and vice versa
        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            TextView tvSelectYourProv = findViewById(R.id.tvSelectYourProv);
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountry = spCountry.getSelectedItem().toString();
                if (selectedCountry.equals("Canada")) {
                    spProvince.setAdapter(provinceAdapter);
                    tvSelectYourProv.setText("Province");
                }
                else if (selectedCountry.equals("United States")) {
                    spProvince.setAdapter(stateAdapter);
                    tvSelectYourProv.setText("State");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSubmit = findViewById(R.id.btnSubmit);

        etCustFirstName = findViewById(R.id.etFirstName);
        etCustFirstName.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               if (s.toString().trim().length() == 0) {
                   firstNameSet = false;
               } else {
                   firstNameSet = true;
               }
           }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustLastName = findViewById(R.id.etLastName);
        etCustLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    lastNameSet = false;
                } else {
                    lastNameSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });

        etCustAddress = findViewById(R.id.etAddress);
        etCustAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    addressSet = false;
                } else {
                    addressSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustCity = findViewById(R.id.etCity);
        etCustCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    citySet = false;
                } else {
                    citySet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustPostal = findViewById(R.id.etPostalCode);
        etCustPostal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    postalSet = false;
                } else {
                    postalSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustHomePhone = findViewById(R.id.etHomePhone);
        etCustHomePhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    homePhoneSet = false;
                } else {
                    homePhoneSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustBusPhone = findViewById(R.id.etBusPhone);
        etCustBusPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    busPhoneSet = false;
                } else {
                    busPhoneSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustEmail = findViewById(R.id.etCustEmail);
        etCustEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    emailSet = false;
                } else {
                    emailSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustLoginID = findViewById(R.id.etCustLoginID);
        etCustLoginID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    loginIDSet = false;
                } else {
                    loginIDSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etCustPass = findViewById(R.id.etCustPass);
        etCustPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    passSet = false;
                } else {
                    passSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        etConfirmPass = findViewById(R.id.etConfirmPass);
        etConfirmPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    confirmPassSet = false;
                } else {
                    confirmPassSet = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                CheckSubmit();
            }
        });
        country = spCountry.getSelectedItem().toString();

        province= spProvince.getSelectedItem().toString();




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etCustPass.getText().toString().equals(etConfirmPass.getText().toString())){
                    inserted = source.insertCustomer(
                            etCustFirstName.getText() + "",
                            etCustLastName.getText() + "",
                            etCustAddress.getText() + "",
                            etCustCity.getText() + "", province + "" ,
                            etCustPostal.getText() + "",
                            country + "",
                            etCustHomePhone.getText() + "",
                            etCustBusPhone.getText() + "",
                            etCustEmail.getText() + "",
                            etCustLoginID.getText() + "",
                            etCustPass.getText() + "");
                    if(inserted = true){
                        //insert works
                        new AlertDialog.Builder(SignUpActivity.this)
                                .setTitle("New user Registered ")
                                .setMessage("Thank you for registering to Travel Experts")

                                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Continue
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .setIcon(android.R.drawable.ic_input_add)
                                .show();
                    }else{
                        new AlertDialog.Builder(SignUpActivity.this)
                                .setTitle("Sign up failed")
                                .setMessage("one or more fields were filled in wrong, please try again")

                                // A null listener allows the button to dismiss the dialog and take no further action.
                                .setPositiveButton("Okay", null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                }

            }
        });

    }

    private void CheckSubmit(){
        btnSubmit = findViewById(R.id.btnSubmit);
        if(firstNameSet == false &&lastNameSet == false && addressSet == false && citySet == false && postalSet == false && homePhoneSet == false && busPhoneSet == false && emailSet == false && loginIDSet == false && passSet == false && confirmPassSet == false){
            btnSubmit.setEnabled(false);
        }else{
            btnSubmit.setEnabled(true);
        }
    }
}
