package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackAnimation.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0099\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062e\u0010\u0007\u001aa\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\bH\u0007\u001aa\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062/\u0010\u0007\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0011\u001a:\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"stackAnimation", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;", "C", ExifInterface.GPS_DIRECTION_TRUE, "", "disableInputDuringAnimation", "", "selector", "Lkotlin/Function3;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "child", "otherChild", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "direction", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "Lkotlin/Function1;", "animator", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackAnimationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final StackAnimator stackAnimation$lambda$0(StackAnimator stackAnimator, Child.Created it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return stackAnimator;
    }

    public static /* synthetic */ StackAnimation stackAnimation$default(boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return stackAnimation(z, function3);
    }

    public static final <C, T> StackAnimation<C, T> stackAnimation(boolean z, Function3<? super Child.Created<? extends C, ? extends T>, ? super Child.Created<? extends C, ? extends T>, ? super Direction, ? extends StackAnimator> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new MovableStackAnimation(z, selector);
    }

    public static /* synthetic */ StackAnimation stackAnimation$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return stackAnimation(z, function1);
    }

    public static final <C, T> StackAnimation<C, T> stackAnimation(boolean z, Function1<? super Child.Created<? extends C, ? extends T>, ? extends StackAnimator> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new SimpleStackAnimation(z, selector);
    }

    public static /* synthetic */ StackAnimation stackAnimation$default(StackAnimator stackAnimator, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            stackAnimator = FadeKt.fade$default(null, 0.0f, 3, null);
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return stackAnimation(stackAnimator, z);
    }

    public static final <C, T> StackAnimation<C, T> stackAnimation(final StackAnimator animator, boolean z) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        return new SimpleStackAnimation(z, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                StackAnimator stackAnimation$lambda$0;
                stackAnimation$lambda$0 = StackAnimationKt.stackAnimation$lambda$0(StackAnimator.this, (Child.Created) obj);
                return stackAnimation$lambda$0;
            }
        });
    }
}
