package com.example.primeiroapdedm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExibeActivity extends AppCompatActivity {
    private  Button btnInserir;
    private ListView lista;
    private ArrayList<String> informacoes= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);
        //ligando botao
        btnInserir=(Button) findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener( new EscutadorBotaoInserir());
        //ligando lista
        lista=findViewById(R.id.lista);
        //Exibir Lista

    }
    private class EscutadorBotaoInserir implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent i= new Intent( getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }
}