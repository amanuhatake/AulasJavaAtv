package models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Chamada {
    private LocalDate data;
    private List<Aluno> alunosPresentes;
    private List<Aluno> alunosAusentes;

   
    public Chamada(LocalDate data) {
        this.data = data;
        this.alunosPresentes = new ArrayList<>();
        this.alunosAusentes = new ArrayList<>();
    }

  
    public void registrarPresenca(Aluno aluno) {
        this.alunosPresentes.add(aluno);
    }

    public void registrarAusencia(Aluno aluno) {
        this.alunosAusentes.add(aluno);
    }

    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Aluno> getAlunosPresentes() {
        return alunosPresentes;
    }

    public List<Aluno> getAlunosAusentes() {
        return alunosAusentes;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Chamada do dia: " + data.format(formatter) +
               "\nPresentes: " + alunosPresentes.size() + " alunos" +
               "\nAusentes: " + alunosAusentes.size() + " alunos";
    }
}