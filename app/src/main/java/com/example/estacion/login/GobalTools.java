package com.example.estacion.login;

import android.widget.TextView;

/**
 * Created by ESTACION on 30/06/2017.
 */

public class GobalTools {

    public static UsuariosDB baseDeDatos;
    public static final int dbVersion = 2;
    public static Main principal;
    public static Cronometro miCronometro;

    public static void actualizarCronoView(int mins, int secs){

        principal.getCrono().setText(mins+":"+secs);

    }

}
