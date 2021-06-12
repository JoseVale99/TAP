package com.example.asteroides;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;
import java.util.Vector;

// public class VistaJuego extends View  implements SensorEventListener { // para implementar sensores
public class VistaJuego extends View {
    private Drawable drawableAsteroide[] = new Drawable[3];
    private Vector<Grafico> asteroides; // vector con los asteroides
    private int numAsteroides = 5;
    private int numFragmentos = 3;
    // NAVE
    private Grafico nave;
    private int giroNave; // Incremento de dirección
    private double aceleracionNave; // aumento de la velocidad
    private static final int MAX_VELOCIDAD_NAVE = 20;
    private static final int PASO_GIRO_NAVE = 5;
    private static final float PASO_ACELERACION_NAVE= 0.5f;

    private float mX=0 , mY=0;
    private boolean disparo = false;

    // MISIL
    //private  Grafico misil;
    private Vector<Grafico> misiles;
    private static int PASO_VELOCIDAD_MISIL =12;
    //private boolean misilActivo = false;
    //private  int tiempoMisil;
    private Vector<Integer> tiempoMisiles;
    private Drawable  drawableMisil;

    //Manejor de sensores
    /*
    private boolean hayValorInicial = false;
    private float valorInicial;
    */

    //
    // //// THREAD Y TIEMPO //////
    // Thread encargado de procesar el juego
    private ThreadJuego thread = new ThreadJuego();
    // Cada cuanto queremos procesar cambios (ms)
    private static int PERIODO_PROCESO = 50;
    // Cuando se realizó el último proceso
    private long ultimoProceso = 0;

    //Multimedia
    private SoundPool soundPool;
    private int idDisparo, idExplosion;

    public VistaJuego(Context context, AttributeSet attrs){
        super(context,attrs);
        //-- Drawable drawableNave, drawableAsteroide;

        Drawable drawableNave; //, drawableMisil;

        // drawableAsteroide = context.getResources().getDrawable(R.drawable.asteroide1);

        // Registro del sensor
        /*
        SensorManager mSensorManager = (SensorManager)  context.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> listSensors = mSensorManager.getSensorList( Sensor.TYPE_ORIENTATION);

        if (!listSensors.isEmpty()) {
            Sensor orientationSensor = listSensors.get(0);
            mSensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_GAME);
        }
         */
        //Asteroides con gráficos vectoriales

        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        idDisparo = soundPool.load(context,R.raw.disparo,0);
        idExplosion = soundPool.load(context,R.raw.explosion,0);


        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        if( pref.getString("graficos","1").equals("0")){
            Path pathAsteroide = new Path();
            pathAsteroide.moveTo((float) 0.3, (float) 0.0);
            pathAsteroide.lineTo((float) 0.6,(float) 0.0);
            pathAsteroide.lineTo((float) 0.6,(float) 0.3);
            pathAsteroide.lineTo((float) 0.8,(float) 0.2);
            pathAsteroide.lineTo((float) 1.0,(float) 0.4);
            pathAsteroide.lineTo((float) 0.8,(float) 0.6);
            pathAsteroide.lineTo((float) 0.9,(float) 0.9);
            pathAsteroide.lineTo((float) 0.8,(float) 1.0);
            pathAsteroide.lineTo((float) 0.4,(float) 1.0);
            pathAsteroide.lineTo((float) 0.0,(float) 0.6);
            pathAsteroide.lineTo((float) 0.0,(float) 0.2);
            pathAsteroide.lineTo((float) 0.3,(float) 0.0);


            for(int i=0; i < 3; i++){
                ShapeDrawable dAsteroide = new ShapeDrawable(
                        new PathShape(pathAsteroide,1,1));
                dAsteroide.getPaint().setColor(Color.WHITE);
                dAsteroide.getPaint().setStyle(Paint.Style.STROKE);
                dAsteroide.setIntrinsicHeight(50 - i * 14);
                dAsteroide.setIntrinsicWidth(50 - i * 14);
                drawableAsteroide[i] = dAsteroide;
            }
            setBackgroundColor(Color.BLACK);
            //setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        }
        else {

            drawableAsteroide[0] = context.getResources().getDrawable(R.drawable.asteroide1);
            drawableAsteroide[1] = context.getResources().getDrawable(R.drawable.asteroide2);
            drawableAsteroide[2] = context.getResources().getDrawable(R.drawable.asteroide3);
            //drawableAsteroide = context.getResources().getDrawable(R.drawable.asteroide1);
            //setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        //----

        //drawableNave = context.getResources().getDrawable(R.drawable.nave);

        // -- NAVE CON VECTORIAL
        if (pref.getString("graficos", "1").equals("0")) {
            Path pathNave = new Path();
            pathNave.moveTo((float) 0.0, (float) 0.0);
            pathNave.lineTo((float) 1.0, (float) 0.5);
            pathNave.lineTo((float) 0.0, (float) 1.0);
            pathNave.lineTo((float) 0.0, (float) 0.0);
            ShapeDrawable dNave = new ShapeDrawable(
                    new PathShape(pathNave, 1, 1));
            dNave.getPaint().setColor(Color.WHITE);
            dNave.getPaint().setStyle(Paint.Style.STROKE);
            dNave.setIntrinsicHeight(15);
            dNave.setIntrinsicWidth(20);
            drawableNave = dNave;

        } else {
            drawableNave = context.getResources().getDrawable(
                    R.drawable.nave);
        }
        //

        nave = new Grafico(this, drawableNave);


        // MISIL
        if (pref.getString("graficos","1").equals("0")){
            ShapeDrawable dMisil = new ShapeDrawable(new RectShape());
            dMisil.getPaint().setColor(Color.WHITE);
            dMisil.getPaint().setStyle(Paint.Style.STROKE);
            dMisil.setIntrinsicWidth(15);
            dMisil.setIntrinsicHeight(3);
            drawableMisil = dMisil;
        } else {
            drawableMisil = context.getResources().getDrawable(R.drawable.misil1);
        }
        //----
        misiles = new Vector<Grafico>();
        //misil = new Grafico(this,drawableMisil);
        tiempoMisiles = new Vector<Integer>();
        asteroides = new Vector<Grafico>();
        for( int i = 0; i < numAsteroides; i++){
            Grafico asteroide = new Grafico(this, drawableAsteroide[0]);
            asteroide.setIncY(Math.random() * 4 - 2);
            asteroide.setIncX(Math.random()* 4 - 2);
            asteroide.setAngulo((int) Math.random() * 360);
            asteroide.setRotacion((int) Math.random()* 8 - 4);
            asteroides.add(asteroide);
        }

    }

    @Override protected void onSizeChanged( int ancho, int alto, int ancho_anter, int alto_anter){
        super.onSizeChanged(ancho,alto,ancho_anter, alto_anter);
        nave.setPosX(ancho/2);
        nave.setPosY(alto/2);

        for (Grafico asteroide: asteroides){
            do {
                asteroide.setPosX((int) (Math.random() * ancho));
                asteroide.setPosY((int) (Math.random() * alto));
            }while (asteroide.distancia(nave) < (ancho + alto)/5 );
        }
        ultimoProceso = System.currentTimeMillis();
        thread.start();

    }

    @Override public synchronized void onDraw(Canvas canvas){
        super.onDraw(canvas);
        synchronized (asteroides) {
            for (Grafico asteroide : asteroides) {
                asteroide.dibujaGrafico(canvas);
            }
        }

        nave.dibujaGrafico(canvas);

        //if( misilActivo)
        // misil.dibujarGrafico(canvas);

        for (Grafico misil : misiles) {
            misil.dibujaGrafico(canvas);

        }

    }



    synchronized void actualizaFisica(){
        long ahora = System.currentTimeMillis();
        if(ultimoProceso + PERIODO_PROCESO > ahora){
            return;  // Salir si el periodo de proceso no se ha cumplido.
        }

        // Para una ejecución en tiempo real calculamos retardo
        double retardo = (ahora - ultimoProceso) / PERIODO_PROCESO;
        ultimoProceso = ahora;

        //Actualizar velocidad y dirección de lanave

        nave.setAngulo((int) (nave.getAngulo() + giroNave * retardo));

        double nIncX = nave.getIncX() + aceleracionNave * Math.cos(Math.toRadians(nave.getAngulo())) * retardo;
        double nIncY = nave.getIncY() + aceleracionNave * Math.sin(Math.toRadians(nave.getAngulo())) * retardo;

        //

        if(Math.hypot(nIncX,nIncY) <= MAX_VELOCIDAD_NAVE){
            nave.setIncX(nIncX);
            nave.setIncY(nIncY);
        }
        nave.incrementaPos(retardo); // actualizar la posición

        for ( Grafico asteroide : asteroides){
            asteroide.incrementaPos(retardo);
        }

        /*
        // Actualizar la posición del misil - solo un misil

        if (misilActivo){
            misil.incrementaPos(retardo);
            tiempoMisil -= retardo;
            if (tiempoMisil < 0){
                misilActivo = false;
            } else {
                for ( int i = 0; i < asteroides.size(); i++)
                    if ( misil.verificaColision(asteroides.elementAt(i))){
                        destruyeAsteroide(i);
                        break;
                    }
            }
        }
         */
        if (!misiles.isEmpty()) {
            for (int m = 0; m < misiles.size(); m++) {
                misiles.elementAt(m).incrementaPos(retardo);
                tiempoMisiles.set(m, tiempoMisiles.get(m) - 1);
                if (tiempoMisiles.get(m) >= 0) {
                    for (int i = 0; i < asteroides.size(); i++)
                        if (misiles.elementAt(m).verificaColision(asteroides.elementAt(i))) {
                            destruyeAsteroide(i);
                            destruyeMisil(m);
                            break;
                        }
                } else {
                    destruyeMisil(m);
                }

            }
        }

    }
/*
    private synchronized void destruyeAsteroide(int i){
        synchronized (asteroides) {
            asteroides.removeElementAt(i);
            //misilActivo = false;
            soundPool.play(idExplosion,1,1,0,0,1);
        }
    }*/

    private synchronized void destruyeAsteroide(int i){
        int tam;
        if (asteroides.get(i).getDrawable()!=drawableAsteroide[2]){
            if(asteroides.get(i).getDrawable()==drawableAsteroide[1]){
                tam=2;
            } else {
                tam=1;
            }
            for(int n = 0; n < numFragmentos; n++){
                Grafico asteroide = new Grafico(this,drawableAsteroide[tam]);
                asteroide.setPosY(asteroides.get(i).getPosY());
                asteroide.setPosX(asteroides.get(i).getPosX());
                asteroide.setIncX(Math.random() * 7-2-tam);
                asteroide.setIncY(Math.random() * 7-2-tam);
                asteroide.setAngulo((int) (Math.random() * 360));
                asteroide.setRotacion((int) (Math.random() * 8-4));
                asteroides.add(asteroide);
            }
        }
        synchronized (asteroides){
            asteroides.removeElementAt(i);
           // misilActivo = false;
            soundPool.play(idExplosion,1,1,0,0,1);
        }
    }







    private synchronized void destruyeMisil(int i){
        synchronized (misiles){
            misiles.removeElementAt(i);
            tiempoMisiles.removeElementAt(i);
        }
    }

    private synchronized void activaMisil(){
        //misil.setCenX(nave.getCenX());
        //misil.setCenY(nave.getCenY());
        //misil.setAngulo(nave.getAngulo());
        //misil.setIncX(Math.cos(Math.toRadians(misil.getAngulo())) * PASO_VELOCIDAD_MISIL);
        //misil.setIncY(Math.sin(Math.toRadians(misil.getAngulo())) * PASO_VELOCIDAD_MISIL);
        //tiempoMisil = (int) Math.min(this.getWidth() / Math.abs(misil.getIncX()), this.getHeight()/ Math.abs(misil.getIncY())) - 2;
        //misilActivo = true;

        //varios misiles
        misiles.add(new Grafico(this, drawableMisil));
        misiles.get(misiles.size()-1).setPosX(nave.getPosX());
        misiles.get(misiles.size()-1).setPosY(nave.getPosY());
        misiles.get(misiles.size()-1).setAngulo(nave.getAngulo());
        misiles.get(misiles.size()-1).setIncX(Math.cos(Math.toRadians(misiles.get(misiles.size()-1).getAngulo()))
                * PASO_VELOCIDAD_MISIL);
        misiles.get(misiles.size()-1).setIncY(Math.sin(Math.toRadians(misiles.get(misiles.size()-1).getAngulo()))
                * PASO_VELOCIDAD_MISIL);
        soundPool.play(idDisparo,1,1,1,0,1);
        // agregar tiempo
        Double d = (Math.min(this.getWidth() / Math.abs(misiles.get(misiles.size()-1).getIncX()),
                this.getHeight()/ Math.abs(misiles.get(misiles.size()-1).getIncY())) - 2);
        Integer t = d.intValue();
        tiempoMisiles.add(t);

    }
    @Override
    public boolean onKeyDown(int codigoTecla, KeyEvent evento) {
        super.onKeyDown(codigoTecla, evento);
        // Suponemos que vamos a procesar la pulsación
        boolean procesada = true;
        switch (codigoTecla) {
            case KeyEvent.KEYCODE_DPAD_UP:
                aceleracionNave += PASO_ACELERACION_NAVE;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                giroNave -= PASO_GIRO_NAVE;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                giroNave += PASO_GIRO_NAVE;
                break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                activaMisil();

                break;
            default:

                // Si estamos aquí, no hay pulsación que nos interese
                procesada = false;
                break;
        }
        return procesada;
    }

    @Override
    public boolean onKeyUp(int codigoTecla, KeyEvent evento) {
        super.onKeyUp(codigoTecla, evento);
        // Suponemos que vamos a procesar la pulsación
        boolean procesada = true;
        switch (codigoTecla) {
            case KeyEvent.KEYCODE_DPAD_UP:
                aceleracionNave = 0;
                break;

            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                giroNave = 0;
                break;
            default:
                // Si estamos aquí, no hay pulsación que nos interese
                procesada = false;
                break;
        }

        return procesada;
    }

    @Override public synchronized boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch ( event.getAction()){
            case MotionEvent.ACTION_DOWN:
                disparo = true;


                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - mX);
                float dy = Math.abs(y - mY);
                if (dy < 6 && dx > 6){
                    giroNave = Math.round((x - mX) / 2);
                    disparo = false;
                } else if (dx < 6 && dy >6){
                    aceleracionNave = Math.round((mY - y) / 25);
                    disparo = false;
                }
                break;

            case MotionEvent.ACTION_UP:
                giroNave = 0;
                aceleracionNave = 0;
                if ( disparo ){
                    activaMisil();
                }
                break;
        }
        mX = x ;
        mY = y ;
        return true;
    }

    //Métodos que se sobreescriben para los sensores..
    /*
     @Override
     public void onAccuracyChanged(Sensor sensor, int accuracy){
    }

    @Override
    public  void onSensorChanged(SensorEvent event){
        float valor = event.values[1];
        if( !hayValorInicial ){
            valorInicial = valor;
            hayValorInicial = true;
        }
        giroNave = (int) (valor-valorInicial/3);
    }

     */  //Fin de los métodos para sensores

    public class ThreadJuego extends Thread {
        @Override
        public synchronized void run(){
            while (true){
                actualizaFisica();
            }
        }
    }


}
