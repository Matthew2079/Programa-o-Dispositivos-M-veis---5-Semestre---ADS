package com.example.saude;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Abaixo deste comando roda os comandos definindos na classe filho, estes prevalecem sobre a classe pai.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R - Resources
    }

    // Definindo o método para chamada da activity Imc
    public void abrirImc(View v){
        Intent tela = new Intent(this, imcActivity.class); // Classe destinada para embarcar uma aplicação;
        startActivity(tela);
    }
}