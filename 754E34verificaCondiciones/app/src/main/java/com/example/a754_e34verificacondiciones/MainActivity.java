package com.example.a754_e34verificacondiciones;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView r1, r2;
    private EditText mnombre;
    //se declara el array para los mensajes
    String[] mensajes;
    //se configura el request code para el intent
    private static final int REQUEST_VERIFICAR = 1;// creamos una cosntante con valor 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnombre = findViewById(R.id.nombre);
        r1 = findViewById(R.id.resultado);
        r2 = findViewById(R.id.resultado2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        Resources res =getResources();
        mensajes = res.getStringArray(R.array.String_array_mesajes);

    }

    public void verificarporbotones(View v) {
        if (mnombre.getText().toString().equals("")) {//recuperamos el texto que tiene el edit text y comparamos si esta vacio si esta vacio
            Toast.makeText(this, "Escribe un nombre", Toast.LENGTH_SHORT).show();//si esta vacio mandamos este mensaje mediante un toast
        } else {
            int indice = (int) (Math.random() * mensajes.length);//si el edit text tiene una cadena de texto usamos el metodo mat.random y multiplicamos los numeros
            //aleartorios por la logintud del array y casteamos el resultado doble a entero almacenandolo en la variable indice
            Intent intento = new Intent(this, activity2.class);//hacemos un objeto intent que apunta a al activity2

            intento.putExtra("nombre", mnombre.getText().toString()); //añadimos datos extendidos a la intencion
            intento.putExtra("mensaje", mensajes[indice]); //añadimos datos extendidos a la extencion
            startActivityForResult(intento, REQUEST_VERIFICAR);// le pasamos como argumento el objeto de tipo intento y y la variable constante que es un numero de identificacion
        }

    }
    public void verificarporopciones(View v){
        if (mnombre.getText().toString().equals("")) {
            Toast.makeText(this, "Escribe un nombre", Toast.LENGTH_SHORT).show();
        } else {
            int indice = (int) (Math.random() * mensajes.length);
            Intent intento = new Intent(this, activity3.class);

            intento.putExtra("nombre", mnombre.getText().toString());
            intento.putExtra("mensaje", mensajes[indice]);
            startActivityForResult(intento, REQUEST_VERIFICAR);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VERIFICAR && resultCode== RESULT_OK) {
            String respuesta = data.getExtras().getString("respuesta");
            String cad = "La propuesta enviada a " + mnombre.getText().toString() + " fue:";
            r1.setText(cad);
            r2.setText(respuesta);
            if(respuesta.equals("ACEPTADA"))
                r2.setTextColor(Color.parseColor("#b2ff59"));
            else
                r2.setTextColor(Color.RED);

            mnombre.setText("");
        }

    }
    public void ejecutar(View v){
        Intent intento=new Intent(this, Activity4.class);
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
