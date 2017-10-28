package com.yed.listeners;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by emmanuel on 22/10/2017.
 */
public class SetDateListener implements View.OnFocusChangeListener, View.OnClickListener, DatePickerDialog.OnDateSetListener {

    Context ctx;
    //private EditText editText;
    private TextView editText;
    private Calendar myCalendar;

    public SetDateListener(EditText editText, Context ctx){
        this.editText = editText;
        this.editText.setOnFocusChangeListener(this);
        this.editText.setOnClickListener(this);
        myCalendar = Calendar.getInstance();
        this.ctx = ctx;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)     {
        // this.editText.setText();

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdformat = new SimpleDateFormat(myFormat, Locale.US);
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        editText.setText(sdformat.format(myCalendar.getTime()));

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){

            new DatePickerDialog(ctx, this, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    }

    @Override
    public void onClick(View view) {

        new DatePickerDialog(ctx, this, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }
}
