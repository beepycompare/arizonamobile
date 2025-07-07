package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsetsPadding.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u001c\u0010#\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020\u001eH\u0016J&\u0010%\u001a\u00020&*\u00020'2\u0006\u0010 \u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001c\u0010-\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u001c\u0010.\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020\u001eH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "()V", "insets", "Landroidx/compose/foundation/layout/ValueInsets;", "getInsets", "()Landroidx/compose/foundation/layout/ValueInsets;", "oldPosition", "Landroidx/compose/ui/unit/IntOffset;", "getOldPosition-nOcc-ac", "()J", "setOldPosition--gyyYBs", "(J)V", "J", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecalculateWindowInsetsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutModifierNode, GlobalPositionAwareModifierNode {
    private final ValueInsets insets;
    private long oldPosition;
    private final ModifierLocalMap providedValues;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public RecalculateWindowInsetsModifierNode() {
        ValueInsets valueInsets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "reset");
        this.insets = valueInsets;
        this.oldPosition = IntOffset.Companion.m6823getZeronOccac();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), valueInsets));
    }

    public final ValueInsets getInsets() {
        return this.insets;
    }

    /* renamed from: getOldPosition-nOcc-ac  reason: not valid java name */
    public final long m763getOldPositionnOccac() {
        return this.oldPosition;
    }

    /* renamed from: setOldPosition--gyyYBs  reason: not valid java name */
    public final void m764setOldPositiongyyYBs(long j) {
        this.oldPosition = j;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, final Measurable measurable, long j) {
        if (!Constraints.m6635getHasFixedWidthimpl(j) || !Constraints.m6634getHasFixedHeightimpl(j)) {
            provide(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets()));
            final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$measure$1
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
        }
        final int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
        final int m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
        return MeasureScope.layout$default(measureScope, m6637getMaxWidthimpl, m6636getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$measure$2
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
                WindowInsets insets;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    RecalculateWindowInsetsModifierNode.this.m764setOldPositiongyyYBs(IntOffsetKt.m6829roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(coordinates)));
                }
                if (coordinates == null) {
                    insets = (WindowInsets) RecalculateWindowInsetsModifierNode.this.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
                } else {
                    long positionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
                    long mo5446getSizeYbymL2g = coordinates.mo5446getSizeYbymL2g();
                    long mo5449localToRootMKHz9U = coordinates.mo5449localToRootMKHz9U(Offset.m3829constructorimpl((Float.floatToRawIntBits((int) (mo5446getSizeYbymL2g & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (mo5446getSizeYbymL2g >> 32)) << 32)));
                    long mo5446getSizeYbymL2g2 = LayoutCoordinatesKt.findRootCoordinates(coordinates).mo5446getSizeYbymL2g();
                    int round = Math.round(Float.intBitsToFloat((int) (positionInRoot >> 32)));
                    int round2 = Math.round(Float.intBitsToFloat((int) (positionInRoot & 4294967295L)));
                    int round3 = ((int) (mo5446getSizeYbymL2g2 >> 32)) - Math.round(Float.intBitsToFloat((int) (mo5449localToRootMKHz9U >> 32)));
                    int round4 = ((int) (mo5446getSizeYbymL2g2 & 4294967295L)) - Math.round(Float.intBitsToFloat((int) (mo5449localToRootMKHz9U & 4294967295L)));
                    InsetsValues value$foundation_layout_release = RecalculateWindowInsetsModifierNode.this.getInsets().getValue$foundation_layout_release();
                    if (value$foundation_layout_release.getLeft() != round || value$foundation_layout_release.getTop() != round2 || value$foundation_layout_release.getRight() != round3 || value$foundation_layout_release.getBottom() != round4) {
                        RecalculateWindowInsetsModifierNode.this.getInsets().setValue$foundation_layout_release(new InsetsValues(round, round2, round3, round4));
                    }
                    insets = RecalculateWindowInsetsModifierNode.this.getInsets();
                }
                RecalculateWindowInsetsModifierNode.this.provide(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), insets);
                Placeable.PlacementScope.place$default(placementScope, measurable.mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(m6637getMaxWidthimpl, m6636getMaxHeightimpl)), 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        long m6829roundk4lQ0M = IntOffsetKt.m6829roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
        boolean m6811equalsimpl0 = IntOffset.m6811equalsimpl0(this.oldPosition, m6829roundk4lQ0M);
        this.oldPosition = m6829roundk4lQ0M;
        if (m6811equalsimpl0) {
            return;
        }
        LayoutModifierNodeKt.invalidatePlacement(this);
    }
}
