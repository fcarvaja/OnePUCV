package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Planificador extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificador);

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

    public void agregarEvento(View view){
        Intent agregar = new Intent(this, AgregarEvento.class);
        agregar.putExtra("Id", u.getRut());
        startActivity(agregar);
    }

    public void verEventos(View view){
        Intent verEv = new Intent(this, VerEventos.class);
        verEv.putExtra("Id", u.getRut());
        startActivity(verEv);
    }
}
