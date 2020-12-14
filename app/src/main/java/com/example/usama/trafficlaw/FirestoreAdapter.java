package com.example.usama.trafficlaw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;


public class FirestoreAdapter extends FirestoreRecyclerAdapter<Violation, FirestoreAdapter.ViolationHolder> {
    private Button btn_pay;


    public FirestoreAdapter(@NonNull FirestoreRecyclerOptions<Violation> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViolationHolder holder, int position, @NonNull Violation model) {

        java.util.Date duedateformserver = model.getDueDate().toDate();

        java.util.Date violationdatefromserver = model.getViolationDate().toDate();
        String formatter = new SimpleDateFormat("dd-MM-yyyy").format(duedateformserver);
        String formatter1 = new SimpleDateFormat("dd-MM-yyyy").format(violationdatefromserver);
        holder.TicketID.setText(model.getTicketId());
        holder.Fine.setText(String.valueOf(model.getFine()));
        holder.ViolationType.setText(model.getViolationType());
        holder.Location.setText(model.getLocation());
        holder.DateandTime.setText(formatter1);
        holder.DueDate.setText(formatter);


        String urlofImage = model.getImageUrl();
        Picasso.get().load(urlofImage).into(holder.img);




    }

    @NonNull
    @Override
    public ViolationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlayout,
                parent, false);

        return new ViolationHolder(v);
    }

    class ViolationHolder extends RecyclerView.ViewHolder
    {

        TextView TicketID, Fine, ViolationType, Location;
        TextView DateandTime;
        TextView DueDate;
        TextView violationNumber;
        ImageView img;
        public ViolationHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.violationImage);
            violationNumber  = (TextView) itemView.findViewById(R.id.textView4);
            TicketID = (TextView) itemView.findViewById(R.id.ticketIDTextView);
            Fine = (TextView)itemView.findViewById(R.id.AmountTextview);
            ViolationType = (TextView)itemView.findViewById(R.id.violation_typeTextView);
            Location = (TextView)itemView.findViewById(R.id.LocationTextView);
            DateandTime = (TextView) itemView.findViewById(R.id.DateandTimeTextView);
            DueDate = (TextView) itemView.findViewById(R.id.Due_DateTextView);
            btn_pay = (Button)itemView.findViewById(R.id.PayBTN);

//            btn_pay.setOnClickListener(new View.OnClickListener() {
//                        public void onClick(View view) {
//
//
////                            Toast.makeText(FirestoreAdapter.this, "Payment ProcessAPI Call" , Toast.LENGTH_SHORT).show();
////                            String value = mod.get(getAdapterPosition()).getTicketId();
////                            String value1 = String.valueOf(mDataset.get(getAdapterPosition()).getFine());
////
////
////                            Intent i = new Intent(context, PaymentOptions.class);
////                            i.putExtra("key_ID",value);
////                            i.putExtra("key_Amount",value1);
////                            System.out.println(getAdapterPosition() + " " +  value);
////                            context.startActivity(i);
//                        }
//                    });

        }
    }
}
