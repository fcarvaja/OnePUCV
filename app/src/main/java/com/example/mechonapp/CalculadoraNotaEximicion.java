package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculadoraNotaEximicion extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_nota_eximicion);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);
    }

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }
}
