import java.io.Serializable;

public class Alunos implements Serializable {
    private String nome,nota1, nota2,mediaf;

    public Alunos(String nome,String nota1,String nota2,String mediaf){
        this.nome=nome;
        this.nota1=nota1;
        this.nota2=nota2;
        this.mediaf=mediaf;
    }

}