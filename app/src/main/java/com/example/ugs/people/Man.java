package com.example.ugs.people;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class Man implements SensorEventListener {
    float x, y,vx;
    Bitmap sprite;
    Sensor accel;

    Man( float x, float y,float vx,Bitmap sprite){
        this.x = x;
        this.y = y;
        this.vx=vx;
        this.sprite = sprite;
        // MainActivity.sm.registerListener(this, MainActivity.accel.SENSOR_DELAY_GAME);
    }
int nFrame=1;
    Paint p = new Paint();
    void draw(Canvas canvas){

       Rect to = new Rect((int)x-54,(int)y-70,(int)x+54,(int)y+70);
        Rect frame = new Rect(0,0,nFrame*108,nFrame*108);
      // nFrame++;
      //  nFrame%=8;

        canvas.drawBitmap(sprite,frame, to, p);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        final float threshold =2;
        if(sensorEvent.values[0]>threshold) vx = 1;
        else if(sensorEvent.values[0]<-threshold) vx = -1;
        else vx= 0;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
