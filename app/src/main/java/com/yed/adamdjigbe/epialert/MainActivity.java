package com.yed.adamdjigbe.epialert;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.yed.classes.EpiMessage;
import com.yed.listeners.CustomOnItemSelectedListener;
import com.yed.listeners.SetDateListener;

import static com.yed.utils.FonctionsUtils.ChechFormValues;
import static com.yed.utils.FonctionsUtils.ConfirmerEpiMessage;
import static com.yed.utils.FonctionsUtils.FormIsFull;
import static com.yed.utils.FonctionsUtils.populateSetCurrentDate;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public static EditText txtNumero;
    public static EditText txtDate;
    public static EditText txtCas;
    public static EditText txtAge;
    public static Spinner spinnerDistrict;
    public static Spinner spinnerAire;
    public static Spinner spinnerSigne;
    public static RadioGroup radioGenre;
    public static Button btnValider;
    public static Button btnAnnuler;

    public static String numero ="";
    public static String district ="";
    public static String aire ="";
    public static String date ="";
    public static String cas ="";
    public static Integer age =0;
    public static String sexe ="";
    public static String signe ="";

    public static EpiMessage epiMessage;


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
        btnAnnuler = (Button) findViewById(R.id.btnAnnuler);

        ini.run();
    }


    Thread ini = new Thread(new Runnable() {
        @Override
        public void run() {
            SetDateListener formDate = new SetDateListener(txtDate, MainActivity.this);
            populateSetCurrentDate(txtDate);
            radioGenre.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    sexe = ((RadioButton)findViewById(checkedId)).getText().toString();
                    //Toast.makeText(getBaseContext(), sexe, Toast.LENGTH_SHORT).show();
                }
            });
            btnValider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckForm.run();
                }
            });
            btnAnnuler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.this.finish();
                }
            });
        }
    });

    Thread CheckForm = new Thread(new Runnable() {
        @Override
        public void run() throws NullPointerException{

            AsyncCheckValue asyncCheckValue = new AsyncCheckValue();
            try{
                numero = txtNumero.getText().toString();
                district = spinnerDistrict.getSelectedItem().toString();
                aire = spinnerAire.getSelectedItem().toString();
                date = txtDate.getText().toString();
                cas = txtCas.getText().toString();
                signe = spinnerSigne.getSelectedItem().toString() ;
                age = Integer.valueOf(txtAge.getText().toString()) ;
                Log.d("rg",String.valueOf(radioGenre.getCheckedRadioButtonId()));
                sexe = ((RadioButton)findViewById(radioGenre.getCheckedRadioButtonId())).getText().toString();

            }catch (NullPointerException ex){

            }catch (NumberFormatException ex){
                age = 0;
            }catch (Exception ex){

            }finally {

            }

            try {
                if(FormIsFull()){
                    epiMessage = new EpiMessage(numero, district, aire, date,cas, age, sexe, signe);
                    String message = epiMessage.ConsoliderMessageEpiAlert();
                    //Toast.makeText(getBaseContext(),"FormIsFull", Toast.LENGTH_SHORT).show();

                    ConfirmerEpiMessage(MainActivity.this, epiMessage);
                }else{
                    epiMessage = new EpiMessage(numero, district, aire, date,cas, age, sexe, signe);
                    Toast.makeText(getBaseContext(), Html.fromHtml("<font color=red>Verifier le formulaire</font>"), Toast.LENGTH_SHORT).show();
                    ChechFormValues(MainActivity.this, epiMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


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


}
