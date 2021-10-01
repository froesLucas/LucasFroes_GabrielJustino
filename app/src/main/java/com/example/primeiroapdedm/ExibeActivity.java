package com.example.primeiroapdedm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ExibeActivity extends AppCompatActivity {
    private  Button btnInserir;
    private ListView lista;
    ArrayList<Alunos> informacoes= new ArrayList<Alunos>();


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
        Intent i = getIntent();
        Alunos a=new Alunos(i.getStringExtra("nome"),i.getStringExtra("nota1"),i.getStringExtra("nota2"),i.getStringExtra("media"));
        informacoes.add(a);
        //Aplicar no adapter
        ArrayAdapter<Alunos> adapter =new ArrayAdapter<Alunos>(ExibeActivity.this, android.R.layout.simple_list_item_1,informacoes);
        lista.setAdapter(adapter);
        //clicks
        lista.setOnItemClickListener(new EscutadorComum());
        lista.setLongClickable(true);
        //lista.setOnItemLongClickListener(new EscutadorCliqueLongo());

    }
    private class EscutadorComum implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
            Toast.makeText(ExibeActivity.this,informacoes.get(i).toString(),Toast.LENGTH_SHORT).show();
        }
    }
    private class EscutadorCliqueLongo implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView,View view,int i,long l){
            informacoes.indexOf(i);
            Toast.makeText(ExibeActivity.this,"Excluido",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private class EscutadorBotaoInserir implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent i= new Intent( getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }
}