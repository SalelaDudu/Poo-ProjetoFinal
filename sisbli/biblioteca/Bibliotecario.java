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
        System.out.println("Empréstimo cadastrado para o livro: " + reserva./* */);
    }

    @Override
  
    public void ocorreu(Reserva reserva) {
        System.out.println("Bibliotecário notificado sobre a reserva do livro: " + reserva./* */);
    }

    @Override
   
    public String informarReserva() {
        if (emprestimos.isEmpty()) {
            return "Nenhuma reserva ou empréstimo pendente.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Emprestimos realizados:\n");
        for (Emprestimo emprestimo : emprestimos) {
            sb.append("Livro: ").append(emprestimo./* */)
              .append(" - Data de Retirada: ").append(emprestimo.getDataRetirada()).append("\n");
        }
        return sb.toString();
    }


}
