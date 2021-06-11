package ModeloVotacion;

public class Modelo {

    double promedio1 = 0, promedio2 = 0, promedio3 = 0;

    public Double Operacion1(int votos, double i1) {
        promedio1 = i1 * 100.00 / votos;
        return promedio1;
    }

    public Double Operacion2(int inc, double i2) {
        promedio2 = i2 * 100.00 / inc;
        return promedio2;
    }

    public Double Operacion3(int inc, double i3) {
        promedio3 = i3 * 100.00 / inc;
        return promedio3;
    }
    
    public Float CalcularPresuouesto(float a, float b, float c ){
    
    float suma =0;
        
    suma+=a+b+c;
    
        
    return suma;
    }
    
}
