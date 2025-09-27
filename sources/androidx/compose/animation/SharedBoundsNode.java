package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: SharedContentNode.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u0014\u00109\u001a\u00020,*\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0014\u0010=\u001a\u00020,*\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0014\u0010>\u001a\u000201*\u0002022\u0006\u0010;\u001a\u00020<H\u0002J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ#\u0010D\u001a\u000201*\u00020E2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\bF\u0010GJ\f\u0010H\u001a\u00020,*\u00020IH\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\tR\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006J"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/animation/BoundsProvider;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/animation/SharedElementInternalState;", "<init>", "(Landroidx/compose/animation/SharedElementInternalState;)V", "lastBoundsInSharedTransitionScope", "Landroidx/compose/ui/geometry/Rect;", "getLastBoundsInSharedTransitionScope", "()Landroidx/compose/ui/geometry/Rect;", "approachCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getApproachCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlaced", "", "rootCoords", "getRootCoords", "value", "getState", "()Landroidx/compose/animation/SharedElementInternalState;", "setState$animation", "requireLookaheadLayoutCoordinates", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", AdRevenueConstants.LAYER_KEY, "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "setup", "", "onAttach", "onDetach", "onReset", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachPlaceMatchBeyondTransition", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "approachPlaceMatchInTransition", "approachPlace", "isMeasurementApproachInProgress", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode, BoundsProvider {
    public static final int $stable = 8;
    private boolean isPlaced;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementInternalState state;

    public SharedBoundsNode(SharedElementInternalState sharedElementInternalState) {
        this.state = sharedElementInternalState;
        this.layer = sharedElementInternalState.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState));
    }

    @Override // androidx.compose.animation.BoundsProvider
    public Rect getLastBoundsInSharedTransitionScope() {
        if (isAttached() && this.isPlaced) {
            return RectKt.m4345Recttz77jQw(LayoutCoordinates.m5974localPositionOfS_NoaFU$default(getRootCoords(), getApproachCoordinates(), 0L, false, 6, null), IntSizeKt.m7447toSizeozmzZPI(getApproachCoordinates().mo5975getSizeYbymL2g()));
        }
        return null;
    }

    private final LayoutCoordinates getApproachCoordinates() {
        return DelegatableNodeKt.requireLayoutCoordinates(this);
    }

    private final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation();
    }

    public final SharedElementInternalState getState() {
        return this.state;
    }

    public final void setState$animation(SharedElementInternalState sharedElementInternalState) {
        if (Intrinsics.areEqual(sharedElementInternalState, this.state)) {
            return;
        }
        this.state = sharedElementInternalState;
        if (isAttached()) {
            setup();
        }
    }

    private final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.state.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    private final BoundsAnimation getBoundsAnimation() {
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

    private final void setup() {
        provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.state);
        this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.isPlaced = false;
        this.state.setBoundsProvider(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        setup();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        setLayer(null);
        this.state.setParentState(null);
        this.state.setBoundsProvider(null);
        this.isPlaced = false;
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
    public MeasureResult mo80measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo5967measureBRTryo0 = measurable.mo5967measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo5967measureBRTryo0.getWidth(), mo5967measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
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
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                sharedElement = this.getSharedElement();
                sharedElement.onLookaheadPlaced(placementScope, this.getState());
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void approachPlaceMatchBeyondTransition(Placeable.PlacementScope placementScope, Placeable placeable) {
        long m7403getZeronOccac;
        if (!getBoundsAnimation().getTarget()) {
            Rect currentBoundsWhenMatched = getSharedElement().getCurrentBoundsWhenMatched();
            if (currentBoundsWhenMatched != null) {
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    m7403getZeronOccac = IntOffsetKt.m7409roundk4lQ0M(Offset.m4309minusMKHz9U(currentBoundsWhenMatched.m4340getTopLeftF1C5BW0(), getRootCoords().mo5976localPositionOfR5De75A(coordinates, Offset.Companion.m4321getZeroF1C5BW0())));
                } else {
                    m7403getZeronOccac = IntOffset.Companion.m7403getZeronOccac();
                }
                Placeable.PlacementScope.place$default(placementScope, placeable, IntOffset.m7392getXimpl(m7403getZeronOccac), IntOffset.m7393getYimpl(m7403getZeronOccac), 0.0f, 4, null);
                return;
            }
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        } else if (getBoundsAnimation().getTarget() || !getSharedElement().getFoundMatch()) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void approachPlaceMatchInTransition(Placeable.PlacementScope placementScope, Placeable placeable) {
        Offset offset;
        long m4340getTopLeftF1C5BW0;
        long j;
        Rect m4345Recttz77jQw;
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates == null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            return;
        }
        long mo5976localPositionOfR5De75A = getRootCoords().mo5976localPositionOfR5De75A(coordinates, Offset.Companion.m4321getZeroF1C5BW0());
        if (getSharedElement().getTargetData$animation() != null) {
            Rect currentBoundsWhenMatched = getSharedElement().getCurrentBoundsWhenMatched();
            if (currentBoundsWhenMatched == null) {
                currentBoundsWhenMatched = RectKt.m4345Recttz77jQw(mo5976localPositionOfR5De75A, Size.m4365constructorimpl((Float.floatToRawIntBits(placeable.getWidth()) << 32) | (Float.floatToRawIntBits(placeable.getHeight()) & 4294967295L)));
            }
            BoundsAnimation boundsAnimation = getBoundsAnimation();
            TargetData targetData$animation = getSharedElement().getTargetData$animation();
            Intrinsics.checkNotNull(targetData$animation);
            boundsAnimation.animate(currentBoundsWhenMatched, SharedElementKt.getTargetBounds(targetData$animation));
        }
        Rect value = getBoundsAnimation().getValue();
        if (value != null) {
            TargetData targetData$animation2 = getSharedElement().getTargetData$animation();
            Intrinsics.checkNotNull(targetData$animation2);
            offset = Offset.m4294boximpl(SharedElementKt.calculateOffsetFromDirectManipulation(targetData$animation2, value));
        } else {
            offset = null;
        }
        if (getBoundsAnimation().getTarget()) {
            j = offset != null ? offset.m4315unboximpl() : mo5976localPositionOfR5De75A;
            if (offset == null) {
                m4345Recttz77jQw = RectKt.m4345Recttz77jQw(mo5976localPositionOfR5De75A, IntSizeKt.m7447toSizeozmzZPI(coordinates.mo5975getSizeYbymL2g()));
            } else {
                m4345Recttz77jQw = RectKt.m4345Recttz77jQw(offset.m4315unboximpl(), value.m4338getSizeNHjbRc());
            }
            getSharedElement().setCurrentBoundsWhenMatched(m4345Recttz77jQw);
        } else {
            if (offset != null) {
                m4340getTopLeftF1C5BW0 = offset.m4315unboximpl();
            } else {
                Rect currentBoundsWhenMatched2 = getSharedElement().getCurrentBoundsWhenMatched();
                Intrinsics.checkNotNull(currentBoundsWhenMatched2);
                m4340getTopLeftF1C5BW0 = currentBoundsWhenMatched2.m4340getTopLeftF1C5BW0();
            }
            j = m4340getTopLeftF1C5BW0;
        }
        long m4309minusMKHz9U = Offset.m4309minusMKHz9U(j, mo5976localPositionOfR5De75A);
        Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(Float.intBitsToFloat((int) (m4309minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (m4309minusMKHz9U & 4294967295L))), 0.0f, 4, null);
    }

    private final MeasureResult approachPlace(MeasureScope measureScope, final Placeable placeable) {
        this.isPlaced = true;
        if (!getSharedElement().getFoundMatch()) {
            getSharedElement().setCurrentBoundsWhenMatched(null);
            return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$1
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
                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        } else if (!getSharedElement().getScope().isTransitionActive()) {
            return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$2
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
                    SharedBoundsNode.this.approachPlaceMatchBeyondTransition(placementScope, placeable);
                }
            }, 4, null);
        } else {
            long mo124calculateSizeJyjRU_E = this.state.getPlaceHolderSize().mo124calculateSizeJyjRU_E(requireLookaheadLayoutCoordinates().mo5975getSizeYbymL2g(), IntSize.m7430constructorimpl((placeable.getWidth() << 32) | (placeable.getHeight() & 4294967295L)));
            return MeasureScope.layout$default(measureScope, (int) (mo124calculateSizeJyjRU_E >> 32), (int) (mo124calculateSizeJyjRU_E & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$3
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
                    SharedBoundsNode.this.approachPlaceMatchInTransition(placementScope, placeable);
                }
            }, 4, null);
        }
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: isMeasurementApproachInProgress-ozmzZPI */
    public boolean mo86isMeasurementApproachInProgressozmzZPI(long j) {
        return getSharedElement().getFoundMatch() && this.state.getSharedElement().getScope().isTransitionActive();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo85approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        if (getSharedElement().getFoundMatch()) {
            Rect value = getBoundsAnimation().getValue();
            if (value == null) {
                value = getSharedElement().tryInitializingCurrentBounds();
            }
            if (value != null) {
                long m7443roundToIntSizeuvyYCjk = IntSizeKt.m7443roundToIntSizeuvyYCjk(value.m4338getSizeNHjbRc());
                int i = (int) (m7443roundToIntSizeuvyYCjk >> 32);
                int i2 = (int) (m7443roundToIntSizeuvyYCjk & 4294967295L);
                if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getCurrentBoundsWhenMatched()).toString());
                }
                j = Constraints.Companion.m7227fixedJhjzzOo(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtLeast(i2, 0));
            }
        }
        return approachPlace(approachMeasureScope, measurable.mo5967measureBRTryo0(j));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        Path path;
        SharedElementInternalState sharedElementInternalState = this.state;
        if (!getSharedElement().getFoundMatch() || getSharedElement().getCurrentBoundsWhenMatched() == null) {
            path = null;
        } else {
            SharedTransitionScope.OverlayClip overlayClip = this.state.getOverlayClip();
            SharedTransitionScope.SharedContentState userState = this.state.getUserState();
            Rect currentBoundsWhenMatched = getSharedElement().getCurrentBoundsWhenMatched();
            Intrinsics.checkNotNull(currentBoundsWhenMatched);
            path = overlayClip.getClipPath(userState, currentBoundsWhenMatched, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(this));
        }
        sharedElementInternalState.setClipPathInOverlay$animation(path);
        GraphicsLayer layer = this.state.getLayer();
        if (layer == null) {
            throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + getSharedElement().getKey() + ",target: " + this.state.getBoundsAnimation().getTarget() + ", is attached: " + isAttached()).toString());
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m5126recordJVtK1S4$default(contentDrawScope2, layer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$draw$1
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
