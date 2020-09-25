package com.example.usama.trafficlaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDetails extends AppCompatActivity {

    private TextView Name, Fine, ViolationType, NumberPlate, DateAndTime, Cnic, License, City, Location, DueDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);


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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("key_ID");
            System.out.println(value + " " +"Value of getAdapterPositions");
            this.Name.setText(Dashboard.getDataSet().get(value).getName());
            this.Fine.setText(String.valueOf(Dashboard.getDataSet().get(value).getAmount()));
            this.ViolationType.setText(Dashboard.getDataSet().get(value).getViolationType());
            this.NumberPlate.setText(Dashboard.getDataSet().get(value).getNumberPlate());
            this.DateAndTime.setText(Dashboard.getDataSet().get(value).getViolationDate());
            this.Cnic.setText(Dashboard.getDataSet().get(value).getCnic());
            this.Location.setText(Dashboard.getDataSet().get(value).getLocation());
            this.License.setText(Dashboard.getDataSet().get(value).getLicenceNo());
            this.DueDate.setText(Dashboard.getDataSet().get(value).getDueDate());
            this.City.setText(Dashboard.getDataSet().get(value).getCity());

        }



    }
}
