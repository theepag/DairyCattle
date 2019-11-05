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

public class AboutDairyCattle extends AppCompatActivity {


    EditText editTextDateOfBirth;
    EditText editTextBreed;
    EditText editTextCoatColour;
    EditText editTextLactation;
    EditText editTextMotherTag;
    EditText editTextRemark;


    Button buttonAdd;

    DatabaseReference databaseDairy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dairy_cattle);

        databaseDairy= FirebaseDatabase.getInstance().getReference("dairy");

        editTextDateOfBirth = (EditText) findViewById(R.id.editTextDateOfBirth);
//        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        editTextBreed = (EditText) findViewById(R.id.editTextBreed);
        editTextCoatColour = (EditText) findViewById(R.id.editTextCoatColour);
        editTextLactation= (EditText) findViewById(R.id.editTextNoofLactation);
        editTextMotherTag= (EditText) findViewById(R.id.editTextMotherTagId);
        editTextRemark = (EditText) findViewById(R.id.editTextRemark);



        buttonAdd = (Button) findViewById(R.id.buttonSave);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addDairy();
            }
        });

    }

    private void addDairy() {
        //getting the values to save
        String DateOfbirth = editTextDateOfBirth.getText().toString().trim();
        String Breed = editTextBreed.getText().toString().trim();
        String CoatColour = editTextCoatColour.getText().toString().trim();
        String Lactation = editTextLactation.getText().toString().trim();
        String MotherTag = editTextMotherTag.getText().toString().trim();
        String Remark = editTextRemark.getText().toString().trim();



        //checking if the value is provided
        if (!TextUtils.isEmpty(DateOfbirth)||!TextUtils.isEmpty(Breed)||!TextUtils.isEmpty(CoatColour)||!TextUtils.isEmpty(Lactation)||!TextUtils.isEmpty(MotherTag)||!TextUtils.isEmpty(Remark)) {

            String id = databaseDairy.push().getKey();

            //creating an Artist Object
            Dairy dairy = new Dairy(id,DateOfbirth,Breed,CoatColour,Lactation,MotherTag,Remark);
            databaseDairy.child(id).setValue(dairy);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Dairy cattle added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a details", Toast.LENGTH_LONG).show();
        }
    }
}
