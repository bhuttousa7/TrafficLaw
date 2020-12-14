package com.example.usama.trafficlaw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Button btn_feed = (Button) findViewById(R.id.btn_feedback);
        EditText descroption = (EditText) findViewById(R.id.descbox);

        btn_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Feedback.this,"Submitted ", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
