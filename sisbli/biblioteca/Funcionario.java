package biblioteca;
import divisao.Setor;
import acesso.Funcionalidade;
import java.util.List;
import java.util.ArrayList;

//aguardar usuário ficar pronto
public class Funcionario extends acesso.Usuario{
    private String cpf;
    private int pis;
    private Setor lotacao;

    List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();
    

    public Funcionario(String nome, String senha, Setor lotacao){
      super(nome, nome+"@email.com", senha, funcionalidades);
      this.lotacao = lotacao;
    }

    public Funcionario(String nome, String senha, Setor lotacao, String cpf ){
    /*
     super.nome = nome;
     super.login = login;
     super.senha = senha;
     */
     this.lotacao = lotacao;
     this.cpf = cpf;  
    }

  public Funcionario(String nome, String senha, Setor lotacao, String cpf, int pis ){
    /*
     super.nome = nome;
     super.login = login;
     super.senha = senha;
      */
     this.lotacao = lotacao;
     this.cpf = cpf;
     this.pis = pis;  
    }

  public Setor getLotacao(){
    return lotacao;
  }

 public void setLotacao(Setor lotacao){
    this.lotacao = lotacao;
 }

}
