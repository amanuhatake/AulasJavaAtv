package java04;

class Aluno{
    String nome;
    int idade;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade; 
    }

    public void setIdade(int idade){
        if (idade > 0){
            this.idade = idade;
            System.out.println("Entrada permitida! Idade: " + idade + "Bem-vindo!");
            
        }else{
            System.out.println("Entrada não permitida! Valor colocar idade válida");
        }
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        Aluno estudante = new Aluno();
        estudante.setNome("Manu");
        estudante.setIdade(20);

        System.out.println(estudante.getNome());
    }
}
