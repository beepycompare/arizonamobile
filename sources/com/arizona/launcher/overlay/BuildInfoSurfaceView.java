package com.arizona.launcher.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: BuildInfoSurfaceView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/overlay/BuildInfoSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "text", "", "textPaint", "Landroid/graphics/Paint;", "padding", "", "textWidth", "getTextWidth", "()I", "textHeight", "getTextHeight", "baseline", "", "surfaceCreated", "", "holder", "Landroid/view/SurfaceHolder;", "surfaceChanged", "format", "width", "height", "surfaceDestroyed", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BuildInfoSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public static final int $stable = 8;
    private final float baseline;
    private final int padding;
    private final String text;
    private final int textHeight;
    private final Paint textPaint;
    private final int textWidth;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildInfoSurfaceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.text = "arizona, release, app: 1788, engine: 3.9.9";
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(context.getResources().getDimension(R.dimen._6sdp));
        paint.setShadowLayer(1.0f, 0.0f, 1.0f, -16777216);
        this.textPaint = paint;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen._2sdp);
        this.padding = dimensionPixelSize;
        this.textWidth = ((int) Math.ceil(paint.measureText("arizona, release, app: 1788, engine: 3.9.9"))) + (dimensionPixelSize * 2);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.textHeight = ((int) Math.ceil(fontMetrics.bottom - fontMetrics.top)) + (dimensionPixelSize * 2);
        this.baseline = dimensionPixelSize - fontMetrics.top;
        getHolder().setFormat(-3);
        getHolder().addCallback(this);
        setZOrderOnTop(true);
        setFocusable(false);
        setClickable(false);
        setImportantForAccessibility(2);
    }

    public final int getTextWidth() {
        return this.textWidth;
    }

    public final int getTextHeight() {
        return this.textHeight;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getSurface().isValid()) {
            try {
                Canvas lockCanvas = holder.lockCanvas();
                if (lockCanvas == null) {
                    return;
                }
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                int i4 = this.textWidth;
                if (i2 != i4 || i3 != this.textHeight) {
                    lockCanvas.scale(i2 / i4, i3 / this.textHeight);
                }
                lockCanvas.drawText(this.text, this.textWidth - this.padding, this.baseline, this.textPaint);
                holder.unlockCanvasAndPost(lockCanvas);
            } catch (RuntimeException e) {
                Log.w("BuildInfoSurfaceView", "Unable to draw build information", e);
            }
        }
    }
}
