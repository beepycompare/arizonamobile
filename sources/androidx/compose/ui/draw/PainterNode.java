package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010.\u001a\u00020/*\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u001c\u00107\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0016J\u001c\u0010<\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0016J\u001c\u0010=\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010>\u001a\u000208H\u0016J\u001c\u0010?\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010>\u001a\u000208H\u0016J\u0017\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u0002042\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\bF\u0010DJ\f\u0010G\u001a\u00020H*\u00020IH\u0016J\u0013\u0010J\u001a\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bN\u0010LJ\b\u0010O\u001a\u00020PH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u0014\u0010,\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0017¨\u0006Q"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "useIntrinsicSize", "getUseIntrinsicSize", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo5978getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo80measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6697measureBRTryo0 = measurable.mo6697measureBRTryo0(m4872modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, mo6697measureBRTryo0.getWidth(), mo6697measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (getUseIntrinsicSize()) {
            long m4872modifyConstraintsZezNO4M = m4872modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m7950getMinWidthimpl(m4872modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4872modifyConstraintsZezNO4M = m4872modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m7950getMinWidthimpl(m4872modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4872modifyConstraintsZezNO4M = m4872modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m7949getMinHeightimpl(m4872modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4872modifyConstraintsZezNO4M = m4872modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m7949getMinHeightimpl(m4872modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m4869calculateScaledSizeE7KxVPU(long j) {
        float intBitsToFloat;
        float intBitsToFloat2;
        if (getUseIntrinsicSize()) {
            if (!m4871hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo5978getIntrinsicSizeNHjbRc())) {
                intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
            } else {
                intBitsToFloat = Float.intBitsToFloat((int) (this.painter.mo5978getIntrinsicSizeNHjbRc() >> 32));
            }
            if (!m4870hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo5978getIntrinsicSizeNHjbRc())) {
                intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
            } else {
                intBitsToFloat2 = Float.intBitsToFloat((int) (this.painter.mo5978getIntrinsicSizeNHjbRc() & 4294967295L));
            }
            long m5095constructorimpl = Size.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
            if (Float.intBitsToFloat((int) (j >> 32)) != 0.0f && Float.intBitsToFloat((int) (j & 4294967295L)) != 0.0f) {
                return ScaleFactorKt.m6802timesUQTWf7w(m5095constructorimpl, this.contentScale.mo6690computeScaleFactorH7hwNQA(m5095constructorimpl, j));
            }
            return Size.Companion.m5113getZeroNHjbRc();
        }
        return j;
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m4872modifyConstraintsZezNO4M(long j) {
        int m7950getMinWidthimpl;
        int m7949getMinHeightimpl;
        boolean z = true;
        boolean z2 = Constraints.m7944getHasBoundedWidthimpl(j) && Constraints.m7943getHasBoundedHeightimpl(j);
        if (!Constraints.m7946getHasFixedWidthimpl(j) || !Constraints.m7945getHasFixedHeightimpl(j)) {
            z = false;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m7938copyZbe2FdA$default(j, Constraints.m7948getMaxWidthimpl(j), 0, Constraints.m7947getMaxHeightimpl(j), 0, 10, null);
        }
        long mo5978getIntrinsicSizeNHjbRc = this.painter.mo5978getIntrinsicSizeNHjbRc();
        if (!m4871hasSpecifiedAndFiniteWidthuvyYCjk(mo5978getIntrinsicSizeNHjbRc)) {
            m7950getMinWidthimpl = Constraints.m7950getMinWidthimpl(j);
        } else {
            m7950getMinWidthimpl = Math.round(Float.intBitsToFloat((int) (mo5978getIntrinsicSizeNHjbRc >> 32)));
        }
        if (!m4870hasSpecifiedAndFiniteHeightuvyYCjk(mo5978getIntrinsicSizeNHjbRc)) {
            m7949getMinHeightimpl = Constraints.m7949getMinHeightimpl(j);
        } else {
            m7949getMinHeightimpl = Math.round(Float.intBitsToFloat((int) (mo5978getIntrinsicSizeNHjbRc & 4294967295L)));
        }
        long m4869calculateScaledSizeE7KxVPU = m4869calculateScaledSizeE7KxVPU(Size.m5095constructorimpl((Float.floatToRawIntBits(ConstraintsKt.m7964constrainHeightK40F9xA(j, m7949getMinHeightimpl)) & 4294967295L) | (Float.floatToRawIntBits(ConstraintsKt.m7965constrainWidthK40F9xA(j, m7950getMinWidthimpl)) << 32)));
        return Constraints.m7938copyZbe2FdA$default(j, ConstraintsKt.m7965constrainWidthK40F9xA(j, Math.round(Float.intBitsToFloat((int) (m4869calculateScaledSizeE7KxVPU >> 32)))), 0, ConstraintsKt.m7964constrainHeightK40F9xA(j, Math.round(Float.intBitsToFloat((int) (m4869calculateScaledSizeE7KxVPU & 4294967295L)))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float intBitsToFloat;
        float intBitsToFloat2;
        long m5113getZeroNHjbRc;
        long mo5978getIntrinsicSizeNHjbRc = this.painter.mo5978getIntrinsicSizeNHjbRc();
        if (m4871hasSpecifiedAndFiniteWidthuvyYCjk(mo5978getIntrinsicSizeNHjbRc)) {
            intBitsToFloat = Float.intBitsToFloat((int) (mo5978getIntrinsicSizeNHjbRc >> 32));
        } else {
            intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.mo5858getSizeNHjbRc() >> 32));
        }
        if (m4870hasSpecifiedAndFiniteHeightuvyYCjk(mo5978getIntrinsicSizeNHjbRc)) {
            intBitsToFloat2 = Float.intBitsToFloat((int) (mo5978getIntrinsicSizeNHjbRc & 4294967295L));
        } else {
            intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo5858getSizeNHjbRc() & 4294967295L));
        }
        long m5095constructorimpl = Size.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
        if (Float.intBitsToFloat((int) (contentDrawScope.mo5858getSizeNHjbRc() >> 32)) != 0.0f && Float.intBitsToFloat((int) (contentDrawScope.mo5858getSizeNHjbRc() & 4294967295L)) != 0.0f) {
            m5113getZeroNHjbRc = ScaleFactorKt.m6802timesUQTWf7w(m5095constructorimpl, this.contentScale.mo6690computeScaleFactorH7hwNQA(m5095constructorimpl, contentDrawScope.mo5858getSizeNHjbRc()));
        } else {
            m5113getZeroNHjbRc = Size.Companion.m5113getZeroNHjbRc();
        }
        long j = m5113getZeroNHjbRc;
        long mo4758alignKFBX0sM = this.alignment.mo4758alignKFBX0sM(IntSize.m8161constructorimpl((Math.round(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j >> 32))) << 32)), IntSize.m8161constructorimpl((Math.round(Float.intBitsToFloat((int) (contentDrawScope.mo5858getSizeNHjbRc() >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (contentDrawScope.mo5858getSizeNHjbRc() & 4294967295L))) & 4294967295L)), contentDrawScope.getLayoutDirection());
        float m8123getXimpl = IntOffset.m8123getXimpl(mo4758alignKFBX0sM);
        float m8124getYimpl = IntOffset.m8124getYimpl(mo4758alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(m8123getXimpl, m8124getYimpl);
        try {
            this.painter.m5984drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
            contentDrawScope2.getDrawContext().getTransform().translate(-m8123getXimpl, -m8124getYimpl);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            contentDrawScope2.getDrawContext().getTransform().translate(-m8123getXimpl, -m8124getYimpl);
            throw th;
        }
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m4871hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        return !Size.m5100equalsimpl0(j, Size.Companion.m5112getUnspecifiedNHjbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m4870hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        return !Size.m5100equalsimpl0(j, Size.Companion.m5112getUnspecifiedNHjbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
