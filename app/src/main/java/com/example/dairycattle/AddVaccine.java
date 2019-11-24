package com.example.dairycattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dairycattle.Vaccine;
import com.example.dairycattle.ViewVaccination;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddVaccine extends AppCompatActivity {
    EditText editTextDate,editTextClinicalSign,editTextTypeOfClinicalSign,editTextKindOfDisease,editTextTreatment,editTextRemarks,editTextNameOfVeterinarian;
    Button btnAddVaccine;
    DatabaseReference databaseVaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccine);


        databaseVaccine= FirebaseDatabase.getInstance().getReference("vaccine");



        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextClinicalSign = (EditText) findViewById(R.id.editTextClinicalSign);
        editTextTypeOfClinicalSign = (EditText) findViewById(R.id.editTextTypeOfClinicalSign);
        editTextKindOfDisease = (EditText) findViewById(R.id.editTextKindOfDisease);
        editTextTreatment = (EditText)findViewById(R.id.editTextTreatment);
        editTextRemarks = (EditText) findViewById(R.id.editTextRemarks);
        editTextNameOfVeterinarian = (EditText) findViewById(R.id.editTextNameOfVeterinarian);





        btnAddVaccine = (Button) findViewById(R.id.buttonAddVaccine);

        btnAddVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addVaccine();

            }
        });


    }

    private void addVaccine(){

        String VaccineDate = editTextDate.getText().toString().trim();
        String VaccineClinicalSigns = editTextClinicalSign.getText().toString().trim();
        String VaccineTypeOfClinicalSign = editTextTypeOfClinicalSign.getText().toString().trim();
        String VaccineKindOfDisease = editTextKindOfDisease.getText().toString().trim();
        String VaccineTreatment = editTextTreatment.getText().toString().trim();
        String VaccineRemarks =editTextRemarks.getText().toString().trim();
        String VaccineNameOfVeterinarian =editTextNameOfVeterinarian.getText().toString().trim();




        if (!TextUtils.isEmpty(VaccineDate)||!TextUtils.isEmpty(VaccineClinicalSigns)||!TextUtils.isEmpty(VaccineTypeOfClinicalSign)||!TextUtils.isEmpty(VaccineKindOfDisease)||!TextUtils.isEmpty(VaccineTreatment)||!TextUtils.isEmpty(VaccineRemarks)) {

            String VaccineID = databaseVaccine.push().getKey();

            //creating an Artist Object
            Bundle bundles = getIntent().getExtras();


            String CattleVaccineID = bundles.getString("CattleID");
            Vaccine vaccine = new Vaccine(VaccineID,CattleVaccineID,VaccineDate,VaccineClinicalSigns,VaccineTypeOfClinicalSign,VaccineKindOfDisease,VaccineTreatment,VaccineRemarks,VaccineNameOfVeterinarian);
            databaseVaccine.child(VaccineID).setValue(vaccine);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Vaccine Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(AddVaccine.this, ViewVaccination.class);




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
    }
