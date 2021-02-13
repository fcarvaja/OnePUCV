package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MenuPpal extends AppCompatActivity {

    WebView wv1;
    int contador = 0;
    TextView bienvenida;
    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ppal);

        wv1 = (WebView)findViewById(R.id.wv_Twitter);
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("https://twitter.com/secdocinfpucv");

        bienvenida = (TextView)findViewById(R.id.txt_Welcome);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);

        if(u.getSexo().equals("Femenino")){
            bienvenida.setText("Bienvenida "+u.getNombre()+" "+u.getApellido());
        }
        else if (u.getSexo().equals("Masculino")){
            bienvenida.setText("Bienvenido "+u.getNombre()+" "+u.getApellido());
        }
        else{
            bienvenida.setText("Bienvenide "+u.getNombre()+" "+u.getApellido());
        }
    }

    @Override
    public void onBackPressed() {

        if(contador == 0){
            Toast.makeText(this,"Presione nuevamente para salir",Toast.LENGTH_SHORT).show();
            contador++;
        }
        else{
            finishAffinity();
        }

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                contador = 0;
            }
        }.start();

    }

    //Métodos Botones

    public void logOut(View view){
        Intent logout = new Intent(this, LoginActivity.class);
        startActivity(logout);
        finish();
    }

    public void Planificador(View view){
        Intent planificador = new Intent(this, Planificador.class);
        planificador.putExtra("Id", u.getRut());
        startActivity(planificador);
        finish();
    }

    public void Perfil(View view){
        Intent perfil = new Intent(this, Perfil.class);
        perfil.putExtra("Id", u.getRut());
        startActivity(perfil);
        finish();
    }

    public void Horario(View view){
        Intent horario = new Intent(this, Horario.class);
        horario.putExtra("Id", u.getRut());
        startActivity(horario);
        finish();
    }

    public void Calculadora(View view){
        Intent calc = new Intent(this, CalculadoraNota.class);
        calc.putExtra("Id", u.getRut());
        startActivity(calc);
        finish();
    }

    public void MatEstudio(View view){
        Intent irAMaterial = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/4/folders/19Xmt_HB-1NNMQOFnA2DQ9zf9q3ng5vTE"));
        startActivity(irAMaterial);
    }

    public void Sanciones(View view){
        Intent sanciones = new Intent(this, Sanciones.class);
        sanciones.putExtra("Id", u.getRut());
        startActivity(sanciones);
        finish();
    }

    public void Profesores(View view){
        Intent profesores = new Intent(this, Profesores.class);
        profesores.putExtra("Id", u.getRut());
        startActivity(profesores);
        finish();
    }
}
