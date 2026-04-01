class Aluno{
    String nome;
    int idade;

    public Aluno (String nome, int idade){// construtor com os parametros 
        this.nome = nome;
        this.idade = idade;
    }

}

public class Main6{
    public static void main(String [] args){
        
        Pessoa p = new Pessoa ("Joao", 25);
        System.out.println(p.nome + "-"+ p.idade);
        
        
    }
}
