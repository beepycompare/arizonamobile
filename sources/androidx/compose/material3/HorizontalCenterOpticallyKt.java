package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: HorizontalCenterOptically.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"horizontalCenterOptically", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "maxStartOffset", "Landroidx/compose/ui/unit/Dp;", "maxEndOffset", "horizontalCenterOptically-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/shape/CornerBasedShape;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ShapeWithHorizontalCenterOptically;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ShapeWithHorizontalCenterOptically;FF)Landroidx/compose/ui/Modifier;", "CenterOpticallyCoefficient", "", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HorizontalCenterOpticallyKt {
    public static final float CenterOpticallyCoefficient = 0.11f;

    /* renamed from: horizontalCenterOptically-4j6BHR0  reason: not valid java name */
    public static final Modifier m2500horizontalCenterOptically4j6BHR0(Modifier modifier, final CornerBasedShape cornerBasedShape, final float f, final float f2) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.HorizontalCenterOpticallyKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                MeasureResult horizontalCenterOptically_4j6BHR0$lambda$1;
                horizontalCenterOptically_4j6BHR0$lambda$1 = HorizontalCenterOpticallyKt.horizontalCenterOptically_4j6BHR0$lambda$1(f, f2, cornerBasedShape, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                return horizontalCenterOptically_4j6BHR0$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult horizontalCenterOptically_4j6BHR0$lambda$1(float f, float f2, CornerBasedShape cornerBasedShape, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable mo6875measureBRTryo0 = measurable.mo6875measureBRTryo0(constraints.m8217unboximpl());
        int width = mo6875measureBRTryo0.getWidth();
        int height = mo6875measureBRTryo0.getHeight();
        long m5239constructorimpl = Size.m5239constructorimpl((Float.floatToRawIntBits(width) << 32) | (Float.floatToRawIntBits(height) & 4294967295L));
        final float f3 = -measureScope.mo464toPx0680j_4(f);
        final float f4 = measureScope.mo464toPx0680j_4(f2);
        MeasureScope measureScope2 = measureScope;
        float mo1274toPxTmRCtEA = cornerBasedShape.getTopStart().mo1274toPxTmRCtEA(m5239constructorimpl, measureScope2);
        float mo1274toPxTmRCtEA2 = cornerBasedShape.getTopEnd().mo1274toPxTmRCtEA(m5239constructorimpl, measureScope2);
        float mo1274toPxTmRCtEA3 = cornerBasedShape.getBottomStart().mo1274toPxTmRCtEA(m5239constructorimpl, measureScope2);
        float mo1274toPxTmRCtEA4 = cornerBasedShape.getBottomEnd().mo1274toPxTmRCtEA(m5239constructorimpl, measureScope2);
        float f5 = 2;
        final float f6 = (((mo1274toPxTmRCtEA + mo1274toPxTmRCtEA3) / f5) - ((mo1274toPxTmRCtEA2 + mo1274toPxTmRCtEA4) / f5)) * 0.11f;
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.material3.HorizontalCenterOpticallyKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0;
                horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0 = HorizontalCenterOpticallyKt.horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0(f6, f3, f4, mo6875measureBRTryo0, (Placeable.PlacementScope) obj);
                return horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0(float f, float f2, float f3, Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, MathKt.roundToInt(RangesKt.coerceIn(f, f2, f3)), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* renamed from: horizontalCenterOptically-4j6BHR0  reason: not valid java name */
    public static final Modifier m2501horizontalCenterOptically4j6BHR0(Modifier modifier, final ShapeWithHorizontalCenterOptically shapeWithHorizontalCenterOptically, final float f, final float f2) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.HorizontalCenterOpticallyKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                MeasureResult horizontalCenterOptically_4j6BHR0$lambda$3;
                horizontalCenterOptically_4j6BHR0$lambda$3 = HorizontalCenterOpticallyKt.horizontalCenterOptically_4j6BHR0$lambda$3(f, f2, shapeWithHorizontalCenterOptically, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                return horizontalCenterOptically_4j6BHR0$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult horizontalCenterOptically_4j6BHR0$lambda$3(float f, float f2, final ShapeWithHorizontalCenterOptically shapeWithHorizontalCenterOptically, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable mo6875measureBRTryo0 = measurable.mo6875measureBRTryo0(constraints.m8217unboximpl());
        int width = mo6875measureBRTryo0.getWidth();
        int height = mo6875measureBRTryo0.getHeight();
        final float f3 = -measureScope.mo464toPx0680j_4(f);
        final float f4 = measureScope.mo464toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.material3.HorizontalCenterOpticallyKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2;
                horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2 = HorizontalCenterOpticallyKt.horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2(ShapeWithHorizontalCenterOptically.this, f3, f4, mo6875measureBRTryo0, (Placeable.PlacementScope) obj);
                return horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2(ShapeWithHorizontalCenterOptically shapeWithHorizontalCenterOptically, float f, float f2, Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, MathKt.roundToInt(RangesKt.coerceIn(shapeWithHorizontalCenterOptically.offset(), f, f2)), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* renamed from: horizontalCenterOptically-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2502horizontalCenterOptically4j6BHR0$default(Modifier modifier, CornerBasedShape cornerBasedShape, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.m8258constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f2 = Dp.m8258constructorimpl(0);
        }
        return m2500horizontalCenterOptically4j6BHR0(modifier, cornerBasedShape, f, f2);
    }

    /* renamed from: horizontalCenterOptically-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2503horizontalCenterOptically4j6BHR0$default(Modifier modifier, ShapeWithHorizontalCenterOptically shapeWithHorizontalCenterOptically, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.m8258constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f2 = Dp.m8258constructorimpl(0);
        }
        return m2501horizontalCenterOptically4j6BHR0(modifier, shapeWithHorizontalCenterOptically, f, f2);
    }
}
