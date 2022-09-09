package com.example.idioma;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void abrirIdioma(View V) {
        Intent tela = new Intent(this, IdiomaActivity.class);
        //startActivityForResult(tela, 1);
        abreIdiomaActivity.launch(tela); // Executa o método rodando a partir da tela corrente
    }

    ActivityResultLauncher<Intent> abreIdiomaActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                }
                recreate();
            }
    );

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
            recreate();
    }*/

}