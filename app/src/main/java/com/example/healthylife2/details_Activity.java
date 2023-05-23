package com.example.healthylife2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class details_Activity extends AppCompatActivity {
    Button submitBtn;
    EditText currentWeight, height, goalWeight;
    DBHelper myDB;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        currentWeight = findViewById(R.id.currentWeighTxt);
        height = findViewById(R.id.heightTxt);
        goalWeight = findViewById(R.id.goalWeightTxt);
        submitBtn = findViewById(R.id.submitButton);

        myDB = new DBHelper(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("personalDetails");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = currentWeight.getText().toString();
                String heights = height.getText().toString();
                String goal = goalWeight.getText().toString();

                // Save data to Firebase
                PersonalDetail personalDetail = new PersonalDetail(current, heights, goal);
                String detailId = databaseReference.push().getKey();
                databaseReference.child(detailId).setValue(personalDetail);

                Boolean regResult = myDB.insertPersonalDetail(current, heights, goal);
                if (regResult) {
                    Toast.makeText(details_Activity.this, "Your Detail Saved Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(details_Activity.this, home11.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(details_Activity.this, "Your Detail Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
