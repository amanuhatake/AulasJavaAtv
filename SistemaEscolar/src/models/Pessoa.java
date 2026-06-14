package models;

public abstract class Pessoa {

    private String nome;
    private String cpf; // Trocado de idade para CPF, muito mais realista!
    private int idade;  // Se quiser, pode manter a idade junto para fins de relatório

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
   
    public abstract void gerarRelatorio();

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | CPF: " + getCpf() + " | Idade: " + getIdade() + " anos";
    }
}