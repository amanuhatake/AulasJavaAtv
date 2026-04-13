/*Exercício 3
• Enunciado
• Crie uma classe Produto com:
– nome
– preco
• Regras:
– preço deve ser maior que 0 */
import java.util.Scanner;
class Produto{
    private String nome;
    private double preco;

    public Produto (String nome, double preco){
        this.nome = nome;
        setPreco(preco);
    }

    public String getNome(){
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        if(preco > 0){
            this.preco = preco;
        }else{
            System.out.println("Valor inválido!");
            this.preco = 0; //setando o valor de preço
        }
    }

    public void ExibirProduto(){
        System.out.println("===============");
        System.out.println("Produto: " + nome);
        System.out.println("Preço do produto: " + preco);
        System.out.println("===============");
    }

}

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do produto desejado: ");
        String nome = entrada.nextLine();
        
        System.out.println("Digite o preço: ");
        double preco = entrada.nextDouble();

        Produto produto = new Produto(nome,preco);

        produto.ExibirProduto(); //pega o void de exibir produtos dentro da classe 
        entrada.close();

    }

}
