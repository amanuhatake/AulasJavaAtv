package java08;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        final double MEDIA_MINIMA = 7.0; //operador final 

        ArrayList<Double> notas = new ArrayList<>();

        notas.add(0.0);
        notas.add(2.5);
        notas.add(9.0);

        double soma = 0;
        for (Double n : notas) {
            soma += n;
        }

        double media = soma / notas.size();

        System.out.println("Media: " + media);

        if (media >= MEDIA_MINIMA) {
            System.out.println("APROVADO!!");
        } else {
            System.out.println("REPROVADO");
        }
    }
}
