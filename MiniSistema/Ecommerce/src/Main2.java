
class Pessoa{
    String nome;
    int idade;
}

class Funcionario extends Pessoa{
    double salario;
}


public class Main2 {
    
    public static void main(String[] args) {
        
        Funcionario funcionario1 = new Funcionario();

        funcionario1.nome = "Manu";
        funcionario1.idade = 25;
        funcionario1.salario = 100;

        System.out.println("Nome: " + funcionario1.nome);
        System.out.println("Idade: " + funcionario1.idade);
        System.out.println("Salario: " + funcionario1.salario);

    }
}
