package com.example.usama.trafficlaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AllViolations extends AppCompatActivity {

    private static final String TAG = "ALLVIOLATIONS";
    private static String LOG_TAG = "CardViewActivity_allViolations";
    static int size = 0;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("ticket").
            document(DataBindFirestore.getUID()).collection("Tickets");
    private FirestoreAllViolations adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_violations);

        setUpAllViolationRecyclerView();
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_allviolations);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new RecyclerViewAdapter_allViolations(d.getDataSet());
//        mRecyclerView.setAdapter(mAdapter);

        //TextView noNew = (TextView) findViewById(R.id.noViolation);
//        if(d.getDataSet().isEmpty())
//        {
//            noNew.setVisibility(View.VISIBLE);
//        }

    }

    private void setUpAllViolationRecyclerView()
    {
        Query query = notebookRef.orderBy("TicketId", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Violation> options = new FirestoreRecyclerOptions.Builder<Violation>()
                .setQuery(query, Violation.class)
                .build();
        adapter = new FirestoreAllViolations(options);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_allviolations);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        size = adapter.getItemCount();

        adapter.setOnItemClickListener(new FirestoreAllViolations.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int pos) {
                Violation violation = documentSnapshot.toObject(Violation.class);
                String id = documentSnapshot.getId();

                  Intent i = new Intent(AllViolations.this, ViewDetails.class);
                  i.putExtra("docID",id);

                  startActivity(i);

            }
        });


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

}
