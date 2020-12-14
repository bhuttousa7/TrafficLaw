package com.example.usama.trafficlaw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class myProfile extends AppCompatActivity {
    TextView name, Phone, City, email;
    TextView violations;
    DataBindFirestore d =new DataBindFirestore();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        email = (TextView) findViewById(R.id.email_profile);
        name = (TextView) findViewById(R.id.name_profile);
        City = (TextView) findViewById(R.id.city_profile);
        Phone = (TextView) findViewById(R.id.phone_profile);
        violations = (TextView) findViewById(R.id.violation_textview_profile);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference noteRef = db.collection("ticket").
                document(DataBindFirestore.getUID()).collection("Tickets").document("ticket1");
        noteRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                email.setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail());
                name.setText(documentSnapshot.getString("Name"));
                City.setText(documentSnapshot.getString("City"));
                System.out.println("Phone - >>>>" + String.valueOf(documentSnapshot.getLong("Phone")));
                Phone.append(String.valueOf(documentSnapshot.getLong("Phone")));
                violations.append(String.valueOf(AllViolations.size));


            }
        });









    }
}
