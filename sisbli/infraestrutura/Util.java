package infraestrutura;
import java.util.Date;

public class Util {
    private Util(){}

    public static String obterDataAtual(){
        Date d = new Date();
        int dia = d.getDay();
        int mes = d.getMonth();
        int ano = d.getYear();
        String data = "";
        data += Integer.toString(dia);
        return 
    }

    public static String somarDiasData(String stringData, int dias){

        return "";
    }

    private static Date converterStringData() {
        Date d = new Date();        
        return d;
    }
}
