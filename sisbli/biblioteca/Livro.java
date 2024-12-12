package biblioteca;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String autor;    
    private String editora;
    @SuppressWarnings("unused")
    private static Map<Livro,List<Exemplar>> biblioteca;


    public Livro(String titulo){
        this.titulo = titulo;
    }

    public Livro(String titulo, String autor, String editora){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }
    // Implementar
    public static Livro obterLivro(String titulo){
        return new Livro("");
    }
    // Implementar
    public static Exemplar obterExemplar(Livro livro){
        return new Exemplar(livro);
    }
    // Implementar
    public static List<String> Listar(){

        return new ArrayList<String>();
    }

    // Implementar + 2 métodos;
}
