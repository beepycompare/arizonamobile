package ru.mrlargha.commonui.elements.metaldetector;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: LocatorView.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0002\b\n¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0007J(\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\b\u0010&\u001a\u00020\u001bH\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/metaldetector/LocatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/jvm/JvmOverloads;", "viewRect", "Landroid/graphics/Rect;", "circleRadius", "", TypedValues.TransitionType.S_DURATION, "", "animator", "Landroid/animation/ValueAnimator;", "colorArrayListRodina", "", "", "colorArrayListArizona", "colorArrayCurrentIndex", "innerCirclePaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setupAnimation", "newDuration", "colorLevel", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "updateShader", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LocatorView extends View {
    private ValueAnimator animator;
    private float circleRadius;
    private int colorArrayCurrentIndex;
    private List<int[]> colorArrayListArizona;
    private List<int[]> colorArrayListRodina;
    private long duration;
    private final Paint innerCirclePaint;
    private Rect viewRect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocatorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewRect = new Rect(0, 0, getWidth(), getHeight());
        this.circleRadius = 10.0f;
        this.duration = 200L;
        this.colorArrayListRodina = CollectionsKt.listOf((Object[]) new int[][]{new int[]{Color.argb(0, 255, (int) ComposerKt.providerMapsKey, 51), Color.argb(255, 255, (int) ComposerKt.providerMapsKey, 51), Color.argb(115, 255, (int) ComposerKt.providerMapsKey, 51)}, new int[]{Color.parseColor("#0059E827"), Color.parseColor("#59E827"), Color.parseColor("#7359E827")}, new int[]{Color.argb(0, 255, 33, 33), Color.argb(255, 255, 33, 33), Color.argb(115, 255, 33, 33)}});
        this.colorArrayListArizona = CollectionsKt.listOf((Object[]) new int[][]{new int[]{Color.argb(0, 255, (int) ComposerKt.providerMapsKey, 51), Color.argb(255, 89, 232, 39), Color.argb(114, 89, 232, 39)}, new int[]{Color.parseColor("#0059E827"), Color.argb(255, 255, (int) ComposerKt.providerMapsKey, 51), Color.argb(114, 255, (int) ComposerKt.providerMapsKey, 51)}, new int[]{Color.argb(0, 255, 33, 33), Color.argb(255, 240, 108, 13), Color.argb(114, (int) TsExtractor.TS_PACKET_SIZE, 61, 10)}, new int[]{Color.argb(0, 255, 33, 33), Color.argb(255, 255, 255, 255), Color.argb(114, 192, 192, 192)}, new int[]{Color.argb(0, 255, 33, 33), Color.argb(255, 215, 14, 14), Color.argb(114, (int) TsExtractor.TS_STREAM_TYPE_AC3, 8, 8)}});
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10.0f);
        this.innerCirclePaint = paint;
    }

    public /* synthetic */ LocatorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawCircle(this.viewRect.exactCenterX(), this.viewRect.exactCenterY(), this.circleRadius, this.innerCirclePaint);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r4 > kotlin.collections.CollectionsKt.getLastIndex(ru.mrlargha.commonui.utils.UtilsKt.isArizonaType() ? r1.colorArrayListArizona : r1.colorArrayListRodina)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setupAnimation(long j, int i) {
        this.duration = j;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(j);
        }
        if (i >= 0) {
        }
        this.colorArrayCurrentIndex = 0;
        this.colorArrayCurrentIndex = i;
        updateShader();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewRect = new Rect(0, 0, i, i2);
        this.circleRadius = i / 2;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setDuration(ofInt.getDuration());
        ofInt.setRepeatCount(-1);
        ofInt.setRepeatMode(2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.commonui.elements.metaldetector.LocatorView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LocatorView.onSizeChanged$lambda$0$0(LocatorView.this, valueAnimator);
            }
        });
        ofInt.start();
        this.animator = ofInt;
        updateShader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSizeChanged$lambda$0$0(LocatorView locatorView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Paint paint = locatorView.innerCirclePaint;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        paint.setAlpha(((Integer) animatedValue).intValue());
        locatorView.invalidate();
    }

    private final void updateShader() {
        this.innerCirclePaint.setShader(new RadialGradient(this.viewRect.exactCenterX(), this.viewRect.exactCenterY(), this.circleRadius, (UtilsKt.isArizonaType() ? this.colorArrayListArizona : this.colorArrayListRodina).get(this.colorArrayCurrentIndex), new float[]{0.0f, 0.82f, 1.0f}, Shader.TileMode.CLAMP));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int coerceAtMost = RangesKt.coerceAtMost(i, i2);
        setMeasuredDimension(coerceAtMost, coerceAtMost);
    }
}
