package com.coayo.tienda;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 22/11/2016.
 */
public class GetResult extends AsyncTask<URL, Void, String> {
    private Context context;
    public GetResult(Context context){
        this.context = context;
    }
    @Override
    //JSONObject
    protected String doInBackground(URL... params) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) params[0].openConnection();
            int response = connection.getResponseCode();
            //
            int n = 1;
            String key;
            List<String> cabeceras = new ArrayList<String>();

            while ((key = connection.getHeaderFieldKey(n)) != null) {
                String valuee = connection.getHeaderField(n);
                cabeceras.add(key.toString() + "   " + valuee.toString());
                String responsee = key + "  " + valuee;
                n++;
            }
            //
            if (response == HttpURLConnection.HTTP_OK) {
                StringBuilder builder = new StringBuilder();

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                } catch (IOException e) {
                           /*Snackbar.make(findViewById(R.id.coordinatorLayout),
                                    R.string.read_error, Snackbar.LENGTH_LONG).show();*/
                    e.printStackTrace();
                }

                // return new JSONObject(builder.toString());
                return "todo ok";
            } else {
                return "mal";
                // SACA UN JSON OBJECT
                        /*Snackbar.make(findViewById(R.id.coordinatorLayout),
                                R.string.connect_error, Snackbar.LENGTH_LONG).show();*/
            }
        } catch (Exception e) {
                      /*  Snackbar.make(findViewById(R.id.coordinatorLayout),
                                R.string.connect_error, Snackbar.LENGTH_LONG).show();*/
            e.printStackTrace();
        } finally {
            connection.disconnect(); // close the HttpURLConnection
        }
        return null;
    }

    // process JSON response and update ListView
    @Override
    // protected void onPostExecute(JSONObject weather) {
    protected void onPostExecute(String responsee) {
        Toast.makeText(context, responsee + " ya se ejecuto ", Toast.LENGTH_SHORT).show();
        //tv.set
            /*    convertJSONtoArrayList(weather); // repopulate weatherList
                weatherArrayAdapter.notifyDataSetChanged(); // rebind to ListView
                weatherListView.smoothScrollToPosition(0); // scroll to top
            */
        // AQUI VIENE LA RESPUESTA ASI QEU MUESTRA EL RESULTADO
    }
}