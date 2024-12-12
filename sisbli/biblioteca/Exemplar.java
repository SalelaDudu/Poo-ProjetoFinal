package biblioteca;
import infraestrutura.Util;

public class Exemplar {
    private int codigo;
    @SuppressWarnings("unused")
    private String dataAquisicao;
    private int situacao;
    private Livro livro;

    public Exemplar(Livro livro){
        this.livro = livro;
        // Acho que essa dataAquiscao deveria ser em outro lugar
        this.dataAquisicao = Util.obterDataAtual();
    }


    public int getSituacao() {
        return situacao;
    }
    
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Livro getLivro() {
        return livro;
    }
    public int getCodigo() {
        return codigo;
    }    
}
