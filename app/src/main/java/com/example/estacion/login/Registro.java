package com.example.estacion.login;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    Button registrar, cancelar;
    EditText nombres, apellidos, usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registrar = (Button) findViewById(R.id.BRRegistrar);
        registrar.setOnClickListener(this);
        cancelar = (Button) findViewById(R.id.BRCancelar);
        cancelar.setOnClickListener(this);
        nombres =(EditText) findViewById(R.id.ETNombres);
        apellidos = (EditText) findViewById(R.id.ETApellidos);
        usuario = (EditText) findViewById(R.id.ETUsuario);
        contraseña = (EditText) findViewById(R.id.ETContraseña);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(registrar)){
            SQLiteDatabase db= GobalTools.baseDeDatos.getWritableDatabase();
            String sqlinsert = "INSERT INTO usuarios (user, pass) VALUES ('"+
                    usuario.getText().toString()+"','"+contraseña.getText().toString()+"')";

            if(db !=null){

                try{
                    db.execSQL(sqlinsert);
                }catch (SQLiteConstraintException e){
                    Toast.makeText(this, "Este usuario ya existe en la BD",Toast.LENGTH_LONG).show();
                }
            }

            db.close();
            Intent i= new Intent(this, Principal.class);
            startActivity(i);
            Toast.makeText(this,"Usuario Registrado Correctamente", Toast.LENGTH_LONG).show();

        }else if(v.equals(cancelar)){
            Intent i= new Intent(this, Principal.class);
            startActivity(i);
        }


    }
}
