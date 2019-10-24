package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewPage extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerGenre;
    Button buttonAddArtist;

   DatabaseReference databaseArtists;
   ListView ListViewArtists;
    List<Artist> artistList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        databaseArtists= FirebaseDatabase.getInstance().getReference("artists");

        editTextName = (EditText) findViewById(R.id.editTextName);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);


        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);
        ListViewArtists = (ListView) findViewById(R.id.listViewArtists);

        artistList=new ArrayList<>();

        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



            artistList.clear();

                for(
            DataSnapshot artistSnapshot :dataSnapshot.getChildren())

            {
                //getting artist
                Artist artist = artistSnapshot.getValue(Artist.class);
                //adding artist to the list
                artistList.add(artist);
            }

                ArtistList adapter = new ArtistList(NewPage.this, artistList);
                ListViewArtists.setAdapter(adapter);
        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addArtist() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Artist artist = new Artist(id, name, genre);
            databaseArtists.child(id).setValue(artist);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();



        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
