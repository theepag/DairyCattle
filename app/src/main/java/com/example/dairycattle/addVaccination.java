package com.example.dairycattle;





import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addVaccination extends AppCompatActivity {


    EditText editTextDate;
    EditText editTextNameOfVaccine;
    EditText editTextPurposeOfVaccine;
    EditText editTextNameOfVOfficer;
    EditText editTextRemark;
    EditText editTextNextVaccination;
    EditText editTextRemainder;


    Button buttonAdd;

    DatabaseReference databaseVaccination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccination);

        databaseVaccination= FirebaseDatabase.getInstance().getReference("vaccinaton");

        editTextDate = (EditText) findViewById(R.id.editTextVaccineDate);
//        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        editTextNameOfVaccine = (EditText) findViewById(R.id.editTextVaccineName);
        editTextPurposeOfVaccine = (EditText) findViewById(R.id.editTextPurposeOfVaccine);
        editTextNameOfVOfficer= (EditText) findViewById(R.id.editTextNameOfVetOfficer);
        editTextRemark= (EditText) findViewById(R.id.editTextRemarkV);
        editTextNextVaccination = (EditText) findViewById(R.id.editTextNextVaccination);
        editTextRemainder= (EditText) findViewById(R.id.editTextRemainder);




        buttonAdd = (Button) findViewById(R.id.btnAddVaccine);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addVaccine();
            }
        });

    }

    private void addVaccine() {
        //getting the values to save
        String date = editTextDate.getText().toString().trim();
        String vaccinationName = editTextNameOfVaccine.getText().toString().trim();
        String vaccinationPurpose = editTextPurposeOfVaccine.getText().toString().trim();
        String veterinaryOffcerName = editTextNameOfVOfficer.getText().toString().trim();
        String remark = editTextRemark.getText().toString().trim();
        String nextVaccine = editTextNextVaccination.getText().toString().trim();
        String remainder = editTextRemainder.getText().toString().trim();



        //checking if the value is provided
        if (!TextUtils.isEmpty(date)||!TextUtils.isEmpty(vaccinationName)||!TextUtils.isEmpty(vaccinationPurpose)||!TextUtils.isEmpty(veterinaryOffcerName)||!TextUtils.isEmpty(remark)||!TextUtils.isEmpty(nextVaccine)||!TextUtils.isEmpty(remainder)) {

            String vaccinatonId = databaseVaccination.push().getKey();

            //creating an Artist Object
            Vaccination vaccination = new Vaccination(vaccinatonId, date,vaccinationName,vaccinationPurpose,veterinaryOffcerName,remark,nextVaccine,remainder);
            databaseVaccination.child(vaccinatonId).setValue(vaccination);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Vaccination added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
