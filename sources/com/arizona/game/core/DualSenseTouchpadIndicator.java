package com.arizona.game.core;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DualSenseTouchpadIndicator extends Drawable {
    private volatile int activeMask;
    private final Paint fill;
    private WeakReference<View> host;
    private float radius;
    private final Paint stroke;
    private float x0;
    private float x1;
    private float y0;
    private float y1;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DualSenseTouchpadIndicator() {
        Paint paint = new Paint(1);
        this.fill = paint;
        Paint paint2 = new Paint(1);
        this.stroke = paint2;
        this.host = new WeakReference<>(null);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(1442840575);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
        paint2.setColor(-436152065);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(JNIActivity jNIActivity, int i, float f, float f2, float f3, float f4) {
        if (jNIActivity == null) {
            return;
        }
        View decorView = jNIActivity.getWindow().getDecorView();
        View view = this.host.get();
        if (view != decorView) {
            if (view != null) {
                view.getOverlay().remove(this);
            }
            this.host = new WeakReference<>(decorView);
            decorView.getOverlay().add(this);
            float f5 = decorView.getResources().getDisplayMetrics().density;
            this.radius = 18.0f * f5;
            this.stroke.setStrokeWidth(f5 * 2.0f);
        }
        setBounds(0, 0, decorView.getWidth(), decorView.getHeight());
        this.activeMask = i;
        this.x0 = f;
        this.y0 = f2;
        this.x1 = f3;
        this.y1 = f4;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detach() {
        View view = this.host.get();
        this.activeMask = 0;
        if (view != null) {
            view.getOverlay().remove(this);
        }
        this.host.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestDetach() {
        this.activeMask = 0;
        final View view = this.host.get();
        if (view != null) {
            view.post(new Runnable() { // from class: com.arizona.game.core.DualSenseTouchpadIndicator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DualSenseTouchpadIndicator.this.lambda$requestDetach$0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDetach$0(View view) {
        if (this.host.get() == view) {
            detach();
        } else {
            view.getOverlay().remove(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        if ((this.activeMask & 1) != 0) {
            drawPoint(canvas, this.x0 * (width - 1), this.y0 * (height - 1));
        }
        if ((this.activeMask & 2) != 0) {
            drawPoint(canvas, this.x1 * (width - 1), this.y1 * (height - 1));
        }
    }

    private void drawPoint(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.radius, this.fill);
        canvas.drawCircle(f, f2, this.radius, this.stroke);
        canvas.drawCircle(f, f2, Math.max(2.0f, this.radius * 0.12f), this.stroke);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        float f = i;
        this.fill.setAlpha(Math.round(0.33333334f * f));
        this.stroke.setAlpha(Math.round(f * 0.9019608f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.fill.setColorFilter(colorFilter);
        this.stroke.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
