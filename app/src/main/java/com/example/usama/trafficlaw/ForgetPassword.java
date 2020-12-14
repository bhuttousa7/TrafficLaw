package com.example.usama.trafficlaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private static final String TAG = "Forgot";
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        Button btn_forgot = (Button) findViewById(R.id.btn_forgot);
        editText = (EditText) findViewById(R.id.forgotPass);
        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st = editText.getText().toString().trim();


                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (TextUtils.isEmpty(st)) {
                    Toast.makeText(getApplicationContext(), "Enter your email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.sendPasswordResetEmail(st)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {

                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent.");
                                    Toast.makeText(ForgetPassword.this, "Check Email to Follow Instructions", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Log.d(TAG,"Failed To send Email");
                                    Toast.makeText(ForgetPassword.this, "Failed To send Email", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });


    }
}
