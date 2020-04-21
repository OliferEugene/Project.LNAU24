package com.olifer.projectlnau24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GroupChoiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAT, btnAIN, btnEN, btnIT, btnMASH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_choice);

        btnAIN = findViewById(R.id.btnAIN);
        btnAT = findViewById(R.id.btnAT);
        btnEN = findViewById(R.id.btnEN);
        btnIT = findViewById(R.id.btnIT);
        btnMASH = findViewById(R.id.btnMASH);

        btnAIN.setOnClickListener(this);
        btnAT.setOnClickListener(this);
        btnEN.setOnClickListener(this);
        btnIT.setOnClickListener(this);
        btnMASH.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent groupIntent = new Intent(this, ScheduleActivity.class);
        startActivity(groupIntent);
    }
}
