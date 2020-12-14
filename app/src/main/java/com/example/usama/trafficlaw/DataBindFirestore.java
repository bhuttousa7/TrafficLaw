package com.example.usama.trafficlaw;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DataBindFirestore {

    String UID;

    private static final String Name_KEY = "Name";
    private static String TAG = "DATABIND";

    public DataBindFirestore()
    {


    }

    static public String getUID()
    {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        System.out.println("Current User ID " +uid + " Current User Name " + FirebaseAuth.getInstance().getCurrentUser().getEmail());
        return uid;
    }




//    public void readData (final MyCallBack myCallBack)
//    {
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("ticket").document(DataBindFirestore.getUID()).collection("Tickets").get().
//                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    int i = 0 ;
//                    ArrayList<Violation> results = new ArrayList<Violation>();
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            //Check if there are no docs
//                            if(task.getResult().isEmpty())
//                            {
//                                Log.d(TAG, "No Documents ");
//                            }
//                            else {
//                                for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                    Log.d(TAG, document.getId() + i +" => " + document.getData());
//                                    Log.d(TAG, document.getString("Name"));
//                                    Log.d(TAG, document.get("Fine").toString());
//
//                                    Object o = document.getData();
//                                    Log.d(TAG,o.toString());
//                                    //System.out.println(o.toString());
//
//                                    results.add(i, new Violation(
//                                            document.getId().toString(),
//                                            document.get("Name").toString(),
//                                            document.getLong("Speed").intValue(),
//                                            document.getDate("DueDate").toString(),
//                                            document.get("NumberPlate").toString(),
//                                            document.get("ViolationType").toString(),
//                                            document.getLong("Fine").intValue(),
//                                            document.get("Location").toString()
//                                    ));
//                                    i += 1 ;
//                                    //System.out.println("Data: -->>>>" + results.get(0).getName());
//
////                                    finalresults = new ArrayList<>(results) ;
////                                    //System.out.println("Final Results Data: -->>>>" + finalresults.get(0).getName().toString());
//
//                                }
//                                myCallBack.onCallback(results);
//
//
//                            }
//
//                        }
//
//                        else {
//                            Log.w(TAG, "Error getting documents.", task.getException());
//                        }
//                    }
//
//
//                });
//
//    }
}
