package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
/* compiled from: TabRow.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class TabRowKt$TabRowWithSubcomposeImpl$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TabRowKt$TabRowWithSubcomposeImpl$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3) {
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C768@33836L2160,768@33794L2202:TabRow.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1815327065, i, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:768)");
        }
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, -772583465, "CC(remember):TabRow.kt#9igjgp");
        boolean changed = composer.changed(this.$tabs) | composer.changed(this.$divider) | composer.changed(this.$indicator);
        final Function2<Composer, Integer, Unit> function2 = this.$tabs;
        final Function2<Composer, Integer, Unit> function22 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function2() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt$TabRowWithSubcomposeImpl$1.invoke$lambda$8$lambda$7(Function2.this, function22, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MeasureResult invoke$lambda$8$lambda$7(Function2 function2, final Function2 function22, final Function3 function3, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        final int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(constraints.m7514unboximpl());
        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        int size = subcompose.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (size > 0) {
            intRef.element = m7508getMaxWidthimpl / size;
        }
        int i = 0;
        List<Measurable> list = subcompose;
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            i = Integer.valueOf(Math.max(subcompose.get(i2).maxIntrinsicHeight(intRef.element), i.intValue()));
        }
        final int intValue = i.intValue();
        ArrayList arrayList = new ArrayList(subcompose.size());
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            arrayList.add(subcompose.get(i3).mo6216measureBRTryo0(Constraints.m7497copyZbe2FdA(constraints.m7514unboximpl(), intRef.element, intRef.element, intValue, intValue)));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(new TabPosition(Dp.m7555constructorimpl(subcomposeMeasureScope.mo402toDpu2uoSUM(intRef.element) * i4), subcomposeMeasureScope.mo402toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m7553boximpl(Dp.m7555constructorimpl(subcomposeMeasureScope.mo402toDpu2uoSUM(Math.min(subcompose.get(i4).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m7555constructorimpl(TabKt.getHorizontalTextPadding() * 2.0f))), Dp.m7553boximpl(Dp.m7555constructorimpl(24.0f)))).m7569unboximpl(), null));
        }
        final ArrayList arrayList4 = arrayList3;
        return MeasureScope.layout$default(subcomposeMeasureScope, m7508getMaxWidthimpl, intValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt$TabRowWithSubcomposeImpl$1.invoke$lambda$8$lambda$7$lambda$6(arrayList2, subcomposeMeasureScope, function22, intRef, constraints, intValue, function3, arrayList4, m7508getMaxWidthimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$8$lambda$7$lambda$6(List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, Ref.IntRef intRef, Constraints constraints, int i, final Function3 function3, final List list2, int i2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i3), i3 * intRef.element, 0, 0.0f, 4, null);
        }
        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = subcompose.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable mo6216measureBRTryo0 = subcompose.get(i4).mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(constraints.m7514unboximpl(), 0, 0, 0, 0, 11, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, mo6216measureBRTryo0, 0, i - mo6216measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(1918742627, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1$1$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                ComposerKt.sourceInformation(composer, "C814@35789L23:TabRow.kt#uh7d8r");
                if (!composer.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1918742627, i5, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:814)");
                }
                function3.invoke(list2, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        int size3 = subcompose2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose2.get(i5).mo6216measureBRTryo0(Constraints.Companion.m7518fixedJhjzzOo(i2, i)), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
