package com.example.janpatrix.spacedefender;

import android.graphics.Point;

import java.util.Random;

/**
 * Created by janpatrix on 12.03.2018.
 */

public class SpaceDust {

    private int x, y;
    private int speed;

    private int minX, maxX, minY, maxY;

    public SpaceDust(Point point) {
        maxX = point.x;
        maxY = point.y;
        minX = 0;
        minY = 0;

        Random generator = new Random();
        speed = generator.nextInt(10);

        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
    }

    public void update (int playerSpeed){
        x -= playerSpeed;
        y -= speed;

        if (x < 0){
            x = maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(15);
        }
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
}
