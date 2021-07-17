package com.example.a754e37cartelera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VistaDetalle extends AppCompatActivity {


    //referencias a las vistas
    private TextView mtitulo,mresena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistad_detalle);

        //se instancian las vistas
        mtitulo=findViewById(R.id.titulo);
        mresena=findViewById(R.id.resena);
        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();
        String t=bundle.getString("TITULO");
        mtitulo.setText(t);

        mresena.setText(bundle.getString("RESEÑA"));
    }
}
