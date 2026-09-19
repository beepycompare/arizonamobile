package ru.mrlargha.commonui.elements.hud.presentation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: TrainSpeedGaugeView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0002\b\n¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/view/TrainSpeedGaugeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/jvm/JvmOverloads;", "value", "speedKmh", "getSpeedKmh", "()I", "setSpeedKmh", "(I)V", "density", "", "trackPaint", "Landroid/graphics/Paint;", "tickPaint", "labelPaint", "needlePaint", "needleCenterPaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public class TrainSpeedGaugeView extends View {
    @Deprecated
    public static final float CENTER_Y_RATIO = 0.82f;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int MAJOR_TICK_STEP = 20;
    @Deprecated
    public static final int MAX_SPEED_KMH = 140;
    @Deprecated
    public static final int MINOR_TICK_STEP = 10;
    @Deprecated
    public static final float RADIUS_HEIGHT_RATIO = 0.72f;
    @Deprecated
    public static final float RADIUS_WIDTH_RATIO = 0.45f;
    @Deprecated
    public static final float START_ANGLE = 200.0f;
    @Deprecated
    public static final float SWEEP_ANGLE = 140.0f;
    private final float density;
    private final Paint labelPaint;
    private final Paint needleCenterPaint;
    private final Paint needlePaint;
    private int speedKmh;
    private final Paint tickPaint;
    private final Paint trackPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrainSpeedGaugeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrainSpeedGaugeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainSpeedGaugeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#52FFFFFF"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(f);
        this.trackPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.parseColor("#A6FFFFFF"));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(f);
        this.tickPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(Color.parseColor("#99FFFFFF"));
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTextSize(3.5f * f);
        this.labelPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setColor(Color.parseColor("#FF414F"));
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        paint4.setStrokeWidth(f * 1.5f);
        this.needlePaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setColor(Color.parseColor("#FF414F"));
        paint5.setStyle(Paint.Style.FILL);
        this.needleCenterPaint = paint5;
    }

    public /* synthetic */ TrainSpeedGaugeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public int getSpeedKmh() {
        return this.speedKmh;
    }

    public void setSpeedKmh(int i) {
        this.speedKmh = RangesKt.coerceIn(i, 0, (int) MAX_SPEED_KMH);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() * 0.82f;
        float min = Math.min(getWidth() * 0.45f, getHeight() * 0.72f);
        canvas.drawArc(new RectF(width - min, height - min, width + min, height + min), 200.0f, 140.0f, false, this.trackPaint);
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, (int) MAX_SPEED_KMH, 10);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                double radians = Math.toRadians(((i * 140.0f) / 140.0f) + 200.0f);
                boolean z = i % 20 == 0;
                float f = min - ((z ? 5.0f : 2.5f) * this.density);
                canvas2 = canvas;
                canvas2.drawLine((((float) Math.cos(radians)) * f) + width, (((float) Math.sin(radians)) * f) + height, width + (((float) Math.cos(radians)) * min), height + (((float) Math.sin(radians)) * min), this.tickPaint);
                if (z) {
                    float f2 = min - (this.density * 10.0f);
                    canvas2.drawText(String.valueOf(i), (((float) Math.cos(radians)) * f2) + width, ((((float) Math.sin(radians)) * f2) + height) - ((this.labelPaint.ascent() + this.labelPaint.descent()) / 2.0f), this.labelPaint);
                }
                if (i == progressionLastElement) {
                    break;
                }
                i += 10;
            }
        } else {
            canvas2 = canvas;
        }
        double radians2 = Math.toRadians(((getSpeedKmh() * 140.0f) / 140.0f) + 200.0f);
        float f3 = min - (this.density * 8.0f);
        canvas2.drawLine(width, height, (((float) Math.cos(radians2)) * f3) + width, height + (((float) Math.sin(radians2)) * f3), this.needlePaint);
        canvas2.drawCircle(width, height, this.density * 2.0f, this.needleCenterPaint);
    }

    /* compiled from: TrainSpeedGaugeView.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/view/TrainSpeedGaugeView$Companion;", "", "<init>", "()V", "MAX_SPEED_KMH", "", "MINOR_TICK_STEP", "MAJOR_TICK_STEP", "START_ANGLE", "", "SWEEP_ANGLE", "CENTER_Y_RATIO", "RADIUS_WIDTH_RATIO", "RADIUS_HEIGHT_RATIO", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
