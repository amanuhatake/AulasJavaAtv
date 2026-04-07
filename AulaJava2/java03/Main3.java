/*Crie uma classe Funcionario com:
– nome
– salario
• Crie um construtor que já calcule bônus de 10% */

class Funcionario{
    String nome;
    double salario;

    public Funcionario (String nome, double salario){
        this.nome = nome;
        double bonus = salario * 0.10;
        this.salario = salario + bonus;

    }
}

public class Main3 {
    public static void main(String[] args) {
        Funcionario fun = new Funcionario("Manu", 15000);

        System.out.println("Nome do funcionario: " + fun.nome);
        System.out.println("Salario com bonus: " + fun.salario);

    }
}
