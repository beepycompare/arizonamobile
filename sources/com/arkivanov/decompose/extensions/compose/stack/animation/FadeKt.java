package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: Fade.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¨\u0006\b"}, d2 = {"fade", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "minAlpha", "getFadeAlpha", "factor", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FadeKt {
    public static /* synthetic */ StackAnimator fade$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fade(finiteAnimationSpec, f);
    }

    public static final StackAnimator fade(FiniteAnimationSpec<Float> animationSpec, final float f) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return StackAnimatorKt.stackAnimator(animationSpec, ComposableLambdaKt.composableLambdaInstance(-1065144880, true, new Function5<Float, Direction, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.FadeKt$fade$1
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Direction direction, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                invoke(f2.floatValue(), direction, (Function3<? super Modifier, ? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f2, Direction unused$var$, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                Intrinsics.checkNotNullParameter(content, "content");
                if ((i & 6) == 0) {
                    i2 = (composer.changed(f2) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i2 |= composer.changedInstance(content) ? 256 : 128;
                }
                if ((i2 & 1155) == 1154 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1065144880, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.fade.<anonymous> (Fade.kt:17)");
                }
                content.invoke(AlphaKt.alpha(Modifier.Companion, FadeKt.getFadeAlpha(f2, f)), composer, Integer.valueOf((i2 >> 3) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final float getFadeAlpha(float f, float f2) {
        return RangesKt.coerceIn(1.0f - (Math.abs(f) * (1.0f - f2)), 0.0f, 1.0f);
    }
}
