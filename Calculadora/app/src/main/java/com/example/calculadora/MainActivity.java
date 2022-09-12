package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText campo1, campo2;
    TextView resultado;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Definindo os campos de entrada de dados
        campo1 = (EditText) findViewById(R.id.num1);
        campo2 = (EditText) findViewById(R.id.num2);

        // Definindo a label que informa o resultado
        resultado = (TextView) findViewById(R.id.result);
    }

    // Metódo que obtém os números informados pelo usúario
    public boolean lerNumeros() {

        // Recebendo os valores os números
        String s1 = campo1.getText().toString();
        String s2 = campo2.getText().toString();

        // Verifica se existem números informados nos campos
        if ((s1.equals(null) && s2.equals(null)) || (s1.equals("") && s2.equals(""))) {

            String result = "Insira os números para calcular...";
            resultado.setText(result);

            return false;

        } else {
            // Converte os valores recebidos para realizar os cálculos
            num1 = Double.parseDouble(s1);
            num2 = Double.parseDouble(s2);
        }
        return true;
    }

    // Método para somar os números
    public void somar(View v) {
        if (lerNumeros()) {
            double soma = num1 + num2;
            resultado.setText(Double.toString(soma));
        }
    }

    // Método para subtrair os números
    public void subtrair(View v) {
        if (lerNumeros()) {
            double subtracao = num1 - num2;
            resultado.setText(Double.toString(subtracao));
        }
    }

    // Método para multiplicar os números
    public void multiplicar(View v) {
        if (lerNumeros()) {
            double multiplicacao = num1 * num2;
            resultado.setText(Double.toString(multiplicacao));
        }
    }

    // Método para dividir os números
    public void dividir(View v) {
        if (lerNumeros()) {
            if (num1 >= 0 & num2 > 0) {
                double divisao = num1 / (num2);
                resultado.setText(Double.toString(divisao));
            } else
                resultado.setText("Não é possível dividir por zero");
        }
    }

    // Método para fazer a potência de um número
    public void potencia(View v) {
        if (lerNumeros()) {
            double elevado = Math.pow(num1, num2);
            resultado.setText(Double.toString(elevado));
        }
    }

    // Método para fazer o mod
    public void mod(View v) {
        if (lerNumeros()) {
            double resto = num1 % num2;
            resultado.setText(Double.toString(resto));
        }
    }

    // Método para limpar os campos
    public void limpar(View V) {
        campo1.setText("");
        campo2.setText("");
        resultado.setText("O Resultado .....");
    }
}