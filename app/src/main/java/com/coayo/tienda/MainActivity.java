package com.coayo.tienda;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class MainActivity extends Activity{
    Context context;TextView tvtest; Boolean errorcx = false; Button btnfin;
    private List<Category> categoriasLista = new ArrayList<Category>();
    private String baseUrl = "http://coayomatos-001-site1.itempurl.com/odata/";
    private String imagenUrl = "http://coayomatos-001-site1.itempurl.com/content/images/thumbs/";
    private String Clave_privada = "3e6fca29e1383cdcf1c92701517fda46";
    private String clave_publica = "5870cd9c13df1504333bdacadbbd0f10";
    private String auth = "YW5kcm9pZEB5YWhvby5lczovc29YKzNVVlNHSXlQK0VUYUUwMzF1aEtzazRWMEFWQmphcGxkanhpV25rPQ==";

    private CatAdapter catAdapter;
    private RecyclerView.LayoutManager catLyMan;
   //private CatAdapterListener listener;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                btnfin = (Button)findViewById(R.id.btnfin);

                setContentView(R.layout.activity_main);
                context = this; tvtest = (TextView)findViewById(R.id.tvtest);
                final RecyclerView rv1 = (RecyclerView)findViewById(R.id.rv1);
                //final ArrayList<Category> catDataset;

                btnfin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       // finish();
                    }
                });
                rv1.setHasFixedSize(true);
                catLyMan = new LinearLayoutManager(this);
                rv1.setLayoutManager(catLyMan);

                URL url = createURL("Category");
                GetResult2 getok = new GetResult2();
                getok.execute(url);// hago peticion de categorias;
                //final List<Category> catDataset = getok.categoriasLista1;

               // final List<Category> catDataset = new ArrayList<Category>();
                CatAdapter adapter;
                if (!errorcx){
                        final List<Category> listadefault;
                        listadefault= new ArrayList<Category>();
                        listadefault.add(new Category("cat1","desc",0,1,0));
                        listadefault.add(new Category("cat2","desc2",0,2,0));
                        listadefault.add(new Category("cat3","desc",0,3,0));
                        listadefault.add(new Category("cat4","desc",0,4,0));
                        adapter = new CatAdapter(listadefault);
                        }else{
                            final List<Category> catDataset = categoriasLista;
                            adapter = new CatAdapter(catDataset);
                                }
               // final RecyclerView rv1 = (RecyclerView)findViewById(R.id.)

                rv1.setAdapter(adapter);

              /*  adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Category catsel = catDataset.get(rv1.getChildLayoutPosition(view));
                    }
                });*/

            }

  /*  public void setCatAdapterListener(CatAdapterListener listener){
        this.listener = listener;
    }*/

// PROCEDIMIENTOS ***********************************
// create la peticion Get del servicio, El argumento es la parte de peticion luego del path;
    private URL createURL(String argumento) {
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

// CLASE GetResult2 DE LA CONEXION A INTERNET
public class GetResult2 extends AsyncTask<URL, Void, JSONObject> {
    public List<Category> categoriasLista1 = new ArrayList<Category>();

    @Override
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
            connection.setRequestProperty("Authorization","Basic YW5kcm9pZEB5YWhvby5lczovc29YKzNVVlNHSXlQK0VUYUUwMzF1aEtzazRWMEFWQmphcGxkanhpV25rPQ==");
            connection.setRequestMethod("GET");
            // Hacer solicitud
            int response = connection.getResponseCode();
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
    // process JSON response and update ListView
    @Override
    protected void onPostExecute(JSONObject responsee) {
        if (responsee!= null) {
            //categoriasLista1 = convertJSONtoArrayList(responsee);
            convertJSONtoArrayList(responsee);
        }
        else {Toast.makeText(context, "datos nulos  ", Toast.LENGTH_SHORT).show();
            tvtest.setText("Error");
            errorcx = true;
        }
    }

 /*   protected void onProgressUpdate() {
        Toast.makeText(context, "Conectando",Toast.LENGTH_SHORT).show();
    }*/

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
                nombres.append("  Nombre:  "+categoria.getString("Name")+ "  parentcategoryiD:  " +
                        categoria.getString("ParentCategoryId"));// prueba(Frank)
            }
            tvtest.setText(nombres);
            // return categoriasLista;
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        //return categoriasLista;
    }


}
