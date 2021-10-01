
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

public class MainActivity extends AppCompatActivity {
    private Button btnInserir;
    private ListView lista;

    private ArrayList<Alunos> alunos = new ArrayList<Alunos>();
    private AdapterAluno adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInserir = findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener( new AbrirAluno() );
        lista = findViewById( R.id.lista );

        // criando adaptador
        adaptador = new AdapterAluno( this, alunos );

        // associando o adaptador a lista
        lista.setAdapter( adaptador );

        // configurar a lista com o escutador de cliques comuns
        lista.setOnItemClickListener( new EscutadorLista() );

        // configurar a lista com o escutador de cliques longos
        lista.setOnItemLongClickListener( new EscutadorLista() );

    }

    private class AbrirAluno implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent i = new Intent( getApplicationContext(), MainActivity.class );
            startActivityForResult(i,1);
        }
    }


    private class EscutadorLista implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Toast.makeText(MainActivity.this, "Dados do aluno: " + "\nNome: "+alunos.get(i).getNome()+
                            "\nNota 1: "+alunos.get(i).getNota1() + "\nNota 2: "+alunos.get(i).getNota2() +
                            "\nMédia: "+alunos.get(i).getMedia(),
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            alunos.remove(i);
            adaptador.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Aluno deletado!", Toast.LENGTH_LONG).show();
            return true;
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent i) {

        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                String nome = i.getStringExtra("nome");
                String nota1 = i.getStringExtra("nota1");
                String nota2 = i.getStringExtra("nota2");
                String media = i.getStringExtra("media");

                Alunos a = new Alunos( nome, nota1, nota2, media );

                // inserindo no ArrayList
                alunos.add( a );

                // avisando o adapter que os dados foram atualizados
                adaptador.notifyDataSetChanged();

            }
        }
    }

}