package infraestrutura;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public class Util {
    private Util(){}

    public static String obterDataAtual(){        
		LocalDate dataAtual = LocalDate.now();
		return (dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static String somarDiasData(String stringData, int dias){
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(stringData, formatadorData);
		LocalDate dataFinal = data.plusDays(dias);
		return (dataFinal.format(formatadorData));
    }


    private static LocalDate converterStringData(String dataString, String formato){
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern(formato);
		LocalDate data = LocalDate.parse(dataString, formatadorData);
		return (data);
    }

    private static String converterDataString(LocalDate data, String formato){
        return (data.format(DateTimeFormatter.ofPattern(formato)));
    }
}
