package acesso;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private List<Funcionalidade> funcionalidades;
    private static List<Usuario> usuarios;

    public Usuario(String nome, String login, String senha, List<Funcionalidade> funcionalidades){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.funcionalidades = funcionalidades;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }
// Implementar esse filho aqui
    public String sair(){

        return "";
    }
// Implementar tbm
    public static <T> List<T> listar(Class<T> instanciaClasse){

        return new ArrayList<>();
    }

    public static Usuario obter(String login, String senha){
        try{
            for (Usuario usuario : usuarios) {
                if(usuario.login == login && usuario.senha == senha){
                    return usuario;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
}
