package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: Padding.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    public PaddingValuesModifier(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float mo688calculateLeftPaddingu2uoSUM = this.paddingValues.mo688calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection());
        float mo690calculateTopPaddingD9Ej5fM = this.paddingValues.mo690calculateTopPaddingD9Ej5fM();
        float mo689calculateRightPaddingu2uoSUM = this.paddingValues.mo689calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection());
        float mo687calculateBottomPaddingD9Ej5fM = this.paddingValues.mo687calculateBottomPaddingD9Ej5fM();
        float f = 0;
        if (!((Dp.m6683compareTo0680j_4(mo687calculateBottomPaddingD9Ej5fM, Dp.m6684constructorimpl(f)) >= 0) & (Dp.m6683compareTo0680j_4(mo688calculateLeftPaddingu2uoSUM, Dp.m6684constructorimpl(f)) >= 0) & (Dp.m6683compareTo0680j_4(mo690calculateTopPaddingD9Ej5fM, Dp.m6684constructorimpl(f)) >= 0) & (Dp.m6683compareTo0680j_4(mo689calculateRightPaddingu2uoSUM, Dp.m6684constructorimpl(f)) >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        final int i = measureScope.mo383roundToPx0680j_4(mo688calculateLeftPaddingu2uoSUM);
        int i2 = measureScope.mo383roundToPx0680j_4(mo689calculateRightPaddingu2uoSUM) + i;
        final int i3 = measureScope.mo383roundToPx0680j_4(mo690calculateTopPaddingD9Ej5fM);
        int i4 = measureScope.mo383roundToPx0680j_4(mo687calculateBottomPaddingD9Ej5fM) + i3;
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(ConstraintsKt.m6656offsetNN6EwU(j, -i2, -i4));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m6654constrainWidthK40F9xA(j, mo5438measureBRTryo0.getWidth() + i2), ConstraintsKt.m6653constrainHeightK40F9xA(j, mo5438measureBRTryo0.getHeight() + i4), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, i, i3, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
