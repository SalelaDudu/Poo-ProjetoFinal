package acesso;
import java.util.List;
import java.util.concurrent.ExecutionException;

import biblioteca.Bibliotecario;
import biblioteca.Funcionario;
import biblioteca.Livro;
import biblioteca.Professor;
import divisao.Setor;

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
        List<T> lista = new ArrayList<>();
        try{
            if(instanciaClasse == Livro.class){
                System.out.println("É um livro");
            }
            else if(instanciaClasse == Funcionario.class || instanciaClasse == Professor.class || instanciaClasse == Bibliotecario.class){
                System.out.println("É um funcionário do tipo: " + instanciaClasse.getName());
            }
            return null;
        }
        catch(Exception e){
            return null;
        }        
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
