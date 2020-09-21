package com.example.usama.trafficlaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Status extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);


        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView_status);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter_Status(Status.getDataSet());
        mRecyclerView.setAdapter(mAdapter);

    }

    static ArrayList<Violation> getDataSet() {
        ArrayList results = new ArrayList<Violation>();
        for (int index = 0; index < 4; index++) {
            Violation obj = new Violation();
            results.add(index, obj);
        }
        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerViewAdapter_Status) mAdapter).setOnItemClickListener(new RecyclerViewAdapter_Status
                .MyClickListener() {
            @Override
            public void onItemClick(final int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);

            }
        });
    }
}
