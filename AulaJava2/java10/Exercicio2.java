import java.util.InputMismatchException;
import java.util.Scanner;

class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Digite sua idade: ");
            int idade = sc.nextInt();
            System.out.println("Idade informada: " + idade);
        }catch(InputMismatchException e){
             System.out.println("Erro: digite uma idade válida.");
        }
        sc.close();
    }
}