//Ukrit Wattanakulchart 5931391721

package com.example.starwars;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Paint.Style;

/**
 * Created by pepukrit on 11/8/2017.
 */

public class StarWars extends View implements Runnable {
    // required constructor
    static int t1 = 0;
    static int t2 = 0;
    static int dt2 = 0;
    static int sp = 25;
    static String text ="A long time ago in a galaxy,far,far away...";
    static  Boolean r = true;
    static  Boolean s = true;




    static Thread T1, T2;

    public StarWars(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (T1 == null) {
            T1 = new Thread(this);
            T1.start();
        }
    }


    // this method draws on the view
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (t1 <= 125) {
            canvas.drawColor(Color.BLACK);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(50 - t1 / 4);
            drawTextCentered(text, getWidth()/2 ,getHeight()/2 - 7 * t1,paint, canvas);
        } else {
            canvas.drawColor(Color.BLACK);
            Paint paint = new Paint();
            Paint paint1 = new Paint();
            Paint paint2 = new Paint();
            paint.setColor(Color.GREEN);
            paint1.setColor(Color.MAGENTA);
            paint2.setColor(Color.YELLOW);
            paint.setStyle(Style.FILL);
            Path wallpath = new Path();
            wallpath.reset();
            wallpath.moveTo(600 - t2, 100 + t2);
            wallpath.lineTo(675 - t2, 0 + t2);
            wallpath.lineTo(699 - t2, 50 + t2);
            wallpath.lineTo(600 - t2, 100 + t2);
            canvas.drawPath(wallpath, paint);
            wallpath.reset();
            wallpath.moveTo(800 - t2,-100 + t2);
            wallpath.lineTo(975 - t2, -400 + t2);
            wallpath.lineTo(999 - t2, -250 + t2);
            wallpath.lineTo(800 - t2, -100 + t2);
            canvas.drawPath(wallpath, paint1);
            wallpath.reset();
            wallpath.moveTo(800 - dt2, -100 + dt2);
            wallpath.lineTo(825 - dt2, -125 + dt2);
            wallpath.lineTo(830 - dt2, -115 + dt2);
            wallpath.lineTo(800 - dt2, -100 + dt2);
            canvas.drawPath(wallpath, paint2);
        }
    }

    private void drawTextCentered(String text, int x, int y, Paint paint, Canvas canvas) {
        int xPos = x - (int)(paint.measureText(text)/2);
        int yPos = (int) (y - ((paint.descent() + paint.ascent()) / 2)) ;
        canvas.drawText(text, xPos, yPos, paint);
    }
    @Override
    public synchronized void run() {
        while (Thread.currentThread() == T1) {if(r) {
            s = true;
            t1 += 1;
            if (t1 > 125) {
                T2 = new Thread(this);
                T2.start();
                break;
            }
            invalidate();
            try {
                Thread.sleep(sp);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
        }
            invalidate();
        }
        while (Thread.currentThread() == T2) {if(r) {
            if (t2 < 999) {


                t2 += 1;
                dt2 += 2;
            }
            if (dt2 > 150 + t2) {
                dt2 = t2;
                dt2 = t2;
            }
            invalidate();

            if (!s) {
                T1 = new Thread(this);
                T1.start();
                break;
            }
            try {
                Thread.sleep(sp);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
        invalidate();
    }
}

