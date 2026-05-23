package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowInsetsSize.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/DerivedHeightModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "heightCalc", "Landroidx/compose/foundation/layout/WindowInsetsHeightCalculator;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsetsHeightCalculator;)V", "heightInsets", "calculateInsets", "ancestorConsumedInsets", "insetsInvalidated", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
final class DerivedHeightModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    private WindowInsetsHeightCalculator heightCalc;
    private WindowInsets heightInsets = WindowInsetsKt.WindowInsets();
    private WindowInsets insets;

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public WindowInsets calculateInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public DerivedHeightModifierNode(WindowInsets windowInsets, WindowInsetsHeightCalculator windowInsetsHeightCalculator) {
        this.insets = windowInsets;
        this.heightCalc = windowInsetsHeightCalculator;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public void insetsInvalidated() {
        this.heightInsets = WindowInsetsKt.exclude(this.insets, getAncestorConsumedInsets());
        super.insetsInvalidated();
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    public final void update(WindowInsets windowInsets, WindowInsetsHeightCalculator windowInsetsHeightCalculator) {
        if (Intrinsics.areEqual(this.insets, windowInsets) && windowInsetsHeightCalculator == this.heightCalc) {
            return;
        }
        this.insets = windowInsets;
        this.heightCalc = windowInsetsHeightCalculator;
        this.heightInsets = WindowInsetsKt.exclude(windowInsets, getAncestorConsumedInsets());
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo69measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int calculate = this.heightCalc.calculate(this.heightInsets, measureScope);
        if (calculate == 0) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.foundation.layout.DerivedHeightModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, 4, null);
        }
        final Placeable mo6818measureBRTryo0 = measurable.mo6818measureBRTryo0(Constraints.m8103copyZbe2FdA$default(j, 0, 0, calculate, calculate, 3, null));
        return MeasureScope.layout$default(measureScope, mo6818measureBRTryo0.getWidth(), calculate, null, new Function1() { // from class: androidx.compose.foundation.layout.DerivedHeightModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DerivedHeightModifierNode.measure_3p2s80s$lambda$1(Placeable.this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
