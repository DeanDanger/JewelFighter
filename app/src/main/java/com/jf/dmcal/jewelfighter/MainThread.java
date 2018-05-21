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

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
        Super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run(){
        long startTime;
        long timeMS = 1000/maxFPS;
        long wait;
        long FPScount = 0;
        long totaltime = 0;
        long targetTime=1000/maxFPS;
    }
}
