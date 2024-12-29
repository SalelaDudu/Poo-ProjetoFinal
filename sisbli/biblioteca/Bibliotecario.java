package biblioteca;
import divisao.Setor;
import java.util.List;

import acesso.Funcionalidade;

import java.util.ArrayList;

public class Bibliotecario extends Funcionario implements LivroReservado{    
    private List<Emprestimo> emprestimos;

    public Bibliotecario(String nome,String login, String senha, Setor lotacao, String cpf, List<Funcionalidade> funcionalidades){
        super(nome,login,senha,lotacao,cpf,funcionalidades);
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public void cadastrarEmprestimo(Reserva reserva){
        emprestimos.add(new Emprestimo(reserva));
    }

    @Override
    public void ocorreu(Reserva reserva) {
        System.out.println("Bibliotecário notificado sobre a reserva dos livros:");
        for (Livro livro : reserva.getLivros()) {
            System.out.println(livro.getTitulo());
        }
    }

    @Override   
    public String informarReserva() {
        if (emprestimos.isEmpty()) {
            return "Nenhuma reserva ou empréstimo pendente.";
        }
        String retorno = "";
        for (Emprestimo emprestimo : emprestimos) {
            retorno = "";
            retorno += "###"+ getNome() + "("+ getClass() +") informa: ###\n";
            retorno += "Data Retirada: "+ emprestimo.getDataRetirada();
            retorno += "Data Devolução: " + emprestimo.getDataDevolucao();
            
            for (Exemplar exemplar : emprestimo.getExemplares()) {
                retorno += "Livro: " + exemplar.getLivro().getTitulo();
                retorno += "Autor: " + exemplar.getLivro().getAutor();
                retorno += "Editora: " + exemplar.getLivro().getEditora();
                retorno += "Exemplar nº: " + exemplar.getCodigo();
                retorno += "Situação: " + exemplar.getSituacao();
            }
        }
        return null;
    }
}
