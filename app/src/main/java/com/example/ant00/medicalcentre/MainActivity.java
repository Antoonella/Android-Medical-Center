package com.example.ant00.medicalcentre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button patientButton, receptionistButton;
    Intent intent;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patientButton = findViewById(R.id.btnPatient);
        receptionistButton= findViewById(R.id.btnReceptionist);

        //patientButton.setOnClickListener(this);
        //receptionistButton.setOnClickListener(this);
    }

    public void rOnClick(View view) {

        switch(view.getId())
        {
            case R.id.btnReceptionist:
                Intent intent = new Intent(MainActivity.this
                        ,ReceptionistLoginActivity.class);
                //intent = new Intent(getApplicationContext()
                // ,ReceptionistActivity.class);
                startActivity(intent);
                //startActivityForResult(intent, PATIENTCODE);

        }
    }

    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btnPatient:
                Intent intent = new Intent(MainActivity.this
                        ,PatientActivity.class);
                //intent = new Intent(getApplicationContext(),
                // ReceptionistActivity.class);
                startActivity(intent);
                //startActivityForResult(intent, PATIENTCODE);

        }
    }
}
