package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Snackbar.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnackbarKt$OneRowSnackbar$2$1(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        float f;
        Measurable measurable;
        Measurable measurable2;
        int i;
        float f2;
        int i2;
        int max;
        int height;
        int i3;
        float f3;
        MeasureScope measureScope2 = measureScope;
        int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j);
        f = SnackbarKt.ContainerMaxWidth;
        int min = Math.min(m7508getMaxWidthimpl, measureScope2.mo399roundToPx0680j_4(f));
        String str = this.$actionTag;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                break;
            }
            i4++;
        }
        Measurable measurable3 = measurable;
        Placeable mo6216measureBRTryo0 = measurable3 != null ? measurable3.mo6216measureBRTryo0(j) : null;
        String str2 = this.$dismissActionTag;
        int size2 = list2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                break;
            }
            i5++;
        }
        Measurable measurable4 = measurable2;
        final Placeable mo6216measureBRTryo02 = measurable4 != null ? measurable4.mo6216measureBRTryo0(j) : null;
        int width = mo6216measureBRTryo0 != null ? mo6216measureBRTryo0.getWidth() : 0;
        int height2 = mo6216measureBRTryo0 != null ? mo6216measureBRTryo0.getHeight() : 0;
        int width2 = mo6216measureBRTryo02 != null ? mo6216measureBRTryo02.getWidth() : 0;
        int height3 = mo6216measureBRTryo02 != null ? mo6216measureBRTryo02.getHeight() : 0;
        if (width2 == 0) {
            f3 = SnackbarKt.TextEndExtraSpacing;
            i = measureScope2.mo399roundToPx0680j_4(f3);
        } else {
            i = 0;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(((min - width) - width2) - i, Constraints.m7510getMinWidthimpl(j));
        String str3 = this.$textTag;
        int size3 = list2.size();
        int i6 = 0;
        while (i6 < size3) {
            Measurable measurable5 = list.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str3)) {
                int i7 = height3;
                final Placeable mo6216measureBRTryo03 = measurable5.mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(j, 0, coerceAtLeast, 0, 0, 9, null));
                int i8 = mo6216measureBRTryo03.get(AlignmentLineKt.getFirstBaseline());
                int i9 = mo6216measureBRTryo03.get(AlignmentLineKt.getLastBaseline());
                boolean z = true;
                boolean z2 = (i8 == Integer.MIN_VALUE || i9 == Integer.MIN_VALUE) ? false : true;
                if (i8 != i9 && z2) {
                    z = false;
                }
                final int i10 = min - width2;
                final int i11 = i10 - width;
                if (!z) {
                    f2 = SnackbarKt.HeightToFirstLine;
                    i2 = measureScope2.mo399roundToPx0680j_4(f2) - i8;
                    max = Math.max(measureScope2.mo399roundToPx0680j_4(SnackbarTokens.INSTANCE.m3745getTwoLinesContainerHeightD9Ej5fM()), mo6216measureBRTryo03.getHeight() + i2);
                    if (mo6216measureBRTryo0 != null) {
                        height = (max - mo6216measureBRTryo0.getHeight()) / 2;
                    }
                    height = 0;
                } else {
                    max = Math.max(measureScope2.mo399roundToPx0680j_4(SnackbarTokens.INSTANCE.m3744getSingleLineContainerHeightD9Ej5fM()), Math.max(height2, i7));
                    i2 = (max - mo6216measureBRTryo03.getHeight()) / 2;
                    if (mo6216measureBRTryo0 != null && (i3 = mo6216measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) != Integer.MIN_VALUE) {
                        height = (i8 + i2) - i3;
                    }
                    height = 0;
                }
                final int i12 = height;
                int i13 = max;
                final int i14 = i2;
                final int height4 = mo6216measureBRTryo02 != null ? (i13 - mo6216measureBRTryo02.getHeight()) / 2 : 0;
                final Placeable placeable = mo6216measureBRTryo0;
                return MeasureScope.layout$default(measureScope2, min, i13, null, new Function1() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SnackbarKt$OneRowSnackbar$2$1.measure_3p2s80s$lambda$4(Placeable.this, i14, mo6216measureBRTryo02, i10, height4, placeable, i11, i12, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
            i6++;
            height3 = height3;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$4(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable placeable3, int i4, int i5, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i3, 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i4, i5, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
