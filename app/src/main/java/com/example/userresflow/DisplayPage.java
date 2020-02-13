package com.example.userresflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayPage extends AppCompatActivity {

    private TextView greeting;
    private TextView emailTv;
    private TextView addressTV;
    private TextView fullNameTV;
    private Intent info;
    private String addr1;
    private String addr2;
    private String city;
    private String zip;
    private String country;
    private String email;
    private String firstName;
    private String lastName;
    private String handle;
    private String region;
    private Person newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);


        greeting = findViewById(R.id.greetingDisplayTv);
        emailTv = findViewById(R.id.emailDisplay);
        addressTV= findViewById(R.id.addressDisplay);
        fullNameTV = findViewById(R.id.fullName);
        info = getIntent();

        addr1 = info.getStringExtra("address1");
        addr2 = info.getStringExtra("address2");
        city = info.getStringExtra("city");
        zip = info.getStringExtra("zip");
        country = info.getStringExtra("country");
        email = info.getStringExtra("userEmail");
        firstName = info.getStringExtra("firstName");
        lastName = info.getStringExtra("lastName");
        handle = info.getStringExtra("handleName");
        region = info.getStringExtra("region");

        String fullAddr = formatAdd(addr1,addr2,region,city,zip,country);

        newUser = new Person(firstName,lastName,handle,fullAddr,email);

        greeting.append("\n"+newUser.getHandleName());
        emailTv.append("\n"+newUser.getEmail());
        fullNameTV.append("\n"+newUser.getFirstName() + " " + newUser.getLastName());
        addressTV.append("\n"+newUser.getAddress());


    }

    public String formatAdd(String addr1,String addr2,String addrRegion,String addrCity, String addrZip,String addrCountry){

        String addr;

        if(addr2.length() != 0)
            addr = addr1 + "\n" + addr2 + "\n" + addrRegion + ", " + addrCity + " " + addrZip + "\n" + addrCountry;
        else
            addr = addr1 + "\n" + addrRegion + ", " + addrCity + " " + addrZip + "\n" + addrCountry;

        return addr;

    }
}
