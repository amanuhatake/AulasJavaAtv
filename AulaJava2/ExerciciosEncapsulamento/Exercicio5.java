/*
Enunciado
• Crie uma classe Livro com:
– título
– autor
– páginas
• Use construtor para inicializar tudo. */

import java.util.Scanner;
class Livro {
    private String titulo;
    private String autor; 
    private int paginas;

    public Livro (String titulo, String autor, int paginas){
        this.titulo = titulo;
        this.autor = autor;
        setPaginas(paginas); //aplicando validação 
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public int getPaginas(){
        return paginas;
    }
    public void setPaginas(int paginas){
        if(paginas >=0){
            this.paginas = paginas;
        }else{
            System.out.println("Numero de paginas inválido!");
            this.paginas = 0;
        }
    }

    public void exibirLivro(){
        System.out.println("==========================");
        System.out.println("Titulo do Livro: " + titulo);
        System.out.println("Autor do Livro: " + autor);
        System.out.println("Número de Páginas do Livro: " + paginas);
        System.out.println("==========================");
        
    }
}

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o título do Livro: ");
        String titulo = entrada.nextLine();

        System.out.println("Digite o nome do Autor: ");
        String autor = entrada.nextLine();

        System.out.println("Digite o número de páginas: ");
        int paginas = entrada.nextInt();

        Livro livro = new Livro(titulo, autor, paginas);

        livro.exibirLivro();
        entrada.close();
    }
}
