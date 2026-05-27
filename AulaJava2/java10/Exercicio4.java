import java.util.ArrayList;

public class Exercicio4 {
    public static void main(String[] args) {

        ArrayList<String> nomes = new ArrayList<>();

            nomes.add("Manu");
            nomes.add("Olivia");
            nomes.add("Melissa");

        try{
            System.out.println(nomes.get(2));
        }catch(IndexOutOfBoundsException e){
            System.out.println("Erro: posição inválida no ArrayList!");
        }
    }
}
