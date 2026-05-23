package coil3.compose.internal;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: utils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class UtilsKt$UseMinConstraintsMeasurePolicy$1 implements MeasurePolicy {
    public static final UtilsKt$UseMinConstraintsMeasurePolicy$1 INSTANCE = new UtilsKt$UseMinConstraintsMeasurePolicy$1();

    UtilsKt$UseMinConstraintsMeasurePolicy$1() {
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.m8115getMinWidthimpl(j), Constraints.m8114getMinHeightimpl(j), null, new Function1() { // from class: coil3.compose.internal.UtilsKt$UseMinConstraintsMeasurePolicy$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 4, null);
    }
}
