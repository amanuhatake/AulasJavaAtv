package controllers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.Aluno;
import models.Curso;
import models.Professor;

public class GerenciadorArquivos {

    private static final String FILE_ALUNOS = "alunos.txt";
    private static final String FILE_PROFESSORES = "professores.txt";
    private static final String FILE_CURSOS = "cursos.txt";

    public static void salvarAlunos(ArrayList<Aluno> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ALUNOS))) {
            for (Aluno a : lista) {
                bw.write(a.getNome() + ";" + a.getCpf() + ";" + a.getIdade() + ";" + a.getMatricula());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

  
    public static ArrayList<Aluno> carregarAlunos() {
        ArrayList<Aluno> lista = new ArrayList<>();
        File file = new File(FILE_ALUNOS);
        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_ALUNOS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    lista.add(new Aluno(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3],null));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
        }
        return lista;
    }

   
    public static void salvarProfessores(ArrayList<Professor> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PROFESSORES))) {
            for (Professor p : lista) {
                bw.write(p.getNome() + ";" + p.getCpf() + ";" + p.getIdade() + ";" + p.getDisciplina());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar professores: " + e.getMessage());
        }
    }

  
    public static ArrayList<Professor> carregarProfessores() {
        ArrayList<Professor> lista = new ArrayList<>();
        File file = new File(FILE_PROFESSORES);
        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PROFESSORES))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    lista.add(new Professor(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar professores: " + e.getMessage());
        }
        return lista;
    }

  
    public static void salvarCursos(ArrayList<Curso> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_CURSOS))) {
            for (Curso c : lista) {
                bw.write(c.getNomeCurso() + ";" + c.getProfessor().getCpf());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar cursos: " + e.getMessage());
        }
    }

    
    public static ArrayList<Curso> carregarCursos(List<Professor> listaProfessores) {
        ArrayList<Curso> lista = new ArrayList<>();
        File file = new File(FILE_CURSOS);
        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_CURSOS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    String nomeCurso = dados[0];
                    String cpfProfessor = dados[1];

                    Professor profEncontrado = null;
                    for (Professor p : listaProfessores) {
                        if (p.getCpf().equals(cpfProfessor)) {
                            profEncontrado = p;
                            break;
                        }
                    }

                    if (profEncontrado != null) {
                        lista.add(new Curso(nomeCurso, profEncontrado));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar cursos: " + e.getMessage());
        }
        return lista;
    }
}