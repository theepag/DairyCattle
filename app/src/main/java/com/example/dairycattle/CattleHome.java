package com.example.dairycattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CattleHome extends AppCompatActivity {
    Button buttonVaccine, buttonDisease,buttonBreeding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cattle_home);

        buttonVaccine = (Button)findViewById(R.id.buttonVaccine);

        buttonVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");


                Intent intToCattleVaccine = new Intent(CattleHome.this, ViewVaccination.class);
                Bundle bundleVac = new Bundle();
                bundleVac.putString("cattleID",cattleID);

                intToCattleVaccine.putExtras(bundleVac);
                startActivity(intToCattleVaccine);


            }
        });


        buttonDisease = (Button)findViewById(R.id.buttonDisease);

        buttonDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");


                Intent intToCattleDisease = new Intent(CattleHome.this, ViewDisease.class);
                Bundle bundleDisease = new Bundle();
                bundleDisease.putString("cattleID",cattleID);

                intToCattleDisease.putExtras(bundleDisease);
                startActivity(intToCattleDisease);


            }
        });

        buttonBreeding = (Button)findViewById(R.id.buttonBreeding);

        buttonBreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");


                Intent intToCattleBreeding = new Intent(CattleHome.this, ViewBreeding.class);
                Bundle bundleBreeding = new Bundle();
                bundleBreeding.putString("cattleID",cattleID);

                intToCattleBreeding.putExtras(bundleBreeding);
                startActivity(intToCattleBreeding);


            }
        });

    }
}
