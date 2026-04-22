package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt$CircularLayout$1$1 implements MeasurePolicy {
    final /* synthetic */ float $radiusToSizeRatio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimePickerKt$CircularLayout$1$1(float f) {
        this.$radiusToSizeRatio = f;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        Measurable measurable2;
        final float m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(j) * this.$radiusToSizeRatio;
        int i = 0;
        long m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list.size());
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable3 = list.get(i2);
            Measurable measurable4 = measurable3;
            if (LayoutIdKt.getLayoutId(measurable4) != LayoutId.Selector && LayoutIdKt.getLayoutId(measurable4) != LayoutId.InnerCircle) {
                arrayList.add(measurable3);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList3.add(((Measurable) arrayList2.get(i3)).mo6216measureBRTryo0(m7498copyZbe2FdA$default));
        }
        final ArrayList arrayList4 = arrayList3;
        int size3 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                measurable = null;
                break;
            }
            measurable = list.get(i4);
            if (LayoutIdKt.getLayoutId(measurable) == LayoutId.Selector) {
                break;
            }
            i4++;
        }
        Measurable measurable5 = measurable;
        int size4 = list2.size();
        while (true) {
            if (i >= size4) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i);
            if (LayoutIdKt.getLayoutId(measurable2) == LayoutId.InnerCircle) {
                break;
            }
            i++;
        }
        Measurable measurable6 = measurable2;
        final float size5 = 6.2831855f / arrayList4.size();
        Placeable mo6216measureBRTryo0 = measurable5 != null ? measurable5.mo6216measureBRTryo0(m7498copyZbe2FdA$default) : null;
        final Placeable mo6216measureBRTryo02 = measurable6 != null ? measurable6.mo6216measureBRTryo0(m7498copyZbe2FdA$default) : null;
        final Placeable placeable = mo6216measureBRTryo0;
        return MeasureScope.layout$default(measureScope, Constraints.m7510getMinWidthimpl(j), Constraints.m7509getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt$CircularLayout$1$1.measure_3p2s80s$lambda$5(Placeable.this, arrayList4, mo6216measureBRTryo02, j, m7507getMaxHeightimpl, size5, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$5(Placeable placeable, List list, Placeable placeable2, long j, float f, float f2, Placeable.PlacementScope placementScope) {
        Placeable placeable3;
        if (placeable != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            double d = f;
            double d2 = (i * f2) - 1.5707963267948966d;
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i), MathKt.roundToInt((Math.cos(d2) * d) + ((Constraints.m7508getMaxWidthimpl(j) / 2) - (placeable3.getWidth() / 2))), MathKt.roundToInt((d * Math.sin(d2)) + ((Constraints.m7507getMaxHeightimpl(j) / 2) - (placeable3.getHeight() / 2))), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable2, (Constraints.m7510getMinWidthimpl(j) - placeable2.getWidth()) / 2, (Constraints.m7509getMinHeightimpl(j) - placeable2.getHeight()) / 2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
