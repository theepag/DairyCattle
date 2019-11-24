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

public class AddDisease extends AppCompatActivity {
    EditText editTextDate,editTextClinicalSign,editTextTypeOfClinicalSign,editTextDiagnosis,editTextTreatment,editTextRemarks,editTextNameOfVeterinarian;
    Button buttonAddDisease;
    DatabaseReference databaseDisease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disease);


        databaseDisease= FirebaseDatabase.getInstance().getReference("disease");



        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextClinicalSign = (EditText) findViewById(R.id.editTextClinicalSign);
        editTextTypeOfClinicalSign = (EditText) findViewById(R.id.editTextTypeOfClinicalSign);
        editTextDiagnosis = (EditText) findViewById(R.id.editTextDiagnosis);
        editTextTreatment = (EditText)findViewById(R.id.editTextTreatment);
        editTextRemarks = (EditText) findViewById(R.id.editTextRemarks);
        editTextNameOfVeterinarian = (EditText) findViewById(R.id.editTextNameOfVeterinarian);





        buttonAddDisease = (Button) findViewById(R.id.buttonAddBreeding);

        buttonAddDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addDisease();

            }
        });


    }

    private void addDisease(){

        String DiseaseDate = editTextDate.getText().toString().trim();
        String DiseaseClinicalSigns = editTextClinicalSign.getText().toString().trim();
        String DiseaseTypeOfClinicalSigns = editTextTypeOfClinicalSign.getText().toString().trim();
        String DiseaseDiagnosis = editTextDiagnosis.getText().toString().trim();
        String DiseaseTreatment = editTextTreatment.getText().toString().trim();
        String DiseaseRemarks =editTextRemarks.getText().toString().trim();
        String DiseaseNameOfVeterinarian =editTextNameOfVeterinarian.getText().toString().trim();




        if (!TextUtils.isEmpty(DiseaseDate)||!TextUtils.isEmpty(DiseaseClinicalSigns)||!TextUtils.isEmpty(DiseaseTypeOfClinicalSigns)||!TextUtils.isEmpty(DiseaseDiagnosis)||!TextUtils.isEmpty(DiseaseTreatment)||!TextUtils.isEmpty(DiseaseRemarks)) {

            String DiseaseID = databaseDisease.push().getKey();

            //creating an Artist Object
            Bundle bundles = getIntent().getExtras();


            String DiseaseCattleID = bundles.getString("CattleID");
            Disease disease = new Disease(DiseaseID,DiseaseDate,DiseaseCattleID,DiseaseClinicalSigns,DiseaseTypeOfClinicalSigns,DiseaseDiagnosis,DiseaseTreatment,DiseaseRemarks,DiseaseNameOfVeterinarian);
            databaseDisease.child(DiseaseID).setValue(disease);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Disease Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(AddDisease.this, ViewVaccination.class);




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
}
