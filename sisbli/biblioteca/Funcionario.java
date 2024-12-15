package biblioteca;
import divisao.Setor;
import acesso.Funcionalidade;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")

public class Funcionario extends acesso.Usuario{
    private String cpf;
    private int pis;
    private Setor lotacao;
    // Não deve ter esse membro
    private static List<Funcionalidade> funcionalidades;
    
        
    
        public Funcionario(String nome,String login, String senha, Setor lotacao){
          super(nome, login, senha, funcionalidades);
      this.lotacao = lotacao;
    }

    public Funcionario(String nome,String login, String senha, Setor lotacao, String cpf ){
    
      super(nome, login, senha, funcionalidades);
     
     this.lotacao = lotacao;
     this.cpf = cpf;  
    }

  public Funcionario(String nome,String login, String senha, Setor lotacao, String cpf, int pis ){
    
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
