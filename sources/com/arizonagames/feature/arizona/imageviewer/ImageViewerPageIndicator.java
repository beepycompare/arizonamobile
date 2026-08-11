package com.arizonagames.feature.arizona.imageviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ImageViewerPageIndicator.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/ImageViewerPageIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/jvm/JvmOverloads;", "paint", "Landroid/graphics/Paint;", "gap", "", "activeColor", "", "visitedColor", "pendingColor", "itemCount", "selectedPosition", "setState", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageViewerPageIndicator extends View {
    private final int activeColor;
    private final float gap;
    private int itemCount;
    private final Paint paint;
    private final int pendingColor;
    private int selectedPosition;
    private final int visitedColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageViewerPageIndicator(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewerPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(1);
        this.gap = getResources().getDimension(ru.mrlargha.commonui.R.dimen._1sdp);
        this.activeColor = ContextCompat.getColor(context, R.color.image_viewer_indicator_active);
        this.visitedColor = ContextCompat.getColor(context, R.color.image_viewer_indicator_visited);
        this.pendingColor = ContextCompat.getColor(context, R.color.image_viewer_indicator_pending);
    }

    public /* synthetic */ ImageViewerPageIndicator(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setState(int i, int i2) {
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        this.itemCount = coerceAtLeast;
        this.selectedPosition = RangesKt.coerceIn(i2, 0, RangesKt.coerceAtLeast(coerceAtLeast - 1, 0));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int coerceAtLeast = RangesKt.coerceAtLeast(this.itemCount, 1);
        float coerceAtLeast2 = RangesKt.coerceAtLeast((getWidth() - (this.gap * (coerceAtLeast - 1))) / coerceAtLeast, 0.0f);
        float height = getHeight() / 2.0f;
        for (int i2 = 0; i2 < coerceAtLeast; i2++) {
            float f = i2 * (this.gap + coerceAtLeast2);
            Paint paint = this.paint;
            if (this.itemCount == 0) {
                i = this.pendingColor;
            } else {
                int i3 = this.selectedPosition;
                if (i2 == i3) {
                    i = this.activeColor;
                } else if (i2 < i3) {
                    i = this.visitedColor;
                } else {
                    i = this.pendingColor;
                }
            }
            paint.setColor(i);
            canvas.drawRoundRect(f, 0.0f, f + coerceAtLeast2, getHeight(), height, height, this.paint);
        }
    }
}
