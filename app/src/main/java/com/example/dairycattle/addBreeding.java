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

public class addBreeding extends AppCompatActivity {


    EditText editTextDateOfHeat;
    EditText editTextDateOfFirstAI;
    EditText editTextDateOfSecondAI;
    EditText editTextSemanId;
    EditText editTextVeterinarianCode;
    EditText editTextDateOfPD;
    EditText editTextDateOfLC;
    EditText editTextNameOfTech;
    EditText editTextNumberOfCal;
    EditText editTextAIReceipt;


    Button buttonAdd;

    DatabaseReference databaseBreed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_breeding);

        databaseBreed= FirebaseDatabase.getInstance().getReference("breeding");

        editTextDateOfHeat = (EditText) findViewById(R.id.editTextHeatObserved);
//        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        editTextDateOfFirstAI = (EditText) findViewById(R.id.editTextFirstAI);
        editTextDateOfSecondAI = (EditText) findViewById(R.id.editTextSecondAI);
        editTextSemanId= (EditText) findViewById(R.id.editTextSemanId);
        editTextVeterinarianCode= (EditText) findViewById(R.id.editTextVeterinarianCode);
        editTextDateOfPD = (EditText) findViewById(R.id.editTextDateOfPD);
        editTextDateOfLC= (EditText) findViewById(R.id.editTextDateOFLC);
        editTextNameOfTech= (EditText) findViewById(R.id.editTextNameOfTech);
        editTextNumberOfCal= (EditText) findViewById(R.id.editTextNumberOfCalving);
        editTextAIReceipt= (EditText) findViewById(R.id.editTextAINo);




        buttonAdd = (Button) findViewById(R.id.btnAddBreeding);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addBreeding();
            }
        });

    }

    private void addBreeding() {
        //getting the values to save
        String dateOfHeatSignObserved = editTextDateOfHeat.getText().toString().trim();
        String dateOfFirstArtificialInsemination = editTextDateOfFirstAI.getText().toString().trim();
        String dateOfSecondArtificialInsemination = editTextDateOfSecondAI.getText().toString().trim();
        String semanId = editTextSemanId.getText().toString().trim();
        String veterinarianCode= editTextVeterinarianCode.getText().toString().trim();
        String dateOfPD = editTextDateOfPD.getText().toString().trim();
        String dateOfLastCalving = editTextDateOfLC.getText().toString().trim();
        String nameOfTechnician = editTextNameOfTech.getText().toString().trim();
        String numberOfCalving = editTextNumberOfCal.getText().toString().trim();
        String aiReceiptNo= editTextAIReceipt.getText().toString().trim();



        //checking if the value is provided
        if (!TextUtils.isEmpty(dateOfHeatSignObserved)||!TextUtils.isEmpty(dateOfFirstArtificialInsemination)||!TextUtils.isEmpty(dateOfSecondArtificialInsemination)||!TextUtils.isEmpty(semanId)||!TextUtils.isEmpty(veterinarianCode)||!TextUtils.isEmpty(dateOfPD)||!TextUtils.isEmpty(dateOfLastCalving)||!TextUtils.isEmpty(nameOfTechnician)||!TextUtils.isEmpty(numberOfCalving)||!TextUtils.isEmpty(aiReceiptNo)) {

            String breedingId = databaseBreed.push().getKey();

            //creating an Artist Object
            Breeding breeding = new Breeding(breedingId, dateOfHeatSignObserved,dateOfFirstArtificialInsemination,dateOfSecondArtificialInsemination,semanId,veterinarianCode,dateOfPD,dateOfLastCalving,nameOfTechnician,numberOfCalving,aiReceiptNo);
            databaseBreed.child(breedingId).setValue(breeding);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Breeding added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter value", Toast.LENGTH_LONG).show();
        }
    }
}
