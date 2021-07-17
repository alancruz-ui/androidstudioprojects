package com.example.a754e33tablademultiplicar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText mvalor;
    private TextView mtabla;
    private ConstraintLayout mfondo;
    private int tamanotexto=20;
    private int limitesuperior=50;
    private int limiteinferior=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        mvalor=findViewById(R.id.valor);
        mtabla=findViewById(R.id.tabla);
        mfondo=findViewById(R.id.fondo);

    }

    public void tabular(View v){
        String c= mvalor.getText().toString();
        int n= Integer.parseInt(c);
        String cad="";
        for(int i=1;i<=10;i++){

            cad+= n + "x" + i +"="+ (n*i)+ "\n";
        }
        mtabla.setText(cad);
        ocultarTeclado(mvalor);


    }
    private  void ocultarTeclado(EditText et){
        InputMethodManager imm=(InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(),0);
    }
    public void limpiar(View view){
    mvalor.setText("");
    mtabla.setText("");

    }
    public void funcionmenos(View v){
        if(tamanotexto>limiteinferior){
            tamanotexto-=5;
            mtabla.setTextSize(tamanotexto);

        }



    }
    public void funcionmas(View v){
        if(tamanotexto<limitesuperior){
            tamanotexto+=5;
            mtabla.setTextSize(tamanotexto);

        }
    }
    public void ejecutar(View v){
        Intent intento=new Intent(this, activity2.class);
        startActivity(intento);

    }
    public void ejecutarestilos(View v){
        Intent intento=new Intent(this, activity3.class);
        startActivity(intento);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id=item.getItemId();

        if(id==R.id.acerca){
            ejecutar(null);
        }


        return super.onOptionsItemSelected(item);
    }

}
