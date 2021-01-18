package it.niccolosegato.coloregioni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.prefs.Preferences;

public class RegionActivity extends AppCompatActivity {

    protected Button abruzzo;
    protected Button basilicata;
    protected Button calabria;
    protected Button campania;
    protected Button emilia;
    protected Button friuli;
    protected Button lazio;
    protected Button liguria;
    protected Button lombardia;
    protected Button marche;
    protected Button molise;
    protected Button piemonte;
    protected Button puglia;
    protected Button sardegna;
    protected Button sicilia;
    protected Button toscana;
    protected Button trento;
    protected Button bolzano;
    protected Button umbria;
    protected Button valle;
    protected Button veneto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_region);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("coloregioni", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        abruzzo = (Button) findViewById(R.id.abruzzo);
        basilicata = (Button) findViewById(R.id.basilicata);
        calabria = (Button) findViewById(R.id.calabria);
        campania = (Button) findViewById(R.id.campania);
        emilia = (Button) findViewById(R.id.emilia);
        friuli = (Button) findViewById(R.id.friuli);
        lazio = (Button) findViewById(R.id.lazio);
        liguria = (Button) findViewById(R.id.liguria);
        lombardia = (Button) findViewById(R.id.lombardia);
        marche = (Button) findViewById(R.id.marche);
        molise = (Button) findViewById(R.id.molise);
        piemonte = (Button) findViewById(R.id.piemonte);
        puglia = (Button) findViewById(R.id.puglia);
        sardegna = (Button) findViewById(R.id.sardegna);
        sicilia = (Button) findViewById(R.id.sicilia);
        toscana = (Button) findViewById(R.id.toscana);
        trento = (Button) findViewById(R.id.trento);
        bolzano = (Button) findViewById(R.id.bolzano);
        umbria = (Button) findViewById(R.id.umbria);
        valle = (Button) findViewById(R.id.valle);
        veneto = (Button) findViewById(R.id.veneto);

        abruzzo.setOnClickListener(v -> {
            editor.putString("REGIONE", "Abruzzo");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        basilicata.setOnClickListener(v -> {
            editor.putString("REGIONE", "Basilicata");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        calabria.setOnClickListener(v -> {
            editor.putString("REGIONE", "Calabria");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        campania.setOnClickListener(v -> {
            editor.putString("REGIONE", "Campania");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        emilia.setOnClickListener(v -> {
            editor.putString("REGIONE", "Emilia-Romagna");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        friuli.setOnClickListener(v -> {
            editor.putString("REGIONE", "Friuli Venezia-Giulia");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        lazio.setOnClickListener(v -> {
            editor.putString("REGIONE", "Lazio");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        liguria.setOnClickListener(v -> {
            editor.putString("REGIONE", "Liguria");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        lombardia.setOnClickListener(v -> {
            editor.putString("REGIONE", "Lombardia");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        marche.setOnClickListener(v -> {
            editor.putString("REGIONE", "Marche");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        molise.setOnClickListener(v -> {
            editor.putString("REGIONE", "Molise");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        piemonte.setOnClickListener(v -> {
            editor.putString("REGIONE", "Piemonte");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        puglia.setOnClickListener(v -> {
            editor.putString("REGIONE", "Puglia");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        sardegna.setOnClickListener(v -> {
            editor.putString("REGIONE", "Sardegna");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        sicilia.setOnClickListener(v -> {
            editor.putString("REGIONE", "Sicilia");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        toscana.setOnClickListener(v -> {
            editor.putString("REGIONE", "Toscana");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        trento.setOnClickListener(v -> {
            editor.putString("REGIONE", "Provincia di Trento");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        bolzano.setOnClickListener(v -> {
            editor.putString("REGIONE", "Provincia di Bolzano");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        umbria.setOnClickListener(v -> {
            editor.putString("REGIONE", "Umbria");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        valle.setOnClickListener(v -> {
            editor.putString("REGIONE", "Valle d'Aosta");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });

        veneto.setOnClickListener(v -> {
            editor.putString("REGIONE", "Veneto");
            editor.apply();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}