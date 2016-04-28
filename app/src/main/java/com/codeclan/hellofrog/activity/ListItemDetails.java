package com.codeclan.hellofrog.activity;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import example.codeclan.com.hellofrog.R;

/**
 * Created by user on 27/04/16.
 */
public class ListItemDetails extends AppCompatActivity {

    ImageView mImageView;
    TextView mNameText;
    TextView mSpeciesText;
    TextView mMediaText;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_details);
        Log.d("HelloFrog:", "ListItemDetails.onCreate called");

        mImageView = (ImageView) findViewById(R.id.list_item_img);
        mNameText = (TextView) findViewById(R.id.list_item_name);
        mSpeciesText = (TextView)findViewById(R.id.list_item_species);
        mMediaText = (TextView)findViewById(R.id.list_item_media);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String imageUrl = extras.getString("imageUrl");
        String name = extras.getString("name");
        String species = extras.getString("species");
        String media = extras.getString("media");

        Picasso picasso = Picasso.with(this);
        RequestCreator image = picasso.load(imageUrl);
        image.into(mImageView);


        mNameText.setText("Amphibian Name: " + name);
        mSpeciesText.setText("They are a: " + species);
        mMediaText.setText("They are from: " + media);
    }
}


