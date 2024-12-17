package biblioteca;

import acesso.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")

public class Aluno extends Usuario implements ReservouLivro{
private int matricula;
private List<Reserva> reservas = new ArrayList<>();
private List<LivroReservado> consumidores = new ArrayList<>();
private List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();

public Aluno(String nome, String login, String senha, int matricula, List<Funcionalidade> funcionalidades){
   super(nome,login,senha,funcionalidades);
   this.matricula = matricula;
 }

public List<LivroReservado> getConsumidores(){
   return consumidores;
}   

public void cadastrarReserva(List<String> titulosLivros, String data){
   Reserva reserva = new Reserva(data,titulosLivros);
}

@Override
public void adicionar(LivroReservado livroReservado) {
   // implementar
}

@Override
public void remover(LivroReservado livroReservado) {
// implementar
}

@Override
public void notificar(Reserva reserva) {
// implementar

   }
}
