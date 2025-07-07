package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackAnimator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005JE\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011H\u0097\u0002¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/PlusStackAnimator;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "first", "second", "<init>", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;)V", "invoke", "", "direction", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "isInitial", "", "onFinished", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class PlusStackAnimator implements StackAnimator {
    private final StackAnimator first;
    private final StackAnimator second;

    public PlusStackAnimator(StackAnimator first, StackAnimator second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        this.first = first;
        this.second = second;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
    public void invoke(Direction direction, boolean z, final Function0<Unit> onFinished, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(1980421254);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1980421254, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.PlusStackAnimator.invoke (StackAnimator.kt:72)");
        }
        composer.startReplaceGroup(633713377);
        int i2 = i & 14;
        boolean z2 = ((i2 ^ 6) > 4 && composer.changed(direction)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new boolean[2];
            composer.updateRememberedValue(rememberedValue);
        }
        final boolean[] zArr = rememberedValue;
        composer.endReplaceGroup();
        StackAnimator stackAnimator = this.first;
        composer.startReplaceGroup(633718314);
        boolean changedInstance = composer.changedInstance(zArr) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(onFinished)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.PlusStackAnimator$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = PlusStackAnimator.invoke$lambda$3$lambda$2(zArr, onFinished);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        stackAnimator.invoke(direction, z, rememberedValue2, ComposableLambdaKt.rememberComposableLambda(1609539477, true, new PlusStackAnimator$invoke$2(this, direction, z, zArr, onFinished, content), composer, 54), composer, i2 | 3072 | (i & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(boolean[] zArr, Function0 function0) {
        int i = 0;
        zArr[0] = true;
        int length = zArr.length;
        while (true) {
            if (i >= length) {
                function0.invoke();
                break;
            } else if (!zArr[i]) {
                break;
            } else {
                i++;
            }
        }
        return Unit.INSTANCE;
    }
}
