package com.example.calculoimporteconsumo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityCica extends AppCompatActivity {
    private EditText lecAnt; //Lectura anterior
    private EditText lecAct;// lectura actual
    private TextView consumo; // consumo
    private TextView importe; // importe
    // Variables para los calculos correspondientes
    private final double V_IMPUESTO = 10; // 10%
    private final double V_MANTENIMIENTO = 15.0; // $15
    private final  int PRECIO_MT3 = 7; //PRECIO EN $ POR M CÚBICO
    private double v_Importe;
    private double v_Consumo;
    private double v_Impuesto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cica);
        lecAnt = (EditText) findViewById(R.id.lecturaAnt);
        lecAct = (EditText) findViewById(R.id.lecturaAct);
        consumo = (TextView) findViewById(R.id.consumo_1);
        importe = (TextView) findViewById(R.id.importe_1);
    }
public  void Calculo(View view){
        String cadena_1 = lecAnt.getText().toString();
    String cadena_2 = lecAct.getText().toString();
    if (cadena_1.isEmpty() || cadena_2.isEmpty()){
        Toast.makeText(this, "Valor de las lecturas NO deben estar vacios", Toast.LENGTH_SHORT).show();
    }
    else {
        if (isNumeric(cadena_1) == false || isNumeric(cadena_2) == false) {
            Toast.makeText(this, "Ingrese solo numeros", Toast.LENGTH_SHORT).show();
        } else {
            // operacionespara calcular el importe a pagar
            int consumoMTS3 = Integer.parseInt(lecAct.getText().toString()) - Integer.parseInt(lecAnt.getText().toString());

            v_Consumo = consumoMTS3 * PRECIO_MT3;
            v_Impuesto = v_Consumo / V_IMPUESTO;
            v_Importe = v_Consumo + v_Impuesto + V_MANTENIMIENTO;
            if (Integer.parseInt(lecAct.getText().toString()) < Integer.parseInt(lecAnt.getText().toString())) {
                Toast.makeText(this, "valor de la lectura actual debe ser >= Valor de la lectura anterior ", Toast.LENGTH_SHORT).show();
            } else {
                consumo.setText("  " + consumoMTS3);
                importe.setText("$ " + v_Importe + " MXN");
            }
        }
    }
}
public void Ver_Detalle(View view){
        String detalle =  String.format("%s  %15s %6.2f \n%s %16s %6.2f \n%s %6.5s %6.2f \n%s %9s %6.2f",
                "Consumo","$", v_Consumo,
                "Impuesto","$", v_Impuesto,
                "Mantenimiento","$", V_MANTENIMIENTO,
                "Importe total ","$",v_Importe);
        Toast mensaje_Detalle = Toast.makeText(getApplicationContext(),detalle,Toast.LENGTH_LONG);

        mensaje_Detalle.show();


}
public void Delete(View view){
        lecAnt.setText("0");
        lecAct.setText("0");
        consumo.setText("");
        importe.setText("___");
}
    private  boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }




}
