package com.example.usama.trafficlaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class myProfile extends AppCompatActivity {
    TextView name, Phone, City, email;
    TextView violations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        email = (TextView) findViewById(R.id.email_profile);
        name = (TextView) findViewById(R.id.name_profile);
        City = (TextView) findViewById(R.id.city_profile);
        Phone = (TextView) findViewById(R.id.phone_profile);
        violations = (TextView) findViewById(R.id.violation_textview_profile);

        if(!Dashboard.getDataSet().isEmpty())
        {
        email.setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail());

        Phone.setText(Dashboard.getDataSet().get(0).getPhone());

        name.setText(Dashboard.getDataSet().get(0).getName());

        City.setText(Dashboard.getDataSet().get(0).getCity());

        violations.append(String.valueOf(Dashboard.getDataSet().size()));
        }
        else
        {
            Violation v = new Violation();
            Dashboard.getDataSet().add(v);
            email.setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail());

            Phone.setText(v.getPhone());

            name.setText(v.getName());

            City.setText(v.getCity());

            violations.append(String.valueOf(Dashboard.getDataSet().size()));
            //Toast.makeText(this,"")
        }
    }
}
