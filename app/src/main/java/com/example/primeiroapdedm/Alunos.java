package com.example.primeiroapdedm;

import java.io.Serializable;

public class Alunos implements Serializable {
    private String nome,mediaf,nota1,nota2;
    public Alunos(String nome, String nota1, String nota2, String mediaf) {
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
    @Override
    public String toString() {
        return  "nome: "+getNome()+"/n"+" nota 1: "+getNota1()+" nota 2: "+getNota2()+" media:"+getMediaf();
    }
}
