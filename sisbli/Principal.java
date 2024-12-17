import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import acesso.Funcionalidade;
import biblioteca.*;
import divisao.Setor;
import infraestrutura.Util;
import acesso.*;
@SuppressWarnings("unused")
public class Principal {
    // ATENCAO  REMOVER TODOS OS COMENTARIOS ANTES DE ENVIAR PARA O CAYO
    public static void main(String[] args){
        // String que recebe o título da janeal do programa
        String titulo_programa = "Sistema Bibliotecário | v0.1";
        List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();

        Funcionalidade CAD_CONS = Funcionalidade.CAD_CONS;
        Funcionalidade CAD_RESE = Funcionalidade.CAD_RESE;
        Funcionalidade REM_CONS = Funcionalidade.REM_CONS;

        funcionalidades.add(CAD_CONS);
        funcionalidades.add(CAD_RESE);
        funcionalidades.add(REM_CONS);

        Professor professor = new Professor("João Souza","joao.souza@professor.com","123456",new Setor("Docente"), "123.456.768-91", funcionalidades);
        Aluno aluno = new Aluno("José Pereira","jose.pereira@aluno.com","123456",202420012,funcionalidades);
        Bibliotecario bibliotecario = new Bibliotecario("Marcelo Barbosa","marcelo.barbosa@biblioteca.com","123456",new Setor("Biblioteca"),"123.456.798-55", funcionalidades);

        // Recebe o login do usuario
        // String usuario_login = JOptionPane.showInputDialog(null,"Informe seu login:",titulo_programa,JOptionPane.PLAIN_MESSAGE);
        // String usuario_senha = JOptionPane.showInputDialog(null,"Informe sua senha:",titulo_programa,JOptionPane.PLAIN_MESSAGE);

        // Encerra o programa
        System.exit(0);
    }
    
}