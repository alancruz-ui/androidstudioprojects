package com.example.a754e41registrodeparticipantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListaGeneral extends AppCompatActivity {
        //11.c.ii referencias a las vistas
    private TextView mListado, mTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_general);

        //11.c.ii
        mListado=findViewById(R.id.lista);
        mTotal=findViewById(R.id.total);
        //11.c.iii
        Intent intent= getIntent();
        String cad= intent.getStringExtra("LISTA");
        double total= intent.getDoubleExtra("TOTAL",0);
        //11.c.iv se depositan los valores en las vistas
        mListado.setText(cad);
        mTotal.setText("total pagado $ "+ total);
    }
}
