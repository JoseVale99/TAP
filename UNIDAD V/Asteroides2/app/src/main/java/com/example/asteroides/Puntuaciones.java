package com.example.asteroides;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

public class Puntuaciones extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);

        setListAdapter(new MiAdaptador(this,
                MainActivity.almacen.listaPuntuaciones(10)));
    }
   @Override
    protected void onListItemClick(ListView listView,View view, int pos, long id){
        super.onListItemClick(listView,view,pos,id);
        Object o = getListAdapter().getItem(pos);
       Toast.makeText(this,"Seleccion : "+Integer.toString(pos)+" - "+o.toString(),
               Toast.LENGTH_LONG).show();
    }


}
