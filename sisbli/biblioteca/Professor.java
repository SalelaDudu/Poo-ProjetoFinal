package biblioteca;
import java.util.ArrayList;
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
        System.out.println("Reserva notificada ao professor: "+ getNome());
    }

    @Override
    public String informarReserva() {
        try{
            if (reserva != null) {
                List<Livro> livros = new ArrayList<Livro>();
                livros = reserva.getLivros();
                String retorno = "### "+ getNome() + "("+getClass()+") informa:" + " ###";
                for (Livro livro : livros) {
                    retorno += "\nData reserva: " + reserva.getData();
                    retorno += "\nLivro: " + livro.getTitulo();
                }
                return retorno;
            } else {
                return "Nenhuma reserva no momento.";
            }            
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}