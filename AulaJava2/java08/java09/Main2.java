package java09;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        for (Integer n : numeros) {
            System.out.println(n);
        }
    }
}
