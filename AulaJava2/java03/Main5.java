/*Crie uma classe Aluno com:
– nome
– nota
• Construtor deve validar:
– nota entre 0 e 10 */

class Aluno{
    String nome;
    double nota;

    public Aluno (String nome, double nota){
        this.nome = nome;
        if(nota < 0 && nota > 10){
            this.nota = nota;
        }else{
            System.out.println("EERO");
        }
    }
}

public class Main5 {
    
}
