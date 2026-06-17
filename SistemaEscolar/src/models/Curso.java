package models;

public class Curso {

    private String nomeCurso;
    private Professor professor; 
    public Curso(String nomeCurso, Professor professor) {
        this.nomeCurso = nomeCurso;
        this.professor = professor;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        String nomeProfessor = (professor != null) ? professor.getNome() : "Sem professor atribuído";
        return "Curso: " + nomeCurso + " | Professor Responsável: " + nomeProfessor;
    }
}