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

public class AboutUs extends AppCompatActivity {


    EditText editTextFarmName;
    EditText editTextRegNo;
    EditText editTextOwnerName;
    EditText editTextVdivision;
    EditText editTextAddress;
    EditText editTextContactNo;
    EditText editTextNoOfCattle;
    EditText editTextNoOfDairy;

    Button buttonAdd;

    DatabaseReference databaseFarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        databaseFarm= FirebaseDatabase.getInstance().getReference("farms");

        editTextFarmName = (EditText) findViewById(R.id.editTextFarmName);
//        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        editTextRegNo = (EditText) findViewById(R.id.editTextRegNo);
        editTextOwnerName = (EditText) findViewById(R.id.editTextOwnerName);
        editTextVdivision= (EditText) findViewById(R.id.editTextVdivision);
        editTextAddress= (EditText) findViewById(R.id.editTextAddress);
        editTextContactNo = (EditText) findViewById(R.id.editTextContactNo);
        editTextNoOfCattle= (EditText) findViewById(R.id.editTextNoOfCattle);
        editTextNoOfDairy = (EditText) findViewById(R.id.editTextNoOfDairy);



        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addFarm();
            }
        });

    }

    private void addFarm() {
        //getting the values to save
        String name = editTextFarmName.getText().toString().trim();
        String reg = editTextRegNo.getText().toString().trim();
        String owner = editTextOwnerName.getText().toString().trim();
        String division = editTextVdivision.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String contact = editTextContactNo.getText().toString().trim();
        String cattle = editTextNoOfCattle.getText().toString().trim();
        String dairy = editTextNoOfDairy.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(name)||!TextUtils.isEmpty(reg)||!TextUtils.isEmpty(owner)||!TextUtils.isEmpty(division)||!TextUtils.isEmpty(address)||!TextUtils.isEmpty(contact)||!TextUtils.isEmpty(cattle)||!TextUtils.isEmpty(dairy)) {

            String id = databaseFarm.push().getKey();

            //creating an Artist Object
            Farm farm = new Farm(id, name,reg,owner,division,address,contact,cattle,dairy);
            databaseFarm.child(id).setValue(farm);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Farms added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
