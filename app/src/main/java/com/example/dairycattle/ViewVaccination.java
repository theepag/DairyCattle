package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewVaccination extends AppCompatActivity {

    DatabaseReference databaseVaccine;
    ListView ListViewVaccine;
    List<Vaccine> vaccineList;
    Button btnAddVaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vaccination);



        btnAddVaccine = (Button) findViewById(R.id.buttonAddVacc);


        databaseVaccine = FirebaseDatabase.getInstance().getReference("vaccine");

        ListViewVaccine = (ListView) findViewById(R.id.listViewVaccine);

        vaccineList = new ArrayList<>();

        btnAddVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAddVaccine = new Intent(ViewVaccination.this, AddVaccine.class);
                startActivity(intToAddVaccine);

                Bundle bundles = new Bundle();
                String m = getCattleID();
                bundles.putString("cattleID", m);
                intToAddVaccine.putExtras(bundles);
                startActivity(intToAddVaccine);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseVaccine.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                vaccineList.clear();

                for (
                        DataSnapshot vaccineSnapshot : dataSnapshot.getChildren()) {
                    //getting farm
                    Vaccine vaccine = vaccineSnapshot.getValue(Vaccine.class);
                    String k = getCattleID();
                    if (vaccine.CattleVaccineID.equals(k)) {

                        vaccineList.add(vaccine);

                    }
                    //adding farm to the list

                }

                VaccineList adapters = new VaccineList(ViewVaccination.this, vaccineList);
                ListViewVaccine.setAdapter(adapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public String getCattleID() {
        Bundle bundle = getIntent().getExtras();


        String stuff = bundle.getString("cattleID");
        return stuff;
    }
}

