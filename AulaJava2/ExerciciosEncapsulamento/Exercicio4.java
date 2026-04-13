/*Enunciado
• Crie uma classe ContaBancaria com:
– titular
– saldo
• Construtor deve iniciar saldo com valor
informado */
import java.util.Scanner;
class ContaBancaria {
    private String nome;
    private double saldo;

    public ContaBancaria (String nome, double saldo){
        this.nome = nome;
        setSaldo(saldo);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        if(saldo >= 0 ){
            this.saldo = saldo;
        }else{
            System.out.println("Valor não informado!"); 
            this.saldo = 0;
        }
        
    }

    public void exibirDados (){
        System.out.println("==========");
        System.out.println("Nome: " + nome);
        System.out.println("Saldo: " + saldo);
        System.out.println("==========");
    }

}


public class Exercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu nome para acessar seu saldo: ");
        String nome = entrada.nextLine();

        System.out.println("Digite seu saldo: "); //somando com o que ja está setado 
        double saldo = entrada.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, saldo);

        conta.exibirDados();
        entrada.close();
        
        

    }
}
