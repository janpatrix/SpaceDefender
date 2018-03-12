package com.example.janpatrix.spacedefender;

import android.content.Context;
import android.view.SurfaceView;

/**
 * Created by janpatrix on 12.03.2018.
 */

public class SDView extends SurfaceView implements Runnable {

    volatile boolean playing;
    private Thread gameThread = null;

    public SDView(Context context) {
        super(context);
    }

    @Override
    public void run() {
        while(playing){
            update();
            draw();
            control();
        }
    }

    private void update(){

    }

    private void draw(){

    }

    private void control(){

    }

    public void pause(){
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }







}
