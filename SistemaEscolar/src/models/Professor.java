package models;

public class Professor extends Pessoa {
    private String disciplina;

    // Construtor atualizado passando os três parâmetros para a classe mãe (Pessoa)
    public Professor(String nome, String cpf, int idade, String disciplina) {
        super(nome, cpf, idade);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    // Polimorfismo: Implementando o método abstrato de Pessoa
    @Override
    public void gerarRelatorio() {
        System.out.println("----- RELATÓRIO DO PROFESSOR -----");
        System.out.println(super.toString()); // Puxa Nome, CPF e Idade automaticamente
        System.out.println("Disciplina Lecionada: " + this.disciplina);
        System.out.println("----------------------------------");
    }

    // toString() obrigatório pelo PDF usando o super
    @Override
    public String toString() {
        return super.toString() + " | Disciplina: " + disciplina;
    }
}