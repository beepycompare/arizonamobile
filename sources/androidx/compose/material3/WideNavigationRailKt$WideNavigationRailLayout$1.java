package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WideNavigationRail.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WideNavigationRailKt$WideNavigationRailLayout$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
    final /* synthetic */ Arrangement.Vertical $arrangement;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ MutableIntState $currentWidth$delegate;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $header;
    final /* synthetic */ State<Dp> $itemMinHeight$delegate;
    final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
    final /* synthetic */ State<Dp> $minWidth$delegate;
    final /* synthetic */ float $minimumA11ySize;
    final /* synthetic */ State<Dp> $widthFullRange$delegate;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public WideNavigationRailKt$WideNavigationRailLayout$1(WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, State<Dp> state, float f, State<Dp> state2, State<Dp> state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State<Dp> state4, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$windowInsets = windowInsets;
        this.$header = function2;
        this.$expanded = z;
        this.$minWidth$delegate = state;
        this.$minimumA11ySize = f;
        this.$itemMinHeight$delegate = state2;
        this.$widthFullRange$delegate = state3;
        this.$actualMaxExpandedWidth$delegate = mutableIntState;
        this.$currentWidth$delegate = mutableIntState2;
        this.$arrangement = vertical;
        this.$itemVerticalSpacedBy$delegate = state4;
        this.$content = function22;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        float f;
        float f2;
        ComposerKt.sourceInformation(composer, "C265@11877L27,258@11568L8803:WideNavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1489314345, i, -1, "androidx.compose.material3.WideNavigationRailLayout.<anonymous> (WideNavigationRail.kt:258)");
        }
        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), this.$windowInsets);
        f = WideNavigationRailKt.ExpandedRailMaxWidth;
        Modifier m871widthInVpY3zN4$default = SizeKt.m871widthInVpY3zN4$default(windowInsetsPadding, 0.0f, f, 1, null);
        f2 = WideNavigationRailKt.WNRVerticalPadding;
        Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m822paddingqDBjuR0$default(m871widthInVpY3zN4$default, 0.0f, f2, 0.0f, 0.0f, 13, null));
        ComposerKt.sourceInformationMarkerStart(composer, -1006965742, "CC(remember):WideNavigationRail.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WideNavigationRailKt$WideNavigationRailLayout$1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier semantics$default = SemanticsModifierKt.semantics$default(selectableGroup, false, (Function1) rememberedValue, 1, null);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$header, this.$expanded, this.$minWidth$delegate, this.$minimumA11ySize, this.$itemMinHeight$delegate, this.$widthFullRange$delegate, this.$actualMaxExpandedWidth$delegate, this.$currentWidth$delegate, this.$arrangement, this.$itemVerticalSpacedBy$delegate);
        Function2<Composer, Integer, Unit> function2 = this.$header;
        Function2<Composer, Integer, Unit> function22 = this.$content;
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, semantics$default);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m4041constructorimpl = Updater.m4041constructorimpl(composer);
        Updater.m4049setimpl(m4041constructorimpl, anonymousClass2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1714873591, "C270@12077L9:WideNavigationRail.kt#uh7d8r");
        if (function2 != null) {
            composer.startReplaceGroup(1714892004);
            ComposerKt.sourceInformation(composer, "268@11988L54");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "header");
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, layoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 310577628, "C268@12032L8:WideNavigationRail.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1714982338);
            composer.endReplaceGroup();
        }
        function22.invoke(composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* compiled from: WideNavigationRail.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/material3/WideNavigationRailKt$WideNavigationRailLayout$1$2", "Landroidx/compose/ui/layout/MeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 implements MeasurePolicy {
        final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
        final /* synthetic */ Arrangement.Vertical $arrangement;
        final /* synthetic */ MutableIntState $currentWidth$delegate;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Function2<Composer, Integer, Unit> $header;
        final /* synthetic */ State<Dp> $itemMinHeight$delegate;
        final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
        final /* synthetic */ State<Dp> $minWidth$delegate;
        final /* synthetic */ float $minimumA11ySize;
        final /* synthetic */ State<Dp> $widthFullRange$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Composer, ? super Integer, Unit> function2, boolean z, State<Dp> state, float f, State<Dp> state2, State<Dp> state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State<Dp> state4) {
            this.$header = function2;
            this.$expanded = z;
            this.$minWidth$delegate = state;
            this.$minimumA11ySize = f;
            this.$itemMinHeight$delegate = state2;
            this.$widthFullRange$delegate = state3;
            this.$actualMaxExpandedWidth$delegate = mutableIntState;
            this.$currentWidth$delegate = mutableIntState2;
            this.$arrangement = vertical;
            this.$itemVerticalSpacedBy$delegate = state4;
        }

        /* JADX WARN: Type inference failed for: r9v8, types: [T, androidx.compose.ui.layout.Placeable] */
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public MeasureResult mo41measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
            int m7510getMinWidthimpl;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int WideNavigationRailLayout$lambda$6;
            float WideNavigationRailLayout$lambda$9;
            int WideNavigationRailLayout$lambda$3;
            int i7;
            float WideNavigationRailLayout$lambda$92;
            float WideNavigationRailLayout$lambda$11;
            float f;
            float f2;
            float WideNavigationRailLayout$lambda$8;
            List<? extends Measurable> list2 = list;
            int m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(j);
            int size = list2.size();
            int m7510getMinWidthimpl2 = Constraints.m7510getMinWidthimpl(j);
            if (Constraints.m7510getMinWidthimpl(j) == 0) {
                f2 = WideNavigationRailKt.ExpandedRailMinWidth;
                m7510getMinWidthimpl2 = RangesKt.coerceAtMost(measureScope.mo399roundToPx0680j_4(f2), Constraints.m7508getMaxWidthimpl(j));
                WideNavigationRailLayout$lambda$8 = WideNavigationRailKt.WideNavigationRailLayout$lambda$8(this.$minWidth$delegate);
                m7510getMinWidthimpl = RangesKt.coerceAtMost(measureScope.mo399roundToPx0680j_4(WideNavigationRailLayout$lambda$8), Constraints.m7508getMaxWidthimpl(j));
            } else {
                m7510getMinWidthimpl = Constraints.m7510getMinWidthimpl(j);
            }
            if (size < 1) {
                return MeasureScope.layout$default(measureScope, m7510getMinWidthimpl, m7507getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit unit;
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, 4, null);
            }
            long m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (this.$header != null) {
                int size2 = list2.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    Measurable measurable = list2.get(i8);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "header")) {
                        objectRef.element = measurable.mo6216measureBRTryo0(m7498copyZbe2FdA$default);
                        if (size > 1) {
                            list2 = list2.subList(1, size);
                        }
                        size--;
                        i = ((Placeable) objectRef.element).getHeight();
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i = 0;
            final ArrayList arrayList = size > 0 ? new ArrayList() : null;
            int m7508getMaxWidthimpl = this.$expanded ? Constraints.m7508getMaxWidthimpl(m7498copyZbe2FdA$default) : m7510getMinWidthimpl;
            if (arrayList != null) {
                float f3 = this.$minimumA11ySize;
                boolean z = this.$expanded;
                State<Dp> state = this.$itemMinHeight$delegate;
                int i9 = i;
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size3 = list2.size();
                i4 = m7507getMaxHeightimpl;
                int i10 = 0;
                i5 = 0;
                int i11 = i9;
                while (i10 < size3) {
                    Measurable measurable2 = list2.get(i10);
                    List<? extends Measurable> list3 = list2;
                    ArrayList arrayList3 = arrayList2;
                    int i12 = size3;
                    int i13 = -i11;
                    boolean z2 = z;
                    State<Dp> state2 = state;
                    long m7528offsetNN6EwU$default = ConstraintsKt.m7528offsetNN6EwU$default(m7498copyZbe2FdA$default, 0, i13, 1, null);
                    Constraints.Companion companion = Constraints.Companion;
                    int i14 = i10;
                    int i15 = measureScope.mo399roundToPx0680j_4(f3);
                    float f4 = f3;
                    WideNavigationRailLayout$lambda$11 = WideNavigationRailKt.WideNavigationRailLayout$lambda$11(state2);
                    ArrayList arrayList4 = arrayList2;
                    int i16 = m7510getMinWidthimpl2;
                    int i17 = m7510getMinWidthimpl;
                    Placeable mo6216measureBRTryo0 = measurable2.mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(m7528offsetNN6EwU$default, companion.m7517fitPrioritizingWidthZbe2FdA(i15, m7508getMaxWidthimpl, measureScope.mo399roundToPx0680j_4(WideNavigationRailLayout$lambda$11), Constraints.m7507getMaxHeightimpl(m7498copyZbe2FdA$default))));
                    int measuredWidth = mo6216measureBRTryo0.getMeasuredWidth();
                    if (z2 && i5 < measuredWidth) {
                        f = WideNavigationRailKt.ItemHorizontalPadding;
                        i5 = measuredWidth + measureScope.mo399roundToPx0680j_4(f);
                    }
                    i11 = mo6216measureBRTryo0.getHeight();
                    arrayList3.add(Boolean.valueOf(arrayList.add(mo6216measureBRTryo0)));
                    i10 = i14 + 1;
                    list2 = list3;
                    z = z2;
                    f3 = f4;
                    arrayList2 = arrayList4;
                    size3 = i12;
                    state = state2;
                    m7510getMinWidthimpl2 = i16;
                    m7510getMinWidthimpl = i17;
                }
                i2 = m7510getMinWidthimpl2;
                i3 = m7510getMinWidthimpl;
            } else {
                i2 = m7510getMinWidthimpl2;
                i3 = m7510getMinWidthimpl;
                i4 = m7507getMaxHeightimpl;
                i5 = 0;
            }
            if (!this.$expanded) {
                i6 = i3;
                WideNavigationRailLayout$lambda$6 = WideNavigationRailKt.WideNavigationRailLayout$lambda$6(this.$actualMaxExpandedWidth$delegate);
                if (WideNavigationRailLayout$lambda$6 > 0) {
                    WideNavigationRailLayout$lambda$9 = WideNavigationRailKt.WideNavigationRailLayout$lambda$9(this.$widthFullRange$delegate);
                    int i18 = measureScope.mo399roundToPx0680j_4(WideNavigationRailLayout$lambda$9);
                    WideNavigationRailLayout$lambda$3 = WideNavigationRailKt.WideNavigationRailLayout$lambda$3(this.$currentWidth$delegate);
                    i6 = RangesKt.coerceIn(i18, i6, RangesKt.coerceAtLeast(WideNavigationRailLayout$lambda$3, i6));
                }
            } else {
                Placeable placeable = (Placeable) objectRef.element;
                int max = Math.max(i5, placeable != null ? placeable.getWidth() : 0);
                i6 = i3;
                if (max > i6 && max > (i7 = i2)) {
                    int coerceAtMost = RangesKt.coerceAtMost(Math.max(max, i7), Constraints.m7508getMaxWidthimpl(j));
                    WideNavigationRailLayout$lambda$92 = WideNavigationRailKt.WideNavigationRailLayout$lambda$9(this.$widthFullRange$delegate);
                    i6 = RangesKt.coerceAtMost(measureScope.mo399roundToPx0680j_4(WideNavigationRailLayout$lambda$92), coerceAtMost);
                    this.$actualMaxExpandedWidth$delegate.setIntValue(i6);
                }
            }
            int i19 = i6;
            this.$currentWidth$delegate.setIntValue(i19);
            final Arrangement.Vertical vertical = this.$arrangement;
            final State<Dp> state3 = this.$itemVerticalSpacedBy$delegate;
            final int i20 = i4;
            return MeasureScope.layout$default(measureScope, i19, i20, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WideNavigationRailKt$WideNavigationRailLayout$1.AnonymousClass2.measure_3p2s80s$lambda$6(i20, measureScope, objectRef, arrayList, vertical, state3, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit measure_3p2s80s$lambda$6(int i, MeasureScope measureScope, Ref.ObjectRef objectRef, List list, Arrangement.Vertical vertical, State state, Placeable.PlacementScope placementScope) {
            float f;
            int i2;
            float WideNavigationRailLayout$lambda$10;
            float f2;
            f = WideNavigationRailKt.WNRVerticalPadding;
            int i3 = i - measureScope.mo399roundToPx0680j_4(f);
            if (objectRef.element == 0 || ((Placeable) objectRef.element).getHeight() <= 0) {
                i2 = 0;
            } else {
                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) objectRef.element, 0, 0, 0.0f, 4, null);
                int height = ((Placeable) objectRef.element).getHeight();
                f2 = WideNavigationRailKt.WNRHeaderPadding;
                i2 = height + measureScope.mo399roundToPx0680j_4(f2);
            }
            if (list != null) {
                if (!Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                    i3 -= i2;
                }
                int[] iArr = new int[list.size()];
                List list2 = list;
                int size = list2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    iArr[i4] = ((Placeable) list.get(i4)).getHeight();
                    if (i4 < list.size() - 1) {
                        int i5 = iArr[i4];
                        WideNavigationRailLayout$lambda$10 = WideNavigationRailKt.WideNavigationRailLayout$lambda$10(state);
                        iArr[i4] = i5 + measureScope.mo399roundToPx0680j_4(WideNavigationRailLayout$lambda$10);
                    }
                }
                int[] iArr2 = new int[list.size()];
                vertical.arrange(measureScope, i3, iArr, iArr2);
                if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                    i2 = 0;
                }
                int size2 = list2.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i6), 0, iArr2[i6] + i2, 0.0f, 4, null);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
