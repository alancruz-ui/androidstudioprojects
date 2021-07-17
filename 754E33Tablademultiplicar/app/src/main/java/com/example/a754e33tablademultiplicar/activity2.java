package com.example.a754e33tablademultiplicar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends Activity {
    String[] arrayacercade;
    TextView mtitulo,mcontenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        mtitulo=findViewById(R.id.titulo);
        mcontenido=findViewById(R.id.contenido);
        arrayacercade=getResources().getStringArray(R.array.Acercade);
        mtitulo.setText(arrayacercade[0]);
        String cad="";
        for(int i=1;i<arrayacercade.length;i++){
            cad+=arrayacercade[i]+"\n";
        }
        mcontenido.setText(cad);
    }


}




