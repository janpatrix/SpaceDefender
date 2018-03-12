package com.example.janpatrix.spacedefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by janpatrix on 12.03.2018.
 */

public class PlayerShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;

    public PlayerShip(Context context) {
        x = 50;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.spaceship);
        bitmap = Bitmap.createScaledBitmap(
                bitmap, bitmap.getWidth()*3, bitmap.getHeight()*3, false);
    }

    public void update(){
        x++;
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
}
