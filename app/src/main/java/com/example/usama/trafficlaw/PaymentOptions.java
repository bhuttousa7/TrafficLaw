package com.example.usama.trafficlaw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentOptions extends AppCompatActivity {

    private TextView subTotal, TotalAmount, TicketID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);


        TicketID= (TextView) findViewById(R.id.ticket_paymentTextView);
        subTotal= (TextView) findViewById(R.id.subAmountTextView);
        TotalAmount= (TextView) findViewById(R.id.totalAmountTextView);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key_ID");
            String value1= extras.getString("key_Amount");
            TicketID.setText(value.toUpperCase());
            subTotal.setText(value1);
            TotalAmount.append(value1);


        }

    }
}
