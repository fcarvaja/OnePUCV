package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Perfil extends AppCompatActivity {

    EditText nombre, apellido, fNac, email, nUsuario, pass, descripcion;

    String id;
    Usuario u;
    TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombre = (EditText)findViewById(R.id.editText_editNombre);
        apellido = (EditText)findViewById(R.id.editText_editApellido);
        fNac = (EditText)findViewById(R.id.editText_editFNacimiento);
        email = (EditText)findViewById(R.id.editText_editEmail);
        nUsuario = (EditText)findViewById(R.id.editText_editNomUsuario);
        pass = (EditText)findViewById(R.id.editText_editPass);
        descripcion = (EditText)findViewById(R.id.editText_editDescripcion);

        Bundle b = getIntent().getExtras();
        id = b.getString("Id");
        trabajo = new TrabajoUsuario(this);
        u = trabajo.obtenerUsuario(id);

        nombre.setText(u.getNombre());
        apellido.setText(u.getApellido());
        fNac.setText(u.getfNacimiento());
        email.setText(u.getEmail());
        nUsuario.setText(u.getnUsuario());
        pass.setText(u.getPassword());
        descripcion.setText(u.getDescripcion());
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

    //Método botón GuardarDatos

    public void guardarDatos(View view){

        u.setNombre(nombre.getText().toString());
        u.setApellido(apellido.getText().toString());
        u.setfNacimiento(fNac.getText().toString());
        u.setEmail(email.getText().toString());
        u.setnUsuario(nUsuario.getText().toString());
        u.setPassword(pass.getText().toString());
        u.setDescripcion(descripcion.getText().toString());

        trabajo.actualizarUsuario(u);

        Toast.makeText(this, "Datos Guardados con Exito", Toast.LENGTH_LONG).show();

        Intent actualizado = new Intent(this, MenuPpal.class);
        actualizado.putExtra("Id", u.getRut());
        startActivity(actualizado);
        finish();

    }
}
