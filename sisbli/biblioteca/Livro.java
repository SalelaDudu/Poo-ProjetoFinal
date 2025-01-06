package biblioteca;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String autor;    
    private String editora;
    private static Map<Livro,List<Exemplar>> biblioteca;

    static{
        biblioteca = criarBiblioteca();
    }

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
    
    public static Livro obterLivro(String titulo){
        try{
            for (Livro livro : biblioteca.keySet()) {
                    if(livro.getTitulo() == titulo){
                        return livro;
                    }
                }
            return null;
        }
        catch(Exception e){
            System.out.println("Erro ao obter livro: "+e);
            return null;
        }
    }
    
    public static Exemplar obterExemplar(Livro livro){
        List<Exemplar> exemplares = new ArrayList<Exemplar>();
        exemplares = biblioteca.get(livro);
        
        if (exemplares.isEmpty()){
            System.out.println("Não há mais exemplares deste livro");
            return null;
        }
        else{
            exemplares.remove(exemplares.size() - 1);
            return exemplares.get(0);
        }
    }

    public static List<String> Listar(){
        List<String> meusLivros = new ArrayList<String>();
        
        for (Livro livro : biblioteca.keySet()) {
            meusLivros.add(livro.getTitulo());
        }

        return meusLivros;
    }
    
    @SuppressWarnings("unchecked")
    private static Map<Livro,List<Exemplar>> criarBiblioteca(){
        @SuppressWarnings("rawtypes")

        Map hashMap = new HashMap<Livro,List<Exemplar>>();
        criarListaExemplares(hashMap);

        return hashMap;
    }

    private static void criarListaExemplares(Map<Livro,List<Exemplar>> biblioteca){        
        int numeroExemplares = 5;

        Livro livro1 = new Livro("Uma breve Historia do tempo","Stephen Hawking","Intrínseca");
        Livro livro2 = new Livro("As crônicas de gelo e fogo: A guerra dos tronos","George R. R. Martin","LeYa");
        
        List<Exemplar> exemplaresLivro1 = new ArrayList<Exemplar>();        
        List<Exemplar> exemplaresLivro2 = new ArrayList<Exemplar>();

        for(int i = 0; i < numeroExemplares; i++){
            exemplaresLivro1.add(new Exemplar(livro1));
        }

        numeroExemplares = 3;

        for(int i = 0; i < numeroExemplares; i++){
            exemplaresLivro2.add(new Exemplar(livro2));
        }

        biblioteca.put(livro1, exemplaresLivro1);
        biblioteca.put(livro2, exemplaresLivro2);
    }
}
