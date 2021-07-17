package com.example.a754_e34verificacondiciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class activity2 extends Activity {
    //referencias  las vistas
    private TextView mmensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        mmensaje = findViewById(R.id.mensaje);
        //se recojen los datos enviados por main activity

        Bundle extras=getIntent().getExtras();//obtenemos el paquete adjunto de la intencion
        String nom=extras.getString("nombre");//extramos  los datos almacenados en el paquete
        String msj=extras.getString("mensaje");
        mmensaje.setText("hola,"+nom+":\n\n"+msj);//sacamos los datps almacenados por un textView =(mmensaje)

    }

    public void procesoAceptar(View v){
        Intent intento=new Intent();//creamos un objeto intento
        intento.putExtra("respuesta", "ACEPTADA");
        setResult(RESULT_OK,intento);
        finish();
    }
    public void procesarRechazar(View v){
        Intent intento=new Intent();
        intento.putExtra("respuesta", "RECHAZADA");
        setResult(RESULT_OK,intento);
        finish();
    }
}
