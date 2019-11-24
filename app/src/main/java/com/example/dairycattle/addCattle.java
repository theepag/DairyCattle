package com.example.dairycattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addCattle extends AppCompatActivity {

    EditText editTextCattleTagId,editTextCattleDOB,editTextCattleSpecialFeature,editTextCattleSex,editTextCattleNoOfLactation,editTextFarmBirthWeight,editTextCattleBreedingWeight,editTextCattleWeaningWeight,editTextCattleAveragePreWeaningGrowthRate,editTextCattleAveragePostWeaningGrowthRate,editTextCattleLastCalvingDate,editTextCattleBreed;
    Button btnAddCattle;
    DatabaseReference databaseCattle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cattle);




        databaseCattle= FirebaseDatabase.getInstance().getReference("cattle");



        editTextCattleTagId = (EditText) findViewById(R.id.editTextCattleTagId);
        editTextCattleDOB = (EditText) findViewById(R.id.editTextCattleDOB);
        editTextCattleSpecialFeature = (EditText) findViewById(R.id.editTextCattleSpeacialFeature);
        editTextCattleSex = (EditText) findViewById(R.id.editTextCattleSex);
        editTextCattleNoOfLactation = (EditText)findViewById(R.id.editTextCattleNoOfLactation);
        editTextFarmBirthWeight = (EditText) findViewById(R.id.editTextFarmBirthWeight);
        editTextCattleBreedingWeight = (EditText) findViewById(R.id.editTextCattleBreedingWeight);
        editTextCattleWeaningWeight = (EditText) findViewById(R.id.editTextCattleWeaningWeight);
        editTextCattleAveragePreWeaningGrowthRate = (EditText)findViewById(R.id.editTextCattleAveragePreWeaningGrowthRate);
        editTextCattleAveragePostWeaningGrowthRate =(EditText)findViewById(R.id.editTextCattleAveragePostWeaningGrowthRate);
        editTextCattleLastCalvingDate =(EditText)findViewById(R.id.editTextCattleLastCalvingDate);
        editTextCattleBreed = (EditText)findViewById(R.id.editTextCattleBreed);




        btnAddCattle = (Button) findViewById(R.id.btnAddCattle);

        btnAddCattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCattle();

            }
        });


    }

    private void addCattle(){

        String CattleTAGID= editTextCattleTagId.getText().toString().trim();
        String CattleDateOfBirth = editTextCattleDOB.getText().toString().trim();
        String CattleBreed =editTextCattleBreed.getText().toString().trim();
        String CattleSpecialFeature = editTextCattleSpecialFeature.getText().toString().trim();
        String CattleSex = editTextCattleSex.getText().toString().trim();
        String CattleNoOfLactation = editTextCattleNoOfLactation.getText().toString().trim();
        String CattleBirthWeight= editTextFarmBirthWeight.getText().toString().trim() ;
        String BreedingWeight = editTextCattleBreedingWeight.getText().toString();
        String CattleWeaningWeight = editTextCattleWeaningWeight.getText().toString();
        String CattleAveragePreWeaningGrowthRate = editTextCattleAveragePreWeaningGrowthRate.getText().toString();
        String CattleAveragePostWeaningGrowthRate = editTextCattleAveragePostWeaningGrowthRate.getText().toString();
        String CattleLastCalvingDate = editTextCattleBreed.getText().toString();




        if (!TextUtils.isEmpty(CattleDateOfBirth)||!TextUtils.isEmpty(CattleBreed)||!TextUtils.isEmpty(CattleSpecialFeature)||!TextUtils.isEmpty(CattleSex)||!TextUtils.isEmpty(CattleNoOfLactation)||!TextUtils.isEmpty(CattleBirthWeight)) {

            String CattleID = databaseCattle.push().getKey();

            //creating an Artist Object
            Bundle bundle = getIntent().getExtras();


            String FarmID = bundle.getString("farmid");
            Cattle cattle = new Cattle(CattleID,CattleTAGID,FarmID,CattleDateOfBirth,CattleBreed,CattleSpecialFeature,CattleSex,CattleNoOfLactation,CattleBirthWeight,BreedingWeight,CattleWeaningWeight,CattleAveragePreWeaningGrowthRate,CattleAveragePostWeaningGrowthRate,CattleLastCalvingDate);
            databaseCattle.child(CattleID).setValue(cattle);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Farm Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(addCattle.this, ViewCattles.class);




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
}
