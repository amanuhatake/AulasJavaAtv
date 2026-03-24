public class Exercicio4 {
    // Inner class estática Universidade
    public static class Universidade{
        String nome, cidade;

        void mostrar(){
        System.out.println("Universidade: " + nome + ", " + ", " + cidade);
        }
    }
    
    // Inner class estática Professor
    public static class Professor{
        String nome, disciplina;

        void mostrar(){
        System.out.println("Universidade: " + nome + ", " + ", " + disciplina);
        }
    }

       
    // Main para executar o programa
    public static void main(String[] args) {
        //instanciando classe
        Universidade uni = new Universidade();
        Professor prof = new Professor();

        //Criando objetos 
        uni.nome = "Positivo";
        uni.cidade = "Londrina";

        //Criando objetos 
        prof.nome = "Duda";
        prof.disciplina ="Java";

        // Chamando os métodos para mostrar informações
        uni.mostrar();
        prof.mostrar();


    }

}