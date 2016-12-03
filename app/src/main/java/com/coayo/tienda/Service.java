package com.coayo.tienda;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Service extends Activity {
    Context context; private List<Category> categoriasLista = new ArrayList<>();
    private String baseUrl = "http://coayomatos-001-site1.itempurl.com/odata/";
    private String imagenUrl = "http://coayomatos-001-site1.itempurl.com/content/images/thumbs/";
    TextView tv6;
   // private List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.servicio); context = this;
        Button btn = (Button) findViewById(R.id.button2); final TextView tv = (TextView) findViewById(R.id.tv_categoria);
        final TextView tv3 = (TextView) findViewById(R.id.textView3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL url = createURL("Category");
                tv6 = (TextView)findViewById(R.id.textView3);
                tv6.setText(url.toString());
                GetResult1 getok = new GetResult1();
               // tv2.setText((CharSequence) getok.);
                getok.execute(url);

            }
        });
    }

    // create la peticion Get del servicio
    private URL createURL(String argumento) {
        String Clave_privada = "3e6fca29e1383cdcf1c92701517fda46";
        String clave_publica = "5870cd9c13df1504333bdacadbbd0f10";
        String auth = "YW5kcm9pZEB5YWhvby5lczovc29YKzNVVlNHSXlQK0VUYUUwMzF1aEtzazRWMEFWQmphcGxkanhpV25rPQ==";
       // CREACION ARGUMENTO DE SOLICITUD AL SERVICIO REST

        String arg = argumento;
        try {
            String urlString = baseUrl + URLEncoder.encode(argumento, "UTF-8");// +
            return new URL(urlString);
        } catch (Exception e) {
               e.printStackTrace();
            return null;
        }

    }

    public class GetResult1 extends AsyncTask<URL, Void, JSONObject> {
       // private Context context;

        @Override
        //JSONObject
        protected JSONObject doInBackground(URL... params) {
            HttpURLConnection connection = null;
            String responsee ="";
            try {
                //CONEXION
                connection = (HttpURLConnection) params[0].openConnection();
                //preparacion de la cabecera
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("User-Agent","WebApiFornopCommerce");
                connection.setRequestProperty("Accept-Charset","UTF-8");
                connection.setRequestProperty("PublicKey","5870cd9c13df1504333bdacadbbd0f10");

                //autenticación BASIC
                connection.setRequestProperty("Authorization","Basic YW5kcm9pZEB5YWhvby5lczovc29YKzNVVlNHSXlQK0VUYUUwMzF1aEtzazRWMEFWQmphcGxkanhpV25rPQ==");
                connection.setRequestMethod("GET");

                // Hacer solicitud
                int response = connection.getResponseCode();
               // Toast.makeText(context,responsee,Toast.LENGTH_SHORT).show();

                if (response == HttpURLConnection.HTTP_OK) {
                    Log.e("conexion", "Correcto");
                    StringBuilder builder = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            Log.e("dowload",line);
                            builder.append(line);
                        }
                         // Toast.makeText(context, builder + " cadena entrada ", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                                       // Toast.makeText(context,e.toString(), Toast.LENGTH_LONG).show();
                                         e.printStackTrace();
                                        }
                        // Toast.makeText(context, builder + " cadena entrada ", Toast.LENGTH_SHORT).show();
                        //return new JSONObject(builder.toString());
                        return new JSONObject(builder.toString());

                } else {
                        Log.e("service", "error");
                        }
            } catch (Exception e) {
                       // Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
            } finally {
                connection.disconnect(); // close the HttpURLConnection
            }
           return null ;
        }

        protected void onProgressUpdate() {
            Toast.makeText(getBaseContext(), "Conectando",Toast.LENGTH_SHORT).show();
        }

        // process JSON response and update ListView
        @Override
        protected void onPostExecute(JSONObject responsee) {
         if (responsee!= null) convertJSONtoArrayList(responsee);
            else Toast.makeText(context, "datos nulos  ", Toast.LENGTH_SHORT).show();
          //  Toast.makeText(context, "post " + " ya se ejecuto ", Toast.LENGTH_SHORT).show();
          // tv6.setText(responsee.toString());
            //tv.set
            /*    convertJSONtoArrayList(weather); // repopulate weatherList
                weatherArrayAdapter.notifyDataSetChanged(); // rebind to ListView
                weatherListView.smoothScrollToPosition(0); // scroll to top
            */
            // AQUI VIENE LA RESPUESTA ASI QUE MUESTRA EL RESULTADO
        }


    }

    private void convertJSONtoArrayList(JSONObject categorias){

        categoriasLista.clear();// limpia lista vieja, crea lista de categorias

        try{
            JSONArray lista = categorias.getJSONArray("value");
            // convertir cada elemento de la lista en una categoria
            StringBuilder nombres = new StringBuilder();
            for (int i = 0; i < lista.length(); ++i){
                                 JSONObject categoria = lista.getJSONObject(i);
                                 // categorias.getJSONArray("value")
                                  categoriasLista.add(new Category(
                                                                categoria.getString("Name"),
                                                                categoria.getString("Description"),
                                                                categoria.getInt("Id"),
                                                                categoria.getInt("PictureId"),
                                                                categoria.getInt("ParentCategoryId")));

                                    nombres.append("  Nombre:  "+categoria.getString("Name")+ "  parentcategoryiD:  " + categoria.getString("ParentCategoryId"));// prueba(Frank)
                                  }
            tv6.setText(nombres);
             }
           catch(JSONException e) {
                         e.printStackTrace();

                             }


         }

    }
