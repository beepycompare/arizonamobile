package com.miami.game.core.ui.utils.extensions;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposeExtensions.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ComposeExtensionsKt$shimmerEffect$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final ComposeExtensionsKt$shimmerEffect$1 INSTANCE = new ComposeExtensionsKt$shimmerEffect$1();

    ComposeExtensionsKt$shimmerEffect$1() {
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    private static final long invoke$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m6859unboximpl();
    }

    private static final void invoke$lambda$2(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.m6847boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$2(mutableState, it.mo5446getSizeYbymL2g());
        return Unit.INSTANCE;
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(311100490);
        ComposerKt.sourceInformation(composer, "C124@4602L53,127@4677L38,128@4751L219,147@5352L38:ComposeExtensions.kt#iw6472");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(311100490, i, -1, "com.miami.game.core.ui.utils.extensions.shimmerEffect.<anonymous> (ComposeExtensions.kt:124)");
        }
        composer.startReplaceGroup(1849434622);
        ComposerKt.sourceInformation(composer, "CC(remember):ComposeExtensions.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6847boximpl(IntSize.Companion.m6860getZeroYbymL2g()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        State<Float> animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("", composer, 6, 0), (-2) * ((int) (invoke$lambda$1(mutableState) >> 32)), 2 * ((int) (invoke$lambda$1(mutableState) >> 32)), AnimationSpecKt.m147infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, null, 6, null), null, 0L, 6, null), "", composer, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 24576, 0);
        Modifier background$default = BackgroundKt.background$default(composed, Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(ColorKt.Color(4279446612L)), Color.m4068boximpl(ColorKt.Color(4280499561L)), Color.m4068boximpl(ColorKt.Color(4279446612L))}), Offset.m3829constructorimpl((Float.floatToRawIntBits(invoke$lambda$3(animateFloat)) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), Offset.m3829constructorimpl((Float.floatToRawIntBits((int) (invoke$lambda$1(mutableState) & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits(invoke$lambda$3(animateFloat) + ((int) (invoke$lambda$1(mutableState) >> 32))) << 32)), 0, 8, (Object) null), null, 0.0f, 6, null);
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ComposeExtensions.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$shimmerEffect$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = ComposeExtensionsKt$shimmerEffect$1.invoke$lambda$5$lambda$4(MutableState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(background$default, (Function1) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return onGloballyPositioned;
    }

    private static final float invoke$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
