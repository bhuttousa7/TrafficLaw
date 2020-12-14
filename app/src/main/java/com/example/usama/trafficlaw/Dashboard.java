package com.example.usama.trafficlaw;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class Dashboard extends AppCompatActivity {
    private TextView title;
    int i = 0;
    private final String TAG = "DASHBOARD";
    public int size;
    ArrayList<Violation> newFinalArraylist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView tx= (TextView) findViewById(R.id.TitleofUser);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            tx.append(" " + value);

        }


        ImageButton payBtn =(ImageButton)findViewById(R.id.payTicketBtn);
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Dashboard.this,NewViolations.class);
                startActivity(i);


            }
        });




        ImageButton ticketStatus =(ImageButton)findViewById(R.id.ticketStatus);
        ticketStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Dashboard.this,Status.class);
                startActivity(i);



            }
        });

        ImageButton allTickets =(ImageButton)findViewById(R.id.viewTickets);
        allTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Dashboard.this,AllViolations.class);
                startActivity(i);



            }
        });

        ImageButton profile =(ImageButton)findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Dashboard.this,myProfile.class);
                startActivity(i);



            }
        });

        ImageButton feedback =(ImageButton)findViewById(R.id.reportBtn);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Dashboard.this,Feedback.class);
                startActivity(i);



            }
        });


        ImageButton contact =(ImageButton)findViewById(R.id.contactBtn);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Dashboard.this,ContactUs.class);
                startActivity(i);



            }
        });

        ImageButton logout =(ImageButton)findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(Dashboard.this,MainActivity.class);
            startActivity(i);
            Toast.makeText(Dashboard.this,"Logged Out", Toast.LENGTH_SHORT).show();

            }
        });
    }





}
