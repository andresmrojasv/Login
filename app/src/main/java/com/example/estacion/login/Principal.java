package com.example.estacion.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    EditText usuario,contraseña;
    Button login,registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        GobalTools.baseDeDatos = new UsuariosDB(this, "BDUsuarios", null,GobalTools.dbVersion);
        usuario = (EditText) findViewById(R.id.ETUsuario);
        contraseña = (EditText) findViewById(R.id.ETContraseña);
        login = (Button) findViewById(R.id.BIniciarSesion);
        login.setOnClickListener(this);
        registrarse =(Button) findViewById(R.id.BRegistrarse);
        registrarse.setOnClickListener(this);

    }

    public void metodo() throws NullPointerException{

    }

    @Override
    public void onClick(View v) {

        if(v.equals(registrarse)){
            Intent i= new Intent(this, Registro.class);
            startActivity(i);


        }

        if(v.equals(login)){

            SQLiteDatabase db = GobalTools.baseDeDatos.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT user, pass FROM usuarios WHERE user =?", new String[]{usuario.getText().toString()});

            if(cursor.moveToFirst()) {
                String passG = cursor.getString(1);
                if(passG.equals(contraseña.getText().toString())) {
                    Intent i = new Intent(this, Main.class);
                    i.putExtra("user", usuario.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Este usuario no esta registrado",Toast.LENGTH_LONG).show();
            }
            contraseña.setText("");

            cursor.close();
            db.close();
        }

    }
}
