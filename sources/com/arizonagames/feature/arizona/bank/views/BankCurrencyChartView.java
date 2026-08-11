package com.arizonagames.feature.arizona.bank.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: BankCurrencyChartView.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u000201B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0006\u0010#\u001a\u00020\u0018J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\nH\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/jvm/JvmOverloads;", "chartPaddingHorizontal", "", "chartPaddingVertical", "pointRadius", "linePath", "Landroid/graphics/Path;", "history", "", "", "selectedIndex", "", "Ljava/lang/Integer;", "onPointSelected", "Lkotlin/Function1;", "Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView$PointSelection;", "", "getOnPointSelected", "()Lkotlin/jvm/functions/Function1;", "setOnPointSelected", "(Lkotlin/jvm/functions/Function1;)V", "linePaint", "Landroid/graphics/Paint;", "pointPaint", "pointOutlinePaint", "setHistory", "values", "clearSelection", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "performClick", "updateSelection", "touchX", "buildChartPoints", "Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView$ChartPoint;", "PointSelection", "ChartPoint", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyChartView extends View {
    private final float chartPaddingHorizontal;
    private final float chartPaddingVertical;
    private List<Long> history;
    private final Paint linePaint;
    private final Path linePath;
    private Function1<? super PointSelection, Unit> onPointSelected;
    private final Paint pointOutlinePaint;
    private final Paint pointPaint;
    private final float pointRadius;
    private Integer selectedIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankCurrencyChartView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCurrencyChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.chartPaddingHorizontal = getResources().getDimension(R.dimen._3sdp);
        this.chartPaddingVertical = getResources().getDimension(R.dimen._4sdp);
        this.pointRadius = getResources().getDimension(R.dimen._3sdp);
        this.linePath = new Path();
        this.history = CollectionsKt.emptyList();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStrokeWidth(getResources().getDimension(R.dimen._2sdp));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        this.linePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.FILL);
        this.pointPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(-872415232);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(getResources().getDimension(R.dimen._1sdp));
        this.pointOutlinePaint = paint3;
    }

    public /* synthetic */ BankCurrencyChartView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* compiled from: BankCurrencyChartView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView$PointSelection;", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "anchorX", "", "anchorY", "<init>", "(IJFF)V", "getIndex", "()I", "getValue", "()J", "getAnchorX", "()F", "getAnchorY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PointSelection {
        private final float anchorX;
        private final float anchorY;
        private final int index;
        private final long value;

        public static /* synthetic */ PointSelection copy$default(PointSelection pointSelection, int i, long j, float f, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pointSelection.index;
            }
            if ((i2 & 2) != 0) {
                j = pointSelection.value;
            }
            if ((i2 & 4) != 0) {
                f = pointSelection.anchorX;
            }
            if ((i2 & 8) != 0) {
                f2 = pointSelection.anchorY;
            }
            return pointSelection.copy(i, j, f, f2);
        }

        public final int component1() {
            return this.index;
        }

        public final long component2() {
            return this.value;
        }

        public final float component3() {
            return this.anchorX;
        }

        public final float component4() {
            return this.anchorY;
        }

        public final PointSelection copy(int i, long j, float f, float f2) {
            return new PointSelection(i, j, f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PointSelection) {
                PointSelection pointSelection = (PointSelection) obj;
                return this.index == pointSelection.index && this.value == pointSelection.value && Float.compare(this.anchorX, pointSelection.anchorX) == 0 && Float.compare(this.anchorY, pointSelection.anchorY) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.index) * 31) + Long.hashCode(this.value)) * 31) + Float.hashCode(this.anchorX)) * 31) + Float.hashCode(this.anchorY);
        }

        public String toString() {
            int i = this.index;
            long j = this.value;
            float f = this.anchorX;
            return "PointSelection(index=" + i + ", value=" + j + ", anchorX=" + f + ", anchorY=" + this.anchorY + ")";
        }

        public PointSelection(int i, long j, float f, float f2) {
            this.index = i;
            this.value = j;
            this.anchorX = f;
            this.anchorY = f2;
        }

        public final int getIndex() {
            return this.index;
        }

        public final long getValue() {
            return this.value;
        }

        public final float getAnchorX() {
            return this.anchorX;
        }

        public final float getAnchorY() {
            return this.anchorY;
        }
    }

    public final Function1<PointSelection, Unit> getOnPointSelected() {
        return this.onPointSelected;
    }

    public final void setOnPointSelected(Function1<? super PointSelection, Unit> function1) {
        this.onPointSelected = function1;
    }

    public final void setHistory(List<Long> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.history = values;
        clearSelection();
        invalidate();
    }

    public final void clearSelection() {
        this.selectedIndex = null;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ChartPoint chartPoint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getWidth() <= 0 || getHeight() <= 0 || this.history.isEmpty()) {
            return;
        }
        List<ChartPoint> buildChartPoints = buildChartPoints();
        if (buildChartPoints.isEmpty()) {
            return;
        }
        this.linePath.reset();
        int i = 0;
        for (Object obj : buildChartPoints) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ChartPoint chartPoint2 = (ChartPoint) obj;
            Path path = this.linePath;
            if (i == 0) {
                path.moveTo(chartPoint2.getX(), chartPoint2.getY());
            } else {
                path.lineTo(chartPoint2.getX(), chartPoint2.getY());
            }
            i = i2;
        }
        canvas.drawPath(this.linePath, this.linePaint);
        Integer num = this.selectedIndex;
        if (num == null || (chartPoint = (ChartPoint) CollectionsKt.getOrNull(buildChartPoints, num.intValue())) == null) {
            return;
        }
        canvas.drawCircle(chartPoint.getX(), chartPoint.getY(), this.pointRadius, this.pointPaint);
        canvas.drawCircle(chartPoint.getX(), chartPoint.getY(), this.pointRadius, this.pointOutlinePaint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.history.isEmpty()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            updateSelection(event.getX());
            return true;
        } else if (actionMasked == 1) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
            performClick();
            return true;
        } else if (actionMasked == 2) {
            updateSelection(event.getX());
            return true;
        } else if (actionMasked == 3) {
            ViewParent parent3 = getParent();
            if (parent3 != null) {
                parent3.requestDisallowInterceptTouchEvent(false);
            }
            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    private final void updateSelection(float f) {
        Object obj;
        Iterator<T> it = buildChartPoints().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                float abs = Math.abs(((ChartPoint) next).getX() - f);
                do {
                    Object next2 = it.next();
                    float abs2 = Math.abs(((ChartPoint) next2).getX() - f);
                    if (Float.compare(abs, abs2) > 0) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        ChartPoint chartPoint = (ChartPoint) obj;
        if (chartPoint == null) {
            return;
        }
        this.selectedIndex = Integer.valueOf(chartPoint.getIndex());
        Function1<? super PointSelection, Unit> function1 = this.onPointSelected;
        if (function1 != null) {
            function1.invoke(new PointSelection(chartPoint.getIndex(), chartPoint.getValue(), chartPoint.getX(), chartPoint.getY()));
        }
        invalidate();
    }

    private final List<ChartPoint> buildChartPoints() {
        BankCurrencyChartView bankCurrencyChartView = this;
        float width = bankCurrencyChartView.getWidth() - (bankCurrencyChartView.chartPaddingHorizontal * 2.0f);
        float height = bankCurrencyChartView.getHeight() - (bankCurrencyChartView.chartPaddingVertical * 2.0f);
        Long l = (Long) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) bankCurrencyChartView.history);
        long longValue = l != null ? l.longValue() : 0L;
        Long l2 = (Long) CollectionsKt.minOrNull((Iterable<? extends Comparable>) bankCurrencyChartView.history);
        long longValue2 = l2 != null ? l2.longValue() : 0L;
        float max = (float) Math.max(longValue - longValue2, 1L);
        float lastIndex = bankCurrencyChartView.history.size() == 1 ? 0.0f : width / CollectionsKt.getLastIndex(bankCurrencyChartView.history);
        List<Long> list = bankCurrencyChartView.history;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long longValue3 = ((Number) obj).longValue();
            arrayList.add(new ChartPoint(i, longValue3, (i * lastIndex) + bankCurrencyChartView.chartPaddingHorizontal, (bankCurrencyChartView.chartPaddingVertical + height) - ((((float) (longValue3 - longValue2)) / max) * height)));
            bankCurrencyChartView = this;
            i = i2;
            lastIndex = lastIndex;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BankCurrencyChartView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView$ChartPoint;", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "x", "", "y", "<init>", "(IJFF)V", "getIndex", "()I", "getValue", "()J", "getX", "()F", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ChartPoint {
        private final int index;
        private final long value;
        private final float x;
        private final float y;

        public static /* synthetic */ ChartPoint copy$default(ChartPoint chartPoint, int i, long j, float f, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = chartPoint.index;
            }
            if ((i2 & 2) != 0) {
                j = chartPoint.value;
            }
            if ((i2 & 4) != 0) {
                f = chartPoint.x;
            }
            if ((i2 & 8) != 0) {
                f2 = chartPoint.y;
            }
            return chartPoint.copy(i, j, f, f2);
        }

        public final int component1() {
            return this.index;
        }

        public final long component2() {
            return this.value;
        }

        public final float component3() {
            return this.x;
        }

        public final float component4() {
            return this.y;
        }

        public final ChartPoint copy(int i, long j, float f, float f2) {
            return new ChartPoint(i, j, f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChartPoint) {
                ChartPoint chartPoint = (ChartPoint) obj;
                return this.index == chartPoint.index && this.value == chartPoint.value && Float.compare(this.x, chartPoint.x) == 0 && Float.compare(this.y, chartPoint.y) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.index) * 31) + Long.hashCode(this.value)) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y);
        }

        public String toString() {
            int i = this.index;
            long j = this.value;
            float f = this.x;
            return "ChartPoint(index=" + i + ", value=" + j + ", x=" + f + ", y=" + this.y + ")";
        }

        public ChartPoint(int i, long j, float f, float f2) {
            this.index = i;
            this.value = j;
            this.x = f;
            this.y = f2;
        }

        public final int getIndex() {
            return this.index;
        }

        public final long getValue() {
            return this.value;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }
    }
}
