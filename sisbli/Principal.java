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
                                    } else {
                                        combobox.addItem(usuario.getNome());
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
                                } else {
                                }
                            } while (selecao != 1);
                            break;

                        case 1:

                            int selecao1 = 10;
                            System.out.println(consumidores);
                            if (consumidores.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum consumidor cadastrado!", titulo_programa,
                                        JOptionPane.WARNING_MESSAGE);

                            } else {
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
                                                    titulo_programa,
                                                    JOptionPane.INFORMATION_MESSAGE);
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
                       
                            break;
                        case 3:
                            controle = false;
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

        // Encerra o programa
        System.exit(0);
    }

}