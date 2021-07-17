package com.example.a42registrocontrasea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  EditText mcontraseña;
    private Button mBtnVer;
    private TextView mResultado;
    private Switch mswitch1,mswitch2,mswitch3,mswitch4;
    private ConstraintLayout mFondo;
  // referencias a prefeerencias
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    // referencias a valores actuales de los switch y de color de fondo
    boolean valorSwitch1,valorSwitch2,valorSwitch3,valorSwitch4;
    int colorFondo;
    //11b referencias a las opciones del menu
    private MenuItem mOpceleste;
    private MenuItem mOpnaranja;
    private MenuItem mOpverde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        //4.b se instancian las vistas
        mFondo=findViewById(R.id.fondo);
        mcontraseña=findViewById(R.id.contraseña);
        mBtnVer=findViewById(R.id.btnVer);
        mswitch1=findViewById(R.id.switch1);
        mswitch2=findViewById(R.id.switch2);
        mswitch3=findViewById(R.id.switch3);
        mswitch4=findViewById(R.id.switch4);
        mResultado=findViewById(R.id.resultado);

        //7 valores de configuracion
        //7.a valores por default
        int defaultcolor= Color.parseColor("#FFFFFF");
        boolean defaultSwitch1=false;
        boolean defaultSwitch2=false;
        boolean defaultSwitch3=false;
        boolean defaultSwitch4=false;
        //7.b se extraen los valores guardados
        pref= getPreferences(MODE_PRIVATE);
        colorFondo= pref.getInt("COLORFONDO", defaultcolor);
        valorSwitch1= pref.getBoolean("SWITCH1", defaultSwitch1);
        valorSwitch2= pref.getBoolean("SWITCH2", defaultSwitch2);
        valorSwitch3= pref.getBoolean("SWITCH3", defaultSwitch3);
        valorSwitch4= pref.getBoolean("SWITCH4", defaultSwitch4);
        // 7.c se aplican los valores descargados
        mFondo.setBackgroundColor(colorFondo);
        mswitch1.setChecked(valorSwitch1);
        mswitch2.setChecked(valorSwitch2);
        mswitch3.setChecked(valorSwitch3);
        mswitch4.setChecked(valorSwitch4);








    }
    //inflado del menu para los colores


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        //se crean las instancias de las opciones
        mOpceleste=menu.findItem(R.id.opColorCeleste);
        mOpnaranja=menu.findItem(R.id.opColornaranja);
        mOpverde=menu.findItem(R.id.opColorverde);
        return super.onCreateOptionsMenu(menu);
    }
    //atender a las opciones del menu


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opColorCeleste:
                colorFondo= Color.parseColor("#4fc3f7");
                mFondo.setBackgroundColor(colorFondo);
                //se guarda el valor en preferencias
                pref=getPreferences(MODE_PRIVATE);
                editor=pref.edit();
                editor.putInt("COLORFONDO",colorFondo);
                editor.commit();
                break;
            case R.id.opColornaranja:
                colorFondo= Color.parseColor("#ff6e40");
                mFondo.setBackgroundColor(colorFondo);
                //se guarda el valor en preferencias
                pref=getPreferences(MODE_PRIVATE);
                editor=pref.edit();
                editor.putInt("COLORFONDO",colorFondo);
                editor.commit();
                break;
            case R.id.opColorverde:
                colorFondo= Color.parseColor("#4caf50");
                mFondo.setBackgroundColor(colorFondo);
                //se guarda el valor en preferencias
                pref=getPreferences(MODE_PRIVATE);
                editor=pref.edit();
                editor.putInt("COLORFONDO",colorFondo);
                editor.commit();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    //8. se crean las 4 funciones para los switches
    public void fnCambiar1(View v){
        valorSwitch1=!valorSwitch1;
       // mswitch1.setChecked(valorSwitch1);
        //se guarda el valor en preferencias
        pref= getPreferences(MODE_PRIVATE);
        editor= pref.edit();
        editor.putBoolean("SWITCH1", valorSwitch1);
        editor.commit();


    }
    public void fnCambiar2(View v){
        valorSwitch2=!valorSwitch2;
        // mswitch1.setChecked(valorSwitch1);
        //se guarda el valor en preferencias
        pref= getPreferences(MODE_PRIVATE);
        editor= pref.edit();
        editor.putBoolean("SWITCH12", valorSwitch2);
        editor.commit();


    }
    public void fnCambiar3(View v){
        valorSwitch3=!valorSwitch3;
        // mswitch1.setChecked(valorSwitch1);
        //se guarda el valor en preferencias
        pref= getPreferences(MODE_PRIVATE);
        editor= pref.edit();
        editor.putBoolean("SWITCH3", valorSwitch3);
        editor.commit();


    }
    public void fnCambiar4(View v){
        valorSwitch4=!valorSwitch4;
        // mswitch1.setChecked(valorSwitch1);
        //se guarda el valor en preferencias
        pref= getPreferences(MODE_PRIVATE);
        editor= pref.edit();
        editor.putBoolean("SWITCH4", valorSwitch4);
        editor.commit();


    }
    //8 funcion para ver o ocultar el texto
    public void fnVerOcultar(View v){
    if(mcontraseña.getInputType()==129){//esta oculto
        mcontraseña.setInputType(145);//visible
        mBtnVer.setBackgroundResource(R.drawable.nover);

    }else{

        mcontraseña.setInputType(129);
        mBtnVer.setBackgroundResource(R.drawable.ojo);
    }

    }
    //verificacion del texto
    public void fnVerificar(View v){
        String contraseña=mcontraseña.getText().toString();
        if(cumpleCond1(contraseña)&&cumpleCond2(contraseña)&&cumpleCond3(contraseña)&&cumpleCond4(contraseña)){
            mResultado.setText("Texto Correcto");
            mResultado.setTextColor(Color.BLUE);

        }else{
            mResultado.setText("Texto Incorrecto");
            mResultado.setTextColor(Color.RED);
        }

    }
    //almenos una mayuscula
    private boolean cumpleCond1( String contraseña){
        boolean resultado= true;
        if(valorSwitch1) {
            for(int i=0;i<contraseña.length(); i++){
                if (Character.isUpperCase(contraseña.charAt(i))) {
                     resultado=true;
                }else{
                    resultado=false;                }
            }


        }
        return resultado;
    }
    //almenos 2 digitos
    private boolean cumpleCond2( String contraseña){
        boolean resultado= true;
        char array_contraseña []= contraseña.toCharArray();
        String n="";
        if(valorSwitch2) {
            for (int i = 0; i < array_contraseña.length; i++) {
                if (Character.isDigit(array_contraseña[i])) {
                    n += array_contraseña[i];
                }


            }
            if(n.length()<2)
                resultado=false;

        }
        return resultado;
    }
    //almenos uno de estos simbolo #,$,*,_
    private boolean cumpleCond3( String contraseña){
        boolean resultado= true;
        if(valorSwitch3){
            if(contraseña.contains("$") ||  contraseña.contains("#") || contraseña.contains("*")|| contraseña.contains("_"))
                resultado= true;
            else{
                resultado=false;
            }
        }
        return resultado;
    }
    //almenos una 8 caracteres
    private boolean cumpleCond4( String contraseña){
        boolean resultado= true;
        if(valorSwitch4){
            if(contraseña.length()<8)

            resultado=false;

        }
        return resultado;
    }
}

