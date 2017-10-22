package com.yed.utils;

import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by emmanuel on 22/10/2017.
 */
public  class FonctionsUtils {

    public static void populateSetCurrentDate(EditText mEditText) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH)+1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        mEditText.setText(dd+"/"+mm+"/"+yy);
    }


}
