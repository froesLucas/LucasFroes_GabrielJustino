import java.io.Serializable;

public class Alunos implements Serializable {
    private String nome,nota1, nota2,mediaf;

    public Alunos(String nome,String nota1,String nota2,String mediaf){
        this.nome=nome;
        this.nota1=nota1;
        this.nota2=nota2;
        this.mediaf=mediaf;
    }
    public String getNome() {
        return nome;
    }

    public String getNota1() {
        return nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public String getMedia() {
        return mediaf;
    }

}