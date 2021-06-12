package com.example.asteroides;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    public static AlmacenPuntuaciones almacen =
            new AlmacenPuntuacionesArray();
    private   TextView titulo;
    private   Button bPreferencias;
    private   Button BAceca_De;
    private   Animation animation;
    private   Animation animacion;
    private LinearLayout jugar;
    private MediaPlayer song,songplay;
    private SharedPreferences pref;
    private String estadomusica;
    private GestureLibrary librearia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = (TextView) findViewById(R.id.textView);
        bPreferencias = (Button) findViewById(R.id.botConf);
        BAceca_De = (Button) findViewById(R.id.botAcerca);

        animacion = AnimationUtils.loadAnimation(this,
                R.anim.giro_con_zoom);
        titulo.startAnimation(animacion);
        jugar = (LinearLayout) findViewById(R.id.principio);
        animation = AnimationUtils.loadAnimation(this,
                R.anim.aparecer);
        jugar.startAnimation(animation);
        Animation desplazar = AnimationUtils.loadAnimation(this,
                R.anim.desplazamiento_derecha);

        bPreferencias.startAnimation(desplazar);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        estadomusica = Boolean.toString(pref.getBoolean("musica",true));

        //song = MediaPlayer.create(this,R.raw.tema_principal);

        // song.setLooping(true);
        librearia = GestureLibraries.fromRawResource(this,R.raw.disparo);
        if (!librearia.load())
            finish();


        songplay = MediaPlayer.create(this, R.raw.tema_juego);
        if (estadomusica.equals("true")) {
            songplay.start();
        } else {
            songplay.start();
            songplay.pause();
        }

        // song.start();
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
    }

    public void lanzarAcercaDe(View view){
        BAceca_De.startAnimation(animacion);
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }
    public void lanzarPreferencias(View view){
        Intent i = new Intent(this, Preferencias.class);
        startActivity(i);

    }
    public void Salir(View view){
        exit(0);
    }
    public void lanzarPuntuaciones(View view){
        Intent i = new Intent(this, Puntuaciones.class);
        startActivity(i);
    }
    public void lanzarJuego(View view){
        //  song.pause();
        // songplay = MediaPlayer.create(this,R.raw.tema_juego);
        // songplay.start();
        //songplay.setLooping(true);

        Intent i = new Intent(this, Juego.class);
        startActivity(i);

    }


    public void mostrarPreferencias(View view){
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        String s = "música: " + pref.getBoolean("musica",true)
                + ", graficos: " + pref.getString("graficos","?")
                + ", fragmentos" + pref.getString("fragmentos","3");
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    public void onGesturePerformed(GestureOverlayView ov, Gesture gesto){
        ArrayList<Prediction> predicciones = librearia.recognize(gesto);
        if (predicciones.size()>0){
            String comando = predicciones.get(0).name;
            if (comando.equals("play")){
                lanzarJuego(null);
            } else if(comando.equals("configurar")){
                lanzarPreferencias(null);
            } else if(comando.equals("acerca_de")){
                lanzarAcercaDe(null);
            } else if(comando.equals("cancelar")){
                finish();
            }
        }
    }




    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        estadomusica = Boolean.toString(pref.getBoolean("musica",true));
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
        if (estadomusica.equals("true")) {
            songplay.start();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
        songplay.pause();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle estadoGuardado){
        super.onSaveInstanceState(estadoGuardado);
        if (songplay!=null){
            int pos = songplay.getCurrentPosition();
            estadoGuardado.putInt("posicion",pos);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle estadoGuardado){
        super.onRestoreInstanceState(estadoGuardado);
        if (estadoGuardado!=null && songplay!=null){
            int pos = estadoGuardado.getInt("posicion");
            songplay.seekTo(pos);
        }
    }
}