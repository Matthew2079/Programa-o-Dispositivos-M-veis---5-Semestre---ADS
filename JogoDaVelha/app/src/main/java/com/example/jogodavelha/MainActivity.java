package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Button botao11, botao12, botao13;
    Button botao21, botao22, botao23;
    Button botao31, botao32, botao33;
    TextView vencedor;
    String jogador = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciando todos os botões do projeto
        botao11 = (Button) findViewById(R.id.btn11);
        botao12 = (Button) findViewById(R.id.btn12);
        botao13 = (Button) findViewById(R.id.btn13);
        botao21 = (Button) findViewById(R.id.btn21);
        botao22 = (Button) findViewById(R.id.btn22);
        botao23 = (Button) findViewById(R.id.btn23);
        botao31 = (Button) findViewById(R.id.btn31);
        botao32 = (Button) findViewById(R.id.btn32);
        botao33 = (Button) findViewById(R.id.btn33);

        // Instanciando todas labels do projeto
        vencedor = (TextView) findViewById(R.id.txtVencedor);

    }

    public void novoJogo(View v){

        jogador = "X";

        //TextView vencedor = (TextView) findViewById(R.id.txtVencedor);

        // Zerando todos os botões
        botao11.setText("");
        botao12.setText("");
        botao13.setText("");

        botao21.setText("");
        botao22.setText("");
        botao23.setText("");

        botao31.setText("");
        botao32.setText("");
        botao33.setText("");

        // Resetando as labels
        vencedor.setText("");
    }

    public void jogada(View v) {

        Button botao = (Button) findViewById(v.getId());

        TextView vencedor = (TextView) findViewById(R.id.txtVencedor);

        if (botao.getText().toString().equals("")) {

            botao.setText(jogador);

            if (jogador == "X") {
                jogador = "O";
            } else {
                jogador = "X";
            }
        }

        // Verificando as linhas
        if (botao11.getText().toString().equals("X") & botao12.getText().toString().equals("X") & botao13.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao11.getText().toString().equals("O") & botao12.getText().toString().equals("O") & botao13.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");
        else if (botao21.getText().toString().equals("X") & botao22.getText().toString().equals("X") & botao23.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao21.getText().toString().equals("O") & botao22.getText().toString().equals("O") & botao23.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");
        else if (botao31.getText().toString().equals("X") & botao32.getText().toString().equals("X") & botao33.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao31.getText().toString().equals("O") & botao32.getText().toString().equals("O") & botao33.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");

        // Verificando as colunas
        else if (botao11.getText().toString().equals("X") & botao21.getText().toString().equals("X") & botao31.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao11.getText().toString().equals("O") & botao21.getText().toString().equals("O") & botao31.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");
        else if (botao12.getText().toString().equals("X") & botao22.getText().toString().equals("X") & botao32.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao12.getText().toString().equals("O") & botao22.getText().toString().equals("O") & botao32.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");
        else if (botao13.getText().toString().equals("X") & botao23.getText().toString().equals("X") & botao33.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao13.getText().toString().equals("O") & botao23.getText().toString().equals("O") & botao33.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");

        // Verificando as diagonais
        else if (botao11.getText().toString().equals("X") & botao22.getText().toString().equals("X") & botao33.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao11.getText().toString().equals("O") & botao22.getText().toString().equals("O") & botao33.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");
        else if (botao13.getText().toString().equals("X") & botao22.getText().toString().equals("X") & botao31.getText().toString().equals("X"))
            vencedor.setText("Vencedor: Jogador X");
        else if (botao13.getText().toString().equals("O") & botao22.getText().toString().equals("O") & botao31.getText().toString().equals("O"))
            vencedor.setText("Vencedor: Jogador O");

        // Se houver empate
        else if (botao11.getText().toString() != "" & botao12.getText().toString() != "" & botao13.getText().toString() != "" &
        botao21.getText().toString() != "" & botao22.getText().toString() != "" & botao23.getText().toString() != "" &
        botao31.getText().toString() != "" & botao32.getText().toString() != "" & botao33.getText().toString() != "")
            vencedor.setText("Empate");

        else
            vencedor.setText("");

    }
}