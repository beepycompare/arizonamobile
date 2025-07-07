package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: RootMeasurePolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final int $stable = 0;
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                final Placeable mo5438measureBRTryo0 = list.get(0).mo5438measureBRTryo0(j);
                return MeasureScope.layout$default(measureScope, ConstraintsKt.m6654constrainWidthK40F9xA(j, mo5438measureBRTryo0.getWidth()), ConstraintsKt.m6653constrainHeightK40F9xA(j, mo5438measureBRTryo0.getHeight()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, Placeable.this, 0, 0, 0.0f, (Function1) null, 12, (Object) null);
                    }
                }, 4, null);
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                Placeable mo5438measureBRTryo02 = list.get(i3).mo5438measureBRTryo0(j);
                i = Math.max(mo5438measureBRTryo02.getWidth(), i);
                i2 = Math.max(mo5438measureBRTryo02.getHeight(), i2);
                arrayList.add(mo5438measureBRTryo02);
            }
            final ArrayList arrayList2 = arrayList;
            return MeasureScope.layout$default(measureScope, ConstraintsKt.m6654constrainWidthK40F9xA(j, i), ConstraintsKt.m6653constrainHeightK40F9xA(j, i2), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$3
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
                    List<Placeable> list2 = arrayList2;
                    int size3 = list2.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, list2.get(i4), 0, 0, 0.0f, (Function1) null, 12, (Object) null);
                    }
                }
            }, 4, null);
        }
        return MeasureScope.layout$default(measureScope, Constraints.m6639getMinWidthimpl(j), Constraints.m6638getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$1
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
}
