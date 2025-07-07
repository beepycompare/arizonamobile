package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultStackAnimator.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Bz\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012a\u0010\u0005\u001a]\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0097\u0002¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Rk\u0010\u0005\u001a]\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/DefaultStackAnimator;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", TypedValues.AttributesType.S_FRAME, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "factor", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "direction", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.CONTENT, "<init>", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function5;)V", "Lkotlin/jvm/functions/Function5;", "invoke", "isInitial", "", "onFinished", "Lkotlin/Function0;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultStackAnimator implements StackAnimator {
    public static final int $stable = 8;
    private final FiniteAnimationSpec<Float> animationSpec;
    private final Function5<Float, Direction, Function3<? super Modifier, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> frame;

    /* compiled from: DefaultStackAnimator.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.ENTER_FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.EXIT_FRONT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.ENTER_BACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.EXIT_BACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultStackAnimator(FiniteAnimationSpec<Float> animationSpec, Function5<? super Float, ? super Direction, ? super Function3<? super Modifier, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> frame) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.animationSpec = animationSpec;
        this.frame = frame;
    }

    public /* synthetic */ DefaultStackAnimator(TweenSpec tweenSpec, Function5 function5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : tweenSpec, function5);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
    public void invoke(Direction direction, boolean z, Function0<Unit> onFinished, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
        float floatValue;
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(1272740764);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1272740764, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.DefaultStackAnimator.invoke (DefaultStackAnimator.kt:23)");
        }
        composer.startReplaceGroup(248821482);
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(direction)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimationStateKt.AnimationState$default(z ? 0.0f : 1.0f, 0.0f, 0L, 0L, false, 30, null);
            composer.updateRememberedValue(rememberedValue);
        }
        AnimationState animationState = (AnimationState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(248825851);
        boolean changed = composer.changed(animationState) | composer.changedInstance(this) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(onFinished)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = (Function2) new DefaultStackAnimator$invoke$1$1(animationState, this, onFinished, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(animationState, (Function2) rememberedValue2, composer, 0);
        int i2 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i2 == 1) {
            floatValue = ((Number) animationState.getValue()).floatValue();
        } else if (i2 == 2) {
            floatValue = 1.0f - ((Number) animationState.getValue()).floatValue();
        } else if (i2 == 3) {
            floatValue = -((Number) animationState.getValue()).floatValue();
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            floatValue = ((Number) animationState.getValue()).floatValue() - 1.0f;
        }
        this.frame.invoke(Float.valueOf(floatValue), direction, content, composer, Integer.valueOf(((i >> 3) & 896) | ((i << 3) & 112)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
