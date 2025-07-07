package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: AnimatedVisibility.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0014\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00190\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "hasLookaheadOccurred", "", "getHasLookaheadOccurred", "()Z", "setHasLookaheadOccurred", "(Z)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private boolean hasLookaheadOccurred;
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        this.scope = animatedVisibilityScopeImpl;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    public final void setHasLookaheadOccurred(boolean z) {
        this.hasLookaheadOccurred = z;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable mo5438measureBRTryo0 = list.get(i3).mo5438measureBRTryo0(j);
            i = Math.max(i, mo5438measureBRTryo0.getWidth());
            i2 = Math.max(i2, mo5438measureBRTryo0.getHeight());
            arrayList.add(mo5438measureBRTryo0);
        }
        final ArrayList arrayList2 = arrayList;
        if (measureScope.isLookingAhead()) {
            this.hasLookaheadOccurred = true;
            this.scope.getTargetSize$animation_release().setValue(IntSize.m6847boximpl(IntSize.m6850constructorimpl((4294967295L & i2) | (i << 32))));
        } else if (!this.hasLookaheadOccurred) {
            this.scope.getTargetSize$animation_release().setValue(IntSize.m6847boximpl(IntSize.m6850constructorimpl((4294967295L & i2) | (i << 32))));
        }
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
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
                int size2 = list2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Placeable.PlacementScope.place$default(placementScope, list2.get(i4), 0, 0, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int minIntrinsicWidth = list.get(0).minIntrinsicWidth(i);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int minIntrinsicWidth2 = list.get(i2).minIntrinsicWidth(i);
                if (minIntrinsicWidth2 > minIntrinsicWidth) {
                    minIntrinsicWidth = minIntrinsicWidth2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return minIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int minIntrinsicHeight = list.get(0).minIntrinsicHeight(i);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int minIntrinsicHeight2 = list.get(i2).minIntrinsicHeight(i);
                if (minIntrinsicHeight2 > minIntrinsicHeight) {
                    minIntrinsicHeight = minIntrinsicHeight2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return minIntrinsicHeight;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int maxIntrinsicWidth = list.get(0).maxIntrinsicWidth(i);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int maxIntrinsicWidth2 = list.get(i2).maxIntrinsicWidth(i);
                if (maxIntrinsicWidth2 > maxIntrinsicWidth) {
                    maxIntrinsicWidth = maxIntrinsicWidth2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return maxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int maxIntrinsicHeight = list.get(0).maxIntrinsicHeight(i);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int maxIntrinsicHeight2 = list.get(i2).maxIntrinsicHeight(i);
                if (maxIntrinsicHeight2 > maxIntrinsicHeight) {
                    maxIntrinsicHeight = maxIntrinsicHeight2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return maxIntrinsicHeight;
    }
}
