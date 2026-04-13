/*
Exercício 7
• Enunciado
• Crie uma classe Produto com:
– nome
– preco
• Se preço for negativo no construtor → mostrar
erro.
*/
import java.util.Scanner;
class Produto{
    private String nome;
    private double preco;

    public Produto(String nome, double preco){
        this.nome = nome;
        if(preco <=0){
            System.out.println("Erro! Valor inválido!");
        }else{
            this.preco = preco;
        }
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }


    public void exibirDados(){
        if(preco > 0){
        System.out.println("===============");
        System.out.println("Produto: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("===============");
        }
    }
}
public class Exercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do Produto: ");
        String nome = entrada.nextLine();

        System.out.println("Digite o Preço do Produto: ");
        double preco = entrada.nextDouble();

        Produto produto = new Produto(nome, preco);

        produto.exibirDados();
        entrada.close();


    }
}
