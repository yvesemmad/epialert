package com.yed.listeners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.yed.adamdjigbe.epialert.R;

/**
 * Created by emmanuel on 22/10/2017.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private Context ctx;
    private int spinnerPos;
    private Spinner spinnerAire;
    private ArrayAdapter<CharSequence> adapter;




    public CustomOnItemSelectedListener(){

    }
    public CustomOnItemSelectedListener(Context ctx){

    }
    public CustomOnItemSelectedListener(Spinner spinnerAire, Context ctx){
        this.ctx = ctx;
        this.spinnerPos = 0;
        this.spinnerAire = spinnerAire;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

        if((this.spinnerPos != pos) || (this.spinnerAire.getCount() <= 0)){
            this.spinnerPos = pos;
            addItemsOnSpinnerAire(this.spinnerAire ,this.spinnerPos);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        this.spinnerPos = 0;
        addItemsOnSpinnerAire(this.spinnerAire ,this.spinnerPos);
    }

    public void addItemsOnSpinnerAire(Spinner spinnerAire, int position) {

        switch (position){
            case 0 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_0, android.R.layout.simple_spinner_item);

            }break;
            case 1 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_1, android.R.layout.simple_spinner_item);

            }break;
            case 2 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_2, android.R.layout.simple_spinner_item);

            }break;
            case 3 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_3, android.R.layout.simple_spinner_item);

            }break;
            case 4 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_4, android.R.layout.simple_spinner_item);

            }break;
            case 5 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_5, android.R.layout.simple_spinner_item);

            }break;
            case 6 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_6, android.R.layout.simple_spinner_item);

            }break;
            case 7 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_7, android.R.layout.simple_spinner_item);

            }break;
            case 8 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_8, android.R.layout.simple_spinner_item);

            }break;
            case 9 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_9, android.R.layout.simple_spinner_item);

            }break;
            case 10 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_10, android.R.layout.simple_spinner_item);

            }break;
            case 11 :{
                this.adapter = ArrayAdapter.createFromResource(
                        this.ctx, R.array.s_districts_array_11, android.R.layout.simple_spinner_item);
            }break;

        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAire.setAdapter(adapter);

        /*List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ctx,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAire.setAdapter(dataAdapter);*/



    }

}
