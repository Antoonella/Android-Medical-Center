package com.example.ant00.medicalcentre;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReceptionistLoginActivity extends Activity {
    private EditText Name;
    private  EditText Password;
    private TextView Info;
    private Button Login;
    private int counter =5;
    String name, mobile;
    Bundle bundle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_login);
             Intent intent = new Intent(getApplicationContext(),
                     AppointmentConfirmationActivity.class);
        //bundle = getIntent().getExtras();
         //name =bundle.getString("Name");
        //mobile =bundle.getString("Mobile");

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        Info = findViewById(R.id.tvInfo);
        Login =findViewById(R.id.btnLogin);



        Info.setText(("No of attempts reaining; 5"));
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),
                        Password.getText().toString());
                Intent intent = new Intent(ReceptionistLoginActivity.
                        this, AppointmentConfirmationActivity.class);
            intent.putExtra("Name",getIntent().getStringExtra("Name"));
            intent.putExtra("Mobile",getIntent().getStringExtra("Mobile"));
            intent.putExtra("Email",getIntent().getStringExtra("Email"));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(intent,bundle);

                }
            }
        });
    }
    private void validate(String userName, String userPassword)
    {
        if ((userName.equals("Receptionist"))  && (userPassword.equals("BookWithUs2018")))
        //username:Receptionist password:BookWithUs2018
        {

        }
        else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));
            if (counter == 0)
            {
                Login.setEnabled(false);
            }

        }
    }


}
