package com.arizonagames.feature.arizona.bank.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: BankSignaturePadView.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0017\u001a\u00020\u00162\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/views/BankSignaturePadView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/jvm/JvmOverloads;", "path", "Landroid/graphics/Path;", "paint", "Landroid/graphics/Paint;", "lastX", "", "lastY", "strokeLength", "hasSignature", "", "onSignatureChanged", "Lkotlin/Function2;", "", "", "setOnSignatureChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "clear", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "markSigned", "calculateProgress", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BankSignaturePadView extends View {
    private boolean hasSignature;
    private float lastX;
    private float lastY;
    private Function2<? super Boolean, ? super Integer, Unit> onSignatureChanged;
    private final Paint paint;
    private final Path path;
    private float strokeLength;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankSignaturePadView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankSignaturePadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#15182A"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(8.0f);
        this.paint = paint;
    }

    public /* synthetic */ BankSignaturePadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setOnSignatureChangedListener(Function2<? super Boolean, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSignatureChanged = listener;
        listener.invoke(Boolean.valueOf(this.hasSignature), Integer.valueOf(calculateProgress()));
    }

    public final void clear() {
        this.path.reset();
        this.strokeLength = 0.0f;
        this.hasSignature = false;
        invalidate();
        Function2<? super Boolean, ? super Integer, Unit> function2 = this.onSignatureChanged;
        if (function2 != null) {
            function2.invoke(false, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.lastX = event.getX();
            float y = event.getY();
            this.lastY = y;
            this.path.moveTo(this.lastX, y);
            markSigned();
            invalidate();
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float x = event.getX();
                float y2 = event.getY();
                Path path = this.path;
                float f = this.lastX;
                float f2 = this.lastY;
                path.quadTo(f, f2, (x + f) / 2.0f, (y2 + f2) / 2.0f);
                this.strokeLength += (float) Math.hypot(x - this.lastX, y2 - this.lastY);
                this.lastX = x;
                this.lastY = y2;
                markSigned();
                invalidate();
                return true;
            } else if (actionMasked != 3) {
                return super.onTouchEvent(event);
            }
        }
        ViewParent parent2 = getParent();
        if (parent2 != null) {
            parent2.requestDisallowInterceptTouchEvent(false);
        }
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    private final void markSigned() {
        this.hasSignature = true;
        Function2<? super Boolean, ? super Integer, Unit> function2 = this.onSignatureChanged;
        if (function2 != null) {
            function2.invoke(true, Integer.valueOf(calculateProgress()));
        }
    }

    private final int calculateProgress() {
        if (!this.hasSignature || getWidth() == 0) {
            return 0;
        }
        return MathKt.roundToInt(RangesKt.coerceIn((this.strokeLength / getWidth()) * 100.0f, 12.0f, 100.0f));
    }
}
