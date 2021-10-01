package com.example.primeiroapdedm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.primeiroapdedm.R;

import java.util.ArrayList;

public class AdapterAluno extends ArrayAdapter<Alunos> {

    // contexto
    private Context context;

    private ArrayList<Alunos> alunos;

    public AdapterAluno(Context context, ArrayList<Alunos> alunos) {

        super(context, R.layout.lista_desenho, alunos);
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.lista_desenho, parent, false);

        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblNota1 = itemView.findViewById(R.id.lblNota1);
        TextView lblNota2 = itemView.findViewById(R.id.lblNota2);
        TextView lblMedia = itemView.findViewById(R.id.lblMedia);

        lblNome.setText(alunos.get(position).getNome());
        lblNota1.setText(alunos.get(position).getNota1());
        lblNota2.setText(alunos.get(position).getNota2());
        lblMedia.setText(alunos.get(position).getMedia());

        return itemView;
    }
}

