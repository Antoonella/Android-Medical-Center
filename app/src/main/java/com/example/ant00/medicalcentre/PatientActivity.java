package com.example.ant00.medicalcentre;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Calendar;

public class PatientActivity extends Activity implements View.OnClickListener {

    EditText date, time;
    DatePickerDialog datePickerDialog;

    String[] names = {"Select Doctor", "Dr.Tom", "Dr.Smith",
            "Dr.Jeny", "Dr.John", "Dr.Smintha"};

    ArrayAdapter<String> adapter;

    Button b;
    Spinner sp;
    Intent intent;
    Button clickbutton;
    TextView patientName, mobileNumber, emailAddress;
    Button btnWebsite;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        time = findViewById(R.id.etTime);
        patientName = findViewById(R.id.etName);
        mobileNumber = findViewById(R.id.etMobile);
        emailAddress = findViewById(R.id.etEmail);
        b = findViewById(R.id.btnSendEmail);

        date = (EditText) findViewById(R.id.date);

        date.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // calender class's instance and get current date , month and year from calender
                                        final Calendar c = Calendar.getInstance();
                                        int mYear = c.get(Calendar.YEAR); // current year
                                        int mMonth = c.get(Calendar.MONTH); // current month
                                        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                                        // date picker dialog
                                        datePickerDialog = new DatePickerDialog(PatientActivity.this,
                                                new DatePickerDialog.OnDateSetListener() {
                                                    @Override
                                                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                                        // set day of month , month and year value in the edit text
                                                        date.setText(dayOfMonth + "/"
                                                                + (monthOfYear + 1) + "/" + year);

                                                    }
                                                }, mYear, mMonth, mDay);
                                        datePickerDialog.show();
                                    }
        });

                sp = (Spinner) findViewById(R.id.sp1);
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, names);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialContactPhone("123123123");
            }
        });
        btnWebsite = findViewById(R.id.viewWeb);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://www.google.com/");

            }
        });

        clickbutton = findViewById(R.id.btnMakeAppointment);
        clickbutton.setOnClickListener(this);
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    @Override
    public void onClick(View v) {
        String name = String.valueOf(patientName.getText());
        String mobile = String.valueOf(mobileNumber.getText());
        String email = String.valueOf(emailAddress.getText());
        switch (v.getId()) {
            case R.id.btnMakeAppointment:
                Intent intent = new Intent
                        (PatientActivity.this,
                                ReceptionistLoginActivity.class);
               intent.putExtra("Name",name);
               intent.putExtra("Mobile",mobile);
               intent.putExtra("Email",email);
                startActivity(intent);

        }
    }
}

