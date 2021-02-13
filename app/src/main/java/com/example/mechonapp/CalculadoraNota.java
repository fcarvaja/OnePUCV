package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CalculadoraNota extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    private Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_nota);

        opciones = (Spinner)findViewById(R.id.spinner_QueCalcular);

        String[] opcionesCalcular = {"Seleccione...", "Nota para Eximirse", "Nota Examen"};

        ArrayAdapter <String> objAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item_onepucv, opcionesCalcular);
        opciones.setAdapter(objAdapter);

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

    //Método botón Ir

    public void irAOpcionSeleccionada(View view) {

        String seleccion = opciones.getSelectedItem().toString();

        if(seleccion.equals("Nota para Eximirse")){
            Intent eximicion = new Intent(this, CalculadoraNotaEximicion.class);
            eximicion.putExtra("Id", u.getRut());
            startActivity(eximicion);
        }
        else if(seleccion.equals("Nota Examen")){
            Intent examen = new Intent(this, CalculadoraNotaExamen.class);
            examen.putExtra("Id", u.getRut());
            startActivity(examen);
        }
    }
}
