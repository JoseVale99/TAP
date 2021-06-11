package com.example.myapplicationH;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
    }

    class MiThread extends Thread {
        private int n, res;

        public MiThread(int n){
            this.n = n;
        }

        @Override
        public void run(){
            res = factorial(n);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    salida.append(res + "\n");
                }
            });
        }
    }

    public void calcularOperacion(View view){
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + " ! = ");
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
    }

    public int factorial(int n){
        int res = 1;
        for(int i=1; i<=n; i++){
            res *=i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    class MiTarea extends AsyncTask< Integer, Integer, Integer >{
        private ProgressDialog progreso;

        @Override
        protected void onPreExecute(){
            progreso = new ProgressDialog(MainActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progreso.setMessage("Calculando...");
            progreso.setCancelable(false);
            progreso.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            MiTarea.this.cancel(true);
                        }
                    });
            progreso.setMax(100);
            progreso.setProgress(0);
            progreso.show();
        }

        protected Integer doInBackground(Integer... n){
            int res = 1;
            for(int i = 1; i <=n[0] && !isCancelled(); i++){
                res *= i;
                SystemClock.sleep(1000);
                publishProgress(i*100/n[0]);
            }
            return res;
        }

        protected void onProgressUpdate(Integer... porc){
            progreso.setProgress(porc[0]);
        }

        @Override
        protected void onCancelled(){
            salida.append("Cancelado\n");
        }

        protected void onPostExecute(Integer res){
            progreso.dismiss();
            salida.append(res + "\n");
        }

    }
}