package com.example.janpatrix.spacedefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.Random;

/**
 * Created by janpatrix on 12.03.2018.
 */

public class EnemyShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed = 1;

    private int maxX, minX;
    private int maxY, minY;

    public EnemyShip(Context context, Point point) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_round);
        bitmap = Bitmap.createScaledBitmap(
                bitmap, bitmap.getWidth(), bitmap.getHeight(), false);

        maxX = point.x;
        maxY = point.y;
        minX = 0;
        minY = 0;

        Random generator = new Random();
        speed = generator.nextInt(6) + 10;

        x = point.x;
        y = generator.nextInt(maxY) - bitmap.getHeight();
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

    public void update(int playerSpeed) {
        x -= playerSpeed;
        x -= speed;

        if (x < minX - bitmap.getWidth()){
            Random generator = new Random();
            speed = generator.nextInt(10) + 10;
            x = maxX;
            y = generator.nextInt(maxY) - bitmap.getHeight();
        }
    }
}
