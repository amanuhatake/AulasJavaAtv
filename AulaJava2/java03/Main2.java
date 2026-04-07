/*Crie uma classe Livro com:
– título
– autor
– páginas
• Use construtor para inicializar tudo. */

class Livro{
    String titulo;
    String autor;
    int paginas;

    public Livro (String titulo, String autor, int paginas){
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas; 
    }
}

public class Main2 {
    public static void main(String[] args) {
        Livro livro = new Livro ("Quarto de Despejo", "Carolina Marina de Jesus", 264);
        System.out.println("Titutlo do livro: " + livro.titulo);
        System.out.println("Nome do autor: " + livro.autor);
        System.out.println("Número de páginas: " + livro.paginas);
        
    }
}
