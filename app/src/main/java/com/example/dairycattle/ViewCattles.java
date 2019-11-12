package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewCattles extends AppCompatActivity {

    DatabaseReference databaseCattle;
    ListView ListViewCattle;
    List<Cattle> cattleList;
    Button btnAddCattle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cattles);

        btnAddCattle = (Button)findViewById(R.id.buttonAddCattle);

        databaseCattle= FirebaseDatabase.getInstance().getReference("cattle");

        ListViewCattle= (ListView) findViewById(R.id.ListViewCattle);

        cattleList=new ArrayList<>();

        btnAddCattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAddCattle = new Intent(ViewCattles.this, addCattle.class);
                startActivity(intToAddCattle);
            }
        });



    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseCattle.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                cattleList.clear();

                for(
                        DataSnapshot cattleSnapshot :dataSnapshot.getChildren())

                {
                    //getting farm
                    Cattle cattle = cattleSnapshot.getValue(Cattle.class);
                    //adding farm to the list
                    cattleList.add(cattle);
                }

                CattleList adapters = new CattleList(ViewCattles.this, cattleList);
                ListViewCattle.setAdapter(adapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
