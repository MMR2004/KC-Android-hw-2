package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CV_Edit extends AppCompatActivity {

    EditText nameEdit, ageEdit, jobEdit, phoneNumberEdit, emailEdit;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_edit);

        //EditText
        nameEdit = findViewById(R.id.cvNameEdit);
        ageEdit = findViewById(R.id.cvAgeEdit);
        jobEdit = findViewById(R.id.cvJobEdit);
        phoneNumberEdit = findViewById(R.id.cvPhoneNumberEdit);
        emailEdit = findViewById(R.id.cvEmailEdit);

        //Button
        next = findViewById(R.id.cvNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name4 = nameEdit.getText().toString();
                final String age4 = ageEdit.getText().toString();
                final String job4 = jobEdit.getText().toString();
                final String phoneNumber4 = phoneNumberEdit.getText().toString();
                final String email4 = emailEdit.getText().toString();


                if (name4.equals("") || age4.equals("") || job4.equals("") || phoneNumber4.equals("") || email4.equals("")){
                    if (TextUtils.isEmpty(nameEdit.getText())){
                        nameEdit.setError("Name is required!");
                    }
                    if (TextUtils.isEmpty(ageEdit.getText())){
                        ageEdit.setError("Age is required!");
                    }
                    if (TextUtils.isEmpty(jobEdit.getText())){
                        jobEdit.setError("Job is required!");
                    }
                    if (TextUtils.isEmpty(phoneNumberEdit.getText())){
                        phoneNumberEdit.setError("Phone Number is required!");
                    }
                    if (TextUtils.isEmpty(emailEdit.getText())){
                        emailEdit.setError("Email is required!");
                    }
                }else{
                CV cv = new CV(nameEdit.getText().toString(),
                        Integer.parseInt(ageEdit.getText().toString()),
                        jobEdit.getText().toString(),
                        Integer.parseInt(phoneNumberEdit.getText().toString()),
                        emailEdit.getText().toString());

                Intent intent = new Intent(CV_Edit.this, Your_CV.class);
                intent.putExtra("name", cv.getName());
                intent.putExtra("age", cv.getAge());
                intent.putExtra("job", cv.getJob());
                intent.putExtra("phone number", cv.getPhoneNumber());
                intent.putExtra("email", cv.getEmail());
                startActivity(intent);
                }
            }
        });




    }
}