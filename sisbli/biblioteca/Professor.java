package biblioteca;
import java.util.List;

import acesso.Funcionalidade;
import divisao.Setor;
@SuppressWarnings("unused")
public class Professor extends Funcionario implements LivroReservado{
    private Reserva reserva;

    public Professor(String nome, String login, String senha, Setor lotacao, String cpf, List<Funcionalidade> funcionalidades ){
        super(nome,login,senha,lotacao,cpf,funcionalidades);

    }

    @Override
    
    public void ocorreu(Reserva reserva) {
        this.reserva = reserva;
        System.out.println("Professor informado sobre a reserva do livro: " + /*não to conseguindo pegar o titulo */);
    }

    @Override

    public String informarReserva() {
        if (reserva != null) {
            return "Reserva do livro: " + /*to com problemas*/ + " feita por: " + /*nessa parte */;
        } else {
            return "Nenhuma reserva no momento.";
        }
    }
       
    }

}
