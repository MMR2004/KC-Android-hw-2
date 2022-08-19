package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Your_CV extends AppCompatActivity {

    TextView name, age, job, phoneNumber, email;
    Button back;
    String calling;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_cv);

        //TextView
        name = findViewById(R.id.cvName);
        age = findViewById(R.id.cvAge);
        job = findViewById(R.id.cvJob);
        phoneNumber = findViewById(R.id.cvPhoneNumber);
        email = findViewById(R.id.cvEmail);

        //Button
        back = findViewById(R.id.back);

        //ــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
        Bundle bundle = getIntent().getExtras();

        String nameString = bundle.getString("name");
        name.setText(nameString);

        String ageInt = String.valueOf(bundle.getInt("age"));
        age.setText(ageInt);

        String jobString = bundle.getString("job");
        job.setText(jobString);

        String phoneNumberInt = String.valueOf(bundle.getInt("phone number"));
        phoneNumber.setText(phoneNumberInt);

        String emailString = bundle.getString("email");
        email.setText(emailString);


        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_CALL);
                calling = phoneNumber.getText().toString();
                callintent.setData(Uri.parse("tel:" + calling));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                    return;
                }
                startActivity(callintent);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackTruck = new Intent(Your_CV.this, CV_Edit.class);
                startActivity(BackTruck);
            }
        });



    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.CALL_PHONE}, 1 );
    }

}