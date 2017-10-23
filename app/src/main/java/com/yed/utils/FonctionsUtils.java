package com.yed.utils;

import android.content.Context;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.yed.classes.EpiMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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


    protected void sendSMSMessage(Context ctx, EpiMessage epiMessage) {


        Log.d("sendSMSMessage", epiMessage.ConsoliderMessageEpiAlert());

        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(epiMessage.getNumero(), null, epiMessage.ConsoliderMessageEpiAlert(), null, null);
            Toast.makeText(ctx,
                    "sendSMSMessage: " + epiMessage.ConsoliderMessageEpiAlert(),
                    Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.getMessage();
            Log.d("sendSMS_Exception", e.getMessage());

        }

    }

    public String GetCurrentDateSystem(){
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdformat = new SimpleDateFormat(myFormat, Locale.US);
        final Calendar myCalendar = Calendar.getInstance();
        int yy = myCalendar.get(Calendar.YEAR);
        int mm = myCalendar.get(Calendar.MONTH)+1;
        int dd = myCalendar.get(Calendar.DAY_OF_MONTH);
        return (dd+"/"+mm+"/"+yy).toString();

    }


}
