package com.example.a754e36adaptadoresylistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //referencias listView
    private ListView mlistado;
    private ArrayAdapter<String> arrayadapter;
    //referencia al arreglo
    private ArrayList<String> productos;
    //referencia a text view
    private TextView mtextoseleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //poner icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        //se instancia la vista
        mlistado = findViewById(R.id.listado);
        //b2
        mtextoseleccion = findViewById(R.id.textoSeleccion);
        Typeface face = Typeface.createFromAsset(getAssets(), "fuentes/unbutton.ttf");
        mtextoseleccion.setTypeface(face);
        //cargamos los datos al array
        cargarDatos();

        //creamos el adaptador
        arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productos);
        //se asocia el adaptador a list view
        mlistado.setAdapter(arrayadapter);
        //b4 se crea y se registra un objeto listener
        mlistado.setOnItemClickListener(new procesaElementosSeleccionados());

    }

    private void cargarDatos() {
        //se instancia el array
        productos = new ArrayList<>();
        //SE CARGA CON DATOS
        productos.add("Manzanas");
        productos.add("Jamon");
        productos.add("Leche");
        productos.add("Azucar");
        productos.add("Atun");
        productos.add("Camote");
        productos.add("Cilantro");
        productos.add("Avena");
        productos.add("Mostaza");
        productos.add("sal");
        productos.add("Lechera");
        productos.add("Uva");
        productos.add("Melon");
        productos.add("Jitomate");
        productos.add("Pepino");
        productos.add("Repollo");

    }

    //b3 se crea una clase que implementa a onitemcliklistener
    public class procesaElementosSeleccionados implements AdapterView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            mtextoseleccion.setText(productos.get(i));
            mtextoseleccion.setText(mlistado.getItemAtPosition(i).toString());

        }
    }

    //c1- inflado del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //c2- manejo de las opciones del menu


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, productos);
                mlistado.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                break;
            case R.id.opcion2:
                arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, productos);
                mlistado.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                break;
            case R.id.opcion3:
                arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, productos);
                mlistado.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                break;
            case R.id.opcion4:
                arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, productos);
                mlistado.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                break;
            case R.id.opcion5:
                arrayadapter = new ArrayAdapter<>(this, R.layout.mi_layout, productos);
                mlistado.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                break;


        }
        mlistado.setAdapter(arrayadapter);
        return super.onOptionsItemSelected(item);
    }

    //d1- se procesan los elemntos que han sido seleccionados
    public void procesarSeleccionado(View v) {
        SparseBooleanArray sel = mlistado.getCheckedItemPositions();
        if (sel == null)
            Toast.makeText(this, "este layout no permite seleccion", Toast.LENGTH_SHORT).show();
        else {
            //se inicializa la cadena de texto
            StringBuffer cad = new StringBuffer("");
            for (int i = 0; i < sel.size(); i++) {
                if (sel.valueAt(i)) {
                    cad.append(mlistado.getItemAtPosition(sel.keyAt(i)));
                    cad.append(",");
                }
            }
            mtextoseleccion.setText(cad);
        }
    }
}
