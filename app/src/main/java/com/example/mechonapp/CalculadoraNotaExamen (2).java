package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraNotaExamen extends AppCompatActivity {

    private EditText np, pond;
    private TextView mensaje1, mensaje2;

    String id;
    Usuario u;
    TrabajoUsuario trabajo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_nota_examen);

        np = (EditText)findViewById(R.id.editText_NP);
        pond = (EditText)findViewById(R.id.editText_Ponderacion);
        mensaje1 = (TextView)findViewById(R.id.textView_Mensaje1);
        mensaje2 = (TextView)findViewById(R.id.textView_Mensaje2);

        np.setText("00");
        pond.setText("00");

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);
    }

    public void onBackPressed() {
        finish();
    }

    //Método botón HOME

    public void irAHome(View view){
        Intent home = new Intent(this, MenuPpal.class);
        home.putExtra("Id", u.getRut());
        startActivity(home);
        finish();
    }

    //Método botón Calcular Nota

    public void calcularNota(View view){
        String np_string = np.getText().toString();
        String pond_string = pond.getText().toString();

        int np_int = Integer.parseInt(np_string);
        int pond_int = Integer.parseInt(pond_string);
        float pond_float = (float) pond_int/100;

        if(np_int >= 10 && np_int <= 70){
            if(pond_int >= 1 && pond_int <= 99){
                if(np_int > 34 && np_int < 55){ //Por reglamento, para poder rendir exámen, la nota de presentación (NP) debe ser mayor a 34
                    float ne_float = (40-(np_int*pond_float))/(1-pond_float);
                    int notaExamen = Math.round(ne_float);
                    if(notaExamen < 10)
                        notaExamen = 10;
                    String resultado = String.valueOf(notaExamen);
                    mensaje1.setText("Necesitas en tu examen:");
                    mensaje2.setText(resultado);
                }
                else if(np_int > 54){
                    mensaje1.setText("¡Felicidades! Estas eximido.");
                    mensaje2.setText("");
                }
                else{
                    mensaje1.setText("Lo siento... Has reprobado.");
                    mensaje2.setText("");
                }
            }
            else{
                Toast.makeText(this,"Debe ingresar una ponderacion entre 1% y 99%",Toast.LENGTH_LONG).show();
            }

        }
        else{
            Toast.makeText(this,"Debe ingresar una nota entre 10 y 70", Toast.LENGTH_LONG).show();
        }
    }
}
