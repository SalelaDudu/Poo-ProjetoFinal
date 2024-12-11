package biblioteca;
import java.util.List;
import java.util.ArrayList;

public class Emprestimo {
    private String dataRetirada;    
    private String dataDevolucao;
    private List<Exemplar> exemplares;
    
    public Emprestimo(Reserva reserva){
        this.exemplares = carregarExemplares(reserva.getLivros());
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    private List<Exemplar> carregarExemplares(List<Livro> livros){
        List<Exemplar> resultado = new ArrayList<Exemplar>();
        for (Livro livro : livros) {
            resultado.add(new Exemplar(livro));
        }
        return resultado;
    }
}
