package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HorarioAgregarAsignatura extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajoU;
    TrabajoAsignatura trabajoA;

    private EditText siglaAsignatura, nombreAsignatura;
    private Spinner dia, clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_agregar_asignatura);

        siglaAsignatura = (EditText)findViewById(R.id.editText_siglaAsignatura);
        nombreAsignatura = (EditText)findViewById(R.id.editText_nombreAsignatura);

        dia = (Spinner)findViewById(R.id.spinner_diaSemana);
        clave = (Spinner)findViewById(R.id.spinner_claveDia);

        String[] diasSemana = {"Seleccione...", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        String[] clavesDia = {"Seleccione...", "1-2", "3-4", "5-6", "7-8", "9-10", "11-12", "13-14"};

        ArrayAdapter<String> objAdapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item_onepucv, diasSemana);
        dia.setAdapter(objAdapter1);

        ArrayAdapter<String>  objAdapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item_onepucv, clavesDia);
        clave.setAdapter(objAdapter2);

        trabajoA = new TrabajoAsignatura(this);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajoU = new TrabajoUsuario(this);
        u = trabajoU.obtenerUsuario(id);
    }

    public void onBackPressed() {
        finish();
    }

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }

    //Métodos botones

    public void agregarAsignatura(View view) {

        Asignatura a = new Asignatura();

        a.setSigla(siglaAsignatura.getText().toString());
        a.setNombre(nombreAsignatura.getText().toString());
        a.setDia(dia.getSelectedItem().toString());
        a.setClave(clave.getSelectedItem().toString());
        a.setRutUsuario(u.getRut());

        if (a.isNull()) {
            Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_LONG).show();
        }
        else if (trabajoA.insertAsignatura(a)) {
            Toast.makeText(this, "Asignatura agregada a tu Horario", Toast.LENGTH_LONG).show();

            Intent irAHorario = new Intent(this, Horario.class);
            irAHorario.putExtra("Id", u.getRut());
            startActivity(irAHorario);
            finish();
        }
        else {
            Toast.makeText(this, "No se pudo agregar la asignatura", Toast.LENGTH_LONG).show();
        }
    }
}
