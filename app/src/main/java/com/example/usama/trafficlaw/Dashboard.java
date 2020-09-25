package com.example.usama.trafficlaw;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

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



    }
    //Dynamic Data For Testing
    static ArrayList<Violation> getDataSet() {
        ArrayList results = new ArrayList<Violation>();
//        for (int index = 0; index < 4; index++) {
            Violation obj = new Violation();
            Violation obj1= new Violation();
           if(FirebaseAuth.getInstance().getCurrentUser()!=null) {

               //Violations of Munesh Kumar (2) Dummy Data
               if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("munesh@gmail.com")) {
                   obj.setTicketId("A1MP90");
                   obj.setName("Munesh Kumar");
                   obj.setAmount(300);
                   obj.setViolationType("Wrong Parking Violation");
                   obj.setLocation("Bahadurabad");
                   obj.setStatus("Unpaid");
                   obj.setNumberPlate("3NJL-848");
                   obj.setLicenceNo("AI90TU");
                   obj.setCnic("45004-1234454-9");
                   obj.setCity("Karachi");
                   obj.setPhone("+92322231232");


                   obj1.setName("Munesh Kumar");
                   obj1.setTicketId("B1MT21");
                   obj1.setAmount(1500);
                   obj1.setViolationType("Speed Violation");
                   obj1.setLocation("Khayaban-e-Ittehad Road");
                   obj1.setStatus("Unpaid");
                   obj1.setNumberPlate("3NJL-848");
                   obj1.setLicenceNo("AI90TU");
                   obj1.setCnic("45004-1234454-9");
                   obj1.setCity("Karachi");

                   obj1.setPhone("+92647923845");

                   results.add(0, obj);
                   results.add(1,obj1);

               }
               // Usama User Violations
               else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("bhuttousama7@gmail.com")) {
                   obj.setTicketId("60GO86");
                   obj.setName("Usama Bhutto");
                   obj.setAmount(400);
                   obj.setViolationType("Parking Violation");
                   obj.setLocation("Iqra University");
                   obj.setStatus("Unpaid");
                   obj.setNumberPlate("ASU-388");
                   obj.setLicenceNo("PI89JKL");
                   obj.setCnic("43301-9074591-9");
                   obj.setCity("Karachi");

                   obj.setPhone("+97198434535");


                   obj1.setTicketId("30F627");
                   obj1.setName("Usama Bhutto");
                   obj1.setAmount(400);
                   obj1.setViolationType("Speed Violation");
                   obj1.setLocation("I.I Chundrigar Road");
                   obj1.setStatus("Unpaid");
                   obj1.setNumberPlate("ASU-388");
                   obj1.setLicenceNo("PI89JKL");
                   obj1.setCnic("43301-9074591-9");
                   obj1.setCity("Karachi");

                   obj1.setPhone("+97198434535");
                   results.add(0, obj);
                   results.add(1,obj1);

               }
               else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("iasfahan@gmail.com"))
               {

                   obj1.setTicketId("S1PYR1");
                   obj1.setName("Asfahan Irfan");
                   obj1.setAmount(800);
                   obj1.setViolationType("Red Light Violation");
                   obj1.setLocation("Main Korangi Road");
                   obj1.setStatus("Process");
                   obj1.setNumberPlate("AMF-647");
                   obj1.setLicenceNo("BSXKI4U");
                   obj1.setCnic("40304-14024958-9");
                   obj1.setCity("Karachi");
                   obj1.setPhone("+92306789472");

                   results.add(0, obj1);

               }
               else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("parshantkumar7867@gmail.com"))
               {
                   obj.setTicketId("8KCEME");
                   obj.setName("Parshant Maheswari");
                   obj.setAmount(800);
                   obj.setViolationType("Speed Violation");
                   obj.setLocation("University Road");
                   obj.setStatus("Process");
                   obj.setNumberPlate("489T057");
                   obj.setLicenceNo("QAF913DN");
                   obj.setCnic("77337-11252454-9");
                   obj.setCity("Karachi");

                   obj.setPhone("+943434342");


                   obj1.setTicketId("8KCEME");
                   obj1.setName("Parshant Maheswari");
                   obj1.setAmount(800);
                   obj1.setViolationType("Speed Violation");
                   obj1.setLocation("University Road");
                   obj1.setStatus("Process");
                   obj1.setNumberPlate("489T057");
                   obj1.setLicenceNo("QAF913DN");
                   obj1.setCnic("77337-11252454-9");
                   obj1.setCity("Karachi");
                   obj1.setPhone("+943434342");

                   results.add(0, obj);
                   results.add(1,obj1);

               }
           }
           else
               {
                   System.out.println("Login Again !");
               }
//        }
        return results;
    }

}
