package com.jf.dmcal.jewelfighter;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by D-Bro on 5/20/2018.
 */

public class MainThread extends Thread {
    public static final int maxFPS = 60;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public void setRunning(boolean running){
        this.running=running;
    }

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        long startTime;
        long timeMS = 1000 / maxFPS;
        long waitTime;
        long FPScount = 0;
        long totaltime = 0;
        long targetTime = 1000 / maxFPS;
        while (running) {
            startTime = System.nanoTime();
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if(canvas != null){
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){
                    }
                }
            }
            timeMS=(System.nanoTime()-startTime)/1000000;
            waitTime=targetTime-timeMS;
            try {
                if (waitTime>0){
                    this.sleep(waitTime);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            totaltime+= System.nanoTime() - startTime;
            FPScount++;
            if(FPScount==maxFPS){
                averageFPS=1000/((totaltime/FPScount)/1000000);
                FPScount=0;
                totaltime=0;
                System.out.println(averageFPS);
            }
        }
    }
}

