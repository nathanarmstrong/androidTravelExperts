package com.example.travelexpertsgroupproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelexpertsgroupproject.database.DatabaseHelper;
import com.example.travelexpertsgroupproject.model.Customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPass;
    private TextView tvError;
    private Customer mCustomer;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check exiting database
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if(false == database.exists()){
            mDBHelper.getReadableDatabase();
            if(copyDatabase(this)){
                Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Copy database failed", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    public void sendLogin(View view){
        mDBHelper = new DatabaseHelper(this);
        etPass =  findViewById(R.id.etPass);
        etEmail =  findViewById(R.id.etEmail);
        String user = etEmail.getText().toString();
        String pass =  etPass.getText().toString();
        if(mDBHelper.getCustomer(user, pass) != null){
            Intent intent = new Intent(this, CustomerInfo.class);
            mCustomer = mDBHelper.getCustomer(user, pass);
            intent.putExtra("CUSTOMER", mCustomer);
            startActivity(intent);
        }else{
            //TODO change text field to display a error message about login fail

        }

    }

    private boolean copyDatabase(Context context){
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while((length = inputStream.read(buff)) > 0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.v("MainActivity", "DB copied");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
