/*Exercício 2
• Crie uma classe ContaBancaria com:
– titular
– saldo
• Regras:
– saldo não pode ser negativo */

import java.util.Scanner;

class ContaBancaria{
    private String titular;
    private double saldo;

    public ContaBancaria (String titular, double saldo){
        this.titular = titular;
        setSaldo(saldo);
    }

    public String getTitular(){
        return titular;
    }
    public void setTitular(String titular){
        this.titular = titular; 
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        if(saldo >= 0){
            this.saldo = saldo;
        }else{
            System.out.println("Saldo inválido");
            this.saldo = 0;//valor setado para zero mesmo negativo
        }
    
    }  

    public void exibirDados(){
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
    
    
} 

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Qual seu nome: " );
        String titular = entrada.nextLine();

        System.out.println("Digite o saldo: ");
        double saldo = entrada.nextDouble();
        
        ContaBancaria conta = new ContaBancaria(titular, saldo);

        conta.exibirDados();
        entrada.close();
        
    }
}
