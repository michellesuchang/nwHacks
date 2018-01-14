package com.hfad.hubmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class HubActivity extends AppCompatActivity implements View.OnClickListener {

    String hubNameStr;
    String collabNameStr;
    int hubID;
    DynamoDBMapper dynamoDBMapper;
    HubDO hubItem;


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
        }

        Button addTask = (Button) findViewById(R.id.add_task_button);
        addTask.setOnClickListener(this);


    }


    public void createHub() {
        hubItem = new HubDO();

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

    public void saveTask(String task, String collab){
        hubItem.setTask1(task);
        hubItem.setCollab1(collab);

        new Thread(new Runnable() {
            @Override
            public void run() {
                dynamoDBMapper.save(hubItem);

                // Item saved
            }
        }).start();


    }

    @Override
    public void onClick(View view) {
        String newTask = (String) findViewById(R.id.edit_task).toString();
        String newCollab = (String) findViewById(R.id.edit_collab).toString();

        ListView taskList = (ListView) findViewById(R.id.task_list_id);
        ListView collabList = (ListView) findViewById(R.id.collab_list_id);
//
//
//
//        ArrayAdapter<String> taskListAdapter = new ArrayAdapter<~>(this,
//                android.R.layout.simple_list_item_1, taskList, R.array.Tasks_array);
//
//        ArrayAdapter<String> collabListAdapter = new ArrayAdapter<~>(this,
//                android.R.layout.simple_list_item_1, collabList, R.array.Collab_array);

        saveTask(newTask, newCollab);
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
