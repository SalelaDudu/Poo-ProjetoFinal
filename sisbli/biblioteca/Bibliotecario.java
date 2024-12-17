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
    // implementar
    public void ocorreu(Reserva reserva) {

    }

    @Override
    // implementar
    public String informarReserva() {
        return "";
    }

//esperar Reserva ficar pronto
/*
public void cadastrarEmprestimo(){

}
*/
}
