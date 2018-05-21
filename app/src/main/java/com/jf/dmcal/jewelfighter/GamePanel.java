package com.jf.dmcal.jewelfighter;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.MainThread;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by D-Bro on 5/20/2018.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
    private MainThread Thread;

    public GamePanel(Context context){
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(...);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        threadt.start;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(true){
            try {
                thread.SetRunning(false);
                thread.join();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

    public void update(){}

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
    }
}
