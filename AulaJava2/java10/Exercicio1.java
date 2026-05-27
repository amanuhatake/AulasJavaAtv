import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //cria o scanner

        try {

            System.out.println("Digite o primeiro número: ");
            int num1 = sc.nextInt();

            System.out.println("Digite o segundo número: ");
            int num2 = sc.nextInt();

            double resultado = num1 / num2;

            System.out.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {

            System.out.println("Erro: não é possível dividir por zero!");

        }

        sc.close();
    }
}