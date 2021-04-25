package com.example.physics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import java.util.ArrayList;

import static android.graphics.Color.*;

public class Physics extends View {

    int viewWidth, viewHeight;
    ArrayList<Ball> bs = new ArrayList<Ball>();
    public Physics(Context context) {
        super(context);
        MyT t = new MyT(3456789,6);
        t.start();

        bs.add(new Ball(340,250,200, BLUE, GREEN, 6,5));
        bs.add(new Ball(456, 434, 34, RED, YELLOW, 5, 6));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
            canvas.drawColor(RED);
            for(Ball b1:bs){
                b1.draw(canvas);
                for(Ball b2:bs){
                    b1.crush(b2);
                }
            }

    }
    
    class MyT extends CountDownTimer{
        public MyT(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            invalidate();
        }

        @Override
        public void onTick(long millisUntilFinished) {
        invalidate();
        }

        @Override
        public void onFinish() {

        }
    }
}
