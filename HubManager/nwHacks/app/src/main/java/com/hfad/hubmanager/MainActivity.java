package com.hfad.hubmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;


public class MainActivity extends Activity implements View.OnClickListener {

//    DynamoDBMapper dynamoDBMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AWSMobileClient.getInstance().initialize(this).execute();
        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);


//        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(AWSMobileClient.getInstance().getCredentialsProvider());
//        this.dynamoDBMapper = DynamoDBMapper.builder()
//                .dynamoDBClient(dynamoDBClient)
//                .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
//                .build();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}





