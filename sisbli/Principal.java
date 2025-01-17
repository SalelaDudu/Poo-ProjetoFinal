import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import biblioteca.*;
import divisao.*;
import infraestrutura.*;
import acesso.*;

@SuppressWarnings("unused")
public class Principal {
    public static void main(String[] args) {
        String titulo_programa = "Sistema Bibliotecário | v0.1";
        List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();

        Funcionalidade CAD_CONS = Funcionalidade.CAD_CONS;
        Funcionalidade CAD_RESE = Funcionalidade.CAD_RESE;
        Funcionalidade REM_CONS = Funcionalidade.REM_CONS;

        funcionalidades.add(CAD_CONS);
        funcionalidades.add(CAD_RESE);
        funcionalidades.add(REM_CONS);
        Aluno aluno = null;
        List<LivroReservado> consumidorDeEventos = new ArrayList<LivroReservado>();
        List<String> livrosAlugados = new ArrayList<String>();
        String[] reservas = null;
        try {            
            for (Usuario usuario : Usuario.listar(Usuario.class)) {
                if(usuario instanceof Aluno){
                    aluno = (Aluno) usuario;
                }
            }

            String usuario_login = JOptionPane.showInputDialog(null, "Informe seu login:", titulo_programa,
                                    JOptionPane.PLAIN_MESSAGE);
            if (usuario_login == null) {
                System.exit(0);
            }

            String usuario_senha = JOptionPane.showInputDialog(null, "Informe sua senha:", titulo_programa,
                                    JOptionPane.PLAIN_MESSAGE);
            
            if (usuario_senha == null) {
                    System.exit(0);
            }

            if (Usuario.obter(usuario_login, usuario_senha) != null) {
                boolean controle = true;
                Object[] opcoes = { "Cadastrar consumidor", "Remover Consumidor", "Cadastrar Reserva", "Sair" };
                List<String> consumidores = new ArrayList<String>();
                
                do {
                    int opcao = JOptionPane.showOptionDialog(null, "Selecione uma opção:", titulo_programa,
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[3]);

                    switch (opcao) {
                        case 0:
                            int selecao = 10;

                            do {
                                JComboBox<String> combobox = new JComboBox<>();
                                combobox.addItem("[Selecione o Consumidor]");

                                for (Usuario usuario : Usuario.listar(Usuario.class)) {
                                    if (consumidores.contains(usuario.getNome())) {
                                    }
                                    else {
                                        if(usuario instanceof Aluno){
                                        }
                                        else{
                                            combobox.addItem(usuario.getNome());
                                    }
                                    }
                                }

                                Object[] funcao = { "Cadastrar", "Cancelar" };

                                selecao = JOptionPane.showOptionDialog(null, combobox, titulo_programa,
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcao,
                                        funcao[0]);

                                if (selecao == 0) {
                                    if (combobox.getSelectedItem() == "[Selecione o Consumidor]") {
                                        JOptionPane.showMessageDialog(null, "Seleção inválida!", titulo_programa,
                                        JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        consumidores.add(combobox.getSelectedItem().toString());
                                        if (JOptionPane.showConfirmDialog(null, "Deseja realizar outro cadastro?",
                                            titulo_programa, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {                                            
                                            continue;
                                        } else {
                                            selecao = 1;
                                        }
                                    }
                                } else {}
                            } while (selecao != 1);
                            break;

                        case 1:
                            int selecao1 = 10;
                            if (consumidores.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum consumidor cadastrado!", titulo_programa,
                                JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                do {
                                    JComboBox<String> combobox = new JComboBox<>();
                                    combobox.addItem("[Selecione o consumidor a ser removido]");
                                    for (Usuario usuario : Usuario.listar(Usuario.class)) {
                                        if (consumidores.contains(usuario.getNome())) {
                                            combobox.addItem(usuario.getNome());
                                        }
                                    }

                                    Object[] funcao = { "Remover", "Cancelar" };
                                    selecao1 = JOptionPane.showOptionDialog(null, combobox, titulo_programa,
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcao,
                                                funcao[0]);

                                    if (selecao1 == 0) {
                                        String consumidorSelecionado = (String) combobox.getSelectedItem();
                                        if (combobox.getSelectedItem() == "[Selecione o consumidor a ser removido]") {
                                            JOptionPane.showMessageDialog(null, "Seleção inválida!", titulo_programa,
                                            JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            consumidores.remove(consumidorSelecionado);
                                            JOptionPane.showMessageDialog(null, "Consumidor removido com sucesso!",
                                            titulo_programa,JOptionPane.INFORMATION_MESSAGE);
                                                if (JOptionPane.showConfirmDialog(null, "Deseja remover outro consumidor?",
                                                    titulo_programa, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                                continue;
                                            }
                                        }
                                    }

                                    else {
                                        selecao1 = 1;
                                    }
                                } while (selecao1 != 1);
                            }
                            break;

                        
                        case 2:
                            if(consumidores.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Nenhum consumidor foi registrado,\npor favor registre ao menos 1.",titulo_programa,JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            else{
                                for (String nome : consumidores) {
                                        for (Usuario usuario : Usuario.listar(Usuario.class)) {
                                            if(usuario.getNome() == nome){
                                                if(usuario instanceof LivroReservado){
                                                    consumidorDeEventos.add((LivroReservado) usuario);
                                                }
                                            }
                                        }
                                } 
                                for (LivroReservado consumidor : consumidorDeEventos) {
                                        aluno.adicionar(consumidor);
                                }
                            }

                            int selecao2 = 10;
                            
                            JOptionPane.showMessageDialog(null,"Listando nossos livros...",titulo_programa,JOptionPane.PLAIN_MESSAGE);
                        
                            for (String titulo : Livro.Listar()) {
                                Livro livro = Livro.obterLivro(titulo);
                                JOptionPane.showMessageDialog(null,
                                "Título: " + titulo +
                                "\nAutor(a): " + livro.getAutor() +
                                "\nEditora: " + livro.getEditora(),
                                titulo_programa,JOptionPane.PLAIN_MESSAGE);
                            }

                            do{

                                JComboBox<String> combobox = new JComboBox<>();
                                combobox.addItem("[Selecione o Livro]");
                                for (String livro : Livro.Listar()) {
                                        combobox.addItem(livro);
                                }

                                Object[] funcao = { "Cadastrar", "Cancelar" };
                                selecao = JOptionPane.showOptionDialog(null, combobox, titulo_programa,
                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcao,
                                            funcao[0]);
                                
                                if (selecao == 0) {
                                    if (combobox.getSelectedItem() == "[Selecione o Livro]") {
                                        JOptionPane.showMessageDialog(null, "Seleção inválida!", titulo_programa,
                                        JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        livrosAlugados.add(combobox.getSelectedItem().toString());                                        
                                        
                                        aluno.cadastrarReserva(livrosAlugados, Util.obterDataAtual());

                                        if (JOptionPane.showConfirmDialog(null, "Deseja realizar outro cadastro?",
                                            titulo_programa, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {                                            
                                            
                                        } else {
                                            selecao2 = 1;
                                        }
                                    }
                                } else {}
                            }
                            while(selecao2 != 1);                            
                            break;
                        case 3:
                            controle = false;
                            String informacoes = null;
                            for (Usuario usuario : Usuario.listar(Usuario.class)){
                                if (usuario instanceof LivroReservado) {
                                    if(usuario instanceof Bibliotecario){                                        
                                        informacoes = ((LivroReservado) usuario).informarReserva();
                                        reservas = informacoes.split("\\$\\$\\$");
                                    }
                                    else{
                                        informacoes = ((LivroReservado) usuario).informarReserva();
                                    }
                                    if ((informacoes != null) && (reservas == null)) {
                                        JOptionPane.showMessageDialog(null, informacoes, titulo_programa, JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else if((informacoes != null) && (reservas != null)){
                                        for (String informacao : reservas) {                                            
                                            JOptionPane.showMessageDialog(null, informacao, titulo_programa, JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    }
                                    else{

                                    }
                                }
                            }
                            System.exit(0);
                        default:
                            break;
                    }
                } while (controle);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário.\nEncerrando operação...",
                        titulo_programa, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Erro no main: "+ e);
        }
System.exit(0);
    }

}