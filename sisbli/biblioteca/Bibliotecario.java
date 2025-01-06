package biblioteca;
import divisao.Setor;
import java.util.List;

import acesso.Funcionalidade;

import java.util.ArrayList;

public class Bibliotecario extends Funcionario implements LivroReservado{    
    private List<Emprestimo> emprestimos;

    public Bibliotecario(String nome,String login, String senha, Setor lotacao, String cpf, List<Funcionalidade> funcionalidades){
        super(nome,login,senha,lotacao,cpf,funcionalidades);
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public void cadastrarEmprestimo(Reserva reserva){
        emprestimos.add(new Emprestimo(reserva));
    }

    @Override
    public void ocorreu(Reserva reserva) {
            cadastrarEmprestimo(reserva);
            System.out.println("Bibliotecário notificado sobre a reserva dos livros:");
            for (Livro livro : reserva.getLivros()) {
                    
                if(livro == null){
                        System.out.println("O LIVRO É NULO, NÃO DEVERIA MAS É NULO");
                    }
                System.out.println(livro);
                if(livro.getTitulo() == null){
                        System.out.println("CHOREI HORRORES");
                    }
            }


    }

    @Override   
    public String informarReserva() {
        if (emprestimos.isEmpty()) {
            return "Nenhuma reserva ou empréstimo pendente.";
        }
        try{

            Emprestimo emprestimo = emprestimos.get(0);
            List<Exemplar> exemplar = emprestimo.getExemplares();
            Exemplar exemplarB = exemplar.getFirst();
            String retorno = "";

            try{
                retorno += "###"+ getNome() + "("+ getClass() +") informa: ###\n";
                retorno += "Data Retirada: "+ emprestimo.getDataRetirada();
                retorno += "\nData Devolução: " + emprestimo.getDataDevolucao();
        
                retorno += "\nLivro: " + exemplarB.getLivro().getTitulo();
                retorno += "\nAutor: " + exemplarB.getLivro().getAutor();
                retorno += "\nEditora: " + exemplarB.getLivro().getEditora();
                retorno += "\nExemplar nº: " + exemplarB.getCodigo();
                retorno += "\nSituação: " + exemplarB.getSituacao();

                return retorno;
            }catch(Exception e){
                System.out.println("Erro na designação dos parametros"+e);
            }
        }catch(Exception e){
            System.out.println("Erro na definição das variavel tlgd: " + e);
        }
        System.out.println("Nem chegou a usar os atributos só foi pro nulo");
        return null;
    }
}
