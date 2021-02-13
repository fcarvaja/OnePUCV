package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Articulo28 extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    private TextView info28;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo28);

        info28 = (TextView)findViewById(R.id.textView_InfoArt28);

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

    //Métodos Botones Documento Tipo

    public void DocArt28(View view){
        Intent irA28 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/1QX1SUBVgxY68MgS2sqwXFsPxEuds_7iG"));
        startActivity(irA28);
    }

}
