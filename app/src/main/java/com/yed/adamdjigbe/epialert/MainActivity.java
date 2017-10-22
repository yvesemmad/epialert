package com.yed.adamdjigbe.epialert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import com.yed.listeners.CustomOnItemSelectedListener;
import com.yed.listeners.SetDateListener;

import static com.yed.utils.FonctionsUtils.populateSetCurrentDate;


public class MainActivity extends AppCompatActivity {

    EditText txtDate;
    Spinner spinnerDistrict;
    Spinner spinnerAire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = (EditText) findViewById(R.id.txtdate);
        SetDateListener formDate = new SetDateListener(txtDate, this);
        populateSetCurrentDate(txtDate);

        spinnerDistrict = (Spinner) findViewById(R.id.spinnerDistrict);
        spinnerAire = (Spinner) findViewById(R.id.spinnerAire);
        spinnerDistrict.setOnItemSelectedListener(new CustomOnItemSelectedListener(spinnerAire, this));
    }


}
