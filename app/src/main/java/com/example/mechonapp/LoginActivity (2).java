package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user, pass;
    private TrabajoUsuario trab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.editText_user);
        pass = (EditText)findViewById(R.id.editText_password);
        trab = new TrabajoUsuario(this);

        SharedPreferences datosGuardados = getSharedPreferences("datos", Context.MODE_PRIVATE);
        user.setText(datosGuardados.getString("user", ""));
        pass.setText(datosGuardados.getString("password", ""));
    }

    public void onBackPressed() {
        Intent irAMain = new Intent(this, MainActivity.class);
        startActivity(irAMain);
        finish();
    }

    //Método botón ingresar

    public void Ingresar(View view){
        String user_string = user.getText().toString();
        String pass_string = pass.getText().toString();

        if(user_string.equals("") && user_string.equals("")){
            Toast.makeText(this, "Ingrese un usuario y contraseña", Toast.LENGTH_SHORT).show();
        }
        else if(trab.login(user_string, pass_string)==1){
            Usuario datosUsuario = trab.obtenerUsuario(user_string, pass_string);

            Intent ingresar = new Intent(this, MenuPpal.class);
            ingresar.putExtra("Id", datosUsuario.getRut());
            startActivity(ingresar);
            finish();

            if(((CheckBox)findViewById(R.id.check_Recordarme)).isChecked()){ //Si el Checkbox de recordar está marcado, guarda los datos ingresados en la aplicación para un uso futuro.
                SharedPreferences datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor objEditor = datos.edit();
                objEditor.putString("user", user_string);
                objEditor.putString("password", pass_string);
                ((CheckBox) findViewById(R.id.check_Recordarme)).setChecked(true);
                objEditor.commit();
            }
            else{
                SharedPreferences datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor objEditor = datos.edit();
                objEditor.putString("user", "");
                objEditor.putString("password", "");
                objEditor.commit();
            }
        }
        else{
            Toast.makeText(this, "usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }


    //Método Link Recuperar Contraseña

    public void Recuperar(View view){
        Intent recuperar = new Intent(this, RecuperarPassActivity.class);
        startActivity(recuperar);
    }
}
