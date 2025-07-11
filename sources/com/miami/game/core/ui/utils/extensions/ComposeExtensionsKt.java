package com.miami.game.core.ui.utils.extensions;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposeExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a.\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0001¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"clickWithDelay", "Landroidx/compose/ui/Modifier;", "enabled", "", "clicksDelayTimeMs", "", "indicationType", "Lcom/miami/game/core/ui/utils/extensions/ClickIndicationType;", "onClick", "Lkotlin/Function0;", "", "clickWithDelayNoRipple", "interceptClick", "shimmerEffect", "ui-utils_release_web", "size", "Landroidx/compose/ui/unit/IntSize;", "startOffsetX", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposeExtensionsKt {

    /* compiled from: ComposeExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickIndicationType.values().length];
            try {
                iArr[ClickIndicationType.NO_INDICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClickIndicationType.INFINITE_ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClickIndicationType.THEMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Modifier clickWithDelay$default(Modifier modifier, boolean z, long j, ClickIndicationType clickIndicationType, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            j = 400;
        }
        if ((i & 4) != 0) {
            clickIndicationType = ClickIndicationType.THEMED;
        }
        return clickWithDelay(modifier, z, j, clickIndicationType, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r22v0, types: [androidx.compose.runtime.Composer] */
    public static final Modifier clickWithDelay$lambda$6(long j, ClickIndicationType clickIndicationType, boolean z, final Function0 function0, Modifier composed, Composer composer, int i) {
        IndicationNodeFactory indicationNodeFactory;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(1586224657);
        ComposerKt.sourceInformation(composer, "C57@2458L105,71@3023L39,69@2900L52:ComposeExtensions.kt#iw6472");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1586224657, i, -1, "com.miami.game.core.ui.utils.extensions.clickWithDelay.<anonymous> (ComposeExtensions.kt:57)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -351493414, "CC(remember):ComposeExtensions.kt#9igjgp");
        boolean changed = composer.changed(j);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new MultipleClicksCutter(j);
            composer.updateRememberedValue(rememberedValue);
        }
        final MultipleClicksCutter multipleClicksCutter = (MultipleClicksCutter) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = WhenMappings.$EnumSwitchMapping$0[clickIndicationType.ordinal()];
        if (i2 == 1) {
            composer.startReplaceGroup(1988806284);
            composer.endReplaceGroup();
            indicationNodeFactory = null;
        } else if (i2 == 2) {
            composer.startReplaceGroup(-351485176);
            composer.endReplaceGroup();
            indicationNodeFactory = RippleKt.m2208rippleH2RKhps$default(false, 0.0f, 0L, 6, null);
        } else if (i2 != 3) {
            composer.startReplaceGroup(-351489068);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(-351482568);
            ComposerKt.sourceInformation(composer, "64@2800L7");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(IndicationKt.getLocalIndication());
            ComposerKt.sourceInformationMarkerEnd(composer);
            indicationNodeFactory = (Indication) consume;
            composer.endReplaceGroup();
        }
        Indication indication = indicationNodeFactory;
        Modifier.Companion companion = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, -351475400, "CC(remember):ComposeExtensions.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier.Companion companion2 = companion;
        ComposerKt.sourceInformationMarkerStart(composer, -351479323, "CC(remember):ComposeExtensions.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(multipleClicksCutter) | composer.changed(function0);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit clickWithDelay$lambda$6$lambda$5$lambda$4;
                    clickWithDelay$lambda$6$lambda$5$lambda$4 = ComposeExtensionsKt.clickWithDelay$lambda$6$lambda$5$lambda$4(MultipleClicksCutter.this, function0);
                    return clickWithDelay$lambda$6$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier m279clickableO2vRcR0$default = ClickableKt.m279clickableO2vRcR0$default(companion2, mutableInteractionSource, indication, z, null, null, rememberedValue3, 24, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m279clickableO2vRcR0$default;
    }

    public static final Unit clickWithDelay$lambda$6$lambda$5$lambda$4(MultipleClicksCutter multipleClicksCutter, final Function0 function0) {
        multipleClicksCutter.onClickCutter(new Function0() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit clickWithDelay$lambda$6$lambda$5$lambda$4$lambda$3;
                clickWithDelay$lambda$6$lambda$5$lambda$4$lambda$3 = ComposeExtensionsKt.clickWithDelay$lambda$6$lambda$5$lambda$4$lambda$3(Function0.this);
                return clickWithDelay$lambda$6$lambda$5$lambda$4$lambda$3;
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit clickWithDelay$lambda$6$lambda$5$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier clickWithDelayNoRipple$default(Modifier modifier, boolean z, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            j = 400;
        }
        return clickWithDelayNoRipple(modifier, z, j, function0);
    }

    public static final Modifier clickWithDelayNoRipple(Modifier modifier, boolean z, long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return clickWithDelay(modifier, z, j, ClickIndicationType.NO_INDICATION, function0);
    }

    public static final Modifier interceptClick(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return clickWithDelayNoRipple$default(modifier, false, 0L, new Function0() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 3, null);
    }

    public static final Modifier shimmerEffect(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier shimmerEffect$lambda$14;
                shimmerEffect$lambda$14 = ComposeExtensionsKt.shimmerEffect$lambda$14((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return shimmerEffect$lambda$14;
            }
        }, 1, null);
    }

    public static final Modifier shimmerEffect$lambda$14(Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(311100490);
        ComposerKt.sourceInformation(composer, "C124@4602L53,127@4677L38,128@4751L219,147@5352L38:ComposeExtensions.kt#iw6472");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(311100490, i, -1, "com.miami.game.core.ui.utils.extensions.shimmerEffect.<anonymous> (ComposeExtensions.kt:124)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1680139201, "CC(remember):ComposeExtensions.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6847boximpl(IntSize.Companion.m6860getZeroYbymL2g()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Float> animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("", composer, 6, 0), (-2) * ((int) (shimmerEffect$lambda$14$lambda$9(mutableState) >> 32)), 2 * ((int) (shimmerEffect$lambda$14$lambda$9(mutableState) >> 32)), AnimationSpecKt.m147infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, null, 6, null), null, 0L, 6, null), "", composer, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 24576, 0);
        Modifier background$default = BackgroundKt.background$default(composed, Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(ColorKt.Color(4279446612L)), Color.m4068boximpl(ColorKt.Color(4280499561L)), Color.m4068boximpl(ColorKt.Color(4279446612L))}), Offset.m3829constructorimpl((Float.floatToRawIntBits(shimmerEffect$lambda$14$lambda$11(animateFloat)) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), Offset.m3829constructorimpl((Float.floatToRawIntBits((int) (shimmerEffect$lambda$14$lambda$9(mutableState) & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits(shimmerEffect$lambda$14$lambda$11(animateFloat) + ((int) (shimmerEffect$lambda$14$lambda$9(mutableState) >> 32))) << 32)), 0, 8, (Object) null), null, 0.0f, 6, null);
        ComposerKt.sourceInformationMarkerStart(composer, -1680115216, "CC(remember):ComposeExtensions.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit shimmerEffect$lambda$14$lambda$13$lambda$12;
                    shimmerEffect$lambda$14$lambda$13$lambda$12 = ComposeExtensionsKt.shimmerEffect$lambda$14$lambda$13$lambda$12(MutableState.this, (LayoutCoordinates) obj);
                    return shimmerEffect$lambda$14$lambda$13$lambda$12;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(background$default, (Function1) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return onGloballyPositioned;
    }

    private static final void shimmerEffect$lambda$14$lambda$10(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.m6847boximpl(j));
    }

    private static final long shimmerEffect$lambda$14$lambda$9(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m6859unboximpl();
    }

    public static final Unit shimmerEffect$lambda$14$lambda$13$lambda$12(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        shimmerEffect$lambda$14$lambda$10(mutableState, it.mo5446getSizeYbymL2g());
        return Unit.INSTANCE;
    }

    public static final Modifier clickWithDelay(Modifier modifier, boolean z, final long j, final ClickIndicationType indicationType, final Function0<Unit> function0) {
        final boolean z2;
        final long j2;
        final ClickIndicationType clickIndicationType;
        final Function0<Unit> function02;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(indicationType, "indicationType");
        if (function0 == null) {
            return modifier;
        }
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            z2 = z;
            function02 = function0;
            j2 = j;
            clickIndicationType = indicationType;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$clickWithDelay$$inlined$debugInspectorInfo$1
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
                    inspectorInfo.setName("clickable");
                    inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
                    inspectorInfo.getProperties().set("onClick", function0);
                    inspectorInfo.getProperties().set("clicksDelayTimeMs", Long.valueOf(j));
                    inspectorInfo.getProperties().set("indicationType", indicationType);
                }
            };
        } else {
            z2 = z;
            j2 = j;
            clickIndicationType = indicationType;
            function02 = function0;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final boolean z3 = z2;
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new Function3() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier clickWithDelay$lambda$6;
                clickWithDelay$lambda$6 = ComposeExtensionsKt.clickWithDelay$lambda$6(j2, clickIndicationType, z3, function02, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return clickWithDelay$lambda$6;
            }
        });
    }

    private static final float shimmerEffect$lambda$14$lambda$11(State<Float> state) {
        return state.getValue().floatValue();
    }
}
