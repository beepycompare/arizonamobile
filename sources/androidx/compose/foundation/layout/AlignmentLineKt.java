package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
/* compiled from: AlignmentLine.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"paddingFrom", "Landroidx/compose/ui/Modifier;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", TtmlNode.ANNOTATION_POSITION_BEFORE, "Landroidx/compose/ui/unit/Dp;", TtmlNode.ANNOTATION_POSITION_AFTER, "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "horizontal", "", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlignmentLineKt {
    /* renamed from: paddingFrom-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m750paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.m8278getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.m8278getUnspecifiedD9Ej5fM();
        }
        return m749paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* renamed from: paddingFrom-4j6BHR0  reason: not valid java name */
    public static final Modifier m749paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f, final float f2) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", AlignmentLine.this);
                inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, Dp.m8256boximpl(f));
                inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, Dp.m8256boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFrom-Y_r0B1c$default  reason: not valid java name */
    public static /* synthetic */ Modifier m752paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.Companion.m8463getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.Companion.m8463getUnspecifiedXSAIIZE();
        }
        return m751paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    /* renamed from: paddingFrom-Y_r0B1c  reason: not valid java name */
    public static final Modifier m751paddingFromY_r0B1c(Modifier modifier, final AlignmentLine alignmentLine, final long j, final long j2) {
        AlignmentLine alignmentLine2;
        long j3;
        long j4;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j4 = j2;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("paddingFrom");
                    inspectorInfo.getProperties().set("alignmentLine", AlignmentLine.this);
                    inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, TextUnit.m8442boximpl(j));
                    inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, TextUnit.m8442boximpl(j2));
                }
            };
        } else {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j4 = j2;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine2, j3, j4, noInspectorInfo, null));
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m754paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m8278getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m8278getUnspecifiedD9Ej5fM();
        }
        return m753paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m756paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.Companion.m8463getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.Companion.m8463getUnspecifiedXSAIIZE();
        }
        return m755paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA  reason: not valid java name */
    public static final MeasureResult m748alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        int max;
        int height;
        final Placeable mo6875measureBRTryo0 = measurable.mo6875measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m8201copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m8201copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = mo6875measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? mo6875measureBRTryo0.getHeight() : mo6875measureBRTryo0.getWidth();
        int m8210getMaxHeightimpl = (getHorizontal(alignmentLine) ? Constraints.m8210getMaxHeightimpl(j) : Constraints.m8211getMaxWidthimpl(j)) - height2;
        final int coerceIn = RangesKt.coerceIn((!Float.isNaN(f) ? measureScope.mo458roundToPx0680j_4(f) : 0) - i, 0, m8210getMaxHeightimpl);
        final int coerceIn2 = RangesKt.coerceIn(((!Float.isNaN(f2) ? measureScope.mo458roundToPx0680j_4(f2) : 0) - height2) + i, 0, m8210getMaxHeightimpl - coerceIn);
        if (getHorizontal(alignmentLine)) {
            max = mo6875measureBRTryo0.getWidth();
        } else {
            max = Math.max(mo6875measureBRTryo0.getWidth() + coerceIn + coerceIn2, Constraints.m8213getMinWidthimpl(j));
        }
        final int i2 = max;
        if (getHorizontal(alignmentLine)) {
            height = Math.max(mo6875measureBRTryo0.getHeight() + coerceIn + coerceIn2, Constraints.m8212getMinHeightimpl(j));
        } else {
            height = mo6875measureBRTryo0.getHeight();
        }
        final int i3 = height;
        return MeasureScope.layout$default(measureScope, i2, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit alignmentLineOffsetMeasure_tjqqzMA$lambda$1;
                alignmentLineOffsetMeasure_tjqqzMA$lambda$1 = AlignmentLineKt.alignmentLineOffsetMeasure_tjqqzMA$lambda$1(AlignmentLine.this, f, coerceIn, i2, coerceIn2, mo6875measureBRTryo0, i3, (Placeable.PlacementScope) obj);
                return alignmentLineOffsetMeasure_tjqqzMA$lambda$1;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit alignmentLineOffsetMeasure_tjqqzMA$lambda$1(AlignmentLine alignmentLine, float f, int i, int i2, int i3, Placeable placeable, int i4, Placeable.PlacementScope placementScope) {
        int width;
        int i5;
        if (getHorizontal(alignmentLine)) {
            width = 0;
        } else {
            width = !Dp.m8263equalsimpl0(f, Dp.Companion.m8278getUnspecifiedD9Ej5fM()) ? i : (i2 - i3) - placeable.getWidth();
        }
        if (getHorizontal(alignmentLine)) {
            if (Dp.m8263equalsimpl0(f, Dp.Companion.m8278getUnspecifiedD9Ej5fM())) {
                i = (i4 - i3) - placeable.getHeight();
            }
            i5 = i;
        } else {
            i5 = 0;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, i5, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    /* renamed from: paddingFromBaseline-VpY3zN4  reason: not valid java name */
    public static final Modifier m753paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        Modifier.Companion companion;
        Modifier.Companion companion2;
        if (!Float.isNaN(f)) {
            companion = m750paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            companion = Modifier.Companion;
        }
        Modifier then = modifier.then(companion);
        if (!Float.isNaN(f2)) {
            companion2 = m750paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            companion2 = Modifier.Companion;
        }
        return then.then(companion2);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI  reason: not valid java name */
    public static final Modifier m755paddingFromBaselinewCyjxdI(Modifier modifier, long j, long j2) {
        Modifier.Companion m752paddingFromY_r0B1c$default;
        Modifier then = modifier.then(TextUnit.m8450getRawTypeimpl(j) == 0 ? Modifier.Companion : m752paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null));
        if (TextUnit.m8450getRawTypeimpl(j2) != 0) {
            m752paddingFromY_r0B1c$default = m752paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null);
        } else {
            m752paddingFromY_r0B1c$default = Modifier.Companion;
        }
        return then.then(m752paddingFromY_r0B1c$default);
    }
}
