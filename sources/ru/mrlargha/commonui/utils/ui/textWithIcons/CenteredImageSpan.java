package ru.mrlargha.commonui.utils.ui.textWithIcons;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: textWithIcons.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/utils/ui/textWithIcons/CenteredImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", TtmlNode.START, "", TtmlNode.END, "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CenteredImageSpan extends ImageSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenteredImageSpan(Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f, (i4 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (drawable.getBounds().height() / 2));
        drawable.draw(canvas);
        canvas.restore();
    }
}
