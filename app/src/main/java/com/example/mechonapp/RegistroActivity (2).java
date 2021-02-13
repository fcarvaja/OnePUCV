package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombre, apellido, rut, email, usuario, pass;
    private RadioButton rbF, rbM, rbO;
    private TrabajoUsuario trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (EditText)findViewById(R.id.editText_Nombre);
        apellido = (EditText)findViewById(R.id.editText_Apellido);
        rut = (EditText)findViewById(R.id.editText_RUT);
        email = (EditText)findViewById(R.id.editText_email);
        usuario = (EditText)findViewById(R.id.editText_usuario);
        pass = (EditText)findViewById(R.id.editText_password);
        rbF = (RadioButton)findViewById(R.id.radioButton_OpcF);
        rbM = (RadioButton)findViewById(R.id.radioButton_OpcM);
        rbO = (RadioButton)findViewById(R.id.radioButton_OpcO);

        trabajo = new TrabajoUsuario(this);
    }

    //Método botón Registrar

    public void RegistrarUsuario(View view){

        Usuario u = new Usuario();

        u.setNombre(nombre.getText().toString());
        u.setApellido(apellido.getText().toString());
        u.setRut(rut.getText().toString());
        u.setEmail(email.getText().toString());
        u.setnUsuario(usuario.getText().toString());
        u.setPassword(pass.getText().toString());

        if(rbF.isChecked() == true)
            u.setSexo("Femenino");
        else if(rbM.isChecked() == true)
            u.setSexo("Masculino");
        else if(rbO.isChecked() == true)
            u.setSexo("Otro");

        if(u.isNull()) {
            Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_LONG).show();
        }
        else if(trabajo.insertUsuario(u)) {
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();

            nombre.setText("");
            apellido.setText("");
            rut.setText("");
            email.setText("");
            usuario.setText("");
            pass.setText("");
            rbF.setChecked(false);
            rbM.setChecked(false);
            rbO.setChecked(false);
        }
        else {
            Toast.makeText(this, "Usuario (Rut y/o Nombre de usuario) Ya Registrado", Toast.LENGTH_LONG).show();

            nombre.setText("");
            apellido.setText("");
            rut.setText("");
            email.setText("");
            usuario.setText("");
            pass.setText("");
            rbF.setChecked(false);
            rbM.setChecked(false);
            rbO.setChecked(false);
        }
    }
}
