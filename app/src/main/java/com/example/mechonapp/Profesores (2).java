package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Profesores extends AppCompatActivity {

    WebView wv_prof;

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);

        wv_prof = (WebView)findViewById(R.id.wv_Profesores);
        wv_prof.setWebViewClient(new WebViewClient());
        wv_prof.loadUrl("http://inf.ucv.cl/academicos/");

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);
    }

    public void onBackPressed() {
        //Método vacío que "deshabilita" el botón de RETOCESO del dispositivo.
    }

    //Método botón HOME

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }
}
