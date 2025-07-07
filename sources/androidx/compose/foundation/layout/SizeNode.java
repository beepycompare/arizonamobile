package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016J&\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\"\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001c\u0010.\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", "F", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m6704getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m6704getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m6704getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m6704getUnspecifiedD9Ej5fM() : f4, z, null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m797getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m801setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m796getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m800setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: getMaxWidth-D9Ej5fM  reason: not valid java name */
    public final float m795getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* renamed from: setMaxWidth-0680j_4  reason: not valid java name */
    public final void m799setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* renamed from: getMaxHeight-D9Ej5fM  reason: not valid java name */
    public final float m794getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* renamed from: setMaxHeight-0680j_4  reason: not valid java name */
    public final void m798setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r4 != Integer.MAX_VALUE) goto L19;
     */
    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long m793getTargetConstraintsOenEA2s(Density density) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (Float.isNaN(this.maxWidth)) {
            i = Integer.MAX_VALUE;
        } else {
            i = density.mo383roundToPx0680j_4(this.maxWidth);
            if (i < 0) {
                i = 0;
            }
        }
        if (Float.isNaN(this.maxHeight)) {
            i2 = Integer.MAX_VALUE;
        } else {
            i2 = density.mo383roundToPx0680j_4(this.maxHeight);
            if (i2 < 0) {
                i2 = 0;
            }
        }
        if (!Float.isNaN(this.minWidth)) {
            i3 = density.mo383roundToPx0680j_4(this.minWidth);
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 > i) {
                i3 = i;
            }
        }
        i3 = 0;
        if (!Float.isNaN(this.minHeight)) {
            int mo383roundToPx0680j_4 = density.mo383roundToPx0680j_4(this.minHeight);
            if (mo383roundToPx0680j_4 < 0) {
                mo383roundToPx0680j_4 = 0;
            }
            if (mo383roundToPx0680j_4 > i2) {
                mo383roundToPx0680j_4 = i2;
            }
            if (mo383roundToPx0680j_4 != Integer.MAX_VALUE) {
                i4 = mo383roundToPx0680j_4;
            }
        }
        return ConstraintsKt.Constraints(i3, i, i4, i2);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int m6639getMinWidthimpl;
        int m6637getMaxWidthimpl;
        int m6638getMinHeightimpl;
        int m6636getMaxHeightimpl;
        long Constraints;
        long m793getTargetConstraintsOenEA2s = m793getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m6652constrainN9IONVI(j, m793getTargetConstraintsOenEA2s);
        } else {
            if (!Float.isNaN(this.minWidth)) {
                m6639getMinWidthimpl = Constraints.m6639getMinWidthimpl(m793getTargetConstraintsOenEA2s);
            } else {
                m6639getMinWidthimpl = Constraints.m6639getMinWidthimpl(j);
                int m6637getMaxWidthimpl2 = Constraints.m6637getMaxWidthimpl(m793getTargetConstraintsOenEA2s);
                if (m6639getMinWidthimpl > m6637getMaxWidthimpl2) {
                    m6639getMinWidthimpl = m6637getMaxWidthimpl2;
                }
            }
            if (!Float.isNaN(this.maxWidth)) {
                m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(m793getTargetConstraintsOenEA2s);
            } else {
                m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
                int m6639getMinWidthimpl2 = Constraints.m6639getMinWidthimpl(m793getTargetConstraintsOenEA2s);
                if (m6637getMaxWidthimpl < m6639getMinWidthimpl2) {
                    m6637getMaxWidthimpl = m6639getMinWidthimpl2;
                }
            }
            if (!Float.isNaN(this.minHeight)) {
                m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(m793getTargetConstraintsOenEA2s);
            } else {
                m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(j);
                int m6636getMaxHeightimpl2 = Constraints.m6636getMaxHeightimpl(m793getTargetConstraintsOenEA2s);
                if (m6638getMinHeightimpl > m6636getMaxHeightimpl2) {
                    m6638getMinHeightimpl = m6636getMaxHeightimpl2;
                }
            }
            if (!Float.isNaN(this.maxHeight)) {
                m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(m793getTargetConstraintsOenEA2s);
            } else {
                m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
                int m6638getMinHeightimpl2 = Constraints.m6638getMinHeightimpl(m793getTargetConstraintsOenEA2s);
                if (m6636getMaxHeightimpl < m6638getMinHeightimpl2) {
                    m6636getMaxHeightimpl = m6638getMinHeightimpl2;
                }
            }
            Constraints = ConstraintsKt.Constraints(m6639getMinWidthimpl, m6637getMaxWidthimpl, m6638getMinHeightimpl, m6636getMaxHeightimpl);
        }
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(Constraints);
        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m793getTargetConstraintsOenEA2s = m793getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6635getHasFixedWidthimpl(m793getTargetConstraintsOenEA2s)) {
            return Constraints.m6637getMaxWidthimpl(m793getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6653constrainHeightK40F9xA(m793getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6654constrainWidthK40F9xA(m793getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m793getTargetConstraintsOenEA2s = m793getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6634getHasFixedHeightimpl(m793getTargetConstraintsOenEA2s)) {
            return Constraints.m6636getMaxHeightimpl(m793getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6654constrainWidthK40F9xA(m793getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6653constrainHeightK40F9xA(m793getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m793getTargetConstraintsOenEA2s = m793getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6635getHasFixedWidthimpl(m793getTargetConstraintsOenEA2s)) {
            return Constraints.m6637getMaxWidthimpl(m793getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6653constrainHeightK40F9xA(m793getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6654constrainWidthK40F9xA(m793getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m793getTargetConstraintsOenEA2s = m793getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6634getHasFixedHeightimpl(m793getTargetConstraintsOenEA2s)) {
            return Constraints.m6636getMaxHeightimpl(m793getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6654constrainWidthK40F9xA(m793getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6653constrainHeightK40F9xA(m793getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
