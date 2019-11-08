package com.example.admin.trial13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText jlemail,jlpass;
    Button lbtn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(login.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            // User is signed out
            Log.d(TAG, "onAuthStateChanged:signed_out");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        jlemail=findViewById(R.id.xmllemail);
        jlpass=findViewById(R.id.xmllpass);
        lbtn=findViewById(R.id.xmllbtn);
        firebaseAuth=FirebaseAuth.getInstance();

        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = jlemail.getText().toString().trim();
                String pass = jlpass.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(login.this, "please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(login.this, "please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.length()<6)
                {
                    Toast.makeText(login.this, "password length should be more than 6", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Toast.makeText(login.this, "login success", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }


    public void gotoreg(View view) {
        startActivity(new Intent(this,signup.class));
    }
}
