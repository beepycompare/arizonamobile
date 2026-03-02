package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicText.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;
    private final Function0<Boolean> shouldMeasureLinks;

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<Boolean> function0, Function0<? extends List<Rect>> function02) {
        this.shouldMeasureLinks = function0;
        this.placements = function02;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final ArrayList arrayList;
        final List measureWithTextRangeMeasureConstraints;
        Pair pair;
        ArrayList arrayList2 = new ArrayList(list.size());
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (!(measurable.getParentData() instanceof TextRangeLayoutModifier)) {
                arrayList2.add(measurable);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List<Rect> invoke = this.placements.invoke();
        if (invoke != null) {
            ArrayList arrayList4 = new ArrayList(invoke.size());
            int size2 = invoke.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Rect rect = invoke.get(i2);
                if (rect != null) {
                    Placeable mo6216measureBRTryo0 = ((Measurable) arrayList3.get(i2)).mo6216measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getRight() - rect.getLeft()), 0, (int) Math.floor(rect.getBottom() - rect.getTop()), 5, null));
                    int round = Math.round(rect.getLeft());
                    pair = new Pair(mo6216measureBRTryo0, IntOffset.m7674boximpl(IntOffset.m7677constructorimpl((Math.round(rect.getTop()) & 4294967295L) | (round << 32))));
                } else {
                    pair = null;
                }
                if (pair != null) {
                    arrayList4.add(pair);
                }
            }
            arrayList = arrayList4;
        } else {
            arrayList = null;
        }
        ArrayList arrayList5 = new ArrayList(list.size());
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Measurable measurable2 = list.get(i3);
            if (measurable2.getParentData() instanceof TextRangeLayoutModifier) {
                arrayList5.add(measurable2);
            }
        }
        measureWithTextRangeMeasureConstraints = BasicTextKt.measureWithTextRangeMeasureConstraints(arrayList5, this.shouldMeasureLinks);
        return MeasureScope.layout$default(measureScope, Constraints.m7508getMaxWidthimpl(j), Constraints.m7507getMaxHeightimpl(j), null, new Function1() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextMeasurePolicy.measure_3p2s80s$lambda$3(arrayList, measureWithTextRangeMeasureConstraints, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$3(List list, List list2, Placeable.PlacementScope placementScope) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Pair pair = (Pair) list.get(i);
                Placeable.PlacementScope.m6282place70tqf50$default(placementScope, (Placeable) pair.component1(), ((IntOffset) pair.component2()).m7692unboximpl(), 0.0f, 2, null);
            }
        }
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Pair pair2 = (Pair) list2.get(i2);
                Placeable placeable = (Placeable) pair2.component1();
                Function0 function0 = (Function0) pair2.component2();
                Placeable.PlacementScope.m6282place70tqf50$default(placementScope, placeable, function0 != null ? ((IntOffset) function0.invoke()).m7692unboximpl() : IntOffset.Companion.m7694getZeronOccac(), 0.0f, 2, null);
            }
        }
        return Unit.INSTANCE;
    }
}
