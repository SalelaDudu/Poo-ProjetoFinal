package biblioteca;

import acesso.*;
import java.util.List;
import java.util.Observer;
import java.util.ArrayList;

@SuppressWarnings("unused")

public class Aluno extends Usuario implements  ReservouLivro{
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
      reservas.add(reserva);
      notificar(reserva);
   }

   @Override
   public void adicionar(LivroReservado livroReservado) {
      consumidores.add(livroReservado);
   }

   @Override
   public void remover(LivroReservado livroReservado) {
      consumidores.remove(livroReservado);
   }

   @Override
   public void notificar(Reserva reserva) {
      for (LivroReservado consumidor : consumidores) {
         consumidor.ocorreu(reserva);
      }
   }
}
