package com.example.admin.trial13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addStops extends AppCompatActivity {

    EditText laystopname,laystoplat,laystoplng;
    String stname;
    Double stlat,stlng;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stops);
        laystopname = (EditText) findViewById(R.id.stopname);
        laystoplat = (EditText) findViewById(R.id.stoplat);
        laystoplng = (EditText) findViewById(R.id.stoplng);

        databaseReference= FirebaseDatabase.getInstance().getReference("stopnames");
    }
    public void addtofirebase(View v) {
        stname=laystopname.getText().toString().trim();
        stlat=Double.parseDouble(laystoplat.getText().toString());
        stlng=Double.parseDouble(laystoplng.getText().toString());
        databaseReference.push().setValue(stname).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                laystopname.setText("");
                laystoplat.setText("");
                laystoplng.setText("");
                Toast.makeText(addStops.this, "data inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
