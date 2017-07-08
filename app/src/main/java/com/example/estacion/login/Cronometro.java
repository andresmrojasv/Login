package com.example.estacion.login;

import android.os.AsyncTask;

/**
 * Created by ESTACION on 05/07/2017.
 * Comentario de prueba de Pablo
 */

public class Cronometro extends AsyncTask <Void,Void,Integer>{

    private int minutos=0;
    private int segundos=0;
    private int totalSgs=0;

    private boolean activo = false;

    @Override
    protected void onPreExecute() {
        activo = true;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        while(isActivo()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            totalSgs++;
            minutos= totalSgs/60;
            segundos= totalSgs%60;
            GobalTools.principal.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    GobalTools.actualizarCronoView(minutos,segundos);

                }
            });

            }
        return totalSgs;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getTotalSgs() {
        return totalSgs;
    }

    public void setTotalSgs(int totalSgs) {
        this.totalSgs = totalSgs;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
