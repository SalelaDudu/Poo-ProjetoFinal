package biblioteca;
import java.util.List;
import java.util.ArrayList;
public class Aluno {
 private int matricula;
 private List<Reserva> reservas = new ArrayList<>();
 private List<LivroReservado> consumidores = new ArrayList<>();
 private List<Funcionalidade> funcionalidades = new ArrayList<>();
//esperar Usuário ficar pronto
 public Aluno(String nome, String login, String senha, int matricula ){
     /*
    super.nome = nome;
    super.login = login;
    super.senha = senha;
    */
    this.matricula = matricula;
 }

 public List<LivroReservado> getConsumidores(){
    return consumidores;
 }   

 public void cadastrarReserva(List<String> titulosLivros, String data){
   //esperar implementar a reserva.
 }
    
 
}
