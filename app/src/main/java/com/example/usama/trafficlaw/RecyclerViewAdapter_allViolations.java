package com.example.usama.trafficlaw;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter_allViolations extends RecyclerView.Adapter<RecyclerViewAdapter_allViolations.MyViewHolder> {
    private ArrayList<Violation> mDataset;
    private static RecyclerViewAdapter_allViolations.MyClickListener myClickListener;
    private Button btn_status;
    Context context;
    private static String LOG_TAG = "MyRecyclerViewAdapter_allViolations";

    public RecyclerViewAdapter_allViolations(ArrayList<Violation> myDataset) {mDataset = myDataset; }


    @NonNull
    @Override
    public RecyclerViewAdapter_allViolations.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.allviolationscardview, viewGroup, false);
        RecyclerViewAdapter_allViolations.MyViewHolder dataObjectHolder = new RecyclerViewAdapter_allViolations.MyViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter_allViolations.MyViewHolder myViewHolder, int i) {
        myViewHolder.TicketID.setText(mDataset.get(i).getTicketId());
        myViewHolder.Amount.setText(String.valueOf(mDataset.get(i).getAmount()));
        myViewHolder.ViolationType.setText(mDataset.get(i).getViolationType());
        String in= String.valueOf(i + 1);
        myViewHolder.violationNumber.append(in);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView TicketID, Amount, ViolationType;
        TextView violationNumber;
        private Button btn_view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            violationNumber  = (TextView) itemView.findViewById(R.id.violationNumber_allviolations);
            TicketID = (TextView) itemView.findViewById(R.id.ticketIDtextView_allviolations);
            Amount = (TextView)itemView.findViewById(R.id.AmountTextview_allviolations);
            ViolationType = (TextView)itemView.findViewById(R.id.violation_typeTextView_allviolations);

            btn_view = (Button)itemView.findViewById(R.id.viewDetails);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(RecyclerViewAdapter_allViolations.MyViewHolder.this);
            context = itemView.getContext();

            btn_view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent i = new Intent(context, ViewDetails.class);
                    i.putExtra("key_ID",getAdapterPosition());
                    context.startActivity(i);

                }
            });
        }

        @Override
        public void onClick(View view) {
            myClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
    public void setOnItemClickListener(RecyclerViewAdapter_allViolations.MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }
    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
    public void addItem(Violation dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }
    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

}
