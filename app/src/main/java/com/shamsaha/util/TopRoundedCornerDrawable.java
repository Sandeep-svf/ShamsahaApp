package com.shamsaha.util;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class TopRoundedCornerDrawable extends Drawable {
    private final Paint paint;
    private final Path path;

    public TopRoundedCornerDrawable(int color) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        path = new Path();
    }

    @Override
    public void draw(Canvas canvas) {
        RectF bounds = new RectF(getBounds());
        float radius = bounds.width() * 0.5f; // Adjust the radius as needed
        path.reset();
        path.addRoundRect(bounds, radius, radius, Path.Direction.CW);
        path.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom - radius, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return paint.getAlpha() == 255 ? PixelFormat.OPAQUE : PixelFormat.TRANSLUCENT;
    }
}
