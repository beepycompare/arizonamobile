package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlexAlignContent;
import androidx.compose.foundation.layout.FlexAlignItems;
import androidx.compose.foundation.layout.FlexAlignSelf;
import androidx.compose.foundation.layout.FlexDirection;
import androidx.compose.foundation.layout.FlexJustifyContent;
import androidx.compose.foundation.layout.FlexWrap;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlexBox.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0013\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jl\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J+\u0010)\u001a\u00020\"*\u00020\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u0017*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b.\u0010/Jt\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010(\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001b04H\u0082\b¢\u0006\u0004\b5\u00106JW\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001f2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00109\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010:\u001a\u00020&H\u0002¢\u0006\u0004\b;\u0010<JP\u0010=\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&H\u0002JG\u0010B\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010C\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002¢\u0006\u0004\bD\u0010EJ_\u0010F\u001a\u00020&2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010C\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\bG\u0010HJ@\u0010I\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010J\u001a\u00020&2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010C\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002J$\u0010K\u001a\u00020&*\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010L\u001a\u00020\u0017H\u0002JH\u0010M\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010A\u001a\u00020&2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020&2\u0006\u0010N\u001a\u00020\u0017H\u0002J?\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020&2\u0006\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020VH\u0002¢\u0006\u0004\bW\u0010XJ\u0018\u0010Y\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010Z\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020&H\u0002J0\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010T\u001a\u00020&2\u0006\u0010]\u001a\u00020\u00172\u0006\u0010:\u001a\u00020&H\u0002J\"\u0010^\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010a\u001a\u00020&H\u0016J\"\u0010b\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010c\u001a\u00020&H\u0016J\"\u0010d\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010a\u001a\u00020&H\u0016J\"\u0010e\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010c\u001a\u00020&H\u0016J'\u0010f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010g\u001a\u00020h2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\bi\u0010jR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Landroidx/compose/foundation/layout/FlexBoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "flexBoxConfigState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/layout/FlexBoxConfig;", "<init>", "(Landroidx/compose/runtime/State;)V", "resolvedFlexBoxConfig", "Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measureFlexBox", "flexBoxConfig", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "isHorizontal", "", "measureFlexBox-w1Onq5I", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/List;JZ)Landroidx/compose/ui/layout/MeasureResult;", "placeFlexItems", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lines", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/layout/FlexLine;", "Lkotlin/collections/ArrayList;", "items", "Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutWidth", "", "layoutHeight", "mainAxisGap", "createFlexItem", "measurable", "createFlexItem-XsoA538", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;ZJ)Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;", "needUpfrontCrossAxisCalculation", "needUpfrontCrossAxisCalculation-RMq0m1M", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;J)Z", "buildFlexLines", "crossAxisGap", "needsUpfrontCrossAxisCalculation", "updateTotalCrossSize", "Lkotlin/Function1;", "buildFlexLines-JlE-8fw", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/ArrayList;JIIZLkotlin/jvm/functions/Function1;)Ljava/util/ArrayList;", "processFlexLine", "line", "currentLineHypotheticalMainAxisSize", "remainingCrossAxisSize", "processFlexLine-7gjidqw", "(Landroidx/compose/foundation/layout/FlexLine;Ljava/util/ArrayList;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;IZJI)V", "resolveFlexibleLengths", "startIndex", "endIndex", "hypotheticalLineSize", "containerMainAxisSize", "applyAlignContentStretch", "totalLinesCrossSize", "applyAlignContentStretch-WWvErGg", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/ArrayList;JII)I", "measureFlexItems", "measureFlexItems-HjG58DU", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;IZJ)I", "calculateLineCrossPositions", "totalCrossAxisSpace", "totalCrossAxisSize", "isReverse", "positionItemsOnMainAxis", "isMainAxisReverse", "calculateItemCrossPosition", "flexConfig", "itemBaseline", "lineMaxAboveBaseline", "itemCrossAxisSize", "lineCrossAxisSize", "containerAlignItems", "Landroidx/compose/foundation/layout/FlexAlignItems;", "calculateItemCrossPosition-sT6f14c", "(Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;IIIII)I", "isMainAxisReversedForLayout", "calculateLineCrossAxisSize", "measureItem", "item", "shouldStretch", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "resolveFlexBoxConfig", "density", "Landroidx/compose/ui/unit/Density;", "resolveFlexBoxConfig-3p2s80s", "(Landroidx/compose/foundation/layout/FlexBoxConfig;Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlexBoxMeasurePolicy implements MeasurePolicy {
    private final State<FlexBoxConfig> flexBoxConfigState;
    private final ResolvedFlexBoxConfig resolvedFlexBoxConfig = new ResolvedFlexBoxConfig();

    /* JADX WARN: Multi-variable type inference failed */
    public FlexBoxMeasurePolicy(State<? extends FlexBoxConfig> state) {
        this.flexBoxConfigState = state;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
        if (androidx.compose.foundation.layout.FlexDirection.m862equalsimpl0(r9, androidx.compose.foundation.layout.FlexDirection.m860constructorimpl(2)) != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        LayoutOrientation layoutOrientation;
        int m1078getDirectionT4wFHC8$foundation_layout;
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m8115getMinWidthimpl(j), Constraints.m8114getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.foundation.layout.FlexBoxMeasurePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, 4, null);
        }
        ResolvedFlexBoxConfig m855resolveFlexBoxConfig3p2s80s = m855resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), measureScope, j);
        int m1078getDirectionT4wFHC8$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        boolean z = false;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout3 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout3, FlexDirection.m860constructorimpl(2))) {
                layoutOrientation = LayoutOrientation.Vertical;
                long m1019constructorimpl = OrientationIndependentConstraints.m1019constructorimpl(j, layoutOrientation);
                m1078getDirectionT4wFHC8$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
                FlexDirection.Companion companion3 = FlexDirection.Companion;
                if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
                    int m1078getDirectionT4wFHC8$foundation_layout4 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
                    FlexDirection.Companion companion4 = FlexDirection.Companion;
                }
                z = true;
                return m851measureFlexBoxw1Onq5I(measureScope, m855resolveFlexBoxConfig3p2s80s, list, m1019constructorimpl, z);
            }
        }
        layoutOrientation = LayoutOrientation.Horizontal;
        long m1019constructorimpl2 = OrientationIndependentConstraints.m1019constructorimpl(j, layoutOrientation);
        m1078getDirectionT4wFHC8$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion32 = FlexDirection.Companion;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
        }
        z = true;
        return m851measureFlexBoxw1Onq5I(measureScope, m855resolveFlexBoxConfig3p2s80s, list, m1019constructorimpl2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00cf, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r6, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L31;
     */
    /* renamed from: measureFlexBox-w1Onq5I  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MeasureResult m851measureFlexBoxw1Onq5I(final MeasureScope measureScope, final ResolvedFlexBoxConfig resolvedFlexBoxConfig, List<? extends Measurable> list, long j, final boolean z) {
        int i;
        ArrayList<ResolvedFlexItemInfo> arrayList;
        boolean z2;
        FlexLine flexLine;
        int i2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        ArrayList<ResolvedFlexItemInfo> arrayList2;
        int i6;
        FlexBoxMeasurePolicy flexBoxMeasurePolicy = this;
        ArrayList<ResolvedFlexItemInfo> arrayList3 = new ArrayList<>(list.size());
        long j2 = j;
        boolean m853needUpfrontCrossAxisCalculationRMq0m1M = flexBoxMeasurePolicy.m853needUpfrontCrossAxisCalculationRMq0m1M(resolvedFlexBoxConfig, j2);
        int size = list.size();
        boolean z4 = m853needUpfrontCrossAxisCalculationRMq0m1M;
        int i7 = 0;
        boolean z5 = false;
        while (true) {
            i = 1;
            if (i7 >= size) {
                break;
            }
            ResolvedFlexItemInfo m850createFlexItemXsoA538 = flexBoxMeasurePolicy.m850createFlexItemXsoA538(measureScope, list.get(i7), z, j2);
            if (m850createFlexItemXsoA538.getOrder$foundation_layout() != 0) {
                z5 = true;
            }
            int m1090getAlignSelf_ov7Qcc$foundation_layout = m850createFlexItemXsoA538.m1090getAlignSelf_ov7Qcc$foundation_layout();
            FlexAlignSelf.Companion companion = FlexAlignSelf.Companion;
            if (!FlexAlignSelf.m813equalsimpl0(m1090getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m811constructorimpl(5))) {
                int m1090getAlignSelf_ov7Qcc$foundation_layout2 = m850createFlexItemXsoA538.m1090getAlignSelf_ov7Qcc$foundation_layout();
                FlexAlignSelf.Companion companion2 = FlexAlignSelf.Companion;
                if (!FlexAlignSelf.m813equalsimpl0(m1090getAlignSelf_ov7Qcc$foundation_layout2, FlexAlignSelf.m811constructorimpl(4))) {
                    arrayList3.add(m850createFlexItemXsoA538);
                    i7++;
                    flexBoxMeasurePolicy = this;
                    j2 = j;
                }
            }
            z4 = true;
            arrayList3.add(m850createFlexItemXsoA538);
            i7++;
            flexBoxMeasurePolicy = this;
            j2 = j;
        }
        if (z5) {
            ArrayList<ResolvedFlexItemInfo> arrayList4 = arrayList3;
            if (arrayList4.size() > 1) {
                CollectionsKt.sortWith(arrayList4, new Comparator() { // from class: androidx.compose.foundation.layout.FlexBoxMeasurePolicy$measureFlexBox-w1Onq5I$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((ResolvedFlexItemInfo) t).getOrder$foundation_layout()), Integer.valueOf(((ResolvedFlexItemInfo) t2).getOrder$foundation_layout()));
                    }
                });
            }
        }
        final int mainAxisGap = resolvedFlexBoxConfig.mainAxisGap();
        int crossAxisGap = resolvedFlexBoxConfig.crossAxisGap();
        final ArrayList<FlexLine> arrayList5 = new ArrayList<>(8);
        FlexLine flexLine2 = new FlexLine();
        int m8112getMaxHeightimpl = Constraints.m8112getMaxHeightimpl(j);
        ArrayList<ResolvedFlexItemInfo> arrayList6 = arrayList3;
        int size2 = arrayList6.size();
        int i8 = m8112getMaxHeightimpl;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        FlexLine flexLine3 = flexLine2;
        int i13 = 0;
        while (i13 < size2) {
            ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList6.get(i13);
            int m1081getWrap7ziDAWk$foundation_layout = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion3 = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                int m1081getWrap7ziDAWk$foundation_layout2 = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion4 = FlexWrap.Companion;
            }
            if (i13 > i9 && resolvedFlexItemInfo.getHypotheticalMainSize() + i10 > Constraints.m8113getMaxWidthimpl(j)) {
                flexLine3.setStartIndex(i9);
                flexLine3.setEndIndex(i13);
                boolean z6 = z4;
                int i14 = i11;
                z3 = z6;
                i4 = i13;
                i5 = size2;
                arrayList2 = arrayList3;
                m854processFlexLine7gjidqw(flexLine3, arrayList2, resolvedFlexBoxConfig, i10 - mainAxisGap, z3, j, i8);
                i12 += flexLine3.getCrossAxisSize();
                flexLine3.setCrossStart(i14);
                int crossAxisSize = flexLine3.getCrossAxisSize() + crossAxisGap + i14;
                int crossAxisSize2 = i8 - (flexLine3.getCrossAxisSize() + crossAxisGap);
                if (crossAxisSize2 < 0) {
                    crossAxisSize2 = 0;
                }
                arrayList5.add(flexLine3);
                flexLine3 = new FlexLine();
                i10 = resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
                i6 = crossAxisSize;
                i8 = crossAxisSize2;
                i9 = i4;
                i13 = i4 + 1;
                int i15 = i6;
                z4 = z3;
                i11 = i15;
                arrayList3 = arrayList2;
                size2 = i5;
            }
            boolean z7 = z4;
            i6 = i11;
            z3 = z7;
            i4 = i13;
            i5 = size2;
            arrayList2 = arrayList3;
            i10 += resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
            i13 = i4 + 1;
            int i152 = i6;
            z4 = z3;
            i11 = i152;
            arrayList3 = arrayList2;
            size2 = i5;
        }
        boolean z8 = z4;
        int i16 = i11;
        ArrayList<ResolvedFlexItemInfo> arrayList7 = arrayList3;
        if (i9 < arrayList7.size()) {
            flexLine3.setStartIndex(i9);
            flexLine3.setEndIndex(arrayList7.size());
            m854processFlexLine7gjidqw(flexLine3, arrayList7, resolvedFlexBoxConfig, i10 - mainAxisGap, z8, j, i8);
            arrayList = arrayList7;
            z2 = z8;
            i12 += flexLine3.getCrossAxisSize();
            flexLine3.setCrossStart(i16);
            arrayList5.add(flexLine3);
        } else {
            arrayList = arrayList7;
            z2 = z8;
        }
        int i17 = i12;
        if (arrayList5.size() == 1) {
            arrayList5.get(0).setCrossAxisSize(Math.max(arrayList5.get(0).getCrossAxisSize(), Constraints.m8114getMinHeightimpl(j)));
        }
        final ArrayList<ResolvedFlexItemInfo> arrayList8 = arrayList;
        int m852measureFlexItemsHjG58DU = m852measureFlexItemsHjG58DU(arrayList5, arrayList8, resolvedFlexBoxConfig, m847applyAlignContentStretchWWvErGg(resolvedFlexBoxConfig, arrayList5, j, i17, crossAxisGap), z2, j);
        calculateLineCrossPositions(resolvedFlexBoxConfig, Math.max(m852measureFlexItemsHjG58DU, Constraints.m8114getMinHeightimpl(j)), arrayList5, m852measureFlexItemsHjG58DU, crossAxisGap);
        int m1081getWrap7ziDAWk$foundation_layout3 = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
        FlexWrap.Companion companion5 = FlexWrap.Companion;
        int max = Math.max(totalCrossAxisSize(arrayList5, FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout3, FlexWrap.m884constructorimpl(2))), Constraints.m8114getMinHeightimpl(j));
        ArrayList<FlexLine> arrayList9 = arrayList5;
        if (arrayList9.isEmpty()) {
            flexLine = null;
        } else {
            flexLine = arrayList9.get(0);
            int mainAxisSize = flexLine.getMainAxisSize();
            int lastIndex = CollectionsKt.getLastIndex(arrayList9);
            if (1 <= lastIndex) {
                while (true) {
                    FlexLine flexLine4 = arrayList9.get(i);
                    int mainAxisSize2 = flexLine4.getMainAxisSize();
                    if (mainAxisSize < mainAxisSize2) {
                        flexLine = flexLine4;
                        mainAxisSize = mainAxisSize2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        FlexLine flexLine5 = flexLine;
        int max2 = Math.max(flexLine5 != null ? flexLine5.getMainAxisSize() : Constraints.m8115getMinWidthimpl(j), Constraints.m8115getMinWidthimpl(j));
        int m8115getMinWidthimpl = Constraints.m8115getMinWidthimpl(j);
        int m8113getMaxWidthimpl = Constraints.m8113getMaxWidthimpl(j);
        if (max2 < m8115getMinWidthimpl) {
            max2 = m8115getMinWidthimpl;
        }
        if (max2 <= m8113getMaxWidthimpl) {
            m8113getMaxWidthimpl = max2;
        }
        if (z) {
            int m8114getMinHeightimpl = Constraints.m8114getMinHeightimpl(j);
            int m8112getMaxHeightimpl2 = Constraints.m8112getMaxHeightimpl(j);
            if (max < m8114getMinHeightimpl) {
                max = m8114getMinHeightimpl;
            }
            if (max <= m8112getMaxHeightimpl2) {
                m8112getMaxHeightimpl2 = max;
            }
            i3 = m8112getMaxHeightimpl2;
            i2 = m8113getMaxWidthimpl;
        } else {
            int m8114getMinHeightimpl2 = Constraints.m8114getMinHeightimpl(j);
            int m8112getMaxHeightimpl3 = Constraints.m8112getMaxHeightimpl(j);
            if (max < m8114getMinHeightimpl2) {
                max = m8114getMinHeightimpl2;
            }
            if (max <= m8112getMaxHeightimpl3) {
                m8112getMaxHeightimpl3 = max;
            }
            i2 = m8112getMaxHeightimpl3;
            i3 = m8113getMaxWidthimpl;
        }
        final int i18 = i2;
        final int i19 = i3;
        return MeasureScope.layout$default(measureScope, i2, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.FlexBoxMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlexBoxMeasurePolicy.measureFlexBox_w1Onq5I$lambda$4(FlexBoxMeasurePolicy.this, arrayList5, arrayList8, measureScope, resolvedFlexBoxConfig, i18, i19, mainAxisGap, z, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measureFlexBox_w1Onq5I$lambda$4(FlexBoxMeasurePolicy flexBoxMeasurePolicy, ArrayList arrayList, ArrayList arrayList2, MeasureScope measureScope, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, boolean z, Placeable.PlacementScope placementScope) {
        flexBoxMeasurePolicy.placeFlexItems(placementScope, arrayList, arrayList2, measureScope.getLayoutDirection(), resolvedFlexBoxConfig, i, i2, i3, z);
        return Unit.INSTANCE;
    }

    private final void placeFlexItems(Placeable.PlacementScope placementScope, ArrayList<FlexLine> arrayList, ArrayList<ResolvedFlexItemInfo> arrayList2, LayoutDirection layoutDirection, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, boolean z) {
        int crossPosition;
        int mainPosition;
        ArrayList<FlexLine> arrayList3 = arrayList;
        int size = arrayList3.size();
        for (int i4 = 0; i4 < size; i4++) {
            FlexLine flexLine = arrayList3.get(i4);
            positionItemsOnMainAxis(arrayList2, resolvedFlexBoxConfig, z ? i : i2, flexLine, i3, isMainAxisReversedForLayout(resolvedFlexBoxConfig, layoutDirection));
            int startIndex = flexLine.getStartIndex();
            int endIndex = flexLine.getEndIndex();
            if (startIndex < 0 || startIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (endIndex < 0 || endIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            while (startIndex < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList2.get(startIndex);
                if (z) {
                    crossPosition = resolvedFlexItemInfo.getMainPosition();
                } else {
                    crossPosition = resolvedFlexItemInfo.getCrossPosition();
                }
                int i5 = crossPosition;
                if (z) {
                    mainPosition = resolvedFlexItemInfo.getCrossPosition();
                } else {
                    mainPosition = resolvedFlexItemInfo.getMainPosition();
                }
                int i6 = mainPosition;
                Placeable placeable = resolvedFlexItemInfo.getPlaceable();
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i5, i6, 0.0f, 4, null);
                }
                startIndex++;
            }
        }
    }

    /* renamed from: createFlexItem-XsoA538  reason: not valid java name */
    private final ResolvedFlexItemInfo m850createFlexItemXsoA538(MeasureScope measureScope, Measurable measurable, boolean z, long j) {
        int maxContentSize$foundation_layout;
        Object parentData = measurable.getParentData();
        FlexBoxChildDataNode flexBoxChildDataNode = parentData instanceof FlexBoxChildDataNode ? (FlexBoxChildDataNode) parentData : null;
        ResolvedFlexItemInfo resolvedFlexItemInfo = new ResolvedFlexItemInfo();
        if (flexBoxChildDataNode != null) {
            resolvedFlexItemInfo.m1092prepareRMq0m1M(measureScope, j);
            flexBoxChildDataNode.getConfig().configure(resolvedFlexItemInfo);
        }
        resolvedFlexItemInfo.setMeasurable(measurable);
        int minMainAxisSize$foundation_layout = resolvedFlexItemInfo.getMinMainAxisSize$foundation_layout(z);
        if (FlexBasis.m830isDpimpl$foundation_layout(resolvedFlexItemInfo.m1091getBasisdlZNVs$foundation_layout())) {
            maxContentSize$foundation_layout = measureScope.mo428roundToPx0680j_4(Dp.m8160constructorimpl(FlexBasis.m827getValueimpl$foundation_layout(resolvedFlexItemInfo.m1091getBasisdlZNVs$foundation_layout())));
        } else if (!FlexBasis.m831isPercentimpl$foundation_layout(resolvedFlexItemInfo.m1091getBasisdlZNVs$foundation_layout())) {
            maxContentSize$foundation_layout = FlexBasis.m829isAutoimpl$foundation_layout(resolvedFlexItemInfo.m1091getBasisdlZNVs$foundation_layout()) ? resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z) : resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z);
        } else if (Constraints.m8113getMaxWidthimpl(j) == Integer.MAX_VALUE || Float.isNaN(FlexBasis.m827getValueimpl$foundation_layout(resolvedFlexItemInfo.m1091getBasisdlZNVs$foundation_layout()))) {
            maxContentSize$foundation_layout = resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z);
        } else {
            maxContentSize$foundation_layout = (int) (Constraints.m8113getMaxWidthimpl(j) * FlexBasis.m827getValueimpl$foundation_layout(resolvedFlexItemInfo.m1091getBasisdlZNVs$foundation_layout()));
        }
        resolvedFlexItemInfo.setFlexBaseSize(maxContentSize$foundation_layout);
        if (maxContentSize$foundation_layout >= minMainAxisSize$foundation_layout) {
            minMainAxisSize$foundation_layout = maxContentSize$foundation_layout;
        }
        resolvedFlexItemInfo.setHypotheticalMainSize(minMainAxisSize$foundation_layout);
        resolvedFlexItemInfo.setTargetMainSize(resolvedFlexItemInfo.getHypotheticalMainSize());
        return resolvedFlexItemInfo;
    }

    /* renamed from: needUpfrontCrossAxisCalculation-RMq0m1M  reason: not valid java name */
    private final boolean m853needUpfrontCrossAxisCalculationRMq0m1M(ResolvedFlexBoxConfig resolvedFlexBoxConfig, long j) {
        int m1076getAlignItems20X20zU$foundation_layout = resolvedFlexBoxConfig.m1076getAlignItems20X20zU$foundation_layout();
        FlexAlignItems.Companion companion = FlexAlignItems.Companion;
        if (!FlexAlignItems.m801equalsimpl0(m1076getAlignItems20X20zU$foundation_layout, FlexAlignItems.m799constructorimpl(3))) {
            int m1076getAlignItems20X20zU$foundation_layout2 = resolvedFlexBoxConfig.m1076getAlignItems20X20zU$foundation_layout();
            FlexAlignItems.Companion companion2 = FlexAlignItems.Companion;
            if (!FlexAlignItems.m801equalsimpl0(m1076getAlignItems20X20zU$foundation_layout2, FlexAlignItems.m799constructorimpl(4))) {
                int m1081getWrap7ziDAWk$foundation_layout = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion3 = FlexWrap.Companion;
                if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                    int m1081getWrap7ziDAWk$foundation_layout2 = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
                    FlexWrap.Companion companion4 = FlexWrap.Companion;
                    if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout2, FlexWrap.m884constructorimpl(2))) {
                        return false;
                    }
                }
                int m1075getAlignContentd9B3MrI$foundation_layout = resolvedFlexBoxConfig.m1075getAlignContentd9B3MrI$foundation_layout();
                FlexAlignContent.Companion companion5 = FlexAlignContent.Companion;
                if (!FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout, FlexAlignContent.m786constructorimpl(3)) || Constraints.m8112getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004d, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r9, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L10;
     */
    /* renamed from: buildFlexLines-JlE-8fw  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<FlexLine> m848buildFlexLinesJlE8fw(ResolvedFlexBoxConfig resolvedFlexBoxConfig, ArrayList<ResolvedFlexItemInfo> arrayList, long j, int i, int i2, boolean z, Function1<? super Integer, Unit> function1) {
        ArrayList<FlexLine> arrayList2 = new ArrayList<>(8);
        FlexLine flexLine = new FlexLine();
        int m8112getMaxHeightimpl = Constraints.m8112getMaxHeightimpl(j);
        ArrayList<ResolvedFlexItemInfo> arrayList3 = arrayList;
        int size = arrayList3.size();
        FlexLine flexLine2 = flexLine;
        int i3 = m8112getMaxHeightimpl;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList3.get(i8);
            int m1081getWrap7ziDAWk$foundation_layout = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                int m1081getWrap7ziDAWk$foundation_layout2 = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion2 = FlexWrap.Companion;
            }
            if (i8 > i4 && resolvedFlexItemInfo.getHypotheticalMainSize() + i5 > Constraints.m8113getMaxWidthimpl(j)) {
                flexLine2.setStartIndex(i4);
                flexLine2.setEndIndex(i8);
                int i9 = i6;
                m854processFlexLine7gjidqw(flexLine2, arrayList, resolvedFlexBoxConfig, i5 - i, z, j, i3);
                i7 += flexLine2.getCrossAxisSize();
                flexLine2.setCrossStart(i9);
                i6 = i9 + flexLine2.getCrossAxisSize() + i2;
                i3 -= flexLine2.getCrossAxisSize() + i2;
                if (i3 < 0) {
                    i3 = 0;
                }
                arrayList2.add(flexLine2);
                FlexLine flexLine3 = new FlexLine();
                i5 = resolvedFlexItemInfo.getHypotheticalMainSize() + i;
                flexLine2 = flexLine3;
                i4 = i8;
            }
            i5 += resolvedFlexItemInfo.getHypotheticalMainSize() + i;
        }
        if (i4 < arrayList.size()) {
            flexLine2.setStartIndex(i4);
            flexLine2.setEndIndex(arrayList.size());
            m854processFlexLine7gjidqw(flexLine2, arrayList, resolvedFlexBoxConfig, i5 - i, z, j, i3);
            i7 += flexLine2.getCrossAxisSize();
            flexLine2.setCrossStart(i6);
            arrayList2.add(flexLine2);
        }
        function1.invoke(Integer.valueOf(i7));
        return arrayList2;
    }

    private final int resolveFlexibleLengths(boolean z, ArrayList<ResolvedFlexItemInfo> arrayList, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, int i4) {
        int i5;
        boolean z2;
        ArrayList<ResolvedFlexItemInfo> arrayList2 = arrayList;
        int i6 = i;
        int i7 = i4;
        int i8 = i2 - i6;
        int mainAxisGap = i8 > 0 ? (i8 - 1) * resolvedFlexBoxConfig.mainAxisGap() : 0;
        if (i7 == Integer.MAX_VALUE) {
            if (i6 < 0 || i6 > arrayList2.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (i2 < 0 || i2 > arrayList2.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            while (i6 < i2) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList2.get(i6);
                resolvedFlexItemInfo.setTargetMainSize(resolvedFlexItemInfo.getHypotheticalMainSize());
                mainAxisGap += resolvedFlexItemInfo.getTargetMainSize();
                i6++;
            }
            return mainAxisGap;
        }
        boolean z3 = i3 < i7;
        if (i6 < 0 || i6 > arrayList2.size()) {
            throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
        }
        if (i2 < 0 || i2 > arrayList2.size()) {
            throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
        }
        int i9 = 0;
        int i10 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        int i11 = 0;
        float f3 = 0.0f;
        for (int i12 = i6; i12 < i2; i12++) {
            ResolvedFlexItemInfo resolvedFlexItemInfo2 = arrayList2.get(i12);
            float grow$foundation_layout = z3 ? resolvedFlexItemInfo2.getGrow$foundation_layout() : resolvedFlexItemInfo2.getShrink$foundation_layout();
            if (grow$foundation_layout == 0.0f || (!z3 && resolvedFlexItemInfo2.getFlexBaseSize() < resolvedFlexItemInfo2.getHypotheticalMainSize())) {
                resolvedFlexItemInfo2.setTargetMainSize(resolvedFlexItemInfo2.getHypotheticalMainSize());
                resolvedFlexItemInfo2.setFrozen(true);
                i9 += resolvedFlexItemInfo2.getTargetMainSize();
            } else {
                resolvedFlexItemInfo2.setFrozen(false);
                i11++;
                i10 += resolvedFlexItemInfo2.getFlexBaseSize();
                f += grow$foundation_layout;
                if (z3) {
                    f2 += resolvedFlexItemInfo2.getGrow$foundation_layout();
                } else {
                    f3 += resolvedFlexItemInfo2.getShrink$foundation_layout() * resolvedFlexItemInfo2.getFlexBaseSize();
                }
            }
        }
        int i13 = 0;
        float f4 = ((i7 - mainAxisGap) - i9) - i10;
        float f5 = 1.0f;
        if (z3) {
            float f6 = i7 - ((mainAxisGap + i9) + i10);
            if (f < 1.0f) {
                float f7 = f4 * f;
                if (Math.abs(f7) < Math.abs(f6)) {
                    f6 = f7;
                }
            }
            if (i6 < 0 || i6 > arrayList2.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (i2 < 0 || i2 > arrayList2.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            while (i6 < i2) {
                ResolvedFlexItemInfo resolvedFlexItemInfo3 = arrayList2.get(i6);
                if (!resolvedFlexItemInfo3.isFrozen()) {
                    int round = Math.round((f2 > 0.0f ? resolvedFlexItemInfo3.getGrow$foundation_layout() / f2 : 0.0f) * f6);
                    f6 -= round;
                    f2 -= resolvedFlexItemInfo3.getGrow$foundation_layout();
                    resolvedFlexItemInfo3.setTargetMainSize(resolvedFlexItemInfo3.getFlexBaseSize() + round);
                    i13 += resolvedFlexItemInfo3.getTargetMainSize();
                }
                i6++;
            }
        } else {
            int i14 = 0;
            int i15 = 0;
            boolean z4 = true;
            while (z4 && i14 < i8) {
                i14++;
                if (i11 == 0) {
                    i13 = 0;
                    break;
                }
                float f8 = i7 - ((mainAxisGap + i9) + i10);
                if (f < f5) {
                    float f9 = f4 * f;
                    if (Math.abs(f9) < Math.abs(f8)) {
                        f8 = f9;
                    }
                }
                float abs = Math.abs(f8);
                if (i6 < 0 || i6 > arrayList2.size()) {
                    throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
                }
                if (i2 < 0 || i2 > arrayList2.size()) {
                    throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
                }
                int i16 = i6;
                float f10 = abs;
                float f11 = f3;
                z4 = false;
                i15 = 0;
                while (i16 < i2) {
                    ResolvedFlexItemInfo resolvedFlexItemInfo4 = arrayList2.get(i16);
                    if (resolvedFlexItemInfo4.isFrozen()) {
                        i5 = i8;
                        z2 = true;
                    } else {
                        float shrink$foundation_layout = resolvedFlexItemInfo4.getShrink$foundation_layout() * resolvedFlexItemInfo4.getFlexBaseSize();
                        int round2 = Math.round((f11 > 0.0f ? shrink$foundation_layout / f11 : 0.0f) * f10);
                        int flexBaseSize = resolvedFlexItemInfo4.getFlexBaseSize() - round2;
                        i5 = i8;
                        float f12 = f10;
                        int minMainAxisSize$foundation_layout = resolvedFlexItemInfo4.getMinMainAxisSize$foundation_layout(z);
                        if (flexBaseSize < minMainAxisSize$foundation_layout) {
                            z2 = true;
                            resolvedFlexItemInfo4.setFrozen(true);
                            f11 -= shrink$foundation_layout;
                            resolvedFlexItemInfo4.setTargetMainSize(minMainAxisSize$foundation_layout);
                            i11--;
                            i9 += minMainAxisSize$foundation_layout;
                            i10 -= resolvedFlexItemInfo4.getFlexBaseSize();
                            f3 -= shrink$foundation_layout;
                            f -= resolvedFlexItemInfo4.getShrink$foundation_layout();
                            f10 = f12 - (resolvedFlexItemInfo4.getFlexBaseSize() - minMainAxisSize$foundation_layout);
                            z4 = true;
                        } else {
                            z2 = true;
                            f10 = f12 - round2;
                            f11 -= shrink$foundation_layout;
                            resolvedFlexItemInfo4.setTargetMainSize(flexBaseSize);
                            i15 += resolvedFlexItemInfo4.getTargetMainSize();
                        }
                    }
                    i16++;
                    arrayList2 = arrayList;
                    i8 = i5;
                }
                arrayList2 = arrayList;
                i7 = i4;
                f5 = 1.0f;
            }
            i13 = i15;
        }
        return mainAxisGap + i9 + i13;
    }

    /* renamed from: applyAlignContentStretch-WWvErGg  reason: not valid java name */
    private final int m847applyAlignContentStretchWWvErGg(ResolvedFlexBoxConfig resolvedFlexBoxConfig, ArrayList<FlexLine> arrayList, long j, int i, int i2) {
        int m1075getAlignContentd9B3MrI$foundation_layout = resolvedFlexBoxConfig.m1075getAlignContentd9B3MrI$foundation_layout();
        FlexAlignContent.Companion companion = FlexAlignContent.Companion;
        if (FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout, FlexAlignContent.m786constructorimpl(3)) && Constraints.m8114getMinHeightimpl(j) != Integer.MAX_VALUE && !arrayList.isEmpty() && arrayList.size() != 1) {
            int size = (arrayList.size() - 1) * i2;
            int m8114getMinHeightimpl = Constraints.m8114getMinHeightimpl(j);
            if (i + size < m8114getMinHeightimpl) {
                int i3 = (m8114getMinHeightimpl - i) - size;
                if (i3 < 0) {
                    i3 = 0;
                }
                int size2 = i3 / arrayList.size();
                ArrayList<FlexLine> arrayList2 = arrayList;
                int size3 = arrayList2.size();
                int i4 = 0;
                for (int i5 = 0; i5 < size3; i5++) {
                    FlexLine flexLine = arrayList2.get(i5);
                    flexLine.setCrossStart(i4);
                    flexLine.setCrossAxisSize(flexLine.getCrossAxisSize() + size2);
                    i4 += flexLine.getCrossAxisSize() + i2;
                    i += size2;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r8, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r8, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calculateLineCrossPositions(ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, ArrayList<FlexLine> arrayList, int i2, int i3) {
        int size;
        if (arrayList.isEmpty() || arrayList.size() == 1) {
            return;
        }
        int size2 = (i - i2) - ((arrayList.size() - 1) * i3);
        int m1075getAlignContentd9B3MrI$foundation_layout = resolvedFlexBoxConfig.m1075getAlignContentd9B3MrI$foundation_layout();
        FlexAlignContent.Companion companion = FlexAlignContent.Companion;
        if (FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout, FlexAlignContent.m786constructorimpl(5))) {
            size = size2 / arrayList.size();
        } else {
            FlexAlignContent.Companion companion2 = FlexAlignContent.Companion;
            size = FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout, FlexAlignContent.m786constructorimpl(4)) ? size2 / (arrayList.size() - 1) : 0;
        }
        int m1075getAlignContentd9B3MrI$foundation_layout2 = resolvedFlexBoxConfig.m1075getAlignContentd9B3MrI$foundation_layout();
        FlexAlignContent.Companion companion3 = FlexAlignContent.Companion;
        if (!FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout2, FlexAlignContent.m786constructorimpl(1))) {
            FlexAlignContent.Companion companion4 = FlexAlignContent.Companion;
            if (FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout2, FlexAlignContent.m786constructorimpl(2))) {
                size2 /= 2;
            } else {
                FlexAlignContent.Companion companion5 = FlexAlignContent.Companion;
                if (FlexAlignContent.m788equalsimpl0(m1075getAlignContentd9B3MrI$foundation_layout2, FlexAlignContent.m786constructorimpl(5))) {
                    size2 = size / 2;
                } else {
                    int m1081getWrap7ziDAWk$foundation_layout = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
                    FlexWrap.Companion companion6 = FlexWrap.Companion;
                }
            }
            int m1081getWrap7ziDAWk$foundation_layout2 = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion7 = FlexWrap.Companion;
            IntRange reversed = FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout2, FlexWrap.m884constructorimpl(2)) ? RangesKt.reversed(CollectionsKt.getIndices(arrayList)) : CollectionsKt.getIndices(arrayList);
            int first = reversed.getFirst();
            int last = reversed.getLast();
            int step = reversed.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return;
            }
            while (true) {
                FlexLine flexLine = arrayList.get(first);
                flexLine.setCrossStart(size2);
                size2 += flexLine.getCrossAxisSize() + size + i3;
                if (first == last) {
                    return;
                }
                first += step;
            }
        } else {
            int m1081getWrap7ziDAWk$foundation_layout3 = resolvedFlexBoxConfig.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion8 = FlexWrap.Companion;
        }
    }

    private final int totalCrossAxisSize(ArrayList<FlexLine> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        int lastIndex = z ? 0 : CollectionsKt.getLastIndex(arrayList);
        return arrayList.get(lastIndex).getCrossStart() + arrayList.get(lastIndex).getCrossAxisSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        if (r19 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (r19 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void positionItemsOnMainAxis(ArrayList<ResolvedFlexItemInfo> arrayList, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, FlexLine flexLine, int i2, boolean z) {
        int i3;
        IntRange until;
        int endIndex = flexLine.getEndIndex() - flexLine.getStartIndex();
        if (endIndex == 0) {
            return;
        }
        int mainAxisSize = i - flexLine.getMainAxisSize();
        int m1079getJustifyContentGomtQF4$foundation_layout = resolvedFlexBoxConfig.m1079getJustifyContentGomtQF4$foundation_layout();
        FlexJustifyContent.Companion companion = FlexJustifyContent.Companion;
        if (FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout, FlexJustifyContent.m871constructorimpl(4))) {
            i3 = mainAxisSize / endIndex;
        } else {
            FlexJustifyContent.Companion companion2 = FlexJustifyContent.Companion;
            if (FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout, FlexJustifyContent.m871constructorimpl(3))) {
                if (endIndex > 1) {
                    i3 = mainAxisSize / (endIndex - 1);
                }
                i3 = 0;
            } else {
                FlexJustifyContent.Companion companion3 = FlexJustifyContent.Companion;
                if (FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout, FlexJustifyContent.m871constructorimpl(5))) {
                    i3 = mainAxisSize / (endIndex + 1);
                }
                i3 = 0;
            }
        }
        int m1079getJustifyContentGomtQF4$foundation_layout2 = resolvedFlexBoxConfig.m1079getJustifyContentGomtQF4$foundation_layout();
        FlexJustifyContent.Companion companion4 = FlexJustifyContent.Companion;
        if (!FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout2, FlexJustifyContent.m871constructorimpl(1))) {
            FlexJustifyContent.Companion companion5 = FlexJustifyContent.Companion;
            if (FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout2, FlexJustifyContent.m871constructorimpl(2))) {
                mainAxisSize /= 2;
            } else {
                FlexJustifyContent.Companion companion6 = FlexJustifyContent.Companion;
                if (FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout2, FlexJustifyContent.m871constructorimpl(4))) {
                    mainAxisSize = i3 / 2;
                } else {
                    FlexJustifyContent.Companion companion7 = FlexJustifyContent.Companion;
                    if (FlexJustifyContent.m873equalsimpl0(m1079getJustifyContentGomtQF4$foundation_layout2, FlexJustifyContent.m871constructorimpl(5))) {
                        mainAxisSize = i3;
                    }
                }
            }
            if (z) {
                until = RangesKt.downTo(flexLine.getEndIndex() - 1, flexLine.getStartIndex());
            } else {
                until = RangesKt.until(flexLine.getStartIndex(), flexLine.getEndIndex());
            }
            int first = until.getFirst();
            int last = until.getLast();
            int step = until.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return;
            }
            while (true) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList.get(first);
                resolvedFlexItemInfo.setMainPosition(mainAxisSize);
                mainAxisSize += resolvedFlexItemInfo.getTargetMainSize() + i3 + i2;
                resolvedFlexItemInfo.setCrossPosition(flexLine.getCrossStart() + m849calculateItemCrossPositionsT6f14c(resolvedFlexItemInfo, resolvedFlexItemInfo.getBaseline(), flexLine.getMaxAboveBaseline(), resolvedFlexItemInfo.getCrossAxisSize(), flexLine.getCrossAxisSize(), resolvedFlexBoxConfig.m1076getAlignItems20X20zU$foundation_layout()));
                if (first == last) {
                    return;
                }
                first += step;
            }
        }
    }

    /* renamed from: calculateItemCrossPosition-sT6f14c  reason: not valid java name */
    private final int m849calculateItemCrossPositionsT6f14c(ResolvedFlexItemInfo resolvedFlexItemInfo, int i, int i2, int i3, int i4, int i5) {
        int m811constructorimpl;
        int m1090getAlignSelf_ov7Qcc$foundation_layout = resolvedFlexItemInfo.m1090getAlignSelf_ov7Qcc$foundation_layout();
        FlexAlignSelf.Companion companion = FlexAlignSelf.Companion;
        if (!FlexAlignSelf.m813equalsimpl0(m1090getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m811constructorimpl(0))) {
            m811constructorimpl = resolvedFlexItemInfo.m1090getAlignSelf_ov7Qcc$foundation_layout();
        } else {
            FlexAlignItems.Companion companion2 = FlexAlignItems.Companion;
            if (!FlexAlignItems.m801equalsimpl0(i5, FlexAlignItems.m799constructorimpl(0))) {
                FlexAlignItems.Companion companion3 = FlexAlignItems.Companion;
                if (!FlexAlignItems.m801equalsimpl0(i5, FlexAlignItems.m799constructorimpl(1))) {
                    FlexAlignItems.Companion companion4 = FlexAlignItems.Companion;
                    if (!FlexAlignItems.m801equalsimpl0(i5, FlexAlignItems.m799constructorimpl(2))) {
                        FlexAlignItems.Companion companion5 = FlexAlignItems.Companion;
                        if (!FlexAlignItems.m801equalsimpl0(i5, FlexAlignItems.m799constructorimpl(3))) {
                            FlexAlignItems.Companion companion6 = FlexAlignItems.Companion;
                            if (!FlexAlignItems.m801equalsimpl0(i5, FlexAlignItems.m799constructorimpl(4))) {
                                FlexAlignSelf.Companion companion7 = FlexAlignSelf.Companion;
                                m811constructorimpl = FlexAlignSelf.m811constructorimpl(1);
                            } else {
                                FlexAlignSelf.Companion companion8 = FlexAlignSelf.Companion;
                                m811constructorimpl = FlexAlignSelf.m811constructorimpl(5);
                            }
                        } else {
                            FlexAlignSelf.Companion companion9 = FlexAlignSelf.Companion;
                            m811constructorimpl = FlexAlignSelf.m811constructorimpl(4);
                        }
                    } else {
                        FlexAlignSelf.Companion companion10 = FlexAlignSelf.Companion;
                        m811constructorimpl = FlexAlignSelf.m811constructorimpl(3);
                    }
                } else {
                    FlexAlignSelf.Companion companion11 = FlexAlignSelf.Companion;
                    m811constructorimpl = FlexAlignSelf.m811constructorimpl(2);
                }
            } else {
                FlexAlignSelf.Companion companion12 = FlexAlignSelf.Companion;
                m811constructorimpl = FlexAlignSelf.m811constructorimpl(1);
            }
        }
        FlexAlignSelf.Companion companion13 = FlexAlignSelf.Companion;
        if (FlexAlignSelf.m813equalsimpl0(m811constructorimpl, FlexAlignSelf.m811constructorimpl(1))) {
            return 0;
        }
        FlexAlignSelf.Companion companion14 = FlexAlignSelf.Companion;
        if (FlexAlignSelf.m813equalsimpl0(m811constructorimpl, FlexAlignSelf.m811constructorimpl(2))) {
            return i4 - i3;
        }
        FlexAlignSelf.Companion companion15 = FlexAlignSelf.Companion;
        if (FlexAlignSelf.m813equalsimpl0(m811constructorimpl, FlexAlignSelf.m811constructorimpl(3))) {
            return (i4 - i3) / 2;
        }
        FlexAlignSelf.Companion companion16 = FlexAlignSelf.Companion;
        if (FlexAlignSelf.m813equalsimpl0(m811constructorimpl, FlexAlignSelf.m811constructorimpl(4))) {
            return 0;
        }
        FlexAlignSelf.Companion companion17 = FlexAlignSelf.Companion;
        if (!FlexAlignSelf.m813equalsimpl0(m811constructorimpl, FlexAlignSelf.m811constructorimpl(5)) || i == Integer.MIN_VALUE) {
            return 0;
        }
        return i2 - i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isMainAxisReversedForLayout(ResolvedFlexBoxConfig resolvedFlexBoxConfig, LayoutDirection layoutDirection) {
        boolean z;
        int m1078getDirectionT4wFHC8$foundation_layout;
        int m1078getDirectionT4wFHC8$foundation_layout2 = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
            int m1078getDirectionT4wFHC8$foundation_layout3 = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout3, FlexDirection.m860constructorimpl(3))) {
                z = false;
                m1078getDirectionT4wFHC8$foundation_layout = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
                FlexDirection.Companion companion3 = FlexDirection.Companion;
                if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
                    int m1078getDirectionT4wFHC8$foundation_layout4 = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
                    FlexDirection.Companion companion4 = FlexDirection.Companion;
                    if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout4, FlexDirection.m860constructorimpl(2))) {
                        return z;
                    }
                }
                return layoutDirection != LayoutDirection.Rtl ? !z : z;
            }
        }
        z = true;
        m1078getDirectionT4wFHC8$foundation_layout = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion32 = FlexDirection.Companion;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
        }
        if (layoutDirection != LayoutDirection.Rtl) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r10, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L18;
     */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig m855resolveFlexBoxConfig3p2s80s = m855resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        int m1078getDirectionT4wFHC8$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        int i2 = 0;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int mainAxisGap = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int crossAxisGap = m855resolveFlexBoxConfig3p2s80s.crossAxisGap();
                int size = list.size();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i2 < size) {
                    IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
                    int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
                    int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(minIntrinsicHeight);
                    int m1081getWrap7ziDAWk$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                    FlexWrap.Companion companion3 = FlexWrap.Companion;
                    if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                        int m1081getWrap7ziDAWk$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                        FlexWrap.Companion companion4 = FlexWrap.Companion;
                    }
                    if (i5 != 0 && i5 + minIntrinsicHeight > i) {
                        i3 += i4 + crossAxisGap;
                        i4 = minIntrinsicWidth;
                        i5 = minIntrinsicHeight + mainAxisGap;
                        i2++;
                    }
                    i5 += minIntrinsicHeight + mainAxisGap;
                    i4 = Math.max(i4, minIntrinsicWidth);
                    i2++;
                }
                return i3 + i4;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int mainAxisGap2 = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int m1081getWrap7ziDAWk$foundation_layout3 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
        FlexWrap.Companion companion5 = FlexWrap.Companion;
        if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout3, FlexWrap.m884constructorimpl(1))) {
            int m1081getWrap7ziDAWk$foundation_layout4 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion6 = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout4, FlexWrap.m884constructorimpl(2))) {
                int size2 = list.size();
                int i6 = 0;
                for (int i7 = 0; i7 < size2; i7++) {
                    i6 += list.get(i7).minIntrinsicWidth(i);
                }
                return i6 + (RangesKt.coerceAtLeast(list.size() - 1, 0) * mainAxisGap2);
            }
        }
        int size3 = list.size();
        int i8 = 0;
        while (i2 < size3) {
            i8 = Math.max(i8, list.get(i2).minIntrinsicWidth(i));
            i2++;
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f5, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r10, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L36;
     */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig m855resolveFlexBoxConfig3p2s80s = m855resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        int m1078getDirectionT4wFHC8$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        int i2 = 0;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int mainAxisGap = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int m1081getWrap7ziDAWk$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion3 = FlexWrap.Companion;
                if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                    int m1081getWrap7ziDAWk$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                    FlexWrap.Companion companion4 = FlexWrap.Companion;
                    if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout2, FlexWrap.m884constructorimpl(2))) {
                        int size = list.size();
                        int i3 = 0;
                        for (int i4 = 0; i4 < size; i4++) {
                            i3 += list.get(i4).minIntrinsicHeight(i);
                        }
                        return i3 + (RangesKt.coerceAtLeast(list.size() - 1, 0) * mainAxisGap);
                    }
                }
                int size2 = list.size();
                int i5 = 0;
                while (i2 < size2) {
                    i5 = Math.max(i5, list.get(i2).minIntrinsicHeight(i));
                    i2++;
                }
                return i5;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int mainAxisGap2 = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int crossAxisGap = m855resolveFlexBoxConfig3p2s80s.crossAxisGap();
        int size3 = list.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i2 < size3) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Integer.MAX_VALUE);
            int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(minIntrinsicWidth);
            int m1081getWrap7ziDAWk$foundation_layout3 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion5 = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout3, FlexWrap.m884constructorimpl(1))) {
                int m1081getWrap7ziDAWk$foundation_layout4 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion6 = FlexWrap.Companion;
            }
            if (i8 != 0 && i8 + minIntrinsicWidth > i) {
                i6 += i7 + crossAxisGap;
                i7 = minIntrinsicHeight;
                i8 = minIntrinsicWidth + mainAxisGap2;
                i2++;
            }
            i8 += minIntrinsicWidth + mainAxisGap2;
            i7 = Math.max(i7, minIntrinsicHeight);
            i2++;
        }
        return i6 + i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r10, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L18;
     */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig m855resolveFlexBoxConfig3p2s80s = m855resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        int m1078getDirectionT4wFHC8$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        int i2 = 0;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int mainAxisGap = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int crossAxisGap = m855resolveFlexBoxConfig3p2s80s.crossAxisGap();
                int size = list.size();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i2 < size) {
                    IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
                    int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
                    int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(maxIntrinsicHeight);
                    int m1081getWrap7ziDAWk$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                    FlexWrap.Companion companion3 = FlexWrap.Companion;
                    if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                        int m1081getWrap7ziDAWk$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                        FlexWrap.Companion companion4 = FlexWrap.Companion;
                    }
                    if (i5 != 0 && i5 + maxIntrinsicHeight > i) {
                        i3 += i4 + crossAxisGap;
                        i4 = maxIntrinsicWidth;
                        i5 = maxIntrinsicHeight + mainAxisGap;
                        i2++;
                    }
                    i5 += maxIntrinsicHeight + mainAxisGap;
                    i4 = Math.max(i4, maxIntrinsicWidth);
                    i2++;
                }
                return i3 + i4;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int mainAxisGap2 = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int m1081getWrap7ziDAWk$foundation_layout3 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
        FlexWrap.Companion companion5 = FlexWrap.Companion;
        if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout3, FlexWrap.m884constructorimpl(1))) {
            int m1081getWrap7ziDAWk$foundation_layout4 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion6 = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout4, FlexWrap.m884constructorimpl(2))) {
                int size2 = list.size();
                int i6 = 0;
                for (int i7 = 0; i7 < size2; i7++) {
                    i6 += list.get(i7).maxIntrinsicWidth(i);
                }
                return i6 + (RangesKt.coerceAtLeast(list.size() - 1, 0) * mainAxisGap2);
            }
        }
        int size3 = list.size();
        int i8 = 0;
        while (i2 < size3) {
            i8 = Math.max(i8, list.get(i2).maxIntrinsicWidth(i));
            i2++;
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f5, code lost:
        if (androidx.compose.foundation.layout.FlexWrap.m886equalsimpl0(r10, androidx.compose.foundation.layout.FlexWrap.m884constructorimpl(2)) != false) goto L36;
     */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig m855resolveFlexBoxConfig3p2s80s = m855resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        int m1078getDirectionT4wFHC8$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        int i2 = 0;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int mainAxisGap = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int m1081getWrap7ziDAWk$foundation_layout = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion3 = FlexWrap.Companion;
                if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout, FlexWrap.m884constructorimpl(1))) {
                    int m1081getWrap7ziDAWk$foundation_layout2 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                    FlexWrap.Companion companion4 = FlexWrap.Companion;
                    if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout2, FlexWrap.m884constructorimpl(2))) {
                        int size = list.size();
                        int i3 = 0;
                        for (int i4 = 0; i4 < size; i4++) {
                            i3 += list.get(i4).maxIntrinsicHeight(i);
                        }
                        return i3 + (RangesKt.coerceAtLeast(list.size() - 1, 0) * mainAxisGap);
                    }
                }
                int size2 = list.size();
                int i5 = 0;
                while (i2 < size2) {
                    i5 = Math.max(i5, list.get(i2).maxIntrinsicHeight(i));
                    i2++;
                }
                return i5;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int mainAxisGap2 = m855resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int crossAxisGap = m855resolveFlexBoxConfig3p2s80s.crossAxisGap();
        int size3 = list.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i2 < size3) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE);
            int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(maxIntrinsicWidth);
            int m1081getWrap7ziDAWk$foundation_layout3 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
            FlexWrap.Companion companion5 = FlexWrap.Companion;
            if (!FlexWrap.m886equalsimpl0(m1081getWrap7ziDAWk$foundation_layout3, FlexWrap.m884constructorimpl(1))) {
                int m1081getWrap7ziDAWk$foundation_layout4 = m855resolveFlexBoxConfig3p2s80s.m1081getWrap7ziDAWk$foundation_layout();
                FlexWrap.Companion companion6 = FlexWrap.Companion;
            }
            if (i8 != 0 && i8 + maxIntrinsicWidth > i) {
                i6 += i7 + crossAxisGap;
                i7 = maxIntrinsicHeight;
                i8 = maxIntrinsicWidth + mainAxisGap2;
                i2++;
            }
            i8 += maxIntrinsicWidth + mainAxisGap2;
            i7 = Math.max(i7, maxIntrinsicHeight);
            i2++;
        }
        return i6 + i7;
    }

    /* renamed from: resolveFlexBoxConfig-3p2s80s  reason: not valid java name */
    private final ResolvedFlexBoxConfig m855resolveFlexBoxConfig3p2s80s(FlexBoxConfig flexBoxConfig, Density density, long j) {
        this.resolvedFlexBoxConfig.m1082prepare0kLqBqw(density, j);
        flexBoxConfig.configure(this.resolvedFlexBoxConfig);
        return this.resolvedFlexBoxConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (androidx.compose.foundation.layout.FlexDirection.m862equalsimpl0(r0, androidx.compose.foundation.layout.FlexDirection.m860constructorimpl(2)) != false) goto L11;
     */
    /* renamed from: processFlexLine-7gjidqw  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m854processFlexLine7gjidqw(FlexLine flexLine, ArrayList<ResolvedFlexItemInfo> arrayList, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, boolean z, long j, int i2) {
        int m1078getDirectionT4wFHC8$foundation_layout = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        boolean z2 = false;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
        }
        z2 = true;
        flexLine.setMainAxisSize(resolveFlexibleLengths(z2, arrayList, resolvedFlexBoxConfig, flexLine.getStartIndex(), flexLine.getEndIndex(), i, Constraints.m8113getMaxWidthimpl(j)));
        if (z) {
            calculateLineCrossAxisSize(arrayList, resolvedFlexBoxConfig, flexLine, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
        if (androidx.compose.foundation.layout.FlexAlignContent.m788equalsimpl0(r4, androidx.compose.foundation.layout.FlexAlignContent.m786constructorimpl(3)) != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0 A[SYNTHETIC] */
    /* renamed from: measureFlexItems-HjG58DU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m852measureFlexItemsHjG58DU(ArrayList<FlexLine> arrayList, ArrayList<ResolvedFlexItemInfo> arrayList2, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, boolean z, long j) {
        boolean z2;
        int i2;
        FlexBoxMeasurePolicy flexBoxMeasurePolicy;
        int i3;
        int m8112getMaxHeightimpl = Constraints.m8112getMaxHeightimpl(j);
        ArrayList<FlexLine> arrayList3 = arrayList;
        int size = arrayList3.size();
        int i4 = 0;
        int i5 = i;
        int i6 = m8112getMaxHeightimpl;
        int i7 = 0;
        while (i7 < size) {
            FlexLine flexLine = arrayList3.get(i7);
            int crossAxisSize = z ? flexLine.getCrossAxisSize() : i4;
            int startIndex = flexLine.getStartIndex();
            int endIndex = flexLine.getEndIndex();
            if (startIndex < 0 || startIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (endIndex >= 0 && endIndex <= arrayList2.size()) {
                int i8 = crossAxisSize;
                int i9 = startIndex;
                while (i9 < endIndex) {
                    ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList2.get(i9);
                    if (resolvedFlexItemInfo.getPlaceable() == null) {
                        int m1090getAlignSelf_ov7Qcc$foundation_layout = resolvedFlexItemInfo.m1090getAlignSelf_ov7Qcc$foundation_layout();
                        FlexAlignSelf.Companion companion = FlexAlignSelf.Companion;
                        if (!FlexAlignSelf.m813equalsimpl0(m1090getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m811constructorimpl(4))) {
                            int m1090getAlignSelf_ov7Qcc$foundation_layout2 = resolvedFlexItemInfo.m1090getAlignSelf_ov7Qcc$foundation_layout();
                            FlexAlignSelf.Companion companion2 = FlexAlignSelf.Companion;
                            if (FlexAlignSelf.m813equalsimpl0(m1090getAlignSelf_ov7Qcc$foundation_layout2, FlexAlignSelf.m811constructorimpl(i4))) {
                                int m1076getAlignItems20X20zU$foundation_layout = resolvedFlexBoxConfig.m1076getAlignItems20X20zU$foundation_layout();
                                FlexAlignItems.Companion companion3 = FlexAlignItems.Companion;
                                if (!FlexAlignItems.m801equalsimpl0(m1076getAlignItems20X20zU$foundation_layout, FlexAlignItems.m799constructorimpl(3))) {
                                    int m1075getAlignContentd9B3MrI$foundation_layout = resolvedFlexBoxConfig.m1075getAlignContentd9B3MrI$foundation_layout();
                                    FlexAlignContent.Companion companion4 = FlexAlignContent.Companion;
                                }
                            }
                            z2 = i4;
                            if (z2) {
                                i2 = i4;
                                flexBoxMeasurePolicy = this;
                                i3 = 1;
                            } else {
                                i2 = flexLine.getCrossAxisSize();
                                i3 = 1;
                                flexBoxMeasurePolicy = this;
                            }
                            int measureItem = flexBoxMeasurePolicy.measureItem(resolvedFlexItemInfo, resolvedFlexBoxConfig, i2, z2, i6);
                            if (!z) {
                                i8 = Math.max(i8, measureItem);
                            }
                            if (arrayList.size() != i3) {
                                i8 = Math.max(i8, Constraints.m8114getMinHeightimpl(j));
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                        int measureItem2 = flexBoxMeasurePolicy.measureItem(resolvedFlexItemInfo, resolvedFlexBoxConfig, i2, z2, i6);
                        if (!z) {
                        }
                        if (arrayList.size() != i3) {
                        }
                    } else if (!z) {
                        i8 = Math.max(i8, resolvedFlexItemInfo.getCrossAxisSize());
                    }
                    i9++;
                    i4 = 0;
                }
                if (!z) {
                    flexLine.setCrossAxisSize(i8);
                    i5 += i8;
                }
                i6 = (i6 - flexLine.getCrossAxisSize()) - resolvedFlexBoxConfig.crossAxisGap();
                if (i6 < 0) {
                    i6 = 0;
                }
                i7++;
                i4 = 0;
            } else {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return z ? i : i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (androidx.compose.foundation.layout.FlexAlignSelf.m813equalsimpl0(r9, androidx.compose.foundation.layout.FlexAlignSelf.m811constructorimpl(0)) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calculateLineCrossAxisSize(ArrayList<ResolvedFlexItemInfo> arrayList, ResolvedFlexBoxConfig resolvedFlexBoxConfig, FlexLine flexLine, int i) {
        boolean z;
        int startIndex;
        int i2;
        int maxIntrinsicWidth;
        int m1078getDirectionT4wFHC8$foundation_layout = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                z = false;
                startIndex = flexLine.getStartIndex();
                int endIndex = flexLine.getEndIndex();
                if (startIndex >= 0 || startIndex > arrayList.size()) {
                    throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
                }
                if (endIndex >= 0 && endIndex <= arrayList.size()) {
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (startIndex < endIndex) {
                        ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList.get(startIndex);
                        if (!resolvedFlexItemInfo.getHasBaseline()) {
                            int m1076getAlignItems20X20zU$foundation_layout = resolvedFlexBoxConfig.m1076getAlignItems20X20zU$foundation_layout();
                            FlexAlignItems.Companion companion3 = FlexAlignItems.Companion;
                            if (FlexAlignItems.m801equalsimpl0(m1076getAlignItems20X20zU$foundation_layout, FlexAlignItems.m799constructorimpl(4))) {
                                int m1090getAlignSelf_ov7Qcc$foundation_layout = resolvedFlexItemInfo.m1090getAlignSelf_ov7Qcc$foundation_layout();
                                FlexAlignSelf.Companion companion4 = FlexAlignSelf.Companion;
                            }
                            if (z) {
                                Measurable measurable = resolvedFlexItemInfo.getMeasurable();
                                if (measurable != null) {
                                    maxIntrinsicWidth = measurable.maxIntrinsicHeight(resolvedFlexItemInfo.getTargetMainSize());
                                    resolvedFlexItemInfo.setCrossAxisSize(maxIntrinsicWidth);
                                    i2 = resolvedFlexItemInfo.getCrossAxisSize();
                                    i4 = Math.max(i4, i2);
                                    startIndex++;
                                }
                                maxIntrinsicWidth = 0;
                                resolvedFlexItemInfo.setCrossAxisSize(maxIntrinsicWidth);
                                i2 = resolvedFlexItemInfo.getCrossAxisSize();
                                i4 = Math.max(i4, i2);
                                startIndex++;
                            } else {
                                Measurable measurable2 = resolvedFlexItemInfo.getMeasurable();
                                if (measurable2 != null) {
                                    maxIntrinsicWidth = measurable2.maxIntrinsicWidth(resolvedFlexItemInfo.getTargetMainSize());
                                    resolvedFlexItemInfo.setCrossAxisSize(maxIntrinsicWidth);
                                    i2 = resolvedFlexItemInfo.getCrossAxisSize();
                                    i4 = Math.max(i4, i2);
                                    startIndex++;
                                }
                                maxIntrinsicWidth = 0;
                                resolvedFlexItemInfo.setCrossAxisSize(maxIntrinsicWidth);
                                i2 = resolvedFlexItemInfo.getCrossAxisSize();
                                i4 = Math.max(i4, i2);
                                startIndex++;
                            }
                        }
                        measureItem(resolvedFlexItemInfo, resolvedFlexBoxConfig, 0, false, i);
                        Placeable placeable = resolvedFlexItemInfo.getPlaceable();
                        Intrinsics.checkNotNull(placeable);
                        int baseline = resolvedFlexItemInfo.getBaseline(placeable, resolvedFlexBoxConfig);
                        resolvedFlexItemInfo.setBaseline(baseline);
                        i3 = Math.max(i3, baseline);
                        i5 = Math.max(i5, resolvedFlexItemInfo.getCrossAxisSize() - baseline);
                        i2 = i3 + i5;
                        i4 = Math.max(i4, i2);
                        startIndex++;
                    }
                    flexLine.setMaxAboveBaseline(i3);
                    flexLine.setCrossAxisSize(i4);
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
            }
        }
        z = true;
        startIndex = flexLine.getStartIndex();
        int endIndex2 = flexLine.getEndIndex();
        if (startIndex >= 0) {
        }
        throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int measureItem(ResolvedFlexItemInfo resolvedFlexItemInfo, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, boolean z, int i2) {
        boolean z2;
        long m8121fitPrioritizingHeightZbe2FdA;
        int width;
        int i3;
        int m1078getDirectionT4wFHC8$foundation_layout = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
        FlexDirection.Companion companion = FlexDirection.Companion;
        int i4 = 0;
        if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout, FlexDirection.m860constructorimpl(0))) {
            int m1078getDirectionT4wFHC8$foundation_layout2 = resolvedFlexBoxConfig.m1078getDirectionT4wFHC8$foundation_layout();
            FlexDirection.Companion companion2 = FlexDirection.Companion;
            if (!FlexDirection.m862equalsimpl0(m1078getDirectionT4wFHC8$foundation_layout2, FlexDirection.m860constructorimpl(2))) {
                z2 = false;
                if (!z && i > 0) {
                    Constraints.Companion companion3 = Constraints.Companion;
                    if (z2) {
                        i3 = resolvedFlexItemInfo.getTargetMainSize();
                    } else {
                        i3 = i > i2 ? i2 : i;
                    }
                    if (!z2) {
                        i = resolvedFlexItemInfo.getTargetMainSize();
                    } else if (i > i2) {
                        i = i2;
                    }
                    m8121fitPrioritizingHeightZbe2FdA = companion3.m8123fixedJhjzzOo(i3, i);
                } else if (!z2) {
                    m8121fitPrioritizingHeightZbe2FdA = Constraints.Companion.m8122fitPrioritizingWidthZbe2FdA(resolvedFlexItemInfo.getTargetMainSize(), resolvedFlexItemInfo.getTargetMainSize(), 0, i2);
                } else {
                    m8121fitPrioritizingHeightZbe2FdA = Constraints.Companion.m8121fitPrioritizingHeightZbe2FdA(0, i2, resolvedFlexItemInfo.getTargetMainSize(), resolvedFlexItemInfo.getTargetMainSize());
                }
                Measurable measurable = resolvedFlexItemInfo.getMeasurable();
                resolvedFlexItemInfo.setPlaceable(measurable == null ? measurable.mo6818measureBRTryo0(m8121fitPrioritizingHeightZbe2FdA) : null);
                if (!z2) {
                    Placeable placeable = resolvedFlexItemInfo.getPlaceable();
                    if (placeable != null) {
                        width = placeable.getHeight();
                    }
                    width = 0;
                } else {
                    Placeable placeable2 = resolvedFlexItemInfo.getPlaceable();
                    if (placeable2 != null) {
                        width = placeable2.getWidth();
                    }
                    width = 0;
                }
                resolvedFlexItemInfo.setCrossAxisSize(width);
                if (!z2) {
                    Placeable placeable3 = resolvedFlexItemInfo.getPlaceable();
                    if (placeable3 != null) {
                        i4 = placeable3.getWidth();
                    }
                } else {
                    Placeable placeable4 = resolvedFlexItemInfo.getPlaceable();
                    if (placeable4 != null) {
                        i4 = placeable4.getHeight();
                    }
                }
                resolvedFlexItemInfo.setMainAxisSize(i4);
                return resolvedFlexItemInfo.getCrossAxisSize();
            }
        }
        z2 = true;
        if (!z) {
        }
        if (!z2) {
        }
        Measurable measurable2 = resolvedFlexItemInfo.getMeasurable();
        resolvedFlexItemInfo.setPlaceable(measurable2 == null ? measurable2.mo6818measureBRTryo0(m8121fitPrioritizingHeightZbe2FdA) : null);
        if (!z2) {
        }
        resolvedFlexItemInfo.setCrossAxisSize(width);
        if (!z2) {
        }
        resolvedFlexItemInfo.setMainAxisSize(i4);
        return resolvedFlexItemInfo.getCrossAxisSize();
    }
}
