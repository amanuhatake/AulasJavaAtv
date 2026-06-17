package models;

import interfaces.Cadastravel;

public class Aluno extends Pessoa implements Cadastravel {

    private String matricula;
    private Curso curso; // Classe composta!

    public Aluno(String nome, String cpf, int idade, String matricula, Curso nomeCurso) {
        super(nome, cpf, idade); // Passando os parâmetros para a classe mãe (Pessoa)
        this.matricula = matricula;
        this.curso = nomeCurso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Polimorfismo: Implementando o método abstrato obrigatório de Pessoa
    @Override
    public void gerarRelatorio() {
        System.out.println("====== RELATÓRIO DO ALUNO ======");
        System.out.println(super.toString()); // Imprime Nome, CPF e Idade
        System.out.println("Matrícula: " + this.matricula);
        // Verifica se o aluno está matriculado em algum curso para não dar erro no sistema
        if (this.curso != null) {
            System.out.println("Curso: " + this.curso.getNomeCurso());
        } else {
            System.out.println("Curso: Nenhum curso vinculado.");
        }
        System.out.println("================================\n");
    }

    // toString() obrigatório pelo PDF usando o super.toString()
    @Override
    public String toString() {
        String nomeCurso = (curso != null) ? curso.getNomeCurso() : "Sem curso";
        return super.toString() + " | Matrícula: " + matricula + " | Curso: " + nomeCurso;
    }

    @Override
    public boolean validar() {
        if (getNome() == null || getNome().isEmpty()) {
            System.out.println("Erro: Nome é obrigatório!");
            return false;
        }
        if (getCpf() == null || getCpf().isEmpty()) {
            System.out.println("Erro: CPF é obrigatório!");
            return false;
        }
        if (matricula == null || matricula.isEmpty()) {
            System.out.println("Erro: Matrícula é obrigatória!");
            return false;
        }
        return true;
    }

    @Override
    public String getId() {
        return matricula; // matrícula é o identificador do aluno
    }
}
