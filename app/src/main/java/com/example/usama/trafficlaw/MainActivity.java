package com.example.usama.trafficlaw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

//Login Activity

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    private TextView signUp;
    private EditText username, password;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    public void clickonTextView(View view)
    {
        Intent i =new Intent(MainActivity.this,SignUpActivity.class);
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
                                            progressBar.setVisibility(View.GONE);
                                            Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                                            FirebaseUser user = mAuth.getCurrentUser();

                                               // user.getDisplayName();
                                                System.out.println("Name of User" + user.getDisplayName());
//                                                TextView tx= (TextView) findViewById(R.id.TitleofUser);
//                                                tx.append(" " + user.getDisplayName());
                                            String value= user.getDisplayName();
                                            Intent i = new Intent(MainActivity.this, Dashboard.class);
                                            i.putExtra("key",value);
                                            startActivity(i);

//
//                                            Intent i =new Intent(MainActivity.this,Dashboard.class);
//                                            startActivity(i);
                                        }
                                        else
                                            {
                                                Log.w(TAG, "signInWithEmail:failure", task.getException());

                                                System.out.println("Reason of SIgn in Fail " + task.getException().getMessage());
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
