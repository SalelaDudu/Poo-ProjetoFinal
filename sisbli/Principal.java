import javax.swing.JOptionPane;
import infraestrutura.Util;
public class Principal {
    // ATENÇÃO -> REMOVER ***TODOS*** OS COMENTÁRIOS ANTES DE ENVIAR PARA O CAYO
    public static void main(String[] args){
        // String que recebe o título da janeal do programa
        String titulo_programa = "Sistema Bibliotecário | v0.1";        
        System.out.println(Util.obterDataAtual());
        // Recebe o login do usuario
        //String usuario_login = JOptionPane.showInputDialog(null,"Informe seu login:",titulo_programa,JOptionPane.PLAIN_MESSAGE);
        //String usuario_senha = JOptionPane.showInputDialog(null,"Informe sua senha:",titulo_programa,JOptionPane.PLAIN_MESSAGE);

        // Encerra o programa
        System.exit(0);
    }
    
}