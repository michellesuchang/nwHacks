package com.hfad.hubmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;

public class CreateNewHubActivity extends AppCompatActivity implements View.OnClickListener {

    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_hub);
        Button saveChangesButton = (Button) findViewById(R.id.save_hub_info);
        saveChangesButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        EditText hubNameView = (EditText) findViewById(R.id.hub_name);
        String hubName = hubNameView.getText().toString();
        EditText collabNameView = (EditText) findViewById(R.id.collab_name);
        String collabName = collabNameView.getText().toString();


        Intent actionIntent = new Intent(this, HubActivity.class);
        actionIntent.putExtra("EXTRA_HUB_NAME", hubName);
        actionIntent.putExtra("EXTRA_COLLAB_NAME", collabName);
        actionIntent.putExtra("EXTRA_HUB_ID", counter);
        counter++;
        startActivity(actionIntent);
    }
}
