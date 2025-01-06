package biblioteca;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Reserva {
    private String data;
    private List<Livro> livros;

    public Reserva(String data, List<String> titulosLivros){
        this.data = data;
        livros = carregarLivros(titulosLivros);
        
    }
    public String getData() {
        return data;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    private List<Livro> carregarLivros(List<String> titulosLivros){
        List<Livro> resultado = new ArrayList<Livro>();    

        for (String titulo : titulosLivros) {
            resultado.add(Livro.obterLivro(titulo));
        }

        return resultado;
    }
}
