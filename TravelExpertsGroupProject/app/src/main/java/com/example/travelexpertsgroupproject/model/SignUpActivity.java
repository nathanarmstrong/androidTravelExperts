package com.example.travelexpertsgroupproject.model;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.travelexpertsgroupproject.R;

public class SignUpActivity extends AppCompatActivity {

    // Andy Code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Drop Down List for Countries
        final Spinner spCountry = findViewById(R.id.spCountry);
        final Resources resources = getResources();
        final ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>
                (SignUpActivity.this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.country));
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(countryAdapter);

        // Set Up Drop Down List for Provinces or States
        final Spinner spProvince = findViewById(R.id.spProvince);
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


    }
}
