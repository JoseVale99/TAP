package com.example.masvistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText entrada;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//    entrada.findViewById(R.id.entrada);
    //salida.findViewById(R.id.salida);
    }

    public  void sePulsa(View view){
        Toast.makeText(this,"¡pulsado!",Toast.LENGTH_SHORT).show();



    }

}
