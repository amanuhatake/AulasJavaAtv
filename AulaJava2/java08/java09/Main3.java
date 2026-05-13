package java09;

public class Main3 {
    public static void main(String[] args) {
        
        String preco = "199.90";

        double valor = Double.parseDouble(preco);

        double desconto = valor * 0.10;

        double valorFinal = valor - desconto;

        System.out.println(valorFinal);


    }
}
