import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
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

        try {

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
                                        if(usuario.getClass().equals(Aluno.class)){
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
                            int selecao2 = 10;
                            List<String> livros = new ArrayList<String>();
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
                                String titulo = JOptionPane.showInputDialog(null, "Informe o título do livro que deseja reservar:",
                                titulo_programa, JOptionPane.OK_CANCEL_OPTION);
                                livros.add(titulo);
                                selecao2 = JOptionPane.showConfirmDialog(null,"Deseja cadastrar reserva para mais um livro?", titulo_programa, 0, JOptionPane.QUESTION_MESSAGE);
                            }
                            while(selecao2 != 1);
                            
                            for (String titulo : livros) {
                                if (titulo == null || titulo == "") {
                                    JOptionPane.showMessageDialog(null, "O título:"+ titulo +" é inválido!", titulo_programa,
                                    JOptionPane.WARNING_MESSAGE);
                                }
                                else {
                                    Livro livro = Livro.obterLivro(titulo);
                                    Exemplar exemplar = Livro.obterExemplar(livro);
                            
                                    if (exemplar != null) {                                                                   
                                        Usuario usuarioLogado = Usuario.obter(usuario_login, usuario_senha);
                                            // Reserva reserva = new Reserva(Util.obterDataAtual(), List.of(livro));
                                            // usuarioLogado.cadastrarReserva(List.of(titulo), Util.obterDataAtual()); 
                            
                                        JOptionPane.showMessageDialog(null, "Livro reservado com sucesso!", titulo_programa,
                                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Não há exemplares disponíveis para este livro.", titulo_programa,
                                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                            
                        break;
                        case 3:
                            controle = false;
                            for (Usuario usuario : Usuario.listar(Usuario.class)) {
                                if (usuario instanceof LivroReservado) {
                                    String informacoes = ((LivroReservado) usuario).informarReserva();
                                    if (informacoes != null) {
                                        JOptionPane.showMessageDialog(null, informacoes, titulo_programa, JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                            }
                        default:
                            break;
                    }
                } while (controle);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário.\nEncerrando operação...",
                        titulo_programa, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
System.exit(0);
    }

}