package com.example.a754e33tablademultiplicar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class activity3 extends Activity {
      Button m1,m2,m3,m4;
      private ConstraintLayout mfondo;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity3);
       mfondo=findViewById(R.id.fondo);

    }

    public void verde(View v){
        Intent intento=new Intent(this,MainActivity.class);
        startActivity(intento);
        mfondo.setBackgroundColor(Color.GREEN);



    }
    public void cambiarcolor(View v){

        mfondo.setBackgroundColor(Color.GREEN);


    }
}
