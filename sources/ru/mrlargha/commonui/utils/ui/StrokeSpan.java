package ru.mrlargha.commonui.utils.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StrokedText.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016JP\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/utils/ui/StrokeSpan;", "Landroid/text/style/ReplacementSpan;", "strokeColor", "", "strokeWidthPx", "", "<init>", "(IF)V", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", TtmlNode.START, TtmlNode.END, "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StrokeSpan extends ReplacementSpan {
    private final int strokeColor;
    private final float strokeWidthPx;

    public StrokeSpan(int i, float f) {
        this.strokeColor = i;
        this.strokeWidthPx = f;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        return (int) paint.measureText(text, i, i2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        Paint.Style style = paint.getStyle();
        float strokeWidth = paint.getStrokeWidth();
        Paint.Join strokeJoin = paint.getStrokeJoin();
        float strokeMiter = paint.getStrokeMiter();
        float f2 = i4;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.strokeColor);
        paint.setStrokeWidth(this.strokeWidthPx);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeMiter(10.0f);
        Unit unit = Unit.INSTANCE;
        canvas.drawText(text, i, i2, f, f2, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        Unit unit2 = Unit.INSTANCE;
        canvas.drawText(text, i, i2, f, f2, paint);
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeJoin(strokeJoin);
        paint.setStrokeMiter(strokeMiter);
    }
}
