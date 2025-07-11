package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
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
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import coil3.compose.AsyncImagePainter;
import coil3.compose.ConstraintsSizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BE\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J#\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010D\u001a\u00020AH\u0016J\u001c\u0010E\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010D\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010G\u001a\u00020AH\u0016J\u001c\u0010H\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010G\u001a\u00020AH\u0016J\u0017\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020=2\u0006\u0010<\u001a\u00020=H\u0002¢\u0006\u0004\bO\u0010MJ\f\u0010P\u001a\u00020Q*\u00020RH\u0016J\f\u0010S\u001a\u00020Q*\u00020TH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0012\u00101\u001a\u000202X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&¨\u0006U"}, d2 = {"Lcoil3/compose/internal/AbstractContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "contentDescription", "", "constraintSizeResolver", "Lcoil3/compose/ConstraintsSizeResolver;", "<init>", "(Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLjava/lang/String;Lcoil3/compose/ConstraintsSizeResolver;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getContentDescription", "()Ljava/lang/String;", "setContentDescription", "(Ljava/lang/String;)V", "getConstraintSizeResolver", "()Lcoil3/compose/ConstraintsSizeResolver;", "setConstraintSizeResolver", "(Lcoil3/compose/ConstraintsSizeResolver;)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private ConstraintsSizeResolver constraintSizeResolver;
    private String contentDescription;
    private ContentScale contentScale;

    public abstract Painter getPainter();

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
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

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final void setClipToBounds(boolean z) {
        this.clipToBounds = z;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final void setContentDescription(String str) {
        this.contentDescription = str;
    }

    public final ConstraintsSizeResolver getConstraintSizeResolver() {
        return this.constraintSizeResolver;
    }

    public final void setConstraintSizeResolver(ConstraintsSizeResolver constraintsSizeResolver) {
        this.constraintSizeResolver = constraintsSizeResolver;
    }

    public AbstractContentPainterNode(Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, ConstraintsSizeResolver constraintsSizeResolver) {
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.contentDescription = str;
        this.constraintSizeResolver = constraintsSizeResolver;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m7744setConstraintsBRTryo0(j);
        }
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m7762modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1() { // from class: coil3.compose.internal.AbstractContentPainterNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = AbstractContentPainterNode.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m7744setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().mo4761getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats) {
            long m7762modifyConstraintsZezNO4M = m7762modifyConstraintsZezNO4M(Constraints$default);
            return Math.max(Constraints.m6639getMinWidthimpl(m7762modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m7744setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().mo4761getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats) {
            long m7762modifyConstraintsZezNO4M = m7762modifyConstraintsZezNO4M(Constraints$default);
            return Math.max(Constraints.m6639getMinWidthimpl(m7762modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m7744setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().mo4761getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats) {
            long m7762modifyConstraintsZezNO4M = m7762modifyConstraintsZezNO4M(Constraints$default);
            return Math.max(Constraints.m6638getMinHeightimpl(m7762modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.m7744setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().mo4761getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats) {
            long m7762modifyConstraintsZezNO4M = m7762modifyConstraintsZezNO4M(Constraints$default);
            return Math.max(Constraints.m6638getMinHeightimpl(m7762modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m7761calculateScaledSizeE7KxVPU(long j) {
        if (Size.m3908isEmptyimpl(j)) {
            return Size.Companion.m3915getZeroNHjbRc();
        }
        long mo4761getIntrinsicSizeNHjbRc = getPainter().mo4761getIntrinsicSizeNHjbRc();
        if (mo4761getIntrinsicSizeNHjbRc == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return j;
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc >> 32));
        if (Math.abs(intBitsToFloat) > Float.MAX_VALUE) {
            intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        }
        float intBitsToFloat2 = Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc & 4294967295L));
        if (Math.abs(intBitsToFloat2) > Float.MAX_VALUE) {
            intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        long m3897constructorimpl = Size.m3897constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
        long mo5431computeScaleFactorH7hwNQA = this.contentScale.mo5431computeScaleFactorH7hwNQA(m3897constructorimpl, j);
        return (Math.abs(Float.intBitsToFloat((int) (mo5431computeScaleFactorH7hwNQA >> 32))) > Float.MAX_VALUE || Math.abs(Float.intBitsToFloat((int) (4294967295L & mo5431computeScaleFactorH7hwNQA))) > Float.MAX_VALUE) ? j : ScaleFactorKt.m5543timesmw2e94(mo5431computeScaleFactorH7hwNQA, m3897constructorimpl);
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m7762modifyConstraintsZezNO4M(long j) {
        float m7767constrainWidthK40F9xA;
        int m6638getMinHeightimpl;
        float m7766constrainHeightK40F9xA;
        boolean m6635getHasFixedWidthimpl = Constraints.m6635getHasFixedWidthimpl(j);
        boolean m6634getHasFixedHeightimpl = Constraints.m6634getHasFixedHeightimpl(j);
        if (m6635getHasFixedWidthimpl && m6634getHasFixedHeightimpl) {
            return j;
        }
        Painter painter = getPainter();
        boolean z = Constraints.m6633getHasBoundedWidthimpl(j) && Constraints.m6632getHasBoundedHeightimpl(j);
        long mo4761getIntrinsicSizeNHjbRc = painter.mo4761getIntrinsicSizeNHjbRc();
        if (mo4761getIntrinsicSizeNHjbRc == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return z ? ((painter instanceof AsyncImagePainter) && ((AsyncImagePainter) painter).getState().getValue().getPainter() == null) ? j : Constraints.m6627copyZbe2FdA$default(j, Constraints.m6637getMaxWidthimpl(j), 0, Constraints.m6636getMaxHeightimpl(j), 0, 10, null) : j;
        }
        if (z && (m6635getHasFixedWidthimpl || m6634getHasFixedHeightimpl)) {
            m7767constrainWidthK40F9xA = Constraints.m6637getMaxWidthimpl(j);
            m6638getMinHeightimpl = Constraints.m6636getMaxHeightimpl(j);
        } else {
            float intBitsToFloat = Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc & 4294967295L));
            m7767constrainWidthK40F9xA = Math.abs(intBitsToFloat) <= Float.MAX_VALUE ? UtilsKt.m7767constrainWidthK40F9xA(j, intBitsToFloat) : Constraints.m6639getMinWidthimpl(j);
            if (Math.abs(intBitsToFloat2) > Float.MAX_VALUE) {
                m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(j);
            } else {
                m7766constrainHeightK40F9xA = UtilsKt.m7766constrainHeightK40F9xA(j, intBitsToFloat2);
                long m7761calculateScaledSizeE7KxVPU = m7761calculateScaledSizeE7KxVPU(Size.m3897constructorimpl((Float.floatToRawIntBits(m7766constrainHeightK40F9xA) & 4294967295L) | (Float.floatToRawIntBits(m7767constrainWidthK40F9xA) << 32)));
                return Constraints.m6627copyZbe2FdA$default(j, ConstraintsKt.m6654constrainWidthK40F9xA(j, MathKt.roundToInt(Float.intBitsToFloat((int) (m7761calculateScaledSizeE7KxVPU >> 32)))), 0, ConstraintsKt.m6653constrainHeightK40F9xA(j, MathKt.roundToInt(Float.intBitsToFloat((int) (m7761calculateScaledSizeE7KxVPU & 4294967295L)))), 0, 10, null);
            }
        }
        m7766constrainHeightK40F9xA = m6638getMinHeightimpl;
        long m7761calculateScaledSizeE7KxVPU2 = m7761calculateScaledSizeE7KxVPU(Size.m3897constructorimpl((Float.floatToRawIntBits(m7766constrainHeightK40F9xA) & 4294967295L) | (Float.floatToRawIntBits(m7767constrainWidthK40F9xA) << 32)));
        return Constraints.m6627copyZbe2FdA$default(j, ConstraintsKt.m6654constrainWidthK40F9xA(j, MathKt.roundToInt(Float.intBitsToFloat((int) (m7761calculateScaledSizeE7KxVPU2 >> 32)))), 0, ConstraintsKt.m6653constrainHeightK40F9xA(j, MathKt.roundToInt(Float.intBitsToFloat((int) (m7761calculateScaledSizeE7KxVPU2 & 4294967295L)))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long m7761calculateScaledSizeE7KxVPU = m7761calculateScaledSizeE7KxVPU(contentDrawScope.mo4640getSizeNHjbRc());
        long mo3654alignKFBX0sM = this.alignment.mo3654alignKFBX0sM(UtilsKt.m7769toIntSizeuvyYCjk(m7761calculateScaledSizeE7KxVPU), UtilsKt.m7769toIntSizeuvyYCjk(contentDrawScope.mo4640getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        int m6812getXimpl = IntOffset.m6812getXimpl(mo3654alignKFBX0sM);
        int m6813getYimpl = IntOffset.m6813getYimpl(mo3654alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long mo4561getSizeNHjbRc = drawContext.mo4561getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            if (this.clipToBounds) {
                DrawTransform.m4697clipRectN_I0leg$default(transform, 0.0f, 0.0f, 0.0f, 0.0f, 0, 31, null);
            }
            transform.translate(m6812getXimpl, m6813getYimpl);
            getPainter().m4767drawx_KDEd0(contentDrawScope2, m7761calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
            drawContext.getCanvas().restore();
            drawContext.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
            throw th;
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        String str = this.contentDescription;
        if (str != null) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
            SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5915getImageo7Vup1c());
        }
    }
}
