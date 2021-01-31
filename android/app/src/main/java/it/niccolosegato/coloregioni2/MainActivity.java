package it.niccolosegato.coloregioni2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    protected Button regioneBtn;
    protected Button dwnBtn;
    protected Button faqBtn;
    protected View mainView;
    protected TextView mainText;
    protected TextView subText;
    protected TextView subPar;
    protected TextView textView;
    protected TextView textView2;
    /*protected TextView dataPrev;
    protected TextView zonaPrev;
    protected CardView viewPrev;*/

    ProgressDialog dialog;

    @Override public void onBackPressed() {
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("coloregioni", 0); // 0 - for private mode
        String regionePref = pref.getString("REGIONE", "Abruzzo");

        regioneBtn = (Button) findViewById(R.id.regione);
        dwnBtn = (Button) findViewById(R.id.dwn);
        faqBtn = (Button) findViewById(R.id.faq);
        mainView = (View) findViewById(R.id.mainView);
        mainText = (TextView) findViewById(R.id.mainColor);
        subText = (TextView) findViewById(R.id.cosaFare);
        subPar = (TextView) findViewById(R.id.subCosa);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        /*dataPrev = (TextView) findViewById(R.id.dataPrev);
        zonaPrev = (TextView) findViewById(R.id.zonaPrev);
        viewPrev = (CardView) findViewById(R.id.viewPrev);*/

        //viewPrev.setVisibility(View.INVISIBLE);

        regioneBtn.setText(regionePref);

        regioneBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), RegionActivity.class);
            startActivity(intent);
        });

        dwnBtn.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.interno.gov.it/sites/default/files/2020-10/modello_autodichiarazione_editabile_ottobre_2020.pdf"));
            startActivity(browserIntent);
        });

        faqBtn.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.governo.it/it/articolo/domande-frequenti-sulle-misure-adottate-dal-governo/15638"));
            startActivity(browserIntent);
        });

        changeColor(regionePref);
    }

    protected void changeColor(String regione){
        dialog = ProgressDialog.show(this, "Attendi un attimo", "Sto scaricando i dati più aggiornati...");
        subText.setText(regione);
        new BackgroundWorker(this, mainText, mainView, subText, dialog, subPar, textView, textView2).execute(regione);
        //new PrevBackgroundWorker(this, zonaPrev, dataPrev, viewPrev).execute(regione);
    }
}