package com.codeclan.hellofrog.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import example.codeclan.com.hellofrog.JSONAdapter;
import example.codeclan.com.hellofrog.R;

/**
 * Created by sandy on 25/04/2016.
 */
public class HelloFrog extends AppCompatActivity {

    private static final String API_URL = "http://cc-amphibian-api.herokuapp.com/";

//
    ImageView mImageView;
    TextView mNameText;
    TextView mSpeciesText;
    TextView mMediaText;
    ListView mListView;

    JSONAdapter mJSONAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("HelloFrog:", "onCreate called");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.list_item_img);
        mNameText = (TextView) findViewById(R.id.list_item_name);
        mSpeciesText = (TextView) findViewById(R.id.list_item_species);
        mMediaText = (TextView) findViewById(R.id.list_item_media);
        mListView = (ListView) findViewById(R.id.amphibian_list_view);

        mJSONAdapter = new JSONAdapter(this, getLayoutInflater());

        fetchAmphibians();
        mListView.setAdapter(mJSONAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JSONObject jsonObject = (JSONObject) mJSONAdapter.getItem(position);
                Log.d("HelloFrog: ", jsonObject.toString());
                Intent intent = new Intent(HelloFrog.this, ListItemDetails.class);

                setContentView(R.layout.list_item_details);

                intent.putExtra("imageUrl", jsonObject.optString("imageUrl"));
                intent.putExtra("name", jsonObject.optString("name"));
                intent.putExtra("species", jsonObject.optString("species"));
                intent.putExtra("media", jsonObject.optString("media"));


                startActivity(intent);
            }
        });

//        mListView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("HelloFrog:", "submit button clicked!");
//                Intent intent = new Intent(HelloFrog.this, ListItemDetails.class);
//
//
//                startActivity(intent);
//
//            }
//        });
    }

    private void fetchAmphibians(){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_URL, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.d("Oh hey Frog! ", jsonObject.toString());
                JSONArray data = jsonObject.optJSONArray("Amphibians");
                if (data != null){
                    mJSONAdapter.updateData(data);
                } else {
                    Log.e("HelloFrog: ", "No data found");
                }

            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error){
                Log.e("HelloFrog", "Failure: " + statusCode + " " + throwable.getMessage());

            }
        });
    }
}
