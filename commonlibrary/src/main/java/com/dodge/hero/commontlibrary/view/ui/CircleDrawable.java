package com.dodge.hero.commontlibrary.view.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;


/**
 * 描述
 * Created by Linzheng on 2016/11/28.
 */

public class CircleDrawable extends Drawable {

    private int mWidth;
    private Paint mPaint;

    public CircleDrawable(Context context, int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);
        mWidth = Math.min(bitmap.getWidth(), bitmap.getHeight());
    }

    public CircleDrawable(Bitmap bitmap) {
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setShader(bitmapShader);
        mWidth = Math.min(bitmap.getWidth(), bitmap.getHeight());
    }


    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        canvas.drawCircle(mWidth /2, mWidth/ 2, mWidth/ 2,  paint);
        canvas.drawCircle(mWidth /2, mWidth/ 2, mWidth / 2 - 5, mPaint);
    }


    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }


    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
