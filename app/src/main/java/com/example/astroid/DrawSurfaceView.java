package com.example.astroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by asafamir on 19/05/2017.
 */

public class DrawSurfaceView extends SurfaceView implements Runnable {
    int interval=50;//try to change it
    float dx=10;
    float dy=10;
    Context context;
    SurfaceHolder holder;
    boolean threadRunning = true;
    boolean isRunning = true;
    Bitmap bitmap;
    float x =100;
    float y =100;

    public DrawSurfaceView(Context context)
    {
        super(context);
        this.context = context;
        holder = getHolder();
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.astro4);
    }

    @Override
    public void run() {
        while (threadRunning)
        {
            if(isRunning)
            {
               if(!holder.getSurface().isValid())
                   continue;

                Canvas c = null;
                try
                {
                    c = this.getHolder().lockCanvas();//what with line meaning?
                    synchronized (this.getHolder()){
                        c.drawRGB(100,100,255);//Try pushing this line into a remark. what happened? you can change the color.
                        c.drawBitmap(bitmap,x,y,null);
                        automaticMove();
                    }
                    Thread.sleep(interval);
                }
                catch (Exception e)
                {

                }
                /*what is finally?
                */
                finally {
                    if(c!=null)
                    {
                        this.getHolder().unlockCanvasAndPost(c);//what this line meaning?
                    }
                }
            }
        }
    }

    /*
    how it works?
     */
    public void automaticMove()
    {
        x = x + dx;
        y = y + dy;
        if(x < 0 || x > this.getWidth())
            dx = -dx;
        if(y < 0 || y > this.getHeight())
            dy = -dy;
    }
    public void moveD()
    {
        y = y + dy;
        if(y < 0 || y > this.getHeight())
            dy = -dy;
    }
}
