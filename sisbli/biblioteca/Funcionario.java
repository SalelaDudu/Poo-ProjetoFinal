package biblioteca;
import divisao.Setor;
import acesso.Funcionalidade;
import java.util.List;

@SuppressWarnings("unused")

public class Funcionario extends acesso.Usuario{
    private String cpf;
    private int pis;
    private Setor lotacao;
    
    public Funcionario(String nome,String login, String senha, Setor lotacao, List<Funcionalidade> funcionalidades){
      super(nome, login, senha, funcionalidades);
      this.lotacao = lotacao;
    }

    public Funcionario(String nome,String login, String senha, Setor lotacao, String cpf, List<Funcionalidade> funcionalidades ){
    
    super(nome, login, senha, funcionalidades);    
    this.lotacao = lotacao;
    this.cpf = cpf;  
    }

public Funcionario(String nome,String login, String senha, Setor lotacao, String cpf, int pis, List<Funcionalidade> funcionalidades){
    
    super(nome, login, senha, funcionalidades);
    
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
