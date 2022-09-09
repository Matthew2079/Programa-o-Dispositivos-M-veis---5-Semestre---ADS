package com.example.saude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class imcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
    }

    // Método que fecha a activity corrente
    public void fechar(View V){
        finish();
    }

    // Método para obter os valores inseridos
    public void calcular (View V){

        // Realiazando casting do valor lido e armazenando
        EditText peso = (EditText) findViewById(R.id.edtTextPeso);
        EditText altura = (EditText) findViewById(R.id.edtTextAltura);
        TextView valor = (TextView) findViewById(R.id.txtResultado);

        // Realizando o cálculo do IMC peso / (altura * altura)
        Float total = Float.parseFloat(peso.getText().toString())
                / ( Float.parseFloat(altura.getText().toString()) * Float.parseFloat(altura.getText().toString()) );

        // Imprimi o valor do IMC na Tela
        valor.setText( total.toString() );

    }
}