import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

import biblioteca.*;
import divisao.Setor;
import infraestrutura.Util;
import acesso.*;
@SuppressWarnings("unused")
public class Principal {    
    public static void main(String[] args){        
        String titulo_programa = "Sistema Bibliotecário | v0.1";
        List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();

        Funcionalidade CAD_CONS = Funcionalidade.CAD_CONS;
        Funcionalidade CAD_RESE = Funcionalidade.CAD_RESE;
        Funcionalidade REM_CONS = Funcionalidade.REM_CONS;

        funcionalidades.add(CAD_CONS);
        funcionalidades.add(CAD_RESE);
        funcionalidades.add(REM_CONS);
    
        try{

            String usuario_login = JOptionPane.showInputDialog(null,"Informe seu login:",titulo_programa,JOptionPane.PLAIN_MESSAGE);
            String usuario_senha = JOptionPane.showInputDialog(null,"Informe sua senha:",titulo_programa,JOptionPane.PLAIN_MESSAGE);
            
            if(Usuario.obter(usuario_login, usuario_senha) != null ){
                Object[] options = { "Cadastrar consumidor", "Remover Consumidor", "Cadastrar Reserva", "Sair" };

                JOptionPane.showOptionDialog(null, "Selecione uma opção:", titulo_programa,
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[3]);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário.\nEncerrando operação...", titulo_programa, JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // Encerra o programa
        System.exit(0);
    }
    
}