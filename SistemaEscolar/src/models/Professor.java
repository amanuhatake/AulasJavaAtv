package models;

import interfaces.Cadastravel;

public class Professor extends Pessoa implements Cadastravel {

    private String disciplina;

    
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

    
    @Override
    public void gerarRelatorio() {
        System.out.println("----- RELATÓRIO DO PROFESSOR -----");
        System.out.println(super.toString()); 
        System.out.println("Disciplina Lecionada: " + this.disciplina);
        System.out.println("----------------------------------");
    }

    
    @Override
    public String toString() {
        return super.toString() + " | Disciplina: " + disciplina;
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
        return true;
    }

    @Override
    public String getId() {
        return getCpf(); 
    }
}
