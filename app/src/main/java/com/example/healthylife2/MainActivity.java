package com.example.healthylife2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText username, password, repassword, phone;
    Button btnSignIn, btnSignUp;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.confirmPassword);
        btnSignIn = findViewById(R.id.button);
        btnSignUp = findViewById(R.id.button2);
        phone = findViewById(R.id.phone);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setTitle("Register");
                }

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String pho = phone.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        // Get a reference to the Firebase database
                        DatabaseReference usersRef = database.getReference("users");

                        // Create a new child node in the "users" table
                        DatabaseReference userRef = usersRef.child(user);

                        // Create a data object with the user's details
                        Map<String, Object> userData = new HashMap<>();
                        userData.put("username", user);
                        userData.put("password", pass);
                        userData.put("phone", pho);

                        // Set the data for the user
                        userRef.setValue(userData);

                        Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, home11.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Password not matching.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
