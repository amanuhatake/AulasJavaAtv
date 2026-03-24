import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 5 numeros: ");
        int [] vetor = new int[5];
        int soma = 0;

        int maior = vetor[0];
        int menor = vetor[0];

            for(int l=0; l<5; l++){
            

            vetor[l] = sc.nextInt();
            soma += vetor[l];

             if(vetor[l] > maior){
                     maior = vetor[l];
                }
                if (vetor[l] < menor){
                    menor = vetor[l];
                }
            }


            System.out.println("Soma: " + soma);
            System.out.println("Maior: " + maior);
            System.out.println("Menor: " + menor);

        sc.close();
        }

    }

