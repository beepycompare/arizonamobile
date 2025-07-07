package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: SharedContentNode.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\u0016H\u0002J&\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0014\u00106\u001a\u00020.*\u0002072\u0006\u00108\u001a\u000209H\u0002J\f\u0010:\u001a\u00020)*\u00020;H\u0016J&\u0010<\u001a\u00020.*\u0002072\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\f\u0010?\u001a\u00020)*\u00020\u0016H\u0002R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/animation/SharedElementInternalState;", "(Landroidx/compose/animation/SharedElementInternalState;)V", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "value", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", AdRevenueConstants.LAYER_KEY, "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "rootCoords", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getRootCoords", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "rootLookaheadCoords", "getRootLookaheadCoords", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "getState", "()Landroidx/compose/animation/SharedElementInternalState;", "setState$animation_release", "isMeasurementApproachInProgress", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "onDetach", "onReset", "requireLookaheadLayoutCoordinates", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachPlace", "Landroidx/compose/ui/layout/MeasureScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measure", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "updateCurrentBounds", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementInternalState state;

    public SharedBoundsNode(SharedElementInternalState sharedElementInternalState) {
        this.state = sharedElementInternalState;
        this.layer = sharedElementInternalState.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getRootLookaheadCoords() {
        return getSharedElement().getScope().getLookaheadRoot$animation_release();
    }

    public final SharedElementInternalState getState() {
        return this.state;
    }

    public final void setState$animation_release(SharedElementInternalState sharedElementInternalState) {
        if (Intrinsics.areEqual(sharedElementInternalState, this.state)) {
            return;
        }
        this.state = sharedElementInternalState;
        if (isAttached()) {
            provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState);
            this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
            this.state.setLayer(this.layer);
            this.state.setLookaheadCoords(new Function0<LayoutCoordinates>() { // from class: androidx.compose.animation.SharedBoundsNode$state$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutCoordinates invoke() {
                    LayoutCoordinates requireLookaheadLayoutCoordinates;
                    requireLookaheadLayoutCoordinates = SharedBoundsNode.this.requireLookaheadLayoutCoordinates();
                    return requireLookaheadLayoutCoordinates;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.state.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoundsAnimation getBoundsAnimation() {
        return this.state.getBoundsAnimation();
    }

    private final void setLayer(GraphicsLayer graphicsLayer) {
        if (graphicsLayer == null) {
            GraphicsLayer graphicsLayer2 = this.layer;
            if (graphicsLayer2 != null) {
                DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer2);
            }
        } else {
            this.state.setLayer(graphicsLayer);
        }
        this.layer = graphicsLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement getSharedElement() {
        return this.state.getSharedElement();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.state);
        this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.state.setLookaheadCoords(new Function0<LayoutCoordinates>() { // from class: androidx.compose.animation.SharedBoundsNode$onAttach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                LayoutCoordinates requireLookaheadLayoutCoordinates;
                requireLookaheadLayoutCoordinates = SharedBoundsNode.this.requireLookaheadLayoutCoordinates();
                return requireLookaheadLayoutCoordinates;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        setLayer(null);
        this.state.setParentState(null);
        this.state.setLookaheadCoords(new Function0() { // from class: androidx.compose.animation.SharedBoundsNode$onDetach$1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
        }
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode, androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
        final long m3897constructorimpl = Size.m3897constructorimpl((Float.floatToRawIntBits(mo5438measureBRTryo0.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(mo5438measureBRTryo0.getWidth()) << 32));
        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
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
                Offset offset;
                SharedElement sharedElement;
                LayoutCoordinates rootLookaheadCoords;
                SharedElement sharedElement2;
                SharedElement sharedElement3;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    SharedBoundsNode sharedBoundsNode = this;
                    long j2 = m3897constructorimpl;
                    rootLookaheadCoords = sharedBoundsNode.getRootLookaheadCoords();
                    long mo5447localPositionOfR5De75A = rootLookaheadCoords.mo5447localPositionOfR5De75A(coordinates, Offset.Companion.m3853getZeroF1C5BW0());
                    sharedElement2 = sharedBoundsNode.getSharedElement();
                    if (sharedElement2.getCurrentBounds() == null) {
                        sharedElement3 = sharedBoundsNode.getSharedElement();
                        sharedElement3.setCurrentBounds(RectKt.m3877Recttz77jQw(mo5447localPositionOfR5De75A, j2));
                    }
                    offset = Offset.m3826boximpl(mo5447localPositionOfR5De75A);
                } else {
                    offset = null;
                }
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                if (offset != null) {
                    SharedBoundsNode sharedBoundsNode2 = this;
                    long j3 = m3897constructorimpl;
                    long m3847unboximpl = offset.m3847unboximpl();
                    sharedElement = sharedBoundsNode2.getSharedElement();
                    sharedElement.m115onLookaheadResultv_w8tDc(sharedBoundsNode2.getState(), j3, m3847unboximpl);
                }
            }
        }, 4, null);
    }

    private final MeasureResult approachPlace(MeasureScope measureScope, final Placeable placeable) {
        if (!getSharedElement().getFoundMatch()) {
            return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$1
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
                        SharedBoundsNode.this.updateCurrentBounds(coordinates);
                    }
                    Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        long mo118calculateSizeJyjRU_E = this.state.getPlaceHolderSize().mo118calculateSizeJyjRU_E(requireLookaheadLayoutCoordinates().mo5446getSizeYbymL2g(), IntSize.m6850constructorimpl((placeable.getWidth() << 32) | (placeable.getHeight() & 4294967295L)));
        return MeasureScope.layout$default(measureScope, (int) (mo118calculateSizeJyjRU_E >> 32), (int) (mo118calculateSizeJyjRU_E & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$2
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
                SharedElement sharedElement;
                BoundsAnimation boundsAnimation;
                Offset offset;
                BoundsAnimation boundsAnimation2;
                SharedElement sharedElement2;
                long m3872getTopLeftF1C5BW0;
                LayoutCoordinates coordinates;
                BoundsAnimation boundsAnimation3;
                SharedElement sharedElement3;
                LayoutCoordinates rootCoords;
                BoundsAnimation boundsAnimation4;
                SharedElement sharedElement4;
                SharedElement sharedElement5;
                sharedElement = SharedBoundsNode.this.getSharedElement();
                if (sharedElement.getTargetBounds() != null) {
                    boundsAnimation4 = SharedBoundsNode.this.getBoundsAnimation();
                    sharedElement4 = SharedBoundsNode.this.getSharedElement();
                    Rect currentBounds = sharedElement4.getCurrentBounds();
                    Intrinsics.checkNotNull(currentBounds);
                    sharedElement5 = SharedBoundsNode.this.getSharedElement();
                    Rect targetBounds = sharedElement5.getTargetBounds();
                    Intrinsics.checkNotNull(targetBounds);
                    boundsAnimation4.animate(currentBounds, targetBounds);
                }
                boundsAnimation = SharedBoundsNode.this.getBoundsAnimation();
                Rect value = boundsAnimation.getValue();
                LayoutCoordinates coordinates2 = placementScope.getCoordinates();
                if (coordinates2 != null) {
                    rootCoords = SharedBoundsNode.this.getRootCoords();
                    offset = Offset.m3826boximpl(rootCoords.mo5447localPositionOfR5De75A(coordinates2, Offset.Companion.m3853getZeroF1C5BW0()));
                } else {
                    offset = null;
                }
                if (value != null) {
                    boundsAnimation3 = SharedBoundsNode.this.getBoundsAnimation();
                    if (boundsAnimation3.getTarget()) {
                        sharedElement3 = SharedBoundsNode.this.getSharedElement();
                        sharedElement3.setCurrentBounds(value);
                    }
                    m3872getTopLeftF1C5BW0 = value.m3872getTopLeftF1C5BW0();
                } else {
                    boundsAnimation2 = SharedBoundsNode.this.getBoundsAnimation();
                    if (boundsAnimation2.getTarget() && (coordinates = placementScope.getCoordinates()) != null) {
                        SharedBoundsNode.this.updateCurrentBounds(coordinates);
                    }
                    sharedElement2 = SharedBoundsNode.this.getSharedElement();
                    Rect currentBounds2 = sharedElement2.getCurrentBounds();
                    Intrinsics.checkNotNull(currentBounds2);
                    m3872getTopLeftF1C5BW0 = currentBounds2.m3872getTopLeftF1C5BW0();
                }
                long m3841minusMKHz9U = offset != null ? Offset.m3841minusMKHz9U(m3872getTopLeftF1C5BW0, offset.m3847unboximpl()) : Offset.Companion.m3853getZeroF1C5BW0();
                Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(Float.intBitsToFloat((int) (m3841minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (m3841minusMKHz9U & 4294967295L))), 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: isMeasurementApproachInProgress-ozmzZPI */
    public boolean mo76isMeasurementApproachInProgressozmzZPI(long j) {
        return getSharedElement().getFoundMatch() && this.state.getSharedElement().getScope().isTransitionActive();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo75approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        if (getSharedElement().getFoundMatch()) {
            Rect value = getBoundsAnimation().getValue();
            if (value == null) {
                value = getSharedElement().getCurrentBounds();
            }
            if (value != null) {
                long m6863roundToIntSizeuvyYCjk = IntSizeKt.m6863roundToIntSizeuvyYCjk(value.m3870getSizeNHjbRc());
                int i = (int) (m6863roundToIntSizeuvyYCjk >> 32);
                int i2 = (int) (m6863roundToIntSizeuvyYCjk & 4294967295L);
                if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getCurrentBounds()).toString());
                }
                j = Constraints.Companion.m6647fixedJhjzzOo(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtLeast(i2, 0));
            }
        }
        return approachPlace(approachMeasureScope, measurable.mo5438measureBRTryo0(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCurrentBounds(LayoutCoordinates layoutCoordinates) {
        getSharedElement().setCurrentBounds(RectKt.m3877Recttz77jQw(getRootCoords().mo5447localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m3853getZeroF1C5BW0()), Size.m3897constructorimpl((Float.floatToRawIntBits((int) (layoutCoordinates.mo5446getSizeYbymL2g() >> 32)) << 32) | (Float.floatToRawIntBits((int) (layoutCoordinates.mo5446getSizeYbymL2g() & 4294967295L)) & 4294967295L))));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        this.state.setFirstFrameDrawn$animation_release(true);
        SharedElementInternalState sharedElementInternalState = this.state;
        SharedTransitionScope.OverlayClip overlayClip = sharedElementInternalState.getOverlayClip();
        SharedTransitionScope.SharedContentState userState = this.state.getUserState();
        Rect currentBounds = getSharedElement().getCurrentBounds();
        Intrinsics.checkNotNull(currentBounds);
        sharedElementInternalState.setClipPathInOverlay$animation_release(overlayClip.getClipPath(userState, currentBounds, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(this)));
        GraphicsLayer layer = this.state.getLayer();
        if (layer == null) {
            throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + getSharedElement().getKey() + ",target: " + this.state.getBoundsAnimation().getTarget() + ", is attached: " + isAttached()).toString());
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m4638recordJVtK1S4$default(contentDrawScope2, layer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$draw$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                ContentDrawScope.this.drawContent();
            }
        }, 1, null);
        if (this.state.getShouldRenderInPlace()) {
            GraphicsLayerKt.drawLayer(contentDrawScope2, layer);
        }
    }
}
