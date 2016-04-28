package com.codeclan.hellofrog.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import example.codeclan.com.hellofrog.R;

/**
 * Created by user on 26/04/16.
 */
public class AmphibianDetails extends AppCompatActivity {
    TextView mNameText;
    TextView mSpeciesText;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d("HelloFrog:", "AmphibianDetails.onCreate called");

        mNameText = (TextView) findViewById(R.id.text_name);
        mSpeciesText = (TextView)findViewById(R.id.text_species);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("name");
        String species = extras.getString("species");

        mNameText.setText("Hello " + name);
        mSpeciesText.setText("You are a " + species);
    }
}
