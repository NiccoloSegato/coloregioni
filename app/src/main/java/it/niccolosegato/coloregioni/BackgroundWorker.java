package it.niccolosegato.coloregioni;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import it.niccolosegato.coloregioni.R;

public class BackgroundWorker extends AsyncTask {

    private TextView mainColorE;

    BackgroundWorker(Context context, TextView mainColor) {
        mainColorE = mainColor;
    }

    @Override
    protected Object doInBackground(Object... params) {
        String regione = params[0].toString();

        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL("https://polimi-replay.it/applicazione/getdata.php?nome="+regione);
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
        mainColorE.setText(result.toString());
    }
}