package com.example.a754_e34verificacondiciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class activity3 extends Activity {

    RadioButton maceptar,mrechazar;
    TextView mmnesaje;
    Button menviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        maceptar=findViewById(R.id.aceptar);
        mrechazar=findViewById(R.id.rechazar);
        mmnesaje=findViewById(R.id.mensaje);
        menviar=findViewById(R.id.enviar);

        Bundle extras=getIntent().getExtras();
        String nom=extras.getString("nombre");
        String msj=extras.getString("mensaje");
        mmnesaje.setText("hola,"+nom+":\n\n"+msj);

    }

    public void ejectar(View v){
        Intent intento= new Intent(this, MainActivity.class);
        startActivity(intento);
    }
    public void enviar(View v) {
        boolean estado=maceptar.isChecked();
        if (estado==true) {
            Intent intento = new Intent();
            intento.putExtra("respuesta", "ACEPTADA");
            setResult(RESULT_OK, intento);
            finish();
        }else{

            Intent intento=new Intent();
            intento.putExtra("respuesta", "RECHAZADA");
            setResult(RESULT_OK,intento);
            finish();
        }
    }


}
