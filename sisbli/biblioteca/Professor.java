package biblioteca;
import java.util.List;

import acesso.Funcionalidade;
import divisao.Setor;
//aguardar usuaruio ficar pronto
@SuppressWarnings("unused")
public class Professor extends Funcionario implements LivroReservado{
    private Reserva reserva;

    public Professor(String nome, String login, String senha, Setor lotacao, String cpf, List<Funcionalidade> funcionalidades ){
        super(nome,login,senha,lotacao,cpf,funcionalidades);

    }

    @Override
    // Fazer isso
    public void ocorreu(Reserva reserva) {

    }

    @Override
    // Implementar isso
    public String informarReserva() {
        
        return "";
    }

}
