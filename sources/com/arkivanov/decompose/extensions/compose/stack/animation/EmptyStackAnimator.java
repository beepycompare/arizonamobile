package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: EmptyStackAnimator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\u0097\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/EmptyStackAnimator;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "<init>", "()V", "invoke", "", "direction", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "isInitial", "", "onFinished", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmptyStackAnimator implements StackAnimator {
    public static final int $stable = 0;
    public static final EmptyStackAnimator INSTANCE = new EmptyStackAnimator();

    private EmptyStackAnimator() {
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
    public void invoke(Direction direction, boolean z, final Function0<Unit> onFinished, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(-811412004);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-811412004, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.EmptyStackAnimator.invoke (EmptyStackAnimator.kt:14)");
        }
        content.invoke(Modifier.Companion, composer, Integer.valueOf(((i >> 6) & 112) | 6));
        Boolean valueOf = Boolean.valueOf(z);
        composer.startReplaceGroup(1449340344);
        boolean z2 = (((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(onFinished)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.EmptyStackAnimator$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DisposableEffectResult invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = EmptyStackAnimator.invoke$lambda$2$lambda$1(Function0.this, (DisposableEffectScope) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.DisposableEffect(direction, valueOf, (Function1) rememberedValue, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$2$lambda$1(Function0 function0, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        function0.invoke();
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.EmptyStackAnimator$invoke$lambda$2$lambda$1$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }
}
