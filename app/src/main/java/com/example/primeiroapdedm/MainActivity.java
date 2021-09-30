package com.example.primeiroapdedm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private  Button btnVolta;
    private  Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVolta=(Button) findViewById(R.id.btnVolta);
        btnVolta.setOnClickListener( new EscutadorBotaoVolta());

        btnOk=(Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener( new EscutadorBotaoOk());


    }
    private class EscutadorBotaoVolta implements View.OnClickListener{
        @Override
        public void onClick(View view){
            //finish();
            onBackPressed();
        }
    }
    private class EscutadorBotaoOk implements View.OnClickListener{
        @Override
        public void onClick(View view){
            //pegando informações
            EditText txtNome= (EditText) findViewById(R.id.txtNome);
            EditText txtNota1= (EditText) findViewById(R.id.txtNota1);
            EditText txtNota2= (EditText) findViewById(R.id.txtNota2);
            // variaveis
            String nome,nota1, nota2,mediaf;
            Double  media;
            //agregando valor
            nome= txtNome.getText().toString();
            nota1=txtNota1.getText().toString();
            nota2=txtNota2.getText().toString();
            media=(Double.valueOf(nota1)*Double.valueOf(nota2))/2;
            mediaf=media.toString();
            //Colocando em objeto aluno
            Aluno a = new Aluno(nome,nota1,nota2,mediaf);
            //Intent
           Intent i = new Intent(getApplicationContext(),ExibeActivity.class);
           //colocar dados
            i.putExtra("Aluno",a);
            //iniciar a activity
            startActivity(i);
        }

    }
    //Objeto Aluno
    public class Aluno implements Serializable{
        private String nome,nota1, nota2,mediaf;

        public Aluno(String nome,String nota1,String nota2,String mediaf){
            this.nome=nome;
            this.nota1=nota1;
            this.nota2=nota2;
            this.mediaf=mediaf;
        }
        public String getNome(){
            return nome;
        }

        public String getMediaf() {
            return mediaf;
        }

        public String getNota1() {
            return nota1;
        }

        public String getNota2() {
            return nota2;
        }
    }

}