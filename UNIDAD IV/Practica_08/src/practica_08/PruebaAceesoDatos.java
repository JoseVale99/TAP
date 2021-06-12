package practica_08;

import java.util.ArrayList;

public class PruebaAceesoDatos {

    public static void main(String arg[]) throws ClassNotFoundException {
        System.out.print("Consulta tabla PERSONA");
        String consulta = "SELECT * FROM ROOT.PERSONA";
        ManejoDatos baseDatos = new ManejoDatos(); // atributo de la clase ManejoDatos
        ArrayList<Object[]> actividad = (ArrayList<Object[]>) baseDatos.conexionConsultaPersona(consulta);
        for (int ne = 0; ne < actividad.size(); ne++) {
            Object reg[] = actividad.get(ne);
            System.out.println();
            for (int c = 0; c < reg.length; c++) {
                System.out.printf("%-33s", reg[c]);
            }

        }
        System.out.print("\n");
        System.out.print("Consulta tabla TIPOACTIUIDAD");
     String consulta2 = "SELECT * FROM ROOT.TIPOACTIUIDAD";
        ManejoDatos baseDatos2 = new ManejoDatos(); // atributo de la clase ManejoDatos
        ArrayList<Object[]> actividad2 = (ArrayList<Object[]>) baseDatos.conexionconsultaActividad(consulta);
        for (int ne = 0; ne < actividad.size(); ne++) {
            Object reg[] = actividad.get(ne);
            System.out.println();
            for (int c = 0; c < reg.length; c++) {
                System.out.printf("%-33s", reg[c]);
            }

        }

    }
}
