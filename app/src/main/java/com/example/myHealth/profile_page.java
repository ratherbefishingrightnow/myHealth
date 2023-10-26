package com.example.myHealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class profile_page extends AppCompatActivity {


    TextView firstNameTitle;
    TextView emailPlaceholder, firstnamePlaceholder, lastnamePlaceholder, phonePlaceholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);


        firstNameTitle = findViewById(R.id.firstNameTitle);
        emailPlaceholder = findViewById(R.id.emailPlaceholder);
        firstnamePlaceholder = findViewById(R.id.firstnamePlaceholder);
        lastnamePlaceholder = findViewById(R.id.lastnamePlaceholder);
        //phonePlaceholder = phonePlaceholder(R.id.phonePlaceholder);



        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set profile selected
        bottomNavigationView.setSelectedItemId(R.id.profileId);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                //check id
                if (id == R.id.appointmentId) {
                    startActivity(new Intent(getApplicationContext(), appointments_page.class));
                    finish();
                    return true;
                } else if (id == R.id.homeId) {
                    startActivity(new Intent(getApplicationContext(), home_page.class)); //check this line it might be wrong
                    finish();
                    return true;
                } else if (id == R.id.medicalHistId) {
                    startActivity(new Intent(getApplicationContext(), medical_records_page.class));
                    finish();
                    return true;
                } else if (id == R.id.resourcesId) {
                    startActivity(new Intent(getApplicationContext(), resources_page.class));
                    finish();
                    return true;
                } else if (id == R.id.profileId) {
                    return true;
                }
                return false;
            }

        });

        // Create button object, id from profile_page.xml
        Button lg_out_btn = findViewById(R.id.button_patient_log_out);

        // Add button functionality with this method
        lg_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth mAuth = myFirestore.getmAuthInstance();
                mAuth.signOut();

                // Start the LoginActivity (or any other activity you want to go to)
                Intent intent = new Intent(getApplicationContext(), login_page.class);
                startActivity(intent);

                // Optionally, finish the current activity to prevent the user from going back to it
                finish();
            }
        });
    }

    public void showUserInfo () {
        Intent intent = new Intent(getApplicationContext(), home_page.class);



    }
    
}