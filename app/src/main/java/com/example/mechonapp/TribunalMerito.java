package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class TribunalMerito extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tribunal_merito);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);
    }

    //Método botón HOME

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }

    public void DocTribunal(View view){
        Intent irATribunal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/1Zh0dsltOeljEZVcKMChO4d7Y6c69Skd4"));
        startActivity(irATribunal);
    }
}
