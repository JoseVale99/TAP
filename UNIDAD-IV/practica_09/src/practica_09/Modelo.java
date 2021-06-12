
package practica_09;

import java.util.Calendar;


public class Modelo {

    public Modelo() {
    }
    
    public int Year(String Fecha) {
        return Integer.parseInt(Fecha.substring(24, 28));

    }

    public int Mes(String Fecha) {
        String meses = Fecha.substring(4, 7);
        int Numero = 0;

        if (meses.equals("Jan")) {
            Numero = 1;
        } else if (meses.equals("Feb")) {
            Numero = 2;
        } else if (meses.equals("Mar")) {
            Numero = 3;
        } else if (meses.equals("Apr")) {
            Numero = 4;
        } else if (meses.equals("May")) {
            Numero = 5;
        } else if (meses.equals("Jun")) {
            Numero = 6;
        } else if (meses.equals("Jul")) {
            Numero = 7;
        } else if (meses.equals("Aug")) {
            Numero = 8;
        } else if (meses.equals("Sep")) {
            Numero = 9;
        } else if (meses.equals("Oct")) {
            Numero = 10;
        } else if (meses.equals("Nov")) {
            Numero = 11;
        } else if (meses.equals("Dec")) {
            Numero = 12;
        }

        return Numero;
    }

    public int Dia(String Fecha) {
        return Integer.parseInt(Fecha.substring(8, 10));
    }

    public int Calcular_Edad(int Anios, int meses, int dias) {
        int Edad = 0;

        Calendar Calendario = Calendar.getInstance();
        int Anio = Calendario.get(Calendar.YEAR);
        int MesI = (Calendario.get(Calendar.MONTH)) + 1;
        int Diass = Calendario.get(Calendar.DAY_OF_MONTH);

        Edad = Anio - Anios;

        if ((meses - MesI) > 0) {
            Edad--;
        } else if ((meses - MesI) == 0) {
            if ((dias - Diass) > 0) {
                Edad--;
            }
        }

        return Edad;
    }
}
