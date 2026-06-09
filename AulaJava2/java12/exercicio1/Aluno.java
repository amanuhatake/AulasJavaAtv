import java.io.Serializable;
class Aluno implements Serializable {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    @Override
    public String toString(){
        return nome + "-" + idade + "anos";
    }
}