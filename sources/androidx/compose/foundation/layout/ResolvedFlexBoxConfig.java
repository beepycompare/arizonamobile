package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlexAlignContent;
import androidx.compose.foundation.layout.FlexAlignItems;
import androidx.compose.foundation.layout.FlexDirection;
import androidx.compose.foundation.layout.FlexJustifyContent;
import androidx.compose.foundation.layout.FlexWrap;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FlexBox.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u0017*\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\"\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020#H\u0016¢\u0006\u0004\bB\u0010'J\u0017\u0010)\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020*H\u0016¢\u0006\u0004\bC\u0010'J\u0017\u0010-\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020.H\u0016¢\u0006\u0004\bD\u0010'J\u0017\u00101\u001a\u00020A2\u0006\u0010\u0006\u001a\u000202H\u0016¢\u0006\u0004\bE\u0010'J\u0017\u0010F\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020\u0017H\u0016¢\u0006\u0004\bG\u0010<J\u0010\u00101\u001a\u00020A2\u0006\u0010H\u001a\u00020\u0007H\u0016J\u001c\u00101\u001a\u00020A2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0JH\u0016J\u0017\u00105\u001a\u00020A2\u0006\u0010\u0006\u001a\u000206H\u0016¢\u0006\u0004\bM\u0010'J\u0017\u00109\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020\u0017H\u0016¢\u0006\u0004\bN\u0010<J\u0017\u0010>\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020\u0017H\u0016¢\u0006\u0004\bO\u0010<J\u001f\u0010F\u001a\u00020A2\u0006\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u0017H\u0016¢\u0006\u0004\bR\u0010SJ\u0015\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020VH\u0000¢\u0006\u0002\bWJ\u001d\u0010X\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bY\u0010ZJ\u0006\u0010b\u001a\u00020LJ\u0006\u0010c\u001a\u00020LJ\b\u0010d\u001a\u00020eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001d@RX\u0096\u000e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020#X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'R\u001c\u0010-\u001a\u00020.X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u001c\u00101\u001a\u000202X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R\u001c\u00105\u001a\u000206X\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b7\u0010%\"\u0004\b8\u0010'R\u001c\u00109\u001a\u00020\u0017X\u0080\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010<R\u001c\u0010>\u001a\u00020\u0017X\u0080\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010<R\u0012\u0010[\u001a\u00020\\8Æ\u0002¢\u0006\u0006\u001a\u0004\b[\u0010]R\u0012\u0010^\u001a\u00020\\8Æ\u0002¢\u0006\u0006\u001a\u0004\b^\u0010]R\u0012\u0010_\u001a\u00020\\8Æ\u0002¢\u0006\u0006\u001a\u0004\b_\u0010]R\u0012\u0010`\u001a\u00020\\8Æ\u0002¢\u0006\u0006\u001a\u0004\ba\u0010]¨\u0006f"}, d2 = {"Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "Landroidx/compose/foundation/layout/FlexBoxConfigScope;", "<init>", "()V", "_density", "Landroidx/compose/ui/unit/Density;", "value", "Landroidx/compose/ui/layout/AlignmentLine;", "baselineAlignmentLine", "getBaselineAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "Landroidx/compose/foundation/layout/AlignmentLineProviderBlock;", "baselineAlignmentBlock", "getBaselineAlignmentBlock", "()Landroidx/compose/foundation/layout/AlignmentLineProviderBlock;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "Landroidx/compose/ui/unit/Constraints;", "constraints", "getConstraints-msEJaDk", "()J", "J", "direction", "Landroidx/compose/foundation/layout/FlexDirection;", "getDirection-T4wFHC8$foundation_layout", "()I", "setDirection-d5Yd7B0$foundation_layout", "(I)V", "I", "wrap", "Landroidx/compose/foundation/layout/FlexWrap;", "getWrap-7ziDAWk$foundation_layout", "setWrap-CLQ35Ag$foundation_layout", "justifyContent", "Landroidx/compose/foundation/layout/FlexJustifyContent;", "getJustifyContent-GomtQF4$foundation_layout", "setJustifyContent-q3qUS_E$foundation_layout", "alignItems", "Landroidx/compose/foundation/layout/FlexAlignItems;", "getAlignItems-20X20zU$foundation_layout", "setAlignItems-yvIbNKY$foundation_layout", "alignContent", "Landroidx/compose/foundation/layout/FlexAlignContent;", "getAlignContent-d9B3MrI$foundation_layout", "setAlignContent-RVFKNBI$foundation_layout", "rowGap", "getRowGap-D9Ej5fM$foundation_layout", "setRowGap-0680j_4$foundation_layout", "(F)V", "F", "columnGap", "getColumnGap-D9Ej5fM$foundation_layout", "setColumnGap-0680j_4$foundation_layout", "", "direction-d5Yd7B0", "wrap-CLQ35Ag", "justifyContent-q3qUS_E", "alignItems-yvIbNKY", "gap", "gap-0680j_4", "alignmentLine", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignContent-RVFKNBI", "rowGap-0680j_4", "columnGap-0680j_4", "row", "column", "gap-YgX7TsA", "(FF)V", "getBaseline", "placeable", "Landroidx/compose/ui/layout/Placeable;", "getBaseline$foundation_layout", "prepare", "prepare-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)V", "isHorizontal", "", "()Z", "isWrapEnabled", "isCrossAxisReverse", "hasBaseline", "getHasBaseline", "mainAxisGap", "crossAxisGap", "toString", "", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResolvedFlexBoxConfig implements FlexBoxConfigScope {
    public static final int $stable = 0;
    private int alignContent;
    private int alignItems;
    private AlignmentLineProviderBlock baselineAlignmentBlock;
    private AlignmentLine baselineAlignmentLine;
    private float columnGap;
    private int direction;
    private int justifyContent;
    private float rowGap;
    private int wrap;
    private Density _density = FlexBoxKt.getDefaultDensity();
    private long constraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);

    public ResolvedFlexBoxConfig() {
        FlexDirection.Companion companion = FlexDirection.Companion;
        this.direction = FlexDirection.m860constructorimpl(0);
        FlexWrap.Companion companion2 = FlexWrap.Companion;
        this.wrap = FlexWrap.m884constructorimpl(0);
        FlexJustifyContent.Companion companion3 = FlexJustifyContent.Companion;
        this.justifyContent = FlexJustifyContent.m871constructorimpl(0);
        FlexAlignItems.Companion companion4 = FlexAlignItems.Companion;
        this.alignItems = FlexAlignItems.m799constructorimpl(0);
        FlexAlignContent.Companion companion5 = FlexAlignContent.Companion;
        this.alignContent = FlexAlignContent.m786constructorimpl(0);
        this.rowGap = Dp.m8160constructorimpl(0.0f);
        this.columnGap = Dp.m8160constructorimpl(0.0f);
    }

    public final AlignmentLine getBaselineAlignmentLine() {
        return this.baselineAlignmentLine;
    }

    public final AlignmentLineProviderBlock getBaselineAlignmentBlock() {
        return this.baselineAlignmentBlock;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this._density.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this._density.getFontScale();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo436toSp0xMU5do(float f) {
        return this._density.mo436toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo429toDpGaN1DYA(long j) {
        return this._density.mo429toDpGaN1DYA(j);
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: getConstraints-msEJaDk */
    public long mo843getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* renamed from: getDirection-T4wFHC8$foundation_layout  reason: not valid java name */
    public final int m1078getDirectionT4wFHC8$foundation_layout() {
        return this.direction;
    }

    /* renamed from: setDirection-d5Yd7B0$foundation_layout  reason: not valid java name */
    public final void m1086setDirectiond5Yd7B0$foundation_layout(int i) {
        this.direction = i;
    }

    /* renamed from: getWrap-7ziDAWk$foundation_layout  reason: not valid java name */
    public final int m1081getWrap7ziDAWk$foundation_layout() {
        return this.wrap;
    }

    /* renamed from: setWrap-CLQ35Ag$foundation_layout  reason: not valid java name */
    public final void m1089setWrapCLQ35Ag$foundation_layout(int i) {
        this.wrap = i;
    }

    /* renamed from: getJustifyContent-GomtQF4$foundation_layout  reason: not valid java name */
    public final int m1079getJustifyContentGomtQF4$foundation_layout() {
        return this.justifyContent;
    }

    /* renamed from: setJustifyContent-q3qUS_E$foundation_layout  reason: not valid java name */
    public final void m1087setJustifyContentq3qUS_E$foundation_layout(int i) {
        this.justifyContent = i;
    }

    /* renamed from: getAlignItems-20X20zU$foundation_layout  reason: not valid java name */
    public final int m1076getAlignItems20X20zU$foundation_layout() {
        return this.alignItems;
    }

    /* renamed from: setAlignItems-yvIbNKY$foundation_layout  reason: not valid java name */
    public final void m1084setAlignItemsyvIbNKY$foundation_layout(int i) {
        this.alignItems = i;
    }

    /* renamed from: getAlignContent-d9B3MrI$foundation_layout  reason: not valid java name */
    public final int m1075getAlignContentd9B3MrI$foundation_layout() {
        return this.alignContent;
    }

    /* renamed from: setAlignContent-RVFKNBI$foundation_layout  reason: not valid java name */
    public final void m1083setAlignContentRVFKNBI$foundation_layout(int i) {
        this.alignContent = i;
    }

    /* renamed from: getRowGap-D9Ej5fM$foundation_layout  reason: not valid java name */
    public final float m1080getRowGapD9Ej5fM$foundation_layout() {
        return this.rowGap;
    }

    /* renamed from: setRowGap-0680j_4$foundation_layout  reason: not valid java name */
    public final void m1088setRowGap0680j_4$foundation_layout(float f) {
        this.rowGap = f;
    }

    /* renamed from: getColumnGap-D9Ej5fM$foundation_layout  reason: not valid java name */
    public final float m1077getColumnGapD9Ej5fM$foundation_layout() {
        return this.columnGap;
    }

    /* renamed from: setColumnGap-0680j_4$foundation_layout  reason: not valid java name */
    public final void m1085setColumnGap0680j_4$foundation_layout(float f) {
        this.columnGap = f;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: direction-d5Yd7B0 */
    public void mo840directiond5Yd7B0(int i) {
        this.direction = i;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: wrap-CLQ35Ag */
    public void mo846wrapCLQ35Ag(int i) {
        this.wrap = i;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: justifyContent-q3qUS_E */
    public void mo844justifyContentq3qUS_E(int i) {
        this.justifyContent = i;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: alignItems-yvIbNKY */
    public void mo838alignItemsyvIbNKY(int i) {
        this.alignItems = i;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: gap-0680j_4 */
    public void mo841gap0680j_4(float f) {
        this.rowGap = f;
        this.columnGap = f;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    public void alignItems(AlignmentLine alignmentLine) {
        FlexAlignItems.Companion companion = FlexAlignItems.Companion;
        this.alignItems = FlexAlignItems.m799constructorimpl(4);
        this.baselineAlignmentLine = alignmentLine;
        this.baselineAlignmentBlock = null;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    public void alignItems(final Function1<? super Measured, Integer> function1) {
        FlexAlignItems.Companion companion = FlexAlignItems.Companion;
        this.alignItems = FlexAlignItems.m799constructorimpl(4);
        this.baselineAlignmentLine = null;
        this.baselineAlignmentBlock = new AlignmentLineProviderBlock() { // from class: androidx.compose.foundation.layout.ResolvedFlexBoxConfig$$ExternalSyntheticLambda0
            @Override // androidx.compose.foundation.layout.AlignmentLineProviderBlock
            public final int calculateAlignmentLinePosition(Measured measured) {
                int intValue;
                intValue = ((Number) Function1.this.invoke(measured)).intValue();
                return intValue;
            }
        };
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: alignContent-RVFKNBI */
    public void mo837alignContentRVFKNBI(int i) {
        this.alignContent = i;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: rowGap-0680j_4 */
    public void mo845rowGap0680j_4(float f) {
        this.rowGap = f;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: columnGap-0680j_4 */
    public void mo839columnGap0680j_4(float f) {
        this.columnGap = f;
    }

    @Override // androidx.compose.foundation.layout.FlexBoxConfigScope
    /* renamed from: gap-YgX7TsA */
    public void mo842gapYgX7TsA(float f, float f2) {
        this.rowGap = f;
        this.columnGap = f2;
    }

    public final int getBaseline$foundation_layout(Placeable placeable) {
        AlignmentLineProviderBlock alignmentLineProviderBlock = this.baselineAlignmentBlock;
        if (alignmentLineProviderBlock != null) {
            Intrinsics.checkNotNull(alignmentLineProviderBlock);
            return alignmentLineProviderBlock.calculateAlignmentLinePosition(placeable);
        }
        AlignmentLine alignmentLine = this.baselineAlignmentLine;
        if (alignmentLine != null) {
            Intrinsics.checkNotNull(alignmentLine);
            int i = placeable.get(alignmentLine);
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            AlignmentLine alignmentLine2 = this.baselineAlignmentLine;
            Intrinsics.checkNotNull(alignmentLine2);
            if (alignmentLine2 instanceof VerticalAlignmentLine) {
                return placeable.getWidth();
            }
            return placeable.getHeight();
        }
        int i2 = placeable.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
        return i2 != Integer.MIN_VALUE ? i2 : placeable.getHeight();
    }

    /* renamed from: prepare-0kLqBqw  reason: not valid java name */
    public final void m1082prepare0kLqBqw(Density density, long j) {
        this._density = density;
        this.constraints = j;
        FlexDirection.Companion companion = FlexDirection.Companion;
        this.direction = FlexDirection.m860constructorimpl(0);
        FlexWrap.Companion companion2 = FlexWrap.Companion;
        this.wrap = FlexWrap.m884constructorimpl(0);
        FlexJustifyContent.Companion companion3 = FlexJustifyContent.Companion;
        this.justifyContent = FlexJustifyContent.m871constructorimpl(0);
        FlexAlignItems.Companion companion4 = FlexAlignItems.Companion;
        this.alignItems = FlexAlignItems.m799constructorimpl(0);
        FlexAlignContent.Companion companion5 = FlexAlignContent.Companion;
        this.alignContent = FlexAlignContent.m786constructorimpl(0);
        this.rowGap = Dp.m8160constructorimpl(0.0f);
        this.columnGap = Dp.m8160constructorimpl(0.0f);
        this.baselineAlignmentLine = null;
        this.baselineAlignmentBlock = null;
    }

    public final boolean isHorizontal() {
        int m1078getDirectionT4wFHC8$foundation_layout = m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        if (FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            return true;
        }
        int m1078getDirectionT4wFHC8$foundation_layout2 = m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion2 = FlexDirection.Companion;
        return FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2));
    }

    public final boolean isWrapEnabled() {
        int m1081getWrap7ziDAWk$foundation_layout = m1081getWrap7ziDAWk$foundation_layout();
        FlexWrap.Companion companion = FlexWrap.Companion;
        if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
            int m1081getWrap7ziDAWk$foundation_layout2 = m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion2 = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout2, FlexWrap.m884constructorimpl(2))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isCrossAxisReverse() {
        int m1081getWrap7ziDAWk$foundation_layout = m1081getWrap7ziDAWk$foundation_layout();
        FlexWrap.Companion companion = FlexWrap.Companion;
        return FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(2));
    }

    public final boolean getHasBaseline() {
        int m1076getAlignItems20X20zU$foundation_layout = m1076getAlignItems20X20zU$foundation_layout();
        FlexAlignItems.Companion companion = FlexAlignItems.Companion;
        return FlexAlignItems.m801equalsimpl0(m1076getAlignItems20X20zU$foundation_layout, FlexAlignItems.m799constructorimpl(4));
    }

    public String toString() {
        return StringsKt.trimIndent("\n        FlexBoxConfig(\n            direction = " + ((Object) FlexDirection.m864toStringimpl(this.direction)) + ",\n            wrap = " + ((Object) FlexWrap.m888toStringimpl(this.wrap)) + ",\n            justifyContent = " + ((Object) FlexJustifyContent.m875toStringimpl(this.justifyContent)) + ",\n            alignItems = " + ((Object) FlexAlignItems.m803toStringimpl(this.alignItems)) + ",\n            alignContent = " + ((Object) FlexAlignContent.m790toStringimpl(this.alignContent)) + ",\n            rowGap = " + ((Object) Dp.m8171toStringimpl(this.rowGap)) + ",\n            columnGap = " + ((Object) Dp.m8171toStringimpl(this.columnGap)) + "\n        )\n    ");
    }

    public final int mainAxisGap() {
        float f;
        int m1078getDirectionT4wFHC8$foundation_layout = m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                f = this.rowGap;
                return mo428roundToPx0680j_4(f);
            }
        }
        f = this.columnGap;
        return mo428roundToPx0680j_4(f);
    }

    public final int crossAxisGap() {
        float f;
        int m1078getDirectionT4wFHC8$foundation_layout = m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                f = this.columnGap;
                return mo428roundToPx0680j_4(f);
            }
        }
        f = this.rowGap;
        return mo428roundToPx0680j_4(f);
    }
}
