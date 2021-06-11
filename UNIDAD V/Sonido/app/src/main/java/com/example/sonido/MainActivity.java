package com.example.sonido;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer reprod; // sonido continuo
    private TextView frase; // frase a formar
    //sujeto
    private ImageButton ibegale; // boton aguila
    private ImageButton ibnino; // btn niño
    private ImageButton ibperro; // btn perro
    //verbo
    private ImageButton ibsaltar; // btn saltar
    private ImageButton ibdormir; //btn dormir;
    private ImageButton ibcomer; // btn comer
    // complemento
    private ImageButton ibpark; //btn parque
    private ImageButton ibcama; // btn cama
    private ImageButton ibcasa; // btn casa

    private String subject;
    private String verb;
    private String complement;
    private Button salir;
    private Button regresar;
    private Animation animacion,desplazar;
    private MediaPlayer sujeto, verbo, complemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // asiganación de las referencias
    frase = (TextView) findViewById(R.id.tFrase);
    // subject

        ibegale = (ImageButton) findViewById(R.id.Btneagle);
        ibnino = (ImageButton) findViewById(R.id.Btnino);
        ibperro = (ImageButton) findViewById(R.id.Btnperro);
        // Verb
        ibsaltar =  (ImageButton) findViewById(R.id.BtnSaltar);
        ibdormir =  (ImageButton) findViewById(R.id.BtnDormir);
        ibcomer =  (ImageButton) findViewById(R.id.BtnComer);
        // complement
        ibpark =  (ImageButton) findViewById(R.id.BtnPark);
        ibcama =  (ImageButton) findViewById(R.id.BtnCama);
        ibcasa =  (ImageButton) findViewById(R.id.BtnCasa);

        // Functions

        salir = (Button) findViewById(R.id.BtnSalir);
        regresar = (Button) findViewById(R.id.BtnRegresar);
        animacion = AnimationUtils.loadAnimation(this,
                R.anim.anim);

         desplazar = AnimationUtils.loadAnimation(this,
                R.anim.desplazamiento_derecha);
        frase.startAnimation(desplazar);
    }

    public void FraseAudible(View view){
        switch (view.getId()){
            case R.id.Btnino:
                if (reprod == null || !reprod.isPlaying()){
                    // Asignación de la frase
                   subject = "El niño";
                    frase.startAnimation(animacion);
                     frase.setText(subject);
                    // Deshabilta los botones
                    ibegale.setEnabled(false);
                    ibnino.setEnabled(false);
                    ibperro.setEnabled(false);
                    // audio del momento

                    sujeto = MediaPlayer.create(this,R.raw.ninio);
                    sujeto.start();
                }
                break;
            case R.id.Btnperro:
                if (reprod == null || !reprod.isPlaying()){
                    // Asignación de la frase
                    subject ="El perro";
                    frase.startAnimation(animacion);
                    frase.setText(subject);
                    // Deshabilta los botones
                    ibegale.setEnabled(false);
                    ibnino.setEnabled(false);
                    ibperro.setEnabled(false);
                    // audio del momento
                    sujeto = MediaPlayer.create(this,R.raw.perro);
                    sujeto.start();
                }
                break;

            case R.id.Btneagle:
                if (reprod == null || !reprod.isPlaying()){
                    // Asignación de la frase
                    subject = "El águila";
                    frase.startAnimation(animacion);
                    frase.setText(subject);
                    // Deshabilta los botones
                    ibegale.setEnabled(false);
                    ibnino.setEnabled(false);
                    ibperro.setEnabled(false);
                    // audio del momento
                    sujeto = MediaPlayer.create(this,R.raw.aguila);
                    sujeto.start();
                }
                break;
            case  R.id.BtnSaltar:
                        if (ibegale.isEnabled() || ibnino.isEnabled() || ibperro.isEnabled()){
                            Toast.makeText(MainActivity.
                                    this,"Seleccione un elemento del primer renglon",Toast.LENGTH_SHORT).show();

                        }else{
                            if (reprod == null || !reprod.isPlaying()){
                                // Asignación de la frase
                                verb ="está saltando";
                                frase.startAnimation(animacion);
                                frase.setText(subject+" "+verb);
                                // Deshabilta los botones
                                ibsaltar.setEnabled(false);
                                ibdormir.setEnabled(false);
                                ibcomer.setEnabled(false);
                                // audio del momento
                                verbo = MediaPlayer.create(this,R.raw.saltar);
                                verbo.start();
                            }

                            break;
                }
            case  R.id.BtnDormir:
                if (ibegale.isEnabled() || ibnino.isEnabled() || ibperro.isEnabled()){
                    Toast.makeText(MainActivity.
                            this,"Seleccione un elemento del primer renglon",Toast.LENGTH_SHORT).show();

                }else{
                    if (reprod == null || !reprod.isPlaying()){
                        // Asignación de la frase
                        verb = "esta durmiendo";
                        frase.startAnimation(animacion);
                        frase.setText(subject+" "+verb);
                        // Deshabilta los botones
                        ibsaltar.setEnabled(false);
                        ibdormir.setEnabled(false);
                        ibcomer.setEnabled(false);
                        // audio del momento
                        verbo = MediaPlayer.create(this,R.raw.dormir);
                        verbo.start();
                    }

                    break;
                }
            case  R.id.BtnComer:
                if (ibegale.isEnabled() || ibnino.isEnabled() || ibperro.isEnabled()){
                    Toast.makeText(MainActivity.
                            this,"Seleccione un elemento del primer renglon",Toast.LENGTH_SHORT).show();

                }else{
                    if (reprod == null || !reprod.isPlaying()){
                        // Asignación de la frase
                        verb="está comiendo";
                        frase.startAnimation(animacion);
                        frase.setText(subject+" "+verb);
                        // Deshabilta los botones
                        ibsaltar.setEnabled(false);
                        ibdormir.setEnabled(false);
                        ibcomer.setEnabled(false);
                        // audio del momento
                        verbo = MediaPlayer.create(this,R.raw.comer);
                        verbo.start();
                    }

                    break;
                }
            case  R.id.BtnPark:
                if (ibegale.isEnabled() || ibnino.isEnabled() || ibperro.isEnabled()
                || ibsaltar.isEnabled() || ibdormir.isEnabled() || ibcomer.isEnabled() ){
                    Toast.makeText(MainActivity.
                            this,"Seleccione un elemento del primer y segundo renglon",Toast.LENGTH_SHORT).show();

                }else{
                    if (reprod == null || !reprod.isPlaying()){
                        // Asignación de la frase
                        complement ="en el parque";
                        //frase.setText("en el parque");
                        frase.startAnimation(animacion);
                        frase.setText(subject +" "+verb+" "+complement);
                        // Deshabilta los botones
                        ibpark.setEnabled(false);
                        ibcama.setEnabled(false);
                        ibcasa.setEnabled(false);
                        // audio del momento
                        complemento = MediaPlayer.create(this,R.raw.parque);
                        complemento.start();
                    }

                    break;
                }
            case  R.id.BtnCama:
                if (ibegale.isEnabled() || ibnino.isEnabled() || ibperro.isEnabled()
                        || ibsaltar.isEnabled() || ibdormir.isEnabled() || ibcomer.isEnabled() ){
                    Toast.makeText(MainActivity.
                            this,"Seleccione un elemento del primer y segundo renglon",Toast.LENGTH_SHORT).show();

                }else{
                    if (reprod == null || !reprod.isPlaying()){
                        // Asignación de la frase
                        complement="en la cama";
                        frase.startAnimation(animacion);
                        frase.setText(subject +" "+verb+" "+complement);
                        // Deshabilta los botones
                        ibpark.setEnabled(false);
                        ibcama.setEnabled(false);
                        ibcasa.setEnabled(false);
                        // audio del momento
                        complemento = MediaPlayer.create(this,R.raw.cama);
                        complemento.start();
                    }

                    break;
                }
            case  R.id.BtnCasa:
                if (ibegale.isEnabled() || ibnino.isEnabled() || ibperro.isEnabled()
                        || ibsaltar.isEnabled() || ibdormir.isEnabled() || ibcomer.isEnabled() ){
                    Toast.makeText(MainActivity.
                            this,"Seleccione un elemento del primer y segundo renglon",Toast.LENGTH_SHORT).show();

                }else{
                    if (reprod == null || !reprod.isPlaying()){
                        // Asignación de la frase
                        complement="en la casa";
                        frase.startAnimation(animacion);
                        frase.setText(subject +" "+verb+" "+complement);
                        // Deshabilta los botones
                        ibpark.setEnabled(false);
                        ibcama.setEnabled(false);
                        ibcasa.setEnabled(false);
                        // audio del momento
                        complemento = MediaPlayer.create(this,R.raw.casa);
                        complemento.start();
                    }

                    break;
                }

        }
    }
    public  void salir(View v) {

        exit(0);
    }
public void Repetir(View view) throws InterruptedException {

    if(sujeto !=null && verbo != null &&complemento !=null){
        ArrayList<MediaPlayer> song = new ArrayList<>();
        song.add(sujeto);
        song.add(verbo);
        song.add(complemento);
    for(int i=0; i<song.size(); i++){
        if(!song.get(i).isLooping()){
        song.get(i).start();}
        sleep(960);
    }
    }else{
        Toast.makeText(MainActivity.
                this,"Elemento vacio",Toast.LENGTH_SHORT).show();
    }
}
    public  void Restart(View view){
        frase.setText("              _____ FRASE _____");
        // sujeto
        ibegale.setEnabled(true);
        ibnino.setEnabled(true);
        ibperro.setEnabled(true);
        // verb
        ibsaltar.setEnabled(true);
        ibdormir.setEnabled(true);
        ibcomer.setEnabled(true);
        // complemento
        ibpark.setEnabled(true);
        ibcama.setEnabled(true);
        ibcasa.setEnabled(true);

       verbo =null;
        sujeto=null;
        complemento=null;
    }
}
