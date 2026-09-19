package ru.mrlargha.commonui.elements.hud.presentation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
/* compiled from: TrainRouteProgressView.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0002\b\n¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/view/TrainRouteProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/jvm/JvmOverloads;", "value", "", "progress", "getProgress", "()F", "setProgress", "(F)V", "dashHeight", "dashGap", "dashPaint", "Landroid/graphics/Paint;", "filledColor", "emptyColor", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TrainRouteProgressView extends View {
    private final float dashGap;
    private final float dashHeight;
    private final Paint dashPaint;
    private final int emptyColor;
    private final int filledColor;
    private float progress;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrainRouteProgressView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrainRouteProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainRouteProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dashHeight = getResources().getDimension(R.dimen._2sdp);
        this.dashGap = getResources().getDimension(R.dimen._2sdp);
        this.dashPaint = new Paint(1);
        this.filledColor = Color.parseColor("#9EF15D");
        this.emptyColor = Color.parseColor("#B3FFFFFF");
    }

    public /* synthetic */ TrainRouteProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final float getProgress() {
        return this.progress;
    }

    public final void setProgress(float f) {
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        if (this.progress == coerceIn) {
            return;
        }
        this.progress = coerceIn;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float f = this.dashHeight;
        float f2 = f + this.dashGap;
        if (width <= 0.0f || height <= 0.0f || f <= 0.0f || f2 <= 0.0f) {
            return;
        }
        float f3 = width / 2.0f;
        float f4 = height * (1.0f - this.progress);
        for (float f5 = 0.0f; f5 < height; f5 += f2) {
            float min = Math.min(this.dashHeight + f5, height);
            this.dashPaint.setColor((f5 + min) / 2.0f >= f4 ? this.filledColor : this.emptyColor);
            canvas.drawRoundRect(0.0f, f5, width, min, f3, f3, this.dashPaint);
        }
    }
}
