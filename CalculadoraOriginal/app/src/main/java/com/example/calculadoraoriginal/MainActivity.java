package com.example.calculadoraoriginal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declarando todos os objetos

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete,
    numeroOito, numeroNove, ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes(); // Recupera os id's dos componentes

        getSupportActionBar().hide(); // esconde a barra de ações

        // Recuperando os valores do clique do botão
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);

        // Evento que limpa as informações na tela
        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        // Evento que apaga digito a digito na tela
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0; // referencial para não crash a aplicação
                    int var1 = string.length()-1; // apaga uma posição da string total

                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        // Evento que realiza determinada operação após clicado no igual
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    // Utilizando a biblioteca de cálculos
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();

                    // irá avaliar a expressão e realizar as tratativas necessárias
                    double resultado = expressao.evaluate();

                    // conversão para um tipo maior
                    long lonfResult = (long) resultado;

                    // CharSequence é uma interface
                    if(resultado == (double)lonfResult){
                        txtResultado.setText((CharSequence) String.valueOf(lonfResult));
                    }else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });
    }

    // Método que recupera todos os id's do xml
    private void iniciarComponentes() {

        // Recuperando numeros
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);

        // Recuperando operadores
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        divisao = findViewById(R.id.bt_divisao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);

        // Recuperando Sinais e Gerais
        botao_limpar = findViewById(R.id.bt_limpar);
        ponto = findViewById(R.id.ponto);
        igual = findViewById(R.id.igual);

        // Recuperando Text Views e Image Views
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);

    }

    // Método que adiciona uma expressão inserida
    public void acrescentarUmaExpressao(String string, boolean limpar_dados){

        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }

        if(limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    /* Método que verifica por meio das id's de uma view dos seus elementos e adiciona um valor de String para o botão
    por meio do Método acrescentarUmaExpressao()*/
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            // Definindo a String do Botão para os números
            case R.id.numero_zero:
                acrescentarUmaExpressao("0", true);
                break;

            case R.id.numero_um:
                acrescentarUmaExpressao("1", true);
                break;

            case R.id.numero_dois:
                acrescentarUmaExpressao("2", true);
                break;

            case R.id.numero_tres:
                acrescentarUmaExpressao("3", true);
                break;

            case R.id.numero_quatro:
                acrescentarUmaExpressao("4", true);
                break;

            case R.id.numero_cinco:
                acrescentarUmaExpressao("5", true);
                break;

            case R.id.numero_seis:
                acrescentarUmaExpressao("6", true);
                break;

            case R.id.numero_sete:
                acrescentarUmaExpressao("7", true);
                break;

            case R.id.numero_oito:
                acrescentarUmaExpressao("8", true);
                break;

            case R.id.numero_nove:
                acrescentarUmaExpressao("9", true);
                break;

            // Definindo a String do Botão para operadores e o ponto
            case R.id.ponto:
                acrescentarUmaExpressao(".", true);
                break;

            case R.id.bt_soma:
                acrescentarUmaExpressao("+", false);
                break;

            case R.id.bt_subtracao:
                acrescentarUmaExpressao("-", false);
                break;

            case R.id.bt_divisao:
                acrescentarUmaExpressao("/", false);
                break;

            case R.id.bt_multiplicacao:
                acrescentarUmaExpressao("*", false);
                break;

        }
    }
}