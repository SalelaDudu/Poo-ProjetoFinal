package biblioteca;
import divisao.Setor;
//aguardar usuaruio ficar pronto
public class Professor extends Funcionario implements LivroReservado{
    private Reserva reserva;

    public Professor(String nome, String login, String senha, Setor lotacao, String cpf ){
        super(nome,login,senha,lotacao,cpf);

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
