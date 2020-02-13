package com.example.userresflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameSignUp extends AppCompatActivity {

    private EditText userFirstName;
    private EditText userLastName;
    private EditText userEmail;
    private Button onwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_sign_up);

        userFirstName = findViewById(R.id.userNameFirst);
        userLastName = findViewById(R.id.userNameLast);
        userEmail = findViewById(R.id.userEmail);
        onwards = findViewById(R.id.onwardsBtn);

        onwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstNameStr = userFirstName.getText().toString();
                String lastNameStr = userLastName.getText().toString();
                String userEmailStr = userEmail.getText().toString();

                if(firstNameStr.length() == 0 || lastNameStr.length() == 0 || userEmail.length() == 0){

                    Toast.makeText(getApplicationContext(), "Please make sure to fill in all fields", Toast.LENGTH_SHORT).show();

                }else{

                    goToExperience();

                }

            }
        });



    }

    public void goToExperience(){

        Intent i  = new Intent(this,UserExperience.class);

        i.putExtra("firstName",userFirstName.getText().toString());
        i.putExtra("lastName",userLastName.getText().toString());
        i.putExtra("userEmail", userEmail.getText().toString());

        startActivity(i);

    }

}
