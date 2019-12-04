package com.olifer.projectlnau24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyChoiceActivity extends AppCompatActivity implements View.OnClickListener {

    String chosenFaculty ="";

    Button btnMechFac, btnEconFac, btnAgroFac, btnBuildFac, btnLandMgmtFac;

    String actionName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_choice);

        btnMechFac = (Button) findViewById(R.id.btnMechFac);
        btnEconFac = (Button) findViewById(R.id.btnEconFac);
        btnAgroFac = (Button) findViewById(R.id.btnAgroFac);
        btnBuildFac = (Button) findViewById(R.id.btnBuildFac);
        btnLandMgmtFac = (Button) findViewById(R.id.btnLandMgmtFac);

        btnMechFac.setOnClickListener(this);
        btnEconFac.setOnClickListener(this);
        btnAgroFac.setOnClickListener(this);
        btnBuildFac.setOnClickListener(this);
        btnLandMgmtFac.setOnClickListener(this);

        Intent intent = getIntent();

        actionName = intent.getStringExtra("actionName");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMechFac:
                chosenFaculty = "Mech";
                break;
            case R.id.btnEconFac:
                chosenFaculty = "Econ";
                break;
            case R.id.btnAgroFac:
                chosenFaculty = "Agro";
                break;
            case R.id.btnBuildFac:
                chosenFaculty = "Build";
                break;
            case R.id.btnLandMgmtFac:
                chosenFaculty = "LandMgmt";
                break;
        }
        Intent facIntent = new Intent(this, GroupChoiceActivity.class);
        facIntent.putExtra("actionName", actionName);
        facIntent.putExtra("facultyName", chosenFaculty);
        startActivity(facIntent);
    }
}
