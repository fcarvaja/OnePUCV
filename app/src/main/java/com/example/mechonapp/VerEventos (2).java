package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class VerEventos extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajo;
    TrabajoEvento trabajoE;
    TextView agendados;
    ArrayList<Evento> listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_eventos);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);

        agendados = (TextView)findViewById(R.id.textView_EventosAgendados);
        trabajoE = new TrabajoEvento(this);
        listaEventos = trabajoE.selectEventos();

        for (Evento e:listaEventos) {
            if(e.getRutUsuario().equals(u.getRut()))
                agendados.append(e.getnSerieEvento()+". "+e.getTituloEvento()+"\n\n"+e.getDescEvento()+"\n\n"+"Fecha: "+e.getFechaEvento()+"\n\n\n -------------------------------------------------------------------- \n\n\n");
        }
    }

    //Método botón HOME

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }
}
