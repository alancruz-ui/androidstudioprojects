package com.example.a754e37cartelera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class VisorImagen extends AppCompatActivity {

    private ImageView mimagencompleta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);
        mimagencompleta=findViewById(R.id.imagenCompleta);
        Intent intent= getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
           mimagencompleta.setImageResource(bundle.getInt("IMAGEN"));
    }
}
