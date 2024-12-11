package infraestrutura;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    private Util(){}

    public static String obterDataAtual(){        
        Date data = new Date();
        return converterDataString(data, "dd-MM-yyyy");
    }

    @SuppressWarnings("deprecation")
    public static String somarDiasData(String stringData, int dias){
        try{
        Date data = converterStringData(stringData, "dd-MM-yyyy");
        data.setDate(data.getDate()+dias);
        return converterDataString(data, "dd-MM-yyyy");
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    private static Date converterStringData(String dataString, String formato){
        SimpleDateFormat formatacao = new SimpleDateFormat(formato);
        Date data = null;

        try {
            data = formatacao.parse(dataString);
            return data;
        }
        catch(Exception e){
            System.out.println(e);
            return data;
        }
    }

    private static String converterDataString(Date data, String formato){
        try{
            SimpleDateFormat formatacao = new SimpleDateFormat(formato);
            return formatacao.format(data);
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
