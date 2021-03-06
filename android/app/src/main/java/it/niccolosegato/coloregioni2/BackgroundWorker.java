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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BackgroundWorker extends AsyncTask {

    private TextView mainColorE;
    private View mainView;
    private TextView subText;
    private TextView subPar;
    private ProgressDialog dialog;
    private Context context;
    private TextView textView;
    private TextView textView2;

    BackgroundWorker(Context context, TextView mainColor, View mainView, TextView subText, ProgressDialog dialog, TextView subPar , TextView textView, TextView textView2) {
        this.context = context;
        mainColorE = mainColor;
        this.mainView = mainView;
        this.subText = subText;
        this.dialog = dialog;
        this.subPar = subPar;
        this.textView = textView;
        this.textView2 = textView2;
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
        switch (result.toString()){
            case "Zona Gialla":
                mainView.setBackgroundColor(Color.parseColor("#fdd835"));
                subText.setText(R.string.cosaG);
                subPar.setText(R.string.amiciG);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Activity act = (Activity) context;
                    Window window = act.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#c6a700"));
                }
                mainColorE.setTextColor(Color.BLACK);
                subText.setTextColor(Color.BLACK);
                subPar.setTextColor(Color.BLACK);
                textView.setTextColor(Color.BLACK);
                textView2.setTextColor(Color.BLACK);
                dialog.dismiss();
                break;
            case "Zona Arancione":
                mainView.setBackgroundColor(Color.parseColor("#fb8c00"));
                subText.setText(R.string.cosaA);
                subPar.setText(R.string.amiciA);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Activity act = (Activity) context;
                    Window window = act.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#c25e00"));
                }
                mainColorE.setTextColor(Color.BLACK);
                subText.setTextColor(Color.BLACK);
                subPar.setTextColor(Color.BLACK);
                textView.setTextColor(Color.BLACK);
                textView2.setTextColor(Color.BLACK);
                dialog.dismiss();
                break;
            case "Zona Rossa":
                mainView.setBackgroundColor(Color.parseColor("#d32f2f"));
                subText.setText(R.string.cosaR);
                subPar.setText(R.string.amiciA);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Activity act = (Activity) context;
                    Window window = act.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#9a0007"));
                }
                mainColorE.setTextColor(Color.WHITE);
                subText.setTextColor(Color.WHITE);
                subPar.setTextColor(Color.WHITE);
                textView.setTextColor(Color.WHITE);
                textView2.setTextColor(Color.WHITE);
                dialog.dismiss();
                break;
            default:
                mainView.setBackgroundColor(Color.WHITE);
                subText.setText(R.string.cosaE);
                mainColorE.setTextColor(Color.BLACK);
                subText.setTextColor(Color.BLACK);
                subPar.setTextColor(Color.BLACK);
                textView.setTextColor(Color.BLACK);
                textView2.setTextColor(Color.BLACK);
                dialog.dismiss();
                break;
        }
    }
}