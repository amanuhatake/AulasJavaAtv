package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Aluno;
import models.Chamada;
import models.Curso;
import models.Professor;
import models.Usuario;

public class Sistema {

    // Listas que vão armazenar os dados do sistema em memória
    private List<Aluno> alunos;
    private List<Professor> professors;
    private List<Curso> cursos;
    private List<Chamada> chamadas;
    private List<Usuario> usuarios;

    // Armazena quem é o usuário que está logado no momento
    private Usuario usuarioLogado;

    // Construtor: Inicializa as listas e carrega os arquivos do disco
    public Sistema() {
        // Carrega os dados persistidos em arquivo de texto
        this.alunos = GerenciadorArquivos.carregarAlunos();
        this.professors = GerenciadorArquivos.carregarProfessores();
        this.cursos = GerenciadorArquivos.carregarCursos(this.professors);

        // Inicializa as demais listas na memória
        this.chamadas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.usuarioLogado = null;

        // Criando o usuário administrador padrão solicitado para testes
        this.usuarios.add(new Usuario("admin", "1234"));
    }

    // Regra de Negócio: Controlar o processo de Login de forma simplificada
    public boolean realizarLogin(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                boolean autenticado = u.autenticar(login, senha);
                if (autenticado) {
                    this.usuarioLogado = u; // define que está logado!
                }
                return autenticado;

            }
        }
        System.out.println("Usuário não cadastrado no sistema.");
        return false;
    }

    public Usuario buscarUsuario(String login) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public Aluno buscarAlunoPorNome(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public void alterarAluno(String matricula, String novoNome, int novaIdade, Curso novoCurso) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        aluno.setNome(novoNome);
        aluno.setIdade(novaIdade);
        aluno.setCurso(novoCurso);
        GerenciadorArquivos.salvarAlunos(new ArrayList<>(alunos));
        System.out.println("Aluno alterado com sucesso!");
    }

    public void excluirAluno(String matricula) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        alunos.remove(aluno);
        GerenciadorArquivos.salvarAlunos(new ArrayList<>(alunos));
        System.out.println("Aluno removido com sucesso!");
    }

    public boolean redefinirSenha(String login, String novaSenha) {
        Usuario u = buscarUsuario(login);
        if (u != null) {
            return u.cadastrarNovaSenha(novaSenha);
        }
        return false;
    }

    // Retorna o usuário logado para a View saber o status
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    // Desloga o usuário atual
    public void realizarLogout() {
        this.usuarioLogado = null;
        System.out.println("Sessão encerrada com sucesso.");
    }

    // --- MÉTODOS DE CADASTRO COM VALIDAÇÃO DE REGRA DE NEGÓCIO ---
    public void cadastrarAluno(Aluno aluno) {

        if (!aluno.validar()) {
            return;
        }

        // REGRA DO PDF: Validação para impedir CPFs duplicados
        for (Aluno a : alunos) {
            if (a.getCpf().equals(aluno.getCpf())) {
                System.out.println("Erro: Já existe um aluno cadastrado com este CPF!");
                return;
            }
        }
        this.alunos.add(aluno);
        GerenciadorArquivos.salvarAlunos(new ArrayList<>(this.alunos));
        System.out.println("Aluno cadastrado com sucesso e salvo em arquivo!");
    }

    public void cadastrarProfessor(Professor professor) {
        if (!professor.validar()) {
            return;
        }

        // REGRA DO PDF: Validação para impedir CPFs duplicados
        for (Professor p : professors) {
            if (p.getCpf().equals(professor.getCpf())) {
                System.out.println("Erro: Já existe um professor cadastrado com este CPF!");
                return;
            }
        }
        this.professors.add(professor);
        GerenciadorArquivos.salvarProfessores(new ArrayList<>(this.professors));
        System.out.println("Professor cadastrado com sucesso e salvo em arquivo!");
    }

    public void cadastrarCurso(Curso curso) {
        this.cursos.add(curso);
        GerenciadorArquivos.salvarCursos(new ArrayList<>(this.cursos));
        System.out.println("Curso cadastrado com sucesso e salvo em arquivo!");
    }

    public void registrarChamada(Chamada chamada) {
        this.chamadas.add(chamada);
        System.out.println("Chamada registrada com sucesso!");
    }

    // --- MÉTODOS DE CONSULTA (Serão usados nos Relatórios) ---
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Chamada> getChamadas() {
        return chamadas;
    }
}
