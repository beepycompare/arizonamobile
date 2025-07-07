package com.androidplot.xy;

import android.graphics.RectF;
import com.androidplot.Region;
/* loaded from: classes3.dex */
public class XYStepCalculator {
    public static Step getStep(XYPlot xYPlot, Axis axis, RectF rectF) {
        int i = AnonymousClass1.$SwitchMap$com$androidplot$xy$Axis[axis.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return getStep(xYPlot.getRangeStepMode(), xYPlot.getRangeStepValue(), xYPlot.getBounds().getyRegion(), new Region(Float.valueOf(rectF.top), Float.valueOf(rectF.bottom)));
        }
        return getStep(xYPlot.getDomainStepMode(), xYPlot.getDomainStepValue(), xYPlot.getBounds().getxRegion(), new Region(Float.valueOf(rectF.left), Float.valueOf(rectF.right)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.xy.XYStepCalculator$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$Axis;
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$StepMode;

        static {
            int[] iArr = new int[StepMode.values().length];
            $SwitchMap$com$androidplot$xy$StepMode = iArr;
            try {
                iArr[StepMode.INCREMENT_BY_VAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$xy$StepMode[StepMode.INCREMENT_BY_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$androidplot$xy$StepMode[StepMode.INCREMENT_BY_PIXELS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$androidplot$xy$StepMode[StepMode.SUBDIVIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Axis.values().length];
            $SwitchMap$com$androidplot$xy$Axis = iArr2;
            try {
                iArr2[Axis.DOMAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$androidplot$xy$Axis[Axis.RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Step getStep(StepMode stepMode, double d, Region region, Region region2) {
        double doubleValue;
        double d2;
        double doubleValue2;
        double d3;
        int i = AnonymousClass1.$SwitchMap$com$androidplot$xy$StepMode[stepMode.ordinal()];
        if (i == 1 || i == 2) {
            doubleValue = d / region.ratio(region2).doubleValue();
            d2 = d;
            doubleValue2 = region2.length().doubleValue() / doubleValue;
        } else {
            if (i == 3) {
                d3 = d;
                doubleValue2 = region2.length().doubleValue() / d;
                d2 = region.ratio(region2).doubleValue() * d;
            } else if (i != 4) {
                doubleValue2 = 0.0d;
                d3 = 0.0d;
                d2 = 0.0d;
            } else {
                doubleValue = region2.length().doubleValue() / (d - 1.0d);
                doubleValue2 = d;
                d2 = region.ratio(region2).doubleValue() * doubleValue;
            }
            return new Step(doubleValue2, d3, d2);
        }
        d3 = doubleValue;
        return new Step(doubleValue2, d3, d2);
    }
}
