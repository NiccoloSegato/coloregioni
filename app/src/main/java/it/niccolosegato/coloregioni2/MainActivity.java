package it.niccolosegato.coloregioni2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.prefs.Preferences;

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

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("coloregioni", 0); // 0 - for private mode
        String regionePref = pref.getString("REGIONE", "Abruzzo");

        AdView mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        regioneBtn = (Button) findViewById(R.id.regione);
        dwnBtn = (Button) findViewById(R.id.dwn);
        faqBtn = (Button) findViewById(R.id.faq);
        mainView = (View) findViewById(R.id.mainView);
        mainText = (TextView) findViewById(R.id.mainColor);
        subText = (TextView) findViewById(R.id.cosaFare);
        subPar = (TextView) findViewById(R.id.subCosa);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
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
    }
}