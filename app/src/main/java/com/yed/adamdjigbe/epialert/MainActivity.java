package com.yed.adamdjigbe.epialert;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.yed.classes.EpiMessage;
import com.yed.listeners.CustomOnItemSelectedListener;
import com.yed.listeners.SetDateListener;

import static com.yed.utils.FonctionsUtils.populateSetCurrentDate;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    EditText txtNumero;
    EditText txtDate;
    EditText txtCas;
    EditText txtAge;
    Spinner spinnerDistrict;
    Spinner spinnerAire;
    Spinner spinnerSigne;
    RadioGroup radioGenre;
    Button btnValider;

    String numero;
    String district;
    String aire;
    String date;
    String cas;
    Integer age;
    String sexe;
    String signe;

    EpiMessage epiMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        txtNumero = (EditText) findViewById(R.id.txtphoneNo);
        txtDate = (EditText) findViewById(R.id.txtDate);
        txtCas = (EditText) findViewById(R.id.txtnomCas);
        txtAge = (EditText) findViewById(R.id.txtAge);
        radioGenre = (RadioGroup) findViewById(R.id.radioGenre);
        spinnerDistrict = (Spinner) findViewById(R.id.spinnerDistrict);
        spinnerAire = (Spinner) findViewById(R.id.spinnerAire);
        spinnerDistrict.setOnItemSelectedListener(new CustomOnItemSelectedListener(spinnerAire, this));
        spinnerSigne = (Spinner) findViewById(R.id.spinnerSigne);
        btnValider = (Button) findViewById(R.id.btnValider);

        ini.run();
    }


    Thread ini = new Thread(new Runnable() {
        @Override
        public void run() {
            SetDateListener formDate = new SetDateListener(txtDate, MainActivity.this);
            populateSetCurrentDate(txtDate);
            radioGenre.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Toast.makeText(getBaseContext(), sexe, Toast.LENGTH_SHORT).show();
                }
            });
            btnValider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckForm.run();
                }
            });
        }
    });

    Thread CheckForm = new Thread(new Runnable() {
        @Override
        public void run() {

            AsyncCheckValue asyncCheckValue = new AsyncCheckValue();
            try{
                numero = txtNumero.getText().toString();
                district = spinnerDistrict.getSelectedItem().toString();
                aire = spinnerAire.getSelectedItem().toString();
                date = txtDate.getText().toString();
                cas = txtCas.getText().toString();
                signe = spinnerSigne.getSelectedItem().toString() ;
                age = Integer.valueOf(txtAge.getText().toString()) ;
                sexe = ((RadioButton)findViewById(radioGenre.getCheckedRadioButtonId())).getText().toString();

            }catch (NullPointerException ex){

            }catch (NumberFormatException ex){
                age = 0;
            }catch (Exception ex){

            }finally {

            }


            epiMessage = new EpiMessage(numero, district, aire, date,cas, age, sexe, signe);
            String message = epiMessage.ConsoliderMessageEpiAlert();
            Toast.makeText(getBaseContext(),message, Toast.LENGTH_SHORT).show();

            asyncCheckValue.execute();
        }
    });

    private class AsyncCheckValue extends AsyncTask<Integer, Void, Void> {
        @Override
        protected Void doInBackground(Integer... paramses) {
            try
            {


            }catch( Exception e )
            {
                e.printStackTrace();
            }

            return null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.yed.adamdjigbe.epialert/http/host/path")
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
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.yed.adamdjigbe.epialert/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
