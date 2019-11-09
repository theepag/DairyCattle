package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerGenres;
    Button buttonAddFarm,btnLogout;

    DatabaseReference databaseFarms;
    ListView ListViewFarms;
    List<Farm> farmList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseFarms= FirebaseDatabase.getInstance().getReference("farms");
        btnLogout = (Button) findViewById(R.id.logout);
        buttonAddFarm = (Button)findViewById(R.id.addFarm);



        buttonAddFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToAddFarm = new Intent(Home.this,addFarm.class);
                startActivity(inToAddFarm);
            }
        });




        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Home.this, MainActivity.class);
                startActivity(intToMain);


            }


        });


        ListViewFarms = (ListView) findViewById(R.id.listViewFarms);

        farmList=new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseFarms.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                farmList.clear();

                for(
                        DataSnapshot farmSnapshot :dataSnapshot.getChildren())

                {
                    //getting farm
                    Farm farm = farmSnapshot.getValue(Farm.class);
                    //adding farm to the list
                    farmList.add(farm);
                }

                FarmList adapter = new FarmList(Home.this, farmList);
                ListViewFarms.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
