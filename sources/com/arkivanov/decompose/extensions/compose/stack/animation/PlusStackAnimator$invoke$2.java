package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackAnimator.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class PlusStackAnimator$invoke$2 implements Function3<Modifier, Composer, Integer, Unit> {
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $content;
    final /* synthetic */ Direction $direction;
    final /* synthetic */ boolean[] $finished;
    final /* synthetic */ boolean $isInitial;
    final /* synthetic */ Function0<Unit> $onFinished;
    final /* synthetic */ PlusStackAnimator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PlusStackAnimator$invoke$2(PlusStackAnimator plusStackAnimator, Direction direction, boolean z, boolean[] zArr, Function0<Unit> function0, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3) {
        this.this$0 = plusStackAnimator;
        this.$direction = direction;
        this.$isInitial = z;
        this.$finished = zArr;
        this.$onFinished = function0;
        this.$content = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
        invoke(modifier, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final Modifier thisModifier, Composer composer, int i) {
        StackAnimator stackAnimator;
        Intrinsics.checkNotNullParameter(thisModifier, "thisModifier");
        if ((i & 6) == 0) {
            i |= composer.changed(thisModifier) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1609539477, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.PlusStackAnimator.invoke.<anonymous> (StackAnimator.kt:85)");
            }
            stackAnimator = this.this$0.second;
            Direction direction = this.$direction;
            boolean z = this.$isInitial;
            composer.startReplaceGroup(1550620381);
            boolean changedInstance = composer.changedInstance(this.$finished) | composer.changed(this.$onFinished);
            final boolean[] zArr = this.$finished;
            final Function0<Unit> function0 = this.$onFinished;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.PlusStackAnimator$invoke$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$2$lambda$1;
                        invoke$lambda$2$lambda$1 = PlusStackAnimator$invoke$2.invoke$lambda$2$lambda$1(zArr, function0);
                        return invoke$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            final Function3<Modifier, Composer, Integer, Unit> function3 = this.$content;
            stackAnimator.invoke(direction, z, (Function0) rememberedValue, ComposableLambdaKt.rememberComposableLambda(-2013106012, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.PlusStackAnimator$invoke$2.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer2, Integer num) {
                    invoke(modifier, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier otherModifier, Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(otherModifier, "otherModifier");
                    if ((i2 & 6) == 0) {
                        i2 |= composer2.changed(otherModifier) ? 4 : 2;
                    }
                    if ((i2 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2013106012, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.PlusStackAnimator.invoke.<anonymous>.<anonymous> (StackAnimator.kt:95)");
                    }
                    function3.invoke(thisModifier.then(otherModifier), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(boolean[] zArr, Function0 function0) {
        zArr[1] = true;
        int length = zArr.length;
        int i = 0;
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
