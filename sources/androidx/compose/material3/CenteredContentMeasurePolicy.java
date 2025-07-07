package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpressiveNavigationBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CenteredContentMeasurePolicy implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int calculateCenteredContentHorizontalPadding;
        final ArrayList arrayList;
        int i;
        int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
        int m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(j);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, m6637getMaxWidthimpl, m6638getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$measure$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int i2 = 0;
        if (Constraints.m6633getHasBoundedWidthimpl(j)) {
            int i3 = m6637getMaxWidthimpl / size;
            calculateCenteredContentHorizontalPadding = ExpressiveNavigationBarKt.calculateCenteredContentHorizontalPadding(size, m6637getMaxWidthimpl);
            intRef.element = calculateCenteredContentHorizontalPadding;
            int i4 = (m6637getMaxWidthimpl - (intRef.element * 2)) / size;
            int size2 = list.size();
            for (int i5 = 0; i5 < size2; i5++) {
                int maxIntrinsicHeight = list.get(i5).maxIntrinsicHeight(i4);
                if (m6638getMinHeightimpl < maxIntrinsicHeight) {
                    m6638getMinHeightimpl = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.m6636getMaxHeightimpl(j));
                }
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            int size3 = list.size();
            while (i2 < size3) {
                ArrayList arrayList3 = arrayList2;
                Measurable measurable = list.get(i2);
                int maxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m6638getMinHeightimpl(j));
                if (i4 < maxIntrinsicWidth) {
                    i = RangesKt.coerceAtMost(maxIntrinsicWidth, i3);
                    intRef.element -= (i - i4) / 2;
                } else {
                    i = i4;
                }
                arrayList3.add(measurable.mo5438measureBRTryo0(ConstraintsKt.m6652constrainN9IONVI(j, Constraints.Companion.m6647fixedJhjzzOo(i, m6638getMinHeightimpl))));
                i2++;
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList4 = new ArrayList(list.size());
            int size4 = list.size();
            while (i2 < size4) {
                arrayList4.add(list.get(i2).mo5438measureBRTryo0(ConstraintsKt.m6652constrainN9IONVI(j, Constraints.Companion.m6648fixedHeightOenEA2s(m6638getMinHeightimpl))));
                i2++;
            }
            arrayList = arrayList4;
        }
        return MeasureScope.layout$default(measureScope, m6637getMaxWidthimpl, m6638getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$measure$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                int i6 = Ref.IntRef.this.element;
                List<Placeable> list2 = arrayList;
                int size5 = list2.size();
                int i7 = 0;
                int i8 = i6;
                while (i7 < size5) {
                    Placeable placeable = list2.get(i7);
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, i8, 0, 0.0f, 4, null);
                    i8 += placeable.getWidth();
                    i7++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
