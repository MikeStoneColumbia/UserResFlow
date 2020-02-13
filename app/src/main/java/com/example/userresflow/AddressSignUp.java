package com.example.userresflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddressSignUp extends AppCompatActivity {

    private EditText addressLine1;
    private EditText addressLine2;
    private EditText city;
    private EditText state_region;
    private EditText zip;
    private EditText country;
    private Button nxtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        addressLine1 = findViewById(R.id.addressLine1);
        addressLine2 = findViewById(R.id.addressLine2);
        city = findViewById(R.id.city);
        state_region = findViewById(R.id.state_region);
        zip = findViewById(R.id.zip);
        country = findViewById(R.id.country);
        nxtButton = findViewById(R.id.onwardsBtnAdd);


        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userAddressLine1 = addressLine1.getText().toString();
                String userAddressLine2 = addressLine2.getText().toString();
                String userCity = city.getText().toString();
                String userRegion = state_region.getText().toString();
                String userZip = zip.getText().toString();
                String userCountry = country.getText().toString();

                if(userAddressLine1.length() == 0 || userCity.length() == 0 || userRegion.length() == 0 ||
                   userZip.length() == 0 || userCountry.length() == 0){

                    Toast.makeText(AddressSignUp.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();

                }else{

                    goToDisplay(userAddressLine1,userAddressLine2,userCity,userRegion,userZip,userCountry);

                }

            }


        });


    }

    private void goToDisplay(String userAddressLine1, String userAddressLine2, String userCity, String userRegion, String zipCode, String userCountry) {

        Intent getInfo = getIntent();

        Intent i = new Intent(this,DisplayPage.class);

        i.putExtra("firstName",getInfo.getStringExtra("firstName"));
        i.putExtra("lastName",getInfo.getStringExtra("lastName"));
        i.putExtra("userEmail", getInfo.getStringExtra("userEmail"));
        i.putExtra("handleName", getInfo.getStringExtra("handleName"));
        i.putExtra("address1",userAddressLine1);
        i.putExtra("address2",userAddressLine2);
        i.putExtra("city",userCity);
        i.putExtra("region",userRegion);
        i.putExtra("zip",zipCode);
        i.putExtra("country",userCountry);

        startActivity(i);
        finish();
    }

}
