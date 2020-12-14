package com.example.usama.trafficlaw;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

//Login Activity

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    private TextView signUp;
    private EditText username, password;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    ArrayList<Violation> arrayList = new ArrayList<>();

    public void clickonTextView(View view)
    {
        Intent i =new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(i);


    }

    public  void ClickonTxtForgot(View view)
    {
        Intent i =new Intent(MainActivity.this,ForgetPassword.class);
        startActivity(i);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        username = (EditText) findViewById(R.id.username);

        password = (EditText) findViewById(R.id.Password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        Button SigninButton = (Button) findViewById(R.id.Loginbtn);


        SigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(pass))
                {
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
                }
                else
                    {
                        progressBar.setVisibility(View.VISIBLE);

                        mAuth.signInWithEmailAndPassword(userName,pass).
                                addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful())
                                        {

                                            Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                                            final FirebaseUser user = mAuth.getInstance().getCurrentUser();
                                            final String value= user.getEmail();

                                            Intent i = new Intent(MainActivity.this, Dashboard.class);

                                            i.putExtra("key",value);
                                            startActivity(i);
                                            progressBar.setVisibility(View.GONE);

//                                            //Get All Documents from firestore, save in Arraylist and pass to other activity through intent
//                                            FirebaseFirestore db = FirebaseFirestore.getInstance();
//                                            CollectionReference notebookRef = db.collection("ticket").
//                                                    document(DataBindFirestore.getUID()).collection("Tickets");
//                                            notebookRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                    for (QueryDocumentSnapshot document : task.getResult())
//                                                    {
//                                                        Log.d(TAG, document.getId() + in +" => " + document.getData());
////                                                        arrayList.add(in, new Violation(
////                                                                document.getId().toString(),
////                                                                document.get("Name").toString(),
////                                                                document.getLong("Speed").intValue(),
////                                                                document.getDate("DueDate").toString(),
////                                                                document.get("NumberPlate").toString(),
////                                                                document.get("ViolationType").toString(),
////                                                                document.getLong("Fine").intValue(),
////                                                                document.get("Location").toString()
////                                                        ));
//                                                        in +=1;
//
//                                                    }
//
//                                                }
//                                            });


// TO CREATE OWN INTERFACE FOR ONCOMPLETE DATA GET
//                                            d.readData(new MyCallBack() {
//                                                ArrayList<Violation> violations ;
//
//                                                @Override
//                                                public ArrayList<Violation> onCallback(ArrayList<Violation> results) {
//                                                    Log.d(TAG, results.toString());
//                                                    System.out.println(results.get(0).getName() + "Whole Fucking DATA W");
//                                                    violations =  new ArrayList<>(results);
//                                                    System.out.println(violations.get(0).getName() + "Whole Fucking DATA V");
//
//                                                    return results;
//                                                }
//
//                                            });


                                        }
                                        else
                                            {
                                                Log.w(TAG, "signInWithEmail:failure", task.getException());

                                                Toast.makeText(MainActivity.this, "Authentication failed." + task.getException().getMessage() ,
                                                        Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);

                                            }
                                    }
                                });

                    }


            }
        });





    }


}
