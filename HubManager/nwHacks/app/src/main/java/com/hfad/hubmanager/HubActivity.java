package com.hfad.hubmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class HubActivity extends AppCompatActivity {

    String hubNameStr;
    String collabNameStr;
    int hubID;
    DynamoDBMapper dynamoDBMapper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(AWSMobileClient.getInstance().getCredentialsProvider());
        this.dynamoDBMapper = DynamoDBMapper.builder()
                .dynamoDBClient(dynamoDBClient)
                .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
                .build();

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            hubNameStr = extras.getString("EXTRA_HUB_NAME");
            collabNameStr = extras.getString("EXTRA_COLLAB_NAME");
            hubID = extras.getInt("EXTRA_HUB_ID");
            createHub();
//            readNews();
        }


    }


    public void createHub() {
        final HubDO hubItem = new HubDO();

        hubItem.setHubId((double) hubID);
        hubItem.setHubName(hubNameStr);
        hubItem.setCollab1(collabNameStr);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("SJDLKJLSKDJD", "is this working? ");
                dynamoDBMapper.save(hubItem);
                Log.i("SJDLKJLSKDJD", "Yes it is! ");

                // Item saved
            }
        }).start();

    }


    public void readNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.i("LKDFJLSJD", "YOU HERE?");
                HubDO hubItem = dynamoDBMapper.load(
                        HubDO.class,
                        hubID);
                //Log.i("LKDFJLSJD", hubItem.getCollab1());
                // Item read
                // Log.d("News Item:", newsItem.toString());
            }
        }).start();
    }


//    public void updateNews() {
//        final NewsDO newsItem = new NewsDO();
//
//        newsItem.setUserId(identityManager.getCachedUserID());
//
//        newsItem.setArticleId("Article1");
//        newsItem.setContent("This is the updated content.");
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                dynamoDBMapper.save(newsItem);
//
//                // Item updated
//            }
//        }).start();
//    }

//
//    public void deleteNews() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                NewsDO newsItem = new NewsDO();
//
//                newsItem.setUserId(identityManager.getCachedUserID());    //partition key
//
//                newsItem.setArticleId("Article1");  //range (sort) key
//
//                dynamoDBMapper.delete(newsItem);
//
//                // Item deleted
//            }
//        }).start();
//    }
}
