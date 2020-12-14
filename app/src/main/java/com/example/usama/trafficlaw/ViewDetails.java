package com.example.usama.trafficlaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class ViewDetails extends AppCompatActivity {

    private static final String TAG ="VIEWDETAILS" ;
    private TextView Name, Fine, ViolationType, NumberPlate, DateAndTime, Cnic, License, City, Location, DueDate;
    private TextView Speed;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);


        Bundle extras = getIntent().getExtras();

        String value = extras.getString("docID");
        Log.d(TAG, "VALUE OF DOC ID --> " + value);

        Name = (TextView)findViewById(R.id.NameTxtView);
        Fine = (TextView)findViewById(R.id.FineTextView);
        ViolationType = (TextView)findViewById(R.id.ViolationTypeTxtView_Details);
        NumberPlate = (TextView)findViewById(R.id.NumberPlateTxtView_Details);
        DateAndTime = (TextView)findViewById(R.id.DandT_TxtView);
        Cnic = (TextView)findViewById(R.id.cnic_txtview);
        License = (TextView)findViewById(R.id.Licence_TxtView);
        City = (TextView)findViewById(R.id.City_TxtView);
        Location = (TextView)findViewById(R.id.Location_TxtView);
        DueDate = (TextView)findViewById(R.id.DueDate_Details_TxtView);
        Speed = (TextView)findViewById(R.id.Speed_textView);
        DocumentReference noteRef = db.collection("ticket").
                document(DataBindFirestore.getUID()).collection("Tickets").document(value);
        noteRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists())
                        {
                            java.util.Date duedateformserver = documentSnapshot.getTimestamp("DueDate").toDate();

                            java.util.Date violationdatefromserver = documentSnapshot.getTimestamp("DueDate").toDate();
                            String formatter = new SimpleDateFormat("dd-MM-yyyy").format(duedateformserver);
                            String formatter1 = new SimpleDateFormat("dd-MM-yyyy").format(violationdatefromserver);
                            Name.setText(documentSnapshot.getString("Name"));
                            Fine.setText(documentSnapshot.get("Fine").toString());
                            ViolationType.setText(documentSnapshot.getString("ViolationType"));
                            Speed.setText(String.valueOf(documentSnapshot.get("Speed")));
                            DueDate.setText(formatter);
                            Location.setText(documentSnapshot.getString("Location"));
                            NumberPlate.setText(documentSnapshot.getString("NumberPlate"));
                            DateAndTime.setText(formatter1);
                            Cnic.setText(String.valueOf(documentSnapshot.get("Cnic")));
                            License.setText(documentSnapshot.getString("LicenceNo"));
                            City.setText(documentSnapshot.getString("City"));
                        }
                        else
                            {
                                Toast.makeText(ViewDetails.this, "Document Does not exist",Toast.LENGTH_SHORT).show();
                            }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });














////Name Fine ViolationType NumberPlate DueDate  Speed
//        Name = (TextView)findViewById(R.id.NameTxtView);
//        Fine = (TextView)findViewById(R.id.FineTextView);
//        ViolationType = (TextView)findViewById(R.id.ViolationTypeTxtView_Details);
//        NumberPlate = (TextView)findViewById(R.id.NumberPlateTxtView_Details);
//        DateAndTime = (TextView)findViewById(R.id.DandT_TxtView);
//        Cnic = (TextView)findViewById(R.id.cnic_txtview);
//        License = (TextView)findViewById(R.id.Licence_TxtView);
//        City = (TextView)findViewById(R.id.City_TxtView);
//        Location = (TextView)findViewById(R.id.Location_TxtView);
//        DueDate = (TextView)findViewById(R.id.DueDate_Details_TxtView);
//        //Speed = (TextView)findViewById(R.id.Location_TxtView);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            int value = extras.getInt("key_ID");
//            System.out.println(value + " " +"Value of getAdapterPositions");
//
//            this.Name.setText(d.getDataSet().get(value).getName());
//            this.Fine.setText(String.valueOf(d.getDataSet().get(value).getFine()));
//            this.ViolationType.setText(d.getDataSet().get(value).getViolationType());
//            this.NumberPlate.setText(d.getDataSet().get(value).getNumberPlate());
//        //    this.DateAndTime.setText(d.getDataSet().get(value).getViolationDate());
//            //this.Cnic.setText(d.getDataSet().get(value).getCnic());
//            this.Location.setText(d.getDataSet().get(value).getLocation());
//            this.License.setText(d.getDataSet().get(value).getLicenceNo());
//         //   this.DueDate.setText(d.getDataSet().get(value).getDueDate());
//            this.City.setText(d.getDataSet().get(value).getCity());
////            this.Speed.setText(Dashboard.getDataSet().get(value).getSpeed());

        }



    }

