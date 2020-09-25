package com.example.usama.trafficlaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AllViolations extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity_allViolations";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_violations);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_allviolations);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter_allViolations(Dashboard.getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        TextView noNew = (TextView) findViewById(R.id.noViolation);
        if(Dashboard.getDataSet().isEmpty())
        {
            noNew.setVisibility(View.VISIBLE);
        }

    }
    protected void onResume() {
        super.onResume();
        ((RecyclerViewAdapter_allViolations) mAdapter).setOnItemClickListener(new RecyclerViewAdapter_allViolations.MyClickListener() {
            @Override
            public void onItemClick(final int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);

            }
        });
    }
}
