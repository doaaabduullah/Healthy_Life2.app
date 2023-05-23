package com.example.healthylife2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback_Activity2 extends AppCompatActivity {
    private RatingBar ratingBar;
    private EditText feedbackTxt;
    private Button sendFeedBackBtn;
    private TextView ratingTextView;
    private DatabaseReference feedbackRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback2);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);
        feedbackRef = FirebaseDatabase.getInstance().getReference("feedback");

        ratingBar = findViewById(R.id.ratingBar);
        feedbackTxt = findViewById(R.id.feedbackTxt);
        sendFeedBackBtn = findViewById(R.id.sendFeedBackBtn);
        ratingTextView = findViewById(R.id.rating_text_view);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTextView.setText(String.valueOf(rating));
            }
        });
        ratingBar.setRating(3.5f);

        sendFeedBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String RB = ratingTextView.getText().toString();
                String RTxt = feedbackTxt.getText().toString();

                String feedbackId = feedbackRef.push().getKey();
                Feedback feedback = new Feedback(RB, RTxt);

                feedbackRef.child(feedbackId).setValue(feedback)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(feedback_Activity2.this, "Feedback Saved Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(feedback_Activity2.this, home11.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(feedback_Activity2.this, "Feedback Saved Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    public static class Feedback {
        private String rating;
        private String feedbackText;

        public Feedback() {
            // Default constructor required for Firebase
        }

        public Feedback(String rating, String feedbackText) {
            this.rating = rating;
            this.feedbackText = feedbackText;
        }

        public String getRating() {
            return rating;
        }

        public String getFeedbackText() {
            return feedbackText;
        }
    }
}
