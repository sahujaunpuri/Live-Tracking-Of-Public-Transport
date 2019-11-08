package com.example.admin.trial13;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextactivity(View v) {
        startActivity(new Intent(this,MapsActivity.class));
    }
    public void btnLocation(View v) {
        startActivity(new Intent(this,RetrieveMapActivity.class));
    }
    public void btn3(View view) {
        startActivity(new Intent(this,addStops.class));
    }
    public void btn4(View view) {
        startActivity(new Intent(this,addroute.class));
    }
    public void btn5(View view) {
        startActivity(new Intent(this,uploadprofile.class));
    }
    public void btn6(View view) {
        startActivity(new Intent(this,signup.class));
    }
    public void LOGOUT(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this,login.class));
    }

//
//    if (id == R.id.action_log_out) {
//    ref.unauth(); //End user session
//    startActivity(new Intent(MainActivity.this, login.class)); //Go back to home page
//    finish();
//    }


    @Override
    public void onBackPressed() {
// empty so nothing happens
    }
}
