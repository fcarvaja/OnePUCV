package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Sanciones extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanciones);

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

    //Métodos Botones Información

    public void infoArt28(View view){
        Intent irAInfo28 = new Intent(this, Articulo28.class);
        irAInfo28.putExtra("Id", u.getRut());
        startActivity(irAInfo28);
    }

    public void infoArt33(View view){
        Intent irAInfo33 = new Intent(this, Articulo33.class);
        irAInfo33.putExtra("Id", u.getRut());
        startActivity(irAInfo33);
    }

    public void infoTM(View view){
        Intent irAInfoTM = new Intent(this, TribunalMerito.class);
        irAInfoTM.putExtra("Id", u.getRut());
        startActivity(irAInfoTM);
    }

    //Métodos Botones Documento Tipo

    public void DocArt28(View view){
        Intent irA28 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/1QX1SUBVgxY68MgS2sqwXFsPxEuds_7iG"));
        startActivity(irA28);
    }

    public void DocArt33(View view){
        Intent irA33 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/1RfPFdMG62wuWXI2hAfpz0c7ItTs6a4q6"));
        startActivity(irA33);
    }

    public void DocTribunal(View view){
        Intent irATribunal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/1Zh0dsltOeljEZVcKMChO4d7Y6c69Skd4"));
        startActivity(irATribunal);
    }
}
