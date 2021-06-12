package com.example.asteroides;



import java.util.Vector;
public interface AlmacenPuntuaciones {

    void guardarPuntuacion(int puntos, String nombre, long fecha);
    Vector< String > listaPuntuaciones(int cantidad);
}
