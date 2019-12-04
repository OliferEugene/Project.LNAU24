package com.olifer.projectlnau24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GroupChoiceActivity extends AppCompatActivity {

    String actionName, facultyName, groupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_choice);

        Intent intent = getIntent();

        actionName = intent.getStringExtra("actionName");
        facultyName = intent.getStringExtra("facultyName");
    }
}
