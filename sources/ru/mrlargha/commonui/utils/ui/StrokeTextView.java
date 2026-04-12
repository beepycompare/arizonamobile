package ru.mrlargha.commonui.utils.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StrokedText.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/utils/ui/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokeColor", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeWidthPx", "", "getStrokeWidthPx", "()F", "setStrokeWidthPx", "(F)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setStroke", "color", "widthPx", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StrokeTextView extends AppCompatTextView {
    private int strokeColor;
    private float strokeWidthPx;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeColor = -16777216;
        this.strokeWidthPx = 3.0f;
    }

    public /* synthetic */ StrokeTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842884 : i);
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final void setStrokeColor(int i) {
        this.strokeColor = i;
    }

    public final float getStrokeWidthPx() {
        return this.strokeWidthPx;
    }

    public final void setStrokeWidthPx(float f) {
        this.strokeWidthPx = f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int currentTextColor = getCurrentTextColor();
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setStrokeWidth(this.strokeWidthPx);
        setTextColor(this.strokeColor);
        super.onDraw(canvas);
        getPaint().setStyle(Paint.Style.FILL);
        setTextColor(currentTextColor);
        super.onDraw(canvas);
    }

    public final void setStroke(int i, float f) {
        this.strokeColor = i;
        this.strokeWidthPx = f;
        invalidate();
    }
}
