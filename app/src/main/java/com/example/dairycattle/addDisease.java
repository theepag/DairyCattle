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

public class addDisease extends AppCompatActivity {


    EditText editTextDate;
    EditText editTextClinicalSign;
    EditText editTextTypeOfCS;
    EditText editTextKind;
    EditText editTextTreatment;
    EditText editTextRemarks;



    Button buttonAdd;

    DatabaseReference databaseDisease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disease);

        databaseDisease= FirebaseDatabase.getInstance().getReference("diseases");

        editTextDate = (EditText) findViewById(R.id.editTextDiseaseDate);
//        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        editTextClinicalSign = (EditText) findViewById(R.id.editTextClinicalSign);
        editTextTypeOfCS = (EditText) findViewById(R.id.editTextTypeOfCS);
        editTextKind= (EditText) findViewById(R.id.editTextKindOfDisease);
        editTextTreatment= (EditText) findViewById(R.id.editTextTreatment);
        editTextRemarks = (EditText) findViewById(R.id.editTextRemarks);





        buttonAdd = (Button) findViewById(R.id.btnAddDisease);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addDisease();
            }
        });

    }

    private void addDisease() {
        //getting the values to save
        String diseaseDate = editTextDate.getText().toString().trim();
        String clinicalSigns = editTextClinicalSign.getText().toString().trim();
        String typeOfClinicalSigns = editTextTypeOfCS.getText().toString().trim();
        String kindOfDisease = editTextKind.getText().toString().trim();
        String treatment = editTextTreatment.getText().toString().trim();
        String remarks = editTextRemarks.getText().toString().trim();




        //checking if the value is provided
        if (!TextUtils.isEmpty(diseaseDate)||!TextUtils.isEmpty(clinicalSigns)||!TextUtils.isEmpty(typeOfClinicalSigns)||!TextUtils.isEmpty(kindOfDisease)||!TextUtils.isEmpty(treatment)||!TextUtils.isEmpty(remarks)) {

            String diseaseId = databaseDisease.push().getKey();

            //creating an Artist Object
            Disease disease = new Disease(diseaseId, diseaseDate,clinicalSigns,typeOfClinicalSigns,kindOfDisease,treatment,remarks);
            databaseDisease.child(diseaseId).setValue(disease);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Diseases added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
