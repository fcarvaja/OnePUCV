package com.example.mechonapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Horario extends AppCompatActivity {

    String id;
    Usuario u;
    TrabajoUsuario trabajoU;
    TrabajoAsignatura trabajoA;
    ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

    TextView l1_2, l3_4, l5_6, l7_8, l9_10, l11_12, l13_14, ma1_2, ma3_4, ma5_6, ma7_8, ma9_10, ma11_12, ma13_14, mi1_2, mi3_4, mi5_6, mi7_8, mi9_10, mi11_12, mi13_14, j1_2, j3_4, j5_6, j7_8, j9_10, j11_12, j13_14, v1_2, v3_4, v5_6, v7_8, v9_10, v11_12, v13_14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajoU = new TrabajoUsuario(this);
        u = trabajoU.obtenerUsuario(id);

        l1_2= (TextView)findViewById(R.id.textView_L1_2);
        l3_4= (TextView)findViewById(R.id.textView_L3_4);
        l5_6= (TextView)findViewById(R.id.textView_L5_6);
        l7_8= (TextView)findViewById(R.id.textView_L7_8);
        l9_10= (TextView)findViewById(R.id.textView_L9_10);
        l11_12= (TextView)findViewById(R.id.textView_L11_12);
        l13_14= (TextView)findViewById(R.id.textView_L13_14);
        ma1_2= (TextView)findViewById(R.id.textView_Ma1_2);
        ma3_4= (TextView)findViewById(R.id.textView_Ma3_4);
        ma5_6= (TextView)findViewById(R.id.textView_Ma5_6);
        ma7_8= (TextView)findViewById(R.id.textView_Ma7_8);
        ma9_10= (TextView)findViewById(R.id.textView_Ma9_10);
        ma11_12= (TextView)findViewById(R.id.textView_Ma11_12);
        ma13_14= (TextView)findViewById(R.id.textView_Ma13_14);
        mi1_2= (TextView)findViewById(R.id.textView_Mi1_2);
        mi3_4= (TextView)findViewById(R.id.textView_Mi3_4);
        mi5_6= (TextView)findViewById(R.id.textView_Mi5_6);
        mi7_8= (TextView)findViewById(R.id.textView_Mi7_8);
        mi9_10= (TextView)findViewById(R.id.textView_Mi9_10);
        mi11_12= (TextView)findViewById(R.id.textView_Mi11_12);
        mi13_14= (TextView)findViewById(R.id.textView_Mi13_14);
        j1_2= (TextView)findViewById(R.id.textView_J1_2);
        j3_4= (TextView)findViewById(R.id.textView_J3_4);
        j5_6= (TextView)findViewById(R.id.textView_J5_6);
        j7_8= (TextView)findViewById(R.id.textView_J7_8);
        j9_10= (TextView)findViewById(R.id.textView_J9_10);
        j11_12= (TextView)findViewById(R.id.textView_J11_12);
        j13_14= (TextView)findViewById(R.id.textView_J13_14);
        v1_2= (TextView)findViewById(R.id.textView_V1_2);
        v3_4= (TextView)findViewById(R.id.textView_V3_4);
        v5_6= (TextView)findViewById(R.id.textView_V5_6);
        v7_8= (TextView)findViewById(R.id.textView_V7_8);
        v9_10= (TextView)findViewById(R.id.textView_V9_10);
        v11_12= (TextView)findViewById(R.id.textView_V11_12);
        v13_14= (TextView)findViewById(R.id.textView_V13_14);

        trabajoA = new TrabajoAsignatura(this);

        listaAsignaturas = trabajoA.selectAsignaturas();

        // Llenado del Horario en pantalla
        for (int i=0; i<listaAsignaturas.size(); i++) {
            if(listaAsignaturas.size() > 0){
                Asignatura a = new Asignatura();
                a = listaAsignaturas.get(i);
                if(a.getRutUsuario().equals(u.getRut())){
                    switch (a.getDia()){
                        case "Lunes":
                            switch (a.getClave()){
                                case "1-2":
                                    l1_2.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "3-4":
                                    l3_4.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "5-6":
                                    l5_6.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "7-8":
                                    l7_8.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "9-10":
                                    l9_10.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "11-12":
                                    l11_12.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "13-14":
                                    l13_14.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                            }
                            break;
                        case "Martes":
                            switch (a.getClave()){
                                case "1-2":
                                    ma1_2.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "3-4":
                                    ma3_4.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "5-6":
                                    ma5_6.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "7-8":
                                    ma7_8.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "9-10":
                                    ma9_10.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "11-12":
                                    ma11_12.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "13-14":
                                    ma13_14.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                            }
                            break;
                        case "Miercoles":
                            switch (a.getClave()){
                                case "1-2":
                                    mi1_2.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "3-4":
                                    mi3_4.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "5-6":
                                    mi5_6.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "7-8":
                                    mi7_8.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "9-10":
                                    mi9_10.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "11-12":
                                    mi11_12.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "13-14":
                                    mi13_14.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                            }
                            break;
                        case "Jueves":
                            switch (a.getClave()){
                                case "1-2":
                                    j1_2.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "3-4":
                                    j3_4.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "5-6":
                                    j5_6.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "7-8":
                                    j7_8.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "9-10":
                                    j9_10.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "11-12":
                                    j11_12.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "13-14":
                                    j13_14.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                            }
                            break;
                        case "Viernes":
                            switch (a.getClave()){
                                case "1-2":
                                    v1_2.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "3-4":
                                    v3_4.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "5-6":
                                    v5_6.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "7-8":
                                    v7_8.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "9-10":
                                    v9_10.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "11-12":
                                    v11_12.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                                case "13-14":
                                    v13_14.setText(a.getSigla()+" "+a.getNombre());
                                    break;
                            }
                            break;
                    }
                }
            }
        }
    }

    public void onBackPressed() {
        //Método vacío que "deshabilita" el botón de RETROCESO del dispositivo.
    }

    //Método botón HOME

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }

    //Métodos Botones

    public void  agregarAsignatura(View view){
        Intent agregar = new Intent(this, HorarioAgregarAsignatura.class);
        agregar.putExtra("Id", u.getRut());
        startActivity(agregar);
    }

    public void vaciarHorario(View view){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("¿Está seguro de querer vaciar su horario?");
        mensaje.setCancelable(false);
        mensaje.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                trabajoA.borrarAsignaturas(u.getRut());
                recreate();
            }
        });

        mensaje.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog titulo = mensaje.create();
        titulo.setTitle("Vaciar Horario");
        titulo.show();
    }
}
