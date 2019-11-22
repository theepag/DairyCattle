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

public class AddBreeding extends AppCompatActivity {
    EditText editTextDateOFHeatSignObserved,editTextDateOfFirstAI,editTextDateOfSecondAI,editTextSemenID,editTextVeterinianCode,editTextDateOfPD,editTextDateOfLastCalving,editTextNameOfTechnician,editTextNoOfCalving,editTextNameOfAIReceiptNo;
    Button buttonAddBreeding;
    DatabaseReference databaseBreeding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_breeding);


        databaseBreeding= FirebaseDatabase.getInstance().getReference("breeding");



        editTextDateOFHeatSignObserved = (EditText) findViewById(R.id.editTextDateOFHeatSignObserved);
        editTextDateOfFirstAI = (EditText) findViewById(R.id.editTextDateOfFirstAI);
        editTextDateOfSecondAI = (EditText) findViewById(R.id.editTextDateOfSecondAI);
        editTextSemenID = (EditText) findViewById(R.id.editTextSemenID);
        editTextVeterinianCode = (EditText) findViewById(R.id.editTextVeterinianCode);
        editTextDateOfPD = (EditText)findViewById(R.id.editTextDateOfPD);
        editTextDateOfLastCalving = (EditText) findViewById(R.id.editTextDateOfLastCalving);
        editTextNameOfTechnician = (EditText) findViewById(R.id.editTextNameOfTechnician);
        editTextNoOfCalving = (EditText) findViewById(R.id.editTextNoOfCalving);
        editTextNameOfAIReceiptNo = (EditText) findViewById(R.id.editTextNameOfAIReceiptNo);






        buttonAddBreeding = (Button) findViewById(R.id.buttonAddBreeding);

        buttonAddBreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addBreeding();

            }
        });


    }

    private void addBreeding(){

        String BreedingDateOfHeatSignObserved = editTextDateOFHeatSignObserved.getText().toString().trim();
        String BreedingDateOfFirstAI = editTextDateOfFirstAI.getText().toString().trim();
        String BreedingDateOfSecondAI = editTextDateOfSecondAI.getText().toString().trim();
        String BreedingSemenID = editTextSemenID.getText().toString().trim();
        String BreedingVeterinarianCode = editTextVeterinianCode.getText().toString().trim();
        String BreedingDateOfPD = editTextDateOfPD.getText().toString().trim();
        String BreedingDateOfLastCalving =editTextDateOfLastCalving.getText().toString().trim();
        String BreedingNameOfTechnnician =editTextNameOfTechnician.getText().toString().trim();
        String BreedingNoOfCalving =editTextNoOfCalving.getText().toString().trim();
        String BreedingAIReceiptNo =editTextNameOfAIReceiptNo.getText().toString().trim();





        if (!TextUtils.isEmpty(BreedingDateOfHeatSignObserved)||!TextUtils.isEmpty(BreedingDateOfFirstAI)||!TextUtils.isEmpty(BreedingDateOfSecondAI)||!TextUtils.isEmpty(BreedingSemenID)||!TextUtils.isEmpty(BreedingVeterinarianCode)||!TextUtils.isEmpty(BreedingDateOfPD)) {

            String BreedingID = databaseBreeding.push().getKey();

            //creating an Artist Object
            Bundle bundles = getIntent().getExtras();


            String BreedingCattleID = bundles.getString("CattleID");
            Breeding breeding = new Breeding(BreedingID,BreedingCattleID,BreedingDateOfHeatSignObserved,BreedingDateOfFirstAI,BreedingDateOfSecondAI,BreedingSemenID,BreedingVeterinarianCode,BreedingDateOfPD,BreedingDateOfLastCalving,BreedingNameOfTechnnician,BreedingNoOfCalving,BreedingAIReceiptNo);
            databaseBreeding.child(BreedingID).setValue(breeding);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Breeding Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(AddBreeding.this, ViewVaccination.class);




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
}
