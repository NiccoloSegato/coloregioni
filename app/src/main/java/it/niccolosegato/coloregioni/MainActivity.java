package it.niccolosegato.coloregioni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    protected Button regione;
    protected View mainView;
    protected TextView mainText;
    protected TextView subText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Preferences prefs = Preferences.userNodeForPackage(it.niccolosegato.coloregioni.MainActivity.class);
        String regionePref = prefs.get("REGIONE", "Abruzzo");

        regione = (Button) findViewById(R.id.regione);
        mainView = (View) findViewById(R.id.mainView);
        mainText = (TextView) findViewById(R.id.mainColor);
        subText = (TextView) findViewById(R.id.cosaFare);
        regione.setText(regionePref);

        changeColor(regionePref);
    }

    protected void changeColor(String regione){
        subText.setText(regione);
        new BackgroundWorker(this, mainText).execute(regione);
    }
}