package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewPage extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerGenres;
    Button buttonAddFarm;

   DatabaseReference databaseFarms;
   ListView ListViewFarms;
    List<Farm> farmList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        databaseFarms= FirebaseDatabase.getInstance().getReference("farms");





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

                FarmList adapter = new FarmList(NewPage.this, farmList);
                ListViewFarms.setAdapter(adapter);
        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addFarm() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            String id = databaseFarms.push().getKey();

            //creating an Farm Object
            Farm farm = new Farm(id,name," "," "," "," "," "," ","");
            databaseFarms.child(id).setValue(farm);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Farm added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
