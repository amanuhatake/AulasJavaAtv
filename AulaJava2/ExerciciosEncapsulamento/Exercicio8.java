/*Enunciado
• Crie uma classe Aluno com:
– nome
– nota
• Construtor deve validar:
– nota entre 0 e 10 */

import java.util.Scanner;

class Aluno{
    private String nome; 
    private double nota;

    public Aluno(String nome, double nota){
        this.nome = nome;

        if(nota < 0){
            System.out.println("Erro nota inferior a 0!");
            this.nota = 0;
        }else if(nota > 10){
            System.out.println("Nota fora da padronização, será corrigido");
            this.nota = 10;
        }else{
            this.nota = nota;
        }
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getNota(){
        return nota; 
    }

    public void setNota(double nota){
        if(nota >=0 && nota <=10){
            this.nota = nota;
        }
    }

    public void exibirDados(){
        System.out.println("===============");
        System.out.println("Nome do Aluno " + nome);
        System.out.println("Nota do Aluno " + nota);
        System.out.println("===============");
        
    }
}

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome Aluno: ");
        String nome = entrada.nextLine();

        System.out.println("Digite o nota do Aluno: ");
        double nota = entrada.nextDouble();

        Aluno aluno = new Aluno(nome, nota);

        aluno.exibirDados();
        entrada.close();
    }
}
