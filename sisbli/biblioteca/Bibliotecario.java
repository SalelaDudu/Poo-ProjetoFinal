package biblioteca;
import divisao.Setor;
import java.util.List;

import acesso.Funcionalidade;

import java.util.ArrayList;

public class Bibliotecario extends Funcionario implements LivroReservado{    
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public Bibliotecario(String nome,String login, String senha, Setor lotacao, String cpf, List<Funcionalidade> funcionalidades){
        super(nome,login,senha,lotacao,cpf,funcionalidades);
    }

    public void cadastrarEmprestimo(Reserva reserva){
            emprestimos.add(new Emprestimo(reserva));
        }

    @Override
    public void ocorreu(Reserva reserva) {

            cadastrarEmprestimo(reserva);

            System.out.println("Bibliotecário " + getNome() + " notificado sobre a reserva dos livros:");
            for (Livro livro : reserva.getLivros()) {
                    System.out.println(livro.getTitulo());
            }
    }

    @Override   
    public String informarReserva() {
        if (emprestimos.isEmpty()) {
            return "Nenhuma reserva ou empréstimo pendente.";
        }
        StringBuilder retorno = new StringBuilder();

        for (Emprestimo emprestimo : emprestimos) {
            retorno.append("###").append(getNome()).append("(Bibliotecario) informa: ###\n");
            retorno.append("Data Retirada: ").append(emprestimo.getDataRetirada());
            retorno.append("\nData Devolução: ").append(emprestimo.getDataDevolucao());
        
            for (Exemplar exemplar : emprestimo.getExemplares()) {
                retorno.append("\nLivro: ").append(exemplar.getLivro().getTitulo());
                retorno.append("\nAutor: ").append(exemplar.getLivro().getAutor());
                retorno.append("\nEditora: ").append(exemplar.getLivro().getEditora());
                retorno.append("\nExemplar nº: ").append(exemplar.getCodigo());
                retorno.append("\nSituação: ").append(exemplar.getSituacao());
            }
            retorno.append("$$$");            
        }
        return retorno.toString();
    }
}
