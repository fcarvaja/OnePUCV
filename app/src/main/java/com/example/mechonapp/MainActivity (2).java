package com.example.mechonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBackPressed() {
        finishAffinity();
    }

    //Métodos para botones login y registro

    public void Login(View view){
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    public void Registro(View view){
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }
}
