package com.example.usama.trafficlaw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Status extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity_status";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("ticket").
            document(DataBindFirestore.getUID()).collection("Tickets");
    private FirestoreStatus adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        setStatusRecyclerView();

//        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView_status);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new RecyclerViewAdapter_Status(d.getDataSet());
//        mRecyclerView.setAdapter(mAdapter);

    }



    private void setStatusRecyclerView()
    {


        Query query = notebookRef.orderBy("TicketId", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Violation> options = new FirestoreRecyclerOptions.Builder<Violation>()
                .setQuery(query, Violation.class)
                .build();
        adapter = new FirestoreStatus(options);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView_status);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        ((RecyclerViewAdapter_Status) mAdapter).setOnItemClickListener(new RecyclerViewAdapter_Status
//                .MyClickListener() {
//            @Override
//            public void onItemClick(final int position, View v) {
//                Log.i(LOG_TAG, " Clicked on Item " + position);
//
//            }
//        });
//    }
}
