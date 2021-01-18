package it.niccolosegato.coloregioni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    protected View mainView;
    protected TextView mainText;
    protected TextView subText;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("coloregioni", 0); // 0 - for private mode
        String regionePref = pref.getString("REGIONE", "Abruzzo");

        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        regioneBtn = (Button) findViewById(R.id.regione);
        mainView = (View) findViewById(R.id.mainView);
        mainText = (TextView) findViewById(R.id.mainColor);
        subText = (TextView) findViewById(R.id.cosaFare);
        regioneBtn.setText(regionePref);

        regioneBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), RegionActivity.class);
            startActivity(intent);
        });


        changeColor(regionePref);
    }

    protected void changeColor(String regione){
        subText.setText(regione);
        new BackgroundWorker(this, mainText, mainView, subText).execute(regione);
    }
}