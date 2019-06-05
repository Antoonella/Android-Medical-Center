package com.example.ant00.medicalcentre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppointmentConfirmationActivity extends Activity implements View.OnClickListener {

    EditText totxbox, subjecttxbox, emailtxbox;
    Button sendEmailBtn, sendSmsBtn;
    String to, subject, emailbody;
        String name, mobile, email;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_confirmation);

        bundle = getIntent().getExtras();
        name =getIntent().getExtras().getString("Name");
        mobile = getIntent().getExtras().getString("Mobile");
        email = getIntent().getExtras().getString("Email");

        mobile = bundle.getString("Mobile");

        totxbox = findViewById(R.id.etCoName);
        subjecttxbox = findViewById(R.id.etCoEmail);
        emailtxbox = findViewById(R.id.etCoMobile);
        sendEmailBtn = findViewById(R.id.btnSendEmail);
        sendSmsBtn = findViewById(R.id.btnSendSms);


        //displaybtn.setOnClickListener(this);
        totxbox.setText(name);
        emailtxbox.setText(mobile);
        subjecttxbox.setText(email);
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to = totxbox.getText().toString();
                subject = subjecttxbox.getText().toString();
                emailbody = emailtxbox.getText().toString();


                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{to});
                emailIntent.putExtra(Intent.EXTRA_CC, new String[]{to});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailbody);

                emailIntent.setType("message/rfc822");


                startActivity(Intent.createChooser(emailIntent,
                        "sendemail"));

            }
        });

        sendSmsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNo = emailtxbox.getText().toString();
                String sms = subjecttxbox.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("04783762689",
                            null, "hello", null,
                            null);
                    Toast.makeText(getApplicationContext(),
                            "SMS Sent!",
                            Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {


    }
}

