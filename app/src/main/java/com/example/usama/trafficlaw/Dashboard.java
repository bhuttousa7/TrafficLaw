package com.example.usama.trafficlaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    private TextView title;


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


    }
}
