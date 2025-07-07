package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import com.arkivanov.decompose.Child;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C, T] */
/* compiled from: PredictiveBackAnimation.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class PredictiveBackAnimation$invoke$childContent$1$1<C, T> implements Function3<Child.Created<? extends C, ? extends T>, Composer, Integer, Unit> {
    final /* synthetic */ HashSet<Object> $activeKeys;
    final /* synthetic */ Function3<Child.Created<? extends C, ? extends T>, Composer, Integer, Unit> $content;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PredictiveBackAnimation$invoke$childContent$1$1(Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> function3, HashSet<Object> hashSet) {
        this.$content = function3;
        this.$activeKeys = hashSet;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer, Integer num) {
        invoke((Child.Created) obj, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final Child.Created<? extends C, ? extends T> child, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1090273764, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation.invoke.<anonymous>.<anonymous> (PredictiveBackAnimation.kt:77)");
        }
        composer.startMovableGroup(-214786668, child.getKey());
        this.$content.invoke(child, composer, Integer.valueOf(i & 14));
        Unit unit = Unit.INSTANCE;
        composer.startReplaceGroup(-214783466);
        boolean changedInstance = composer.changedInstance(this.$activeKeys) | composer.changedInstance(child);
        final HashSet<Object> hashSet = this.$activeKeys;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$invoke$childContent$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DisposableEffectResult invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = PredictiveBackAnimation$invoke$childContent$1$1.invoke$lambda$2$lambda$1(hashSet, child, (DisposableEffectScope) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.DisposableEffect(unit, (Function1) rememberedValue, composer, 6);
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$2$lambda$1(final HashSet hashSet, final Child.Created created, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        hashSet.add(created.getKey());
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$invoke$childContent$1$1$invoke$lambda$2$lambda$1$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                hashSet.remove(created.getKey());
            }
        };
    }
}
