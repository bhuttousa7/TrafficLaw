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
import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Violation> mDataset;
    private static MyClickListener myClickListener;
    private Button btn_pay;
    Context context;


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
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.TicketID.setText(mDataset.get(i).getTicketId());
        myViewHolder.Amount.setText(String.valueOf(mDataset.get(i).getAmount()));
        myViewHolder.ViolationType.setText(mDataset.get(i).getViolationType());
        myViewHolder.Location.setText(mDataset.get(i).getLocation());
        myViewHolder.DateandTime.setText(mDataset.get(i).getViolationDate());
        myViewHolder.DueDate.setText(mDataset.get(i).getDueDate());
        String in= String.valueOf(i + 1);
        myViewHolder.violationNumber.append(in);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
                TextView TicketID, Amount, ViolationType, Location;
                TextView DateandTime;
                TextView DueDate;
                TextView violationNumber;
                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    violationNumber  = (TextView) itemView.findViewById(R.id.textView4);
                    TicketID = (TextView) itemView.findViewById(R.id.ticketIDTextView);
                    Amount = (TextView)itemView.findViewById(R.id.AmountTextview);
                    ViolationType = (TextView)itemView.findViewById(R.id.violation_typeTextView);
                    Location = (TextView)itemView.findViewById(R.id.LocationTextView);
                    DateandTime = (TextView) itemView.findViewById(R.id.DateandTimeTextView);
                    DueDate = (TextView) itemView.findViewById(R.id.Due_DateTextView);
                    btn_pay = (Button)itemView.findViewById(R.id.PayBTN);

                    Log.i(LOG_TAG, "Adding Listener");
                    itemView.setOnClickListener(MyViewHolder.this);
                    context = itemView.getContext();

                    btn_pay.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            String value = mDataset.get(getAdapterPosition()).getTicketId();
                            String value1 = String.valueOf(mDataset.get(getAdapterPosition()).getAmount());


                            Intent i = new Intent(context, PaymentOptions.class);
                            i.putExtra("key_ID",value);
                            i.putExtra("key_Amount",value1);
                            System.out.println(getAdapterPosition() + " " +  value);
                            context.startActivity(i);
                        }
                    });

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


