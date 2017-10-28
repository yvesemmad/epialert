package com.yed.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.telephony.SmsManager;
import android.text.Html;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.yed.adamdjigbe.epialert.MainActivity;
import com.yed.adamdjigbe.epialert.R;
import com.yed.classes.EpiMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by emmanuel on 22/10/2017.
 */
public class FonctionsUtils extends MainActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    public static void populateSetCurrentDate(EditText mEditText) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        mEditText.setText(dd + "/" + mm + "/" + yy);
    }

    protected static void sendSMSMessage(Context ctx, EpiMessage epiMessage) {

        Log.d("sendSMSMessage", epiMessage.ConsoliderMessageEpiAlert());

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(epiMessage.getNumero(), null, epiMessage.ConsoliderMessageEpiAlert(), null, null);
            Toast.makeText(ctx,
                    "sendSMSMessage: " + epiMessage.ConsoliderMessageEpiAlert(),
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.getMessage();
            Log.d("sendSMS_Exception", e.getMessage());

        }

    }

    public String GetCurrentDateSystem() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdformat = new SimpleDateFormat(myFormat, Locale.US);
        final Calendar myCalendar = Calendar.getInstance();
        int yy = myCalendar.get(Calendar.YEAR);
        int mm = myCalendar.get(Calendar.MONTH) + 1;
        int dd = myCalendar.get(Calendar.DAY_OF_MONTH);
        //String string = (sdformat.format(myCalendar.getTime()));
        return (dd + "/" + mm + "/" + yy).toString();

    }

    public Calendar GetCurrentCalendarDateSystem() {
        final Calendar myCalendar = Calendar.getInstance();
        return myCalendar;

    }

    public String GetEditTextValue(EditText et) {
        String text = null;
        try {
            text = et.getText().toString();
        } catch (Exception e) {
            text = "";
        }
        return text;
    }

    public static void ChechFormValues(final Context ctx, final EpiMessage epiMessage) throws Exception {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(ctx, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(ctx);
        }

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setTitle(R.string.dialog_epimessage_title)
                .setMessage(Html.fromHtml(epiMessage.getDialogEpiMessageAlert()))
                .setNeutralButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .create()
                .show();

        // 3. Get the AlertDialog from create()
        //AlertDialog dialog = builder.create();
    }

    public static void reinitialiserChampsForm() {
        txtNumero.setText("");
        txtCas.setText("");
        txtAge.setText("");

    }

    public static Boolean FormIsFull() throws Exception {
        Boolean bool = false;
        //numero;district; aire;        date;        cas;        age;        sexe;        signe;
        if (!((numero.isEmpty()) || (district.isEmpty()) || (aire.isEmpty()) || (date.isEmpty()) ||
                (cas.isEmpty()) || (sexe.isEmpty()) || (signe.isEmpty()) || (age <= 0))) {
            if(CheckNumeroFormat(numero)){
                bool = true;
            }
        }
        return bool;
    }

    public static Boolean CheckNumeroFormat(String numero){
        Boolean bool = false;
        //TODO CheckNumeroFormat 1 Size, **RegEx
        return bool;
    }

    public static void ConfirmerEpiMessage(final Context ctx, final EpiMessage epiMessage) throws Exception {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(ctx, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(ctx);
        }

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setTitle(R.string.dialog_epimessage_title)
                .setMessage(Html.fromHtml(epiMessage.getDialogEpiMessageAlert()))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        sendSMSMessage(ctx, epiMessage);
                        reinitialiserChampsForm();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.presence_online)
                .setCancelable(false)
                .create()
                .show();

        // 3. Get the AlertDialog from create()
        //AlertDialog dialog = builder.create();
    }

    public static void kllMyPid() {
        int p = android.os.Process.myPid();
        Process.killProcess(p);
    }

    public static void QuitMyFullApp(Context ctx) {
        Intent intent = ctx.getPackageManager()
                .getLaunchIntentForPackage(ctx.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ctx.startActivity(intent);
    }

    public static Boolean setTrueBooleanVar(Boolean var) {
        return var = true;
    }


    //==============================================================================================
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "FonctionsUtils Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.yed.utils/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "FonctionsUtils Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.yed.utils/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
