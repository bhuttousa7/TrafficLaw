package com.example.usama.trafficlaw;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Violation> mDataset;
    private static MyClickListener myClickListener;


    private static String LOG_TAG = "MyRecyclerViewAdapter";

    //Constructor for Class
    public RecyclerViewAdapter(ArrayList<Violation> myDataset) {
        mDataset = myDataset;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardviewlayout, viewGroup, false);
        MyViewHolder dataObjectHolder = new MyViewHolder(view);
        return dataObjectHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.TicketID.setText(mDataset.get(i).getTicketId());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
                TextView TicketID;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    TicketID = (TextView) itemView.findViewById(R.id.ticketIDTextView);
                    Log.i(LOG_TAG, "Adding Listener");
                    itemView.setOnClickListener(MyViewHolder.this);
                }

                @Override
                public void onClick(@NonNull View v) {
                    myClickListener.onItemClick(getAdapterPosition(), v);
                }


        }

    public void setOnItemClickListener(MyClickListener myClickListener) {
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


