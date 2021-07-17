package com.example.a754e37cartelera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // referencias al listview
    private ListView mListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // instanciamos la vista
        mListado=findViewById(R.id.listado);
        final ListaPeliculas listaPeliculas= new ListaPeliculas(0);
        //creamos el adaptador y lo sociamos al list view
        miAdaptador adaptador=new miAdaptador(this, listaPeliculas);
        mListado.setAdapter(adaptador);
        //listener para enviar a vista de detalle
        mListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //se extraen los datos de la pelicula(titulo y reseña)
                pelicula peliculas=(pelicula) listaPeliculas.get(position);
                //se crea un intent y se envian los datos
                Intent vistadetalles=  new Intent(view.getContext(), VistaDetalle.class);
                vistadetalles.putExtra("TITULO", peliculas.getTitulo());
                vistadetalles.putExtra("RESEÑA", peliculas.getReseña());
                startActivity(vistadetalles);
            }
        });
    }
}
