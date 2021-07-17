package com.example.a754e37cartelera;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class miAdaptador extends BaseAdapter {

    // referencias a utilizar
    private Context contexto;
    private ListaPeliculas catalogo;
    //OTRAS REFERENCIA
    private static LayoutInflater inflater;
    //constructor

    public miAdaptador(Context contexto, ListaPeliculas catalogo) {
        this.contexto = contexto;
        this.catalogo = catalogo;

        //se crea una instancia de inflater
        inflater=(LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final pelicula peli=(pelicula) catalogo.get(position);

        view= inflater.inflate(R.layout.mi_layout,null);
        //instancia cada vista de mi_layout
        ImageView mImagen= view.findViewById(R.id.imageView);
        TextView mTitulo= view.findViewById(R.id.tituloPelicula);
        TextView mDirector= view.findViewById(R.id.director);
        TextView mDuracion= view.findViewById(R.id.duracion);
        RatingBar mCalificacion= view.findViewById(R.id.ratingBar);
        //vaciamos los datos del objeto peli en cada una de las vistas
        mImagen.setImageResource(peli.refimagen);
        mTitulo.setText(peli.titulo);
        mDirector.setText(peli.director);
        mDuracion.setText(peli.duracion);
        mCalificacion.setProgress(peli.calificacion);
        //listener para detectar un click sobre la imagen
        mImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen=new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMAGEN",peli.getRefimagen());
                contexto.startActivity(visorImagen);
            }
        });

        return view;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return super.areAllItemsEnabled();
    }

    @Override
    public int getCount() {
        return catalogo.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
