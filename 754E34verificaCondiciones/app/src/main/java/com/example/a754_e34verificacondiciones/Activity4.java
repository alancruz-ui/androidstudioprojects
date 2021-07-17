package com.example.a754_e34verificacondiciones;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {
     String[] arrayacercade;
    TextView mtitulo,mcontenido;
    Button simpleDialogoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        mtitulo=findViewById(R.id.titulo);
        mcontenido=findViewById(R.id.contenido);
        simpleDialogoId=findViewById(R.id.simpleDialogoId);
        arrayacercade=getResources().getStringArray(R.array.Acercade);
        mtitulo.setText(arrayacercade[0]);
        String cad="";
        for(int i=1;i<arrayacercade.length;i++){
            cad+=arrayacercade[i]+"\n";
        }
        mcontenido.setText(cad);

        simpleDialogoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(Activity4.this);//creamos un objetos de tipo alertdialog
                builder.setIcon(R.drawable.senales).//asignamos un iconono mediante el metodo seticon y un mensaje
                setTitle("AlertDialog").setMessage("Realmente deseas salir?").setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     finishAffinity();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity4.this, "Accion Cancelada", Toast.LENGTH_SHORT).show();
                    }
                });


                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }
    }

