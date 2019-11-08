package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    Button btnLogout,btnfarmlist;

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    ListView listViewFarms;
    DatabaseReference databaseFarm;
    List<Farm> farmList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        databaseFarm= FirebaseDatabase.getInstance().getReference("farms");


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Home.this, MainActivity.class);
                startActivity(intToMain);


            }


        });

        listViewFarms = (ListView) findViewById(R.id.listViewFarms);
        farmList = new ArrayList<>();


    }


    @Override
    protected void onStart() {
        super.onStart();


        databaseFarm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                farmList.clear();
                for(DataSnapshot farmSnapShot: dataSnapshot.getChildren()) {

                    Farm farm = farmSnapShot.getValue(Farm.class);
                    farmList.add(farm);

                }
                FarmList adapter = new FarmList(Home.this,farmList);
                listViewFarms.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void toAddFarm (View view) {
        startActivity(new Intent(this, addFarm.class));
    }



}