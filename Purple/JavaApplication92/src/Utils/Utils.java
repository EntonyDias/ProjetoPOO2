package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Utils {

    public static Date converterStringToDate(String texto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;

        try {
            data = formato.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter data");
        }

        return data;
    }
    
    public static String converterDateToString(Date datnas) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = "";

        try {
            data = formato.format(datnas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter String: "+e);
        }

        return data;
    }
}
