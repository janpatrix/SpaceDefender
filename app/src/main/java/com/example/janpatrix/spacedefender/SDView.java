package com.example.janpatrix.spacedefender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by janpatrix on 12.03.2018.
 */

public class SDView extends SurfaceView implements Runnable {

    volatile boolean playing;
    private Thread gameThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder holder;

    //Game Objects
    private PlayerShip player;
    private EnemyShip enemy1;
    private EnemyShip enemy2;
    private EnemyShip enemy3;

    public SDView(Context context, Point point) {
        super(context);
        holder = getHolder();
        paint = new Paint();
        player = new PlayerShip(context, point);
        enemy1 = new EnemyShip(context, point);
        enemy2 = new EnemyShip(context, point);
        enemy3 = new EnemyShip(context, point);
    }

    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            control();
        }
    }

    private void update() {
        player.update();
        enemy1.update(player.getSpeed());
        enemy2.update(player.getSpeed());
        enemy3.update(player.getSpeed());
    }

    private void draw() {
        if (holder.getSurface().isValid()) {
            canvas = holder.lockCanvas();
            canvas.drawColor(Color.argb(255, 0, 0, 0));

            canvas.drawBitmap(player.getBitmap(), player.getX(), player.getY(), paint);
            canvas.drawBitmap(enemy1.getBitmap(), enemy1.getX(), enemy1.getY(), paint);
            canvas.drawBitmap(enemy2.getBitmap(), enemy2.getX(), enemy2.getY(), paint);
            canvas.drawBitmap(enemy3.getBitmap(), enemy3.getX(), enemy3.getY(), paint);

            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {

        }
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                player.stopBoosting();

                break;

            case MotionEvent.ACTION_DOWN:
                player.setBoosting();
                break;
        }
        return true;
    }
}
