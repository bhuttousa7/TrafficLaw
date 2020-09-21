package com.example.usama.trafficlaw;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter_Status extends RecyclerView.Adapter<RecyclerViewAdapter_Status.MyViewHolder> {
    private ArrayList<Violation> mDataset;
    private static RecyclerViewAdapter_Status.MyClickListener myClickListener;
    private Button btn_status;
    Context context;
    private static String LOG_TAG = "MyRecyclerViewAdapter_status";

    public RecyclerViewAdapter_Status(ArrayList<Violation> myDataset) {
        mDataset = myDataset;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardviewstatus, viewGroup, false);
        MyViewHolder dataObjectHolder = new MyViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter_Status.MyViewHolder myViewHolder, int i) {
        myViewHolder.TicketID.setText(mDataset.get(i).getTicketId());
        myViewHolder.Amount.setText(String.valueOf(mDataset.get(i).getAmount()));
        myViewHolder.ViolationType.setText(mDataset.get(i).getViolationType());
        myViewHolder.Location.setText(mDataset.get(i).getLocation());
        myViewHolder.DateandTime.setText(mDataset.get(i).getViolationDate());
        String in= String.valueOf(i + 1);
        myViewHolder.violationNumber.append(in);
        btn_status.setText(mDataset.get(i).getStatus());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TicketID, Amount, ViolationType, Location;
        TextView DateandTime;
        TextView violationNumber;
        public MyViewHolder(@NonNull View itemView )
       {
           super(itemView);
           violationNumber  = (TextView) itemView.findViewById(R.id.statusViolation);
           TicketID = (TextView) itemView.findViewById(R.id.ticketIDtextView_status);
           Amount = (TextView)itemView.findViewById(R.id.AmountTextview_status);
           ViolationType = (TextView)itemView.findViewById(R.id.violation_typeTextView_status);
           Location = (TextView)itemView.findViewById(R.id.LocationTextView_status);
           DateandTime = (TextView) itemView.findViewById(R.id.DateTimeTextView_status);

           btn_status = (Button)itemView.findViewById(R.id.button_status);

           Log.i(LOG_TAG, "Adding Listener");
           itemView.setOnClickListener(RecyclerViewAdapter_Status.MyViewHolder.this);
           context = itemView.getContext();
       }

        @Override
        public void onClick(View view) {
            myClickListener.onItemClick(getAdapterPosition(), view);
        }
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
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }
}
