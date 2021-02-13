package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarEvento extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;
    TrabajoEvento trabajoE;

    EditText titulo, fecha, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_evento);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);

        titulo = (EditText) findViewById(R.id.editText_tituloEvento);
        fecha = (EditText)findViewById(R.id.editText_FechaEvento);
        descripcion = (EditText)findViewById(R.id.editText_DescEvento);

        trabajoE = new TrabajoEvento(this);
    }

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }

    public void  agendarEvento(View view){
        Evento objEvento = new Evento();

        objEvento.setTituloEvento(titulo.getText().toString());
        objEvento.setFechaEvento(fecha.getText().toString());
        objEvento.setDescEvento(descripcion.getText().toString());
        objEvento.setRutUsuario(u.getRut());

        if (objEvento.isNull()) {
            Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_LONG).show();
        }
        else if (trabajoE.insertEvento(objEvento)) {
            Toast.makeText(this, "Evento Agendado", Toast.LENGTH_LONG).show();

            Intent irAPlanificador = new Intent(this, Planificador.class);
            irAPlanificador.putExtra("Id", u.getRut());
            startActivity(irAPlanificador);
            finish();
        }
        else {
            Toast.makeText(this, "No se pudo agendar el evento", Toast.LENGTH_LONG).show();
        }
    }
}
