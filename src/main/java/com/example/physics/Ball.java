package com.example.physics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Ball {
    int x, y, r, dx, dy;
    int bc, str;
    int gx,gy;
    int viewWidth, viewHeight;
    int l;

    public Ball(int x, int y, int r, int bc, int str, int dx, int dy){
        this.x = x;
        this.y = y;
        this.r = r;
        this.bc = bc;
        this.str = str;
        this.dx = dx;
        this.dy = dy;
        l = r/4;
        gx = x + dx*l ;
        gy = y + dy*l;
    }


    protected void draw(Canvas canvas) {
        viewHeight= canvas.getHeight();
        viewWidth = canvas.getWidth();
        Paint p = new Paint();
        p.setColor(bc);
        canvas.drawCircle(x, y, r, p);
        p.setColor(str);

        canvas.drawLine(x,y,gx,gy,p);
        if(x>viewWidth-r/1.3) {
            dx = -dx;
            gx=-gx;
        }
        else if(x<r/1.3){
            dx=-dx;
            gx=-gx;
        }
        if(y>viewHeight-r/1.3) {
            dy = -dy;
            gy=-gy;
        }
        else if(y <r/1.3) {
            dy = -dy;
            gy=-gy;
        }
        move();

    }
    public void move(){
        x+=dx;
        y+=dy;
        gx =x+dx*l ;
        gy = y + dy*l;
    }

    public void crush(Ball b){
        int l = (int)(Math.sqrt((x - b.x)*(x - b.x) + (y-b.y)*(y-b.y)));
        if(l<r+b.r){
            dx = -dx; dy = -dy;
            b.dx = -b.dx; b.dy = - b.dy;
        }
    }
}
