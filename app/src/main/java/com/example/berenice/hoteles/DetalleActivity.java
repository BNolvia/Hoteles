package com.example.berenice.hoteles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Berenice on 30/03/2017.
 */

public class DetalleActivity extends AppCompatActivity {
    String jsonString;
    String video="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle("Detalle de película");
        NetworkImageView niv= (NetworkImageView)findViewById(R.id.imagenDetalle);
        jsonString = getIntent().getStringExtra("pelicula");
        // JSONArray loans=response.getJSONArray("pelicula");
        try {
            JSONObject json = new JSONObject(jsonString);
            String url=json.getString("imagen");
            String video=json.getString("video");
            ((TextView) findViewById(R.id._nombre)).setText(json.getString("nombrehotel"));
            ((TextView) findViewById(R.id._descripcion)).setText(json.getString("descripcion"));
            ((TextView) findViewById(R.id._telefono)).setText("Género: "+json.getString("telefono"));
            ((TextView) findViewById(R.id._correo)).setText("Clasificación "+json.getString("correo"));
            niv.setImageUrl(url,MySingleton.getInstance(MainActivity.mContext).getImageLoader());

        } catch (JSONException excepcion) {

        } catch (Exception excepcion) {

            Log.d("DetalleActivity", excepcion.getMessage());
        }

        Log.d("DetalleActivity", "Terminar de crear actividad");
    }
}
