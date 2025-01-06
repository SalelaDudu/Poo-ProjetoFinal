package biblioteca;
import infraestrutura.*;
import java.util.List;
import java.util.ArrayList;

public class Emprestimo {
    private String dataRetirada;    
    private String dataDevolucao;
    private List<Exemplar> exemplares = new ArrayList<Exemplar>();
    
    public Emprestimo(Reserva reserva){
        try{
            if(reserva != null){
                try{
                    exemplares = carregarExemplares(reserva.getLivros());
                    if(exemplares.isEmpty() || exemplares == null){
                    }
                    dataRetirada = reserva.getData();
                    dataDevolucao = Util.somarDiasData(dataRetirada, 7);
                }
                catch(Exception e){
                }
            }

        }catch(Exception e){
        }
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
