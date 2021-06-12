package com.example.asteroides;


import java.util.Vector;

public class AlmacenPuntuacionesArray  implements AlmacenPuntuaciones{
    private Vector< String > puntuaciones;

    public AlmacenPuntuacionesArray(){
        puntuaciones = new Vector< String >();
        puntuaciones.add("111111 Martin Miranda");
        puntuaciones.add("100000 Marta Gargaglione");
        puntuaciones.add("090000 Enzo Trotore");
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre,
                                  long fecha){
        puntuaciones.add(0,puntos + " " + nombre);
    }

    public Vector< String > listaPuntuaciones(int cantidad){
        return puntuaciones;
    }


}
