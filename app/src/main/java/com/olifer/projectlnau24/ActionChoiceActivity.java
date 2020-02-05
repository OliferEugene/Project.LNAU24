package com.olifer.projectlnau24;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

public class ActionChoiceActivity extends TabActivity implements View.OnClickListener{

    final String ACTION_SCHEDULE = "schedule";
    final String ACTION_TASKS = "tasks";

    ImageView ivLogoSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_choice);

        ivLogoSmall = findViewById(R.id.ivLogoSmall);
        ivLogoSmall.setImageResource(R.drawable.logo_no_shield_no_bg_dark);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("events");
        tabSpec.setIndicator("Заходи");
        tabSpec.setContent(new Intent(this, EventsActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("schedule");
        tabSpec.setIndicator("Розклад");
        tabSpec.setContent(new Intent(this, FacultyChoiceActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("myGroup");
        tabSpec.setIndicator("Моя група");
        tabSpec.setContent(new Intent(this, TasksActivity.class));
        tabHost.addTab(tabSpec);
    }

    @Override
    public void onClick(View v) {


    }
}
