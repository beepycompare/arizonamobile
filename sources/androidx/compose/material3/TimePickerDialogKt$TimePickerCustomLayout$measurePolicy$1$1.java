package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* compiled from: TimePickerDialog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 INSTANCE = new TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1();

    TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$3(boolean z, int i, Placeable placeable, int i2, Placeable placeable2, int i3, int i4, int i5, MeasureScope measureScope, Placeable placeable3, int i6, int i7, int i8, int i9, Placeable.PlacementScope placementScope) {
        if (z) {
            int height = i4 - ((((i + placeable.getHeight()) + i2) + placeable2.getHeight()) + i3);
            int i10 = i4 >= i5 ? measureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(16.0f)) : 0;
            Placeable.PlacementScope.place$default(placementScope, placeable3, i6, i6, 0.0f, 4, null);
            int i11 = height / 2;
            int i12 = i + i11;
            Placeable.PlacementScope.place$default(placementScope, placeable, i7, i12, 0.0f, 4, null);
            Placeable.PlacementScope.place$default(placementScope, placeable2, i7, (((i12 + placeable.getHeight()) + i2) - i10) + i11, 0.0f, 4, null);
        } else {
            Placeable.PlacementScope.place$default(placementScope, placeable3, i6, i8, 0.0f, 4, null);
            int height2 = i8 + placeable3.getHeight();
            Placeable.PlacementScope.place$default(placementScope, placeable, (i9 - placeable.getWidth()) / 2, height2, 0.0f, 4, null);
            Placeable.PlacementScope.place$default(placementScope, placeable2, (i9 - placeable2.getWidth()) / 2, height2 + placeable.getHeight(), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo41measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        boolean z;
        int width;
        int height;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "title")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "timePickerContent")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "actions")) {
                                final int i5 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(24.0f));
                                final int i6 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(384.0f));
                                final int i7 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(24.0f));
                                final int i8 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(16.0f));
                                final int i9 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(4.0f));
                                final int i10 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(8.0f));
                                final int i11 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(24.0f));
                                int i12 = measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(24.0f));
                                final Placeable mo6216measureBRTryo0 = measurable2.mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                if (mo6216measureBRTryo0.getWidth() <= mo6216measureBRTryo0.getHeight() || mo6216measureBRTryo0.getHeight() < MathKt.truncate(measureScope2.mo405toPx0680j_4(TimePickerKt.getClockDialMinContainerSize()))) {
                                    i = i12;
                                    z = false;
                                } else {
                                    i = i12;
                                    z = true;
                                }
                                if (z) {
                                    width = mo6216measureBRTryo0.getWidth();
                                } else {
                                    width = mo6216measureBRTryo0.getWidth();
                                }
                                final int i13 = width + (i5 * 2);
                                final boolean z2 = z;
                                final Placeable mo6216measureBRTryo02 = measurable3.mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(j, 0, mo6216measureBRTryo0.getWidth(), 0, 0, 8, null));
                                final Placeable mo6216measureBRTryo03 = measurable.mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(j, 0, mo6216measureBRTryo0.getWidth(), 0, 0, 8, null));
                                if (z2) {
                                    height = mo6216measureBRTryo0.getHeight() + mo6216measureBRTryo02.getHeight() + i10 + i8 + i9;
                                    if (Constraints.m7503getHasBoundedHeightimpl(j)) {
                                        height = Constraints.m7507getMaxHeightimpl(j);
                                    }
                                } else {
                                    height = mo6216measureBRTryo03.getHeight() + i11 + mo6216measureBRTryo0.getHeight() + mo6216measureBRTryo02.getHeight() + i;
                                }
                                final int i14 = height;
                                return MeasureScope.layout$default(measureScope, i13, i14, null, new Function1() { // from class: androidx.compose.material3.TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1.measure_3p2s80s$lambda$3(z2, i8, mo6216measureBRTryo0, i9, mo6216measureBRTryo02, i10, i14, i6, measureScope, mo6216measureBRTryo03, i7, i5, i11, i13, (Placeable.PlacementScope) obj);
                                    }
                                }, 4, null);
                            }
                            i4++;
                            measureScope2 = measureScope;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i3++;
                    measureScope2 = measureScope;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i2++;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
