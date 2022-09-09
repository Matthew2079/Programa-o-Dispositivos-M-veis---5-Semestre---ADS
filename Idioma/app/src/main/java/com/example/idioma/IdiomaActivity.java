package com.example.idioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class IdiomaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mudarIdioma();
        setContentView(R.layout.activity_idioma);
    }

    // Método que verifica o idioma salvo e carrega ele
    public void mudarIdioma(){

        // Instanciando em modo de leitura
        SharedPreferences dados = getSharedPreferences("fatec", MODE_PRIVATE);
        String lang = dados.getString("Idioma", "pt");

        // Instanciando o idioma
        Locale idioma = new Locale(lang);
        Locale.setDefault(idioma);

        // Definindo as novas configurações
        Context context = this;
        Resources res = context.getResources();

        // Carregando as novas configurações
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

    }

    public void sair(View V){
        finish();
    }

    // Definindo os Métodos que trocam o idioma do app

    // Português
    public void idiomaPT(View V){

        // Instanciando o idioma
        Locale idioma = new Locale("pt");
        Locale.setDefault(idioma);

        // Definindo as novas configurações
        Context context = this;
        Resources res = context.getResources();

        // Carregando as novas configurações
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        // Instanciando em modo de gravação
        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("Idioma", "pt");
        dados.apply();

        recreate(); // Recriando o xml
    }

    // Inglês
    public void idiomaEN(View V){

        // Instanciando o idioma
        Locale idioma = new Locale("en");
        Locale.setDefault(idioma);

        // Definindo as novas configurações
        Context context = this;
        Resources res = context.getResources();

        // Carregando as novas configurações
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        // Instanciando em modo de gravação
        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("Idioma", "en");
        dados.apply();

        recreate(); // Recriando o xml
    }

    // Espanhol
    public void idiomaES(View V){

        // Instanciando o idioma
        Locale idioma = new Locale("es");
        Locale.setDefault(idioma);

        // Definindo as novas configurações
        Context context = this;
        Resources res = context.getResources();

        // Carregando as novas configurações
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        // Instanciando em modo de gravação
        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("Idioma", "es");
        dados.apply();

        recreate(); // Recriando o xml
    }

}
