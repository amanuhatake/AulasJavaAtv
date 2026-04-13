/*Enunciado
• Crie uma classe Funcionario com:
– nome
– salario
• Crie um construtor que já calcule bônus de
10%. */

import java.util.Scanner;

class Funcionario {
    private String nome;
    private double salario;

    public Funcionario (String nome, double salario){
        this.nome = nome;
        setSalario(salario);
        aumentarSalario(); //já cria o funcionario atualizado
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        if(salario >=0){
            this.salario = salario;
        }else{
            System.out.println("Valor Inválido!");
        }
    }

    public void aumentarSalario(){
        this.salario += this.salario * 0.10;
    }

    public void exibirDados(){
        System.out.println("=====================");
        System.out.println("Salario Atualizado: " + salario);
        System.out.println("=====================");
    }

    
}

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.println("Digite seu salario: ");
        double salario = entrada.nextDouble();

        Funcionario funcionario = new Funcionario(nome, salario);

        funcionario.exibirDados();
        entrada.close();

    }
}
