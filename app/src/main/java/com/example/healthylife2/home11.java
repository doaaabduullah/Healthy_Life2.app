package com.example.healthylife2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home11 extends AppCompatActivity {
    Button move, button, Move2, Move3;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home11);

        move = findViewById(R.id.Move);
        button = findViewById(R.id.TestButton);
        Move2 = findViewById(R.id.Move22);
        Move3 = findViewById(R.id.Move3);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home11.this, mineActivity_nav.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home11.this, medication_Activity2.class);
                startActivity(intent);
            }
        });

        Move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home11.this, details_Activity.class);
                startActivity(intent);
            }
        });

        Move3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home11.this, feedback_Activity2.class);
                startActivity(intent);
            }
        });
    }
}
