package com.hfad.hubmanager;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "hubmanager-mobilehub-472488996-Hub")

public class HubDO {
    private Double _hubId;
    private String _collab1;
    private String _collab2;
    private String _collab3;
    private String _collab4;
    private String _collab5;
    private String _hubName;
    private String _task1;
    private String _task10;
    private String _task2;
    private String _task3;
    private String _task4;
    private String _task5;
    private String _task6;
    private String _task7;
    private String _task8;
    private String _task9;

    @DynamoDBHashKey(attributeName = "hubId")
    @DynamoDBAttribute(attributeName = "hubId")
    public Double getHubId() {
        return _hubId;
    }

    public void setHubId(final Double _hubId) {
        this._hubId = _hubId;
    }
    @DynamoDBAttribute(attributeName = "collab1")
    public String getCollab1() {
        return _collab1;
    }

    public void setCollab1(final String _collab1) {
        this._collab1 = _collab1;
    }
    @DynamoDBAttribute(attributeName = "collab2")
    public String getCollab2() {
        return _collab2;
    }

    public void setCollab2(final String _collab2) {
        this._collab2 = _collab2;
    }
    @DynamoDBAttribute(attributeName = "collab3")
    public String getCollab3() {
        return _collab3;
    }

    public void setCollab3(final String _collab3) {
        this._collab3 = _collab3;
    }
    @DynamoDBAttribute(attributeName = "collab4")
    public String getCollab4() {
        return _collab4;
    }

    public void setCollab4(final String _collab4) {
        this._collab4 = _collab4;
    }
    @DynamoDBAttribute(attributeName = "collab5")
    public String getCollab5() {
        return _collab5;
    }

    public void setCollab5(final String _collab5) {
        this._collab5 = _collab5;
    }
    @DynamoDBAttribute(attributeName = "hubName")
    public String getHubName() {
        return _hubName;
    }

    public void setHubName(final String _hubName) {
        this._hubName = _hubName;
    }
    @DynamoDBAttribute(attributeName = "task1")
    public String getTask1() {
        return _task1;
    }

    public void setTask1(final String _task1) {
        this._task1 = _task1;
    }
    @DynamoDBAttribute(attributeName = "task10")
    public String getTask10() {
        return _task10;
    }

    public void setTask10(final String _task10) {
        this._task10 = _task10;
    }
    @DynamoDBAttribute(attributeName = "task2")
    public String getTask2() {
        return _task2;
    }

    public void setTask2(final String _task2) {
        this._task2 = _task2;
    }
    @DynamoDBAttribute(attributeName = "task3")
    public String getTask3() {
        return _task3;
    }

    public void setTask3(final String _task3) {
        this._task3 = _task3;
    }
    @DynamoDBAttribute(attributeName = "task4")
    public String getTask4() {
        return _task4;
    }

    public void setTask4(final String _task4) {
        this._task4 = _task4;
    }
    @DynamoDBAttribute(attributeName = "task5")
    public String getTask5() {
        return _task5;
    }

    public void setTask5(final String _task5) {
        this._task5 = _task5;
    }
    @DynamoDBAttribute(attributeName = "task6")
    public String getTask6() {
        return _task6;
    }

    public void setTask6(final String _task6) {
        this._task6 = _task6;
    }
    @DynamoDBAttribute(attributeName = "task7")
    public String getTask7() {
        return _task7;
    }

    public void setTask7(final String _task7) {
        this._task7 = _task7;
    }
    @DynamoDBAttribute(attributeName = "task8")
    public String getTask8() {
        return _task8;
    }

    public void setTask8(final String _task8) {
        this._task8 = _task8;
    }
    @DynamoDBAttribute(attributeName = "task9")
    public String getTask9() {
        return _task9;
    }

    public void setTask9(final String _task9) {
        this._task9 = _task9;
    }

}
