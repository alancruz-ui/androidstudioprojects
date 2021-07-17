package com.example.a754e33tablademultiplicar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ejecutar(View v){

        Intent intento= new Intent(this,infoclase.class);
        startActivity(intento);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.acerca){
            return true;
        }
        if(id==R.id.configuracion){
           ejecutar(null);
        }
        return  super.onOptionsItemSelected(item);
    }
}
