package polinomio;

import java.io.Serializable;

public class Polinomio implements Serializable {

    // Creación de los atributos
    protected double coeficiente[];
    protected static int MAX_GRADO = 3;//para este caso muestra 
    protected static int MIN_GRADOrl;
    protected int grado;

    public Polinomio() {
        coeficiente = new double[MAX_GRADO + 1];
        for (int c = 0; c <= MAX_GRADO; c++) {
            coeficiente[c] = 0.0d;
        }
    }

    public Polinomio(double[] coeficiente) throws Exception {
        if (coeficiente.length > 1) {
            this.coeficiente = coeficiente;
        } else {
            throw new Exception("Numero de coeficientes debe ser > 1");
        }
    }

    public void setcoeficiente(double coefs[]) {
        grado = coefs.length - 1; //Asegura el minimo de coeficientes 
        if (coefs.length > 1) {
            coeficiente = coefs;
        }
    }
 // obtención del grado del polinomio
    public int getGrado() {
        return grado;
    }
// método para recuperar los valores de los coeficientes
    public double[] getCoeficiente() {

        return coeficiente;
    }
  // método para obtener Y para un valor dado de X
    public double getY(double x) {
        double y = 0.0;
        for (int c = 0; c <= grado; c++) {
            y += coeficiente[c] * Math.pow(x, c);
        }
        return y;
    }
 // calculo de la derivada del polinomio para un valor dado de X
    public double getDerFx(double x) {
        double dx = 0;
        for (int c = 0; c < grado; c++) {
            dx += coeficiente[c] * Math.pow(x, c - 1);
        }
        return dx;
    }
// método para regresar una cadena con el polinomio formado
    public String getPolinomio() {
// Regresa una cadena representado al polinomio, como por ejemplo 
// 1.0-3.0X+2.0^2     
     double[] coeficientes = getCoeficiente();
        String polinomio = String.valueOf(coeficientes[0]);
        for (int i = 1; i < coeficientes.length; i++) {
            if (coeficientes[i] < 0) {
                polinomio += coeficientes[i] + "X^" + i;
            } else {
                polinomio += "+" + coeficientes[i] + "X^" + i;
            }
        }
        return polinomio;
    }

    public double[] getRaices() throws Exception {
        double x[] = null;
        if (grado == 1) {//Ecuacion lineal // Calculo de X 
            x = new double[grado];
            if (coeficiente[0] != 0) {
                x[0] = -1 * coeficiente[0] / coeficiente[1];
            } else {
                throw new Exception("Coeficiente de X debe debe ser !=0");
            }
        } else if (grado == 2) { // Ecuacion cuadratica 
// Regresa las raices de la ecuacion X[0) y X(1) si son reales 
// Si son imaginarias: x(0] es el valor real, y x[1] y x[2] los valores imaginarios 
//Usando la formula general 
            x = new double[2];
            double a = coeficiente[2];
            double b = coeficiente[1];
            double c = coeficiente[0];
            double rad = Math.pow(b, 2.0) - 4 * a * c;
            if (rad >= 0) // Raices reales 
            {
                x[0] = (-b + Math.sqrt(rad)) / (2 * a);
                x[1] = (-b - Math.sqrt(rad)) / (2 * a);
            } else // Raices imaginarias 
            {
                x = new double[4];
                x[0] = x[2] = -b / (2 * a); // parte real
                x[1] = Math.sqrt(Math.abs(rad)) / (2 * a);
                x[3] = -1 * (Math.sqrt(Math.abs(rad)) / (2 * a));
            }
        } else if (grado > 2) {
//Utilizando el Metodo Newton-Raphson double derivada; 
            final int MAX_ITERA = 100;
            final double PRECISION = 0.001;
            x = new double[grado];
            double error = 9999.0, xi = 0, x1 = 0;
            int i = 0, n = 0;
            for (n = 0; n < grado; n++) {
                i = 0;
                do {
                    xi = x1;
                    x1 = xi - (getY(xi) / getDerFx(xi));
                    i++;
                } while ((Math.abs((x1 - xi) / x1)) * 100 > PRECISION && i <= MAX_ITERA);
                x[n] = x1;
                
            }
        }
        return x;
    }
    public static void main(String[] args) throws Exception {
         Polinomio  pol = new Polinomio();
        //double coef[] = new double[3];
         double coef[]={4,-40,2,1};
        System.err.println("Ecuacion de primer grado: ");
        pol.setcoeficiente(coef);
       // System.err.println(pol.getDerFx(2));
        System.out.println("x="+pol.getRaices().length);
        System.out.println(pol.getPolinomio());
        //System.err.println(pol.getDerFx(MAX_GRADO));
        System.err.println(pol.getY(MAX_GRADO));
        System.out.println("Grado de la ec: "+pol.getGrado());
        double array []= pol.getRaices();
        for (int i = 0; i <array.length; i++) {
            System.out.println(array[i]);
        }
        
    }
}
