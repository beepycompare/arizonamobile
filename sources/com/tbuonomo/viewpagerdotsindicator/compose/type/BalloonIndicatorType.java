package com.tbuonomo.viewpagerdotsindicator.compose.type;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
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
import kotlin.ranges.RangesKt;
/* compiled from: BalloonIndicatorType.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JN\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/compose/type/BalloonIndicatorType;", "Lcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;", "dotsGraphic", "Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;", "balloonSizeFactor", "", "(Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;F)V", "IndicatorTypeComposable", "", "globalOffsetProvider", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "dotCount", "", "dotSpacing", "Landroidx/compose/ui/unit/Dp;", "onDotClicked", "Lkotlin/Function1;", "IndicatorTypeComposable--jt2gSs", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;IFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "computeDotWidth", "currentDotIndex", "globalOffset", "viewpagerdotsindicator_release", "dotSize", "dotModifier"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BalloonIndicatorType extends IndicatorType {
    public static final int $stable = 0;
    private final float balloonSizeFactor;
    private final DotGraphic dotsGraphic;

    public BalloonIndicatorType() {
        this(null, 0.0f, 3, null);
    }

    public /* synthetic */ BalloonIndicatorType(DotGraphic dotGraphic, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DotGraphic(Dp.m6684constructorimpl(12), 0L, null, null, 0L, 30, null) : dotGraphic, (i & 2) != 0 ? 1.5f : f);
    }

    public BalloonIndicatorType(DotGraphic dotsGraphic, float f) {
        Intrinsics.checkNotNullParameter(dotsGraphic, "dotsGraphic");
        this.dotsGraphic = dotsGraphic;
        this.balloonSizeFactor = f;
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.compose.type.IndicatorType
    /* renamed from: IndicatorTypeComposable--jt2gSs  reason: not valid java name */
    public void mo8452IndicatorTypeComposablejt2gSs(final Function0<Float> globalOffsetProvider, final Modifier modifier, final int i, final float f, final Function1<? super Integer, Unit> function1, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(globalOffsetProvider, "globalOffsetProvider");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(122582380);
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
            i3 |= startRestartGroup.changed(this) ? 131072 : 65536;
        }
        if ((374491 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(122582380, i3, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType.IndicatorTypeComposable (BalloonIndicatorType.kt:27)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
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
            Modifier m771height3ABfNKs = SizeKt.m771height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(this.dotsGraphic.m8451getSizeD9Ej5fM() * this.balloonSizeFactor));
            Arrangement.Horizontal m620spacedByD5KLDUw = Arrangement.INSTANCE.m620spacedByD5KLDUw(f, Alignment.Companion.getCenterHorizontally());
            int i4 = i3;
            PaddingValues m735PaddingValuesa9UjIt4$default = PaddingKt.m735PaddingValuesa9UjIt4$default(f, 0.0f, f, 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceGroup(2022843647);
            boolean z = ((i4 & 14) == 4) | ((i4 & 896) == 256) | ((i4 & 458752) == 131072) | ((i4 & 57344) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType$IndicatorTypeComposable$1$1$1
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
                        int i5 = i;
                        final Function0<Float> function0 = globalOffsetProvider;
                        final BalloonIndicatorType balloonIndicatorType = this;
                        final Function1<Integer, Unit> function12 = function1;
                        LazyListScope.items$default(LazyRow, i5, null, null, ComposableLambdaKt.composableLambdaInstance(2058116263, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType$IndicatorTypeComposable$1$1$1.1
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

                            public final void invoke(LazyItemScope items, final int i6, Composer composer3, int i7) {
                                DotGraphic dotGraphic;
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if ((i7 & 112) == 0) {
                                    i7 |= composer3.changed(i6) ? 32 : 16;
                                }
                                if ((i7 & 721) != 144 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2058116263, i7, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType.IndicatorTypeComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BalloonIndicatorType.kt:35)");
                                    }
                                    float floatValue = function0.invoke().floatValue();
                                    composer3.startReplaceGroup(-748471134);
                                    boolean changed = composer3.changed(floatValue);
                                    final BalloonIndicatorType balloonIndicatorType2 = balloonIndicatorType;
                                    final Function0<Float> function02 = function0;
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType$IndicatorTypeComposable$1$1$1$1$dotSize$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Float invoke() {
                                                float computeDotWidth;
                                                computeDotWidth = BalloonIndicatorType.this.computeDotWidth(i6, function02.invoke().floatValue());
                                                return Float.valueOf(computeDotWidth);
                                            }
                                        });
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    State state = (State) rememberedValue2;
                                    composer3.endReplaceGroup();
                                    float invoke$lambda$1 = invoke$lambda$1(state);
                                    composer3.startReplaceGroup(-748464518);
                                    boolean changed2 = composer3.changed(invoke$lambda$1);
                                    final Function1<Integer, Unit> function13 = function12;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ClickableKt.m281clickableXHw0xAI$default(ScaleKt.scale(Modifier.Companion, invoke$lambda$1(state)), false, null, null, new Function0<Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType$IndicatorTypeComposable$1$1$1$1$dotModifier$2$1
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
                                                Function1<Integer, Unit> function14 = function13;
                                                if (function14 != null) {
                                                    function14.invoke(Integer.valueOf(i6));
                                                }
                                            }
                                        }, 7, null), null, 2, null);
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceGroup();
                                    dotGraphic = balloonIndicatorType.dotsGraphic;
                                    DotKt.Dot(dotGraphic, invoke$lambda$3((MutableState) rememberedValue3), composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }

                            private static final Modifier invoke$lambda$3(MutableState<Modifier> mutableState) {
                                return mutableState.getValue();
                            }

                            private static final float invoke$lambda$1(State<Float> state) {
                                return state.getValue().floatValue();
                            }
                        }), 6, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyRow(m771height3ABfNKs, null, m735PaddingValuesa9UjIt4$default, false, m620spacedByD5KLDUw, centerVertically, null, false, (Function1) rememberedValue, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, ComposerKt.compositionLocalMapKey);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType$IndicatorTypeComposable$2
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

                public final void invoke(Composer composer3, int i5) {
                    BalloonIndicatorType.this.mo8452IndicatorTypeComposablejt2gSs(globalOffsetProvider, modifier, i, f, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float computeDotWidth(int i, float f) {
        return Dp.m6684constructorimpl(this.dotsGraphic.m8451getSizeD9Ej5fM() + Dp.m6684constructorimpl(Dp.m6684constructorimpl(RangesKt.coerceAtLeast(this.balloonSizeFactor - 1.0f, 0.0f) * this.dotsGraphic.m8451getSizeD9Ej5fM()) * (1.0f - RangesKt.coerceAtMost(Math.abs(i - f), 1.0f)))) / this.dotsGraphic.m8451getSizeD9Ej5fM();
    }
}
