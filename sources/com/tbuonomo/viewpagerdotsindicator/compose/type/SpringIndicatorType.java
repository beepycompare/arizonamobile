package com.tbuonomo.viewpagerdotsindicator.compose.type;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.tbuonomo.viewpagerdotsindicator.compose.DotKt;
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpringIndicatorType.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005JN\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d²\u0006\n\u0010\u0016\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/compose/type/SpringIndicatorType;", "Lcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;", "dotsGraphic", "Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;", "selectorDotGraphic", "(Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;)V", "IndicatorTypeComposable", "", "globalOffsetProvider", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "dotCount", "", "dotSpacing", "Landroidx/compose/ui/unit/Dp;", "onDotClicked", "Lkotlin/Function1;", "IndicatorTypeComposable--jt2gSs", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;IFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "computeSelectorDotPositionDp", "firstDotPositionX", "lastDotPositionX", "globalOffset", "density", "centeredOffset", "computeSelectorDotPositionDp-tI-LSbM", "(FFIFFF)F", "viewpagerdotsindicator_release", "foregroundDotPositionDp"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpringIndicatorType extends IndicatorType {
    public static final int $stable = 0;
    private final DotGraphic dotsGraphic;
    private final DotGraphic selectorDotGraphic;

    public SpringIndicatorType() {
        this(null, null, 3, null);
    }

    public /* synthetic */ SpringIndicatorType(DotGraphic dotGraphic, DotGraphic dotGraphic2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DotGraphic(0.0f, 0L, null, null, 0L, 31, null) : dotGraphic, (i & 2) != 0 ? new DotGraphic(0.0f, Color.Companion.m4104getBlack0d7_KjU(), null, null, 0L, 29, null) : dotGraphic2);
    }

    public SpringIndicatorType(DotGraphic dotsGraphic, DotGraphic selectorDotGraphic) {
        Intrinsics.checkNotNullParameter(dotsGraphic, "dotsGraphic");
        Intrinsics.checkNotNullParameter(selectorDotGraphic, "selectorDotGraphic");
        this.dotsGraphic = dotsGraphic;
        this.selectorDotGraphic = selectorDotGraphic;
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.compose.type.IndicatorType
    /* renamed from: IndicatorTypeComposable--jt2gSs */
    public void mo8452IndicatorTypeComposablejt2gSs(final Function0<Float> globalOffsetProvider, final Modifier modifier, final int i, final float f, final Function1<? super Integer, Unit> function1, Composer composer, final int i2) {
        int i3;
        final MutableState mutableState;
        final MutableState mutableState2;
        int i4;
        int i5;
        Function1 function12;
        Composer composer2;
        final SpringIndicatorType springIndicatorType = this;
        Intrinsics.checkNotNullParameter(globalOffsetProvider, "globalOffsetProvider");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(1001950278);
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(globalOffsetProvider) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 57344) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i2 & 458752) == 0) {
            i3 |= startRestartGroup.changed(springIndicatorType) ? 131072 : 65536;
        }
        if ((374491 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001950278, i3, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType.IndicatorTypeComposable (SpringIndicatorType.kt:28)");
            }
            DotGraphic dotGraphic = springIndicatorType.dotsGraphic;
            startRestartGroup.startReplaceGroup(2028453812);
            int i6 = i3 & 896;
            boolean changed = (i6 == 256) | startRestartGroup.changed(dotGraphic);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(-1.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState3 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            DotGraphic dotGraphic2 = springIndicatorType.dotsGraphic;
            startRestartGroup.startReplaceGroup(2028456852);
            boolean changed2 = (i6 == 256) | startRestartGroup.changed(dotGraphic2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(-1.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState4 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i7 = i3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            Arrangement.Horizontal m620spacedByD5KLDUw = Arrangement.INSTANCE.m620spacedByD5KLDUw(f, Alignment.Companion.getCenterHorizontally());
            PaddingValues m735PaddingValuesa9UjIt4$default = PaddingKt.m735PaddingValuesa9UjIt4$default(f, 0.0f, f, 0.0f, 10, null);
            startRestartGroup.startReplaceGroup(-1014803039);
            boolean changed3 = startRestartGroup.changed(mutableState3) | (i6 == 256) | startRestartGroup.changed(mutableState4) | ((i7 & 458752) == 131072) | ((i7 & 57344) == 16384);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                mutableState = mutableState3;
                mutableState2 = mutableState4;
                i4 = i7;
                i5 = 4;
                springIndicatorType = this;
                function12 = new Function1<LazyListScope, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                        invoke2(lazyListScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(LazyListScope LazyRow) {
                        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                        int i8 = i;
                        final MutableState<Float> mutableState5 = mutableState;
                        final int i9 = i;
                        final MutableState<Float> mutableState6 = mutableState2;
                        final SpringIndicatorType springIndicatorType2 = this;
                        final Function1<Integer, Unit> function13 = function1;
                        LazyListScope.items$default(LazyRow, i8, null, null, ComposableLambdaKt.composableLambdaInstance(38602305, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope items, final int i10, Composer composer3, int i11) {
                                Modifier.Companion companion;
                                DotGraphic dotGraphic3;
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if ((i11 & 112) == 0) {
                                    i11 |= composer3.changed(i10) ? 32 : 16;
                                }
                                if ((i11 & 721) != 144 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(38602305, i11, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType.IndicatorTypeComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SpringIndicatorType.kt:36)");
                                    }
                                    if (i10 == 0) {
                                        composer3.startReplaceGroup(934357912);
                                        Modifier.Companion companion2 = Modifier.Companion;
                                        composer3.startReplaceGroup(307237196);
                                        boolean changed4 = composer3.changed(mutableState5);
                                        final MutableState<Float> mutableState7 = mutableState5;
                                        Object rememberedValue4 = composer3.rememberedValue();
                                        if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                            rememberedValue4 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1$1$dotModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(LayoutCoordinates it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$2(mutableState7, Offset.m3837getXimpl(LayoutCoordinatesKt.positionInParent(it)));
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue4);
                                        }
                                        composer3.endReplaceGroup();
                                        companion = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue4);
                                        composer3.endReplaceGroup();
                                    } else if (i10 == i9 - 1) {
                                        composer3.startReplaceGroup(934609849);
                                        Modifier.Companion companion3 = Modifier.Companion;
                                        composer3.startReplaceGroup(307245323);
                                        boolean changed5 = composer3.changed(mutableState6);
                                        final MutableState<Float> mutableState8 = mutableState6;
                                        Object rememberedValue5 = composer3.rememberedValue();
                                        if (changed5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                            rememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1$1$dotModifier$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(LayoutCoordinates it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$5(mutableState8, Offset.m3837getXimpl(LayoutCoordinatesKt.positionInParent(it)));
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue5);
                                        }
                                        composer3.endReplaceGroup();
                                        companion = OnGloballyPositionedModifierKt.onGloballyPositioned(companion3, (Function1) rememberedValue5);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(307251009);
                                        composer3.endReplaceGroup();
                                        companion = Modifier.Companion;
                                    }
                                    Modifier modifier2 = companion;
                                    dotGraphic3 = springIndicatorType2.dotsGraphic;
                                    composer3.startReplaceGroup(307254223);
                                    boolean changed6 = ((i11 & 112) == 32) | composer3.changed(function13);
                                    final Function1<Integer, Unit> function14 = function13;
                                    Object rememberedValue6 = composer3.rememberedValue();
                                    if (changed6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                        rememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                Function1<Integer, Unit> function15 = function14;
                                                if (function15 != null) {
                                                    function15.invoke(Integer.valueOf(i10));
                                                }
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue6);
                                    }
                                    composer3.endReplaceGroup();
                                    DotKt.Dot(dotGraphic3, ClickableKt.m281clickableXHw0xAI$default(modifier2, false, null, null, (Function0) rememberedValue6, 7, null), composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), 6, null);
                    }
                };
                startRestartGroup.updateRememberedValue(function12);
            } else {
                mutableState = mutableState3;
                function12 = rememberedValue3;
                springIndicatorType = this;
                mutableState2 = mutableState4;
                i4 = i7;
                i5 = 4;
            }
            startRestartGroup.endReplaceGroup();
            LazyDslKt.LazyRow(fillMaxWidth$default, null, m735PaddingValuesa9UjIt4$default, false, m620spacedByD5KLDUw, null, null, false, function12, startRestartGroup, 6, 234);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-1014767024);
            if (IndicatorTypeComposable__jt2gSs$lambda$1(mutableState) != -1.0f && IndicatorTypeComposable__jt2gSs$lambda$4(mutableState2) != -1.0f) {
                composer2.startReplaceGroup(-1014764804);
                Object rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$centeredOffset$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Dp invoke() {
                            return Dp.m6682boximpl(m8458invokeD9Ej5fM());
                        }

                        /* renamed from: invoke-D9Ej5fM  reason: not valid java name */
                        public final float m8458invokeD9Ej5fM() {
                            DotGraphic dotGraphic3;
                            DotGraphic dotGraphic4;
                            dotGraphic3 = SpringIndicatorType.this.dotsGraphic;
                            float m8451getSizeD9Ej5fM = dotGraphic3.m8451getSizeD9Ej5fM();
                            dotGraphic4 = SpringIndicatorType.this.selectorDotGraphic;
                            return Dp.m6684constructorimpl(Dp.m6684constructorimpl(m8451getSizeD9Ej5fM - dotGraphic4.m8451getSizeD9Ej5fM()) / 2);
                        }
                    });
                    composer2.updateRememberedValue(rememberedValue4);
                }
                final State state = (State) rememberedValue4;
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final float density = ((Density) consume).getDensity();
                composer2.startReplaceGroup(-1014755968);
                boolean z = (i4 & 14) == i5;
                Object rememberedValue5 = composer2.rememberedValue();
                if (z || rememberedValue5 == Composer.Companion.getEmpty()) {
                    final MutableState mutableState5 = mutableState2;
                    final MutableState mutableState6 = mutableState;
                    rememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$foregroundDotPositionDp$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Dp invoke() {
                            return Dp.m6682boximpl(m8459invokeD9Ej5fM());
                        }

                        /* renamed from: invoke-D9Ej5fM  reason: not valid java name */
                        public final float m8459invokeD9Ej5fM() {
                            float IndicatorTypeComposable__jt2gSs$lambda$1;
                            float IndicatorTypeComposable__jt2gSs$lambda$4;
                            float IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8;
                            float m8457computeSelectorDotPositionDptILSbM;
                            SpringIndicatorType springIndicatorType2 = SpringIndicatorType.this;
                            IndicatorTypeComposable__jt2gSs$lambda$1 = SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$1(mutableState6);
                            IndicatorTypeComposable__jt2gSs$lambda$4 = SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$4(mutableState5);
                            int i8 = i;
                            float floatValue = globalOffsetProvider.invoke().floatValue();
                            float f2 = density;
                            IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8 = SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8(state);
                            m8457computeSelectorDotPositionDptILSbM = springIndicatorType2.m8457computeSelectorDotPositionDptILSbM(IndicatorTypeComposable__jt2gSs$lambda$1, IndicatorTypeComposable__jt2gSs$lambda$4, i8, floatValue, f2, IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8);
                            return m8457computeSelectorDotPositionDptILSbM;
                        }
                    });
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                DotKt.Dot(springIndicatorType.selectorDotGraphic, OffsetKt.m697offsetVpY3zN4(Modifier.Companion, IndicatorTypeComposable__jt2gSs$lambda$11$lambda$10((State) rememberedValue5), IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8(state)), composer2, 0);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    SpringIndicatorType.this.mo8452IndicatorTypeComposablejt2gSs(globalOffsetProvider, modifier, i, f, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float IndicatorTypeComposable__jt2gSs$lambda$1(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IndicatorTypeComposable__jt2gSs$lambda$2(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float IndicatorTypeComposable__jt2gSs$lambda$4(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IndicatorTypeComposable__jt2gSs$lambda$5(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeSelectorDotPositionDp-tI-LSbM  reason: not valid java name */
    public final float m8457computeSelectorDotPositionDptILSbM(float f, float f2, int i, float f3, float f4, float f5) {
        return Dp.m6684constructorimpl(Dp.m6684constructorimpl((f + (((f2 - f) / (i - 1)) * f3)) / f4) + f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8(State<Dp> state) {
        return state.getValue().m6698unboximpl();
    }

    private static final float IndicatorTypeComposable__jt2gSs$lambda$11$lambda$10(State<Dp> state) {
        return state.getValue().m6698unboximpl();
    }
}
