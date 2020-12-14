package com.example.usama.trafficlaw;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class FirestoreAllViolations extends FirestoreRecyclerAdapter<Violation, FirestoreAllViolations.AllViolationHolder> {

    private OnItemClickListener listener;
    private static final String TAG = "AllViolations";
    Context context;

    public int size;
    public FirestoreAllViolations(@NonNull FirestoreRecyclerOptions<Violation> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull AllViolationHolder holder, int position, @NonNull Violation model) {
        holder.TicketID.setText(model.getTicketId());
        holder.Fine.setText(String.valueOf(model.getFine()));
        holder.ViolationType.setText(model.getViolationType());

        String documentId = getSnapshots().getSnapshot(position).getId();
        DocumentSnapshot snapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());

        Log.d(TAG, documentId + " DOC ID OF CLICKED ---> " + snapshot);


    }

    @NonNull
    @Override
    public AllViolationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.allviolationscardview,
                parent, false);
        return new AllViolationHolder(v);
    }

    class AllViolationHolder extends RecyclerView.ViewHolder
    {
        TextView TicketID, Fine, ViolationType;
        private Button btn_view;

        public AllViolationHolder(@NonNull View itemView) {
            super(itemView);
            btn_view = (Button)itemView.findViewById(R.id.viewDetails);


            TicketID = (TextView) itemView.findViewById(R.id.ticketIDtextView_allviolations);
            Fine = (TextView)itemView.findViewById(R.id.AmountTextview_allviolations);
            ViolationType = (TextView)itemView.findViewById(R.id.violation_typeTextView_allviolations);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null)
                    {
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);


                    }
                }
            });



        }
    }
    public interface OnItemClickListener {
        public void onItemClick(DocumentSnapshot documentSnapshot, int pos);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {

        this.listener = listener;
    }
}
