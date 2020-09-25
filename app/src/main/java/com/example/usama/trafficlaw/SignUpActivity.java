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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    private EditText userName, email, password, confirmPassword, Phone;
    private Button signUpBtn;
    FirebaseAuth auth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        userName = (EditText) findViewById(R.id.userNameSignUp);

        email = (EditText) findViewById(R.id.Email);

        password = (EditText) findViewById(R.id.passwordSignUp);

        confirmPassword = (EditText) findViewById(R.id.password2);

        Phone = (EditText) findViewById(R.id.Phone);

        signUpBtn = (Button) findViewById(R.id.SignUpBtn);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String user = userName.getText().toString().trim();
                String pass1 =confirmPassword.getText().toString().trim();
                String phoneNumber = Phone.getText().toString().trim();

                //Check Empty for UserName
                if (TextUtils.isEmpty(user)) {
                    userName.setError("Please Enter UserName");
                    return;
                }

                //Check Empty for Phone Number
                if (TextUtils.isEmpty(phoneNumber)) {
                    Phone.setError("Please Enter Phone Number");
                    return;
                }

                //Check Empty Field for Mail
                if (TextUtils.isEmpty(mail)) {
                    email.setError("Please Enter Email");
                    return;
                }

                //Check Empty Field for Password
                if (TextUtils.isEmpty(pass) )  {
                    password.setError("Please Enter Password");
                    return;
                }
                //Check Empty Field for Confirm Password
                if (TextUtils.isEmpty(pass1) )  {
                    confirmPassword.setError("Please Enter Password");
                    return;
                }
                if(!TextUtils.equals(pass,pass1))
                {
                    confirmPassword.setError("Passwords do not match");
                }
                progressBar.setVisibility(View.VISIBLE);


                auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUpActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                            Intent i =new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(i);

                            finish();
                        }
                        else
                        {
                            String excep = task.getException().getMessage();
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            System.out.println(excep);
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            hideProgressBar();
                        }

                    }
                });


            }
        });

    }
    public void hideProgressBar() {
        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
