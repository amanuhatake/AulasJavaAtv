/*Enunciado
• Crie uma classe Pedido com:
– numero
– valor
• Construtor inicializa tudo. */

import java.util.Scanner;
class Pedido {
    private int numero;
    private double valor;

    public Pedido(int numero, double valor){
        setNumero(numero);
        setValor(valor);
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        if(numero > 0){
            this.numero = numero;
        }else{
            System.out.println("ERRO! Numero de pedido inválido!");
            this.numero = 0;
        }
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        if(valor > 0 ){
            this.valor = valor;
        }else{
            System.out.println("ERRO! Valor do pedido Inválido!");
            this.valor = 0;
        }
    }

    public void exibirPedido(){
        System.out.println("===============");
        System.out.println("Numero do pedido: " + numero);
        System.out.println("Valor do pedido: " + valor);
        System.out.println("===============");
    }
}
public class Exercicio9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o numero do Pedido: ");
        int numero = entrada.nextInt();
      
        System.out.println("Digite o valor do Pedido: ");
        double valor = entrada.nextDouble();

        Pedido pedido = new Pedido(numero, valor);

        pedido.exibirPedido();
        entrada.close();
    }
}
