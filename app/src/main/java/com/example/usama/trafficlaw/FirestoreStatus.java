package com.example.usama.trafficlaw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.SimpleDateFormat;

public class FirestoreStatus extends FirestoreRecyclerAdapter<Violation, FirestoreStatus.StatusHolder> {

    private Button btn_status;


    public FirestoreStatus(@NonNull FirestoreRecyclerOptions<Violation> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull StatusHolder holder, int position, @NonNull Violation model) {
        java.util.Date violationdatefromserver = model.getViolationDate().toDate();
        String formatter = new SimpleDateFormat("dd-MM-yyyy").format(violationdatefromserver);

        holder.TicketID.setText(model.getTicketId());
        holder.Fine.setText(String.valueOf(model.getFine()));
        holder.ViolationType.setText(model.getViolationType());
        holder.Location.setText(model.getLocation());
        holder.DateandTime.setText(formatter);
        String in= String.valueOf(position + 1);
        holder.violationNumber.append(in);
        btn_status.setText(model.getStatus());
    }

    @NonNull
    @Override
    public StatusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewstatus,
                parent, false);

        return new StatusHolder(v);
    }

    class StatusHolder extends RecyclerView.ViewHolder
    {
        TextView TicketID, Fine, ViolationType, Location;
        TextView DateandTime;
        TextView violationNumber;

        public StatusHolder(@NonNull View itemView) {
            super(itemView);
            violationNumber  = (TextView) itemView.findViewById(R.id.statusViolation);

            TicketID = (TextView) itemView.findViewById(R.id.ticketIDtextView_status);
            Fine = (TextView)itemView.findViewById(R.id.AmountTextview_status);
            ViolationType = (TextView)itemView.findViewById(R.id.violation_typeTextView_status);
            Location = (TextView)itemView.findViewById(R.id.LocationTextView_status);
            DateandTime = (TextView) itemView.findViewById(R.id.DateTimeTextView_status);

            btn_status = (Button)itemView.findViewById(R.id.button_status);
        }
    }

}
