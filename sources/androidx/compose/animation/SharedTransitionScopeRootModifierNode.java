package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SharedTransitionScope.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\f\u0010\u001b\u001a\u00020\u000b*\u00020\u001cH\u0016R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\t¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeRootModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "onAttach", "", "onDetach", "newScope", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "onObservedReadsChanged", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
final class SharedTransitionScopeRootModifierNode extends Modifier.Node implements LayoutModifierNode, ObserverModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode {
    private SharedTransitionScopeImpl sharedScope;

    public SharedTransitionScopeRootModifierNode(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.sharedScope = sharedTransitionScopeImpl;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ObserverModifierNodeKt.observeReads(this, this.sharedScope.getObserveAnimatingBlock$animation());
        this.sharedScope.setInvalidateOverlay(new Function0<Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeRootModifierNode$onAttach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DrawModifierNodeKt.invalidateDraw(SharedTransitionScopeRootModifierNode.this);
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.sharedScope.setInvalidateOverlay(null);
    }

    public final SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    public final void setSharedScope(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        if (!Intrinsics.areEqual(sharedTransitionScopeImpl, this.sharedScope)) {
            ObserverModifierNodeKt.observeReads(this, sharedTransitionScopeImpl.getObserveAnimatingBlock$animation());
        }
        this.sharedScope = sharedTransitionScopeImpl;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo69measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6818measureBRTryo0 = measurable.mo6818measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo6818measureBRTryo0.getWidth(), mo6818measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeRootModifierNode$measure$1
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
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    boolean isLookingAhead = MeasureScope.this.isLookingAhead();
                    SharedTransitionScopeRootModifierNode sharedTransitionScopeRootModifierNode = this;
                    if (!isLookingAhead) {
                        sharedTransitionScopeRootModifierNode.getSharedScope().setRoot$animation(coordinates);
                        if (IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() && ((LookaheadAnimationVisualDebugConfig) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig())).isEnabled()) {
                            if (this.getSharedScope().getLookaheadAnimationVisualDebugHelper$animation() == null) {
                                this.getSharedScope().setLookaheadAnimationVisualDebugHelper$animation(new LookaheadAnimationVisualDebugHelper());
                            }
                            LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper$animation = this.getSharedScope().getLookaheadAnimationVisualDebugHelper$animation();
                            Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper$animation);
                            lookaheadAnimationVisualDebugHelper$animation.m134updateDrawingCoordinatesCowoxoA$animation(LayoutCoordinatesKt.positionInRoot(LayoutCoordinatesKt.findRootCoordinates(coordinates)), this.getSharedScope().getLookaheadRoot$animation().mo6826getSizeYbymL2g());
                        }
                    } else {
                        sharedTransitionScopeRootModifierNode.getSharedScope().setLookaheadRoot$animation(coordinates);
                    }
                }
                Placeable.PlacementScope.place$default(placementScope, mo6818measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        this.sharedScope.updateTransitionActiveness$animation();
        ObserverModifierNodeKt.observeReads(this, this.sharedScope.getObserveAnimatingBlock$animation());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled()) {
            LookaheadAnimationVisualDebugConfig lookaheadAnimationVisualDebugConfig = (LookaheadAnimationVisualDebugConfig) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig());
            if (lookaheadAnimationVisualDebugConfig.isEnabled() && this.sharedScope.isTransitionActive()) {
                LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper$animation = this.sharedScope.getLookaheadAnimationVisualDebugHelper$animation();
                Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper$animation);
                lookaheadAnimationVisualDebugHelper$animation.m126drawOverlay4WTKRHQ$animation(contentDrawScope, lookaheadAnimationVisualDebugConfig.m117getOverlayColor0d7_KjU());
            }
            this.sharedScope.drawInOverlay$animation(contentDrawScope);
            if (lookaheadAnimationVisualDebugConfig.isEnabled() && this.sharedScope.isTransitionActive()) {
                LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper$animation2 = this.sharedScope.getLookaheadAnimationVisualDebugHelper$animation();
                Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper$animation2);
                lookaheadAnimationVisualDebugHelper$animation2.drawGlobalVisualizations$animation(contentDrawScope);
                return;
            }
            return;
        }
        this.sharedScope.drawInOverlay$animation(contentDrawScope);
    }
}
