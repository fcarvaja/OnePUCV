package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Articulo33 extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo33);

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

    public void DocArt33(View view){
        Intent irA33 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/1RfPFdMG62wuWXI2hAfpz0c7ItTs6a4q6"));
        startActivity(irA33);
    }
}
