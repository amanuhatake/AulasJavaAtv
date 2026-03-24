
public class exercicio01 {

    static class Aluno{
        String nome;
        int idade;
        String curso;

        void estudar(){
            System.out.println("O aluno está estudando");
        }
    }
    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno();
        aluno1.nome ="Carlos";
        aluno1.estudar();
    }
}   
