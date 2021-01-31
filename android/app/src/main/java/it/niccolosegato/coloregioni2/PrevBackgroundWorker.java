package it.niccolosegato.coloregioni2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class PrevBackgroundWorker extends AsyncTask {

    private Context context;
    private TextView zonaPrev;
    private TextView dataPrev;
    private CardView viewPrev;

    PrevBackgroundWorker(Context context, TextView zonaPrev, TextView dataPrev, CardView viewPrev) {
        this.context = context;
        this.zonaPrev = zonaPrev;
        this.dataPrev = dataPrev;
        this.viewPrev = viewPrev;
    }

    @Override
    protected Object doInBackground(Object... params) {
        String regione = params[0].toString();

        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL("https://polimi-replay.it/applicazione/getprev.php?nome="+regione);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                return line;
            }
        } catch (Exception mue) {
            mue.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object result) {
        if(!result.toString().equals("-")){
            zonaPrev.setText(result.toString());
            viewPrev.setVisibility(View.VISIBLE);
            switch (result.toString()) {
                case "Zona Gialla":
                    viewPrev.setBackgroundColor(Color.parseColor("#fdd835"));
                    dataPrev.setTextColor(Color.BLACK);
                    zonaPrev.setTextColor(Color.BLACK);
                    break;
                case "Zona Arancione":
                    viewPrev.setBackgroundColor(Color.parseColor("#fb8c00"));
                    dataPrev.setTextColor(Color.BLACK);
                    zonaPrev.setTextColor(Color.BLACK);
                    break;
                case "Zona Rossa":
                    viewPrev.setBackgroundColor(Color.parseColor("#d32f2f"));
                    dataPrev.setTextColor(Color.WHITE);
                    zonaPrev.setTextColor(Color.WHITE);
                    break;
                default:
                    viewPrev.setBackgroundColor(Color.WHITE);
                    dataPrev.setTextColor(Color.BLACK);
                    zonaPrev.setTextColor(Color.BLACK);
                    break;
            }
        }
    }
}