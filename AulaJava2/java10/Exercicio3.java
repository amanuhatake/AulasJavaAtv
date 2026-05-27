import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite um numero: ");
            int numero = Integer.parseInt(sc.nextLine());

            System.out.println("Numero: " + numero);
        }catch(NumberFormatException e){
            System.out.println("Conversão não é possível!");
        }

        sc.close();
    }
}
