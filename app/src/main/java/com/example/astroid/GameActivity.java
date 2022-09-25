package com.example.astroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    DrawSurfaceView ds;
    Thread thread;
    FrameLayout frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        frame = findViewById(R.id.frame);
        ds = new DrawSurfaceView(this);
        frame.addView(ds);
        thread = new Thread(ds);
        thread.start();
    }


    public void pauseResume(View view)
    {
        //TODO
    }

    public void playResume(View view)
    {
        //TODO
    }
    public void move(View view)
    {
        //TODO

    }
}
