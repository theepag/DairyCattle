package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerGenres;
    Button buttonAddFarm,btnLogout;

    DatabaseReference databaseFarms;
    ListView ListViewFarms;
    List<Farm> farmList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseFarms= FirebaseDatabase.getInstance().getReference("farms");
        btnLogout = (Button) findViewById(R.id.logout);
        buttonAddFarm = (Button)findViewById(R.id.addFarm);

        ListViewFarms = (ListView) findViewById(R.id.listViewFarms);

        farmList=new ArrayList<>();




        buttonAddFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToAddFarm = new Intent(Home.this,addFarm.class);
                startActivity(inToAddFarm);
            }
        });

        ListViewFarms.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Farm farm = farmList.get(i);
                updateFarmDetail(farm.getFarmName(),farm.getFarmRegNo(),farm.getFarmOwnName(),farm.getFarmVetDiv(),farm.getFarmAddress(),farm.getFarmContactNo(),farm.getFarmCattleCount(),farm.getFarmDairyCattleCount());


                return true;
            }
        });


        ListViewFarms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Farm farm = farmList.get(i);
                showFarmDetail(farm.getFarmName(),farm.getFarmRegNo(),farm.getFarmOwnName(),farm.getFarmVetDiv(),farm.getFarmAddress(),farm.getFarmContactNo(),farm.getFarmCattleCount(),farm.getFarmDairyCattleCount());



            }
        });




        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Home.this, MainActivity.class);
                startActivity(intToMain);


            }


        });

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

                FarmList adapter = new FarmList(Home.this, farmList);
                ListViewFarms.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




    private void showFarmDetail(String Name, String RegNo, String OwnName, String VetDiv , String Address, String ContactNo, String CattleCount, String DairyCattleCount){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.viewfarms,null);

        dialogBuilder.setView(dialogView);

        final TextView editTextName = (TextView) dialogView.findViewById(R.id.FarmName);
        final TextView editTextRegNo = (TextView) dialogView.findViewById(R.id.farmRegNo);
        final TextView editTextOwnName = (TextView) dialogView.findViewById(R.id.farmOwnName);
        final TextView editTextVetDiv = (TextView) dialogView.findViewById(R.id.farmVetDiv);
        final TextView editTextAddress = (TextView) dialogView.findViewById(R.id.farmAddress);
        final TextView editTextContactNo = (TextView) dialogView.findViewById(R.id.farmContactNo);
        final TextView editTextCattleCount = (TextView) dialogView.findViewById(R.id.farmCattleCount);
        final TextView editTextDairyCattleCount = (TextView) dialogView.findViewById(R.id.farmDairyCattleCount);

        editTextName.setText(Name);
        editTextRegNo.setText(RegNo);
        editTextOwnName.setText(OwnName);
        editTextVetDiv.setText(VetDiv);
        editTextAddress.setText(Address);
        editTextCattleCount.setText(CattleCount);
        editTextDairyCattleCount.setText(DairyCattleCount);
        editTextContactNo.setText(ContactNo);


        dialogBuilder.setTitle("Showing Farm Details");
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();



    }

    private void updateFarmDetail(String Name, String RegNo, String OwnName, String VetDiv , String Address, String ContactNo, String CattleCount, String DairyCattleCount){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.update_farms,null);

        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editTextRegNo = (EditText) dialogView.findViewById(R.id.editTextRegNo);
        final EditText editTextOwnName = (EditText) dialogView.findViewById(R.id.editTextOwnName);
        final EditText editTextVetDiv = (EditText) dialogView.findViewById(R.id.editTextVetDiv);
        final EditText editTextAddress = (EditText) dialogView.findViewById(R.id.editTextAddress);
        final EditText editTextContactNo = (EditText) dialogView.findViewById(R.id.editTextContactNo);
        final EditText editTextCattleCount = (EditText) dialogView.findViewById(R.id.editTextCattleCount);
        final EditText editTextDairyCattleCount = (EditText) dialogView.findViewById(R.id.editTextDairyCattleCount);
        final Button btnCancell = (Button)dialogView.findViewById(R.id.buttonCancel);

        editTextName.setText(Name);
        editTextRegNo.setText(RegNo);
        editTextOwnName.setText(OwnName);
        editTextVetDiv.setText(VetDiv);
        editTextAddress.setText(Address);
        editTextCattleCount.setText(CattleCount);
        editTextDairyCattleCount.setText(DairyCattleCount);
        editTextContactNo.setText(ContactNo);

        btnCancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intToHome = new Intent(Home.this, Home.class);
                startActivity(intToHome);


            }


        });


        dialogBuilder.setTitle("Update Farm Details");
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();



    }







}
