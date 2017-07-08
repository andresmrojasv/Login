package com.example.estacion.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import static com.example.estacion.login.GobalTools.principal;

public class Main extends AppCompatActivity implements View.OnClickListener {

    TextView userLogged;
    Button salir, finalizar, niveles;
    private TextView crono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLogged=(TextView) findViewById(R.id.TVPMostrar);
        userLogged.setText(this.getIntent().getStringExtra("user"));
        salir = (Button) findViewById(R.id.BMSalir);
        salir.setOnClickListener(this);
        setCrono((TextView) findViewById(R.id.TVMCronometro));
        principal = this;
        finalizar = (Button) findViewById(R.id.BMFinalizar);
        finalizar.setOnClickListener(this);
        niveles = (Button) findViewById(R.id.BMNiveles);
        niveles.setOnClickListener(this);
        GobalTools.miCronometro = new Cronometro();
        GobalTools.miCronometro.execute();

    }

    @Override
    public void onClick(View v) {
        if(v.equals(salir)) {
            Intent i = new Intent(this, Principal.class);
            startActivity(i);
        }else if(v.equals(finalizar)) {
            GobalTools.miCronometro.setActivo(false);
        }else if(v.equals(niveles)) {
            Intent i = new Intent(this, Nivel.class);
            startActivity(i);

       }
    }

    public TextView getCrono() {
        return crono;
    }

    public void setCrono(TextView crono) {
        this.crono = crono;
    }
}
