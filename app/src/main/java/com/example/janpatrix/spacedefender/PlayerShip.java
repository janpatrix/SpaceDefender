package com.example.janpatrix.spacedefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by janpatrix on 12.03.2018.
 */

public class PlayerShip {

    private final int GRAVITY = -12;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    private Bitmap bitmap;
    private int x, y;
    private int minY, maxY;
    private int speed = 0;
    private boolean boosting;

    public PlayerShip(Context context, Point point) {
        x = 50;
        y = 50;
        speed = 1;
        boosting = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.spaceship);
        bitmap = Bitmap.createScaledBitmap(
                bitmap, bitmap.getWidth()*3, bitmap.getHeight()*3, false);
        minY = 0;
        maxY = point.y - bitmap.getHeight();
    }

    public void update(){
        if (boosting){
            speed += 2;
        } else {
            speed -= 5;
        }

        if (speed > MAX_SPEED){
            speed = MAX_SPEED;
        }

        if (speed < MIN_SPEED){
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;

        if (y <= minY){
            y = minY;
        }

        if (y > maxY){
            y = maxY;
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBoosting(){
        boosting = true;
    }

    public void stopBoosting(){
        boosting = false;
    }
}
