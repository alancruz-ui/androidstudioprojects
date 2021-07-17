package com.example.a754e41registrodeparticipantes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.a754e41registrodeparticipantes.AdminBDEventos.*;

public class MainActivity extends AppCompatActivity {
 // 3.a referencias a las vistas
    private EditText mclave, mnombre, minstitucion, mcorreo, mcantidad;
    //5.f se agregan referencias para los botones
    private Button mBtnAgregar,mBtnModificar , mBtnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 3.b se instancian las vistas
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        mclave=findViewById(R.id.clave);
        mnombre=findViewById(R.id.nombre);
        minstitucion=findViewById(R.id.institucion);
        mcorreo=findViewById(R.id.Email);
        mcantidad=findViewById(R.id.cantidad);
        //5.f se instancian los botones
        mBtnAgregar=findViewById(R.id.btnAgregar);
        mBtnModificar=findViewById(R.id.btnModificar);

        mBtnEliminar= findViewById(R.id.button4);

        limpiarCampos();
    }

    public void fn_Agregar(View v){

        //4.a se instancia y se activa la base de datos
        AdminBDEventos adminBDEventos= new AdminBDEventos(this);
        SQLiteDatabase bDatos = adminBDEventos.getWritableDatabase();
        //4.b se obtienen los datos del usuario
        String cad_clave=mclave.getText().toString();
        String nombre=mnombre.getText().toString();
        String institucion=minstitucion.getText().toString();
        String correo=mcorreo.getText().toString();
        String cad_cantidad=mcantidad.getText().toString();

        if(!cad_clave.isEmpty() && !nombre.isEmpty() && !institucion.isEmpty() && !correo.isEmpty()&& !cad_cantidad.isEmpty())
        {
          // se convierten los valores que deben ser numericos
            int clave= Integer.parseInt(cad_clave);
            double cantidad= Double.parseDouble(cad_cantidad);
            //se prepara el content values
            ContentValues registro=new ContentValues();
            registro.put(CAMPO1,clave);
            registro.put(CAMPO2,nombre);
            registro.put(CAMPO3,institucion);
            registro.put(CAMPO4,correo);
            registro.put(CAMPO5,cantidad);
            //se crea el registro y se insertan los valores
            bDatos.insert(NOMBRE_TABLA,null,registro);
            Toast.makeText(this,"participante"+clave+"Agregado",Toast.LENGTH_SHORT).show();
            //4.d se vacian las vistas y se cierra la base de datos
           mclave.setText("");
           mnombre.setText("");
           minstitucion.setText("");
           mcorreo.setText("");
           mcantidad.setText("");

           bDatos.close();

        }
        else
            Toast.makeText(this, "debe llenar todos los campos", Toast.LENGTH_SHORT).show();


    }

    //5
    public void fn_cosultar(View v){

        //5.a se instancia y se habre la base de datos para consultas
        AdminBDEventos adminBDEventos= new AdminBDEventos(this);
        SQLiteDatabase bDatos= adminBDEventos.getReadableDatabase();

        String cad_clave=mclave.getText().toString();
        if(cad_clave.isEmpty())

            Toast.makeText(this,"escriba una clave",Toast.LENGTH_SHORT).show();

            else{
                //5.b preparamos el query para la consulta
            String queryConsulta="select * from " + NOMBRE_TABLA + " where " + CAMPO1 + "=" + cad_clave;
            //select * from participantes where clave=?

           Cursor cursor= bDatos.rawQuery(queryConsulta,null);
           //5.c se extraen los datos del cursor y se colocan en las vistas
            if(cursor.moveToFirst()){
                mnombre.setText(cursor.getString(1));
                minstitucion.setText(cursor.getString(2));
                mcorreo.setText(cursor.getString(3));
                mcantidad.setText(Double.toString(cursor.getDouble(4)));

                // 5.e se deshabilita el campo clave
                mclave.setEnabled(false);
                // 5.f se deshabilita el boton agregar y se habilita el boton modificar y eliminar
                mBtnAgregar.setEnabled(false);
                mBtnModificar.setEnabled(true);
                mBtnEliminar.setEnabled(true);


            }
            else {
                Toast.makeText(this, "no existe la clave" + cad_clave, Toast.LENGTH_SHORT).show();
                limpiarCampos();

            }

        }
            bDatos.close();

    }
    // 6 funciones para limpiar campos
    public void fn_limpiarCampos(View v){
        limpiarCampos();

    }
    private void limpiarCampos(){
        mclave.setText("");
        mnombre.setText("");
        minstitucion.setText("");
        mcorreo.setText("");
        mcantidad.setText("");

        // 6.b se habilita el campo clave
        mclave.setEnabled(true);
        // 6.c se habilita el boton agregar y se deshabilita el boton modificar y eliminar
        mBtnAgregar.setEnabled(true);
        mBtnModificar.setEnabled(false);
        mBtnEliminar.setEnabled(false);
    }
    //modificacion de registros
    public void fn_modificar(View v){
        final AlertDialog.Builder diagolo= new AlertDialog.Builder(this);
        diagolo.setTitle("Modifica los Datos?");
        diagolo.setMessage("Confirme si realmente desea modificar");
        diagolo.setCancelable(false);

        diagolo.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                modificar();
            }
        });

        diagolo.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });
        diagolo.show();
    }
        private void modificar(){
        //8.a se instancia la base de datos y se abre para escritura
            AdminBDEventos adminBDEventos=new AdminBDEventos(this);
            SQLiteDatabase bDatos=adminBDEventos.getWritableDatabase();
            //8.b se colocan los valores en el content values
            ContentValues valores= new ContentValues();
            valores.put(CAMPO2, mnombre.getText().toString());
            valores.put(CAMPO3, minstitucion.getText().toString());
            valores.put(CAMPO4, mcorreo.getText().toString());
            valores.put(CAMPO5, Double.parseDouble(mcantidad.getText().toString()));
            //8.c
            int clave= Integer.parseInt(mclave.getText().toString());
            bDatos.update(NOMBRE_TABLA, valores, CAMPO1 + " = "+ clave, null);
            limpiarCampos();
            bDatos.close();
            Toast.makeText(this,"registro modificado", Toast.LENGTH_SHORT).show();

        }
        //9
        public void fn_eliminar(View v){
            final AlertDialog.Builder diagolo= new AlertDialog.Builder(this);
            diagolo.setTitle("Elimine los Datos?");
            diagolo.setMessage("Confirme si realmente desea eliminar");
            diagolo.setCancelable(false);

            diagolo.setPositiveButton("si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    eliminar();
                }
            });

            diagolo.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            diagolo.show();

        }
        //10 se realiza eliminacion del registro
        private void eliminar(){
            // se instancia la base de datos y se abre para escritura
            AdminBDEventos adminBDEventos=new AdminBDEventos(this);
            SQLiteDatabase bDatos=adminBDEventos.getWritableDatabase();
            // se realiza la eliminacion del registro
            int clave= Integer.parseInt(mclave.getText().toString());

            bDatos.delete(NOMBRE_TABLA,CAMPO1 + " = "+ clave ,null);
            Toast.makeText(this, "Registro eliminado", Toast.LENGTH_LONG).show();
            limpiarCampos();
            bDatos.close();

        }
        // funcion para ver las vista
    public void  fn_verLista(View v){
        // 11.b preparamos la cadena de la lista y el total
        String cad="";
        double total=0;
        // 11.bii se abre la base de datos para lectura
        AdminBDEventos adminBDEventos= new AdminBDEventos(this);
        SQLiteDatabase bDatos= adminBDEventos.getReadableDatabase();
        //11.b.iii accedemos a la tabla participantes para extraer su contenido
        String query="SELECT * FROM " + NOMBRE_TABLA;
        Cursor cursor=bDatos.rawQuery( query, null);
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
            //se obtiene la clave , el nombre y la cantidad
                int clave= cursor.getInt(0);
                String nombre=cursor.getString(1);
                double cantidad=cursor.getDouble(4);

                //creamos un nuevo renglon en cad
                cad+=(clave +"  " + nombre + "  "+ cantidad + "\n");

                //sumamos al total
                total+=cantidad;

            }

                //11.b.iv se prepara en intent
            Intent listaGeneral= new Intent(this, ListaGeneral.class);
            listaGeneral.putExtra("LISTA", cad);
            listaGeneral.putExtra("TOTAL",total);
            startActivity(listaGeneral);
        }else{
            Toast.makeText(this,"no hay participantes registrados", Toast.LENGTH_SHORT).show();
        }

    }
}
