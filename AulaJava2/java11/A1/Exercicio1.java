package A1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.txt", true));// true = pode colocar mais coisas sem precisar criar outro arquivo 

            System.out.println("Cliente: ");
            String nome = sc.nextLine();

            System.out.println("Produto: ");
            String produto = sc.nextLine();

            System.out.println("Valor do produto: ");
            double valor = sc.nextDouble();

            bw.write("Cliente: " + nome);
            bw.newLine();

            bw.write("Produtor: " + produto);
            bw.newLine();

            bw.write("Valor do produtor: "+ valor);
            bw.newLine();

            bw.close();

            System.out.println("Pedido salvo!");
            System.out.println("============== Leitura de Arquivo =============");
            BufferedReader br = new BufferedReader(new FileReader("pedidos.txt"));

            String linha; 

            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
            br.close();

        }catch(IOException e){
            System.out.println("Erro no sistema!");
        }
        sc.close();
    }
    
}
