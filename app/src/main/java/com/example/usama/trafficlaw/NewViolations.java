package com.example.usama.trafficlaw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class NewViolations extends AppCompatActivity {
    private static String LOG_TAG = "CardViewActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("ticket").document(DataBindFirestore.getUID()).collection("Tickets");
    private FirestoreAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_violations);
        setUpRecyclerView();

//        mAdapter = new RecyclerViewAdapter(d.getDataSet());

        //TextView noNew = (TextView) findViewById(R.id.NoNewViolation);
//        if(d.getDataSet().isEmpty())
//        {
//            noNew.setVisibility(View.VISIBLE);
//        }



    }
    private void setUpRecyclerView()
    {
        Query query = notebookRef.orderBy("TicketId", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Violation> options = new FirestoreRecyclerOptions.Builder<Violation>()
            .setQuery(query, Violation.class)
            .build();
        adapter = new FirestoreAdapter(options);
         RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);




    }

    @Override
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
