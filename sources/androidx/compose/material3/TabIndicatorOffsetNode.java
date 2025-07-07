package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/material3/TabIndicatorOffsetNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "(Landroidx/compose/runtime/State;IZ)V", "getFollowContentSize", "()Z", "setFollowContentSize", "(Z)V", "initialOffset", "Landroidx/compose/ui/unit/Dp;", "initialWidth", "offsetAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSelectedTabIndex", "()I", "setSelectedTabIndex", "(I)V", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "setTabPositionsState", "(Landroidx/compose/runtime/State;)V", "widthAnimatable", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabIndicatorOffsetNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private boolean followContentSize;
    private Dp initialOffset;
    private Dp initialWidth;
    private Animatable<Dp, AnimationVector1D> offsetAnimatable;
    private int selectedTabIndex;
    private State<? extends List<TabPosition>> tabPositionsState;
    private Animatable<Dp, AnimationVector1D> widthAnimatable;

    public final State<List<TabPosition>> getTabPositionsState() {
        return this.tabPositionsState;
    }

    public final void setTabPositionsState(State<? extends List<TabPosition>> state) {
        this.tabPositionsState = state;
    }

    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final void setSelectedTabIndex(int i) {
        this.selectedTabIndex = i;
    }

    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    public final void setFollowContentSize(boolean z) {
        this.followContentSize = z;
    }

    public TabIndicatorOffsetNode(State<? extends List<TabPosition>> state, int i, boolean z) {
        this.tabPositionsState = state;
        this.selectedTabIndex = i;
        this.followContentSize = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        float m2389getWidthD9Ej5fM;
        if (this.tabPositionsState.getValue().isEmpty()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabIndicatorOffsetNode$measure$1
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
        if (this.followContentSize) {
            m2389getWidthD9Ej5fM = this.tabPositionsState.getValue().get(this.selectedTabIndex).m2386getContentWidthD9Ej5fM();
        } else {
            m2389getWidthD9Ej5fM = this.tabPositionsState.getValue().get(this.selectedTabIndex).m2389getWidthD9Ej5fM();
        }
        if (this.initialWidth != null) {
            Animatable<Dp, AnimationVector1D> animatable = this.widthAnimatable;
            if (animatable == null) {
                Dp dp = this.initialWidth;
                Intrinsics.checkNotNull(dp);
                Animatable<Dp, AnimationVector1D> animatable2 = new Animatable<>(dp, VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
                this.widthAnimatable = animatable2;
                animatable = animatable2;
            }
            if (!Dp.m6689equalsimpl0(m2389getWidthD9Ej5fM, animatable.getTargetValue().m6698unboximpl())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$2(animatable, m2389getWidthD9Ej5fM, null), 3, null);
            }
        } else {
            this.initialWidth = Dp.m6682boximpl(m2389getWidthD9Ej5fM);
        }
        float m2387getLeftD9Ej5fM = this.tabPositionsState.getValue().get(this.selectedTabIndex).m2387getLeftD9Ej5fM();
        if (this.initialOffset != null) {
            Animatable<Dp, AnimationVector1D> animatable3 = this.offsetAnimatable;
            if (animatable3 == null) {
                Dp dp2 = this.initialOffset;
                Intrinsics.checkNotNull(dp2);
                Animatable<Dp, AnimationVector1D> animatable4 = new Animatable<>(dp2, VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
                this.offsetAnimatable = animatable4;
                animatable3 = animatable4;
            }
            if (!Dp.m6689equalsimpl0(m2387getLeftD9Ej5fM, animatable3.getTargetValue().m6698unboximpl())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$3(animatable3, m2387getLeftD9Ej5fM, null), 3, null);
            }
        } else {
            this.initialOffset = Dp.m6682boximpl(m2387getLeftD9Ej5fM);
        }
        if (measureScope.getLayoutDirection() == LayoutDirection.Ltr) {
            Animatable<Dp, AnimationVector1D> animatable5 = this.offsetAnimatable;
            if (animatable5 != null) {
                m2387getLeftD9Ej5fM = animatable5.getValue().m6698unboximpl();
            }
        } else {
            Animatable<Dp, AnimationVector1D> animatable6 = this.offsetAnimatable;
            if (animatable6 != null) {
                m2387getLeftD9Ej5fM = animatable6.getValue().m6698unboximpl();
            }
            m2387getLeftD9Ej5fM = Dp.m6684constructorimpl(-m2387getLeftD9Ej5fM);
        }
        Animatable<Dp, AnimationVector1D> animatable7 = this.widthAnimatable;
        if (animatable7 != null) {
            m2389getWidthD9Ej5fM = animatable7.getValue().m6698unboximpl();
        }
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j, measureScope.mo383roundToPx0680j_4(m2389getWidthD9Ej5fM), measureScope.mo383roundToPx0680j_4(m2389getWidthD9Ej5fM), 0, 0, 12, null));
        final float f = m2387getLeftD9Ej5fM;
        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabIndicatorOffsetNode$measure$4
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
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, measureScope.mo383roundToPx0680j_4(f), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
