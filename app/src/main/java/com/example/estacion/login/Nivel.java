package com.example.estacion.login;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class Nivel extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor acelerometro;
    private long ultimaActualizacion;

    private Esfera bolita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ultimaActualizacion = System.currentTimeMillis();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; //ancho absoluto en pixels
        int height = metrics.heightPixels;//alto absoluto en pixels

        bolita = new Esfera(this, width/40, width/40, width/40);
        setContentView(bolita);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected  void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            bolita.move((int) -event.values[0],(int)event.values[1]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
