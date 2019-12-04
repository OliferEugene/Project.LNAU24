package com.olifer.projectlnau24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActionChoiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSchedule, btnTasks, btnEvents;

    final String ACTION_SCHEDULE = "schedule";
    final String ACTION_TASKS = "tasks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_choice);

        btnSchedule = (Button) findViewById(R.id.btnSchedule);
        btnTasks = (Button) findViewById(R.id.btnTasks);
        btnEvents = (Button) findViewById(R.id.btnEvents);

        btnSchedule.setOnClickListener(this);
        btnTasks.setOnClickListener(this);
        btnEvents.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSchedule:
                Intent scheduleIntent = new Intent(this, FacultyChoiceActivity.class);
                scheduleIntent.putExtra("actionName", ACTION_SCHEDULE);
                startActivity(scheduleIntent);
                break;
            case R.id.btnTasks:
                Intent tasksIntent = new Intent(this, FacultyChoiceActivity.class);
                tasksIntent.putExtra("actionName", ACTION_TASKS);
                startActivity(tasksIntent);
                break;
            case R.id.btnEvents:
                Intent eventsIntent = new Intent(this, EventsActivity.class);
                startActivity(eventsIntent);
                break;
        }
    }
}
